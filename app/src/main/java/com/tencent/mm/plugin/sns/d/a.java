package com.tencent.mm.plugin.sns.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ca.b;
import com.tencent.mm.memory.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static n c(String str, Options options, DecodeResultLogger decodeResultLogger) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a = l.EA().a(str, options, decodeResultLogger);
            if (a != null) {
                a = i.s(str, a);
            }
            x.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a});
            return n.i(a);
        } catch (OutOfMemoryError e) {
            b.clp();
            x.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e.getMessage());
            return null;
        }
    }

    public static Bitmap b(String str, Options options, DecodeResultLogger decodeResultLogger) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a = l.EA().a(str, options, decodeResultLogger);
            if (a != null) {
                a = i.s(str, a);
            }
            x.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a});
            return a;
        } catch (OutOfMemoryError e) {
            b.clp();
            x.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e.getMessage());
            return null;
        }
    }
}
