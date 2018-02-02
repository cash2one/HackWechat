package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.aj.d;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.60;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class GameWebViewUI$3 implements c {
    final /* synthetic */ GameWebViewUI tFJ;

    GameWebViewUI$3(GameWebViewUI gameWebViewUI) {
        this.tFJ = gameWebViewUI;
    }

    public final void g(MenuItem menuItem) {
        aqy com_tencent_mm_protocal_c_aqy = (aqy) GameWebViewUI.b(this.tFJ).get(Integer.valueOf(menuItem.getItemId()));
        if (com_tencent_mm_protocal_c_aqy != null) {
            d bRe;
            switch (GameWebViewUI$2.mZY[a.AY(com_tencent_mm_protocal_c_aqy.wgQ).ordinal()]) {
                case 1:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", com_tencent_mm_protocal_c_aqy.wgR);
                    com.tencent.mm.bm.d.b(this.tFJ.mController.xIM, "webview", ".ui.tools.game.GameWebViewUI", intent);
                    return;
                case 2:
                    bRe = GameWebViewUI.d(this.tFJ).bRe();
                    bRe.tsX = new Object[]{this.tFJ.fIG, Integer.valueOf(32), Integer.valueOf(1)};
                    bRe.c(GameWebViewUI.c(this.tFJ));
                    if (!GameWebViewUI.e(this.tFJ)) {
                        this.tFJ.finish();
                        return;
                    }
                    return;
                case 3:
                    String stringExtra = this.tFJ.getIntent().getStringExtra("KPublisherId");
                    String stringExtra2 = this.tFJ.getIntent().getStringExtra("KAppId");
                    String stringExtra3 = this.tFJ.getIntent().getStringExtra("srcUsername");
                    d bRe2 = GameWebViewUI.g(this.tFJ).bRe();
                    bRe2.tsX = new Object[]{this.tFJ.fIG, Integer.valueOf(1), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                    bRe2.c(GameWebViewUI.f(this.tFJ));
                    GameWebViewUI.a(this.tFJ, GameWebViewUI.h(this.tFJ).bSt().cdC());
                    GameWebViewUI.i(this.tFJ);
                    return;
                case 4:
                    bRe = GameWebViewUI.k(this.tFJ).bRe();
                    bRe.tsX = new Object[]{this.tFJ.fIG, Integer.valueOf(3), Integer.valueOf(1)};
                    bRe.c(GameWebViewUI.j(this.tFJ));
                    g.pQN.a(157, 6, 1, false);
                    GameWebViewUI.b(this.tFJ, GameWebViewUI.l(this.tFJ).bSt().cdC());
                    GameWebViewUI.m(this.tFJ);
                    return;
                case 5:
                    bRe = GameWebViewUI.o(this.tFJ).bRe();
                    bRe.tsX = new Object[]{this.tFJ.fIG, Integer.valueOf(29), Integer.valueOf(1)};
                    bRe.c(GameWebViewUI.n(this.tFJ));
                    GameWebViewUI.p(this.tFJ);
                    return;
                case 6:
                    bRe = GameWebViewUI.r(this.tFJ).bRe();
                    bRe.tsX = new Object[]{this.tFJ.fIG, Integer.valueOf(30), Integer.valueOf(1)};
                    bRe.c(GameWebViewUI.q(this.tFJ));
                    GameWebViewUI.s(this.tFJ);
                    return;
                case 7:
                    bRe = GameWebViewUI.u(this.tFJ).bRe();
                    bRe.tsX = new Object[]{this.tFJ.fIG, Integer.valueOf(10), Integer.valueOf(1)};
                    bRe.c(GameWebViewUI.t(this.tFJ));
                    if (GameWebViewUI.v(this.tFJ) != null) {
                        GameWebViewUI.w(this.tFJ).reload();
                        return;
                    }
                    return;
                case 8:
                    bRe = GameWebViewUI.y(this.tFJ).bRe();
                    bRe.tsX = new Object[]{this.tFJ.fIG, Integer.valueOf(31), Integer.valueOf(1)};
                    bRe.c(GameWebViewUI.x(this.tFJ));
                    GameWebViewUI.z(this.tFJ);
                    return;
                case 9:
                    bRe = GameWebViewUI.B(this.tFJ).bRe();
                    bRe.tsX = new Object[]{this.tFJ.fIG, Integer.valueOf(11), Integer.valueOf(1)};
                    bRe.c(GameWebViewUI.A(this.tFJ));
                    GameWebViewUI.C(this.tFJ);
                    return;
                case 10:
                    if (GameWebViewUI.D(this.tFJ) != null) {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d E = GameWebViewUI.E(this.tFJ);
                        int i = com_tencent_mm_protocal_c_aqy.wyO;
                        x.i("MicroMsg.JsApiHandler", com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                        Map hashMap = new HashMap();
                        hashMap.put("itemId", Integer.valueOf(i));
                        ag.y(new 60(E, i.a.a(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME, hashMap, E.tGS, E.tGT)));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
