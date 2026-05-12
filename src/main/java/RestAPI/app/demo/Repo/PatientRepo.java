package RestAPI.app.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import RestAPI.app.demo.Models.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long>{
}
