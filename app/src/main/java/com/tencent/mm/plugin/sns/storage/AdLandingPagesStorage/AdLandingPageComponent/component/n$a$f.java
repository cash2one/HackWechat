package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$f extends b {
    final /* synthetic */ a rjT;

    n$a$f(a aVar) {
        this.rjT = aVar;
    }

    public final void enter() {
        super.enter();
        this.rjT.rjH.rjC.setVisibility(8);
        this.rjT.rjH.rjB.setVisibility(0);
        this.rjT.rjH.rjB.setText("重新下载");
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                this.rjT.b(this.rjT.rjQ);
                return true;
            default:
                return false;
        }
    }
}
