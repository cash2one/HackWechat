package com.google.android.gms.wearable;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public final class i {
    public final HashMap<String, Object> bdp = new HashMap();

    public final void a(String str, Asset asset) {
        this.bdp.put(str, asset);
    }

    public final Asset bk(String str) {
        Object obj = this.bdp.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (Asset) obj;
        } catch (ClassCastException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key ");
            stringBuilder.append(str);
            stringBuilder.append(" expected ");
            stringBuilder.append("Asset");
            stringBuilder.append(" but value was a ");
            stringBuilder.append(obj.getClass().getName());
            stringBuilder.append(".  The default value ");
            stringBuilder.append("<null>");
            stringBuilder.append(" was returned.");
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.bdp.size() != iVar.bdp.size()) {
            return false;
        }
        for (String str : this.bdp.keySet()) {
            Object obj2 = get(str);
            Object obj3 = iVar.get(str);
            if (obj2 instanceof Asset) {
                if (!(obj3 instanceof Asset)) {
                    return false;
                }
                Asset asset = (Asset) obj2;
                Asset asset2 = (Asset) obj3;
                boolean equals = (asset == null || asset2 == null) ? asset == asset2 : !TextUtils.isEmpty(asset.bdh) ? asset.bdh.equals(asset2.bdh) : Arrays.equals(asset.bdg, asset2.bdg);
                if (!equals) {
                    return false;
                }
            } else if (obj2 instanceof String[]) {
                if (!(obj3 instanceof String[])) {
                    return false;
                }
                if (!Arrays.equals((String[]) obj2, (String[]) obj3)) {
                    return false;
                }
            } else if (obj2 instanceof long[]) {
                if (!(obj3 instanceof long[])) {
                    return false;
                }
                if (!Arrays.equals((long[]) obj2, (long[]) obj3)) {
                    return false;
                }
            } else if (obj2 instanceof float[]) {
                if (!(obj3 instanceof float[])) {
                    return false;
                }
                if (!Arrays.equals((float[]) obj2, (float[]) obj3)) {
                    return false;
                }
            } else if (obj2 instanceof byte[]) {
                if (!(obj3 instanceof byte[])) {
                    return false;
                }
                if (!Arrays.equals((byte[]) obj2, (byte[]) obj3)) {
                    return false;
                }
            } else if (obj2 == null || obj3 == null) {
                if (obj2 != obj3) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(obj3)) {
                return false;
            }
        }
        return true;
    }

    public final <T> T get(String str) {
        return this.bdp.get(str);
    }

    public final int hashCode() {
        return this.bdp.hashCode() * 29;
    }

    public final void putLong(String str, long j) {
        this.bdp.put(str, Long.valueOf(j));
    }

    public final void putString(String str, String str2) {
        this.bdp.put(str, str2);
    }

    public final void putStringArrayList(String str, ArrayList<String> arrayList) {
        this.bdp.put(str, arrayList);
    }

    public final String toString() {
        return this.bdp.toString();
    }
}
