package com.fazliddin.library.entity;

import com.fazliddin.library.enums.FeedBackTypeEnum;
import com.fazliddin.library.template.AbstractLong;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:51
 * @project app-fast-food
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "support")
@SQLDelete(sql = "update support set deleted=true where id=?")
@Where(clause = "deleted=false")
public class FeedBack extends AbstractLong {

    //todo FAZLIDDIN aka CRUD qilishingiz kk ekan!!! 26.01

    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private FeedBackTypeEnum type;


    @Column(name = "text", nullable = false)
    private String text;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private Attachment photo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
