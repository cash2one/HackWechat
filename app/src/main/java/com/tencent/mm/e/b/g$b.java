package com.tencent.mm.e.b;

import android.os.Build;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class g$b {
    private static boolean flr;
    private static boolean fls;

    static {
        flr = false;
        fls = false;
        int yp = m.yp();
        x.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(yp));
        if (!bh.ov(Build.CPU_ABI) && !Build.CPU_ABI.contains("armeabi") && !bh.ov(Build.CPU_ABI2) && !Build.CPU_ABI2.contains("armeabi")) {
            x.i("MicroMsg.RecorderUtil", "don't contains armeabi");
            k.b("wechatvoicesilk_v5", g.class.getClassLoader());
            flr = true;
            fls = false;
        } else if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            try {
                k.b("wechatvoicesilk_v7a", g.class.getClassLoader());
                flr = true;
                fls = true;
            } catch (UnsatisfiedLinkError e) {
                x.e("MicroMsg.RecorderUtil", "load library failed!");
                flr = false;
                fls = false;
            }
        } else if ((yp & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            k.b("wechatvoicesilk", g.class.getClassLoader());
            flr = true;
            fls = true;
        } else {
            k.b("wechatvoicesilk_v5", g.class.getClassLoader());
            flr = true;
            fls = false;
        }
        x.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", Boolean.valueOf(flr), Boolean.valueOf(fls));
    }

    public static boolean vw() {
        return fls;
    }
}
