package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.4;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 218;
    public static final String NAME = "sendBizRedPacket";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", jVar.mAppId);
            a aVar = a.joW;
            b.a 1 = new 1(this, jVar, i);
            g gVar = new g(jSONObject);
            gVar.fqJ = 16;
            MMActivity.a 4 = new 4(aVar, 1);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", gVar.appId);
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.fCT);
            intent.putExtra("key_static_from_scene", 100004);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.url);
            a.jwN = 4;
            d.a(a, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, aVar.hashCode() & 65535, false);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiSendBizRedPacket", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}
