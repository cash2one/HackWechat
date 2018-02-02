package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$h extends b {
    final /* synthetic */ a rjT;
    private boolean rjW;

    n$a$h(a aVar) {
        this.rjT = aVar;
    }

    public final void enter() {
        super.enter();
        if (AdLandingPagesProxy.getInstance().isApkExist(n.b(this.rjT.rjH).fFm)) {
            this.rjT.rjH.rjC.setVisibility(8);
            this.rjT.rjH.rjB.setVisibility(0);
            this.rjT.rjH.rjB.setText("安装应用");
            this.rjW = true;
            return;
        }
        this.rjT.b(this.rjT.rjL);
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                if (AdLandingPagesProxy.getInstance().installApp(this.rjT.rjH.context, n.b(this.rjT.rjH).fFm)) {
                    this.rjW = true;
                    return true;
                }
                a.a(this.rjT, "安装失败");
                this.rjT.b(this.rjT.rjP);
                return true;
            case 2:
                if (!AdLandingPagesProxy.getInstance().isApkExist(n.b(this.rjT.rjH).fFm)) {
                    this.rjT.b(this.rjT.rjL);
                }
                return true;
            case 3:
                if (this.rjW) {
                    this.rjW = false;
                    AdLandingPagesProxy.getInstance().reportDownloadInfo(5, n.b(this.rjT.rjH).fFm, n.b(this.rjT.rjH).uC, n.b(this.rjT.rjH).fqR, n.b(this.rjT.rjH).downloadUrl);
                }
                this.rjT.b(this.rjT.rjO);
                return true;
            default:
                return false;
        }
    }
}
