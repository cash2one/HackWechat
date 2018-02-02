package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.z.ar;

class o$1 extends af {
    final /* synthetic */ o pYe;

    o$1(o oVar) {
        this.pYe = oVar;
    }

    public final void handleMessage(Message message) {
        if (this.pYe.pXE >= this.pYe.pXF) {
            if (this.pYe.pXX != null) {
                ar.CG().c(this.pYe.pXX);
            }
            o oVar = this.pYe;
            oVar.pXE--;
        }
    }
}
