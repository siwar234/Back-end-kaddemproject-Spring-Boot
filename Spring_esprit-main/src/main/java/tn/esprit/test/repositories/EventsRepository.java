package tn.esprit.test.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.test.entity.Events;

import java.util.List;

public interface EventsRepository extends JpaRepository<Events, Long>{
    @Query(value = "select * from Events e where  e.type like %:keyword%  " ,nativeQuery = true)
    List<Events> search(@Param("keyword") String keyword);
}
