package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.protocal.c.ama;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ak extends a {
    public static final int CTRL_BYTE = -3;
    public static final String NAME = "preVerifyJSAPI";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiPreVerify", "invoke");
        String optString = jSONObject.optString("verifyAppId");
        String optString2 = jSONObject.optString("verifySignature");
        String optString3 = jSONObject.optString("verifyNonceStr");
        String optString4 = jSONObject.optString("verifyTimestamp");
        String optString5 = jSONObject.optString("verifySignType");
        JSONArray optJSONArray = jSONObject.optJSONArray("verifyJsApiList");
        x.i("MicroMsg.GameJsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[]{optString, optString2, optString3, optString4, optString5});
        String aPk = dVar.aPk();
        LinkedList linkedList = new LinkedList();
        try {
            x.i("MicroMsg.GameJsApiPreVerify", "jsItem length %s", new Object[]{Integer.valueOf(optJSONArray.length())});
            if (optJSONArray.length() == 0) {
                dVar.E(i, "checkJsApi:param is empty");
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String string = optJSONArray.getString(i2);
                if (!bh.ov(string)) {
                    linkedList.add(string);
                }
            }
            if (bh.ov(optString) || linkedList.size() <= 0 || bh.ov(aPk)) {
                x.e("MicroMsg.GameJsApiPreVerify", "handlePreVerify wrong args, %s", new Object[]{optString});
                dVar.E(i, a.e("pre_verify_jsapi:fail_invalid_args", null));
                return;
            }
            b.a aVar = new b.a();
            aVar.hmj = new ama();
            aVar.hmk = new amb();
            aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
            aVar.hmi = 1093;
            aVar.hml = 0;
            aVar.hmm = 0;
            b JZ = aVar.JZ();
            ama com_tencent_mm_protocal_c_ama = (ama) JZ.hmg.hmo;
            com_tencent_mm_protocal_c_ama.url = aPk;
            com_tencent_mm_protocal_c_ama.fFm = optString;
            com_tencent_mm_protocal_c_ama.wsV = linkedList;
            com_tencent_mm_protocal_c_ama.fqD = optString4;
            com_tencent_mm_protocal_c_ama.wsG = optString3;
            com_tencent_mm_protocal_c_ama.signature = optString2;
            com_tencent_mm_protocal_c_ama.wsH = optString5;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new a(dVar, i, optString));
        } catch (Exception e) {
            x.w("MicroMsg.GameJsApiPreVerify", "exception occur " + e.getMessage());
            dVar.E(i, "pre_verify_jsapi:fail");
        }
    }
}
