package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;

final class m {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static String a(z zVar, String str) {
        String str2 = null;
        if (!(zVar == null || bh.ov(str))) {
            zVar.ZX();
            Closeable pI = zVar.pI(str);
            if (pI != null) {
                try {
                    pI.mark(pI.available());
                    String a = g.a(pI, Downloads.RECV_BUFFER_SIZE);
                    pI.reset();
                    File file = new File(zVar.iFl.getAbsolutePath() + "_xdir/" + str);
                    File parentFile = file.getParentFile();
                    if (parentFile.exists() && parentFile.isFile()) {
                        parentFile.delete();
                    }
                    parentFile.mkdirs();
                    if (!a.equals(g.i(file))) {
                        if (file.isDirectory()) {
                            Runtime.getRuntime().exec("rm -r " + file.getAbsolutePath());
                        } else {
                            file.delete();
                        }
                        Closeable fileOutputStream = new FileOutputStream(file);
                        e.c(pI, fileOutputStream);
                        bh.d(fileOutputStream);
                    }
                    str2 = file.getAbsolutePath();
                    bh.d(pI);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.PkgPartialCopy", e, "copy failed", new Object[0]);
                } catch (Throwable th) {
                    str2 = th;
                    bh.d(pI);
                }
            }
        }
        return str2;
    }
}
