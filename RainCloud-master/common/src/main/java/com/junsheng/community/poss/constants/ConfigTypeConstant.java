package com.junsheng.community.poss.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by snowwolf-louis on 17/11/18.
 */
public class ConfigTypeConstant {
    public static final Short PROPERTY_TYPE = 1;
    public static final Short HOUST_TYPE = 2;
    public static final Short AUTHORITY_LEVEL = 3;
    public static final Short HOUSE_NATURE = 4;

    public static final Map<Short,String> configTypeMap = new HashMap<>();

    static {
        configTypeMap.put(PROPERTY_TYPE,"房产类型");
        configTypeMap.put(HOUST_TYPE,"户型");
        configTypeMap.put(AUTHORITY_LEVEL,"机构类型");
        configTypeMap.put(HOUSE_NATURE,"房屋性质");
    }
}
