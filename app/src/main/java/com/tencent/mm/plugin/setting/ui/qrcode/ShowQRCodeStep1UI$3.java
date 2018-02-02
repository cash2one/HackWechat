package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

class ShowQRCodeStep1UI$3 implements OnClickListener {
    final /* synthetic */ ShowQRCodeStep1UI qgN;

    ShowQRCodeStep1UI$3(ShowQRCodeStep1UI showQRCodeStep1UI) {
        this.qgN = showQRCodeStep1UI;
    }

    public final void onClick(View view) {
        if (ShowQRCodeStep1UI.a(this.qgN) == 3) {
            byte[] CF = ar.CF();
            String FS = q.FS();
            ar.Hg();
            x.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[]{bh.VT(bh.by(CF)), FS, Integer.valueOf(bh.e((Integer) c.CU().get(66561, null)))});
            x.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[]{"http://weixin.qq.com/cgi-bin/rweibourl?sid=" + g.s(CF) + "&u=" + FS + "&qr=" + r0 + "&device=" + d.DEVICE_TYPE + "&version=" + d.vAz});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", r0);
            intent.putExtra("title", this.qgN.getString(R.l.eJJ));
            com.tencent.mm.bm.d.b(this.qgN, "webview", ".ui.tools.WebViewUI", intent);
            this.qgN.finish();
        } else if (ShowQRCodeStep1UI.a(this.qgN) == 4) {
            if (q.Gt()) {
                r0 = new Intent(this.qgN, ShareToQQUI.class);
                r0.putExtra("show_to", 4);
                this.qgN.startActivity(r0);
            } else {
                ShowQRCodeStep1UI.a(this.qgN, FacebookAuthUI.class);
            }
            this.qgN.finish();
        } else if (ShowQRCodeStep1UI.a(this.qgN) == 2) {
            r0 = new Intent(this.qgN, ShareToQQUI.class);
            r0.putExtra("show_to", 2);
            this.qgN.startActivity(r0);
            this.qgN.finish();
        } else {
            r0 = new Intent(this.qgN, ShareToQQUI.class);
            r0.putExtra("show_to", 1);
            this.qgN.startActivity(r0);
            this.qgN.finish();
        }
    }
}
