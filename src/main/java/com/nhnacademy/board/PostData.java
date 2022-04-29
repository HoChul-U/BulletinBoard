package com.nhnacademy.board;

import java.time.LocalDateTime;

public class PostData implements Post{
    private LocalDateTime writeTime;
    private  String title;
    private String context;
    private String writerUserId;
    private long id;
    private int viewCount;

    public PostData(LocalDateTime writeTime, String title, String context,
                    String writerUserId, long id, int viewCount) {
        this.writeTime = writeTime;
        this.title = title;
        this.context = context;
        this.writerUserId = writerUserId;
        this.id = id;
        this.viewCount = viewCount;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getContent() {
        return this.context;
    }

    @Override
    public void setContent(String content) {
        this.context = content;
    }

    @Override
    public String getWriterUserId() {
        return this.writerUserId;
    }

    @Override
    public void setWriterUserId(String writerUserId) {
        this.writerUserId = writerUserId;
    }

    @Override
    public LocalDateTime getWriteTime() {
        return this.writeTime;
    }

    @Override
    public void setWriteTime(LocalDateTime writeTime) {
        this.writeTime = writeTime;
    }

    @Override
    public int getViewCount() {
        return this.viewCount;
    }

    @Override
    public void increaseViewCount() {
        this.viewCount++;
    }
}
