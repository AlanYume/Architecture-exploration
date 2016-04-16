package dps.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class American implements IPerson {
    private static final Logger LOGGER = LoggerFactory.getLogger(American.class);

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

    public American() {
    }

    public American(final String name, final ICup c) {
        this.name = name;
        this.cup = c;
    }

    public void sayHello() {
        LOGGER.info(name + " say,hello.");
    }

    @Override
    public void drink() {
        this.cup.fillWater();
    }
}
