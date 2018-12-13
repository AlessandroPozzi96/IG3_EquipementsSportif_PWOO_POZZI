package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util;

import javax.servlet.http.HttpServletRequest;

public class Util {
    public static String makeUrl(HttpServletRequest request)
    {
        //return request.getRequestURL().toString() + "?" + request.getQueryString();
        return request.getRequestURL().toString();
    }
}
