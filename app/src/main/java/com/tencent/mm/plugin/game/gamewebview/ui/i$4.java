package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.R;
import com.tencent.mm.k.d.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p.c;
import java.util.ArrayList;

class i$4 implements c {
    final /* synthetic */ i nai;
    final /* synthetic */ Boolean naj;
    final /* synthetic */ ArrayList nak = null;

    i$4(i iVar, Boolean bool, ArrayList arrayList) {
        this.nai = iVar;
        this.naj = bool;
    }

    public final void a(n nVar) {
        g.pQN.a(480, 0, 1, false);
        if (this.naj.booleanValue()) {
            int size = this.nak.size();
            for (int i = 0; i < size; i++) {
                b bVar = (b) this.nak.get(i);
                o oVar = (o) nVar.f(bVar.id, bVar.title);
                oVar.ycf = bVar;
                oVar.setIcon(null);
                oVar.setIcon(0);
            }
            return;
        }
        if (this.nai.mZP.mWG.gn(21) && i.a(this.nai, 1)) {
            nVar.a(1, this.nai.mYx.getString(R.l.eBK), R.k.dwQ);
        }
        if (this.nai.mZP.mWG.gn(23) && i.a(this.nai, 2)) {
            nVar.a(2, this.nai.mYx.getString(R.l.eBL), R.k.dwF);
        }
        boolean z = this.nai.getBundle().getBoolean("is_favorite_item", false);
        if (!z && i.aPN() && i.a(this.nai, 3)) {
            nVar.a(3, this.nai.mYx.getString(R.l.eAd), R.k.dwy);
        }
        nVar.a(31, this.nai.mYx.getString(R.l.eYy), R.k.dwO);
        if (this.nai.mZP.mWG.gn(44) && i.a(this.nai, 6)) {
            nVar.a(6, this.nai.mYx.getString(R.l.eXV), R.k.dws);
        }
        boolean z2 = this.nai.getBundle().getBoolean("key_detail_can_delete", true);
        if (z && z2 && i.aPN()) {
            if (i.a(this.nai, 12)) {
                nVar.a(12, this.nai.mYx.getString(R.l.eeF), R.k.dwn);
            }
            if (i.a(this.nai, 9)) {
                nVar.a(9, this.nai.mYx.getString(R.l.dEw), R.k.dwt);
            }
        }
        if (this.nai.Vb()) {
            if (i.a(this.nai, 32)) {
                nVar.a(32, this.nai.mYx.getString(R.l.eBM), R.k.dwR);
            }
        } else if (i.a(this.nai, 30)) {
            nVar.a(30, this.nai.mYx.getString(R.l.eBR), R.k.dwS);
        }
        if (this.nai.mZP.mWG.gn(45) && i.a(this.nai, 7)) {
            nVar.a(7, this.nai.mYx.getString(R.l.eYa), R.k.dwq);
        }
        if (i.a(this.nai, 28)) {
            nVar.a(28, this.nai.mYx.getString(R.l.eWu), R.k.dwM);
        }
        if (this.nai.mZP.mWG.jDU) {
            nVar.a(27, this.nai.mYx.getString(R.l.eBQ), R.k.dwx);
        }
        String aPl = this.nai.mZP.mWG.aPl();
        String string = this.nai.getBundle().getString("shortcut_user_name");
        if (!(this.nai.getBundle().getBoolean("from_shortcut", false) || bh.ov(aPl) || bh.ov(string) || !this.nai.mZP.mWG.gn(255) || !i.a(this.nai, 29))) {
            nVar.a(29, this.nai.mYx.getString(R.l.eBI), R.k.dBH);
        }
        nVar.a(10, this.nai.mYx.getString(R.l.dMl), R.k.dwr);
    }
}
