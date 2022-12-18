package com.maxmlv.responserthyme.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.maxmlv.responserthyme.models.MediaFile;
import com.maxmlv.responserthyme.models.Post;
import com.maxmlv.responserthyme.models.PostLike;
import com.maxmlv.responserthyme.models.Role;
import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.models.UserStar;
import com.maxmlv.responserthyme.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#findUserById(long)}
     */
    @Test
    void testFindUserById() {
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
        when(userRepository.findById(anyLong())).thenReturn(user);
        assertSame(user, userService.findUserById(1L));
        verify(userRepository).findById(anyLong());
    }

    /**
     * Method under test: {@link UserService#encodePassword(String)}
     */
    @Test
    void testEncodePassword() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     UserService.bCryptPasswordEncoder
        //     UserService.userRepository

        userService.encodePassword("iloveyou");
    }

    /**
     * Method under test: {@link UserService#addUser(User)}
     */
    @Test
    void testAddUser() {
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
        when(userRepository.save((User) any())).thenReturn(user);

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
        assertSame(user, userService.addUser(user1));
        verify(userRepository).save((User) any());
        assertTrue(user1.isEnabled());
    }

    /**
     * Method under test: {@link UserService#addUser(User)}
     */
    @Test
    void testAddUser2() {
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
        when(userRepository.save((User) any())).thenReturn(user);
        User user1 = mock(User.class);
        when(user1.getConfirmPassword()).thenReturn("iloveyou");
        when(user1.getPassword()).thenReturn("iloveyou");
        doNothing().when(user1).setActive(anyBoolean());
        doNothing().when(user1).setConfirmPassword((String) any());
        doNothing().when(user1).setFirstName((String) any());
        doNothing().when(user1).setId(anyLong());
        doNothing().when(user1).setLastName((String) any());
        doNothing().when(user1).setLikes((List<PostLike>) any());
        doNothing().when(user1).setMediaFiles((List<MediaFile>) any());
        doNothing().when(user1).setPassword((String) any());
        doNothing().when(user1).setPosts((List<Post>) any());
        doNothing().when(user1).setRoles((Set<Role>) any());
        doNothing().when(user1).setStars((List<UserStar>) any());
        doNothing().when(user1).setUsername((String) any());
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
        assertSame(user, userService.addUser(user1));
        verify(userRepository).save((User) any());
        verify(user1).getConfirmPassword();
        verify(user1).getPassword();
        verify(user1, atLeast(1)).setActive(anyBoolean());
        verify(user1, atLeast(1)).setConfirmPassword((String) any());
        verify(user1).setFirstName((String) any());
        verify(user1).setId(anyLong());
        verify(user1).setLastName((String) any());
        verify(user1).setLikes((List<PostLike>) any());
        verify(user1).setMediaFiles((List<MediaFile>) any());
        verify(user1, atLeast(1)).setPassword((String) any());
        verify(user1).setPosts((List<Post>) any());
        verify(user1).setRoles((Set<Role>) any());
        verify(user1).setStars((List<UserStar>) any());
        verify(user1).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(User, String, String)}
     */
    @Test
    void testUpdateUser() {
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
        when(userRepository.save((User) any())).thenReturn(user);

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
        assertSame(user, userService.updateUser(user1, "Jane", "Doe"));
        verify(userRepository).save((User) any());
        assertEquals("Doe", user1.getLastName());
        assertEquals("Jane", user1.getFirstName());
    }

    /**
     * Method under test: {@link UserService#updateUser(User, String, String)}
     */
    @Test
    void testUpdateUser2() {
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
        when(userRepository.save((User) any())).thenReturn(user);
        User user1 = mock(User.class);
        doNothing().when(user1).setActive(anyBoolean());
        doNothing().when(user1).setConfirmPassword((String) any());
        doNothing().when(user1).setFirstName((String) any());
        doNothing().when(user1).setId(anyLong());
        doNothing().when(user1).setLastName((String) any());
        doNothing().when(user1).setLikes((List<PostLike>) any());
        doNothing().when(user1).setMediaFiles((List<MediaFile>) any());
        doNothing().when(user1).setPassword((String) any());
        doNothing().when(user1).setPosts((List<Post>) any());
        doNothing().when(user1).setRoles((Set<Role>) any());
        doNothing().when(user1).setStars((List<UserStar>) any());
        doNothing().when(user1).setUsername((String) any());
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
        assertSame(user, userService.updateUser(user1, "Jane", "Doe"));
        verify(userRepository).save((User) any());
        verify(user1).setActive(anyBoolean());
        verify(user1).setConfirmPassword((String) any());
        verify(user1, atLeast(1)).setFirstName((String) any());
        verify(user1).setId(anyLong());
        verify(user1, atLeast(1)).setLastName((String) any());
        verify(user1).setLikes((List<PostLike>) any());
        verify(user1).setMediaFiles((List<MediaFile>) any());
        verify(user1).setPassword((String) any());
        verify(user1).setPosts((List<Post>) any());
        verify(user1).setRoles((Set<Role>) any());
        verify(user1).setStars((List<UserStar>) any());
        verify(user1).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#deleteUserById(long)}
     */
    @Test
    void testDeleteUserById() {
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
        when(userRepository.findById(anyLong())).thenReturn(user);
        doNothing().when(userRepository).delete((User) any());
        userService.deleteUserById(1L);
        verify(userRepository).findById(anyLong());
        verify(userRepository).delete((User) any());
    }

    /**
     * Method under test: {@link UserService#findUserByUsername(String)}
     */
    @Test
    void testFindUserByUsername() {
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
        when(userRepository.findByUsername((String) any())).thenReturn(user);
        assertSame(user, userService.findUserByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
    }
}

