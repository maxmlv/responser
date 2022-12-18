package com.maxmlv.responserthyme.controllers.apis;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.repositories.UserRepository;
import com.maxmlv.responserthyme.services.UserService;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@ContextConfiguration(classes = {UserApiController.class, UserService.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UserApiControllerTest {
    @Autowired
    private UserApiController userApiController;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link UserApiController#addUser(User, Model)}
     */
    @Test
    void testAddUser() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user/add");
        MockMvcBuilders.standaloneSetup(userApiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(2))
                .andExpect(MockMvcResultMatchers.model().attributeExists("errMessage", "user"))
                .andExpect(MockMvcResultMatchers.view().name("registration"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("registration"));
    }

    /**
     * Method under test: {@link UserApiController#updateUser(User, String, String, Model)}
     */
    @Test
    void testUpdateUser() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user/update")
                .param("firstName", "foo")
                .param("lastName", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userApiController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

