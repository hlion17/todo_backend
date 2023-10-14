package com.mytodo.api.todo.entity;

import com.mytodo.api.common.AuditEntity;
import com.mytodo.api.constant.TodoConstant;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "todo")
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoId;

    private String content;

    @Enumerated(EnumType.STRING)
    private TodoConstant todoStus;

    private LocalDateTime deadLine;

    private LocalDateTime todoEnterTime;

}
