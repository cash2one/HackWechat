package com.tencent.mm.ui.friend;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.z.ar;

class RecommendFriendUI$5 implements OnCancelListener {
    final /* synthetic */ RecommendFriendUI zdr;
    final /* synthetic */ p zdt;

    RecommendFriendUI$5(RecommendFriendUI recommendFriendUI, p pVar) {
        this.zdr = recommendFriendUI;
        this.zdt = pVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.zdt);
        this.zdr.finish();
    }
}
