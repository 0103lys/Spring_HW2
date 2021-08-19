package com.koreait.day3.repository;

import com.koreait.day3.Day3ApplicationTests;
import com.koreait.day3.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends Day3ApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void create(){
        Category category = Category.builder()
                .type("가전")
                .title("엘지 가전")
                .regDate(LocalDateTime.now())
                .build();

        Category newCategory = categoryRepository.save(category);
    }

    @Test
    public void read() {
        /*Optional<Category> category = categoryRepository.findById(1L);
        category.ifPresent(selectCategory -> {
            System.out.println("category : " + selectCategory);
            System.out.println("type : " + selectCategory.getType());
            System.out.println("title : " + selectCategory.getTitle());
            System.out.println("update_date : " + selectCategory.getUpdateDate());
        });*/

        Optional<Category> category = categoryRepository.findByIdAndType(1L,"자동차");
        if(category != null){
            System.out.println("데이터가 존재합니다!");
        }else{
            System.out.println("데이터가 존재하지 않습니다.");
        }



    }

    @Test
    public void update() {
        Optional<Category> category = categoryRepository.findById(7L);
        category.ifPresent(selectCategory -> {
            selectCategory.setType("자동차");
            selectCategory.setTitle("현대 자동차");
            selectCategory.setUpdateDate(LocalDateTime.now());
            categoryRepository.save(selectCategory);

        });
    }

    @Test
    public void delete(){
        Optional<Category> category = categoryRepository.findById(7L);
        category.ifPresent(selectCategory->{
            categoryRepository.delete(selectCategory);
        });

        Optional<Category> deleteCategory = categoryRepository.findById(7L);
        if(deleteCategory.isPresent()){
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }

    }
}
