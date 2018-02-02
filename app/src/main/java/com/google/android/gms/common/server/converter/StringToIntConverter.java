package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, a<String, Integer> {
    public static final b CREATOR = new b();
    final HashMap<String, Integer> aOR;
    private final HashMap<Integer, String> aOS;
    private final ArrayList<Entry> aOT;
    final int mVersionCode;

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.aOR = new HashMap();
        this.aOS = new HashMap();
        this.aOT = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.mVersionCode = i;
        this.aOR = new HashMap();
        this.aOS = new HashMap();
        this.aOT = null;
        b(arrayList);
    }

    private void b(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str = entry.aOU;
            int i = entry.aOV;
            this.aOR.put(str, Integer.valueOf(i));
            this.aOS.put(Integer.valueOf(i), str);
        }
    }

    public final /* synthetic */ Object convertBack(Object obj) {
        String str = (String) this.aOS.get((Integer) obj);
        return (str == null && this.aOR.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
