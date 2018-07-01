package net.mav;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, BIConversion.User> userMap = new HashMap<>();

    public BIConversion.User findUserById(String id){
        return userMap.get(id);
    }


}
