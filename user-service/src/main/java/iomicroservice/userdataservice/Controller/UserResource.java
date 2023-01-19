package iomicroservice.userdataservice.Controller;



import iomicroservice.userdataservice.Entity.User;
import iomicroservice.userdataservice.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {


    @Autowired
    private IUserService userService;

    @PostMapping("/addFomateur")
    @ResponseBody
    public User ajouterFormateur(@RequestBody User formateur)  {

       // User user1 = userService.saveUser(formateur);
       return userService.saveUser(formateur);
       // return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }

    @GetMapping("/{userid}")
    @ResponseBody
    public User getSingleUser(@PathVariable(name = "userid") Integer userid)
    {
       // User user = userService.getUser(userid);
       return userService.getUser(userid);
       // return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userid}")
    public void deleteUser( @PathVariable(name = "userid") Integer userid)
    {
        userService.deleteUser(userid);

    }

    @GetMapping()
    @ResponseBody
    public List<User> getAllUsers()
    {
        List<User> list = userService.getAllUser();
        //return ResponseEntity.ok(list);
        return list;
    }


}
