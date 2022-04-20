package com.fazliddin.library.payload;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fazliddin.library.entity.Attachment;
import com.fazliddin.library.entity.Role;
import com.fazliddin.library.enums.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

/**
 * @author Fazliddin Xamdamoc
 * @since 18.04.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {
    private UUID id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private Set<String> authorities;

    private LanguageEnum language;

    private DistrictDTO district;

    private Date birthDate;

    private Attachment photo;

    private Role role;

    private double confidenceRate;

    private boolean active = true;

    private Double lat;

    private Double lon;
}
