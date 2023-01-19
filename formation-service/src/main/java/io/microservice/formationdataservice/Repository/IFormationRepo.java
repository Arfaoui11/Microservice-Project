package io.microservice.formationdataservice.Repository;




import io.microservice.formationdataservice.Entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IFormationRepo extends JpaRepository<Formation,Integer> {

    List<Formation> findByFormateurId(Integer userId);

}
