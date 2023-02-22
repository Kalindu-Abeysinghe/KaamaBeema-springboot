package KaamaBeemacom.example.demo.Repository;

import KaamaBeemacom.example.demo.Model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Integer> {

    @Query(value = "FROM visitor WHERE emailAddress = ?1")
    Visitor findByEmailAddress(String emailAddress);
}
