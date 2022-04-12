package com.fazliddin.library.entity;

import com.fazliddin.library.enums.NotificationType;
import com.fazliddin.library.template.AbstractLong;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  16:36
 * @project app-fast-food
 */

@Getter
@Entity
@Table(name = "notification")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update notification set deleted = false where id = ?")
public class Notification extends AbstractLong {

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private Attachment photo;

    @Column(name = "text", columnDefinition = "text")
    private String text;

    @Column(name = "notification_type")
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;
}
