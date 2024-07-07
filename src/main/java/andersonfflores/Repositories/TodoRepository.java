package andersonfflores.Repositories;

import andersonfflores.Models.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends CrudRepository<Todo, UUID> {

    @Query(value = "select * from tb_todo where tb_todo.user_id = :userId",
            nativeQuery = true)
    Iterable<Todo> findAllTodosByUserId(@Param("userId") UUID ID);
}
