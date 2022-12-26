package tn.esprit.test.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.test.entity.Equipe;
import tn.esprit.test.entity.Etudiant;
import tn.esprit.test.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(value = "select * from users e where e.username like %:keyword% or e.email like %:keyword%" ,nativeQuery = true)
    List<User> serach(@Param("keyword") String keyword);


    @Query(value = "select * from users e ORDER BY e.username DESC " ,nativeQuery = true)
    List<User> Trier();

    Page<User> findAll(Pageable pageable);

   // public User findByusernameAndemail(String username, String email);



}
