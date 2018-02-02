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

class d$1 implements a {
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
    final /* synthetic */ d jqR;

    d$1(d dVar, j jVar, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, boolean z, String str7, AppBrandSysConfig appBrandSysConfig, p pVar, String str8, boolean z2, boolean z3, String str9, int i3, MMActivity mMActivity) {
        this.jqR = dVar;
        this.iZy = jVar;
        this.gOK = i;
        this.fgU = str;
        this.hpU = str2;
        this.icx = str3;
        this.jqG = str4;
        this.jqH = str5;
        this.jqE = str6;
        this.iGh = i2;
        this.jqJ = z;
        this.jqI = str7;
        this.iri = appBrandSysConfig;
        this.jfB = pVar;
        this.jqK = str8;
        this.jqF = z2;
        this.jqL = z3;
        this.hjS = str9;
        this.jqM = i3;
        this.fgW = mMActivity;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 1) {
            x.i("MicroMsg.JsApiShareAppMessageDirectly", "requestCode(%d) not corrected.", new Object[]{Integer.valueOf(i)});
        } else if (i2 != -1) {
            x.i("MicroMsg.JsApiShareAppMessageDirectly", "resultCode is not RESULT_OK(%d)", new Object[]{Integer.valueOf(i2)});
            this.iZy.E(this.gOK, this.jqR.e("cancel", null));
        } else {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (stringExtra == null || stringExtra.length() == 0) {
                x.e("MicroMsg.JsApiShareAppMessageDirectly", "mmOnActivityResult fail, toUser is null");
                this.iZy.E(this.gOK, this.jqR.e("fail:selected user is nil", null));
                return;
            }
            x.i("MicroMsg.JsApiShareAppMessageDirectly", "result success toUser : %s ", new Object[]{stringExtra});
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            MainProcessTask sendAppMessageTask = new SendAppMessageTask();
            sendAppMessageTask.jqV = stringExtra2;
            sendAppMessageTask.toUser = stringExtra;
            sendAppMessageTask.appId = this.fgU;
            sendAppMessageTask.userName = this.hpU;
            sendAppMessageTask.title = this.icx;
            sendAppMessageTask.description = this.jqG;
            sendAppMessageTask.url = this.jqH;
            sendAppMessageTask.path = this.jqE;
            sendAppMessageTask.type = this.iGh;
            sendAppMessageTask.jqY = this.jqJ;
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
            sendAppMessageTask.jqX = j.sK(this.jqK);
            sendAppMessageTask.withShareTicket = this.jqF;
            sendAppMessageTask.jrd = this.jqL;
            sendAppMessageTask.iUc = this.hjS;
            sendAppMessageTask.hoL = this.jqM;
            com.tencent.mm.plugin.appbrand.jsapi.n.a ajb = this.jfB.ajb();
            if (ajb == null) {
                stringExtra = "";
            } else {
                stringExtra = ajb.juE.getUrl();
            }
            sendAppMessageTask.jre = stringExtra;
            if (this.jqF) {
                sendAppMessageTask.jcI = new 1(this, sendAppMessageTask);
                sendAppMessageTask.afi();
                AppBrandMainProcessService.a(sendAppMessageTask);
            } else {
                AppBrandMainProcessService.a(sendAppMessageTask);
                this.iZy.E(this.gOK, this.jqR.e("ok", null));
            }
            if (this.fgW != null) {
                com.tencent.mm.ui.base.h.bu(this.fgW, this.fgW.getResources().getString(q.j.iyr));
            }
        }
    }
}
