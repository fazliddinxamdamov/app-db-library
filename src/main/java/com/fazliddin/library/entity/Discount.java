package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractLong;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:32
 * @project app-fast-food
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "discount")
@SQLDelete(sql = "update discount set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Discount extends AbstractLong {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "percent")
    private double percent;

    @Column(name = "expire_time", nullable = false)
    private Timestamp expireTime;

    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;

    @Column(name = "price")
    private Double price;

    @Column(name = "active")
    private boolean active;
}
