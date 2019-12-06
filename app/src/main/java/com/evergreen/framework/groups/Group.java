package com.evergreen.framework.groups;

import android.graphics.Color;
import android.graphics.ColorSpace;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Represents a potentially nested, labeled, group of objects.
 */
public class Group<T> implements Iterable<T> {
    public Color DEFAULT_COLOR = new Color();


    /**
     * The objects in the group
     */
    private final ArrayList<T> m_members = new ArrayList<>();

    /**
     * The group nested within this one. dividing the members further.
     */
    private final ArrayList<Group> m_subGroups = new ArrayList<>();

    /**
     * The group's title
     */
    private String m_name;

    /**
     * A color code for the group, for the UI.
     */
    private Color m_colorCode;

    /**
     * @return this group's title.
     */
    public String getName() {
        return m_name;
    }

    /**
     * Sets this group's title
     *
     * @param name - the title to change to.
     */
    public void setName(String name) {
        m_name = name;
    }

    public Color getColorCode() {
        return m_colorCode;
    }

    public void setColorCode(Color colorCode) {
        m_colorCode = colorCode;
    }

    public void addMember(T member) {
        m_members.add(member);
    }

    /**
     * Adds a subgroup to this group. If the subgroup is not a subset of the current one,
     * this may throw a {@link DisjointSubgroupException`}
     *
     * @param group the subgroup to add.
     */
    public void addSubGroup(Group<T> group) {
        for (T member : group.getMembers()) {
            if (!contains(member)) {
                throw new DisjointSubgroupException("Tried to add subgroup \"" +
                        group.getName() + "\" to group \"" + getName() + "\", but it" +
                        "was not a subset of it!");
            }
        }

        m_subGroups.add(group);
    }

    public ArrayList<Group> getSubGroups() {
        return m_subGroups;
    }

    public ArrayList<T> getMembers() {
        return m_members;
    }

    public Group(String name, Color colorCode, T... teamMembers) {
        m_name = name;
        m_colorCode = colorCode;
        Collections.addAll(m_members, teamMembers);
    }

    public boolean contains(T member) {
        return m_members.contains(member);
    }

    public void remove(T member) {
        m_members.remove(member);
    }

    public ArrayList<T> asList() {
        return m_members;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return m_members.iterator();
    }

    @NonNull
    @Override
    public String toString() {
        return m_name;
    }

    public static class DisjointSubgroupException extends RuntimeException {

        /**
         * Constructs a new runtime exception with the specified detail message.
         * The cause is not initialized, and may subsequently be initialized by a
         * call to {@link #initCause}.
         *
         * @param message the detail message. The detail message is saved for
         *                later retrieval by the {@link #getMessage()} method.
         */
        public DisjointSubgroupException(String message) {
            super(message);
        }

        /**
         * Constructs a new runtime exception with the specified detail message and
         * cause.  <p>Note that the detail message associated with
         * {@code cause} is <i>not</i> automatically incorporated in
         * this runtime exception's detail message.
         *
         * @param message the detail message (which is saved for later retrieval
         *                by the {@link #getMessage()} method).
         * @param cause   the cause (which is saved for later retrieval by the
         *                {@link #getCause()} method).  (A <tt>null</tt> value is
         *                permitted, and indicates that the cause is nonexistent or
         *                unknown.)
         * @since 1.4
         */
        public DisjointSubgroupException(String message, Throwable cause) {
            super(message, cause);
        }

        /**
         * Constructs a new runtime exception with the specified cause and a
         * detail message of <tt>(cause==null ? null : cause.toString())</tt>
         * (which typically contains the class and detail message of
         * <tt>cause</tt>).  This constructor is useful for runtime exceptions
         * that are little more than wrappers for other throwables.
         *
         * @param cause the cause (which is saved for later retrieval by the
         *              {@link #getCause()} method).  (A <tt>null</tt> value is
         *              permitted, and indicates that the cause is nonexistent or
         *              unknown.)
         * @since 1.4
         */
        public DisjointSubgroupException(Throwable cause) {
            super(cause);
        }

        /**
         * Constructs a new runtime exception with the specified detail
         * message, cause, suppression enabled or disabled, and writable
         * stack trace enabled or disabled.
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
        public DisjointSubgroupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
