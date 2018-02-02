package com.tencent.mm.plugin.bottle.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.z.ar;

class BottleBeachUI$5 implements OnCancelListener {
    final /* synthetic */ BottleBeachUI kBA;
    final /* synthetic */ ac kBB;

    BottleBeachUI$5(BottleBeachUI bottleBeachUI, ac acVar) {
        this.kBA = bottleBeachUI;
        this.kBB = acVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.kBB);
    }
}
