package packages.dto.request;

import java.time.LocalDate;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class KpacRequestDto {
    @Size(max = 250)
    private String title;
    @Size(max = 2000)
    private String description;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate showDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }
}
