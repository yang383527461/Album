package com.ygy.album.bean;

/**
 * Created by Administrator on 2017/9/21.
 */

public class LoginBean {

    /**
     * msg : 登陆成功
     * user : {"userId":1,"name":"1","userName":"12","password":"234"}
     * status : 1
     */

    private String msg;
    private UserBean user;
    private int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class UserBean {
        /**
         * userId : 1
         * name : 1
         * userName : 12
         * password : 234
         */

        private int userId;
        private String name;
        private String userName;
        private String password;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
