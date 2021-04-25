package webapplication.ShoesShopApp.service.attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webapplication.ShoesShopApp.model.Attribute;
import webapplication.ShoesShopApp.repository.AttributeRepository;

@Service
@Transactional
public class AttributeServiceImpl {

    @Autowired
    private AttributeRepository attributeRepository;

    public AttributeServiceImpl(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public void save(Attribute attribute){
        attributeRepository.save(attribute);
    }
}
