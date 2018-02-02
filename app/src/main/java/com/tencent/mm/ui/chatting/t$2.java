package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.t.3;
import com.tencent.mm.ui.chatting.t.5;
import com.tencent.mm.ui.chatting.t.8;
import com.tencent.wcdb.database.SQLiteDatabase;

class t$2 implements OnClickListener {
    final /* synthetic */ t yuo;

    t$2(t tVar) {
        this.yuo = tVar;
    }

    public final void onClick(View view) {
        t tVar;
        switch (8.yuq[this.yuo.yug.ordinal()]) {
            case 1:
                g.pQN.h(11288, new Object[]{Integer.valueOf(7)});
                tVar = this.yuo;
                x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
                bh.i(tVar.yuj, tVar.mContext);
                return;
            case 2:
                tVar = this.yuo;
                x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
                f.aAd().bX(tVar.lPM);
                tVar.crW();
                return;
            case 3:
                g.pQN.h(11288, new Object[]{Integer.valueOf(6)});
                t tVar2 = this.yuo;
                if (!an.isConnected(tVar2.mContext)) {
                    h.a(tVar2.mContext, a.ac(tVar2.mContext, R.l.dQp), "", a.ac(tVar2.mContext, R.l.dQk), null);
                    return;
                } else if (an.isWifi(tVar2.mContext)) {
                    h.a(tVar2.mContext, R.l.dQn, 0, R.l.dQi, R.l.dQh, new t$4(tVar2), null);
                    return;
                } else {
                    h.a(tVar2.mContext, R.l.dQm, 0, R.l.dQi, R.l.dQh, new 3(tVar2), null);
                    return;
                }
            case 4:
                Intent launchIntentForPackage;
                g.pQN.h(11288, new Object[]{Integer.valueOf(5)});
                t tVar3 = this.yuo;
                x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
                x.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[]{tVar3.yuk});
                if (bh.ov(tVar3.yuk)) {
                    launchIntentForPackage = tVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                } else {
                    launchIntentForPackage = new Intent();
                    launchIntentForPackage.setData(Uri.parse(tVar3.yuk));
                    launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    if (VERSION.SDK_INT >= 11) {
                        launchIntentForPackage.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
                    }
                    if (!bh.k(tVar3.mContext, launchIntentForPackage)) {
                        launchIntentForPackage = tVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                    }
                }
                x.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[]{launchIntentForPackage});
                com.tencent.mm.bz.a.post(new 5(tVar3, launchIntentForPackage));
                return;
            case 5:
                if (this.yuo.yui) {
                    t.a(this.yuo);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
