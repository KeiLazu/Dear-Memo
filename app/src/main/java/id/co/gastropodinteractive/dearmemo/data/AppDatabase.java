package id.co.gastropodinteractive.dearmemo.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import id.co.gastropodinteractive.dearmemo.data.todolist.MemoDao;
import id.co.gastropodinteractive.dearmemo.data.todolist.MemoModel;

/**
 * Created by Kei Lazu on 9/8/2018
 * check https://github.com/KeiLazu for more
 */
@Database(entities = {MemoModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MemoDao memoDao();

}
