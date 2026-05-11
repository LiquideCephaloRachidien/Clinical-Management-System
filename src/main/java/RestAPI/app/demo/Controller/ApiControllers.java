package RestAPI.app.demo.Controller;

import java.util.List;
import RestAPI.app.demo.Models.User;
import RestAPI.app.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Hello World";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUsers(@RequestBody User user){
        userRepo.save(user);
        return "Saved...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepo.save(updatedUser);
        return "Updated";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "delete user with the id " + id;
    }
}
