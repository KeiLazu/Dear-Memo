package id.co.gastropodinteractive.dearmemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.co.gastropodinteractive.dearmemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemoDetailFragment extends Fragment {


    public MemoDetailFragment() {
        // Required empty public constructor
    }

    public static MemoDetailFragment newInstance() {
        MemoDetailFragment todoDetailFragment = new MemoDetailFragment();
        return todoDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_memo_detail, container, false);
    }

}
