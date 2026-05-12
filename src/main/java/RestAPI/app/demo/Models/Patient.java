package RestAPI.app.demo.Models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;;

@Entity
@JsonPropertyOrder({ "id", "firstName", "lastName", "age", "gender", "previousMedId", "chiefComplaint", "diagnosedIllness", "prescribedMedId" })
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int age;

    @Column
    private char gender; //m for male, f for female

    @Column
    private String previousMedId; //previously taken medication by the patient 

    @Column
    private String chiefComplaint;

    @Column
    private String diagnosedIllness;

    @Column
    private String prescribedMedId; //prescribed medication by the doctor

    //i plan on linking previousMedId and prescribedMedId to the open FDA's list of drugs


    //getter and setter for id
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    //getter and setter for firstName
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    //getter and setter for lastName
    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    //getter and setter for age
    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    //getter and setter for gender
    public char getGender(){
        return gender;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    //getter and setter for previousMedId
    public String getPreviousMedId(){
        return previousMedId;
    }

    public void setPreviousMedId(String previousMedId){
        this.previousMedId = previousMedId;
    }

    //getter and setter for chiefComplaint
    public String getChiefComplaint(){
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint){
        this.chiefComplaint = chiefComplaint;
    }

    //getter and setter for diagnosed illness
    public String getDiagnosedIllness(){
        return diagnosedIllness;
    }

    public void setDiagnosedIllness(String diagnosedIllness){
        this.diagnosedIllness = diagnosedIllness;
    }

    //getter and setter for prescribed medication id
    public String getPrescribedMedId(){
        return prescribedMedId;
    }

    public void setPrescribedMedId(String prescribedMedId){
        this.prescribedMedId = prescribedMedId;
    }


}

