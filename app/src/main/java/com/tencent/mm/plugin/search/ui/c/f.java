package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i$b;
import com.tencent.mm.plugin.search.ui.a.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.storage.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f extends l {
    public String mLS;
    public q qcf;

    public f(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        super(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    public final int getType() {
        return JsApiSetBackgroundAudioState.CTRL_INDEX;
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        this.qeT = false;
        g gVar = new g();
        gVar.fDj = this.fDj;
        gVar.mLS = this.mLS;
        gVar.mLZ = this;
        gVar.handler = afVar;
        gVar.mLR = 3;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(3, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        List list = hVar.mMc;
        if (aU(list)) {
            if (list.size() > 0) {
                j jVar = (j) list.get(0);
                if (jVar.mLs.equals("create_talker_message​")) {
                    i.a aVar = new i.a();
                    aVar.mOS = false;
                    aVar.mOV = new ArrayList();
                    aVar.mOV.add(jVar);
                    aVar.mMb = hVar.mMb;
                    aVar.hKY = -2;
                    this.mOA.add(aVar);
                    list.remove(0);
                }
            }
            i.a aVar2 = new i.a();
            aVar2.hKY = -2;
            aVar2.mMb = hVar.mMb;
            if (list.size() == 0) {
                aVar2.mOS = false;
                j jVar2 = new j();
                jVar2.mLs = "no_result​";
                aVar2.mOV = new ArrayList();
                aVar2.mOV.add(jVar2);
            } else {
                aVar2.mOV = list;
            }
            this.mOA.add(aVar2);
        }
    }

    protected final c b(int i, i.a aVar) {
        c dVar = new d(i);
        dVar.talker = this.mLS;
        dVar.count = aVar.mOV.size();
        return dVar;
    }

    protected final b a(int i, i.a aVar) {
        int i2;
        int i3 = i - aVar.mOR;
        if (aVar.mOS) {
            i2 = i3 - 1;
        } else {
            i2 = i3;
        }
        b bVar = null;
        if (i2 < aVar.mOV.size() && i2 >= 0) {
            j jVar = (j) aVar.mOV.get(i2);
            if (jVar.mLs.equals("create_talker_message​")) {
                bVar = new com.tencent.mm.plugin.search.ui.a.h(i);
                bVar.mPw = false;
                bVar.mLS = this.mLS;
                this.qeT = true;
            } else if (jVar.mLs.equals("no_result​")) {
                bVar = new com.tencent.mm.plugin.fts.d.a.d(i);
            } else {
                b cVar = new com.tencent.mm.plugin.search.ui.a.c(i2);
                cVar.iVU = jVar;
                cVar.mMb = aVar.mMb;
                cVar.qcf = this.qcf;
                cVar.cC(jVar.type, jVar.mLr);
                bVar = cVar;
            }
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
            bVar.mMb = aVar.mMb;
        }
        return bVar;
    }
}
