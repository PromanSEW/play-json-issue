package models;

import io.ebean.DB;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tours")
public class Tour extends Model {

    @Id
    public long id;
    @ManyToOne(optional = false)
    public TourType tourtype;

    // ... All other fields

    public static List<Tour> getTours() {
        return DB.find(Tour.class).findList();
    }
}
