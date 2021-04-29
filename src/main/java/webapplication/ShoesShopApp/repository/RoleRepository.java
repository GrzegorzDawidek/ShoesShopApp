package webapplication.ShoesShopApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webapplication.ShoesShopApp.model.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    @Query("select r.name from Role r" +
            " where r.name = ?1")
    Role findByName(String name);

    @Query("select r from Role r")
    List<Role> findAll();


    /*Role findById(long id);

    @Query("select distinct r.roleName from Role r " +
            " where r.roleName = ?1")
    Role findByRoleName(String name);

*/

    Role findById(long id);





}
