package com.example.beautygab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.beautygab.models.Note;

import java.util.ArrayList;
import java.util.List;


public class MyDatabaseHelper extends SQLiteOpenHelper {
	private static final String TAG = "SQLITE";

	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "DB";

	private static final String TABLE_NOTE = "Note";

	private static final String COLUMN_NOTE_ID ="Note_Id";
	private static final String COLUMN_NOTE_TITLE ="Note_Title";
	private static final String COLUMN_NOTE_CONTENT = "Note_Content";



	public MyDatabaseHelper(Context context)  {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {

		// Script to create table.
		String script = "CREATE TABLE " + TABLE_NOTE + "("
				+ COLUMN_NOTE_ID + " INTEGER PRIMARY KEY," + COLUMN_NOTE_TITLE + " TEXT,"
				+ COLUMN_NOTE_CONTENT + " TEXT" + ")";
		// Execute script.
		db.execSQL(script);
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		// Drop table
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);


		// Recreate
		onCreate(db);
	}

	/* If Note table has no data
	default, Insert 2 records.*/
	public void createDefaultNotesIfNeed()  {
		int count = this.getNotesCount();
		if(count ==0 ) {
			Note note1 = new Note("Firstly see Android ListView",
					"See Android ListView Example in o7planning.org");
			Note note2 = new Note("Learning Android SQLite",
					"See Android SQLite Example in o7planning.org");
			this.addNote(note1);
			this.addNote(note2);
		}
	}

	public int getNotesCount() {

		String countQuery = "SELECT  * FROM " + TABLE_NOTE;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);

		int count = cursor.getCount();

		cursor.close();

		// return count
		return count;
	}

	public void addNote(Note note) {


		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
		values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());

		// Inserting Row
		db.insert(TABLE_NOTE, null, values);

		// Closing database connection
		db.close();
	}

	public Note getNote(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_NOTE, new String[] { COLUMN_NOTE_ID,
						COLUMN_NOTE_TITLE, COLUMN_NOTE_CONTENT }, COLUMN_NOTE_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Note note = new Note(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2));
		// return note
		return note;
	}

	public List<Note> getAllNotes() {


		List<Note> noteList = new ArrayList<Note>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_NOTE;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Note note = new Note();
				note.setNoteId(Integer.parseInt(cursor.getString(0)));
				note.setNoteTitle(cursor.getString(1));
				note.setNoteContent(cursor.getString(2));
				// Adding note to list
				noteList.add(note);
			} while (cursor.moveToNext());
		}

		// return note list
		return noteList;
	}

	public int updateNote(Note note) {


		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
		values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());

		// updating row
		return db.update(TABLE_NOTE, values, COLUMN_NOTE_ID + " = ?",
				new String[]{String.valueOf(note.getNoteId())});
	}

	public void deleteNote(Note note) {


		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NOTE, COLUMN_NOTE_ID + " = ?",
				new String[] { String.valueOf(note.getNoteId()) });
		db.close();
	}

}
