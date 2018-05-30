package com.junsheng.community.poss.domain;

public enum ParkingApplyStatusEnum {

    AUDITING("审核中",(short)0), ALLOCATED("已分配",(short)1), PAYMENT("缴纳停车费",(short)2), REJECTED("已拒绝",(short)3), OVERDUE("已过期",(short)4);

    private String name;
    private Short index;
    private ParkingApplyStatusEnum(String name, Short index) {
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
        if (index == AUDITING.getIndex()){
            return AUDITING.getName();
        } else if (index == ALLOCATED.getIndex()){
            return ALLOCATED.getName();
        }  else if (index == PAYMENT.getIndex()){
            return PAYMENT.getName();
        }   else if (index == REJECTED.getIndex()){
            return REJECTED.getName();
        }   else if (index == OVERDUE.getIndex()){
            return OVERDUE.getName();
        } else{
            return null;
        }
    }
    public static Short getIndexByName(String name){
        if (AUDITING.getName().equals(name)){
            return AUDITING.getIndex();
        } else if (ALLOCATED.getName().equals(name)){
            return ALLOCATED.getIndex();
        } else if (PAYMENT.getName().equals(name)){
            return PAYMENT.getIndex();
        }  else if (REJECTED.getName().equals(name)){
            return REJECTED.getIndex();
        }  else if (OVERDUE.getName().equals(name)){
            return OVERDUE.getIndex();
        } else {
            return  null;
        }
    }

}
