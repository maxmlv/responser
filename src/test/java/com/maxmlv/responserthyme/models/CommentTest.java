package com.maxmlv.responserthyme.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

class CommentTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Comment#Comment()}
     *   <li>{@link Comment#setDate(Date)}
     *   <li>{@link Comment#setId(long)}
     *   <li>{@link Comment#setPost(Post)}
     *   <li>{@link Comment#setReplies(List)}
     *   <li>{@link Comment#setText(String)}
     *   <li>{@link Comment#setUser(User)}
     *   <li>{@link Comment#getDate()}
     *   <li>{@link Comment#getId()}
     *   <li>{@link Comment#getPost()}
     *   <li>{@link Comment#getReplies()}
     *   <li>{@link Comment#getText()}
     *   <li>{@link Comment#getUser()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Comment actualComment = new Comment();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualComment.setDate(fromResult);
        actualComment.setId(123L);
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
        ArrayList<PostLike> postLikeList = new ArrayList<>();
        user.setLikes(postLikeList);
        ArrayList<MediaFile> mediaFileList = new ArrayList<>();
        user.setMediaFiles(mediaFileList);
        user.setPassword("iloveyou");
        ArrayList<Post> postList = new ArrayList<>();
        user.setPosts(postList);
        user.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList = new ArrayList<>();
        user.setStars(userStarList);
        user.setUsername("janedoe");
        Post post = new Post();
        ArrayList<Comment> commentList = new ArrayList<>();
        post.setComments(commentList);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        post.setId(123L);
        ArrayList<PostLike> postLikeList1 = new ArrayList<>();
        post.setLikes(postLikeList1);
        post.setMediaFile(mediaFile);
        ArrayList<Reply> replyList = new ArrayList<>();
        post.setReplies(replyList);
        post.setText("Text");
        post.setUser(user);
        User user1 = new User();
        user1.setActive(true);
        user1.setConfirmPassword("iloveyou");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        ArrayList<PostLike> postLikeList2 = new ArrayList<>();
        user1.setLikes(postLikeList2);
        ArrayList<MediaFile> mediaFileList1 = new ArrayList<>();
        user1.setMediaFiles(mediaFileList1);
        user1.setPassword("iloveyou");
        ArrayList<Post> postList1 = new ArrayList<>();
        user1.setPosts(postList1);
        user1.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList1 = new ArrayList<>();
        user1.setStars(userStarList1);
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
        ArrayList<PostLike> postLikeList3 = new ArrayList<>();
        user2.setLikes(postLikeList3);
        ArrayList<MediaFile> mediaFileList2 = new ArrayList<>();
        user2.setMediaFiles(mediaFileList2);
        user2.setPassword("iloveyou");
        ArrayList<Post> postList2 = new ArrayList<>();
        user2.setPosts(postList2);
        user2.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList2 = new ArrayList<>();
        user2.setStars(userStarList2);
        user2.setUsername("janedoe");
        Post post1 = new Post();
        ArrayList<Comment> commentList1 = new ArrayList<>();
        post1.setComments(commentList1);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post1.setDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        post1.setId(123L);
        ArrayList<PostLike> postLikeList4 = new ArrayList<>();
        post1.setLikes(postLikeList4);
        post1.setMediaFile(mediaFile1);
        ArrayList<Reply> replyList1 = new ArrayList<>();
        post1.setReplies(replyList1);
        post1.setText("Text");
        post1.setUser(user2);
        actualComment.setPost(post1);
        ArrayList<Reply> replyList2 = new ArrayList<>();
        actualComment.setReplies(replyList2);
        actualComment.setText("Text");
        User user3 = new User();
        user3.setActive(true);
        user3.setConfirmPassword("iloveyou");
        user3.setFirstName("Jane");
        user3.setId(123L);
        user3.setLastName("Doe");
        ArrayList<PostLike> postLikeList5 = new ArrayList<>();
        user3.setLikes(postLikeList5);
        ArrayList<MediaFile> mediaFileList3 = new ArrayList<>();
        user3.setMediaFiles(mediaFileList3);
        user3.setPassword("iloveyou");
        ArrayList<Post> postList3 = new ArrayList<>();
        user3.setPosts(postList3);
        user3.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList3 = new ArrayList<>();
        user3.setStars(userStarList3);
        user3.setUsername("janedoe");
        actualComment.setUser(user3);
        assertSame(fromResult, actualComment.getDate());
        assertEquals(123L, actualComment.getId());
        assertSame(post1, actualComment.getPost());
        List<Reply> replies = actualComment.getReplies();
        assertSame(replyList2, replies);
        assertEquals(commentList1, replies);
        assertEquals(postLikeList4, replies);
        assertEquals(commentList, replies);
        assertEquals(postLikeList1, replies);
        assertEquals(replyList, replies);
        assertEquals(postLikeList, replies);
        assertEquals(mediaFileList, replies);
        assertEquals(postList, replies);
        assertEquals(userStarList, replies);
        assertEquals(postLikeList2, replies);
        assertEquals(mediaFileList1, replies);
        assertEquals(postList1, replies);
        assertEquals(userStarList1, replies);
        assertEquals(replyList1, replies);
        assertEquals(postLikeList3, replies);
        assertEquals(mediaFileList2, replies);
        assertEquals(postList2, replies);
        assertEquals(userStarList2, replies);
        assertEquals(postLikeList5, replies);
        assertEquals(mediaFileList3, replies);
        assertEquals(postList3, replies);
        assertEquals(userStarList3, replies);
        assertEquals("Text", actualComment.getText());
        assertSame(user3, actualComment.getUser());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Comment#Comment(String, User, Post)}
     *   <li>{@link Comment#setDate(Date)}
     *   <li>{@link Comment#setId(long)}
     *   <li>{@link Comment#setPost(Post)}
     *   <li>{@link Comment#setReplies(List)}
     *   <li>{@link Comment#setText(String)}
     *   <li>{@link Comment#setUser(User)}
     *   <li>{@link Comment#getDate()}
     *   <li>{@link Comment#getId()}
     *   <li>{@link Comment#getPost()}
     *   <li>{@link Comment#getReplies()}
     *   <li>{@link Comment#getText()}
     *   <li>{@link Comment#getUser()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User user = new User();
        user.setActive(true);
        user.setConfirmPassword("iloveyou");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        ArrayList<PostLike> postLikeList = new ArrayList<>();
        user.setLikes(postLikeList);
        ArrayList<MediaFile> mediaFileList = new ArrayList<>();
        user.setMediaFiles(mediaFileList);
        user.setPassword("iloveyou");
        ArrayList<Post> postList = new ArrayList<>();
        user.setPosts(postList);
        user.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList = new ArrayList<>();
        user.setStars(userStarList);
        user.setUsername("janedoe");

        MediaFile mediaFile = new MediaFile();
        mediaFile.setId(123L);
        mediaFile.setImageUrl("https://example.org/example");
        mediaFile.setName("Name");
        mediaFile.setPost(new Post());
        mediaFile.setUser(new User());

        User user1 = new User();
        user1.setActive(true);
        user1.setConfirmPassword("iloveyou");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        ArrayList<PostLike> postLikeList1 = new ArrayList<>();
        user1.setLikes(postLikeList1);
        ArrayList<MediaFile> mediaFileList1 = new ArrayList<>();
        user1.setMediaFiles(mediaFileList1);
        user1.setPassword("iloveyou");
        ArrayList<Post> postList1 = new ArrayList<>();
        user1.setPosts(postList1);
        user1.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList1 = new ArrayList<>();
        user1.setStars(userStarList1);
        user1.setUsername("janedoe");

        Post post = new Post();
        ArrayList<Comment> commentList = new ArrayList<>();
        post.setComments(commentList);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        post.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        post.setId(123L);
        ArrayList<PostLike> postLikeList2 = new ArrayList<>();
        post.setLikes(postLikeList2);
        post.setMediaFile(mediaFile);
        ArrayList<Reply> replyList = new ArrayList<>();
        post.setReplies(replyList);
        post.setText("Text");
        post.setUser(user1);

        User user2 = new User();
        user2.setActive(true);
        user2.setConfirmPassword("iloveyou");
        user2.setFirstName("Jane");
        user2.setId(123L);
        user2.setLastName("Doe");
        ArrayList<PostLike> postLikeList3 = new ArrayList<>();
        user2.setLikes(postLikeList3);
        ArrayList<MediaFile> mediaFileList2 = new ArrayList<>();
        user2.setMediaFiles(mediaFileList2);
        user2.setPassword("iloveyou");
        ArrayList<Post> postList2 = new ArrayList<>();
        user2.setPosts(postList2);
        user2.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList2 = new ArrayList<>();
        user2.setStars(userStarList2);
        user2.setUsername("janedoe");

        MediaFile mediaFile1 = new MediaFile();
        mediaFile1.setId(123L);
        mediaFile1.setImageUrl("https://example.org/example");
        mediaFile1.setName("Name");
        mediaFile1.setPost(post);
        mediaFile1.setUser(user2);

        User user3 = new User();
        user3.setActive(true);
        user3.setConfirmPassword("iloveyou");
        user3.setFirstName("Jane");
        user3.setId(123L);
        user3.setLastName("Doe");
        ArrayList<PostLike> postLikeList4 = new ArrayList<>();
        user3.setLikes(postLikeList4);
        ArrayList<MediaFile> mediaFileList3 = new ArrayList<>();
        user3.setMediaFiles(mediaFileList3);
        user3.setPassword("iloveyou");
        ArrayList<Post> postList3 = new ArrayList<>();
        user3.setPosts(postList3);
        user3.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList3 = new ArrayList<>();
        user3.setStars(userStarList3);
        user3.setUsername("janedoe");

        Post post1 = new Post();
        ArrayList<Comment> commentList1 = new ArrayList<>();
        post1.setComments(commentList1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post1.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        post1.setId(123L);
        ArrayList<PostLike> postLikeList5 = new ArrayList<>();
        post1.setLikes(postLikeList5);
        post1.setMediaFile(mediaFile1);
        ArrayList<Reply> replyList1 = new ArrayList<>();
        post1.setReplies(replyList1);
        post1.setText("Text");
        post1.setUser(user3);
        Comment actualComment = new Comment("Text", user, post1);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant());
        actualComment.setDate(fromResult);
        actualComment.setId(123L);
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
        ArrayList<PostLike> postLikeList6 = new ArrayList<>();
        user4.setLikes(postLikeList6);
        ArrayList<MediaFile> mediaFileList4 = new ArrayList<>();
        user4.setMediaFiles(mediaFileList4);
        user4.setPassword("iloveyou");
        ArrayList<Post> postList4 = new ArrayList<>();
        user4.setPosts(postList4);
        user4.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList4 = new ArrayList<>();
        user4.setStars(userStarList4);
        user4.setUsername("janedoe");
        Post post2 = new Post();
        ArrayList<Comment> commentList2 = new ArrayList<>();
        post2.setComments(commentList2);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post2.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        post2.setId(123L);
        ArrayList<PostLike> postLikeList7 = new ArrayList<>();
        post2.setLikes(postLikeList7);
        post2.setMediaFile(mediaFile2);
        ArrayList<Reply> replyList2 = new ArrayList<>();
        post2.setReplies(replyList2);
        post2.setText("Text");
        post2.setUser(user4);
        User user5 = new User();
        user5.setActive(true);
        user5.setConfirmPassword("iloveyou");
        user5.setFirstName("Jane");
        user5.setId(123L);
        user5.setLastName("Doe");
        ArrayList<PostLike> postLikeList8 = new ArrayList<>();
        user5.setLikes(postLikeList8);
        ArrayList<MediaFile> mediaFileList5 = new ArrayList<>();
        user5.setMediaFiles(mediaFileList5);
        user5.setPassword("iloveyou");
        ArrayList<Post> postList5 = new ArrayList<>();
        user5.setPosts(postList5);
        user5.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList5 = new ArrayList<>();
        user5.setStars(userStarList5);
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
        ArrayList<PostLike> postLikeList9 = new ArrayList<>();
        user6.setLikes(postLikeList9);
        ArrayList<MediaFile> mediaFileList6 = new ArrayList<>();
        user6.setMediaFiles(mediaFileList6);
        user6.setPassword("iloveyou");
        ArrayList<Post> postList6 = new ArrayList<>();
        user6.setPosts(postList6);
        user6.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList6 = new ArrayList<>();
        user6.setStars(userStarList6);
        user6.setUsername("janedoe");
        Post post3 = new Post();
        ArrayList<Comment> commentList3 = new ArrayList<>();
        post3.setComments(commentList3);
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        post3.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        post3.setId(123L);
        ArrayList<PostLike> postLikeList10 = new ArrayList<>();
        post3.setLikes(postLikeList10);
        post3.setMediaFile(mediaFile3);
        ArrayList<Reply> replyList3 = new ArrayList<>();
        post3.setReplies(replyList3);
        post3.setText("Text");
        post3.setUser(user6);
        actualComment.setPost(post3);
        ArrayList<Reply> replyList4 = new ArrayList<>();
        actualComment.setReplies(replyList4);
        actualComment.setText("Text");
        User user7 = new User();
        user7.setActive(true);
        user7.setConfirmPassword("iloveyou");
        user7.setFirstName("Jane");
        user7.setId(123L);
        user7.setLastName("Doe");
        ArrayList<PostLike> postLikeList11 = new ArrayList<>();
        user7.setLikes(postLikeList11);
        ArrayList<MediaFile> mediaFileList7 = new ArrayList<>();
        user7.setMediaFiles(mediaFileList7);
        user7.setPassword("iloveyou");
        ArrayList<Post> postList7 = new ArrayList<>();
        user7.setPosts(postList7);
        user7.setRoles(new HashSet<>());
        ArrayList<UserStar> userStarList7 = new ArrayList<>();
        user7.setStars(userStarList7);
        user7.setUsername("janedoe");
        actualComment.setUser(user7);
        assertSame(fromResult, actualComment.getDate());
        assertEquals(123L, actualComment.getId());
        assertSame(post3, actualComment.getPost());
        List<Reply> replies = actualComment.getReplies();
        assertSame(replyList4, replies);
        assertEquals(postLikeList, replies);
        assertEquals(mediaFileList, replies);
        assertEquals(postList, replies);
        assertEquals(userStarList, replies);
        assertEquals(commentList1, replies);
        assertEquals(postLikeList5, replies);
        assertEquals(commentList, replies);
        assertEquals(postLikeList2, replies);
        assertEquals(replyList, replies);
        assertEquals(postLikeList1, replies);
        assertEquals(mediaFileList1, replies);
        assertEquals(postList1, replies);
        assertEquals(userStarList1, replies);
        assertEquals(postLikeList3, replies);
        assertEquals(mediaFileList2, replies);
        assertEquals(postList2, replies);
        assertEquals(userStarList2, replies);
        assertEquals(replyList1, replies);
        assertEquals(postLikeList4, replies);
        assertEquals(mediaFileList3, replies);
        assertEquals(postList3, replies);
        assertEquals(userStarList3, replies);
        assertEquals(commentList3, replies);
        assertEquals(postLikeList10, replies);
        assertEquals(commentList2, replies);
        assertEquals(postLikeList7, replies);
        assertEquals(replyList2, replies);
        assertEquals(postLikeList6, replies);
        assertEquals(mediaFileList4, replies);
        assertEquals(postList4, replies);
        assertEquals(userStarList4, replies);
        assertEquals(postLikeList8, replies);
        assertEquals(mediaFileList5, replies);
        assertEquals(postList5, replies);
        assertEquals(userStarList5, replies);
        assertEquals(replyList3, replies);
        assertEquals(postLikeList9, replies);
        assertEquals(mediaFileList6, replies);
        assertEquals(postList6, replies);
        assertEquals(userStarList6, replies);
        assertEquals(postLikeList11, replies);
        assertEquals(mediaFileList7, replies);
        assertEquals(postList7, replies);
        assertEquals(userStarList7, replies);
        assertEquals("Text", actualComment.getText());
        assertSame(user7, actualComment.getUser());
    }
}

