package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.a.b.a;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.z.s;

public final class f extends b {
    int jRy = -1;
    private int mNk = 0;
    int yHq = 0;

    public f(Context context) {
        super(context);
    }

    public final int getType() {
        return 3;
    }

    public final void cur() {
        this.yHf.cuv();
        g.Dk();
        g.Dm().F(new 1(this, true));
    }

    public final String WW() {
        return this.mContext.getString(R.l.dDz);
    }

    public final String cuu() {
        return this.mContext.getString(R.l.dDz);
    }

    public final e cus() {
        return new 2(this);
    }

    public final t l(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dtq, viewGroup, false));
    }

    public final void a(a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) FD(i);
        bVar.ldK.setText(com.tencent.mm.plugin.favorite.a.g.e(this.mContext, aVar2.timestamp));
        Bitmap a = o.Pw().a(aVar2.imagePath, com.tencent.mm.bv.a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = com.tencent.mm.pluginsdk.model.app.g.b(aVar2.appId, 1, com.tencent.mm.bv.a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                bVar.jCP.setImageResource(R.k.dvD);
                bVar.mxT.setText(bh.az(aVar2.bhd, ""));
                b.d(bVar.mxT, this.yHg.yyw);
            }
        }
        bVar.jCP.setImageBitmap(a);
        bVar.mxT.setText(bh.az(aVar2.bhd, ""));
        b.d(bVar.mxT, this.yHg.yyw);
    }

    protected final void a(String str, String str2, String str3, int i, String str4, long j, long j2, au auVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            x.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
            return;
        }
        if (an.isMobile(this.mContext) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", true);
        intent.putExtra("geta8key_username", this.jRw);
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        String g = g(auVar, s.eV(this.jRw));
        intent.putExtra("pre_username", g);
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (auVar != null) {
            intent.putExtra("preUsername", g);
        }
        intent.putExtra("preChatName", this.jRw);
        intent.putExtra("preChatTYPE", com.tencent.mm.z.t.N(g, this.jRw));
        intent.putExtra("preMsgIndex", 0);
        d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
            if (aZ == null) {
                Object obj = packageInfo;
            } else {
                str2 = aZ.field_packageName;
            }
        }
        if (str2 != null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }
}
