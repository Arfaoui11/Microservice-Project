package io.microservice.formationdataservice.Repository;



import io.microservice.formationdataservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {











}
