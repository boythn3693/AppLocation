package com.bbteam.applocation;


import com.bbteam.applocation.objects.Member;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class FirebaseService {

    public void addFamily(Member member, DatabaseReference databaseReference) {
        Map<String, Object> postValues = member.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/group/dsfas", postValues);

        databaseReference.updateChildren(childUpdates);
    }
}