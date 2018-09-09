package id.co.gastropodinteractive.dearmemo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.co.gastropodinteractive.dearmemo.R;
import id.co.gastropodinteractive.dearmemo.data.todolist.MemoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kei Lazu on 9/9/2018
 * check https://github.com/KeiLazu for more
 */
public class TodolistAdapter extends RecyclerView.Adapter<TodolistAdapter.ViewHolder> {

    Context context;
    private List<MemoModel> todolistModelList;

    public void setTodolistModelList(List<MemoModel> todolistModelList) {
        this.todolistModelList = todolistModelList;
    }

    public List<MemoModel> getTodolistModelList() {
        return todolistModelList;
    }

    public TodolistAdapter(Context context) {
        this.context = context;
        todolistModelList = new ArrayList<>();
    }

    @NonNull
    @Override

    public TodolistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_memo, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TodolistAdapter.ViewHolder holder, int position) {
        holder.Clear();
        MemoModel todolistModel = getTodolistModelList().get(position);

        holder.tvTitle.setText(todolistModel.getTitle());
        holder.tvNotes.setText(todolistModel.getNotes());
    }

    @Override
    public int getItemCount() {
        return getTodolistModelList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvNotes;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.list_item_tv_memo_title);
            tvNotes = itemView.findViewById(R.id.list_item_tv_memo_notes);
        }

        public void Clear() {
            tvTitle.setText("");
            tvNotes.setText("");
        }

    }
}
