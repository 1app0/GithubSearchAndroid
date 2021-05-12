 package com.example.githubsearchandroid.ui.favourite.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubsearchandroid.R;
import com.example.githubsearchandroid.data.FavData.FavRepository;
import com.example.githubsearchandroid.data.FavData.FavUser;
import com.example.githubsearchandroid.ui.favourite.FavoriteFragmentDirections;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class UserAdapter extends FirebaseRecyclerAdapter<FavUser, UserAdapter.ViewHolder> {
    private List<FavUser> favUserList;
    private FavRepository favRepo;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public UserAdapter(@NonNull FirebaseRecyclerOptions<FavUser> options) {
        super(options);
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.favorite_list_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull FavUser model) {
        holder.favUsername.setText(model.getBody());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView favUsername;
        private Button favButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            favUsername = itemView.findViewById(R.id.favoriteName_textView);
            favButton = itemView.findViewById(R.id.favoriteButton);

            favButton.setOnClickListener(v -> {
                NavDirections action = FavoriteFragmentDirections.actionNavigationFavouriteToNavigationUserInfo(String.valueOf(favUsername.getText()));
                Navigation.findNavController(v).navigate(action);
            });
        }
    }
}
