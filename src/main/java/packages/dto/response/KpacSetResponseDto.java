package packages.dto.response;

import java.util.List;

public class KpacSetResponseDto {
    private Long id;
    private String title;
    private List<Long> kpacsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getKpacsId() {
        return kpacsId;
    }

    public void setKpacsId(List<Long> kpacsId) {
        this.kpacsId = kpacsId;
    }
}
