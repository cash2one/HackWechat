package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;

class y$1 implements ab {
    final /* synthetic */ y rlv;
    final /* synthetic */ Context val$context;

    y$1(y yVar, Context context) {
        this.rlv = yVar;
        this.val$context = context;
    }

    public final void iD(boolean z) {
        Intent intent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
        intent.putExtra("show", z ? 1 : 0);
        d.m(this.val$context).a(intent);
    }
}
