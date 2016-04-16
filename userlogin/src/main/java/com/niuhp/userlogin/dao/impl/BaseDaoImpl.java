package com.niuhp.userlogin.dao.impl;

import com.niuhp.userlogin.dao.BaseDao;
import com.niuhp.userlogin.util.GenericsUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private final Class<T> entityClass = GenericsUtils.getSuperClassGenricType(getClass());

    @Override
    public T findById(final Serializable id) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("from ").append(entityClass.getSimpleName());
        final Query query = sessionFactory.getCurrentSession().createQuery(queryBuilder.toString());
        return query.list();
    }

    @Override
    public List<T> findByProperty(final String propertyName, final Object propertyValue) {
        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("from ").append(entityClass.getSimpleName()).append(" t where t.")
                .append(propertyName)
                .append("=:propertyName");
        final Query query = sessionFactory.getCurrentSession().createQuery(queryBuilder.toString());
        query.setParameter(propertyName, propertyValue);
        return query.list();
    }

    @Override
    public List<T> findByPropertyMap(final Map<String, Object> propMap) {
        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("from ").append(entityClass.getSimpleName());
        if (propMap != null && !propMap.isEmpty()) {
            queryBuilder.append(" t where");

            final Iterator<String> iterator = propMap.keySet().iterator();
            String propertyName = iterator.next();
            queryBuilder.append(" t.").append(propertyName).append("=:").append(propertyName);

            while (iterator.hasNext()) {
                propertyName = iterator.next();
                queryBuilder.append(" and t.").append(propertyName).append("=:").append(
                        propertyName);
            }
        }

        final Query query = sessionFactory.getCurrentSession().createQuery(queryBuilder.toString());
        if (propMap != null && !propMap.isEmpty()) {
            final Iterator<String> iterator = propMap.keySet().iterator();
            while (iterator.hasNext()) {
                final String propertyName = iterator.next();
                final Object propertyValue = propMap.get(propertyName);
                query.setParameter(propertyName, propertyValue);
            }
        }

        return query.list();
    }

    @Override
    public void save(final T entity) {
        sessionFactory.getCurrentSession().save(entity);

    }

    @Override
    public void update(final T entity) {
        sessionFactory.getCurrentSession().update(entity);

    }

    @Override
    public void delete(final T entity) {
        sessionFactory.getCurrentSession().delete(entity);

    }

    @Override
    public void deleteById(final Serializable id) {
        final T entity = findById(id);
        if (entity != null) {
            delete(entity);
        }
    }

    @Override
    public int udateByPropertyMap(final Map<String, Object> conditionMap,
            final Map<String, Object> valueMap) {
        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("update ").append(entityClass.getSimpleName()).append(" t");

        final Set<String> propNames = valueMap.keySet();
        final Iterator<String> propNameIt = propNames.iterator();
        String propName = propNameIt.next();
        queryBuilder.append(" set t.").append(propName).append("=:").append(propName);

        while (propNameIt.hasNext()) {
            propName = propNameIt.next();
            queryBuilder.append(",t.").append(propName).append("=:").append(propName);
        }

        if (conditionMap != null && !conditionMap.isEmpty()) {
            queryBuilder.append(" where");

            final Iterator<String> iterator = conditionMap.keySet().iterator();
            propName = iterator.next();
            queryBuilder.append(" t.").append(propName).append("=:").append(propName);

            while (iterator.hasNext()) {
                propName = iterator.next();
                queryBuilder.append(" and t.").append(propName).append("=:").append(propName);
            }
        }

        final Query query = sessionFactory.getCurrentSession().createQuery(queryBuilder.toString());
        if (conditionMap != null && !conditionMap.isEmpty()) {
            final Iterator<String> iterator = conditionMap.keySet().iterator();
            while (iterator.hasNext()) {
                final String propertyName = iterator.next();
                final Object propertyValue = conditionMap.get(propertyName);
                query.setParameter(propertyName, propertyValue);
            }
        }
        if (valueMap != null && !valueMap.isEmpty()) {
            final Iterator<String> iterator = valueMap.keySet().iterator();
            while (iterator.hasNext()) {
                final String propertyName = iterator.next();
                final Object propertyValue = valueMap.get(propertyName);
                query.setParameter(propertyName, propertyValue);
            }
        }
        return query.executeUpdate();
    }

}
