package com.example.githubsearchandroid.data.FavData;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class FavLiveData extends LiveData<List<String>> {
    private List<String> favListSnapshot;
    private DatabaseReference dbRef;
    private final ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if (snapshot.exists()) {
                favListSnapshot.clear();

                for (DataSnapshot snap: snapshot.getChildren()) {
                    String favUserSnapshot = snap.getValue(String.class);
                    favListSnapshot.add(favUserSnapshot);
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
        }
    };

    public FavLiveData(DatabaseReference dbRef) {
        this.dbRef = dbRef;
    }

    @Override
    protected void onActive() {
        super.onActive();
        dbRef.addValueEventListener(listener);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        dbRef.removeEventListener(listener);
    }
}
