package com.myspring.test.bean;

public class UserService {
    String uId;
    UserDao userDao;

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService() {
        System.out.println("UserService 被创建");
    }
    public UserService(String name) {
        System.out.println("有参构造" + name + "创建");
    }
    public void queryInfo() {
        System.out.println("查询用信息"+userDao.queryUserName(uId));
    }
}
