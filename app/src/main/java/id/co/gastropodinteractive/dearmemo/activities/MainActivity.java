package id.co.gastropodinteractive.dearmemo.activities;

import android.arch.persistence.room.Room;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import id.co.gastropodinteractive.dearmemo.R;
import id.co.gastropodinteractive.dearmemo.data.AppDatabase;
import id.co.gastropodinteractive.dearmemo.data.asynctodoilst.AsyncTaskPostMemo;
import id.co.gastropodinteractive.dearmemo.data.todolist.MemoModel;
import id.co.gastropodinteractive.dearmemo.fragments.DashboardFragment;
import id.co.gastropodinteractive.dearmemo.fragments.MemoDetailFragment;
import id.co.gastropodinteractive.dearmemo.utils.PrefManager;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    FragmentTransaction ft;

    Toolbar toolbar;

    AppDatabase db;

    public AppDatabase getDb() {
        return db;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitUtils();
        InitFirstTime();
        displayDashboard();
    }

    private void InitFirstTime() {
        PrefManager prefManager = new PrefManager(this);
        if (prefManager.isFirstTimeLaunch()) {
            DummyDataTutorial();
            prefManager.setFirstTimeLaunch(false);
        }
    }

    private void DummyDataTutorial() {
        MemoModel tutorial01 = new MemoModel(
                "Dear Memo",
                "CLICK ME!\nwelcome to dear memo, your dearest Memo, at your services"
        );

        AsyncTaskPostMemo asyncTaskPostMemo = new AsyncTaskPostMemo(db, tutorial01);
        asyncTaskPostMemo.execute();
    }

    private void InitUtils() {
        fm = getSupportFragmentManager();

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "todolist").build();
    }

    private void fragmentReplacer(@IdRes int idLayout, Fragment newFragment, String transactionTag) {
        if (newFragment != null) {
            ft = fm.beginTransaction();
            ft.addToBackStack(transactionTag);
            ft.replace(idLayout, newFragment)
                    .commit();
        }
    }

    private void fragmentReplacer(@IdRes int idLayout, Fragment newFragment) {
        if (newFragment != null) {
            ft = fm.beginTransaction();
            ft.replace(idLayout, newFragment)
                    .commit();
        }
    }

    private void clearBackStack() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStackImmediate(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    private void displayDashboard() {
        clearBackStack();
        Fragment fragment = fm.findFragmentById(R.id.main_layout_fragment);
        if (fragment == null || !(fragment instanceof DashboardFragment)) {
            Fragment frag = DashboardFragment.newInstance();
            fragmentReplacer(R.id.main_layout_fragment, frag);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                Fragment fragment = MemoDetailFragment.newInstance();
                fragmentReplacer(R.id.main_layout_fragment, fragment, MemoDetailFragment.class.getSimpleName());
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
