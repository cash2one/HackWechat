package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.k.d.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$37 implements d {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$37(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String stringExtra;
        Throwable e;
        boolean z;
        boolean z2 = false;
        if (WebViewUI.i(menuItem)) {
            b bVar = (b) menuItem.getMenuInfo();
            if (bVar != null) {
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.tAv.tlx;
                x.i("MicroMsg.JsApiHandler", "onCustomMenuClick");
                Map hashMap = new HashMap();
                hashMap.put("key", bVar.aAM);
                hashMap.put("title", bVar.title);
                dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a.a("menu:custom", hashMap, dVar.tGS, dVar.tGT) + ")", null);
                return;
            }
            return;
        }
        String stringExtra2;
        String stringExtra3;
        aj.d bRe;
        aj.d bRe2;
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                stringExtra2 = this.tAv.getIntent().getStringExtra("KPublisherId");
                stringExtra3 = this.tAv.getIntent().getStringExtra("KAppId");
                stringExtra = this.tAv.getIntent().getStringExtra("srcUsername");
                bRe = this.tAv.trN.bRe();
                bRe.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(1), Integer.valueOf(1), stringExtra2, stringExtra3, stringExtra};
                bRe.c(this.tAv.juQ);
                this.tAv.tyF = this.tAv.juR.bSt().cdC();
                this.tAv.aPD();
                return;
            case 2:
                int intValue;
                stringExtra2 = this.tAv.getIntent().getStringExtra("KPublisherId");
                stringExtra3 = this.tAv.getIntent().getStringExtra("KAppId");
                stringExtra = this.tAv.getIntent().getStringExtra("srcUsername");
                bRe = this.tAv.trN.bRe();
                bRe.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(2), Integer.valueOf(1), stringExtra2, stringExtra3, stringExtra};
                bRe.c(this.tAv.juQ);
                this.tAv.tyF = this.tAv.juR.bSt().cdC();
                if (WebViewUI.Y(this.tAv).containsKey(this.tAv.ptK.getUrl())) {
                    intValue = ((Integer) WebViewUI.Y(this.tAv).get(this.tAv.ptK.getUrl())).intValue();
                } else {
                    intValue = 0;
                }
                WebViewUI webViewUI = this.tAv;
                webViewUI.tlx.aQ("shareTimeline", true);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2 = webViewUI.tlx;
                if (dVar2.tGQ) {
                    try {
                        dVar2.juQ.E("urlAttribute", String.valueOf(intValue), dVar2.tvn);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    }
                    dVar2.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a.a("menu:share:timeline", new HashMap(), dVar2.tGS, dVar2.tGT) + ")", null);
                } else {
                    x.e("MicroMsg.JsApiHandler", "onShareTimeline fail, not ready");
                }
                webViewUI.trN.Ow("mm_share_sns_count");
                return;
            case 3:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(3), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                g.pQN.a(157, 6, 1, false);
                this.tAv.tyF = this.tAv.juR.bSt().cdC();
                this.tAv.aPK();
                return;
            case 5:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(4), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                stringExtra2 = (String) WebViewUI.h(this.tAv).get(this.tAv.ptK.getUrl());
                if (stringExtra2 == null) {
                    stringExtra2 = this.tAv.getIntent().getStringExtra("srcUsername");
                }
                WebViewUI.h(this.tAv, "Contact_Scene");
                WebViewUI.i(this.tAv, stringExtra2);
                return;
            case 6:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(5), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.Z(this.tAv);
                return;
            case 7:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(13), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.aa(this.tAv);
                return;
            case 8:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(15), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.ab(this.tAv);
                return;
            case 9:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(7), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.ac(this.tAv);
                return;
            case 10:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(11), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                this.tAv.bST();
                return;
            case 11:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(8), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                if (WebViewUI.Q(this.tAv).getVisibility() == 8) {
                    WebViewUI.Q(this.tAv).startAnimation(AnimationUtils.loadAnimation(this.tAv, R.a.bqb));
                    WebViewUI.Q(this.tAv).setVisibility(0);
                    return;
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(this.tAv, R.a.bqc);
                loadAnimation.setAnimationListener(new 1(this));
                WebViewUI.Q(this.tAv).startAnimation(loadAnimation);
                WebViewUI.Q(this.tAv).setVisibility(8);
                return;
            case 12:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(6), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                intent = new Intent();
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", this.tAv.getIntent().getLongExtra("fav_local_id", -1));
                com.tencent.mm.bm.d.b(this.tAv.mController.xIM, "favorite", ".ui.FavTagEditUI", intent);
                this.tAv.trN.Ow("mm_edit_fav_count");
                return;
            case 14:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(9), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                if (WebViewUI.ad(this.tAv)) {
                    WebViewUI.j(this.tAv, WebViewUI.ag(this.tAv));
                    return;
                } else {
                    WebViewUI.a(this.tAv, this.tAv.ptK.getUrl(), this.tAv.ptK.getSettings().getUserAgentString(), WebViewUI.ae(this.tAv), WebViewUI.af(this.tAv));
                    return;
                }
            case 15:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(19), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.a(this.tAv, menuItem);
                return;
            case 16:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(21), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.a(this.tAv, menuItem);
                return;
            case 17:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(20), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.a(this.tAv, menuItem);
                return;
            case 18:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(22), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.a(this.tAv, menuItem);
                return;
            case 19:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(23), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.a(this.tAv, menuItem);
                return;
            case 20:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(17), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.aj(this.tAv);
                return;
            case 21:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(18), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.ak(this.tAv);
                return;
            case 22:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(24), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.al(this.tAv);
                return;
            case 23:
                intent = new Intent();
                stringExtra3 = this.tAv.getIntent().getStringExtra("sns_local_id");
                if (stringExtra3 != null) {
                    intent.putExtra("sns_send_data_ui_activity", true);
                    intent.putExtra("sns_local_id", stringExtra3);
                } else {
                    intent.putExtra("Retr_Msg_Id", Long.valueOf(this.tAv.getIntent().getLongExtra("msg_id", Long.MIN_VALUE)));
                }
                com.tencent.mm.bm.d.a(this.tAv.mController.xIM, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                return;
            case 24:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(16), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.an(this.tAv);
                return;
            case 25:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(26), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.ah(this.tAv);
                return;
            case 26:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(27), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.ai(this.tAv);
                return;
            case 27:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(32), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                if (!this.tAv.aPo()) {
                    this.tAv.finish();
                    return;
                }
                return;
            case 28:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(10), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                if (this.tAv.ptK != null) {
                    this.tAv.ptK.reload();
                    return;
                }
                return;
            case 29:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(31), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                this.tAv.aPJ();
                return;
            case 30:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(29), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                this.tAv.aPG();
                return;
            case 31:
                g.pQN.a(480, 1, 1, false);
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(28), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                if (!this.tAv.tyA.isShown()) {
                    this.tAv.tyA.reset();
                    this.tAv.tyA.bUR();
                    this.tAv.tyA.show();
                    return;
                }
                return;
            case 32:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(30), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                this.tAv.aPH();
                return;
            case 33:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(14), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                WebViewUI.am(this.tAv);
                return;
            case 34:
                WebViewUI.ao(this.tAv);
                return;
            default:
                bRe2 = this.tAv.trN.bRe();
                bRe2.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(16), Integer.valueOf(1)};
                bRe2.c(this.tAv.juQ);
                stringExtra = menuItem.getTitle();
                if (!bh.ov(stringExtra)) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString(SlookAirButtonFrequentContactAdapter.DATA, stringExtra);
                        bundle = this.tAv.juQ.e(50, bundle);
                        if (bundle != null) {
                            z = bundle.getInt("key_biz_type") == 2;
                            try {
                                if (bundle.getInt("key_biz_type") == 3) {
                                    z2 = true;
                                }
                            } catch (RemoteException e3) {
                                e2 = e3;
                                x.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
                                z2 = z;
                                if (z2) {
                                    WebViewUI.l(this.tAv, stringExtra);
                                    return;
                                } else {
                                    WebViewUI.k(this.tAv, stringExtra);
                                    return;
                                }
                            }
                        }
                    } catch (RemoteException e4) {
                        e2 = e4;
                        z = false;
                        x.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
                        z2 = z;
                        if (z2) {
                            WebViewUI.k(this.tAv, stringExtra);
                            return;
                        } else {
                            WebViewUI.l(this.tAv, stringExtra);
                            return;
                        }
                    }
                    if (z2) {
                        WebViewUI.k(this.tAv, stringExtra);
                        return;
                    } else {
                        WebViewUI.l(this.tAv, stringExtra);
                        return;
                    }
                }
                return;
        }
    }
}
