package com.google.android.exoplayer2.f.e;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

final class e implements d {
    private final b aze;
    private final long[] azf;
    private final Map<String, d> azg;
    private final Map<String, c> azh;

    public e(b bVar, Map<String, d> map, Map<String, c> map2) {
        this.aze = bVar;
        this.azh = map2;
        this.azg = Collections.unmodifiableMap(map);
        this.azf = bVar.ld();
    }

    public final int L(long j) {
        int a = t.a(this.azf, j);
        return a < this.azf.length ? a : -1;
    }

    public final int kJ() {
        return this.azf.length;
    }

    public final long cH(int i) {
        return this.azf[i];
    }

    public final List<a> M(long j) {
        b bVar = this.aze;
        Map map = this.azg;
        Map map2 = this.azh;
        Object treeMap = new TreeMap();
        bVar.a(j, false, bVar.ayN, treeMap);
        bVar.a(map, treeMap);
        List<a> arrayList = new ArrayList();
        for (Entry entry : treeMap.entrySet()) {
            c cVar = (c) map2.get(entry.getKey());
            arrayList.add(new a(b.a((SpannableStringBuilder) entry.getValue()), null, cVar.avU, cVar.avV, cVar.avW, cVar.avX, Integer.MIN_VALUE, cVar.width));
        }
        return arrayList;
    }
}
