package com.hong.hongmmunity.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "community")
public class Community extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_id")
    private Long communityId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String category;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = User.class)
    @JoinColumn(name = "user_id", updatable = false, referencedColumnName = "user_id")
    private User user;

    private int viewCnt;

   @Builder
    public Community(Long communityId, String title, String content, String category, User user, int viewCnt) {
        this.communityId = communityId;
        this.title = title;
        this.content = content;
        this.category = category;
        this.user = user;
        this.viewCnt = viewCnt;
    }

    public void update(String title, String content, String category){
       this.title = title;
       this.content = content;
       this.category = category;
    }
}