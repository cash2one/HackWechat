package com.tencent.mm.plugin.appbrand.r.e;

import com.tencent.mm.sdk.platformtools.x;

public final class d extends g implements b {
    private String jTp = "*";

    public final void uK(String str) {
        if (str == null) {
            x.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
        } else {
            this.jTp = str;
        }
    }

    public final String alZ() {
        return this.jTp;
    }
}
