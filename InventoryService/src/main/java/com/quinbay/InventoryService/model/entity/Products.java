package com.quinbay.InventoryService.model.entity;

import com.quinbay.InventoryService.model.constant.FieldNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name=FieldNames.PRODUCT_T)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products
{
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Id
    @Column(name = FieldNames.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = FieldNames.NAME, nullable = false)
    private String name;

    @Column(name = FieldNames.PRICE, nullable = false)
    private String price;

    @Column(name = FieldNames.QUANTITY, nullable = false)
    private String quantity;

    @ManyToOne
    @JoinColumn(name=FieldNames.CATEGORY_ID, nullable=false)
    private Category category;
}
