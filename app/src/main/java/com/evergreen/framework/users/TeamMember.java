package com.evergreen.framework.users;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import com.evergreen.framework.groups.Crew;
import com.evergreen.framework.groups.Team;
import com.evergreen.framework.groups.Unit;
import com.evergreen.framework.lessons.Lesson;
import com.evergreen.framework.lessons.LessonSet;

public class TeamMember extends User {

    private Location m_school;
    private Team m_team;
    private Contact m_homeTeacher;
    private int m_grade;
    private int m_classNumber;

    public int getGrade() {
        return m_grade;
    }

    public void setGrade(int grade) {
        m_grade = grade;
    }

    public int getClassNumber() {
        return m_classNumber;
    }

    public void setClassNumber(int classNumber) {
        m_classNumber = classNumber;
    }

    private final ArrayList<Date> m_freeSchedule = new ArrayList<>();
    private final ArrayList<Crew> m_crews = new ArrayList<>();
    private final ArrayList<Unit> m_units = new ArrayList<>();
    private final Map<Lesson, Boolean> m_trainings = new HashMap<>();
    private final Map<LessonSet, Boolean> m_trainingSets = new HashMap<>();

    public Location getSchool() {
        return m_school;
    }

    public void setSchool(Location school) {
        m_school = school;
    }

    public Team getTeam() {
        return m_team;
    }

    public void setTeam(Team team) {
        m_team = team;
    }

    public Contact getHomeTeacher() {
        return m_homeTeacher;
    }

    public void setHomeTeacher(Contact homeTeacher) {
        m_homeTeacher = homeTeacher;
    }

    public ArrayList<Date> getFreeSchedule() {
        return m_freeSchedule;
    }

    public TeamMember(String fullNameEn, SecretKey password, Date birthday, Location school, Team team, int grade, int classNumber) {
        super(fullNameEn, password, birthday);
        m_school = school;
        m_team = team;
        m_grade = grade;
        m_classNumber = classNumber;
    }

    public TeamMember(String fullName, String phoneNumber, SecretKey password, Date birthday, Location school, Team team, int grade, int classNumber) {
        super(fullName, phoneNumber, password, birthday);
        m_school = school;
        m_team = team;
        m_grade = grade;
        m_classNumber = classNumber;
    }

    public TeamMember(String fullName, String phoneNumber, String email, SecretKey password, Date birthday, Location school, Team team, int grade, int classNumber) {
        super(fullName, phoneNumber, email, password, birthday);
        m_school = school;
        m_team = team;
        m_grade = grade;
        m_classNumber = classNumber;
    }

    public ArrayList<Crew> getCrews() {
        return m_crews;
    }

    public ArrayList<Unit> getUnits() {
        return m_units;
    }

    public Map<Lesson, Boolean> getTrainings() {
        return m_trainings;
    }

    public Map<LessonSet, Boolean> getTrainingSets() {
        return m_trainingSets;
    }


    @Override
    public UserType getType() {
        return UserType.MEMBER;
    }
}
