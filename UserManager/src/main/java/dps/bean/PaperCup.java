package dps.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaperCup implements ICup {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaperCup.class);

    private String color;

    public void setColor(final String color) {
        this.color = color;
    }

    @Override
    public void fillWater() {
        LOGGER.info("使用" + this.color + "颜色的纸杯喝水。");
    }
}
