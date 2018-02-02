package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.k.d.a;
import com.tencent.mm.k.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.bq;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p.c;
import com.tencent.wework.api.WWAPIFactory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class WebViewUI$38 implements c {
    final /* synthetic */ Boolean naj;
    final /* synthetic */ ArrayList nak;
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$38(WebViewUI webViewUI, Boolean bool, ArrayList arrayList) {
        this.tAv = webViewUI;
        this.naj = bool;
        this.nak = arrayList;
    }

    public final void a(n nVar) {
        g.pQN.a(480, 0, 1, false);
        int i;
        if (this.naj.booleanValue()) {
            int size = this.nak.size();
            for (i = 0; i < size; i++) {
                b bVar = (b) this.nak.get(i);
                o oVar = (o) nVar.f(bVar.id, bVar.title);
                oVar.ycf = bVar;
                oVar.setIcon(null);
                oVar.setIcon(0);
            }
            return;
        }
        try {
            LinkedList ap = WebViewUI.ap(this.tAv);
            if (ap != null) {
                i = 0;
                while (i < ap.size() && i < 8) {
                    a aVar = (a) ap.get(i);
                    if ("index".equals(bh.ou(aVar.id))) {
                        oVar = (o) nVar.a(15, this.tAv.getString(R.l.eWM), R.k.dwC);
                    } else if ("categories".equals(bh.ou(aVar.id))) {
                        oVar = (o) nVar.a(16, this.tAv.getString(R.l.eWL), R.k.dwB);
                    } else if ("cart".equals(bh.ou(aVar.id))) {
                        oVar = (o) nVar.a(17, this.tAv.getString(R.l.eWK), R.k.dwA);
                    } else if ("profile".equals(bh.ou(aVar.id))) {
                        oVar = (o) nVar.a(18, this.tAv.getString(R.l.eWO), R.k.dwH);
                    } else if ("member".equals(bh.ou(aVar.id))) {
                        oVar = (o) nVar.a(19, this.tAv.getString(R.l.eWN), R.k.dwD);
                    } else {
                        oVar = null;
                    }
                    if (oVar != null) {
                        oVar.jeE = aVar.url;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "exception in add jd menu, " + e.getMessage());
        }
        if (this.tAv.juR == null || this.tAv.juR.bSs() == null) {
            x.e("MicroMsg.WebViewUI", "get permission failed");
            return;
        }
        boolean gF;
        String bRR;
        JsapiPermissionWrapper bSs = this.tAv.juR.bSs();
        if (bSs.gn(21) && this.tAv.AK(1)) {
            nVar.a(1, this.tAv.getString(R.l.eBK), R.k.dwQ);
        }
        if (bSs.gn(23) && this.tAv.AK(2)) {
            nVar.a(2, this.tAv.getString(R.l.eBL), R.k.dwF);
        }
        if (!(WebViewUI.aq(this.tAv) && (bh.ov(WebViewUI.F(this.tAv)) || bh.ov(WebViewUI.ar(this.tAv)) || WebViewUI.F(this.tAv).startsWith(WebViewUI.ar(this.tAv)))) && WebViewUI.as(this.tAv) && this.tAv.AK(3)) {
            nVar.a(3, this.tAv.getString(R.l.eAd), R.k.dwy);
        }
        try {
            if (this.tAv.juQ.r(this.tAv.getIntent().getLongExtra("msg_id", Long.MIN_VALUE), this.tAv.getIntent().getStringExtra("sns_local_id"))) {
                nVar.a(23, this.tAv.getString(R.l.dZe), R.k.dwG);
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
        }
        nVar.a(31, this.tAv.getString(R.l.eYy), R.k.dwO);
        if (bSs.gn(44) && this.tAv.AK(6)) {
            nVar.a(6, this.tAv.getString(R.l.eXV), R.k.dws);
        }
        if (bSs.vAQ != null && WebViewUI.aq(this.tAv) && !bh.ov(WebViewUI.F(this.tAv)) && !bh.ov(WebViewUI.ar(this.tAv)) && WebViewUI.F(this.tAv).startsWith(WebViewUI.ar(this.tAv)) && this.tAv.getIntent().getBooleanExtra("key_detail_can_delete", true) && WebViewUI.as(this.tAv)) {
            if (this.tAv.AK(12)) {
                nVar.a(12, this.tAv.getString(R.l.eeF), R.k.dwn);
            }
            if (this.tAv.AK(9)) {
                nVar.a(9, this.tAv.getString(R.l.dEw), R.k.dwt);
            }
        }
        String stringExtra = this.tAv.getIntent().getStringExtra("srcUsername");
        if (!bh.ov(stringExtra)) {
            try {
                gF = this.tAv.juQ.gF(stringExtra);
            } catch (Exception e3) {
                x.e("MicroMsg.WebViewUI", "sharebtn click fail isBizContact, ex = " + e3.getMessage());
                gF = false;
            }
            if (gF) {
                boolean gE;
                try {
                    gE = this.tAv.juQ.gE(stringExtra);
                } catch (Exception e32) {
                    x.e("MicroMsg.WebViewUI", "sharebtn click fail, ex = " + e32.getMessage());
                    gE = false;
                }
                if (gE) {
                    gF = bSs.gn(19);
                } else {
                    gF = bSs.gn(20);
                }
                boolean bSR = this.tAv.bSR();
                if ((gF && this.tAv.AK(5)) || bSR) {
                    int i2 = gE ? R.l.eYg : R.l.eXX;
                    if (bSR) {
                        i2 = R.l.eYh;
                    }
                    nVar.a(5, this.tAv.getString(i2), R.k.dwp);
                }
            } else {
                try {
                    this.tAv.juQ.OS(stringExtra);
                } catch (Exception e322) {
                    x.e("MicroMsg.WebViewUI", "sharebtn click fail triggerGetContact, ex = " + e322.getMessage());
                }
            }
        }
        if (bSs.gn(bq.CTRL_INDEX) && this.tAv.AK(34)) {
            nVar.a(34, this.tAv.getString(R.l.eYw), R.k.dwL);
        }
        if (this.tAv.Vb()) {
            if (this.tAv.AK(32)) {
                nVar.a(32, this.tAv.getString(R.l.eBM), R.k.dwR);
            }
        } else if (this.tAv.AK(30)) {
            nVar.a(30, this.tAv.getString(R.l.eBR), R.k.dwS);
        }
        if (bSs.gn(45) && this.tAv.AK(7)) {
            nVar.a(7, this.tAv.getString(R.l.eYa), R.k.dwq);
        }
        if (bSs.gn(43) && this.tAv.AK(24) && !p.m(this.tAv.mController.xIM, "com.tencent.wework")) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("enterprise_action", "enterprise_has_connector");
                bundle = this.tAv.juQ.e(71, bundle);
                if (bundle != null) {
                    gF = bundle.getBoolean("enterprise_has_connector");
                    if (gF) {
                        nVar.a(24, this.tAv.getString(R.l.eBV), R.k.dww);
                    }
                }
            } catch (Exception e3222) {
                x.w("MicroMsg.WebViewUI", "builder add, ex = " + e3222.getMessage());
            }
            gF = false;
            if (gF) {
                nVar.a(24, this.tAv.getString(R.l.eBV), R.k.dww);
            }
        }
        if (bSs.gn(18) && this.tAv.AK(11)) {
            nVar.a(11, this.tAv.getString(R.l.eBJ), R.k.dwz);
        }
        if (this.tAv.AK(28)) {
            nVar.a(28, this.tAv.getString(R.l.eWu), R.k.dwM);
        }
        if (bSs.gn(73) && this.tAv.AK(14) && !WebViewUI.ad(this.tAv)) {
            nVar.a(14, this.tAv.getString(R.l.eYx), R.k.dwK);
        }
        if (WebViewUI.ad(this.tAv) && this.tAv.AK(14)) {
            nVar.a(14, this.tAv.getString(R.l.eYv), R.k.dwG);
        }
        gF = (this.tAv.juR.bSt().vAL & 16) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowExpose, ret = " + gF);
        if (gF && this.tAv.AK(10)) {
            nVar.a(10, this.tAv.getString(R.l.dMl), R.k.dwr);
        }
        if (bSs.gn(36) && this.tAv.AK(8)) {
            try {
                bRR = this.tAv.juQ.bRR();
            } catch (Exception e4) {
                bRR = null;
            }
            if (bh.ov(bRR)) {
                x.i("MicroMsg.WebViewUI", "get mail session key is null or nil, should not show send mail menu");
            } else {
                nVar.a(8, this.tAv.getString(R.l.eYc), R.k.dwE);
            }
        }
        if (bSs.gn(31) && this.tAv.AK(30)) {
            try {
                if (this.tAv.juQ.e(78, null).getBoolean("isOpenForFaceBook", false)) {
                    nVar.a(33, this.tAv.getString(R.l.eYB), R.k.dyl);
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e22, "", new Object[0]);
            }
        }
        if (WWAPIFactory.iN(this.tAv).cIg() && this.tAv.AK(25)) {
            bRR = WWAPIFactory.iN(this.tAv).cIh();
            nVar.a(25, this.tAv.getString(R.l.eBW, new Object[]{bRR}), R.k.dwU);
        }
        if (com.tencent.mm.plugin.webview.stub.a.aM(this.tAv, this.tAv.ptK.getUrl()) && this.tAv.AK(26)) {
            nVar.a(26, this.tAv.getString(R.l.eYA), R.k.dwT);
        }
        if (bSs.gn(91) && com.tencent.mm.plugin.webview.stub.a.dO(this.tAv) && this.tAv.AK(20)) {
            nVar.a(20, this.tAv.getString(R.l.eYC), R.k.dwI);
        }
        if (bSs.gn(d.CTRL_INDEX) && com.tencent.mm.plugin.webview.stub.a.dO(this.tAv) && this.tAv.AK(22)) {
            nVar.a(22, this.tAv.getString(R.l.eYD), R.k.dwJ);
        }
        try {
            if (bSs.gn(43) && this.tAv.AK(0) && this.tAv.juQ.LU()) {
                List<CharSequence> LT = this.tAv.juQ.LT();
                for (CharSequence add : LT) {
                    nVar.add(add);
                }
                WebViewUI.a(this.tAv, LT);
            }
        } catch (Exception e32222) {
            x.w("MicroMsg.WebViewUI", "builder add, ex = " + e32222.getMessage());
        }
        if (this.tAv.tyv != null && this.tAv.tyv.getVisibility() == 0) {
            nVar.a(27, this.tAv.getString(R.l.eBQ), R.k.dwx);
        }
        bRR = this.tAv.Po(WebViewUI.F(this.tAv));
        stringExtra = this.tAv.getIntent().getStringExtra("shortcut_user_name");
        if (!WebViewUI.v(this.tAv) && !bh.ov(bRR) && !bh.ov(stringExtra) && bSs.gn(255) && this.tAv.AK(29)) {
            nVar.a(29, this.tAv.getString(R.l.eBI), R.k.dBH);
        }
    }
}
