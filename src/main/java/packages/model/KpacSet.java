package packages.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "kPacSet")
public class KpacSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "kPacSet_kPac",
            joinColumns = @JoinColumn(name = "kPacSet_id"),
            inverseJoinColumns = @JoinColumn(name = "kPac_id"))
    private List<Kpac> kpacs;

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

    public List<Kpac> getKPacs() {
        return kpacs;
    }

    public void setKPacs(List<Kpac> kpacs) {
        this.kpacs = kpacs;
    }

    @Override
    public String toString() {
        return "KPacSet{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", kPacs=" + kpacs + '}';
    }
}
