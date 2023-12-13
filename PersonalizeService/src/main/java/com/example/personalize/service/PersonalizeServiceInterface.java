package com.example.personalize.service;

import com.example.personalize.model.entity.vo.RecommendationsVo;

import java.util.List;

public interface PersonalizeServiceInterface {
        //void sendMessage(PublishProduct product) throws JsonProcessingException;
        List<RecommendationsVo> getRecommendations(Long customerId);
        String addRecommendation(RecommendationsVo recommendation);

    }
