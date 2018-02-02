package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

class c$1 implements a {
    final /* synthetic */ String fgU;
    final /* synthetic */ MMActivity fgW;
    final /* synthetic */ int gOK;
    final /* synthetic */ String hjS;
    final /* synthetic */ String hpU;
    final /* synthetic */ int iGh;
    final /* synthetic */ j iZy;
    final /* synthetic */ String icx;
    final /* synthetic */ AppBrandSysConfig iri;
    final /* synthetic */ p jfB;
    final /* synthetic */ String jqE;
    final /* synthetic */ boolean jqF;
    final /* synthetic */ String jqG;
    final /* synthetic */ String jqH;
    final /* synthetic */ String jqI;
    final /* synthetic */ boolean jqJ;
    final /* synthetic */ String jqK;
    final /* synthetic */ boolean jqL;
    final /* synthetic */ int jqM;
    final /* synthetic */ c jqN;

    c$1(c cVar, j jVar, int i, String str, String str2, boolean z, String str3, String str4, String str5, String str6, int i2, String str7, AppBrandSysConfig appBrandSysConfig, p pVar, boolean z2, String str8, boolean z3, String str9, int i3, MMActivity mMActivity) {
        this.jqN = cVar;
        this.iZy = jVar;
        this.gOK = i;
        this.fgU = str;
        this.jqE = str2;
        this.jqF = z;
        this.hpU = str3;
        this.icx = str4;
        this.jqG = str5;
        this.jqH = str6;
        this.iGh = i2;
        this.jqI = str7;
        this.iri = appBrandSysConfig;
        this.jfB = pVar;
        this.jqJ = z2;
        this.jqK = str8;
        this.jqL = z3;
        this.hjS = str9;
        this.jqM = i3;
        this.fgW = mMActivity;
    }

    public final void b(int i, int i2, Intent intent) {
        int i3 = 16;
        if (i != 1) {
            x.i("MicroMsg.JsApiShareAppMessage", "requestCode(%d) not corrected.", Integer.valueOf(i));
        } else if (i2 != -1) {
            x.i("MicroMsg.JsApiShareAppMessage", "resultCode is not RESULT_OK(%d)", Integer.valueOf(i2));
            this.iZy.E(this.gOK, this.jqN.e("cancel", null));
            r0 = this.fgU;
            r1 = this.jqE;
            if (!this.jqF) {
                i3 = 2;
            }
            c.a(r0, r1, i3, "", 3, i2);
        } else {
            r1 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (r1 == null || r1.length() == 0) {
                x.e("MicroMsg.JsApiShareAppMessage", "mmOnActivityResult fail, toUser is null");
                this.iZy.E(this.gOK, this.jqN.e("fail:selected user is nil", null));
                if (!this.jqF) {
                    i3 = 2;
                }
                c.a(this.fgU, this.jqE, i3, "", 2, i2);
                return;
            }
            x.i("MicroMsg.JsApiShareAppMessage", "result success toUser : %s ", r1);
            r0 = intent.getStringExtra("custom_send_text");
            MainProcessTask sendAppMessageTask = new SendAppMessageTask();
            sendAppMessageTask.jqV = r0;
            sendAppMessageTask.toUser = r1;
            sendAppMessageTask.appId = this.fgU;
            sendAppMessageTask.userName = this.hpU;
            sendAppMessageTask.title = this.icx;
            sendAppMessageTask.description = this.jqG;
            sendAppMessageTask.url = this.jqH;
            sendAppMessageTask.path = this.jqE;
            sendAppMessageTask.type = this.iGh;
            sendAppMessageTask.jqW = this.jqI;
            sendAppMessageTask.iconUrl = this.iri.iOg;
            sendAppMessageTask.fvM = this.iri.iOI.iGK;
            sendAppMessageTask.iPL = this.iri.iOI.fqR;
            sendAppMessageTask.version = this.iri.iOI.iGL;
            sendAppMessageTask.fpL = this.iri.frn;
            sendAppMessageTask.jqZ = i.pm(this.fgU).irJ.getAndIncrement();
            sendAppMessageTask.jrb = this.jfB.getURL();
            sendAppMessageTask.jrc = this.jfB.aeH();
            AppBrandStatObject oT = com.tencent.mm.plugin.appbrand.a.oT(this.fgU);
            if (oT != null) {
                sendAppMessageTask.scene = oT.scene == 0 ? 1000 : oT.scene;
                sendAppMessageTask.fnp = bh.ou(oT.fnp);
                sendAppMessageTask.jra = bh.ou(h.e(this.iZy.irP).irG);
            }
            sendAppMessageTask.jqY = this.jqJ;
            sendAppMessageTask.jqX = j.sK(this.jqK);
            sendAppMessageTask.withShareTicket = this.jqF;
            sendAppMessageTask.jrd = this.jqL;
            sendAppMessageTask.iUc = this.hjS;
            sendAppMessageTask.hoL = this.jqM;
            com.tencent.mm.plugin.appbrand.jsapi.n.a ajb = this.jfB.ajb();
            if (ajb == null) {
                r0 = "";
            } else {
                r0 = ajb.juE.getUrl();
            }
            sendAppMessageTask.jre = r0;
            if (this.jqF) {
                sendAppMessageTask.jcI = new 1(this, sendAppMessageTask, r1, i2);
                sendAppMessageTask.afi();
                AppBrandMainProcessService.a(sendAppMessageTask);
            } else {
                AppBrandMainProcessService.a(sendAppMessageTask);
                this.iZy.E(this.gOK, this.jqN.e("ok", null));
                if (r1.toLowerCase().endsWith("@chatroom")) {
                    i3 = 9;
                } else {
                    i3 = 2;
                }
                c.a(this.fgU, this.jqE, i3, "", 1, i2);
            }
            if (this.fgW != null) {
                com.tencent.mm.ui.base.h.bu(this.fgW, this.fgW.getResources().getString(q.j.iyr));
            }
        }
    }
}
