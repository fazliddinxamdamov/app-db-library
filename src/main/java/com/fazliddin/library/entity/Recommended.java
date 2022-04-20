package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractUUID;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:54
 * @project app-fast-food
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
//@RequiredArgsConstructor
@Entity(name = "recommended")
@SQLDelete(sql = "update recommended set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Recommended extends AbstractUUID {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "from_category_id")
    @ToString.Exclude
    private Category fromCategory;          //  todo taklif qilingan ichimlik yo boshqa mahsulot

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "to_category_id")
    @ToString.Exclude    // todo hotdogni tanlasa
    private Category toCategory;

    public Recommended(UUID id, Category fromCategory, Category toCategory) {
        super(id);
        this.fromCategory = fromCategory;
        this.toCategory = toCategory;
    }

    public Recommended(Category fromCategory, Category toCategory) {
        this.fromCategory = fromCategory;
        this.toCategory = toCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Recommended that = (Recommended) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
