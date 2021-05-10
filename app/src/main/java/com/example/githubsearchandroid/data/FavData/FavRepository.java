package com.example.githubsearchandroid.data.FavData;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class FavRepository {
    private static FavRepository instance;
    private DatabaseReference myRef;
    private FavLiveData favListLiveData;

    public static synchronized FavRepository getFavRepository() {
        if (instance == null) {
            instance = new FavRepository();
        }

        return instance;
    }

    public void init(String userId) {
        myRef = FirebaseDatabase.getInstance().getReference().child("users").child(userId);
        favListLiveData = new FavLiveData(myRef);
    }

    public void saveFavList(List<String> favList) {
        myRef.setValue(favList);
    }

    public FavLiveData getFavListLiveData() {
        return favListLiveData;
    }
}
