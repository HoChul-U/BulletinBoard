package com.nhnacademy.repository;

import com.nhnacademy.board.Post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostDataRepository implements PostRepository{
    private static final PostDataRepository post = new PostDataRepository();

    private final Map<Long, Post> postRepository = new ConcurrentHashMap<>();

    private PostDataRepository(){}

    public static PostDataRepository getInstance() {
        return post;}

    public Map<Long, Post> getPostRepository() {
        return postRepository;
    }

    @Override
    public long register(Post post) {
        postRepository.put(post.getId(),post);
        return postRepository.get(post.getId()).getId();
    }

    @Override
    public void modify(Post post) {
        if(postRepository.containsKey(post.getId())){
            postRepository.put(post.getId(), post);
        }else throw new IllegalStateException();
    }

    @Override
    public Post remove(long id) {
        return postRepository.remove(id);
    }

    @Override
    public Post getPost(long id) {
        return postRepository.get(id);
    }

    @Override
    public List<Post> getPosts() {
        return new ArrayList<>(getPostRepository().values());
    }
}
