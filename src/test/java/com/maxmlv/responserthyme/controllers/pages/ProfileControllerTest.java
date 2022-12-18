package com.maxmlv.responserthyme.controllers.pages;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.maxmlv.responserthyme.models.MediaFile;
import com.maxmlv.responserthyme.models.Post;
import com.maxmlv.responserthyme.models.PostLike;
import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.models.UserStar;
import com.maxmlv.responserthyme.repositories.MediaFilesRepository;
import com.maxmlv.responserthyme.repositories.PostLikeRepository;
import com.maxmlv.responserthyme.repositories.PostRepository;
import com.maxmlv.responserthyme.repositories.UserRepository;
import com.maxmlv.responserthyme.repositories.UserStarRepository;
import com.maxmlv.responserthyme.services.MediaFileService;
import com.maxmlv.responserthyme.services.PostLikeService;
import com.maxmlv.responserthyme.services.PostService;
import com.maxmlv.responserthyme.services.UserService;
import com.maxmlv.responserthyme.services.UserStarService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.ui.Model;

@ContextConfiguration(classes = {ProfileController.class, PostLikeService.class, PostService.class, UserService.class,
        UserStarService.class, BCryptPasswordEncoder.class, MediaFileService.class})
@ExtendWith(SpringExtension.class)
class ProfileControllerTest {
    @MockBean
    private MediaFilesRepository mediaFilesRepository;

    @MockBean
    private PostLikeRepository postLikeRepository;

    @MockBean
    private PostRepository postRepository;

    @Autowired
    private ProfileController profileController;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserStarRepository userStarRepository;

    /**
     * Method under test: {@link ProfileController#getUserProfileLikes(User, String, Model)}
     */
    @Test
    void testGetUserProfileLikes() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/profile/{username}/likes", "janedoe");
        MockMvcBuilders.standaloneSetup(profileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(4))
                .andExpect(
                        MockMvcResultMatchers.model().attributeExists("isPrincipalLikedPostList", "posts", "principalUser", "user"))
                .andExpect(MockMvcResultMatchers.view().name("profile_likes"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("profile_likes"));
    }

