package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b$c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.xweb.x5.sdk.d;

class g$1 implements b$c {
    final /* synthetic */ g mZW;

    g$1(g gVar) {
        this.mZW = gVar;
    }

    public final void g(MenuItem menuItem) {
        aqy com_tencent_mm_protocal_c_aqy = (aqy) g.a(this.mZW).get(Integer.valueOf(menuItem.getItemId()));
        if (com_tencent_mm_protocal_c_aqy != null) {
            switch (g$5.mZY[a.AY(com_tencent_mm_protocal_c_aqy.wgQ).ordinal()]) {
                case 1:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", com_tencent_mm_protocal_c_aqy.wgR);
                    if (d.getTbsVersion(this.mZW.mYx) >= 43114) {
                        com.tencent.mm.bm.d.b(this.mZW.mYx, "game", ".gamewebview.ui.GameWebViewUI", intent);
                        return;
                    } else {
                        com.tencent.mm.bm.d.b(this.mZW.mYx, "webview", ".ui.tools.game.GameWebViewUI", intent);
                        return;
                    }
                case 2:
                    this.mZW.aPC();
                    return;
                case 3:
                    this.mZW.aPD();
                    return;
                case 4:
                    this.mZW.aPK();
                    return;
                case 5:
                    this.mZW.aPG();
                    return;
                case 6:
                    this.mZW.aPH();
                    return;
                case 7:
                    this.mZW.refresh();
                    return;
                case 8:
                    this.mZW.aPJ();
                    return;
                case 9:
                    this.mZW.aPM();
                    return;
                case 10:
                    Bundle bundle = new Bundle();
                    bundle.putInt("mm_to_client_notify_type", 1);
                    bundle.putString("js_event_name", com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                    bundle.putInt("itemId", com_tencent_mm_protocal_c_aqy.wyO);
                    com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
                    return;
                default:
                    return;
            }
        }
    }
}
