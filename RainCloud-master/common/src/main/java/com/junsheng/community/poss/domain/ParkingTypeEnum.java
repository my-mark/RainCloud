package com.junsheng.community.poss.domain;

public enum ParkingTypeEnum {

    UNDER_GROUND("地下车位", (short)0), ON_GROUND("地上车位", (short)1);
    private String name;
    private Short index;
    private ParkingTypeEnum(String name, Short index) {
        this.name = name;
        this.index = index;
    }
    public String getName() {
        return name;
    }
    public Short getIndex() {
        return index;
    }

    public static String getNameByIndex(Short index){
        if (index == UNDER_GROUND.getIndex()){
            return UNDER_GROUND.getName();
        } else if (index == ON_GROUND.getIndex()){
            return ON_GROUND.getName();
        } else{
            return null;
        }
    }
    public static Short getIndexByName(String name){
        if (UNDER_GROUND.getName().equals(name)){
            return UNDER_GROUND.getIndex();
        } else if (ON_GROUND.getName().equals(name)){
            return ON_GROUND.getIndex();
        } else {
            return  null;
        }
    }


}