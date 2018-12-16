package com.example.aleksandresabanadze.suggestme.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aleksandresabanadze.suggestme.models.MovieModel;

import java.util.ArrayList;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DbModel.MovieModel.TABLE_NAME + " (" +
                    DbModel.MovieModel.id + " INTEGER PRIMARY KEY," +
                    DbModel.MovieModel.list + " TEXT," +
                    DbModel.MovieModel.budget + " INTEGER," +
                    DbModel.MovieModel.genres + " TEXT," +
                    DbModel.MovieModel.originalLanguage + " TEXT," +
                    DbModel.MovieModel.overview + " TEXT," +
                    DbModel.MovieModel.popularity + " REAL," +
                    DbModel.MovieModel.posterPath + " TEXT," +
                    DbModel.MovieModel.releaseDate + " TEXT," +
                    DbModel.MovieModel.revenue + " INTEGER," +
                    DbModel.MovieModel.runtime + " INTEGER," +
                    DbModel.MovieModel.spokenLanguages + " TEXT," +
                    DbModel.MovieModel.title + " TEXT," +
                    DbModel.MovieModel.voteAverage + " REAL)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DbModel.MovieModel.TABLE_NAME;

    private static final int DB_VERSION = 3;

    public DbHelper(Context context) { super(context, "MyDb.db", null, DB_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(SQL_CREATE_ENTRIES); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public List<MovieModel> getMovieDataToWant(){

        List<MovieModel> movieData = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String[] forQuery = new String[]{
                DbModel.MovieModel.id,
                DbModel.MovieModel.list,
                DbModel.MovieModel.budget,
                DbModel.MovieModel.genres,
                DbModel.MovieModel.originalLanguage,
                DbModel.MovieModel.overview,
                DbModel.MovieModel.popularity,
                DbModel.MovieModel.posterPath,
                DbModel.MovieModel.releaseDate,
                DbModel.MovieModel.revenue,
                DbModel.MovieModel.runtime,
                DbModel.MovieModel.spokenLanguages,
                DbModel.MovieModel.title,
                DbModel.MovieModel.voteAverage};

        Cursor cursor = db.query(DbModel.MovieModel.TABLE_NAME, forQuery,
                DbModel.MovieModel.list + " = ?", new String[]{"want"}, null, null, null);

        cursor.moveToFirst();

        do {
            MovieModel movie = new MovieModel();

            if (cursor.getCount()>0) {
                movie.id = cursor.getInt(cursor.getColumnIndex(DbModel.MovieModel.id));
                movie.budget = cursor.getInt(cursor.getColumnIndex(DbModel.MovieModel.budget));
                movie.genres = cursor.getString(cursor.getColumnIndex(DbModel.MovieModel.genres));
                movie.originalLanguage = cursor.getString(cursor.getColumnIndex(DbModel.MovieModel.originalLanguage));
                movie.overview = cursor.getString(cursor.getColumnIndex(DbModel.MovieModel.overview));
                movie.popularity = cursor.getDouble(cursor.getColumnIndex(DbModel.MovieModel.popularity));
                movie.posterPath = cursor.getString(cursor.getColumnIndex(DbModel.MovieModel.posterPath));
                movie.releaseDate = cursor.getString(cursor.getColumnIndex(DbModel.MovieModel.releaseDate));
                movie.revenue = cursor.getInt(cursor.getColumnIndex(DbModel.MovieModel.revenue));
                movie.runtime = cursor.getInt(cursor.getColumnIndex(DbModel.MovieModel.runtime));
                movie.spokenLanguages = cursor.getString(cursor.getColumnIndex(DbModel.MovieModel.spokenLanguages));
                movie.title = cursor.getString(cursor.getColumnIndex(DbModel.MovieModel.title));
                movie.voteAverage = cursor.getDouble(cursor.getColumnIndex(DbModel.MovieModel.voteAverage));
            }
            movieData.add(movie);

        } while (cursor.moveToNext());

        return movieData;
    }

    public long addMovieData(MovieModel movieData, String list) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DbModel.MovieModel.id, movieData.id);
        contentValues.put(DbModel.MovieModel.list, list);
        contentValues.put(DbModel.MovieModel.budget, movieData.budget);
        contentValues.put(DbModel.MovieModel.genres, movieData.genres);
        contentValues.put(DbModel.MovieModel.originalLanguage, movieData.originalLanguage);
        contentValues.put(DbModel.MovieModel.overview, movieData.overview);
        contentValues.put(DbModel.MovieModel.popularity, movieData.popularity);
        contentValues.put(DbModel.MovieModel.posterPath, movieData.posterPath);
        contentValues.put(DbModel.MovieModel.releaseDate, movieData.releaseDate);
        contentValues.put(DbModel.MovieModel.revenue, movieData.revenue);
        contentValues.put(DbModel.MovieModel.runtime, movieData.runtime);
        contentValues.put(DbModel.MovieModel.spokenLanguages, movieData.spokenLanguages);
        contentValues.put(DbModel.MovieModel.title, movieData.title);
        contentValues.put(DbModel.MovieModel.voteAverage, movieData.voteAverage);

        return db.insert(DbModel.MovieModel.TABLE_NAME, null, contentValues);
    }

    public int deleteMovieData(int id) {

        String idText = id + "";

        SQLiteDatabase db = getWritableDatabase();

        return db.delete(DbModel.MovieModel.TABLE_NAME, DbModel.MovieModel.id + " = ?", new String[]{idText});
    }
}