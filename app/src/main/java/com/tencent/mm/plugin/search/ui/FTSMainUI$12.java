package com.tencent.mm.plugin.search.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.e;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.z.ar;

class FTSMainUI$12 implements OnCancelListener {
    final /* synthetic */ ac kBB;
    final /* synthetic */ e qbR;
    final /* synthetic */ FTSMainUI qdk;

    FTSMainUI$12(FTSMainUI fTSMainUI, ac acVar, e eVar) {
        this.qdk = fTSMainUI;
        this.kBB = acVar;
        this.qbR = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.kBB);
        ar.CG().b(106, this.qbR);
        FTSMainUI.f(this.qdk);
    }
}
