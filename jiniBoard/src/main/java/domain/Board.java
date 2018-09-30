package domain;

import java.time.LocalDateTime;

public class Board {
    private int id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime regdate;

    public Board() {
        this.regdate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Board setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Board setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getWriter() {
        return writer;
    }

    public Board setWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Board setContent(String content) {
        this.content = content;
        return this;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

}
