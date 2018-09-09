package id.co.gastropodinteractive.dearmemo.data.todolist;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "memo")
public class MemoModel {

	@SerializedName("notes")
	@ColumnInfo(name = "notes")
	private String notes;

	@SerializedName("id")
	@PrimaryKey
	private int id;

	@SerializedName("title")
	@ColumnInfo(name = "title")
	private String title;

	public void setNotes(String notes){
		this.notes = notes;
	}

	public String getNotes(){
		return notes;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public MemoModel(String title, String notes) {
		this.title = title;
		this.notes = notes;
	}

	@Override
 	public String toString(){
		return 
			"MemoModel{" +
			"notes = '" + notes + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}