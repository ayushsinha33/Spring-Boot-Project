package com.crmsystem.registration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name = "REGISTRATIONS")
public class UserRegistry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq_gen")
    @SequenceGenerator(name = "my_seq_gen", sequenceName = "MY_SEQ",allocationSize = 1)
    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "uidai",unique = true)
    private Long uidai;

    @Column(name = "mobile_number")
    @NotNull
    private Long mobileNumber;

    @Column(name = "pincode")
    @NotNull
    private Long pincode;

    @Column(name = "user_name")
    @NotBlank
    private String name;

    @Column(name = "user_email",unique = true)
    @NotBlank
    private String email;

    @Column(name = "user_password")
    @NotBlank
    private String password;

    @Column
    @NotBlank
    private String pan;

    @Column
    @NotBlank
    private String address1;

    @Column
    @NotBlank
    private String address2;

    @Column
    @NotBlank
    private String state;

    @Column
    @NotBlank
    private String city;



}
