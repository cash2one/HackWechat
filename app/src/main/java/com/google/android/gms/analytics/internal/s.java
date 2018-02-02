package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class s {
    final Map<String, String> aFb;
    final long aGl = 0;
    final String aGm;
    final String aGn;
    final boolean aGo;
    long aGp;

    public s(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        w.aM(str);
        w.aM(str2);
        this.aGm = str;
        this.aGn = str2;
        this.aGo = z;
        this.aGp = j2;
        if (map != null) {
            this.aFb = new HashMap(map);
        } else {
            this.aFb = Collections.emptyMap();
        }
    }
}
