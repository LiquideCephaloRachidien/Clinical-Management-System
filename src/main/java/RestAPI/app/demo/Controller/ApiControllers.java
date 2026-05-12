package RestAPI.app.demo.Controller;

import java.util.List;
import RestAPI.app.demo.Models.Patient;
import RestAPI.app.demo.Repo.PatientRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ApiControllers {

    @Autowired
    private PatientRepo patientRepo;
    

    @GetMapping(value = "/patients")
    public List<Patient> getPatient(){
        return patientRepo.findAll();
    }


    @PostMapping(value = "/save")
    public String savePatient(@RequestBody Patient patient){
        patientRepo.save(patient);
        return "Patient logged";
    }



    @PutMapping(value = "/update/{id}")
    public String updatePatient(@PathVariable long id, @RequestBody Patient patient){
        Patient updatedPatient = patientRepo.findById(id).get();
        updatedPatient.setFirstName(patient.getFirstName());
        updatedPatient.setLastName(patient.getLastName());
        updatedPatient.setAge(patient.getAge());
        updatedPatient.setGender(patient.getGender());
        updatedPatient.setPreviousMedId(patient.getPreviousMedId());
        updatedPatient.setChiefComplaint(patient.getChiefComplaint());
        updatedPatient.setDiagnosedIllness(patient.getDiagnosedIllness());
        updatedPatient.setPrescribedMedId(patient.getPrescribedMedId());

        patientRepo.save(updatedPatient);
        return "Patient updated";
    }


   

    @DeleteMapping (value = "/delete/{id}")
    public String deletePatient (@PathVariable long id){
        Patient deletePatient = patientRepo.findById(id).get();
        patientRepo.delete(deletePatient);
        return "user with id " + id + " deleted";
    }

}
