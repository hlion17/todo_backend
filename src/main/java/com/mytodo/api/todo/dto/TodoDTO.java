package com.mytodo.api.todo.dto;

import com.mytodo.api.todo.entity.constant.TodoStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoDTO {
    private int todoId;
    private String content;
    private TodoStatus todoStus;
    private LocalDateTime todoEntrTime;
    private LocalDateTime deadLine;

    public boolean isDone() {
        return TodoStatus.DONE == this.todoStus;
    }

}
