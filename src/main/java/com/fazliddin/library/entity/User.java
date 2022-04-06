package com.fazliddin.library.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

public class User {
    @Id
    private Integer id;

    private String name;
}
