package enums;

/**
 * @EnumName ConfigureStatusEnum
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/7/12 16:53
 */

public enum ConfigureStatusEnum {
    /**
     * 渠道信息自定义配置修改状态
     */
    KEEP(0, "保持"),
    COLSE(1, "关闭"),
    OPEN(2, "打开"),
    MODIFY(3, "修改");

    private final Integer key;
    private final String desc;

    ConfigureStatusEnum(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public Integer getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }
}
