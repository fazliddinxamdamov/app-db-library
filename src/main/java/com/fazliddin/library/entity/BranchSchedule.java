package com.fazliddin.library.entity;

import com.fazliddin.library.enums.WeekdaysNameEnum;
import com.fazliddin.library.template.AbstractLong;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "branch_schedule")
@SQLDelete(sql = "update branch_schedule set deleted=true where id=?")
@Where(clause = "deleted=false")
public class BranchSchedule extends AbstractLong {

    @Column(name = "week_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private WeekdaysNameEnum weekdaysNameEnum;

    @Column(name = "start_time", nullable = false)
    private Time startTime;

    @Column(name = "end_time", nullable = false)
    private Time endTime;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    @ToString.Exclude
    private Branch branch;
}
