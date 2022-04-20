package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractLong;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
//@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "category")
@SQLDelete(sql = "update category set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Category extends AbstractLong {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @ToString.Exclude
    private Category parent;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private Attachment photo;


    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    @ToString.Exclude
    private Discount discount;

    public Category(Long id, String name, Category parent, Attachment photo, Discount discount) {
        super(id);
        this.name = name;
        this.parent = parent;
        this.photo = photo;
        this.discount = discount;
    }

    public Category(String name, Category parent, Attachment photo, Discount discount) {
        this.name = name;
        this.parent = parent;
        this.photo = photo;
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return getId() != null && Objects.equals(getId(), category.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
