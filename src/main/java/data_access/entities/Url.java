package data_access.entities;

import javax.persistence.*;

/**
 * Created by Андрей on 02.10.2016.
 */
@Entity
@Table(name = "url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idUrl;

    @Column
    private String url;

    public int getIdUrl() {
        return idUrl;
    }

    public void setIdUrl(int idUrl) {
        this.idUrl = idUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
