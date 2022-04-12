package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractLong;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:28
 * @project app-fast-food
 */

@Entity
@Table(name = "branch")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update region set deleted = false where id = ?")
public class Branch extends AbstractLong {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "max_delivery_distance", nullable = false)
    private Integer maxDeliveryDistance;

    @Column(name = "max_delivery_time", nullable = false)
    private Integer maxDeliveryTime;

    @Column(name = "auto_distribution")
    private boolean autoDistribution;

    @Column(name = "active")
    private boolean active;
}
