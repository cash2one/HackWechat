package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.tencent.mm.bc.l;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.fts.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import org.json.JSONObject;

class b$9 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ String iTD;
    final /* synthetic */ JSONObject joO;
    final /* synthetic */ b tlF;
    final /* synthetic */ ThreeDotsLoadingView tlG;
    final /* synthetic */ String tlI;
    final /* synthetic */ AbsoluteLayout tlJ;
    final /* synthetic */ View zS;

    b$9(b bVar, String str, ThreeDotsLoadingView threeDotsLoadingView, String str2, String str3, View view, AbsoluteLayout absoluteLayout, JSONObject jSONObject) {
        this.tlF = bVar;
        this.fgU = str;
        this.tlG = threeDotsLoadingView;
        this.tlI = str2;
        this.iTD = str3;
        this.zS = view;
        this.tlJ = absoluteLayout;
        this.joO = jSONObject;
    }

    public final void run() {
        int i;
        Bundle a = f.a("com.tencent.mm", new Bundle(), a.class);
        if (a != null) {
            i = a.getInt("search_wa_widget_init_out_time");
        } else {
            i = 0;
        }
        if (i == 0) {
            i = 8000;
        }
        x.i("FTSSearchWidgetMgr", "widget loading timeout is %d ms", new Object[]{Integer.valueOf(i)});
        if (i > 0) {
            ag.h(new Runnable(this) {
                final /* synthetic */ b$9 tlK;

                {
                    this.tlK = r1;
                }

                public final void run() {
                    if (b.e(this.tlK.tlF) != 4 && b.e(this.tlK.tlF) != 2 && b.e(this.tlK.tlF) != 3) {
                        x.e("FTSSearchWidgetMgr", "widget load timeout, unbind now");
                        b.bPe();
                        l.E(this.tlK.fgU, false);
                        this.tlK.tlG.ajm();
                        this.tlK.tlG.setVisibility(4);
                        b.a(this.tlK.tlF).cJ(this.tlK.tlI, 3);
                        b.f(this.tlK.tlF).bA(this.tlK.zS);
                        b.f(this.tlK.tlF).a(this.tlK.iTD, this.tlK.zS);
                        this.tlK.tlJ.removeView(this.tlK.zS);
                        g.pQN.h(14452, new Object[]{this.tlK.joO.optString("searchId") + "-" + this.tlK.fgU, Integer.valueOf(12), Long.valueOf(System.currentTimeMillis())});
                        g.pQN.a(646, 0, 1, false);
                    }
                }
            }, (long) i);
        }
    }
}
