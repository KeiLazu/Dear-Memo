package id.co.gastropodinteractive.dearmemo.data.asynctodoilst;

import android.os.AsyncTask;

import id.co.gastropodinteractive.dearmemo.data.AppDatabase;
import id.co.gastropodinteractive.dearmemo.data.todolist.MemoModel;

/**
 * Created by Kei Lazu on 9/9/2018
 * check https://github.com/KeiLazu for more
 */
public class AsyncTaskPostMemo extends AsyncTask<Void, Void, Void> {

    private AppDatabase db;
    private MemoModel todolistModel;

    public AsyncTaskPostMemo(AppDatabase db, MemoModel todolistModel) {
        this.db = db;
        this.todolistModel = todolistModel;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        db.memoDao().postMemo(todolistModel);
        return null;
    }
}
