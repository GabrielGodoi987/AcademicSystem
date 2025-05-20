package system.academico.academicsystem.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class StandardError {
    private String message;
    private int status;
    private LocalDateTime timsestamp;
    private String path;
}
