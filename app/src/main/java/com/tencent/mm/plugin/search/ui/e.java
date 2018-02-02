package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.c.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.HashSet;

public final class e extends b implements b {
    private af qbw = new af(Looper.getMainLooper());
    private f qck;
    private boolean qcl;

    public e(c cVar, String str, int i) {
        super(cVar);
        Context context = cVar.getContext();
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(JsApiSetBackgroundAudioState.CTRL_INDEX));
        f fVar = (f) h.a(hashSet, context, this, i).get(0);
        fVar.mLS = str;
        if (s.eV(str)) {
            ar.Hg();
            fVar.qcf = c.Fh().hD(str);
        }
        this.qck = fVar;
    }

    public final void a(i iVar, String str) {
        vP(iVar.qe(0));
        notifyDataSetChanged();
        G(getCount(), true);
    }

    protected final com.tencent.mm.plugin.fts.d.a.b qf(int i) {
        com.tencent.mm.plugin.fts.d.a.b qf = this.qck.qf(i);
        if (qf != null) {
            qf.mPy = i;
            qf.pageType = 4;
        }
        return qf;
    }

    protected final void bpU() {
        this.qcl = false;
        this.qck.a(this.fDj, this.qbw, new HashSet());
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        this.qck.a(view, bVar, z);
        if (bVar.mPF && !this.qcl) {
            this.qcl = true;
            com.tencent.mm.bc.e.b(this.fDj, true, this.qck.aNo(), -2);
        }
        return false;
    }

    public final void finish() {
        super.finish();
        if (!this.qcl) {
            this.qcl = true;
            com.tencent.mm.bc.e.b(this.fDj, false, this.qck.aNo(), -2);
        }
    }

    protected final int aNp() {
        return this.qck.aNo();
    }
}
