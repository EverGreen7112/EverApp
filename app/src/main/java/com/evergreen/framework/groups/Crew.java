package com.evergreen.framework.groups;

import android.graphics.Color;

import com.evergreen.framework.users.TeamMember;

/**
 * A special type of unit, whose parent is a team and is a
 */
public class Crew extends Unit {

    public Crew(String name, Color colorCode, Team parent, TeamMember hoc, TeamMember... teamMembers) {
        super(name, colorCode, parent, hoc, teamMembers);
        parent.addCrew(this);
    }

    @Override
    public void setLeader(TeamMember leader) {
        super.setLeader(leader);
    }

    @Override
    public void setParent(Group parent) { }

    public Team getTeam() {
        return (Team)(getParent());
    }
}
