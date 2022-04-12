package com.fazliddin.library.entity;

import com.fazliddin.library.enums.PayTypeEnum;
import com.fazliddin.library.template.AbstractLong;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:38
 * @project app-fast-food
 */
@Getter
@Entity
@Table(name = "pay_type")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update pay_type set deleted = false where id = ?")
public class PayType extends AbstractLong {

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private PayTypeEnum name;

    @Column(name = "active")
    private boolean active;

    @OneToOne(optional = false)
    @JoinColumn(name = "photo_id")
    private Attachment photo;
}
