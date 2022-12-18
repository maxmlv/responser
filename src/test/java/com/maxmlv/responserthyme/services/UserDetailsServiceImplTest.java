package com.maxmlv.responserthyme.services;

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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserDetailsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
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
        UserDetails actualLoadUserByUsernameResult = userDetailsServiceImpl.loadUserByUsername("janedoe");
        assertSame(user, actualLoadUserByUsernameResult);
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        User user = mock(User.class);
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setConfirmPassword((String) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setLikes((List<PostLike>) any());
        doNothing().when(user).setMediaFiles((List<MediaFile>) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setPosts((List<Post>) any());
        doNothing().when(user).setRoles((Set<Role>) any());
        doNothing().when(user).setStars((List<UserStar>) any());
        doNothing().when(user).setUsername((String) any());
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
        userDetailsServiceImpl.loadUserByUsername("janedoe");
        verify(userRepository).findByUsername((String) any());
        verify(user, atLeast(1)).setActive(anyBoolean());
        verify(user).setConfirmPassword((String) any());
        verify(user).setFirstName((String) any());
        verify(user).setId(anyLong());
        verify(user).setLastName((String) any());
        verify(user).setLikes((List<PostLike>) any());
        verify(user).setMediaFiles((List<MediaFile>) any());
        verify(user).setPassword((String) any());
        verify(user).setPosts((List<Post>) any());
        verify(user).setRoles((Set<Role>) any());
        verify(user).setStars((List<UserStar>) any());
        verify(user).setUsername((String) any());
    }
}

