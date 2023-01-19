package iomicroservice.userdataservice.Services;

import iomicroservice.userdataservice.Entity.Formation;
import iomicroservice.userdataservice.Entity.User;
import iomicroservice.userdataservice.Exceptions.ResourceNotFoundException;
import iomicroservice.userdataservice.Repository.IUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepo iUserRepo;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public User saveUser(User user) {

        return iUserRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = iUserRepo.findAll();
        return users.stream().map(user ->
        {
            Formation[] usersss = restTemplate.getForObject("http://formation-data-service/formations/user/"+user.getId(), Formation[].class);
            List<Formation> userList = Arrays.stream(usersss).toList();
            user.setFormations(userList);
            return user;
        }).collect(Collectors.toList());
    }

    @Override
    public User getUser(Integer id) {
        User user =  iUserRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server !!"));

        Formation[] users = restTemplate.getForObject("http://formation-data-service/formations/user/"+user.getId(), Formation[].class);
        List<Formation> userList = Arrays.stream(users).toList();
        user.setFormations(userList);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        iUserRepo.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return iUserRepo.save(user);
    }
}
