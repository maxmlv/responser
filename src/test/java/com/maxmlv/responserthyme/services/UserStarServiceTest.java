package com.maxmlv.responserthyme.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.maxmlv.responserthyme.models.PostLike;
import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.models.UserStar;
import com.maxmlv.responserthyme.repositories.UserStarRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserStarService.class})
@ExtendWith(SpringExtension.class)
class UserStarServiceTest {
    @MockBean
    private UserStarRepository userStarRepository;

    @Autowired
    private UserStarService userStarService;

    /**
     * Method under test: {@link UserStarService#findUserStarBySenderAndOwner(User, User)}
     */
    @Test
    void testFindUserStarBySenderAndOwner() {
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

        UserStar userStar = new UserStar();
        userStar.setId(123L);
        userStar.setOwner(user);
        userStar.setSender(user1);
        when(userStarRepository.findBySenderAndOwner((User) any(), (User) any())).thenReturn(userStar);

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
        assertSame(userStar, userStarService.findUserStarBySenderAndOwner(user2, user3));
        verify(userStarRepository).findBySenderAndOwner((User) any(), (User) any());
    }

    /**
     * Method under test: {@link UserStarService#isPrincipalStaredUser(User, User)}
     */
    @Test
    void testIsPrincipalStaredUser() {
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

        UserStar userStar = new UserStar();
        userStar.setId(123L);
        userStar.setOwner(user);
        userStar.setSender(user1);
        when(userStarRepository.findBySenderAndOwner((User) any(), (User) any())).thenReturn(userStar);

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
        assertTrue(userStarService.isPrincipalStaredUser(user2, user3));
        verify(userStarRepository).findBySenderAndOwner((User) any(), (User) any());
    }

    /**
     * Method under test: {@link UserStarService#addStar(User, User)}
     */
    @Test
    void testAddStar() {
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

        UserStar userStar = new UserStar();
        userStar.setId(123L);
        userStar.setOwner(user);
        userStar.setSender(user1);

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

        UserStar userStar1 = new UserStar();
        userStar1.setId(123L);
        userStar1.setOwner(user2);
        userStar1.setSender(user3);
        when(userStarRepository.findBySenderAndOwner((User) any(), (User) any())).thenReturn(userStar);
        when(userStarRepository.save((UserStar) any())).thenReturn(userStar1);

        User user4 = new User();
        user4.setActive(true);
        user4.setConfirmPassword("iloveyou");
        user4.setFirstName("Jane");
        user4.setId(123L);
        user4.setLastName("Doe");
        user4.setLikes(new ArrayList<>());
        user4.setMediaFiles(new ArrayList<>());
        user4.setPassword("iloveyou");
        user4.setPosts(new ArrayList<>());
        user4.setRoles(new HashSet<>());
        user4.setStars(new ArrayList<>());
        user4.setUsername("janedoe");

        User user5 = new User();
        user5.setActive(true);
        user5.setConfirmPassword("iloveyou");
        user5.setFirstName("Jane");
        user5.setId(123L);
        user5.setLastName("Doe");
        user5.setLikes(new ArrayList<>());
        user5.setMediaFiles(new ArrayList<>());
        user5.setPassword("iloveyou");
        user5.setPosts(new ArrayList<>());
        user5.setRoles(new HashSet<>());
        user5.setStars(new ArrayList<>());
        user5.setUsername("janedoe");
        assertNull(userStarService.addStar(user4, user5));
        verify(userStarRepository).findBySenderAndOwner((User) any(), (User) any());
    }

    /**
     * Method under test: {@link UserStarService#deleteStar(User, User)}
     */
    @Test
    void testDeleteStar() {
        doNothing().when(userStarRepository).deleteBySenderAndOwner((User) any(), (User) any());

        User user = new User();
        user.setActive(true);
        user.setConfirmPassword("iloveyou");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        ArrayList<PostLike> postLikeList = new ArrayList<>();
        user.setLikes(postLikeList);
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
        ArrayList<PostLike> postLikeList1 = new ArrayList<>();
        user1.setLikes(postLikeList1);
        user1.setMediaFiles(new ArrayList<>());
        user1.setPassword("iloveyou");
        user1.setPosts(new ArrayList<>());
        user1.setRoles(new HashSet<>());
        user1.setStars(new ArrayList<>());
        user1.setUsername("janedoe");
        userStarService.deleteStar(user, user1);
        verify(userStarRepository).deleteBySenderAndOwner((User) any(), (User) any());
        assertTrue(user.getAuthorities().isEmpty());
        assertTrue(user.isEnabled());
        assertEquals("janedoe", user.getUsername());
        assertEquals(postLikeList, user.getStars());
        assertEquals(postLikeList, user.getPosts());
        assertEquals("iloveyou", user.getPassword());
        assertEquals(postLikeList, user.getMediaFiles());
        List<PostLike> likes = user.getLikes();
        assertEquals(postLikeList1, likes);
        assertEquals("Doe", user.getLastName());
        assertEquals(123L, user.getId());
        assertEquals("Jane", user.getFirstName());
        assertEquals("iloveyou", user.getConfirmPassword());
        assertTrue(user1.getAuthorities().isEmpty());
        assertTrue(user1.isEnabled());
        assertEquals("janedoe", user1.getUsername());
        assertEquals(postLikeList1, user1.getStars());
        assertEquals(postLikeList1, user1.getPosts());
        assertEquals("iloveyou", user1.getPassword());
        assertEquals(postLikeList1, user1.getMediaFiles());
        assertEquals(likes, user1.getLikes());
        assertEquals("Doe", user1.getLastName());
        assertEquals(123L, user1.getId());
        assertEquals("Jane", user1.getFirstName());
        assertEquals("iloveyou", user1.getConfirmPassword());
    }
}

