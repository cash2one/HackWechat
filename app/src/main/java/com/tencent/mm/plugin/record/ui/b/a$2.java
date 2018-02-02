package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.l;

class a$2 implements OnLongClickListener {
    private Context context;
    private f mqC;
    final /* synthetic */ a pGF;
    private b pGG;
    private uq pGH;
    private String path;

    a$2(a aVar) {
        this.pGF = aVar;
    }

    public final boolean onLongClick(View view) {
        if (view != null) {
            this.context = view.getContext();
            this.pGG = (b) view.getTag();
            this.mqC = this.pGG.pFG;
            this.pGH = this.pGG.fve;
        }
        com.tencent.mm.sdk.b.b fvVar = new fv();
        fvVar.fvq.type = 2;
        fvVar.fvq.fvs = this.pGG.fve;
        a.xef.m(fvVar);
        this.path = fvVar.fvr.path;
        if (e.bO(this.path)) {
            if (this.pGF.jni == null) {
                this.pGF.jni = new l(this.context);
            }
            this.pGF.jni.rKC = new 1(this);
            this.pGF.jni.rKD = new 2(this);
            this.pGF.jni.bBX();
        } else {
            x.w("MicroMsg.ImageViewWrapper", "file not exists");
        }
        return true;
    }
}
