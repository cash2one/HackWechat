package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.h.q.c;
import java.util.List;
import java.util.Map;

public final class q$e extends c {
    public final Map<String, List<String>> aBE;
    public final int responseCode;

    public q$e(int i, Map<String, List<String>> map, i iVar) {
        super("Response code: " + i, iVar);
        this.responseCode = i;
        this.aBE = map;
    }
}
