package swd.backend.plannerapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;	//Suunnitellun tapahtuman otsikko
	private String type;	//tapahtuman tyyppi (esim. kokous, auton katsastus, lääkäri...)
	private String desc;	//mahdollisia lisätietoja tapahtumaa koskien
	private String duetime; //make this a date object
	private boolean priority; //mahdollisuus listata tärkeimmät asiat erikseen
	
	public Plan() {
	}
	
	public Plan(String title, String type, String desc, String duetime) {
		this.title = title;
		this.type = type;
		this.desc = desc;
		this.duetime = duetime;
		this.priority = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDuetime() {
		return duetime;
	}

	public void setDuetime(String duetime) {
		this.duetime = duetime;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", title=" + title + ", type=" + type + ", desc=" + desc + ", duetime=" + duetime
				+ ", priority=" + priority + "]";
	}

	
}
