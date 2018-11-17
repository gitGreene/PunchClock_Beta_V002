package co.codemaestro.punchclockv002;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TimeDataDao {

    @Query("SELECT * FROM timeData")
    List<TimeData> getAllData();

    @Insert
    void insertAll(TimeData... timeDatas);

//    @Insert
//    void insertCategory(String category);


    // Currently unused
    @Query("DELETE FROM timeData")
    void nukeTable();

}
