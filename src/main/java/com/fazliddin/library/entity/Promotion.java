package com.fazliddin.library.entity;

import com.fazliddin.library.enums.PromotionTypeEnum;
import com.fazliddin.library.template.AbstractLong;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:43
 * @project app-fast-food
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "promotion")
@SQLDelete(sql = "update promotion set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Promotion extends AbstractLong {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PromotionTypeEnum type;
}
