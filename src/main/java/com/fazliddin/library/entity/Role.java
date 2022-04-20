package com.fazliddin.library.entity;

import com.fazliddin.library.enums.RoleTypeEnum;
import com.fazliddin.library.template.AbstractLong;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Fazliddin Xamdamov
 * @date 18.04.2022  15:47
 * @project app-fast-food
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update roles set deleted = false where id = ?")
public class Role extends AbstractLong {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "role_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleTypeEnum roleType;
}
