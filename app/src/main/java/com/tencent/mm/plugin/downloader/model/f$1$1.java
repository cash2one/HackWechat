package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.c.c;
import com.tencent.mm.plugin.downloader.model.f.1;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class f$1$1 implements e {
    final /* synthetic */ 1 lst;

    f$1$1(1 1) {
        this.lst = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        kVar.hmF = true;
        g gVar;
        Object[] objArr;
        if (i == 0 && i2 == 0) {
            String string = MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "yyb_pkg_sig_prefs", 4).getString(this.lst.lrK.field_packageName, "");
            x.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[]{string});
            if (bh.ov(string)) {
                g.pQN.a(322, 26, 1, false);
                gVar = g.pQN;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4026);
                objArr[1] = String.format("%s,%s", new Object[]{this.lst.lrK.field_packageName, this.lst.lrK.field_filePath});
                gVar.h(11098, objArr);
            } else {
                g gVar2;
                Object[] objArr2;
                try {
                    c.b(new File(this.lst.lrK.field_filePath), string);
                    x.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                    g.pQN.a(322, 25, 1, false);
                    gVar2 = g.pQN;
                    objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(4025);
                    objArr2[1] = String.format("%s,%s,%s", new Object[]{this.lst.lrK.field_packageName, this.lst.lrK.field_filePath, string});
                    gVar2.h(11098, objArr2);
                } catch (Exception e) {
                    x.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + e.getMessage());
                    g.pQN.a(322, 27, 1, false);
                    gVar2 = g.pQN;
                    objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(4027);
                    objArr2[1] = String.format("%s,%s,%s", new Object[]{this.lst.lrK.field_packageName, this.lst.lrK.field_filePath, e.getMessage()});
                    gVar2.h(11098, objArr2);
                }
            }
        } else {
            x.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
            g.pQN.a(322, 28, 1, false);
            gVar = g.pQN;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4028);
            objArr[1] = String.format("%s,%s,%d,%d", new Object[]{this.lst.lrK.field_packageName, this.lst.lrK.field_filePath, Integer.valueOf(i), Integer.valueOf(i2)});
            gVar.h(11098, objArr);
        }
        ag.y(new 1(this));
    }
}
