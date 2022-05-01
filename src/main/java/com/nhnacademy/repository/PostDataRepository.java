package com.nhnacademy.repository;

import com.nhnacademy.board.Post;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
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
        log.error(PostDataRepository.getInstance().getPostRepository().entrySet()+"");
        log.error(postRepository.get(post.getId()).getId()+"");
        return postRepository.get(post.getId()).getId();
    }

    @Override
    public void modify(Post post, long id) {
        if(postRepository.containsKey(id)){
            postRepository.remove(id);
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
