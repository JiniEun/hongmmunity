package com.hong.hongmmunity.repository;

import com.hong.hongmmunity.entity.Community;
import com.hong.hongmmunity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    Community findCommunityByUser(User user);

    //Long deleteBy(Community community);

    // Boolean existsByUserEmail(String email);
}
