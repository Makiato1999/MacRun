package com.course.project.challengecenter.port;

import com.course.project.challengecenter.business.entity.Profile;
import com.course.project.challengecenter.dto.ScoreReq;


public interface ProfileService {


    Profile generateProfile(ScoreReq userinfo);


}
