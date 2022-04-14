package olusegun.service.task;


import olusegun.data.repository.TaskItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskItemServiceImpl implements TaskItemService {
    @Autowired
    TaskItemRepository taskItemRepository;

}
