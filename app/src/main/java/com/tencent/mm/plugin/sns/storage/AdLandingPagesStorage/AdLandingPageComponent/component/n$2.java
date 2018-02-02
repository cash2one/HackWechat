package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class n$2 implements a {
    final /* synthetic */ n rjH;

    n$2(n nVar) {
        this.rjH = nVar;
    }

    public final void as(Object obj) {
    }

    public final void e(int i, int i2, Object obj) {
        if (i == 0 && i2 == 0) {
            mc mcVar = new mc();
            try {
                mcVar.aF((byte[]) obj);
            } catch (Throwable e) {
                x.e("MicroMsg.AdLandingPageDownloadApkBtnComp", bh.i(e));
            }
            if (!TextUtils.isEmpty(mcVar.vUP)) {
                x.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + mcVar.vUP);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", mcVar.vUP);
                intent.putExtra("showShare", true);
                d.b(this.rjH.context, "webview", ".ui.tools.WebViewUI", intent);
                n.a(this.rjH).Dh(10);
                return;
            } else if (mcVar.vUO != null) {
                n.b(this.rjH).rfG = mcVar.vUO.vUF;
                n.b(this.rjH).fqR = mcVar.vUO.vUD;
                n.b(this.rjH).downloadUrl = mcVar.vUO.vUE;
                n.b(this.rjH).fileSize = (long) mcVar.vUO.vUI;
                n.a(this.rjH).Dh(6);
                return;
            } else {
                x.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp null");
                n.a(this.rjH).Dh(5);
                return;
            }
        }
        n.a(this.rjH).Dh(5);
    }
}
