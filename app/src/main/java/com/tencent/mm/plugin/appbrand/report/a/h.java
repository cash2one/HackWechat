package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private String fnp;
    public b jIl;
    public int jIm;
    public String jIn;
    private long jIo;
    public a jIp;

    public enum a {
        NEARBY_H5(1),
        EMPTY_PAGE(2),
        LBS_NOT_ALLOW(3),
        NEARBY_MINI_PROGRAM(4);
        
        public final int value;

        private a(int i) {
            this.value = i;
        }
    }

    public final String toString() {
        return "kv_13917{scene=" + this.jIl.value + ", appCount=" + this.jIm + ", nearbyListId='" + this.jIn + '\'' + ", clickTime=" + this.jIo + ", sceneNote='" + this.fnp + '\'' + ", openType=" + this.jIp.value + '}';
    }

    public final void wW() {
        if (this.jIl != null && this.jIp != null) {
            x.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
            this.jIo = bh.Wp();
            g.pQN.h(13917, e.h(new Object[]{Integer.valueOf(this.jIl.value), Integer.valueOf(this.jIm), this.jIn, Long.valueOf(this.jIo), this.fnp, Integer.valueOf(this.jIp.value)}));
        }
    }
}
