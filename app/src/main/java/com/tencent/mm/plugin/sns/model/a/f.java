package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.n;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.k.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class f extends c {
    protected boolean qZe = false;
    protected boolean qZf = false;
    protected boolean qZg = false;
    protected boolean qZh = false;

    public f(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String KK(String str) {
        String str2;
        Exception e;
        int i = 2;
        Object obj = null;
        try {
            int i2;
            Object obj2;
            Object obj3;
            int i3;
            String value = g.zY().getValue("SnsCloseDownloadWebp");
            if (bh.ov(value)) {
                i2 = 0;
            } else {
                i2 = bh.VI(value);
            }
            if (i2 != 0) {
                obj2 = null;
            } else if (VERSION.SDK_INT < 14) {
                obj2 = null;
            } else if (q.gGe.gFz == 2) {
                obj2 = null;
            } else if (bh.ov(r.ieg)) {
                int i4 = 1;
            } else {
                obj2 = null;
            }
            if (!n.yw()) {
                obj3 = null;
            } else if (!ae.bvG()) {
                obj3 = null;
            } else if (bh.ov(r.ieg)) {
                i2 = 1;
            } else {
                obj3 = null;
            }
            if (n.yw() && ae.bvF() && bh.ov(r.ieg)) {
                i3 = 1;
            }
            if (!bh.ov(r.ief) || !bh.ov(r.ieg)) {
                if (!bh.ov(r.ief)) {
                    String[] split = str.split("(//?)");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split[0]).append("//").append(r.ief);
                    while (i < split.length) {
                        stringBuilder.append("/").append(split[i]);
                        i++;
                    }
                    str = stringBuilder.toString();
                    x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
                }
                if (!bh.ov(r.ieg)) {
                    str = k(str, "tp=" + r.ieg);
                    x.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  " + str);
                }
            } else if (obj3 != null) {
                str = k(str, "tp=wxpc");
                x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            } else if (obj != null) {
                str = k(str, "tp=hevc");
                x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            } else if (obj2 != null) {
                str = k(str, "tp=webp");
                x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            }
            if (!(this.qYF == null || this.qYF.qTV.wxQ == 0)) {
                str = k(str, "enc=1");
                x.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.qYF.qTV.wxR + " " + this.qYF.qTV.wxQ + " " + str);
                b.pY(h.CTRL_INDEX);
                this.qZh = true;
            }
            str2 = str;
            try {
                if (!(this.qYF == null || this.qYF.qTV == null)) {
                    Object obj4;
                    aqr com_tencent_mm_protocal_c_aqr = this.qYF.qTV;
                    if (this.qYF.qYz) {
                        obj4 = com_tencent_mm_protocal_c_aqr.wxW;
                    } else {
                        String str3 = com_tencent_mm_protocal_c_aqr.wxT;
                    }
                    i3 = this.qYF.qYz ? com_tencent_mm_protocal_c_aqr.wxX : com_tencent_mm_protocal_c_aqr.wxU;
                    if (!TextUtils.isEmpty(obj4)) {
                        str2 = k(str2, "token=" + obj4, "idx=" + i3);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
            x.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
            return str2;
        }
        return str2;
    }

    private static String k(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(str.contains("?") ? "&" : "?");
        Object obj = 1;
        for (String str2 : strArr) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("&");
            }
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }
}
