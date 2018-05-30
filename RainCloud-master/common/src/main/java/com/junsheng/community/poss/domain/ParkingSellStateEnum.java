package com.junsheng.community.poss.domain;

public enum ParkingSellStateEnum {

    FREE("空闲",(short)-1),RENTED("已租",(short)0),SOLD("已售",(short)1);
    private String name;
    private Short index;
    private ParkingSellStateEnum(String name, Short index) {
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
        if (index == FREE.getIndex()){
            return FREE.getName();
        } else if (index == RENTED.getIndex()){
            return RENTED.getName();
        }  else if (index == SOLD.getIndex()){
            return SOLD.getName();
        } else{
            return null;
        }
    }
    public static Short getIndexByName(String name){
        if (FREE.getName().equals(name)){
            return FREE.getIndex();
        } else if (RENTED.getName().equals(name)){
            return RENTED.getIndex();
        } else if (SOLD.getName().equals(name)){
            return SOLD.getIndex();
        } else {
            return  null;
        }
    }
}
