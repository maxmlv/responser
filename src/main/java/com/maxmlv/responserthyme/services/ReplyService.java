package com.maxmlv.responserthyme.services;

import com.maxmlv.responserthyme.models.Comment;
import com.maxmlv.responserthyme.models.Post;
import com.maxmlv.responserthyme.models.Reply;
import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.repositories.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    public Reply findReplyById(long reply_id) {
        return replyRepository.findById(reply_id);
    }

    public Reply addReply(String text, Post post, User user, Comment comment) {
        Reply reply = new Reply(text, post, user, comment);
        Date date = new Date();
        reply.setDate(date);
        return replyRepository.save(reply);
    }

    public void deleteReply(long reply_id) {
        replyRepository.delete(findReplyById(reply_id));
    }

    @Transactional
    public void deleteAllRepliesByPost(Post post) {
        replyRepository.deleteAllByPost(post);
    }
}
