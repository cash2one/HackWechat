package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary$Entry implements SafeParcelable {
    public static final d CREATOR = new d();
    final ArrayList<FieldMapPair> aPj;
    final String className;
    final int versionCode;

    FieldMappingDictionary$Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
        this.versionCode = i;
        this.className = str;
        this.aPj = arrayList;
    }

    FieldMappingDictionary$Entry(String str, Map<String, Field<?, ?>> map) {
        this.versionCode = 1;
        this.className = str;
        this.aPj = b(map);
    }

    private static ArrayList<FieldMapPair> b(Map<String, Field<?, ?>> map) {
        if (map == null) {
            return null;
        }
        ArrayList<FieldMapPair> arrayList = new ArrayList();
        for (String str : map.keySet()) {
            arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    final HashMap<String, Field<?, ?>> pg() {
        HashMap<String, Field<?, ?>> hashMap = new HashMap();
        int size = this.aPj.size();
        for (int i = 0; i < size; i++) {
            FieldMapPair fieldMapPair = (FieldMapPair) this.aPj.get(i);
            hashMap.put(fieldMapPair.aAM, fieldMapPair.aPk);
        }
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel);
    }
}
