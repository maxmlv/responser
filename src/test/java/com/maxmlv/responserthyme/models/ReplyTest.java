package com.maxmlv.responserthyme.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class ReplyTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Reply#Reply()}
     *   <li>{@link Reply#setComment(Comment)}
     *   <li>{@link Reply#setDate(Date)}
     *   <li>{@link Reply#setId(long)}
     *   <li>{@link Reply#setPost(Post)}
     *   <li>{@link Reply#setText(String)}
     *   <li>{@link Reply#setUser(User)}
     *   <li>{@link Reply#getComment()}
     *   <li>{@link Reply#getDate()}
     *   <li>{@link Reply#getId()}
     *   <li>{@link Reply#getPost()}
     *   <li>{@link Reply#getText()}
     *   <li>{@link Reply#getUser()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Reply actualReply = new Reply();
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
        actualReply.setComment(comment);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant());
        actualReply.setDate(fromResult);
        actualReply.setId(123L);
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
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post2.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
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
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post3.setDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        post3.setId(123L);
        post3.setLikes(new ArrayList<>());
        post3.setMediaFile(mediaFile2);
        post3.setReplies(new ArrayList<>());
        post3.setText("Text");
        post3.setUser(user5);
        actualReply.setPost(post3);
        actualReply.setText("Text");
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
        actualReply.setUser(user6);
        assertSame(comment, actualReply.getComment());
        assertSame(fromResult, actualReply.getDate());
        assertEquals(123L, actualReply.getId());
        assertSame(post3, actualReply.getPost());
        assertEquals("Text", actualReply.getText());
        assertSame(user6, actualReply.getUser());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Reply#Reply(String, Post, User, Comment)}
     *   <li>{@link Reply#setComment(Comment)}
     *   <li>{@link Reply#setDate(Date)}
     *   <li>{@link Reply#setId(long)}
     *   <li>{@link Reply#setPost(Post)}
     *   <li>{@link Reply#setText(String)}
     *   <li>{@link Reply#setUser(User)}
     *   <li>{@link Reply#getComment()}
     *   <li>{@link Reply#getDate()}
     *   <li>{@link Reply#getId()}
     *   <li>{@link Reply#getPost()}
     *   <li>{@link Reply#getText()}
     *   <li>{@link Reply#getUser()}
     * </ul>
     */
    @Test
    void testConstructor2() {
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

        Comment comment = new Comment();
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        comment.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        comment.setId(123L);
        comment.setPost(post3);
        comment.setReplies(new ArrayList<>());
        comment.setText("Text");
        comment.setUser(user6);
        Reply actualReply = new Reply("Text", post1, user3, comment);
        Post post4 = new Post();
        post4.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post4.setDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
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
        MediaFile mediaFile3 = new MediaFile();
        mediaFile3.setId(123L);
        mediaFile3.setImageUrl("https://example.org/example");
        mediaFile3.setName("Name");
        mediaFile3.setPost(post4);
        mediaFile3.setUser(user7);
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
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post5.setDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        post5.setId(123L);
        post5.setLikes(new ArrayList<>());
        post5.setMediaFile(mediaFile3);
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
        Comment comment1 = new Comment();
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        comment1.setDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        comment1.setId(123L);
        comment1.setPost(post5);
        comment1.setReplies(new ArrayList<>());
        comment1.setText("Text");
        comment1.setUser(user9);
        actualReply.setComment(comment1);
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant());
        actualReply.setDate(fromResult);
        actualReply.setId(123L);
        MediaFile mediaFile4 = new MediaFile();
        mediaFile4.setId(123L);
        mediaFile4.setImageUrl("https://example.org/example");
        mediaFile4.setName("Name");
        mediaFile4.setPost(new Post());
        mediaFile4.setUser(new User());
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
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post6.setDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        post6.setId(123L);
        post6.setLikes(new ArrayList<>());
        post6.setMediaFile(mediaFile4);
        post6.setReplies(new ArrayList<>());
        post6.setText("Text");
        post6.setUser(user10);
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
        MediaFile mediaFile5 = new MediaFile();
        mediaFile5.setId(123L);
        mediaFile5.setImageUrl("https://example.org/example");
        mediaFile5.setName("Name");
        mediaFile5.setPost(post6);
        mediaFile5.setUser(user11);
        User user12 = new User();
        user12.setActive(true);
        user12.setConfirmPassword("iloveyou");
        user12.setFirstName("Jane");
        user12.setId(123L);
        user12.setLastName("Doe");
        user12.setLikes(new ArrayList<>());
        user12.setMediaFiles(new ArrayList<>());
        user12.setPassword("iloveyou");
        user12.setPosts(new ArrayList<>());
        user12.setRoles(new HashSet<>());
        user12.setStars(new ArrayList<>());
        user12.setUsername("janedoe");
        Post post7 = new Post();
        post7.setComments(new ArrayList<>());
        LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post7.setDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
        post7.setId(123L);
        post7.setLikes(new ArrayList<>());
        post7.setMediaFile(mediaFile5);
        post7.setReplies(new ArrayList<>());
        post7.setText("Text");
        post7.setUser(user12);
        actualReply.setPost(post7);
        actualReply.setText("Text");
        User user13 = new User();
        user13.setActive(true);
        user13.setConfirmPassword("iloveyou");
        user13.setFirstName("Jane");
        user13.setId(123L);
        user13.setLastName("Doe");
        user13.setLikes(new ArrayList<>());
        user13.setMediaFiles(new ArrayList<>());
        user13.setPassword("iloveyou");
        user13.setPosts(new ArrayList<>());
        user13.setRoles(new HashSet<>());
        user13.setStars(new ArrayList<>());
        user13.setUsername("janedoe");
        actualReply.setUser(user13);
        assertSame(comment1, actualReply.getComment());
        assertSame(fromResult, actualReply.getDate());
        assertEquals(123L, actualReply.getId());
        assertSame(post7, actualReply.getPost());
        assertEquals("Text", actualReply.getText());
        assertSame(user13, actualReply.getUser());
    }
}

