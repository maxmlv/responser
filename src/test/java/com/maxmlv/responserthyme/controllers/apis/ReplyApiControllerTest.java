package com.maxmlv.responserthyme.controllers.apis;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.maxmlv.responserthyme.models.Comment;
import com.maxmlv.responserthyme.models.MediaFile;
import com.maxmlv.responserthyme.models.Post;
import com.maxmlv.responserthyme.models.Reply;
import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.repositories.CommentRepository;
import com.maxmlv.responserthyme.repositories.MediaFilesRepository;
import com.maxmlv.responserthyme.repositories.PostRepository;
import com.maxmlv.responserthyme.repositories.ReplyRepository;
import com.maxmlv.responserthyme.services.CommentService;
import com.maxmlv.responserthyme.services.MediaFileService;
import com.maxmlv.responserthyme.services.PostService;
import com.maxmlv.responserthyme.services.ReplyService;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ReplyApiController.class, CommentService.class, PostService.class, ReplyService.class,
        MediaFileService.class})
@ExtendWith(SpringExtension.class)
class ReplyApiControllerTest {
    @MockBean
    private CommentRepository commentRepository;

    @MockBean
    private MediaFilesRepository mediaFilesRepository;

    @MockBean
    private PostRepository postRepository;

    @Autowired
    private ReplyApiController replyApiController;

    @MockBean
    private ReplyRepository replyRepository;

    /**
     * Method under test: {@link ReplyApiController#addReply(User, long, long, String)}
     */
    @Test
    void testAddReply() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/reply/add/{post_id}/{comment_id}", 1L, 1L)
                .param("text", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(replyApiController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link ReplyApiController#deleteReply(long, long)}
     */
    @Test
    void testDeleteReply() throws Exception {
        Post post = new Post();
        post.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        post.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        post.setId(123L);
        post.setLikes(new ArrayList<>());
        post.setMediaFile(new MediaFile());
        post.setReplies(new ArrayList<>());
        post.setText("Text");
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
        mediaFile.setName("Name");
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
        post1.setText("Text");
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

        Comment comment = new Comment();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        comment.setDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        comment.setId(123L);
        comment.setPost(post1);
        comment.setReplies(new ArrayList<>());
        comment.setText("Text");
        comment.setUser(user2);

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("Name");
        mediaFile1.setPost(new Post());
        mediaFile1.setUser(new User());

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
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post2.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        post2.setId(123L);
        post2.setLikes(new ArrayList<>());
        post2.setMediaFile(mediaFile1);
        post2.setReplies(new ArrayList<>());
        post2.setText("Text");
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

        MediaFile mediaFile2 = new MediaFile();
        mediaFile2.setId(123L);
        mediaFile2.setImageUrl("https://example.org/example");
        mediaFile2.setName("Name");
        mediaFile2.setPost(post2);
        mediaFile2.setUser(user4);

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
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post3.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        post3.setId(123L);
        post3.setLikes(new ArrayList<>());
        post3.setMediaFile(mediaFile2);
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

        Reply reply = new Reply();
        reply.setComment(comment);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        reply.setDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        reply.setId(123L);
        reply.setPost(post3);
        reply.setText("Text");
        reply.setUser(user6);
        when(replyRepository.findById(anyLong())).thenReturn(reply);
        doNothing().when(replyRepository).delete((Reply) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/reply/delete/{post_id}/{reply_id}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(replyApiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/post/1"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/post/1"));
    }
}

