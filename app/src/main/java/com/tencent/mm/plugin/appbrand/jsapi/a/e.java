package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 402;
    public static final String NAME = "openRealnameAuth";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiOpenRealnameAuth", "getIDCardInfo data is null");
            pVar.E(i, e("fail:data is null", null));
            return;
        }
        MMActivity mMActivity = (MMActivity) pVar.mContext;
        if (mMActivity == null) {
            pVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenRealnameAuth", "mmActivity is null, invoke fail!");
            return;
        }
        String optString = jSONObject.optString("categoryId", "");
        if (bh.ov(optString)) {
            x.e("MicroMsg.JsApiOpenRealnameAuth", "category_id is null");
            Map hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(40003));
            pVar.E(i, e("fail:category_id is empty", hashMap));
            return;
        }
        x.i("MicroMsg.JsApiOpenRealnameAuth", "getIDCardInfo category_id:%s, appId:%s", new Object[]{optString, pVar.mAppId});
        Intent intent = new Intent(mMActivity, AppBrandIDCardUI.class);
        intent.putExtra("intent_appid", r2);
        intent.putExtra("intent_category_id", optString);
        mMActivity.jwN = new 1(this, pVar, i);
        mMActivity.startActivityForResult(intent, 1);
        g.pQN.h(14943, new Object[]{r2, Integer.valueOf(1), ""});
    }
}
