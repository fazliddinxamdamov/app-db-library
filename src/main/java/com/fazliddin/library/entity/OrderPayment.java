package com.fazliddin.library.entity;

import com.fazliddin.library.enums.PaymentStatusEnum;
import com.fazliddin.library.template.AbstractUUID;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:40
 * @project app-fast-food
 */
@Getter
@Entity
@Table(name = "order_payment")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update order_payment set deleted = false where id = ?")
public class OrderPayment extends AbstractUUID {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_type_id")
    private PayType payType;

    @Column(name = "total_sum", nullable = false)
    private Double totalSum;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;

    private String chargeId;
}