    /**
     * Method under test: {@link ProfileController#getUserProfileLikes(User, String, Model)}
     */
    @Test
    void testGetUserProfileLikes2() throws Exception {
        Post post = new Post();
        post.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        post.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        post.setId(123L);
        post.setLikes(new ArrayList<>());
        post.setMediaFile(new MediaFile());
        post.setReplies(new ArrayList<>());
        post.setText("?");
        post.setUser(new User());

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

        MediaFile mediaFile = new MediaFile();
        mediaFile.setId(123L);
        mediaFile.setImageUrl("https://example.org/example");
        mediaFile.setName("?");
        mediaFile.setPost(post);
        mediaFile.setUser(user);

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

        Post post1 = new Post();
        post1.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post1.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        post1.setId(123L);
        post1.setLikes(new ArrayList<>());
        post1.setMediaFile(mediaFile);
        post1.setReplies(new ArrayList<>());
        post1.setText("?");
        post1.setUser(user1);

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

        PostLike postLike = new PostLike();
        postLike.setId(123L);
        postLike.setPost(post1);
        postLike.setUser(user2);

        ArrayList<PostLike> postLikeList = new ArrayList<>();
        postLikeList.add(postLike);

        User user3 = new User();
        user3.setActive(true);
        user3.setConfirmPassword("iloveyou");
        user3.setFirstName("Jane");
        user3.setId(123L);
        user3.setLastName("Doe");
        user3.setLikes(postLikeList);
        user3.setMediaFiles(new ArrayList<>());
        user3.setPassword("iloveyou");
        user3.setPosts(new ArrayList<>());
        user3.setRoles(new HashSet<>());
        user3.setStars(new ArrayList<>());
        user3.setUsername("janedoe");
        when(userRepository.findByUsername((String) any())).thenReturn(user3);

        Post post2 = new Post();
        post2.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post2.setDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        post2.setId(123L);
        post2.setLikes(new ArrayList<>());
        post2.setMediaFile(new MediaFile());
        post2.setReplies(new ArrayList<>());
        post2.setText("Text");
        post2.setUser(new User());

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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("Name");
        mediaFile1.setPost(post2);
        mediaFile1.setUser(user4);

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

        Post post3 = new Post();
        post3.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post3.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        post3.setId(123L);
        post3.setLikes(new ArrayList<>());
        post3.setMediaFile(mediaFile1);
        post3.setReplies(new ArrayList<>());
        post3.setText("Text");
        post3.setUser(user5);

        User user6 = new User();
        user6.setActive(true);
        user6.setConfirmPassword("iloveyou");
        user6.setFirstName("Jane");
        user6.setId(123L);
        user6.setLastName("Doe");
        user6.setLikes(new ArrayList<>());
        user6.setMediaFiles(new ArrayList<>());
        user6.setPassword("iloveyou");
        user6.setPosts(new ArrayList<>());
        user6.setRoles(new HashSet<>());
        user6.setStars(new ArrayList<>());
        user6.setUsername("janedoe");

        MediaFile mediaFile2 = new MediaFile();
        mediaFile2.setId(123L);
        mediaFile2.setImageUrl("https://example.org/example");
        mediaFile2.setName("Name");
        mediaFile2.setPost(post3);
        mediaFile2.setUser(user6);

        User user7 = new User();
        user7.setActive(true);
        user7.setConfirmPassword("iloveyou");
        user7.setFirstName("Jane");
        user7.setId(123L);
        user7.setLastName("Doe");
        user7.setLikes(new ArrayList<>());
        user7.setMediaFiles(new ArrayList<>());
        user7.setPassword("iloveyou");
        user7.setPosts(new ArrayList<>());
        user7.setRoles(new HashSet<>());
        user7.setStars(new ArrayList<>());
        user7.setUsername("janedoe");

        Post post4 = new Post();
        post4.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post4.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        post4.setId(123L);
        post4.setLikes(new ArrayList<>());
        post4.setMediaFile(mediaFile2);
        post4.setReplies(new ArrayList<>());
        post4.setText("Text");
        post4.setUser(user7);
        when(postRepository.findById(anyLong())).thenReturn(post4);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/profile/{username}/likes", "janedoe");
        MockMvcBuilders.standaloneSetup(profileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(4))
                .andExpect(MockMvcResultMatchers.model()
                        .attributeExists("isPrincipalLikedPostList", "posts", "principalUser", "user"))
                .andExpect(MockMvcResultMatchers.view().name("profile_likes"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("profile_likes"));
    }

    /**
     * Method under test: {@link ProfileController#getUserProfileLikes(User, String, Model)}
     */
    @Test
    void testGetUserProfileLikes3() throws Exception {
        Post post = new Post();
        post.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        post.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        post.setId(123L);
        post.setLikes(new ArrayList<>());
        post.setMediaFile(new MediaFile());
        post.setReplies(new ArrayList<>());
        post.setText("?");
        post.setUser(new User());

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

        MediaFile mediaFile = new MediaFile();
        mediaFile.setId(123L);
        mediaFile.setImageUrl("https://example.org/example");
        mediaFile.setName("?");
        mediaFile.setPost(post);
        mediaFile.setUser(user);

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

        Post post1 = new Post();
        post1.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post1.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        post1.setId(123L);
        post1.setLikes(new ArrayList<>());
        post1.setMediaFile(mediaFile);
        post1.setReplies(new ArrayList<>());
        post1.setText("?");
        post1.setUser(user1);

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

        PostLike postLike = new PostLike();
        postLike.setId(123L);
        postLike.setPost(post1);
        postLike.setUser(user2);

        Post post2 = new Post();
        post2.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post2.setDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        post2.setId(123L);
        post2.setLikes(new ArrayList<>());
        post2.setMediaFile(new MediaFile());
        post2.setReplies(new ArrayList<>());
        post2.setText("?");
        post2.setUser(new User());

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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("?");
        mediaFile1.setPost(post2);
        mediaFile1.setUser(user3);

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

        Post post3 = new Post();
        post3.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post3.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        post3.setId(123L);
        post3.setLikes(new ArrayList<>());
        post3.setMediaFile(mediaFile1);
        post3.setReplies(new ArrayList<>());
        post3.setText("?");
        post3.setUser(user4);

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

        PostLike postLike1 = new PostLike();
        postLike1.setId(123L);
        postLike1.setPost(post3);
        postLike1.setUser(user5);

        ArrayList<PostLike> postLikeList = new ArrayList<>();
        postLikeList.add(postLike1);
        postLikeList.add(postLike);

        User user6 = new User();
        user6.setActive(true);
        user6.setConfirmPassword("iloveyou");
        user6.setFirstName("Jane");
        user6.setId(123L);
        user6.setLastName("Doe");
        user6.setLikes(postLikeList);
        user6.setMediaFiles(new ArrayList<>());
        user6.setPassword("iloveyou");
        user6.setPosts(new ArrayList<>());
        user6.setRoles(new HashSet<>());
        user6.setStars(new ArrayList<>());
        user6.setUsername("janedoe");
        when(userRepository.findByUsername((String) any())).thenReturn(user6);

        Post post4 = new Post();
        post4.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post4.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        post4.setId(123L);
        post4.setLikes(new ArrayList<>());
        post4.setMediaFile(new MediaFile());
        post4.setReplies(new ArrayList<>());
        post4.setText("Text");
        post4.setUser(new User());

        User user7 = new User();
        user7.setActive(true);
        user7.setConfirmPassword("iloveyou");
        user7.setFirstName("Jane");
        user7.setId(123L);
        user7.setLastName("Doe");
        user7.setLikes(new ArrayList<>());
        user7.setMediaFiles(new ArrayList<>());
        user7.setPassword("iloveyou");
        user7.setPosts(new ArrayList<>());
        user7.setRoles(new HashSet<>());
        user7.setStars(new ArrayList<>());
        user7.setUsername("janedoe");

        MediaFile mediaFile2 = new MediaFile();
        mediaFile2.setId(123L);
        mediaFile2.setImageUrl("https://example.org/example");
        mediaFile2.setName("Name");
        mediaFile2.setPost(post4);
        mediaFile2.setUser(user7);

        User user8 = new User();
        user8.setActive(true);
        user8.setConfirmPassword("iloveyou");
        user8.setFirstName("Jane");
        user8.setId(123L);
        user8.setLastName("Doe");
        user8.setLikes(new ArrayList<>());
        user8.setMediaFiles(new ArrayList<>());
        user8.setPassword("iloveyou");
        user8.setPosts(new ArrayList<>());
        user8.setRoles(new HashSet<>());
        user8.setStars(new ArrayList<>());
        user8.setUsername("janedoe");

        Post post5 = new Post();
        post5.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post5.setDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        post5.setId(123L);
        post5.setLikes(new ArrayList<>());
        post5.setMediaFile(mediaFile2);
        post5.setReplies(new ArrayList<>());
        post5.setText("Text");
        post5.setUser(user8);

        User user9 = new User();
        user9.setActive(true);
        user9.setConfirmPassword("iloveyou");
        user9.setFirstName("Jane");
        user9.setId(123L);
        user9.setLastName("Doe");
        user9.setLikes(new ArrayList<>());
        user9.setMediaFiles(new ArrayList<>());
        user9.setPassword("iloveyou");
        user9.setPosts(new ArrayList<>());
        user9.setRoles(new HashSet<>());
        user9.setStars(new ArrayList<>());
        user9.setUsername("janedoe");

        MediaFile mediaFile3 = new MediaFile();
        mediaFile3.setId(123L);
        mediaFile3.setImageUrl("https://example.org/example");
        mediaFile3.setName("Name");
        mediaFile3.setPost(post5);
        mediaFile3.setUser(user9);

        User user10 = new User();
        user10.setActive(true);
        user10.setConfirmPassword("iloveyou");
        user10.setFirstName("Jane");
        user10.setId(123L);
        user10.setLastName("Doe");
        user10.setLikes(new ArrayList<>());
        user10.setMediaFiles(new ArrayList<>());
        user10.setPassword("iloveyou");
        user10.setPosts(new ArrayList<>());
        user10.setRoles(new HashSet<>());
        user10.setStars(new ArrayList<>());
        user10.setUsername("janedoe");

        Post post6 = new Post();
        post6.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post6.setDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        post6.setId(123L);
        post6.setLikes(new ArrayList<>());
        post6.setMediaFile(mediaFile3);
        post6.setReplies(new ArrayList<>());
        post6.setText("Text");
        post6.setUser(user10);
        when(postRepository.findById(anyLong())).thenReturn(post6);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/profile/{username}/likes", "janedoe");
        MockMvcBuilders.standaloneSetup(profileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(4))
                .andExpect(MockMvcResultMatchers.model()
                        .attributeExists("isPrincipalLikedPostList", "posts", "principalUser", "user"))
                .andExpect(MockMvcResultMatchers.view().name("profile_likes"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("profile_likes"));
    }

    /**
     * Method under test: {@link ProfileController#getUserProfileMedia(User, String, Model)}
     */
    @Test
    void testGetUserProfileMedia() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/profile/{username}/media", "janedoe");
        MockMvcBuilders.standaloneSetup(profileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(3))
                .andExpect(MockMvcResultMatchers.model().attributeExists("mediaFiles", "principalUser", "user"))
                .andExpect(MockMvcResultMatchers.view().name("profile_media"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("profile_media"));
    }

    /**
     * Method under test: {@link ProfileController#getUserProfilePosts(User, String, Model)}
     */
    @Test
    void testGetUserProfilePosts() throws Exception {
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

        UserStar userStar = new UserStar();
        userStar.setId(123L);
        userStar.setOwner(user1);
        userStar.setSender(user2);
        when(userStarRepository.findBySenderAndOwner((User) any(), (User) any())).thenReturn(userStar);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/profile/{username}", "janedoe");
        MockMvcBuilders.standaloneSetup(profileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(5))
                .andExpect(MockMvcResultMatchers.model()
                        .attributeExists("isPrincipalLikedPostList", "isPrincipalStaredUser", "posts", "principalUser", "user"))
                .andExpect(MockMvcResultMatchers.view().name("profile"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("profile"));
    }

    /**
     * Method under test: {@link ProfileController#getUserProfilePosts(User, String, Model)}
     */
    @Test
    void testGetUserProfilePosts2() throws Exception {
        MediaFile mediaFile = new MediaFile();
        mediaFile.setId(123L);
        mediaFile.setImageUrl("https://example.org/example");
        mediaFile.setName("?");
        mediaFile.setPost(new Post());
        mediaFile.setUser(new User());

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

        Post post = new Post();
        post.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        post.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        post.setId(123L);
        post.setLikes(new ArrayList<>());
        post.setMediaFile(mediaFile);
        post.setReplies(new ArrayList<>());
        post.setText("?");
        post.setUser(user);

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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("?");
        mediaFile1.setPost(post);
        mediaFile1.setUser(user1);

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

        Post post1 = new Post();
        post1.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post1.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        post1.setId(123L);
        post1.setLikes(new ArrayList<>());
        post1.setMediaFile(mediaFile1);
        post1.setReplies(new ArrayList<>());
        post1.setText("?");
        post1.setUser(user2);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post1);

        User user3 = new User();
        user3.setActive(true);
        user3.setConfirmPassword("iloveyou");
        user3.setFirstName("Jane");
        user3.setId(123L);
        user3.setLastName("Doe");
        user3.setLikes(new ArrayList<>());
        user3.setMediaFiles(new ArrayList<>());
        user3.setPassword("iloveyou");
        user3.setPosts(postList);
        user3.setRoles(new HashSet<>());
        user3.setStars(new ArrayList<>());
        user3.setUsername("janedoe");
        when(userRepository.findByUsername((String) any())).thenReturn(user3);

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

        UserStar userStar = new UserStar();
        userStar.setId(123L);
        userStar.setOwner(user4);
        userStar.setSender(user5);
        when(userStarRepository.findBySenderAndOwner((User) any(), (User) any())).thenReturn(userStar);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/profile/{username}", "janedoe");
        MockMvcBuilders.standaloneSetup(profileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(5))
                .andExpect(MockMvcResultMatchers.model()
                        .attributeExists("isPrincipalLikedPostList", "isPrincipalStaredUser", "posts", "principalUser", "user"))
                .andExpect(MockMvcResultMatchers.view().name("profile"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("profile"));
    }

    /**
     * Method under test: {@link ProfileController#getUserProfilePosts(User, String, Model)}
     */
    @Test
    void testGetUserProfilePosts3() throws Exception {
        MediaFile mediaFile = new MediaFile();
        mediaFile.setId(123L);
        mediaFile.setImageUrl("https://example.org/example");
        mediaFile.setName("?");
        mediaFile.setPost(new Post());
        mediaFile.setUser(new User());

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

        Post post = new Post();
        post.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        post.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        post.setId(123L);
        post.setLikes(new ArrayList<>());
        post.setMediaFile(mediaFile);
        post.setReplies(new ArrayList<>());
        post.setText("?");
        post.setUser(user);

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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("?");
        mediaFile1.setPost(post);
        mediaFile1.setUser(user1);

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

        Post post1 = new Post();
        post1.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post1.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        post1.setId(123L);
        post1.setLikes(new ArrayList<>());
        post1.setMediaFile(mediaFile1);
        post1.setReplies(new ArrayList<>());
        post1.setText("?");
        post1.setUser(user2);

        MediaFile mediaFile2 = new MediaFile();
        mediaFile2.setId(123L);
        mediaFile2.setImageUrl("https://example.org/example");
        mediaFile2.setName("?");
        mediaFile2.setPost(new Post());
        mediaFile2.setUser(new User());

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

        Post post2 = new Post();
        post2.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post2.setDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        post2.setId(123L);
        post2.setLikes(new ArrayList<>());
        post2.setMediaFile(mediaFile2);
        post2.setReplies(new ArrayList<>());
        post2.setText("?");
        post2.setUser(user3);

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

        MediaFile mediaFile3 = new MediaFile();
        mediaFile3.setId(123L);
        mediaFile3.setImageUrl("https://example.org/example");
        mediaFile3.setName("?");
        mediaFile3.setPost(post2);
        mediaFile3.setUser(user4);

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

        Post post3 = new Post();
        post3.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post3.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        post3.setId(123L);
        post3.setLikes(new ArrayList<>());
        post3.setMediaFile(mediaFile3);
        post3.setReplies(new ArrayList<>());
        post3.setText("?");
        post3.setUser(user5);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post3);
        postList.add(post1);

        User user6 = new User();
        user6.setActive(true);
        user6.setConfirmPassword("iloveyou");
        user6.setFirstName("Jane");
        user6.setId(123L);
        user6.setLastName("Doe");
        user6.setLikes(new ArrayList<>());
        user6.setMediaFiles(new ArrayList<>());
        user6.setPassword("iloveyou");
        user6.setPosts(postList);
        user6.setRoles(new HashSet<>());
        user6.setStars(new ArrayList<>());
        user6.setUsername("janedoe");
        when(userRepository.findByUsername((String) any())).thenReturn(user6);

        User user7 = new User();
        user7.setActive(true);
        user7.setConfirmPassword("iloveyou");
        user7.setFirstName("Jane");
        user7.setId(123L);
        user7.setLastName("Doe");
        user7.setLikes(new ArrayList<>());
        user7.setMediaFiles(new ArrayList<>());
        user7.setPassword("iloveyou");
        user7.setPosts(new ArrayList<>());
        user7.setRoles(new HashSet<>());
        user7.setStars(new ArrayList<>());
        user7.setUsername("janedoe");

        User user8 = new User();
        user8.setActive(true);
        user8.setConfirmPassword("iloveyou");
        user8.setFirstName("Jane");
        user8.setId(123L);
        user8.setLastName("Doe");
        user8.setLikes(new ArrayList<>());
        user8.setMediaFiles(new ArrayList<>());
        user8.setPassword("iloveyou");
        user8.setPosts(new ArrayList<>());
        user8.setRoles(new HashSet<>());
        user8.setStars(new ArrayList<>());
        user8.setUsername("janedoe");

        UserStar userStar = new UserStar();
        userStar.setId(123L);
        userStar.setOwner(user7);
        userStar.setSender(user8);
        when(userStarRepository.findBySenderAndOwner((User) any(), (User) any())).thenReturn(userStar);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/profile/{username}", "janedoe");
        MockMvcBuilders.standaloneSetup(profileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(5))
                .andExpect(MockMvcResultMatchers.model()
                        .attributeExists("isPrincipalLikedPostList", "isPrincipalStaredUser", "posts", "principalUser", "user"))
                .andExpect(MockMvcResultMatchers.view().name("profile"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("profile"));
    }
}

