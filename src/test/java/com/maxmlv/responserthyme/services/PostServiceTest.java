package com.maxmlv.responserthyme.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.maxmlv.responserthyme.models.Comment;
import com.maxmlv.responserthyme.models.MediaFile;
import com.maxmlv.responserthyme.models.Post;
import com.maxmlv.responserthyme.models.PostLike;
import com.maxmlv.responserthyme.models.Reply;
import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.repositories.PostRepository;

import java.io.IOException;
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

@ContextConfiguration(classes = {PostService.class})
@ExtendWith(SpringExtension.class)
class PostServiceTest {
    @MockBean
    private MediaFileService mediaFileService;

    @MockBean
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    /**
     * Method under test: {@link PostService#findAllPosts()}
     */
    @Test
    void testFindAllPosts() {
        ArrayList<Post> postList = new ArrayList<>();
        when(postRepository.findAllByOrderByDateDesc()).thenReturn(postList);
        List<Post> actualFindAllPostsResult = postService.findAllPosts();
        assertSame(postList, actualFindAllPostsResult);
        assertTrue(actualFindAllPostsResult.isEmpty());
        verify(postRepository).findAllByOrderByDateDesc();
    }

    /**
     * Method under test: {@link PostService#findPostById(long)}
     */
    @Test
    void testFindPostById() {
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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("Name");
        mediaFile1.setPost(post1);
        mediaFile1.setUser(user2);

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
        post2.setMediaFile(mediaFile1);
        post2.setReplies(new ArrayList<>());
        post2.setText("Text");
        post2.setUser(user3);
        when(postRepository.findById(anyLong())).thenReturn(post2);
        assertSame(post2, postService.findPostById(1L));
        verify(postRepository).findById(anyLong());
    }

