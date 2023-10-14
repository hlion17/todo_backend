package com.mytodo.api.todo.service;

import com.mytodo.api.todo.dto.TodoDTO;
import com.mytodo.api.todo.dto.TodoUpdateDTO;
import com.mytodo.api.todo.dto.mapper.TodoMapper;
import com.mytodo.api.todo.entity.TodoEntity;
import com.mytodo.api.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    public void deleteTodo(int todoId) {
        Optional<TodoEntity> delTargetTodoEntityOpt = todoRepository.findById(todoId);
        if (delTargetTodoEntityOpt.isPresent()) {
            todoRepository.delete(delTargetTodoEntityOpt.get());
        } else {
            throw new IllegalArgumentException("투두 정보를 찾을 수 없습니다.");
        }
    }

    public void updateTodo(int todoId, TodoUpdateDTO todoUpdateRequest) {
        Optional<TodoEntity> foundTotoEntityOpt = todoRepository.findById(todoId);
        if (foundTotoEntityOpt.isPresent()) {
            TodoEntity todoEntity = foundTotoEntityOpt.get();
            todoEntity.updateTodo(todoUpdateRequest);
        } else {
            throw new IllegalArgumentException("투두 정보를 찾을 수 없습니다.");
        }
    }
}
