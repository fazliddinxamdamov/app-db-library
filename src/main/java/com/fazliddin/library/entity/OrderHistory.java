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
 * @date 12.04.2022  16:40
 * @project app-fast-food
 */
@Getter
@Entity
@Table(name = "order_history")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update order_history set deleted = false where id = ?")
public class OrderHistory extends AbstractUUID {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
