package packages.dto.request;

import java.util.List;
import javax.validation.constraints.Size;
import packages.model.Kpac;

public class KpacSetRequestDto {
    @Size(max = 250)
    private String title;
    private List<Kpac> kpacs;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Kpac> getKpacs() {
        return kpacs;
    }

    public void setKPacs(List<Kpac> kpacs) {
        this.kpacs = kpacs;
    }
}
