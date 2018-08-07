package com.thoughtworks.amawta.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "postCache")
public class PostDomain extends BaseModelDomain {
    private static final SimpleDateFormat SLUG_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

    @ManyToOne
    private UserDomain userDao;

    @Column(nullable = false)
    private String title;

    @Type(type = "text")
    private String content;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "posts_tags",
            joinColumns = {@JoinColumn(name = "post_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", nullable = false, updatable = false)}
    )
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "tagCache")
    private Set<TagDomain> tag = new HashSet<>();

    private String permalink;

    private Integer views;

    private Integer liked;

    public PostDomain() {

    }

    public PostDomain(String title, String content, Set<TagDomain> tag, String permalink) {
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.permalink = permalink;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViews() {
        return views == null ? 0 : views;
    }

    public void setPermalink(String permalink) {
        String token = permalink.toLowerCase().replace("\n", " ").replaceAll("[^a-z\\d\\s]", " ");
        this.permalink = StringUtils.arrayToDelimitedString(StringUtils.tokenizeToStringArray(token, " "), "-");
    }

    public void setIncrementViewByOne() {
        this.views += 1;
    }
}