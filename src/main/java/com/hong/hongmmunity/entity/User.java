package com.hong.hongmmunity.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userGender;

    @Column(nullable = false)
    private String userStudentId;

    @Column
    private String userPhoneNumber;

    @Column(nullable = false)
    private String userGrade;
    // default UserGrade.MEMBER
    // admin -> UserGrade.ADMIN

    @Builder
    public User(Long userId, String userEmail, String userPassword, String userName, String userGender, String userStudentId, String userPhoneNumber, String userGrade) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userGender = userGender;
        this.userStudentId = userStudentId;
        this.userPhoneNumber = userPhoneNumber;
        this.userGrade = userGrade;
    }

    public void setUserPhoneNumber(String userPhoneNumber){
        this.userPhoneNumber = userPhoneNumber;
    }
}
