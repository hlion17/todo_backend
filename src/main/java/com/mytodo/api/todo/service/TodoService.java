package com.mytodo.api.todo.service;

import com.mytodo.api.constant.TodoConstant;
import com.mytodo.api.todo.dto.TodoDTO;
import com.mytodo.api.todo.dto.mapper.TodoMapper;
import com.mytodo.api.todo.entity.TodoEntity;
import com.mytodo.api.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public void saveTodo(TodoDTO todoDTO) {
        todoDTO.setTodoEntrTime(LocalDateTime.now());
        todoRepository.save(todoMapper.toTodoEntity(todoDTO));
    }

    public TodoDTO retrieveTodo(int todoId) {
        Optional<TodoEntity> todoEntityOpt = todoRepository.findById(todoId);
        return todoEntityOpt.map(todoMapper::toTodoDto)
                            .orElse(null);
    }

    public List<TodoDTO> retrieveTodoList() {
        return todoMapper.toTodoDodoList(todoRepository.findAll());
    }
}
