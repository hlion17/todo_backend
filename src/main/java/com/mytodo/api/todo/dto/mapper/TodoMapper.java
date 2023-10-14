package com.mytodo.api.todo.dto.mapper;

import com.mytodo.api.todo.dto.TodoDTO;
import com.mytodo.api.todo.entity.TodoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoDTO toTodoDto(TodoEntity entity);
    TodoEntity toTodoEntity(TodoDTO dto);
    List<TodoDTO> toTodoDodoList(List<TodoEntity> entityList);
}
