package com.fazliddin.library.entity;

import com.fazliddin.library.enums.OrderStatusEnum;
import com.fazliddin.library.template.AbstractUUID;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:37
 * @project app-fast-food
 */
@Getter
@Entity
@Table(name = "orders")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update orders set deleted = false where id = ?")
public class Order extends AbstractUUID {

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "receive_time")
    private Timestamp receiveTime;

    @Column(name = "ready_time")
    private Integer readyTime;

    @OneToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private User courier;

    @Column(name = "delivery_price")
    private Double deliveryPrice;

    @Column(name = "total_sum", nullable = false)
    private Double totalSum;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private User client;

    @Column(name = "is_delivery")
    private boolean isDelivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id")
    private User operator;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_type_id")
    private PayType payType;
}
