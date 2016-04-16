package dps.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chinese implements IPerson {
    private static final Logger LOGGER = LoggerFactory.getLogger(Chinese.class);

    private String name;
    private ICup cup;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public ICup getCup() {
        return cup;
    }

    public void setCup(final ICup cup) {
        this.cup = cup;
    }

    public Chinese() {
    }

    public Chinese(final String name, final ICup c) {
        this.name = name;
        this.cup = c;
    }

    @Override
    public void sayHello() {
        LOGGER.info(name + "说，你好");
    }

    @Override
    public void drink() {
        this.cup.fillWater();
    }
}
