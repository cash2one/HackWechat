package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$1 extends c<bc> {
    final /* synthetic */ c jJd;

    c$1(c cVar) {
        this.jJd = cVar;
        this.xen = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.fpl.fpm == 40 && bcVar.fpl.fpn == 1) {
            File file = new File(bcVar.fpl.filePath);
            if (file.exists()) {
                x.i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                File file2 = new File(((f) g.h(f.class)).Rh(), "temp");
                File file3 = new File(file2, "wxa_fts_template.zip");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                e.x(file.getAbsolutePath(), file3.getAbsolutePath());
                int ft = bh.ft(file3.getAbsolutePath(), file2.getAbsolutePath());
                int i = 65900180;
                if (ft >= 0) {
                    i = Integer.valueOf(((f) g.h(f.class)).o(new File(file2, "config.conf")).getProperty("version", "0")).intValue();
                }
                e.g(file2);
                if (i > this.jJd.jIZ.aIt) {
                    x.i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", new Object[]{Integer.valueOf(this.jJd.jIZ.aIt), Integer.valueOf(i)});
                    if (c.d(file, new File(this.jJd.jIZ.iHK))) {
                        this.jJd.refresh();
                    } else {
                        x.e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                    }
                } else {
                    x.i("MicroMsg.WxaFTSSearchCore", "res no need update template currentVersion : %d resVersion : %d", new Object[]{Integer.valueOf(this.jJd.jIZ.aIt), Integer.valueOf(i)});
                }
            } else {
                x.e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
            }
        }
        return false;
    }
}
