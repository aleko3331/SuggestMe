package com.example.aleksandresabanadze.suggestme.db;

import android.net.Uri;
import android.provider.BaseColumns;


public class DbModel {

    public static final String PROVIDER_AUTHORITY = "com.example.pc.themoviecatalog";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + PROVIDER_AUTHORITY);

    public class MovieModel implements BaseColumns {

        public final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath("MovieModel").build();

        public static final String TABLE_NAME = "MovieCatalog";

        public static final String id = "id";

        public static final String list = "list";

        public static final String budget = "budget";

        public static final String genres = "genres";

        public static final String originalLanguage = "original_language";

        public static final String overview = "overview";

        public static final String popularity = "popularity";

        public static final String posterPath = "poster_path";

        public static final String releaseDate = "release_date";

        public static final String revenue = "revenue";

        public static final String runtime = "runtime";

        public static final String spokenLanguages = "spoken_languages";

        public static final String title = "title";

        public static final String voteAverage = "vote_average";

    }
}
