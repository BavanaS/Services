package com.quinbay.InventoryService.dao.api;

import com.quinbay.InventoryService.model.entity.Category;
import com.quinbay.InventoryService.model.entity.Products;
import com.quinbay.InventoryService.model.vo.CategoryVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Override
    List<Category> findAll();

    @Override
    Category save(Category product);

}
