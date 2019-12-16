package models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tour_types")
public class TourType extends Model {

    @Id
    public int id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public String description;
}
