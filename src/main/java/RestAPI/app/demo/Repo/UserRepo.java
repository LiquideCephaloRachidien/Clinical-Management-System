package RestAPI.app.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import RestAPI.app.demo.Models.User;

public interface UserRepo extends JpaRepository<User, Long>{
}
