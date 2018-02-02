package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.widget.TextView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;

class a$j implements Runnable {
    final /* synthetic */ a rmk;

    private a$j(a aVar) {
        this.rmk = aVar;
    }

    public final void run() {
        if (a.e(this.rmk) >= 0 && a.j(this.rmk) != null && a.j(this.rmk).get() != null) {
            ((TextView) a.j(this.rmk).get()).setText(SightVideoJNI.getVideoInfo(a.e(this.rmk)));
        }
    }
}
