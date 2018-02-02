package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.storage.au;

class l$b implements a {
    private Context context;
    private String hog;
    private long kGB;
    private boolean vnK;
    private ChattingUI.a yrU;
    private l.a yrV;

    public l$b(ChattingUI.a aVar, Context context, String str, long j, l.a aVar2) {
        this.yrU = aVar;
        this.context = context;
        this.hog = str;
        this.kGB = j;
        this.yrV = aVar2;
        this.vnK = f.eE(str);
    }

    public final boolean JB() {
        if (this.vnK) {
            c ag = y.Mh().ag(this.kGB);
            synchronized (e.hqR) {
                String HD = e.HD();
                e.d(ag);
                if (this.yrV.yrT) {
                    crv();
                } else {
                    crw();
                }
                e.ks(HD);
            }
        } else if (this.yrV.yrT) {
            crv();
        } else {
            crw();
        }
        return true;
    }

    private void crv() {
        for (au auVar : this.yrV.yrI) {
            Context context = this.context;
            boolean z = this.yrV.ypn;
            String str = this.hog;
            if (auVar.cjg()) {
                i.a(context, str, auVar, z);
            } else if (auVar.cje()) {
                i.b(context, str, auVar);
            } else if (auVar.cjh() && !this.vnK) {
                i.c(context, str, auVar);
            } else if (auVar.aNe()) {
                i.c(context, str, auVar, z);
            } else if ((auVar.cjj() || auVar.cjk()) && !this.vnK) {
                if (!i.ai(auVar)) {
                    i.a(context, str, auVar);
                }
            } else if (auVar.aNc() && !((this.vnK && !i.aq(auVar)) || i.ar(auVar) || auVar.getType() == 318767153 || i.av(auVar) || i.ak(auVar))) {
                i.b(context, str, auVar, z);
            }
        }
    }

    private void crw() {
        l.bv(this.context, this.hog);
        b mtVar = new mt();
        mtVar.fEE.type = 5;
        mtVar.fEE.fEK = this.yrV.yrI;
        mtVar.fEE.toUser = this.hog;
        mtVar.fEE.fEL = this.yrV.fEL;
        mtVar.fEE.context = this.context;
        mtVar.fEE.fEg = this.yrV.fEg;
        mtVar.fEE.fEN = this.yrV.yrJ;
        com.tencent.mm.sdk.b.a.xef.m(mtVar);
    }

    public final boolean JC() {
        if (l.cru() != null) {
            l.cru().dismiss();
        }
        com.tencent.mm.ui.snackbar.a.a(this.context, this.yrU.getView().findViewById(R.h.cwm), this.context.getString(R.l.eic));
        return true;
    }
}
