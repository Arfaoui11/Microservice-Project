package iomicroservice.userdataservice.Services;

import iomicroservice.userdataservice.Entity.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);
    List<User> getAllUser();
    User getUser(Integer id);
    void deleteUser(Integer id);
    User updateUser(User user);


}
