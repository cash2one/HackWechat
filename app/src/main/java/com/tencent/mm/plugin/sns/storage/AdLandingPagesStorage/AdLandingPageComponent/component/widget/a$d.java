package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.view.View;

class a$d implements Runnable {
    final /* synthetic */ a rmk;

    private a$d(a aVar) {
        this.rmk = aVar;
    }

    public final void run() {
        if (a.k(this.rmk).get() != null) {
            ((View) a.k(this.rmk).get()).startAnimation(a.l(this.rmk));
        }
    }
}
