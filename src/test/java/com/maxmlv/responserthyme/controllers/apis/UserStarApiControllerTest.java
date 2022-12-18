package com.maxmlv.responserthyme.controllers.apis;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.models.UserStar;
import com.maxmlv.responserthyme.repositories.UserRepository;
import com.maxmlv.responserthyme.repositories.UserStarRepository;
import com.maxmlv.responserthyme.services.UserService;
import com.maxmlv.responserthyme.services.UserStarService;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserStarApiController.class, UserService.class, UserStarService.class,
        BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UserStarApiControllerTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserStarApiController userStarApiController;

    @MockBean
    private UserStarRepository userStarRepository;

    /**
     * Method under test: {@link UserStarApiController#addStar(User, long)}
     */
    @Test
    void testAddStar() throws Exception {
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
        when(userRepository.findById(anyLong())).thenReturn(user4);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/star/add/{user_id}", 1L);
        MockMvcBuilders.standaloneSetup(userStarApiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/profile/janedoe"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile/janedoe"));
    }

    /**
     * Method under test: {@link UserStarApiController#deleteStar(User, long)}
     */
    @Test
    void testDeleteStar() throws Exception {
        doNothing().when(userStarRepository).deleteBySenderAndOwner((User) any(), (User) any());

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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/star/delete/{user_id}", 1L);
        MockMvcBuilders.standaloneSetup(userStarApiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/profile/janedoe"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile/janedoe"));
    }
}

