package com.tencent.mm.plugin.search.a;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

class c$2 extends c<iw> {
    final /* synthetic */ c qbq;

    c$2(c cVar) {
        this.qbq = cVar;
        this.xen = iw.class.getName().hashCode();
    }

    private boolean a(iw iwVar) {
        InputStream fileInputStream;
        Throwable e;
        int intValue;
        if (iwVar != null && iwVar.fzw.fpm == 27) {
            File file;
            if (iwVar.fzw.fpn == 1) {
                File file2 = new File(iwVar.fzw.filePath);
                if (file2.exists()) {
                    x.i("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener callback to update %s", new Object[]{file2.getAbsoluteFile()});
                    File file3 = new File(g.zS(iwVar.fzw.fpn), "temp");
                    file = new File(file3, g.zT(iwVar.fzw.fpn));
                    file3.mkdirs();
                    e.x(file2.getAbsolutePath(), file.getAbsolutePath());
                    if (bh.ft(file.getAbsolutePath(), file3.getAbsolutePath()) >= 0) {
                        Properties properties = new Properties();
                        try {
                            fileInputStream = new FileInputStream(new File(file3, "config.conf"));
                            try {
                                properties.load(fileInputStream);
                                e.c(fileInputStream);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                                    e.c(fileInputStream);
                                    intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                    e.g(file3);
                                    x.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(g.zN(0)), Integer.valueOf(intValue)});
                                    c.f(file2, iwVar.fzw.fpn);
                                    return false;
                                } catch (Throwable th) {
                                    e = th;
                                    e.c(fileInputStream);
                                    throw e;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileInputStream = null;
                            x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                            e.c(fileInputStream);
                            intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                            e.g(file3);
                            x.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(g.zN(0)), Integer.valueOf(intValue)});
                            c.f(file2, iwVar.fzw.fpn);
                            return false;
                        } catch (Throwable th2) {
                            e = th2;
                            fileInputStream = null;
                            e.c(fileInputStream);
                            throw e;
                        }
                        intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                    } else {
                        intValue = 1;
                    }
                    e.g(file3);
                    x.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(g.zN(0)), Integer.valueOf(intValue)});
                    c.f(file2, iwVar.fzw.fpn);
                } else {
                    x.e("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener file not exist");
                }
            } else if (iwVar.fzw.fpn == 2) {
                file = new File(iwVar.fzw.filePath);
                if (file.exists()) {
                    int zN = g.zN(1);
                    c.f(file, iwVar.fzw.fpn);
                    x.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(zN), Integer.valueOf(g.zN(1))});
                } else {
                    x.e("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener file not exist");
                }
            }
        }
        return false;
    }
}
