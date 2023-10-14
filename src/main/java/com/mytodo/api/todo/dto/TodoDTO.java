package com.mytodo.api.todo.dto;

import com.mytodo.api.constant.TodoConstant;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoDTO {
    private int todoId;
    private String content;
    private TodoConstant todoStus;
    private LocalDateTime todoEntrTime;
    private LocalDateTime deadLine;

    public boolean isDone() {
        return TodoConstant.DONE == this.todoStus;
    }

}
