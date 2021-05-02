package webapplication.ShoesShopApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webapplication.ShoesShopApp.model.Attribute;
import webapplication.ShoesShopApp.model.Category;
import webapplication.ShoesShopApp.model.Product;
import webapplication.ShoesShopApp.service.attribute.AttributeServiceImpl;
import webapplication.ShoesShopApp.service.category.CategoryServiceImpl;
import webapplication.ShoesShopApp.service.product.ProductServiceImpl;

@Controller
public class ProductsController {

    @Autowired
    private ProductServiceImpl productService;


    @Autowired
    private AttributeServiceImpl attributeServiceImpl;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;


    public ProductsController(ProductServiceImpl productService,AttributeServiceImpl attributeServiceImpl, CategoryServiceImpl categoryServiceImpl) {
        this.productService = productService;
        this.attributeServiceImpl = attributeServiceImpl;
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @RequestMapping("/product")
    public String newProduct(Model model) {
        Product product = new Product();
        Category category = new Category();
        Attribute attribute = new Attribute();
        model.addAttribute("attribute", attribute);
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping("/category")
    public String newCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category";
    }

    @RequestMapping("/attribute")
    public String newAttribute(Model model) {
        Attribute attribute = new Attribute();
        model.addAttribute("attribute", attribute);
        return "attribute";
    }


    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct( @ModelAttribute("category") Category category,@ModelAttribute("product") Product product,
                              @ModelAttribute("attribute") Attribute attribute){

        categoryServiceImpl.save(category);
        attributeServiceImpl.save(attribute);
        product.setCategory(category);
        product.addAttribute(attribute);
        productService.save(product);
        return "redirect:/product";
    }

}
