package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final c CREATOR = new c();
    final HashMap<String, Map<String, Field<?, ?>>> aPg;
    private final ArrayList<Entry> aPh = null;
    final String aPi;
    final int mVersionCode;

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.mVersionCode = i;
        this.aPg = c(arrayList);
        this.aPi = (String) w.ag(str);
        pf();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> c(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.className, entry.pg());
        }
        return hashMap;
    }

    private void pf() {
        for (String str : this.aPg.keySet()) {
            Map map = (Map) this.aPg.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).aPe = this;
            }
        }
    }

    public final Map<String, Field<?, ?>> aP(String str) {
        return (Map) this.aPg.get(str);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.aPg.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.aPg.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel);
    }
}
