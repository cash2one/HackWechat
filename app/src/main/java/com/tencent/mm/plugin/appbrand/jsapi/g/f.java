package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.2;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 149;
    public static final String NAME = "requestPaymentToBank";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", jVar.mAppId);
            a aVar = a.joW;
            AppBrandStatObject appBrandStatObject = jVar.irP.iqH;
            b.a anonymousClass1 = new b.a(this) {
                final /* synthetic */ f jpe;

                public final void a(int i, String str, Map<String, Object> map) {
                    switch (i) {
                        case 1:
                            jVar.E(i, this.jpe.e("ok", map));
                            return;
                        default:
                            jVar.E(i, this.jpe.e("fail:" + str, null));
                            return;
                    }
                }
            };
            g gVar = new g(jSONObject);
            if (appBrandStatObject != null) {
                gVar.fqJ = g.eD(appBrandStatObject.scene, appBrandStatObject.fIr);
            }
            gVar.fCV = 46;
            MMActivity.a 2 = new 2(aVar, anonymousClass1);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar.appId);
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.fCT);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.url);
            intent.putExtra("pay_scene", gVar.fCW);
            a.jwN = 2;
            d.a(a, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, aVar.hashCode() & 65535, false);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiRequestPaymentToBank", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}
