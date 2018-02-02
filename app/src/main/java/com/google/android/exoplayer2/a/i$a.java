package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e.a;
import com.google.android.exoplayer2.a.f.f;

final class i$a implements f {
    final /* synthetic */ i ahs;

    private i$a(i iVar) {
        this.ahs = iVar;
    }

    public final void bW(int i) {
        a a = i.a(this.ahs);
        if (a.afB != null) {
            a.handler.post(new e$a$6(a, i));
        }
        i.iR();
    }

    public final void ir() {
        i.iS();
        i.b(this.ahs);
    }

    public final void d(int i, long j, long j2) {
        a a = i.a(this.ahs);
        if (a.afB != null) {
            a.handler.post(new e$a$4(a, i, j, j2));
        }
        i.iT();
    }
}
