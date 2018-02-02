package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$i extends b {
    final /* synthetic */ a rjT;

    n$a$i(a aVar) {
        this.rjT = aVar;
    }

    public final void enter() {
        super.enter();
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(n.b(this.rjT.rjH).uC)) {
            this.rjT.rjH.rjC.setVisibility(8);
            this.rjT.rjH.rjB.setVisibility(0);
            this.rjT.rjH.rjB.setText("打开应用");
            return;
        }
        this.rjT.b(this.rjT.rjN);
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                if (this.rjT.rjH.bxn()) {
                    return true;
                }
                a.a(this.rjT, "打开失败");
                this.rjT.b(this.rjT.rjO);
                return true;
            case 4:
                this.rjT.b(this.rjT.rjL);
                AdLandingPagesProxy.getInstance().deleteDeferredDeepLink(n.b(this.rjT.rjH).uC);
                return true;
            default:
                return false;
        }
    }
}
