package com.mytodo.api.todo.controller;

import com.mytodo.api.todo.dto.TodoDTO;
import com.mytodo.api.todo.dto.TodoUpdateDTO;
import com.mytodo.api.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/{todoId}")
    public TodoDTO retrieveTodo(@PathVariable("todoId") int todoId) {
        return todoService.retrieveTodo(todoId);
    }

    @GetMapping("/all")
    public List<TodoDTO> retrieveTodoList() {
        return todoService.retrieveTodoList();
    }

    @PostMapping
    public void saveTodo(@RequestBody TodoDTO todoDTO) {
        todoService.saveTodo(todoDTO);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable("todoId") int todoId) {
        todoService.deleteTodo(todoId);
    }

    @PutMapping("/{todoId}")
    public void updateTodo(@PathVariable("todoId") int todoId, @RequestBody TodoUpdateDTO todoUpdateRequest) {
        todoService.updateTodo(todoId, todoUpdateRequest);
    }

}
