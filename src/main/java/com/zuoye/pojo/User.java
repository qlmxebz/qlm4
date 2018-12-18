package com.zuoye.pojo;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {


    private static final long serialVersionUID = -1581691088397097000L;

    private String telephone;

    private String password;
    private int errNum;
    private Date lastTime;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }



    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
