package com.tencent.mm.pluginsdk.f;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a {
    public static Bundle Rp(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_scene", 1);
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            x.e("MicroMsg.MallManager", "getWapPayBundle arrKeys == null || arrKeys.length == 0");
            return bundle;
        }
        HashMap hashMap = new HashMap();
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                String[] split2 = obj.split("=");
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        bundle.putString("_wxapi_payreq_appid", b("appid", hashMap));
        bundle.putString("_wxapi_payreq_partnerid", b("partnerid", hashMap));
        bundle.putString("_wxapi_payreq_prepayid", b("prepayid", hashMap));
        bundle.putString("_wxapi_payreq_noncestr", b("noncestr", hashMap));
        bundle.putString("_wxapi_payreq_timestamp", b("timestamp", hashMap));
        bundle.putString("_wxapi_payreq_packagevalue", b("package", hashMap));
        bundle.putString("_wxapi_payreq_sign", b("sign", hashMap));
        bundle.putString("_wxapi_payreq_sign_type", b("signtype", hashMap));
        bundle.putString("_wxapi_payreq_extdata", b("extdata", hashMap));
        bundle.putString("_wxapi_payoptions_callback_classname", "");
        bundle.putInt("_wxapi_payoptions_callback_flags", -1);
        return bundle;
    }

    private static String b(String str, HashMap<String, String> hashMap) {
        String str2 = (String) hashMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        x.e("MicroMsg.MallManager", "getWapPayKey key: " + str + " value is empty");
        return "";
    }
}
