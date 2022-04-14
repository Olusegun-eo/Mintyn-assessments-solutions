package olusegun.dtos.response;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
public class TaskItemResponse {
    private boolean done = false;
    @NotNull(message = "title is required")
    private String title;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
