package id.co.gastropodinteractive.dearmemo.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.co.gastropodinteractive.dearmemo.R;
import id.co.gastropodinteractive.dearmemo.activities.MainActivity;
import id.co.gastropodinteractive.dearmemo.adapters.TodolistAdapter;
import id.co.gastropodinteractive.dearmemo.data.AppDatabase;
import id.co.gastropodinteractive.dearmemo.data.asynctodoilst.AsyncTaskGetTodolist;
import id.co.gastropodinteractive.dearmemo.data.todolist.MemoModel;

import java.util.List;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements AsyncTaskGetTodolist.FetchedData {

    View v;
    Context context;

    AppDatabase db;

    RecyclerView rvTodolist;
    TodolistAdapter todolistAdapter;
    LinearLayoutManager llmTodolist;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance() {
        DashboardFragment dashboardFragment = new DashboardFragment();
        return dashboardFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        context = v.getContext();

        InitUtils();
        InitDatabase();
        FetchTodolist();

        return v;
    }

    private void InitUtils() {
        rvTodolist = v.findViewById(R.id.dashboard_rv_memo);

        todolistAdapter = new TodolistAdapter(context);
        llmTodolist = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        rvTodolist.setAdapter(todolistAdapter);
        rvTodolist.setLayoutManager(llmTodolist);

    }

    private void InitDatabase() {
        if (getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();
            db = activity.getDb();
        }
    }

    private void FetchTodolist() {
        AsyncTaskGetTodolist asyncTaskGetTodolist = new AsyncTaskGetTodolist(db, this);
        asyncTaskGetTodolist.execute();
    }

    @Override
    public void FetchedTodolist(List<MemoModel> todolistModels) {
        Log.i(TAG, "FetchedTodolist: responses:\n" + todolistModels.toString());
        todolistAdapter.setTodolistModelList(todolistModels);
        todolistAdapter.notifyDataSetChanged();
    }
}
