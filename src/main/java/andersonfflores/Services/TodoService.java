package andersonfflores.Services;

import andersonfflores.Models.Todo;
import andersonfflores.Repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Iterable<Todo> findByUserId(UUID userId) {
        return todoRepository.findAllTodosByUserId(userId);
    }


    public Optional<Todo> findById(UUID id) {
        return todoRepository.findById(id);
    }

    public Todo update(UUID id,Todo todo) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo updatedTodo = optionalTodo.get();
            updatedTodo.setTitle(todo.getTitle());
            updatedTodo.setDescription(todo.getDescription());
            return updatedTodo;
        }
        return null;
    }

    public void delete(UUID id) {
        todoRepository.deleteById(id);
    }
}
