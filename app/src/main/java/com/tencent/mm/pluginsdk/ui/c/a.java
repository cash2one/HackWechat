package com.tencent.mm.pluginsdk.ui.c;

import com.qq.taf.jce.JceStruct;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.ui.tools.a.a {
    public int hX = JceStruct.JCE_MAX_STRING_LENGTH;
    private String qtl;
    private a vsR;

    private a(String str) {
        this.qtl = str;
    }

    public static a SD(String str) {
        return new a(str);
    }

    public final int cci() {
        return adc();
    }

    protected final int adc() {
        int shouldRemuxing;
        int i = 10485760;
        if (bh.ov(this.qtl)) {
            x.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
        }
        boolean is2G = an.is2G(ac.getContext());
        if (c.oy(this.qtl)) {
            double d;
            String str = this.qtl;
            if (!is2G) {
                i = this.hX;
            }
            if (is2G) {
                d = 60000.0d;
            } else {
                d = (double) this.hX;
            }
            shouldRemuxing = SightVideoJNI.shouldRemuxing(str, 660, 500, i, d, Constants.MAX_BUFFER_SIZE);
        } else {
            if (e.bN(this.qtl) > (is2G ? 10485760 : 26214400)) {
                shouldRemuxing = -1;
            } else {
                shouldRemuxing = 1;
            }
        }
        x.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", new Object[]{Integer.valueOf(shouldRemuxing), Boolean.valueOf(r10)});
        switch (shouldRemuxing) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
                return 1;
            case -1:
                return 2;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return 0;
            default:
                x.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", new Object[]{Integer.valueOf(shouldRemuxing)});
                return 1;
        }
    }

    protected final void ccj() {
        if (this.vsR == null) {
            x.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
        } else {
            adc();
        }
    }
}
