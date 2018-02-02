package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.source.b.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class e implements a<s<c>> {
    public final d atM;
    final com.google.android.exoplayer2.source.a.a atO;
    public final s.a<c> atW;
    public a atr;
    public final IdentityHashMap<a$a, a> avA = new IdentityHashMap();
    public final Handler avB = new Handler();
    final e avC;
    public final List<b> avD = new ArrayList();
    public final r avE = new r("HlsPlaylistTracker:MasterPlaylist");
    public a$a avF;
    b avG;
    public boolean avH;
    public final Uri avy;
    public final int avz;

    public static final class c extends IOException {
        public final String url;

        private c(String str) {
            this.url = str;
        }
    }

    public final /* synthetic */ void a(com.google.android.exoplayer2.h.r.c cVar, long j, long j2) {
        a aVar;
        s sVar = (s) cVar;
        c cVar2 = (c) sVar.result;
        boolean z = cVar2 instanceof b;
        if (z) {
            if (((b) cVar2).auM) {
                this.atO.jW();
            }
            List singletonList = Collections.singletonList(new a$a(cVar2.auW, Format.c("0", "application/x-mpegURL")));
            List emptyList = Collections.emptyList();
            aVar = new a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
        } else {
            aVar = (a) cVar2;
        }
        this.atr = aVar;
        this.avF = (a$a) aVar.auC.get(0);
        List arrayList = new ArrayList();
        arrayList.addAll(aVar.auC);
        arrayList.addAll(aVar.auD);
        arrayList.addAll(aVar.auE);
        l(arrayList);
        a aVar2 = (a) this.avA.get(this.avF);
        if (z) {
            a.a(aVar2, (b) cVar2);
        } else {
            aVar2.kG();
        }
        this.atO.a(sVar.asH, j, j2, sVar.aBU);
    }

    public final /* synthetic */ void a(com.google.android.exoplayer2.h.r.c cVar, long j, long j2, boolean z) {
        s sVar = (s) cVar;
        this.atO.b(sVar.asH, j, j2, sVar.aBU);
    }

    public e(Uri uri, d dVar, com.google.android.exoplayer2.source.a.a aVar, int i, e eVar, s.a<c> aVar2) {
        this.avy = uri;
        this.atM = dVar;
        this.atO = aVar;
        this.avz = i;
        this.avC = eVar;
        this.atW = aVar2;
    }

    public final b b(a$a com_google_android_exoplayer2_source_b_a_a_a) {
        b bVar = ((a) this.avA.get(com_google_android_exoplayer2_source_b_a_a_a)).avL;
        if (bVar != null && com_google_android_exoplayer2_source_b_a_a_a != this.avF && this.atr.auC.contains(com_google_android_exoplayer2_source_b_a_a_a) && (this.avG == null || !this.avG.auM)) {
            this.avF = com_google_android_exoplayer2_source_b_a_a_a;
            ((a) this.avA.get(this.avF)).kG();
        }
        return bVar;
    }

    public final void c(a$a com_google_android_exoplayer2_source_b_a_a_a) {
        a aVar = (a) this.avA.get(com_google_android_exoplayer2_source_b_a_a_a);
        aVar.avJ.kc();
        if (aVar.avR != null) {
            throw aVar.avR;
        }
    }

    private void l(List<a$a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a$a com_google_android_exoplayer2_source_b_a_a_a = (a$a) list.get(i);
            this.avA.put(com_google_android_exoplayer2_source_b_a_a_a, new a(this, com_google_android_exoplayer2_source_b_a_a_a));
        }
    }

    static b.a a(b bVar, b bVar2) {
        int i = bVar2.auJ - bVar.auJ;
        List list = bVar.auP;
        return i < list.size() ? (b.a) list.get(i) : null;
    }
}
