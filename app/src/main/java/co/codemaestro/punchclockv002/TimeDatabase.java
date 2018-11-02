package co.codemaestro.punchclockv002;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {TimeData.class}, version = 1)
public abstract class TimeDatabase extends RoomDatabase {
    public abstract TimeDataDao timeDataDao();

}
