package olusegun.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class TaskItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean done = false;
    @NotNull(message = "title is required")
    private String title;


    @CreationTimestamp
//    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "MMMM-dddd-yyyy  HH:mm:ss")
    private LocalDateTime createdAt;

    public TaskItem() {
    }

    public TaskItem(String title, LocalDateTime createdAt) {
        this.title = title;
        this.createdAt = createdAt;
        this.done = false;
    }


}

