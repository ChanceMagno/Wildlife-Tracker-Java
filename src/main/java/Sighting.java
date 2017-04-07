import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.DateFormat;
import java.util.Date;
import java.sql.Timestamp;

public class Sighting implements DatabaseManagement {
  private int animal_id;
  private String location;
  private String ranger_name;
  private int id;
  private Timestamp time_reported;
  private String sex;
  private String type_of_sighting;



  public Sighting(int animal_id, String location, String ranger_name, String sex, String type_of_sighting) {
    this.animal_id = animal_id;
    this.location = location;
    this.ranger_name = ranger_name;
    this.sex = sex;
    this.type_of_sighting = type_of_sighting;
    this.id = id;
  }

  public String getTypeofSighting() {
    return type_of_sighting;
  }

  public String getSex() {
    return sex;
  }

  public Timestamp getTimeReported() {
    return time_reported;
  }

  public int getId() {
    return id;
  }

  public int getAnimalId() {
    return animal_id;
  }

  public String getLocation() {
    return location;
  }

  public String getRangerName() {
    return ranger_name;
  }

  @Override
  public boolean equals(Object otherSighting) {
    if(!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getAnimalId() == (newSighting.getAnimalId()) && this.getLocation().equals(newSighting.getLocation()) && this.getRangerName().equals(newSighting.getRangerName()) && this.getSex().equals(newSighting.getSex()) && this.getTypeofSighting().equals(newSighting.getTypeofSighting());
    }
  }

  @Override
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (animal_id, location, ranger_name, sex, type_of_sighting, time_reported) VALUES (:animal_id, :location, :ranger_name, :sex, :type_of_sighting, now());";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("animal_id", this.animal_id)
        .addParameter("location", this.location)
        .addParameter("ranger_name", this.ranger_name)
        .addParameter("sex", this.sex)
        .addParameter("type_of_sighting", this.type_of_sighting)
        .throwOnMappingFailure(false)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Sighting> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings;";
      return con.createQuery(sql)
        .throwOnMappingFailure(false)
        .executeAndFetch(Sighting.class);
    }
  }

  public static Sighting find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE id=:id;";
      Sighting sighting = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Sighting.class);
      return sighting;
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public static List<Sighting> mostSightings() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings ORDER BY time_reported DESC;";
      return con.createQuery(sql)
        .executeAndFetch(Sighting.class);
    }
  }

}
