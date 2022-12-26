package tn.esprit.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.test.entity.Contrat;
import tn.esprit.test.entity.User;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
    @Query(value = "SELECT count(*) FROM contrat c WHERE (c.datedeb > :startDate and  c.datefin < :endDate) and c.archive=1 ",
            nativeQuery = true)
    Integer nbContratsValides(@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    @Query(value = "select * from contrat e where e.datedeb like %:keyword% " ,nativeQuery = true)
    List<Contrat> serach(@Param("keyword") String keyword);



}
