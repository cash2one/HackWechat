package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.b.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public enum a implements b {
    ;

    private a(String str) {
    }

    public final boolean a(MMActivity mMActivity, AppBrandStatObject appBrandStatObject, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.jsapi.g.b.a aVar, PString pString) {
        g gVar = new g(jSONObject);
        if (appBrandStatObject != null) {
            gVar.fqJ = g.eD(appBrandStatObject.scene, appBrandStatObject.fIr);
        }
        gVar.fCV = 46;
        pString.value = gVar.packageExt;
        return h.a(mMActivity, gVar, hashCode() & 65535, new 1(this, aVar));
    }

    public final void a(MMActivity mMActivity, JSONObject jSONObject, final b bVar) {
        com.tencent.mm.ui.MMActivity.a anonymousClass5 = new com.tencent.mm.ui.MMActivity.a(this) {
            final /* synthetic */ a joZ;

            public final void b(int i, int i2, Intent intent) {
                if (i == (this.joZ.hashCode() & 65535)) {
                    if (i2 == -1) {
                        Object obj = "";
                        if (intent != null) {
                            obj = bh.az(intent.getStringExtra("token"), "");
                        }
                        if (TextUtils.isEmpty(obj)) {
                            x.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
                            if (bVar != null) {
                                bVar.d(false, null);
                                return;
                            }
                            return;
                        }
                        x.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
                        if (bVar != null) {
                            bVar.d(true, obj);
                        }
                    } else if (bVar != null) {
                        bVar.d(false, null);
                    }
                }
            }
        };
        g gVar = new g(jSONObject);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar.appId);
        intent.putExtra("timeStamp", gVar.timeStamp);
        intent.putExtra("nonceStr", gVar.nonceStr);
        intent.putExtra("packageExt", gVar.packageExt);
        intent.putExtra("signtype", gVar.signType);
        intent.putExtra("paySignature", gVar.fCT);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.url);
        intent.putExtra("scene", 1);
        mMActivity.jwN = anonymousClass5;
        Context context = mMActivity;
        d.a(context, "wallet_core", ".ui.WalletCheckPwdUI", intent, 65535 & hashCode(), false);
    }
}
