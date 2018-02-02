package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a$a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$c extends b {
    final /* synthetic */ a rjT;
    a$a rjU;

    n$a$c(a aVar) {
        this.rjT = aVar;
    }

    public final void enter() {
        super.enter();
        this.rjT.rjH.rjB.setVisibility(8);
        this.rjT.rjH.rjC.setVisibility(0);
        if (AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm) || AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm)) {
            if (this.rjU == null) {
                this.rjU = new a(this, (byte) 0);
            }
            this.rjT.rjH.rjC.setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm));
            if (!AdLandingPagesProxy.getInstance().resumeTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm, this.rjU, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).reb, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).rea)) {
                AdLandingPagesProxy.getInstance().stopTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm);
                this.rjT.b(this.rjT.rjK);
            }
        } else if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).downloadUrl)) {
            this.rjT.b(this.rjT.rjQ);
        } else if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm)) {
            this.rjT.rjH.rjC.setProgress(100);
            this.rjT.b(this.rjT.rjN);
        } else {
            AdLandingPagesProxy.getInstance().stopTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm);
            this.rjU = new a(this, (byte) 0);
            AdLandingPagesProxy.getInstance().startDownload(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).uC, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fqR, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).downloadUrl, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).rfG, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).rfH, this.rjU, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).reb, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).rea);
        }
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                if (AdLandingPagesProxy.getInstance().pauseTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm) && AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm)) {
                    this.rjT.b(this.rjT.rjM);
                }
                return true;
            case 1:
                int i = message.arg1;
                if (i >= 0) {
                    this.rjT.rjH.rjC.setProgress(i);
                }
                return true;
            case 3:
                this.rjT.b(this.rjT.rjO);
                return true;
            case 7:
                this.rjT.b(this.rjT.rjM);
                return true;
            case 8:
                a.a(this.rjT, "下载失败");
                this.rjT.b(this.rjT.rjP);
                return true;
            case 9:
                if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).rfH) {
                    AdLandingPagesProxy.getInstance().reportDownloadInfo(4, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fFm, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).uC, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).fqR, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.rjT.rjH.rji).downloadUrl);
                }
                this.rjT.rjH.bxo();
                this.rjT.b(this.rjT.rjN);
                return true;
            default:
                return false;
        }
    }
}
