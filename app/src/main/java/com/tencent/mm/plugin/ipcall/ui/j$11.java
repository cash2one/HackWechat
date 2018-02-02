package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a;
import com.tencent.mm.plugin.report.service.g;

class j$11 implements a {
    final /* synthetic */ j nOi;

    j$11(j jVar) {
        this.nOi = jVar;
    }

    public final void gf(boolean z) {
        j jVar;
        if (z) {
            jVar = this.nOi;
            if (jVar.nNC == null) {
                jVar.ihQ.setVisibility(8);
            } else {
                jVar.ihQ.setVisibility(4);
            }
            jVar.ihQ.setVisibility(8);
            jVar.nNN.setVisibility(8);
            jVar.nNL.setText("");
            jVar.nNM.setText("");
            jVar.nHd.setVisibility(0);
        } else {
            jVar = this.nOi;
            if (jVar.nNC != null) {
                jVar.ihQ.setVisibility(0);
                jVar.nNN.setVisibility(8);
            } else {
                jVar.nNN.setVisibility(0);
                jVar.ihQ.setVisibility(8);
            }
            jVar.CY(jVar.nNW);
            jVar.nHd.setVisibility(4);
        }
        g.pQN.h(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
    }
}
