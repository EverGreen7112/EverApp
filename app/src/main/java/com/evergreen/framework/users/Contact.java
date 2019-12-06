package com.evergreen.framework.users;

import androidx.annotation.NonNull;

public class Contact {

    public Contact(String fullNameEn) {
        String[] nameComponents = fullNameEn.split(" ");
        m_firstNameEn = nameComponents[0];
        m_lastNameEn = nameComponents[1];
    }

    public Contact(String fullName, String phoneNumber) {
        this(fullName);
        m_phoneNumber = phoneNumber;
    }

    public Contact(String fullName, String phoneNumber, String email) {
        this(fullName, phoneNumber);
        m_email = email;
    }

    private String m_firstNameEn;
    private String m_firstNameHe;
    private String m_lastNameHe;
    private String m_lastNameEn;
    private String m_phoneNumber;
    private String m_email;

    public String getFirstNameEn() {
        return m_firstNameEn;
    }

    public void setFirstNameEn(String firstNameEn) {
        m_firstNameEn = firstNameEn;
    }

    public String getFirstNameHe() {
        return m_firstNameHe;
    }

    public void setFirstNameHe(String firstNameHe) {
        m_firstNameHe = firstNameHe;
    }

    public String getLastNameHe() {
        return m_lastNameHe;
    }

    public void setLastNameHe(String lastNameHe) {
        m_lastNameHe = lastNameHe;
    }

    public String getLastNameEn() {
        return m_lastNameEn;
    }

    public String geFullName() {
        return m_firstNameEn + " " + m_lastNameEn;
    }

    public String getFullNameHe() {
        return  m_firstNameHe + " " + m_lastNameHe;
    }

    public void setLastNameEn(String lastNameEn) {
        m_lastNameEn = lastNameEn;
    }

    public String getPhoneNumber() throws  MissingPhoneException {

        if (m_phoneNumber == null) throw new MissingPhoneException("Tried to get email for "
        + " user \"" + toString() + "\", but it did not have one!");

        return m_phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        m_phoneNumber = phoneNumber;
    }

    public String getEmail() throws MissingEmailException {
        if (m_email == null)
            throw new MissingEmailException("Tried to get email for user \"" + toString() + "\" ,"
            + "But it did not have one!");
        return m_email;
    }

    public void setEmail(String email) {
        m_email = email;
    }




    @NonNull
    @Override
    public String toString() {
        return getFullNameHe();
    }

    public static class MissingEmailException extends Exception {

        public MissingEmailException(String msg) {
            super(msg);
        }

        public MissingEmailException(String msg, Throwable e) {
            super(msg, e);
        }
    }


    public static class MissingPhoneException extends Exception {

        public MissingPhoneException(String msg) {
            super(msg);
        }

        public MissingPhoneException(String msg, Throwable e) {
            super(msg, e);
        }
    }
}
