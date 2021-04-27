package webapplication.ShoesShopApp.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webapplication.ShoesShopApp.model.Role;
import webapplication.ShoesShopApp.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl {

    @Autowired
    private RoleRepository roleRepository;

    public void save(Role role) {roleRepository.save(role);}
}
