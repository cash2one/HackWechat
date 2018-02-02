package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.u;

public final class e {

    public interface c {
        boolean a(String str, Context context, u uVar, String str2);
    }

    public static boolean a(String str, Context context, u uVar, String str2) {
        if (bh.ov(str)) {
            return false;
        }
        c cVar = null;
        if (str.startsWith("weixin://openNativeUrl/weixinHB")) {
            cVar = new a();
        } else {
            boolean z;
            if (str == null || !(str.startsWith("weixin://openNativeUrl/myDeviceList") || str.startsWith("weixin://openNativeUrl/bindMyDevice"))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                cVar = new b();
            } else {
                if (str == null || !(str.startsWith("weixin://wesport/recommend") || str.startsWith("weixin://openNativeUrl/rankMyHomepage") || str.startsWith("weixin://openNativeUrl/rankSetting"))) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    cVar = new d();
                }
            }
        }
        if (cVar == null || !cVar.a(str, context, uVar, str2)) {
            return false;
        }
        return true;
    }
}
