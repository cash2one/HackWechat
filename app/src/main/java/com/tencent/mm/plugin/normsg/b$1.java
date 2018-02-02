package com.tencent.mm.plugin.normsg;

import android.content.Context;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.utils.NativeLogic;
import com.tencent.mm.plugin.normsg.utils.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.Inet4Address;

class b$1 implements Runnable {
    final /* synthetic */ b oSq;

    b$1(b bVar) {
        this.oSq = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        if (g.Dh().Cy()) {
            String hostAddress;
            long currentTimeMillis = System.currentTimeMillis();
            Context context = ac.getContext();
            String str = context.getApplicationInfo().sourceDir;
            g.Dh();
            byte[] bO = NativeLogic.bO(str, a.Cg());
            g.Dh();
            byte[] h = NativeLogic.h(context, str, a.Cg());
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            String format = String.format("<k25>%s</k25>", new Object[]{c.q(bO, 0, bO.length)});
            if (h != null) {
                if (h.length == 8) {
                    byte b = h[0];
                    h[0] = h[3];
                    h[3] = b;
                    b = h[1];
                    h[1] = h[2];
                    h[2] = b;
                    b = h[4];
                    h[4] = h[7];
                    h[7] = b;
                    b = h[5];
                    h[5] = h[6];
                    h[6] = b;
                    format = format + String.format("<k28>%s</k28><k29>%s</k29>", new Object[]{c.q(h, 0, 4), c.q(h, 4, 8)});
                } else {
                    format = format + String.format("<k27>%s</k27>", new Object[]{c.q(h, 0, h.length)});
                }
            }
            try {
                hostAddress = Inet4Address.getByName("mp.weixin.qq.com").getHostAddress();
                hostAddress = format + String.format("<k32>%s</k32>", new Object[]{bh.ou(hostAddress)});
            } catch (Throwable e) {
                x.e("MicroMsg.NormsgSourceImpl", "exception:%s", new Object[]{bh.i(e)});
                hostAddress = format;
            }
            x.i("MicroMsg.NormsgSourceImpl", "checkSoftType2 [time: " + currentTimeMillis2 + ", value: " + hostAddress + "]");
            g.Dj().CU().set(79, hostAddress);
        }
    }

    public final String toString() {
        return super.toString() + "|checkSoftTypeExtra";
    }
}
