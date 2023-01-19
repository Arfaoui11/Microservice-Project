package iomicroservice.userdataservice.Repository;


import iomicroservice.userdataservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {


}
