package com.example.personalize.model.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RecommendationsVo {

    private Long id;

    private Long customerId;

    private Long productId;
}
