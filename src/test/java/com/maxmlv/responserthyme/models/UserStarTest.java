package com.maxmlv.responserthyme.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class UserStarTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserStar#UserStar()}
     *   <li>{@link UserStar#setId(long)}
     *   <li>{@link UserStar#setOwner(User)}
     *   <li>{@link UserStar#setSender(User)}
     *   <li>{@link UserStar#getId()}
     *   <li>{@link UserStar#getOwner()}
     *   <li>{@link UserStar#getSender()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserStar actualUserStar = new UserStar();
        actualUserStar.setId(123L);
        User user = new User();
        user.setActive(true);
        user.setConfirmPassword("iloveyou");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setLikes(new ArrayList<>());
        user.setMediaFiles(new ArrayList<>());
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        user.setStars(new ArrayList<>());
        user.setUsername("janedoe");
        actualUserStar.setOwner(user);
        User user1 = new User();
        user1.setActive(true);
        user1.setConfirmPassword("iloveyou");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setLikes(new ArrayList<>());
        user1.setMediaFiles(new ArrayList<>());
        user1.setPassword("iloveyou");
        user1.setPosts(new ArrayList<>());
        user1.setRoles(new HashSet<>());
        user1.setStars(new ArrayList<>());
        user1.setUsername("janedoe");
        actualUserStar.setSender(user1);
        assertEquals(123L, actualUserStar.getId());
        assertSame(user, actualUserStar.getOwner());
        assertSame(user1, actualUserStar.getSender());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserStar#UserStar(User, User)}
     *   <li>{@link UserStar#setId(long)}
     *   <li>{@link UserStar#setOwner(User)}
     *   <li>{@link UserStar#setSender(User)}
     *   <li>{@link UserStar#getId()}
     *   <li>{@link UserStar#getOwner()}
     *   <li>{@link UserStar#getSender()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User user = new User();
        user.setActive(true);
        user.setConfirmPassword("iloveyou");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setLikes(new ArrayList<>());
        user.setMediaFiles(new ArrayList<>());
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        user.setStars(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setConfirmPassword("iloveyou");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setLikes(new ArrayList<>());
        user1.setMediaFiles(new ArrayList<>());
        user1.setPassword("iloveyou");
        user1.setPosts(new ArrayList<>());
        user1.setRoles(new HashSet<>());
        user1.setStars(new ArrayList<>());
        user1.setUsername("janedoe");
        UserStar actualUserStar = new UserStar(user, user1);
        actualUserStar.setId(123L);
        User user2 = new User();
        user2.setActive(true);
        user2.setConfirmPassword("iloveyou");
        user2.setFirstName("Jane");
        user2.setId(123L);
        user2.setLastName("Doe");
        user2.setLikes(new ArrayList<>());
        user2.setMediaFiles(new ArrayList<>());
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());
        user2.setStars(new ArrayList<>());
        user2.setUsername("janedoe");
        actualUserStar.setOwner(user2);
        User user3 = new User();
        user3.setActive(true);
        user3.setConfirmPassword("iloveyou");
        user3.setFirstName("Jane");
        user3.setId(123L);
        user3.setLastName("Doe");
        user3.setLikes(new ArrayList<>());
        user3.setMediaFiles(new ArrayList<>());
        user3.setPassword("iloveyou");
        user3.setPosts(new ArrayList<>());
        user3.setRoles(new HashSet<>());
        user3.setStars(new ArrayList<>());
        user3.setUsername("janedoe");
        actualUserStar.setSender(user3);
        assertEquals(123L, actualUserStar.getId());
        assertSame(user2, actualUserStar.getOwner());
        assertSame(user3, actualUserStar.getSender());
    }
}

