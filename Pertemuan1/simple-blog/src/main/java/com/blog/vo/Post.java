package com.blog.vo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="user")
    private String user;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="regDate")
    private Date regDate;

    @Column(name="updDate")
    private Date updDate;

    public Post() {

    }

    public Post(Long id, String user, String title, String content) {
        super();
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.regDate = new Date();
        this.updDate = new Date();
    }

    public Post(String user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.regDate = new Date();
        this.updDate = new Date();
    }

    public long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUser(){
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate){
        this.regDate = regDate;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate){
        this.updDate = updDate;
    }

}
