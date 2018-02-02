package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.t.6;

class t$6$1 implements Runnable {
    final /* synthetic */ 6 yup;

    t$6$1(6 6) {
        this.yup = 6;
    }

    public final void run() {
        if (bh.ov(this.yup.yuo.pur) || bh.ov(this.yup.yuo.pus)) {
            t.a(this.yup.yuo);
            return;
        }
        t tVar = this.yup.yuo;
        x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[downloadQQMail]");
        a aVar = new a();
        aVar.xL(tVar.pur);
        aVar.xN(tVar.mContext.getResources().getString(R.l.dZg));
        aVar.xO(tVar.pus);
        aVar.ep(true);
        aVar.ox(1);
        tVar.lPM = f.aAd().a(aVar.lsE);
        if (tVar.lPM > 0) {
            tVar.gZO = tVar.mContext.getSharedPreferences("QQMAIL", 4);
            tVar.gZO.edit().putLong("qqmail_downloadid", tVar.lPM).apply();
            tVar.crW();
        }
    }
}
