package com.davin.miaoshaproject.valiator;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ValidationResult {
    @Setter
    private boolean hasErrors = false;

    @Getter
    @Setter
    private Map<String,String> errorMsgMap = new HashMap<>();

    public boolean isHasErrors(){
        return hasErrors;
    }

    public String getErrMsg(){
        return StringUtils.join(errorMsgMap.values().toArray(),",");
    }
}
