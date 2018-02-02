package com.tencent.mm.plugin.search.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.e;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.z.ar;

class FTSAddFriendUI$5 implements OnCancelListener {
    final /* synthetic */ ac kBB;
    final /* synthetic */ FTSAddFriendUI qbQ;
    final /* synthetic */ e qbR;

    FTSAddFriendUI$5(FTSAddFriendUI fTSAddFriendUI, ac acVar, e eVar) {
        this.qbQ = fTSAddFriendUI;
        this.kBB = acVar;
        this.qbR = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.kBB);
        ar.CG().b(106, this.qbR);
        FTSAddFriendUI.h(this.qbQ);
    }
}
