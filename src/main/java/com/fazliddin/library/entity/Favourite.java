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
 * @date 12.04.2022  16:50
 * @project app-fast-food
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "favourite")
@SQLDelete(sql = "update favourite set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Favourite extends AbstractUUID {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
