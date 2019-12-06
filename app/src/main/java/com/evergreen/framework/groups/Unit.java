package com.evergreen.framework.groups;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Collections;

import com.evergreen.framework.tasks.Goal;
import com.evergreen.framework.users.TeamMember;
import com.evergreen.framework.users.User;

public class Unit extends Group<TeamMember> {
    private ArrayList<Goal> m_goals = new ArrayList<>();
    private Group<? extends User> m_parent;
    private TeamMember m_leader;
    private String m_description;

    public Unit(String name, Group<? extends  User> parent) {
        super(name);
        m_parent = parent;
        m_parent.addSubGroup(this);
    }

    public Unit(String name, Color colorCode, Group<User> parent, TeamMember leader, TeamMember... teamMembers) {
        super(name, colorCode, teamMembers);
        m_leader = leader;
        m_parent = parent;
        m_parent.addSubGroup(this);
    }

    public void addGoals(Goal... goals) {
        Collections.addAll(m_goals, goals);

    }

    public boolean isCrew() {
        return m_parent instanceof Team;
    }

    public ArrayList<Goal> getGoals() {
        return m_goals;
    }

    public Group getParent() {
        return m_parent;
    }

    public void setParent(Group parent) {
        m_parent = parent;
    }

    public TeamMember getLeader() {
        return m_leader;
    }

    public void setLeader(TeamMember leader) {
        m_leader = leader;
    }

    public String getDescription() {
        return m_description;
    }

    public void setDescription(String description) {
        m_description = description;
    }
}
