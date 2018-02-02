package com.tencent.mm.bb;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.ad.a;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class c {
    private static c hKu;
    private as hKv = null;

    public static c QL() {
        if (hKu == null) {
            hKu = new c();
        }
        return hKu;
    }

    private c() {
    }

    public static String lO(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return i.a(a.Fk(), "remark_", g.s((str + "ZnVjaw==").getBytes()), ".png", 1);
    }

    public static boolean lP(String str) {
        x.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[]{str, lO(str)});
        return new File(lO(str)).exists();
    }

    public static boolean lQ(String str) {
        x.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[]{str, lO(str)});
        return b.deleteFile(lO(str));
    }

    public final Bitmap lR(String str) {
        int i = 0;
        Bitmap Y = d.Y(lO(str), 0, 0);
        if (!(Y == null || Y.isRecycled())) {
            i = 1;
        }
        return i != 0 ? Y : null;
    }

    public final void a(String str, String str2, a aVar) {
        if (!bh.ov(str2) && !lP(str)) {
            if (this.hKv == null || this.hKv.cfT()) {
                this.hKv = new as(1, "download-remark-img", 1);
            }
            this.hKv.c(new b(this, str, str2, aVar));
        }
    }
}
