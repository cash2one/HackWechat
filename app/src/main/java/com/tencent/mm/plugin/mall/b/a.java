package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.text.SimpleDateFormat;

public final class a {
    private static SimpleDateFormat kXB = null;
    private static SimpleDateFormat kXC = null;
    private static final String omK = (e.bnF + "wallet/mall");

    public static void aYu() {
        b rdVar = new rd();
        rdVar.fIS.fIT = false;
        com.tencent.mm.sdk.b.a.xef.m(rdVar);
    }

    public static void k(ImageView imageView, String str) {
        f(imageView, str, 0);
    }

    public static void f(ImageView imageView, String str, int i) {
        String str2 = null;
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bh.ov(str)) {
                com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
                if (!bh.ov(str)) {
                    str2 = String.format("%s/%s", new Object[]{omK, g.s(str.getBytes())});
                }
                aVar.hDD = str2;
                aVar.hDA = true;
                aVar.hDX = true;
                aVar.hDY = false;
                if (i != 0) {
                    aVar.hDP = i;
                }
                o.PA().a(str, imageView, aVar.PK());
            } else if (i != 0) {
                imageView.setImageResource(i);
            }
        }
    }
}
