package com.fazliddin.library.entity;

import com.fazliddin.library.enums.LanguageEnum;
import com.fazliddin.library.template.AbstractUUID;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Fazliddin Xamdamov
 * @date 06.04.2022  13:57
 * @project app-fast-food
 */


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update users set deleted = false where id = ?")

public class User extends AbstractUUID {

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Builder.Default
    @Column(name = "password", nullable = false)
    private String password = "1234";

    @Column(name = "additional_phone_number")
    private String additionalPhoneNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany
    private List<Address> defaultAddress;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_branch")
    private Set<Branch> branches;

    @Column(name = "github_login")
    private String githubLogin;

    @Column(name = "confidence_rate")
    private double confidenceRate;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "online", nullable = false)
    private boolean online;

    @Builder.Default
    private boolean accountNonExpired = true;
    @Builder.Default
    private boolean accountNonLocked = true;
    @Builder.Default
    private boolean credentialsNonExpired = true;
    @Builder.Default
    private boolean enabled = false;

    public User(String phoneNumber, String firstName, String lastName, District district, LanguageEnum language) {

        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.district = district;
        this.language = language;
    }

    public String getFullName(){
        return this.lastName + " " + this.firstName;
    }
}
