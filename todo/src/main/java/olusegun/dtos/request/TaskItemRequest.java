package olusegun.dtos.request;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class TaskItemRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean done = false;
    @NotNull(message = "title is required")
    private String title;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
