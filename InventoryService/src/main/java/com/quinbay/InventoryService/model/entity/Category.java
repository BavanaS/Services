package com.quinbay.InventoryService.model.entity;

import com.quinbay.InventoryService.model.constant.FieldNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name=FieldNames.CATEGORY_T)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category
{
    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Id
    @Column(name=FieldNames.CATEGORY_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(name=FieldNames.CATEGORY_NAME, nullable=false)
    private String category_name;
}
