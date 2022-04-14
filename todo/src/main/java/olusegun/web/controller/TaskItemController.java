package olusegun.web.controller;

//import olusegun.todo.data.repository.*;
import olusegun.data.model.TaskItem;
import olusegun.data.repository.TaskItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
public class TaskItemController {

    private static final String ERROR_MESSAGE= "task does not exists";

    @Autowired
    private TaskItemRepository taskItemRepository;

    @PostMapping(path = "/add")
    public TaskItem addTask(@Valid @RequestBody TaskItem taskitem){
        return taskItemRepository.save(taskitem);
    }

    @GetMapping
    public List<TaskItem> getTasks(){
        return  taskItemRepository.findAll();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id){
        boolean taskExist= taskItemRepository.existsById(id);
        if(taskExist) {
            TaskItem task = taskItemRepository.getById(id);
            boolean done = task.isDone();
            task.setDone(!done);
            taskItemRepository.save(task);
            return new ResponseEntity("The task updated", HttpStatus.OK);
        } else  {
            return new ResponseEntity("The task does not exist", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        try {
            boolean taskExist = taskItemRepository.existsById(id);
            if(taskExist) taskItemRepository.deleteById(id);
                return new ResponseEntity("task deleted", HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format(ERROR_MESSAGE, e.getMessage()));
//            return new ResponseEntity("task not exist", HttpStatus.BAD_REQUEST);
        }
    }
}