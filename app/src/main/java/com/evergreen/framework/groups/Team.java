package com.evergreen.framework.groups;

import android.graphics.Color;

import java.security.PrivilegedActionException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.evergreen.framework.lessons.LessonSet;
import com.evergreen.framework.tasks.Goal;
import com.evergreen.framework.users.Mentor;
import com.evergreen.framework.users.Parent;
import com.evergreen.framework.users.TeamMember;
import com.evergreen.framework.users.User;

public class Team extends Group<User> {

    /**The team identifying number. 7112!*/
    private int m_number;

    /**The base units of the team.
     * Crews are less dynamic and are presented differently; Think a more temporary day camp unit
     * vs. the more constant Software crew.*/
    private ArrayList<Crew> m_crews;


    private Unit m_captains = new Unit();
    private Unit m_management;
    private Unit m_HOCs;

    /**
     * All units other then {@link #m_crews the crews}, {@link #m_captains the captains}
     * and {@link #m_management the managment unit}.
     * */
    private List<Unit> m_extraUnits;

    /**
     * All the team's mentors
     * */
    private Group<Mentor> m_mentors;

    /**
     * All member parent
     * */
    private Group<Parent> m_parents;

    /**
     * The team's main goals
     */
    private ArrayList<Goal> m_goals;

    /**
     * The training sets this team has done or intends to do.
     */
    private ArrayList<LessonSet> m_trainings;

    public ArrayList<LessonSet> getTrainings() {
        return m_trainings;
    }

    public void setTrainings(ArrayList<LessonSet> trainings) {
        m_trainings = trainings;
    }

    public Team(String name, Color colorCode, int m_number, User... teamMembers) {
        super(name, colorCode, teamMembers);
        this.m_number = m_number;
    }

    public int getNumber() {
        return m_number;
    }

    public ArrayList<Crew> getCrews() {
        return m_crews;
    }

    public List<Unit> getUnits() {
        List<Unit> result = new ArrayList<>();
        result.add(m_captains);
        result.add(m_management);
        Collections.addAll(m_crews);
        Collections.addAll(m_extraUnits);
    }

    public Unit getCaptains() {
        return m_captains;
    }

    public ArrayList<Goal> getGoals() {
        return m_goals;
    }

    public void addCrew(Crew crew) {
        m_crews.add(crew);
        m_extraUnits.add(crew);
        m_management.addMember(crew.getLeader());
    }
    public Unit getHOCs() {
        return m_HOCs;
    }

    public void removeCrew(Unit unit) throws ItemDoesNotExistException {

        if (!m_crews.contains(unit)) {
            if (!m_extraUnits.contains(unit)) {
                throw new ItemDoesNotExistException("Tried to remove crew \"" +
                        unit.toString() + "\" from team #" + m_number + ", but it does"
                        + " not exist.");
            }

            else {
                throw new ItemDoesNotExistException("Tried to remove crew \"" +
                        unit.toString() + "\" from team #" + m_number + ", but it was not" +
                        " a crew!");
            }
        }

        m_crews.remove(unit);
        m_extraUnits.remove(unit);
    }

    public void addUnit(Unit unit) {
        m_extraUnits.add(unit);
    }

    /**Removes */
    public void removeUnit(Unit unit) throws ItemDoesNotExistException {
        if (!m_extraUnits.contains(unit)) {
            throw new ItemDoesNotExistException("Tried to remove unit \"" +
                    unit.toString() + " from team #" + m_number + ", but it does not exist!");
        }

        m_extraUnits.remove(unit);
    }

    public void addGoal(Goal goal) {
        m_goals.add(goal);
    }

    public void removeGoal(Goal goal) throws ItemDoesNotExistException {
        if (!m_goals.contains(goal)) {
            throw new ItemDoesNotExistException("Tried to remove goal \"" + goal.toString()
            + "\", but it does not exist!");
        }

        m_goals.remove(goal);
    }

    public void addCaptain(TeamMember captain) {
        m_captains.addMember(captain);
    }

    public void removeCaptain(TeamMember captain) throws ItemDoesNotExistException {

        if (!m_captains.contains(captain)) {
            if (!getMembers().contains(captain)) {
                throw new ItemDoesNotExistException("Tried to remove crew \"" +
                        captain.toString() + "\" from team #" + m_number + ", but it does"
                        + " not exist.");
            }

            else {
                throw new ItemDoesNotExistException("Tried to remove crew \"" +
                        captain.toString() + "\" from team #" + m_number + ", but they were not" +
                        " a captain!");
            }
        }

        m_captains.remove(captain);
    }

    public Unit getHOCs() {
        return m_HOCs;
    }

    public Unit getManagement() {
        return  m_management;
    }



    public static class ItemDoesNotExistException extends Exception {


        /**
         * Constructs a new exception with the specified detail message.  The
         * cause is not initialized, and may subsequently be initialized by
         * a call to {@link #initCause}.
         *
         * @param message the detail message. The detail message is saved for
         *                later retrieval by the {@link #getMessage()} method.
         */
        public ItemDoesNotExistException(String message) {
            super(message);
        }

        /**
         * Constructs a new exception with the specified detail message and
         * cause.  <p>Note that the detail message associated with
         * {@code cause} is <i>not</i> automatically incorporated in
         * this exception's detail message.
         *
         * @param message the detail message (which is saved for later retrieval
         *                by the {@link #getMessage()} method).
         * @param cause   the cause (which is saved for later retrieval by the
         *                {@link #getCause()} method).  (A <tt>null</tt> value is
         *                permitted, and indicates that the cause is nonexistent or
         *                unknown.)
         * @since 1.4
         */
        public ItemDoesNotExistException(String message, Throwable cause) {
            super(message, cause);
        }

        /**
         * Constructs a new exception with the specified cause and a detail
         * message of <tt>(cause==null ? null : cause.toString())</tt> (which
         * typically contains the class and detail message of <tt>cause</tt>).
         * This constructor is useful for exceptions that are little more than
         * wrappers for other throwables (for example, {@link
         * PrivilegedActionException}).
         *
         * @param cause the cause (which is saved for later retrieval by the
         *              {@link #getCause()} method).  (A <tt>null</tt> value is
         *              permitted, and indicates that the cause is nonexistent or
         *              unknown.)
         * @since 1.4
         */
        public ItemDoesNotExistException(Throwable cause) {
            super(cause);
        }

        /**
         * Constructs a new exception with the specified detail message,
         * cause, suppression enabled or disabled, and writable stack
         * trace enabled or disabled.
         *
         * @param message            the detail message.
         * @param cause              the cause.  (A {@code null} value is permitted,
         *                           and indicates that the cause is nonexistent or unknown.)
         * @param enableSuppression  whether or not suppression is enabled
         *                           or disabled
         * @param writableStackTrace whether or not the stack trace should
         *                           be writable
         * @since 1.7
         */
        public ItemDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
