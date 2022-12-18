package com.maxmlv.responserthyme.services;

import com.maxmlv.responserthyme.models.Post;
import com.maxmlv.responserthyme.models.PostLike;
import com.maxmlv.responserthyme.models.User;
import com.maxmlv.responserthyme.repositories.PostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostLikeService {
    @Autowired
    private PostLikeRepository postLikeRepository;

    public PostLike findLikeByPostAndUser(Post post, User user) {
        return postLikeRepository.findByPostAndUser(post, user);
    }

    public List<PostLike> findAllByUser(User user) {
        return postLikeRepository.findAllByUser(user);
    }

    public PostLike addLike(Post post, User user) {
        if (findLikeByPostAndUser(post, user) == null) {
            PostLike like = new PostLike(post, user);
            return postLikeRepository.save(like);
        }
        return null;
    }

    @Transactional
    public void deleteLike(Post post, User user) {
        postLikeRepository.deleteByPostAndUser(post, user);
    }

    @Transactional
    public void deleteAllByPost(Post post) {
        postLikeRepository.deleteAllByPost(post);
    }
}
