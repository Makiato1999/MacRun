package com.course.project.challengecenter.port;

import com.course.project.challengecenter.business.entity.Badges;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BadgeRepo extends JpaRepository<Badges, Long> {

    List<Badges> findByUserId(Long userId);

}