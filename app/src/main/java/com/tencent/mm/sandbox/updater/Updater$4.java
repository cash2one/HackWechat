package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.protocal.c.no;
import com.tencent.mm.z.ar;

class Updater$4 implements e {
    final /* synthetic */ Updater xdq;
    final /* synthetic */ TextView xds;

    Updater$4(Updater updater, TextView textView) {
        this.xdq = updater;
        this.xds = textView;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(922, Updater.g(this.xdq));
        Updater.a(this.xdq, null);
        if (i == 0 && i2 == 0) {
            bnv com_tencent_mm_protocal_c_bnv = ((no) ((b) kVar.hmG).hmh.hmo).vWv;
            if (com_tencent_mm_protocal_c_bnv == null || com_tencent_mm_protocal_c_bnv.wQE != 3) {
                if (Updater.h(this.xdq).findViewById(R.h.cwp) != null) {
                    Updater.h(this.xdq).findViewById(R.h.cwp).setVisibility(8);
                }
                if (this.xds != null) {
                    g.pQN.a(405, 63, 1, true);
                    this.xds.setText(R.l.eSb);
                    return;
                }
                return;
            }
            Intent intent = new Intent(this.xdq.getContext(), AppUpdaterUI.class);
            Updater.a(intent, new e(com_tencent_mm_protocal_c_bnv));
            this.xdq.getContext().startActivity(intent);
            if (Updater.h(this.xdq) != null) {
                Updater.h(this.xdq).cancel();
            }
            this.xdq.onStop();
            return;
        }
        if (Updater.h(this.xdq).findViewById(R.h.cwp) != null) {
            Updater.h(this.xdq).findViewById(R.h.cwp).setVisibility(8);
        }
        if (this.xds != null) {
            g.pQN.a(405, 63, 1, true);
            this.xds.setText(R.l.eSb);
        }
    }
}
