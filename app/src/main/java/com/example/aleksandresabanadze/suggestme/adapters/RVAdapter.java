package com.example.aleksandresabanadze.suggestme.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aleksandresabanadze.suggestme.db.DbModel;
import com.example.aleksandresabanadze.suggestme.R;
import com.example.aleksandresabanadze.suggestme.api.ApiClient;
import com.example.aleksandresabanadze.suggestme.models.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<MovieModel> movieModels;
    private Context context;
    private OnItemClickListener itemClickListener;

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        CardView cardView;
        ImageView poster;
        TextView title, date, language, runtime, genre, vote;

        private OnItemClickListener itemClickListener;

        public ViewHolder(View itemView, OnItemClickListener itemClickListener) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            this.itemClickListener = itemClickListener;
            cardView.setOnClickListener(this);
            poster = itemView.findViewById(R.id.item_movie_poster);
            title = itemView.findViewById(R.id.item_movie_title);
            date = itemView.findViewById(R.id.item_movie_date);
            language = itemView.findViewById(R.id.item_movie_language);
            runtime = itemView.findViewById(R.id.item_movie_runtime);
            genre = itemView.findViewById(R.id.item_movie_genre);
            vote = itemView.findViewById(R.id.item_movie_vote);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(getLayoutPosition());
        }
    }

    public RVAdapter(List<MovieModel> movieModels, Context context) {
        this.movieModels = movieModels;
        this.context = context;
    }

    public void addMovie(List<MovieModel> movieModel){
        this.movieModels = movieModel;
        notifyDataSetChanged();
    }

    public void deleteMovie(int index){
        this.movieModels.remove(index);
        notifyDataSetChanged();
    }

    public void setOnRecyclerItemListener(OnItemClickListener itemListener){
        this.itemClickListener = itemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (movieModels.get(position).runtime!=null) {
            holder.title.setText(movieModels.get(position).title);
            holder.date.setText("Date: " + movieModels.get(position).releaseDate);
            holder.language.setText("Language: " + movieModels.get(position).spokenLanguages);
            holder.runtime.setText("Runtime: " + Integer.toString(movieModels.get(position).runtime));
            holder.genre.setText("Genre: " + movieModels.get(position).genres);
            holder.vote.setText("Vote: " + Double.toString(movieModels.get(position).voteAverage));
            Picasso.with(context)
                    .load(ApiClient.BASE_IMAGE_URL_MEDIUM + movieModels.get(position).posterPath)
                    .into(holder.poster);
        }
        if (holder.title.getText().toString().equals("Title"))
            holder.cardView.setVisibility(View.GONE);
        else
            holder.cardView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }
}
