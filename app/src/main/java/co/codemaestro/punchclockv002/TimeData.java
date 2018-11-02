package co.codemaestro.punchclockv002;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Entity;

@Entity
public class TimeData {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "time")
    private String time;

    public TimeData(String category, String time) {
        this.category = category;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
