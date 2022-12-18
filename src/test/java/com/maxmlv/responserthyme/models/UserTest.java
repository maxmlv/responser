package com.maxmlv.responserthyme.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setActive(boolean)}
     *   <li>{@link User#setConfirmPassword(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setId(long)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setLikes(List)}
     *   <li>{@link User#setMediaFiles(List)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setPosts(List)}
     *   <li>{@link User#setRoles(Set)}
     *   <li>{@link User#setStars(List)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#getConfirmPassword()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getLikes()}
     *   <li>{@link User#getMediaFiles()}
     *   <li>{@link User#getPosts()}
     *   <li>{@link User#getStars()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getRoles()}
     *   <li>{@link User#getUsername()}
     *   <li>{@link User#isAccountNonExpired()}
     *   <li>{@link User#isAccountNonLocked()}
     *   <li>{@link User#isActive()}
     *   <li>{@link User#isCredentialsNonExpired()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setActive(true);
        actualUser.setConfirmPassword("iloveyou");
        actualUser.setFirstName("Jane");
        actualUser.setId(123L);
        actualUser.setLastName("Doe");
        ArrayList<PostLike> postLikeList = new ArrayList<>();
        actualUser.setLikes(postLikeList);
        ArrayList<MediaFile> mediaFileList = new ArrayList<>();
        actualUser.setMediaFiles(mediaFileList);
        actualUser.setPassword("iloveyou");
        ArrayList<Post> postList = new ArrayList<>();
        actualUser.setPosts(postList);
        actualUser.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList = new ArrayList<>();
        actualUser.setStars(userStarList);
        actualUser.setUsername("janedoe");
        assertEquals("iloveyou", actualUser.getConfirmPassword());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals(123L, actualUser.getId());
        assertEquals("Doe", actualUser.getLastName());
        List<PostLike> likes = actualUser.getLikes();
        assertSame(postLikeList, likes);
        List<MediaFile> mediaFiles = actualUser.getMediaFiles();
        assertEquals(mediaFiles, likes);
        List<Post> posts = actualUser.getPosts();
        assertEquals(posts, likes);
        List<UserStar> stars = actualUser.getStars();
        assertEquals(stars, likes);
        assertSame(mediaFileList, mediaFiles);
        assertEquals(postLikeList, mediaFiles);
        assertEquals(posts, mediaFiles);
        assertEquals(stars, mediaFiles);
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(postList, posts);
        assertEquals(postLikeList, posts);
        assertEquals(mediaFileList, posts);
        assertEquals(stars, posts);
        Collection<? extends GrantedAuthority> expectedRoles = actualUser.getAuthorities();
        assertSame(expectedRoles, actualUser.getRoles());
        assertSame(userStarList, stars);
        assertEquals(postLikeList, stars);
        assertEquals(mediaFileList, stars);
        assertEquals(postList, stars);
        assertEquals("janedoe", actualUser.getUsername());
        assertTrue(actualUser.isAccountNonExpired());
        assertTrue(actualUser.isAccountNonLocked());
        assertTrue(actualUser.isActive());
        assertTrue(actualUser.isCredentialsNonExpired());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(String, String, String, String, String, Set, boolean)}
     *   <li>{@link User#setActive(boolean)}
     *   <li>{@link User#setConfirmPassword(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setId(long)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setLikes(List)}
     *   <li>{@link User#setMediaFiles(List)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setPosts(List)}
     *   <li>{@link User#setRoles(Set)}
     *   <li>{@link User#setStars(List)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#getConfirmPassword()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getLikes()}
     *   <li>{@link User#getMediaFiles()}
     *   <li>{@link User#getPosts()}
     *   <li>{@link User#getStars()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getRoles()}
     *   <li>{@link User#getUsername()}
     *   <li>{@link User#isAccountNonExpired()}
     *   <li>{@link User#isAccountNonLocked()}
     *   <li>{@link User#isActive()}
     *   <li>{@link User#isCredentialsNonExpired()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User actualUser = new User("janedoe", "iloveyou", "iloveyou", "Jane", "Doe", new HashSet<>(), true);
        actualUser.setActive(true);
        actualUser.setConfirmPassword("iloveyou");
        actualUser.setFirstName("Jane");
        actualUser.setId(123L);
        actualUser.setLastName("Doe");
        ArrayList<PostLike> postLikeList = new ArrayList<>();
        actualUser.setLikes(postLikeList);
        ArrayList<MediaFile> mediaFileList = new ArrayList<>();
        actualUser.setMediaFiles(mediaFileList);
        actualUser.setPassword("iloveyou");
        ArrayList<Post> postList = new ArrayList<>();
        actualUser.setPosts(postList);
        actualUser.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList = new ArrayList<>();
        actualUser.setStars(userStarList);
        actualUser.setUsername("janedoe");
        assertEquals("iloveyou", actualUser.getConfirmPassword());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals(123L, actualUser.getId());
        assertEquals("Doe", actualUser.getLastName());
        List<PostLike> likes = actualUser.getLikes();
        assertSame(postLikeList, likes);
        List<MediaFile> mediaFiles = actualUser.getMediaFiles();
        assertEquals(mediaFiles, likes);
        List<Post> posts = actualUser.getPosts();
        assertEquals(posts, likes);
        List<UserStar> stars = actualUser.getStars();
        assertEquals(stars, likes);
        assertSame(mediaFileList, mediaFiles);
        assertEquals(postLikeList, mediaFiles);
        assertEquals(posts, mediaFiles);
        assertEquals(stars, mediaFiles);
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(postList, posts);
        assertEquals(postLikeList, posts);
        assertEquals(mediaFileList, posts);
        assertEquals(stars, posts);
        Collection<? extends GrantedAuthority> expectedRoles = actualUser.getAuthorities();
        assertSame(expectedRoles, actualUser.getRoles());
        assertSame(userStarList, stars);
        assertEquals(postLikeList, stars);
        assertEquals(mediaFileList, stars);
        assertEquals(postList, stars);
        assertEquals("janedoe", actualUser.getUsername());
        assertTrue(actualUser.isAccountNonExpired());
        assertTrue(actualUser.isAccountNonLocked());
        assertTrue(actualUser.isActive());
        assertTrue(actualUser.isCredentialsNonExpired());
    }

    /**
     * Method under test: {@link User#isEnabled()}
     */
    @Test
    void testIsEnabled() {
        assertFalse((new User()).isEnabled());
    }

    /**
     * Method under test: {@link User#isEnabled()}
     */
    @Test
    void testIsEnabled2() {
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
        assertTrue(user.isEnabled());
    }

    /**
     * Method under test: {@link User#getAuthorities()}
     */
    @Test
    void testGetAuthorities() {
        assertNull((new User()).getAuthorities());
    }
}

