package id.co.gastropodinteractive.dearmemo.data.todolist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Kei Lazu on 9/8/2018
 * check https://github.com/KeiLazu for more
 */

@Dao
public interface MemoDao {
    @Query("SELECT * FROM memo")
    List<MemoModel> getAllMemo();

    @Insert
    void postMemo(MemoModel memoModel);

    @Update
    void putMemo(MemoModel memoModel);

    @Delete
    void deleteMemo(MemoModel memoModel);
}
