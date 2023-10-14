package com.mytodo.api.todo.dto;

import com.mytodo.api.todo.entity.constant.TodoStatus;
import lombok.Data;

@Data
public class TodoUpdateDTO {
    private String content;
    private TodoStatus todoStus;
}
