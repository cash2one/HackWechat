package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ag.f;
import com.tencent.mm.ba.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;

class SelfQRCodeUI$5 implements OnCancelListener {
    final /* synthetic */ a qgO;
    final /* synthetic */ SelfQRCodeUI qhD;

    SelfQRCodeUI$5(SelfQRCodeUI selfQRCodeUI, a aVar) {
        this.qhD = selfQRCodeUI;
        this.qgO = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qgO);
        if (s.eV(SelfQRCodeUI.c(this.qhD)) || f.jX(SelfQRCodeUI.c(this.qhD))) {
            this.qhD.finish();
        }
    }
}
