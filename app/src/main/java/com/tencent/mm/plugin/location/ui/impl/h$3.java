package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Map.Entry;

class h$3 implements d {
    final /* synthetic */ h nYk;

    h$3(h hVar) {
        this.nYk = hVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                this.nYk.aWM();
                g.pQN.h(12809, new Object[]{Integer.valueOf(4)});
                return;
            case 2:
                x.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[]{Boolean.valueOf(this.nYk.nYi.containsKey("com.tencent.map"))});
                if (h.b(this.nYk)) {
                    this.nYk.nVR.a(this.nYk.nVS, this.nYk.nVT, "com.tencent.map", false);
                    g.pQN.h(12809, new Object[]{Integer.valueOf(4), "com.tencent.map"});
                    return;
                }
                if (this.nYk.nYj < 4) {
                    h hVar = this.nYk;
                    hVar.nYj++;
                    ar.Hg();
                    c.CU().a(a.xvc, Integer.valueOf(this.nYk.nYj));
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", " http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
                com.tencent.mm.bm.d.b(this.nYk.activity, "webview", ".ui.tools.WebViewUI", intent);
                g.pQN.h(12809, new Object[]{Integer.valueOf(5)});
                return;
            default:
                if (this.nYk.nYi != null) {
                    for (Entry entry : this.nYk.nYi.entrySet()) {
                        if (((String) entry.getValue()).equals(menuItem.getTitle())) {
                            this.nYk.nVR.a(this.nYk.nVS, this.nYk.nVT, (String) entry.getKey(), false);
                            g.pQN.h(12809, new Object[]{Integer.valueOf(4), entry.getKey()});
                            return;
                        }
                    }
                    return;
                }
                return;
        }
    }
}
