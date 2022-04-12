package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractUUID;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:54
 * @project app-fast-food
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "recommended")
@SQLDelete(sql = "update recommended set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Recommended extends AbstractUUID {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "from_category_id")
    private Category fromCategory;          //  todo taklif qilingan ichimlik yo boshqa mahsulot

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "to_category_id")    // todo hotdogni tanlasa
    private Category toCategory;
}
