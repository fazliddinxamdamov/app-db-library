package com.fazliddin.library.entity;

import com.fazliddin.library.enums.PermissionEnum;
import com.fazliddin.library.template.AbstractLong;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Permissions")
public class Permission extends AbstractLong {
    @Enumerated(EnumType.STRING)
    private PermissionEnum name;
}
