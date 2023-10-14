package com.mytodo.api.todo.controller;

import com.mytodo.api.todo.dto.TodoDTO;
import com.mytodo.api.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todo")
    public void saveTodo(@RequestBody TodoDTO todoDTO) {
        todoService.saveTodo(todoDTO);
    }

    @GetMapping("/todo/{todoId}")
    public TodoDTO retrieveTodo(@PathVariable("todoId") int todoId) {
        return todoService.retrieveTodo(todoId);
    }

    @GetMapping("/todos")
    public List<TodoDTO> retrieveTodoList() {
        return todoService.retrieveTodoList();
    }

}
