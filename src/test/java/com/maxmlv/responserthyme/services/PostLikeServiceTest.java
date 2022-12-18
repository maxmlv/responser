package com.maxmlv.responserthyme.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.maxmlv.responserthyme.models.Comment;
import com.maxmlv.responserthyme.models.MediaFile;
import com.maxmlv.responserthyme.models.Post;
import com.maxmlv.responserthyme.models.PostLike;
import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.repositories.PostLikeRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PostLikeService.class})
@ExtendWith(SpringExtension.class)
class PostLikeServiceTest {
    @MockBean
    private PostLikeRepository postLikeRepository;

    @Autowired
    private PostLikeService postLikeService;

    /**
     * Method under test: {@link PostLikeService#findLikeByPostAndUser(Post, User)}
     */
    @Test
    void testFindLikeByPostAndUser() {
        MediaFile mediaFile = new MediaFile();
        mediaFile.setId(123L);
        mediaFile.setImageUrl("https://example.org/example");
        mediaFile.setName("Name");
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
        post.setText("Text");
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
        mediaFile1.setName("Name");
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
        post1.setText("Text");
        post1.setUser(user2);

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

        PostLike postLike = new PostLike();
        postLike.setId(123L);
        postLike.setPost(post1);
        postLike.setUser(user3);
        when(postLikeRepository.findByPostAndUser((Post) any(), (User) any())).thenReturn(postLike);

        MediaFile mediaFile2 = new MediaFile();
        mediaFile2.setId(123L);
        mediaFile2.setImageUrl("https://example.org/example");
        mediaFile2.setName("Name");
        mediaFile2.setPost(new Post());
        mediaFile2.setUser(new User());

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

        Post post2 = new Post();
        post2.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post2.setDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        post2.setId(123L);
        post2.setLikes(new ArrayList<>());
        post2.setMediaFile(mediaFile2);
        post2.setReplies(new ArrayList<>());
        post2.setText("Text");
        post2.setUser(user4);

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

        MediaFile mediaFile3 = new MediaFile();
        mediaFile3.setId(123L);
        mediaFile3.setImageUrl("https://example.org/example");
        mediaFile3.setName("Name");
        mediaFile3.setPost(post2);
        mediaFile3.setUser(user5);

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

        Post post3 = new Post();
        post3.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post3.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        post3.setId(123L);
        post3.setLikes(new ArrayList<>());
        post3.setMediaFile(mediaFile3);
        post3.setReplies(new ArrayList<>());
        post3.setText("Text");
        post3.setUser(user6);

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
        assertSame(postLike, postLikeService.findLikeByPostAndUser(post3, user7));
        verify(postLikeRepository).findByPostAndUser((Post) any(), (User) any());
    }

    /**
     * Method under test: {@link PostLikeService#findAllByUser(User)}
     */
    @Test
    void testFindAllByUser() {
        ArrayList<PostLike> postLikeList = new ArrayList<>();
        when(postLikeRepository.findAllByUser((User) any())).thenReturn(postLikeList);

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
        List<PostLike> actualFindAllByUserResult = postLikeService.findAllByUser(user);
        assertSame(postLikeList, actualFindAllByUserResult);
        assertTrue(actualFindAllByUserResult.isEmpty());
        verify(postLikeRepository).findAllByUser((User) any());
    }

