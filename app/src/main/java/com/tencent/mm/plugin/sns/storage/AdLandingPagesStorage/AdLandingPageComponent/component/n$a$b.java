package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$b extends b {
    final /* synthetic */ a rjT;

    n$a$b(a aVar) {
        this.rjT = aVar;
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                this.rjT.b(this.rjT.rjM);
                return true;
            case 5:
                a.a(this.rjT, "下载失败");
                this.rjT.b(this.rjT.rjP);
                return true;
            case 6:
                this.rjT.b(this.rjT.rjK);
                return true;
            case 10:
                this.rjT.b(this.rjT.rjL);
                return true;
            default:
                return false;
        }
    }

    public final void enter() {
        super.enter();
        AdLandingPagesProxy.getInstance().doAdChannelScene(n.b(this.rjT.rjH).uC, n.b(this.rjT.rjH).channelId, this.rjT.rjH.rjG);
        AdLandingPagesProxy.getInstance().stopTask(n.b(this.rjT.rjH).fFm);
        this.rjT.rjH.rjB.setVisibility(8);
        this.rjT.rjH.rjC.setVisibility(0);
        this.rjT.rjH.rjC.setProgress(0);
        x.i("LogStateTransitionState", "appid %s, channelId %s", new Object[]{n.b(this.rjT.rjH).uC, n.b(this.rjT.rjH).channelId});
    }
}
