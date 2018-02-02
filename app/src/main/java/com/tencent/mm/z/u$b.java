package com.tencent.mm.z;

import android.text.TextUtils;
import com.tencent.mm.z.u.a;
import java.util.Map;
import java.util.Set;

public class u$b {
    public Map<String, Object> hfv = new a((byte) 0);

    public final Set<String> GL() {
        return this.hfv.keySet();
    }

    public final boolean containsKey(String str) {
        return this.hfv.containsKey(str);
    }

    public final u$b o(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.hfv.put(str, obj);
        }
        return this;
    }

    public final u$b u(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.hfv.put(str, Boolean.valueOf(z));
        }
        return this;
    }

    public final u$b O(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.hfv.put(str, str2);
        }
        return this;
    }

    public final boolean hA(String str) {
        if (!TextUtils.isEmpty(str)) {
            Object obj = this.hfv.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    public final Object get(String str) {
        return this.hfv.get(str);
    }

    public final int getInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        Object obj = this.hfv.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return i;
    }

    public final boolean getBoolean(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        Object obj = this.hfv.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return z;
    }

    public final String getString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        Object obj = this.hfv.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return str2;
    }

    public final <T> T get(String str, T t) {
        T t2 = get(str);
        if (t2 != null) {
            return t2;
        }
        return t;
    }

    public final void recycle() {
        this.hfv.clear();
    }
}
