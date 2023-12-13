package com.example.personalize.controller;

import com.example.personalize.model.entity.vo.RecommendationsVo;
import com.example.personalize.service.PersonalizeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/httpPersonalize")

public class HttpController {

    @Autowired
    PersonalizeServiceInterface personaliseService;
//
//    public void publishMsg(@RequestBody PublishProduct prod) throws JsonProcessingException {
//        personaliseService.sendMessage(prod);
//    }

    @GetMapping("/getRecomendations")
    public List<RecommendationsVo> getRecommendations(@RequestParam(value = "customerId") long customerId ){
        return personaliseService.getRecommendations(customerId);
    }

    @PostMapping("/addRecomendation")
    public String addRecommendation(@RequestBody RecommendationsVo recommendation){
        return personaliseService.addRecommendation(recommendation);

    }



}