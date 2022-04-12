package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractUUID;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:27
 * @project app-fast-food
 */
@Entity
@Table(name = "region")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update region set deleted = false where id = ?")
public class Region extends AbstractUUID {

    @Column(name = "name", nullable = false)
    private String name;
}
