package models;

import io.ebean.DB;
import io.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tournament extends Model {

    @Id
    public long id;
    @OneToOne(cascade = CascadeType.REMOVE, optional = false)
    public Prize first;
    @OneToOne(cascade = CascadeType.REMOVE, optional = false)
    public Prize second;
    @OneToOne(cascade = CascadeType.REMOVE, optional = false)
    public Prize third;

    public static List<Tournament> getTours() {
        return DB.find(Tournament.class).findList();
    }
}
