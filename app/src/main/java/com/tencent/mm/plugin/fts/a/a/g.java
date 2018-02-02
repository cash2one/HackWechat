package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.af;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class g {
    private static final AtomicInteger mLQ = new AtomicInteger(0);
    public String fDj = null;
    public af handler = null;
    public final int id = mLQ.incrementAndGet();
    public int mLR = 0;
    public String mLS = null;
    public String mLT = null;
    public int[] mLU = null;
    public int[] mLV = null;
    public int mLW = Integer.MAX_VALUE;
    public HashSet<String> mLX = new HashSet();
    public Comparator<j> mLY = null;
    public k mLZ = null;
    public int scene = -1;
    public String talker = null;

    public static g a(String str, int[] iArr, int[] iArr2, int i, HashSet<String> hashSet, Comparator<j> comparator, k kVar, af afVar) {
        g gVar = new g();
        gVar.fDj = str;
        gVar.mLS = null;
        gVar.mLU = iArr;
        gVar.mLV = iArr2;
        gVar.mLW = i;
        gVar.mLX = hashSet;
        gVar.mLY = comparator;
        gVar.mLZ = kVar;
        gVar.handler = afVar;
        return gVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.id != ((g) obj).id) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("{id: %d, query: %s}", new Object[]{Integer.valueOf(this.id), this.fDj});
    }
}
