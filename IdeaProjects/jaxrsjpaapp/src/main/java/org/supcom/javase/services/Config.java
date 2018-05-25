package org.supcom.javase.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Config {
    public static List<Class> getResources(){
        List<Class> ret = new ArrayList<>();
        ret.add(TestService.class);
        ret.add(CityService.class);
        ret.add(CountryService.class);
        return ret;
    }
}
