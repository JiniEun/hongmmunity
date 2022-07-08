package com.hong.hongmmunity.repository;

import com.hong.hongmmunity.entity.Community;
import com.hong.hongmmunity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    List<Community> findCommunityByUser(User user);

    Community findByCommunityId(Long communityId);

    //Long deleteBy(Community community);

    // Boolean existsByUserEmail(String email);
}
