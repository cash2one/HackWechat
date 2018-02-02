package com.tencent.mm.console;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.console.b.5;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class b$5$1 implements Runnable {
    final /* synthetic */ 5 gIr;

    b$5$1(5 5) {
        this.gIr = 5;
    }

    public final void run() {
        try {
            String str = e.bnD;
            ar.Hg();
            String Fs = c.Fs();
            ar.Hg();
            String ER = c.ER();
            x.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", new Object[]{Integer.valueOf(this.gIr.gIp), str, Fs, ER, Fs.substring(str.length())});
            for (int i = 0; i < this.gIr.gIp; i++) {
                Object obj = ((a) this.gIr.gIq.get(i)).xhO;
                if (!(bh.ov(obj) || str.contains(obj))) {
                    File file = new File(obj + r5);
                    if (file.exists() && file.isDirectory()) {
                        x.i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", new Object[]{Fs, file.getAbsolutePath(), Boolean.valueOf(k.q(file.getAbsolutePath(), Fs, false))});
                        if (k.q(file.getAbsolutePath(), Fs, false)) {
                            new af(Looper.getMainLooper()).post(new Runnable(this) {
                                final /* synthetic */ b$5$1 gIs;

                                {
                                    this.gIs = r1;
                                }

                                public final void run() {
                                    h.bu(this.gIs.gIr.val$context, this.gIs.gIr.val$context.getString(R.l.dXF));
                                }
                            });
                            return;
                        }
                    }
                }
            }
            new af(Looper.getMainLooper()).post(new 2(this));
        } catch (Exception e) {
            x.w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", new Object[]{e.getMessage()});
        }
    }
}
