package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.h.q.e;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;

public final class b {
    public static boolean a(Exception exception) {
        if (!(exception instanceof e)) {
            return false;
        }
        int i = ((e) exception).responseCode;
        if (i == TencentLocation.ERROR_UNKNOWN || i == JsApiBatchGetContact.CTRL_INDEX) {
            return true;
        }
        return false;
    }
}