    /**
     * Method under test: {@link PostLikeService#addLike(Post, User)}
     */
    @Test
    void testAddLike() {
        MediaFile mediaFile = new MediaFile();
        mediaFile.setId(123L);
        mediaFile.setImageUrl("https://example.org/example");
        mediaFile.setName("Name");
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
        post.setText("Text");
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
        mediaFile1.setName("Name");
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
        post1.setText("Text");
        post1.setUser(user2);

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

        PostLike postLike = new PostLike();
        postLike.setId(123L);
        postLike.setPost(post1);
        postLike.setUser(user3);

        MediaFile mediaFile2 = new MediaFile();
        mediaFile2.setId(123L);
        mediaFile2.setImageUrl("https://example.org/example");
        mediaFile2.setName("Name");
        mediaFile2.setPost(new Post());
        mediaFile2.setUser(new User());

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

        Post post2 = new Post();
        post2.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post2.setDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        post2.setId(123L);
        post2.setLikes(new ArrayList<>());
        post2.setMediaFile(mediaFile2);
        post2.setReplies(new ArrayList<>());
        post2.setText("Text");
        post2.setUser(user4);

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

        MediaFile mediaFile3 = new MediaFile();
        mediaFile3.setId(123L);
        mediaFile3.setImageUrl("https://example.org/example");
        mediaFile3.setName("Name");
        mediaFile3.setPost(post2);
        mediaFile3.setUser(user5);

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

        Post post3 = new Post();
        post3.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post3.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        post3.setId(123L);
        post3.setLikes(new ArrayList<>());
        post3.setMediaFile(mediaFile3);
        post3.setReplies(new ArrayList<>());
        post3.setText("Text");
        post3.setUser(user6);

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

        PostLike postLike1 = new PostLike();
        postLike1.setId(123L);
        postLike1.setPost(post3);
        postLike1.setUser(user7);
        when(postLikeRepository.findByPostAndUser((Post) any(), (User) any())).thenReturn(postLike);
        when(postLikeRepository.save((PostLike) any())).thenReturn(postLike1);

        MediaFile mediaFile4 = new MediaFile();
        mediaFile4.setId(123L);
        mediaFile4.setImageUrl("https://example.org/example");
        mediaFile4.setName("Name");
        mediaFile4.setPost(new Post());
        mediaFile4.setUser(new User());

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

        Post post4 = new Post();
        post4.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post4.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        post4.setId(123L);
        post4.setLikes(new ArrayList<>());
        post4.setMediaFile(mediaFile4);
        post4.setReplies(new ArrayList<>());
        post4.setText("Text");
        post4.setUser(user8);

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

        MediaFile mediaFile5 = new MediaFile();
        mediaFile5.setId(123L);
        mediaFile5.setImageUrl("https://example.org/example");
        mediaFile5.setName("Name");
        mediaFile5.setPost(post4);
        mediaFile5.setUser(user9);

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

        Post post5 = new Post();
        post5.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post5.setDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        post5.setId(123L);
        post5.setLikes(new ArrayList<>());
        post5.setMediaFile(mediaFile5);
        post5.setReplies(new ArrayList<>());
        post5.setText("Text");
        post5.setUser(user10);

        User user11 = new User();
        user11.setActive(true);
        user11.setConfirmPassword("iloveyou");
        user11.setFirstName("Jane");
        user11.setId(123L);
        user11.setLastName("Doe");
        user11.setLikes(new ArrayList<>());
        user11.setMediaFiles(new ArrayList<>());
        user11.setPassword("iloveyou");
        user11.setPosts(new ArrayList<>());
        user11.setRoles(new HashSet<>());
        user11.setStars(new ArrayList<>());
        user11.setUsername("janedoe");
        assertNull(postLikeService.addLike(post5, user11));
        verify(postLikeRepository).findByPostAndUser((Post) any(), (User) any());
    }

    /**
     * Method under test: {@link PostLikeService#deleteLike(Post, User)}
     */
    @Test
    void testDeleteLike() {
        doNothing().when(postLikeRepository).deleteByPostAndUser((Post) any(), (User) any());

        MediaFile mediaFile = new MediaFile();
        mediaFile.setId(123L);
        mediaFile.setImageUrl("https://example.org/example");
        mediaFile.setName("Name");
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
        ArrayList<Comment> commentList = new ArrayList<>();
        post.setComments(commentList);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        post.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        post.setId(123L);
        post.setLikes(new ArrayList<>());
        post.setMediaFile(mediaFile);
        post.setReplies(new ArrayList<>());
        post.setText("Text");
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
        mediaFile1.setName("Name");
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
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        post1.setDate(fromResult);
        post1.setId(123L);
        ArrayList<PostLike> postLikeList = new ArrayList<>();
        post1.setLikes(postLikeList);
        post1.setMediaFile(mediaFile1);
        post1.setReplies(new ArrayList<>());
        post1.setText("Text");
        post1.setUser(user2);

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
        postLikeService.deleteLike(post1, user3);
        verify(postLikeRepository).deleteByPostAndUser((Post) any(), (User) any());
        assertEquals(postLikeList, post1.getComments());
        assertSame(user2, post1.getUser());
        assertEquals("Text", post1.getText());
        assertSame(fromResult, post1.getDate());
        assertEquals(commentList, post1.getLikes());
        assertSame(mediaFile1, post1.getMediaFile());
        assertEquals(123L, post1.getId());
        assertEquals(commentList, post1.getReplies());
    }

    /**
     * Method under test: {@link PostLikeService#deleteAllByPost(Post)}
     */
    @Test
    void testDeleteAllByPost() {
        doNothing().when(postLikeRepository).deleteAllByPost((Post) any());

        MediaFile mediaFile = new MediaFile();
        mediaFile.setId(123L);
        mediaFile.setImageUrl("https://example.org/example");
        mediaFile.setName("Name");
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
        ArrayList<Comment> commentList = new ArrayList<>();
        post.setComments(commentList);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        post.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        post.setId(123L);
        post.setLikes(new ArrayList<>());
        post.setMediaFile(mediaFile);
        post.setReplies(new ArrayList<>());
        post.setText("Text");
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
        mediaFile1.setName("Name");
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
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        post1.setDate(fromResult);
        post1.setId(123L);
        ArrayList<PostLike> postLikeList = new ArrayList<>();
        post1.setLikes(postLikeList);
        post1.setMediaFile(mediaFile1);
        post1.setReplies(new ArrayList<>());
        post1.setText("Text");
        post1.setUser(user2);
        postLikeService.deleteAllByPost(post1);
        verify(postLikeRepository).deleteAllByPost((Post) any());
        assertEquals(postLikeList, post1.getComments());
        assertSame(user2, post1.getUser());
        assertEquals("Text", post1.getText());
        assertSame(fromResult, post1.getDate());
        assertEquals(commentList, post1.getLikes());
        assertSame(mediaFile1, post1.getMediaFile());
        assertEquals(123L, post1.getId());
        assertEquals(commentList, post1.getReplies());
    }
}

