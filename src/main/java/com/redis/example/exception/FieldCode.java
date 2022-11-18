package com.redis.example.exception;

import lombok.Getter;

@Getter
public enum FieldCode {
    UNKNOWN_FIELD("undefinedId",10111000),
    ID("id",10111001),
    VALUE("value",10111002),
    KEY("key",10111003);

    private String fieldName;
    private Integer fieldCode;

    FieldCode(String fieldName, Integer fieldCode) {
        this.fieldName = fieldName;
        this.fieldCode = fieldCode;
    }

    public static Integer get_code_by_name(String fieldName){
        for(FieldCode fieldCode : values()){
            if (fieldCode.getFieldName().equals(fieldName)){
                return fieldCode.getFieldCode();
            }
        }
        return FieldCode.UNKNOWN_FIELD.getFieldCode();
    }
}
