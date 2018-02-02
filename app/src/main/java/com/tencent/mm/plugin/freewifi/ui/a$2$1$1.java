package com.tencent.mm.plugin.freewifi.ui;

import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.plugin.freewifi.ui.a.2.1;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class a$2$1$1 implements Runnable {
    final /* synthetic */ bg mGH;
    final /* synthetic */ 1 mGI;

    a$2$1$1(1 1, bg bgVar) {
        this.mGI = 1;
        this.mGH = bgVar;
    }

    public final void run() {
        if (bh.ov(this.mGH.fpw.fpB)) {
            this.mGI.mGF.setVisibility(8);
            return;
        }
        ((TextView) this.mGI.mGG.mGE.view.findViewById(R.h.cji)).setText(this.mGH.fpw.fpB);
        String str = this.mGH.fpw.fpy;
        Object obj = "0".equalsIgnoreCase(this.mGH.fpw.fpx) ? "0" : "1";
        String str2 = this.mGH.fpw.fpz;
        String str3 = this.mGH.fpw.ssid;
        String str4 = this.mGH.fpw.bssid;
        String str5 = this.mGH.fpw.fpA;
        x.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to show bar. pingEnabled = %s,  pingUrl= %s", new Object[]{obj, str});
        if ("1".equals(obj)) {
            ar.Dm().F(new 1(this, str, str3, str4, str5, str2));
        } else {
            this.mGI.mGF.setVisibility(0);
        }
    }
}
