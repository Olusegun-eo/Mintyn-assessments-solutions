package olusegun.data.repository;

import olusegun.data.model.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {

}
