package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$3 extends c<iw> {
    final /* synthetic */ c jJd;

    c$3(c cVar) {
        this.jJd = cVar;
        this.xen = iw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        iw iwVar = (iw) bVar;
        if (iwVar.fzw.fpm == 40 && iwVar.fzw.fpn == 1) {
            File file = new File(iwVar.fzw.filePath);
            f fVar = (f) g.h(f.class);
            if (file.exists()) {
                x.i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                File file2 = new File(fVar.Rh(), "temp");
                File file3 = new File(file2, "wxa_fts_template.zip");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                e.x(file.getAbsolutePath(), file3.getAbsolutePath());
                int intValue = bh.ft(file3.getAbsolutePath(), file2.getAbsolutePath()) >= 0 ? Integer.valueOf(fVar.o(new File(file2, "config.conf")).getProperty("version", "0")).intValue() : 65900180;
                e.g(file2);
                x.i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", new Object[]{Integer.valueOf(this.jJd.jIZ.aIt), Integer.valueOf(intValue)});
                if (c.d(file, new File(this.jJd.jIZ.iHK))) {
                    this.jJd.refresh();
                } else {
                    x.e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                }
            } else {
                x.e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
            }
        }
        return false;
    }
}
