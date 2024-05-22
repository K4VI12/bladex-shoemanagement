package com.shoes.bladex.entity;

import com.shoes.bladex.utill.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private String code;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String proPic;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String civilStatus;
    private String designation;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Temporal(TemporalType.DATE)
    private Date joinDate;

    private String branch;
    private String addressLine1;
    private String addressLine2;
    private String contact;
    private String email;
    private String guardianName;
    private String guardianContact;


}
