import java.time.LocalDateTime;

public class Livro {
    private Integer id;
    private String title;
    private Boolean available;
    private LocalDateTime dateRegister;
    private LocalDateTime dateRefresh;
    private Autor autor;

    public Livro(Integer id, String title, Boolean available, LocalDateTime dateRegister, LocalDateTime dateRefresh, Autor autor) {
        this.id = id;
        this.title = title;
        this.available = available;
        this.dateRegister = dateRegister;
        this.dateRefresh = dateRefresh;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDateTime dateRegister) {
        this.dateRegister = dateRegister;
    }

    public LocalDateTime getDateRefresh() {
        return dateRefresh;
    }

    public void setDateRefresh(LocalDateTime dateRefresh) {
        this.dateRefresh = dateRefresh;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
