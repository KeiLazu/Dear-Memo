package id.co.gastropodinteractive.dearmemo.data.asynctodoilst;

import android.os.AsyncTask;

import id.co.gastropodinteractive.dearmemo.data.AppDatabase;
import id.co.gastropodinteractive.dearmemo.data.todolist.MemoModel;

import java.util.List;

/**
 * Created by Kei Lazu on 9/9/2018
 * check https://github.com/KeiLazu for more
 */
public class AsyncTaskGetTodolist extends AsyncTask<Void, Void, List<MemoModel>> {

    private AppDatabase db;
    private FetchedData fetchedData;

    public AsyncTaskGetTodolist(AppDatabase db, FetchedData fetchedData) {
        this.db = db;
        this.fetchedData = fetchedData;
    }

    @Override
    protected List<MemoModel> doInBackground(Void... voids) {
        return db.memoDao().getAllMemo();
    }

    @Override
    protected void onPostExecute(List<MemoModel> todolistModels) {
        fetchedData.FetchedTodolist(todolistModels);
    }

    public interface FetchedData {
        void FetchedTodolist(List<MemoModel> todolistModels);
    }

}
