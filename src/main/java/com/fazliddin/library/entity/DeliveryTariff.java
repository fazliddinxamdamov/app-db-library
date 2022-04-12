package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractLong;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:52
 * @project app-fast-food
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "delivery_tariff")
@SQLDelete(sql = "update delivery_tariff set deleted=true where id=?")
@Where(clause = "deleted=false")
public class DeliveryTariff extends AbstractLong {

    @Column(name = "distance", nullable = false)
    private Double distance;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "is_minimum")
    private boolean isMinimum;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
