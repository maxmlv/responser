package com.maxmlv.responserthyme.controllers.apis;

import com.maxmlv.responserthyme.models.Post;
import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import java.io.*;

@Controller
@RequestMapping("/api/post")
public class PostApiController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private MediaFileService mediaFileService;

    @Autowired
    private AwsS3Service awsS3Service;

    @PostMapping("/add")
    public String addPost(@AuthenticationPrincipal User user,
                          @RequestParam("text") String text,
                          @RequestParam("file") MultipartFile multipartFile) throws IOException {
        File file = File.createTempFile(multipartFile.getName(), ".jpg");
        Post post = postService.addPost(text, user);
        String imageKey = "";
        String imageUrl = "";
        if (!(multipartFile.isEmpty())) {
            multipartFile.transferTo(file);
            imageKey = awsS3Service.uploadObject(file);
            imageUrl = awsS3Service.getObjectUrl(imageKey);
            mediaFileService.addMediaFile(user, post, imageKey, imageUrl);
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{post_id}")
    public String delete(@PathVariable("post_id") long post_id,
                         @RequestParam("redirect") String redirect) throws IOException {
        Post post = postService.findPostById(post_id);

        if (post.getMediaFile().getName() != null)
            awsS3Service.deleteObject(post.getMediaFile().getName());
        mediaFileService.deleteByPost(post);
        replyService.deleteAllRepliesByPost(post);
        commentService.deleteAllCommentsByPost(post);
        postService.deletePost(post_id);

        return "redirect:/" + redirect;
    }
}
