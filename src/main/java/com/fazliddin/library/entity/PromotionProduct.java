package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractUUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
@Entity(name = "promotion_product")
@SQLDelete(sql = "update promotion_product set deleted=true where id=?")
@Where(clause = "deleted=false")
public class PromotionProduct extends AbstractUUID {
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderPromotion orderPromotion;

    @ManyToOne
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "group_number")
    private String groupNumber;
}
