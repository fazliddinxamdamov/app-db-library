package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractUUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:46
 * @project app-fast-food
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "order_product")
@SQLDelete(sql = "update order_product set deleted=true where id=?")
@Where(clause = "deleted=false")
public class OrderProduct extends AbstractUUID {

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
