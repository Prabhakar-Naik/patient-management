package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validator.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * @author prabhakar, @Date 18-03-2025
 */

public class PatientRequestDTO {
    @NotBlank(message = "firstName is required")
    @Size(max = 100, message = "firstName cannot exceed 100 characters")
    private String firstName;

    @NotBlank(message = "lastName is required")
    @Size(max = 100, message = "lastName cannot exceed 100 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "phoneNumber is required")
    @Size(min = 10, max = 12, message = "phoneNumber cannot exceed 10-12 characters")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Date of birth is required")
    private String dateOfBirth;

//    @NotBlank(groups = CreatePatientValidationGroup.class, message =
//            "registrationDate date is required")
    private LocalDate registrationDate;



    public @NotBlank(message = "firstName is required") @Size(max = 100, message = "firstName cannot exceed 100 characters") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "firstName is required") @Size(max = 100, message = "firstName cannot exceed 100 characters") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "lastName is required") @Size(max = 100, message = "lastName cannot exceed 100 characters") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "lastName is required") @Size(max = 100, message = "lastName cannot exceed 100 characters") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "phoneNumber is required") @Size(min = 10, max = 12, message = "phoneNumber cannot exceed 10-12 characters") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotBlank(message = "phoneNumber is required") @Size(min = 10, max = 12, message = "phoneNumber cannot exceed 10-12 characters") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotBlank(message = "Address is required") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address is required") String address) {
        this.address = address;
    }

    public @NotBlank(message = "Gender is required") String getGender() {
        return gender;
    }

    public void setGender(@NotBlank(message = "Gender is required") String gender) {
        this.gender = gender;
    }

    public @NotBlank(message = "Date of birth is required") String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotBlank(message = "Date of birth is required") String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public /*@NotBlank(groups = CreatePatientValidationGroup.class, message =
            "registrationDate date is required")*/ LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(/*@NotBlank(groups = CreatePatientValidationGroup.class, message =
            "registrationDate date is required")*/ LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
