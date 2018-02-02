package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;

public enum g {
    UUID_EXPIRED(e.CTRL_INDEX),
    UUID_CANCELED(ap.CTRL_INDEX),
    UUID_SCANED(TencentLocation.ERROR_UNKNOWN),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(av.CTRL_INDEX),
    UUID_ERROR(500);
    
    private int code;

    private g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
