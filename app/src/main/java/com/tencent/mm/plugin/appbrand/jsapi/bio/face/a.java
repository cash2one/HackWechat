package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.facedetect.ui.FaceTransparentStubUI;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    protected abstract boolean afQ();

    protected abstract String afR();

    static /* synthetic */ void a(a aVar, j jVar, int i, Bundle bundle, String str) {
        int i2 = -1;
        String str2 = "not returned";
        Object obj = "";
        if (bundle != null) {
            i2 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            obj = bundle.getString("verify_result");
        }
        Map hashMap = new HashMap(3);
        hashMap.put("errCode", Integer.valueOf(i2));
        hashMap.put("verifyResult", obj);
        if ("fail".equals(str)) {
            str = str + " " + str2;
        }
        jVar.E(i, aVar.e(str, hashMap));
    }

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        super.a(jVar, jSONObject, i);
        Context a = a(jVar);
        if (a == null) {
            x.e("MicroMsg.JsApiFaceAsyncBase", "JsApiFaceAsyncBase context is null, appId is %s", new Object[]{jVar.mAppId});
            jVar.E(i, e("fail", null));
            return;
        }
        String optString = jSONObject.optString("requestVerifyPreInfo");
        String str = jVar.mAppId;
        int i2 = afQ() ? 1001 : 1000;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putInt("k_server_scene", 5);
        bundle.putBoolean("key_is_need_video", afQ());
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_app_id", str);
        bundle.putString("request_verify_pre_info", optString);
        bundle.putInt("key_business_type", 4);
        bundle.putString("key_function_name", afR());
        Intent intent = new Intent(a, FaceTransparentStubUI.class);
        intent.putExtra("KEY_EXTRAS", bundle);
        intent.putExtra("KEY_REQUEST_CODE", i2);
        a.jwN = new com.tencent.mm.ui.MMActivity.a(this) {
            final /* synthetic */ a jhs;

            public final void b(int i, int i2, Intent intent) {
                int i3 = 90199;
                Bundle bundle = null;
                if (intent != null) {
                    i3 = intent.getIntExtra("err_code", 90199);
                }
                a aVar;
                j jVar;
                int i4;
                if (i == 1000) {
                    x.i("MicroMsg.JsApiFaceAsyncBase", "alvinluo: requestWxFacePictureVerify errCode: %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 == 0) {
                        aVar = this.jhs;
                        jVar = jVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, jVar, i4, bundle, "ok");
                    } else if (i3 == 90100) {
                        aVar = this.jhs;
                        jVar = jVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, jVar, i4, bundle, "cancel");
                    } else {
                        aVar = this.jhs;
                        jVar = jVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, jVar, i4, bundle, "fail");
                    }
                } else if (i == 1001) {
                    x.i("MicroMsg.JsApiFaceAsyncBase", "hy: REQUEST_FACE_DETECT_WITH_VIDEO errCode: %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 == 0) {
                        aVar = this.jhs;
                        jVar = jVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, jVar, i4, bundle, "ok");
                    } else if (i3 == 90100) {
                        aVar = this.jhs;
                        jVar = jVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, jVar, i4, bundle, "cancel");
                    } else {
                        aVar = this.jhs;
                        jVar = jVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, jVar, i4, bundle, "fail");
                    }
                }
            }
        };
        a.startActivityForResult(intent, i2);
    }
}