    /**
     * Method under test: {@link PostService#findPostsByLikes(List)}
     */
    @Test
    void testFindPostsByLikes() {
        assertTrue(postService.findPostsByLikes(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link PostService#findPostsByLikes(List)}
     */
    @Test
    void testFindPostsByLikes2() {
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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("Name");
        mediaFile1.setPost(post1);
        mediaFile1.setUser(user2);

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
        post2.setMediaFile(mediaFile1);
        post2.setReplies(new ArrayList<>());
        post2.setText("Text");
        post2.setUser(user3);
        when(postRepository.findById(anyLong())).thenReturn(post2);

        Post post3 = new Post();
        post3.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post3.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        post3.setId(123L);
        post3.setLikes(new ArrayList<>());
        post3.setMediaFile(new MediaFile());
        post3.setReplies(new ArrayList<>());
        post3.setText("Text");
        post3.setUser(new User());

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
        mediaFile2.setPost(post3);
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

        Post post4 = new Post();
        post4.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post4.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        post4.setId(123L);
        post4.setLikes(new ArrayList<>());
        post4.setMediaFile(mediaFile2);
        post4.setReplies(new ArrayList<>());
        post4.setText("Text");
        post4.setUser(user5);

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

        PostLike postLike = new PostLike();
        postLike.setId(123L);
        postLike.setPost(post4);
        postLike.setUser(user6);

        ArrayList<PostLike> postLikeList = new ArrayList<>();
        postLikeList.add(postLike);
        assertEquals(1, postService.findPostsByLikes(postLikeList).size());
        verify(postRepository).findById(anyLong());
    }

    /**
     * Method under test: {@link PostService#sortPostsByDate(List)}
     */
    @Test
    void testSortPostsByDate() {
        ArrayList<Post> postList = new ArrayList<>();
        List<Post> actualSortPostsByDateResult = postService.sortPostsByDate(postList);
        assertSame(postList, actualSortPostsByDateResult);
        assertTrue(actualSortPostsByDateResult.isEmpty());
    }

    /**
     * Method under test: {@link PostService#sortPostsByDate(List)}
     */
    @Test
    void testSortPostsByDate2() {
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

        MediaFile mediaFile2 = new MediaFile();
        mediaFile2.setId(123L);
        mediaFile2.setImageUrl("https://example.org/example");
        mediaFile2.setName("Name");
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

        MediaFile mediaFile3 = new MediaFile();
        mediaFile3.setId(123L);
        mediaFile3.setImageUrl("https://example.org/example");
        mediaFile3.setName("Name");
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
        post3.setText("Text");
        post3.setUser(user5);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post3);
        postList.add(post1);
        List<Post> actualSortPostsByDateResult = postService.sortPostsByDate(postList);
        assertSame(postList, actualSortPostsByDateResult);
        assertEquals(2, actualSortPostsByDateResult.size());
    }

    /**
     * Method under test: {@link PostService#sortPostsByDate(List)}
     */
    @Test
    void testSortPostsByDate3() {
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

        MediaFile mediaFile2 = new MediaFile();
        mediaFile2.setId(123L);
        mediaFile2.setImageUrl("https://example.org/example");
        mediaFile2.setName("Name");
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

        MediaFile mediaFile3 = new MediaFile();
        mediaFile3.setId(123L);
        mediaFile3.setImageUrl("https://example.org/example");
        mediaFile3.setName("Name");
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
        post3.setText("Text");
        post3.setUser(user5);

        MediaFile mediaFile4 = new MediaFile();
        mediaFile4.setId(123L);
        mediaFile4.setImageUrl("https://example.org/example");
        mediaFile4.setName("Name");
        mediaFile4.setPost(new Post());
        mediaFile4.setUser(new User());

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

        Post post4 = new Post();
        post4.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post4.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        post4.setId(123L);
        post4.setLikes(new ArrayList<>());
        post4.setMediaFile(mediaFile4);
        post4.setReplies(new ArrayList<>());
        post4.setText("Text");
        post4.setUser(user6);

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

        MediaFile mediaFile5 = new MediaFile();
        mediaFile5.setId(123L);
        mediaFile5.setImageUrl("https://example.org/example");
        mediaFile5.setName("Name");
        mediaFile5.setPost(post4);
        mediaFile5.setUser(user7);

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
        post5.setMediaFile(mediaFile5);
        post5.setReplies(new ArrayList<>());
        post5.setText("Text");
        post5.setUser(user8);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post5);
        postList.add(post3);
        postList.add(post1);
        List<Post> actualSortPostsByDateResult = postService.sortPostsByDate(postList);
        assertSame(postList, actualSortPostsByDateResult);
        assertEquals(3, actualSortPostsByDateResult.size());
    }

    /**
     * Method under test: {@link PostService#checkPostsByPrincipal(List, User)}
     */
    @Test
    void testCheckPostsByPrincipal() {
        ArrayList<Post> posts = new ArrayList<>();

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
        assertTrue(postService.checkPostsByPrincipal(posts, user).isEmpty());
    }

    /**
     * Method under test: {@link PostService#checkPostsByPrincipal(List, User)}
     */
    @Test
    void testCheckPostsByPrincipal2() {
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
        user3.setPosts(new ArrayList<>());
        user3.setRoles(new HashSet<>());
        user3.setStars(new ArrayList<>());
        user3.setUsername("janedoe");
        List<Boolean> actualCheckPostsByPrincipalResult = postService.checkPostsByPrincipal(postList, user3);
        assertEquals(1, actualCheckPostsByPrincipalResult.size());
        assertFalse(actualCheckPostsByPrincipalResult.get(0));
    }

    /**
     * Method under test: {@link PostService#checkPostByPrincipal(long, User)}
     */
    @Test
    void testCheckPostByPrincipal() {
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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("Name");
        mediaFile1.setPost(post1);
        mediaFile1.setUser(user2);

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
        post2.setMediaFile(mediaFile1);
        post2.setReplies(new ArrayList<>());
        post2.setText("Text");
        post2.setUser(user3);
        when(postRepository.findById(anyLong())).thenReturn(post2);

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
        assertFalse(postService.checkPostByPrincipal(1L, user4));
        verify(postRepository).findById(anyLong());
    }

    /**
     * Method under test: {@link PostService#checkPostByPrincipal(long, User)}
     */
    @Test
    void testCheckPostByPrincipal2() {
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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("Name");
        mediaFile1.setPost(post1);
        mediaFile1.setUser(user2);

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
        Post post2 = mock(Post.class);
        when(post2.getLikes()).thenReturn(new ArrayList<>());
        doNothing().when(post2).setComments((List<Comment>) any());
        doNothing().when(post2).setDate((Date) any());
        doNothing().when(post2).setId(anyLong());
        doNothing().when(post2).setLikes((List<PostLike>) any());
        doNothing().when(post2).setMediaFile((MediaFile) any());
        doNothing().when(post2).setReplies((List<Reply>) any());
        doNothing().when(post2).setText((String) any());
        doNothing().when(post2).setUser((User) any());
        post2.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post2.setDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        post2.setId(123L);
        post2.setLikes(new ArrayList<>());
        post2.setMediaFile(mediaFile1);
        post2.setReplies(new ArrayList<>());
        post2.setText("Text");
        post2.setUser(user3);
        when(postRepository.findById(anyLong())).thenReturn(post2);

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
        assertFalse(postService.checkPostByPrincipal(1L, user4));
        verify(postRepository).findById(anyLong());
        verify(post2).getLikes();
        verify(post2).setComments((List<Comment>) any());
        verify(post2).setDate((Date) any());
        verify(post2).setId(anyLong());
        verify(post2).setLikes((List<PostLike>) any());
        verify(post2).setMediaFile((MediaFile) any());
        verify(post2).setReplies((List<Reply>) any());
        verify(post2).setText((String) any());
        verify(post2).setUser((User) any());
    }

    /**
     * Method under test: {@link PostService#checkPostByPrincipal(long, User)}
     */
    @Test
    void testCheckPostByPrincipal3() {
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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("Name");
        mediaFile1.setPost(post1);
        mediaFile1.setUser(user2);

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
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post3.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
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

        PostLike postLike = new PostLike();
        postLike.setId(123L);
        postLike.setPost(post3);
        postLike.setUser(user6);

        ArrayList<PostLike> postLikeList = new ArrayList<>();
        postLikeList.add(postLike);
        Post post4 = mock(Post.class);
        when(post4.getLikes()).thenReturn(postLikeList);
        doNothing().when(post4).setComments((List<Comment>) any());
        doNothing().when(post4).setDate((Date) any());
        doNothing().when(post4).setId(anyLong());
        doNothing().when(post4).setLikes((List<PostLike>) any());
        doNothing().when(post4).setMediaFile((MediaFile) any());
        doNothing().when(post4).setReplies((List<Reply>) any());
        doNothing().when(post4).setText((String) any());
        doNothing().when(post4).setUser((User) any());
        post4.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post4.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        post4.setId(123L);
        post4.setLikes(new ArrayList<>());
        post4.setMediaFile(mediaFile1);
        post4.setReplies(new ArrayList<>());
        post4.setText("Text");
        post4.setUser(user3);
        when(postRepository.findById(anyLong())).thenReturn(post4);

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
        assertTrue(postService.checkPostByPrincipal(1L, user7));
        verify(postRepository).findById(anyLong());
        verify(post4).getLikes();
        verify(post4).setComments((List<Comment>) any());
        verify(post4).setDate((Date) any());
        verify(post4).setId(anyLong());
        verify(post4).setLikes((List<PostLike>) any());
        verify(post4).setMediaFile((MediaFile) any());
        verify(post4).setReplies((List<Reply>) any());
        verify(post4).setText((String) any());
        verify(post4).setUser((User) any());
    }

    /**
     * Method under test: {@link PostService#addPost(String, User)}
     */
    @Test
    void testAddPost() throws IOException {
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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("Name");
        mediaFile1.setPost(post1);
        mediaFile1.setUser(user2);

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
        post2.setMediaFile(mediaFile1);
        post2.setReplies(new ArrayList<>());
        post2.setText("Text");
        post2.setUser(user3);
        when(postRepository.save((Post) any())).thenReturn(post2);

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
        assertSame(post2, postService.addPost("Text", user4));
        verify(postRepository).save((Post) any());
    }

    /**
     * Method under test: {@link PostService#deletePost(long)}
     */
    @Test
    void testDeletePost() {
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

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("Name");
        mediaFile1.setPost(post1);
        mediaFile1.setUser(user2);

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
        post2.setMediaFile(mediaFile1);
        post2.setReplies(new ArrayList<>());
        post2.setText("Text");
        post2.setUser(user3);
        when(postRepository.findById(anyLong())).thenReturn(post2);
        doNothing().when(postRepository).delete((Post) any());
        postService.deletePost(1L);
        verify(postRepository).findById(anyLong());
        verify(postRepository).delete((Post) any());
        assertTrue(postService.findAllPosts().isEmpty());
    }
}

