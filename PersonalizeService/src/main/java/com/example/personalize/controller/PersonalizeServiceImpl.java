package com.example.personalize.controller;

import com.example.personalize.dao.api.RecomendationDao;
import com.example.personalize.model.entity.Recommendations;
import com.example.personalize.model.entity.vo.RecommendationsVo;
import com.example.personalize.service.PersonalizeServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personaliseService")
public class PersonalizeServiceImpl implements PersonalizeServiceInterface {

    @Autowired
    RecomendationDao recommendationsDao;

    public static final String topic="com.quinbay.product.create";

//    @Autowired
//    private KafkaTemplate<String,String> kafkaTemplate;

//    @Override
//    public void sendMessage(PublishProduct product) throws JsonProcessingException {
//        ObjectMapper objectMapper=new ObjectMapper();
//
//        kafkaTemplate.send(topic,objectMapper.writeValueAsString(product));
//
//    }

    @Override
    public List<RecommendationsVo> getRecommendations(Long customerId) {

//        try{
            List<Recommendations> productList=recommendationsDao.findAll();
            ObjectMapper objectMapper=new ObjectMapper();

            List<RecommendationsVo> recommendations= objectMapper.convertValue(productList,List.class);

            return recommendations;
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return new ArrayList<>();
    }

    @Override
    public String addRecommendation(RecommendationsVo recommendation) {
//        try{
            ObjectMapper objectMapper=new ObjectMapper();
            recommendationsDao.save(objectMapper.convertValue(recommendation, Recommendations.class));
            return "Success";
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "Unsuccessful";
    }
}
