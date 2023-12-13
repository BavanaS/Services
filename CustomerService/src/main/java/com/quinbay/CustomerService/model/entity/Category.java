package com.quinbay.CustomerService.model.entity;
import com.quinbay.CustomerService.model.constant.FieldNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name=FieldNames.CATEGORY_T)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category
{
    @Id
    @Column(name=FieldNames.CATEGORY_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(name=FieldNames.CATEGORY_NAME, nullable=false)
    private String category_name;
}
