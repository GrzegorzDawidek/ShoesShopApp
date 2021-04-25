package webapplication.ShoesShopApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webapplication.ShoesShopApp.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    @Query("select r.name from Role r" +
            " where r.name = ?1")
    Role findByName(String name);


    Role findById(long id);

}
