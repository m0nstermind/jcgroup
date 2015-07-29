/*
 * @(#) Tests.java
 * Created 29 июля 2015 г. by oleg
 * (C) Odnoklassniki.ru
 */
package me.haosdent.cgroup;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import me.haosdent.cgroup.manage.Admin;

/**
 * @author Oleg Anastasyev<oa@odnoklassniki.ru>
 *
 */
public class Tests
{
    public static final String userConfName = "user_conf";
    public static final String USER_CONF_KEY_NAME = "name";
    public static final String USER_CONF_KEY_PASSWORD = "password";

    public static Admin admin(int subsystems) throws IOException {
        String content =
                IOUtils.toString(Tests.class.getClassLoader()
                        .getResourceAsStream(userConfName));
        JSONObject json = JSON.parseObject(content);
        String name = json.getString(USER_CONF_KEY_NAME);
        String password = json.getString(USER_CONF_KEY_PASSWORD);


        return new Admin(name, password, subsystems);
    }
}
