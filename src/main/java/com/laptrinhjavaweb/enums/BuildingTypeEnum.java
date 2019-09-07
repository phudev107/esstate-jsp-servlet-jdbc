package com.laptrinhjavaweb.enums;

public enum BuildingTypeEnum {
	TAN_TRET("Tầng Trệt"),
    NGUYEN_CAN("Nguyên Căn"),
    APNIC("Nội Thất");
 

    private String value;

    BuildingTypeEnum(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}
 
}
