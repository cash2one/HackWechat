package com.tencent.mm.plugin.sns.ui;

import android.view.ViewTreeObserver.OnPreDrawListener;

class SnsOnlineVideoActivity$10 implements OnPreDrawListener {
    final /* synthetic */ SnsOnlineVideoActivity rEF;

    SnsOnlineVideoActivity$10(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.rEF = snsOnlineVideoActivity;
    }

    public final boolean onPreDraw() {
        SnsOnlineVideoActivity.c(this.rEF).getViewTreeObserver().removeOnPreDrawListener(this);
        SnsOnlineVideoActivity.m(this.rEF).a(SnsOnlineVideoActivity.c(this.rEF), SnsOnlineVideoActivity.h(this.rEF), new 1(this));
        return true;
    }
}
