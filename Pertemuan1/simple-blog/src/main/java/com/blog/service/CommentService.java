package com.blog.service;

import com.blog.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.blog.repository.CommentJpaRepository;
import com.blog.vo.Comment;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentJpaRepository commentJpaRepository;

    public boolean saveComment(Comment comment){
        Comment result = commentJpaRepository.save(comment);
        boolean isSuccess = true;

        if(result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public Comment getComment(Long id) {
        Comment comment = commentJpaRepository.findOneById(id);
        return comment;
    }

    public List<Comment> getCommentList(Long postId) {
        List<Comment> comments = commentJpaRepository.findAllByPostIdOrderByRegDateDesc(postId);
        return comments;
    }

    public boolean deleteComment(Long id) {
        Comment result = commentJpaRepository.findOneById(id);

        if(result == null)
            return false;

        commentJpaRepository.deleteById(id);
        return true;
    }

    public List<Comment> searchCommentByPost(Long postId, String query) {
        List<Comment> comments = commentJpaRepository.findByPostIdAndCommentContainingOrderByRegDateDesc(postId, query);
        return comments;
    }


}
