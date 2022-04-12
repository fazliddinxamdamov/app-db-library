package com.fazliddin.library.entity;

import com.fazliddin.library.template.AbstractLong;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Fazliddin Xamdamov
 * @date 12.04.2022  17:08
 * @project app-fast-food
 */
@Entity
@Table(name = "attachment_content")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update attachment_content set deleted = false where id = ?")
public class AttachmentContent extends AbstractLong {
    @Column(name = "bytes", nullable = false)
    private byte[] bytes;

    @OneToOne(optional = false)
    @JoinColumn(name = "attachment_id")
    private Attachment attachment;
}
