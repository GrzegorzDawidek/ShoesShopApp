package webapplication.ShoesShopApp.service.attribute;

import webapplication.ShoesShopApp.model.Attribute;

import java.util.List;

public interface AttributeService {

    void save(Attribute attribute);

    List<Attribute> getAllAttributes();
}
