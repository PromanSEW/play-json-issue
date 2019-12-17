package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prize extends Model {

	@Id
	@JsonIgnore
	public long id;
	public int money;
	public int xp;
	@JsonProperty("type")
	@Column(name = "type", nullable = false)
	public String ptype;
	@Column(nullable = false)
	public String name;
	public int value;

	public Prize(int money, int xp, String type, String name, int prop) {
		this.money = money;
		this.xp = xp;
		ptype = type;
		this.name = name;
		value = prop;
		save();
	}
}
