package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractUUID;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:25
 * @project app-fast-food
 */

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update address set deleted = false where id = ?")
public class Address extends AbstractUUID {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @ManyToOne(optional = false)
    @JoinColumn(name = "district_id")
    private District district;
}
