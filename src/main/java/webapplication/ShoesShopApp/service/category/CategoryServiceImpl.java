package webapplication.ShoesShopApp.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webapplication.ShoesShopApp.model.Category;
import webapplication.ShoesShopApp.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public void save(Category category) {
        categoryRepository.save(category);
    }
}
