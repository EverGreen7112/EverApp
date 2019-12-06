package com.evergreen.framework.users;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;

import javax.crypto.SecretKey;

public abstract class User extends Contact {


    private SecretKey m_password;
    private Date m_birthday;
    private Location m_home;
    private final ArrayList<Date> m_freeSchedule = new ArrayList<>();

    public User(String fullNameEn, SecretKey password, Date birthday) {
        super(fullNameEn);
        this.m_password = password;
        this.m_birthday = birthday;
    }

    public User(String fullName, String phoneNumber, SecretKey password, Date birthday) {
        super(fullName, phoneNumber);
        this.m_password = password;
        this.m_birthday = birthday;
    }

    public User(String fullName, String phoneNumber, String email, SecretKey password, Date birthday) {
        super(fullName, phoneNumber, email);
        this.m_password = password;
        this.m_birthday = birthday;
    }

    public SecretKey getPassword() {
        return m_password;
    }

    public void setPassword(SecretKey password) {
        m_password = password;
    }

    public Date getBirthday() {
        return m_birthday;
    }

    public void setBirthdasy(Date birthday) {
        m_birthday = birthday;
    }

    public Location getHome() {
        return m_home;
    }

    public void setHome(Location home) {
        m_home = home;
    }

    public abstract UserType getType();
//  public String getEmail();
//  public SecretKey getPassword();
}
