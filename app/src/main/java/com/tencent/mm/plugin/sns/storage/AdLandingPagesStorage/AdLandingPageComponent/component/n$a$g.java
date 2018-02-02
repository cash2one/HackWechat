package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.IntentFilter;
import android.os.Message;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$g extends b {
    final /* synthetic */ a rjT;

    n$a$g(a aVar) {
        this.rjT = aVar;
    }

    public final void enter() {
        super.enter();
        if (this.rjT.rjH.rjE == null) {
            this.rjT.rjH.rjE = new n.b(this.rjT.rjH, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            this.rjT.rjH.context.registerReceiver(this.rjT.rjH.rjE, intentFilter);
        }
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(n.b(this.rjT.rjH).uC)) {
            this.rjT.b(this.rjT.rjO);
        } else if (AdLandingPagesProxy.getInstance().isApkExist(n.b(this.rjT.rjH).fFm)) {
            this.rjT.b(this.rjT.rjN);
        } else if (AdLandingPagesProxy.getInstance().isDownloading(n.b(this.rjT.rjH).fFm)) {
            this.rjT.b(this.rjT.rjK);
        } else if (AdLandingPagesProxy.getInstance().isPaused(n.b(this.rjT.rjH).fFm)) {
            this.rjT.b(this.rjT.rjM);
        } else {
            this.rjT.rjH.rjC.setVisibility(8);
            this.rjT.rjH.rjB.setVisibility(0);
            this.rjT.rjH.rjB.setText(n.b(this.rjT.rjH).title);
        }
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                this.rjT.b(this.rjT.rjQ);
                return true;
            case 3:
                this.rjT.b(this.rjT.rjO);
                return true;
            case 11:
                this.rjT.b(this.rjT.rjL);
                return true;
            default:
                return false;
        }
    }
}
