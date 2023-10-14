package com.mytodo.api.todo.entity;

import com.mytodo.api.common.AuditEntity;
import com.mytodo.api.todo.entity.constant.TodoStatus;
import com.mytodo.api.todo.dto.TodoUpdateDTO;
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
    private TodoStatus todoStus;

    private LocalDateTime deadLine;

    private LocalDateTime todoEntrTime;

    @PrePersist
    public void updateDefaultValue() {
        if (this.todoStus == null) this.todoStus = TodoStatus.CREATED;
    }

    public void updateTodo(TodoUpdateDTO update) {
        if (update == null) return;
        if (update.getContent() != null) this.content = update.getContent();
        if (update.getTodoStus() != null) this.todoStus = update.getTodoStus();
    }
}
