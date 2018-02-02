package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

class e$9 implements a {
    final /* synthetic */ e iHW;

    e$9(e eVar) {
        this.iHW = eVar;
    }

    public final j a(File file, Object... objArr) {
        j jVar;
        Exception e;
        Throwable th;
        if (k.u(file)) {
            return j.iID;
        }
        InputStream inputStream = (InputStream) objArr[0];
        if (inputStream instanceof ZipInputStream) {
            if (k.a((ZipInputStream) inputStream, file.getAbsolutePath()) == 0) {
                return j.iIt;
            }
            return j.iIu;
        } else if (file.isDirectory()) {
            return j.iIy;
        } else {
            Closeable fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                    while (true) {
                        int read = inputStream.read(bArr, 0, Downloads.RECV_BUFFER_SIZE);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            jVar = j.iIt;
                            bh.d(fileOutputStream);
                            bh.d(inputStream);
                            return jVar;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.i("MicroMsg.AppBrandNonFlattenedFileStorage", "writeFile exp %s", new Object[]{e});
                        jVar = j.iIu;
                        bh.d(fileOutputStream);
                        bh.d(inputStream);
                        return jVar;
                    } catch (Throwable th2) {
                        th = th2;
                        bh.d(fileOutputStream);
                        bh.d(inputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                x.i("MicroMsg.AppBrandNonFlattenedFileStorage", "writeFile exp %s", new Object[]{e});
                jVar = j.iIu;
                bh.d(fileOutputStream);
                bh.d(inputStream);
                return jVar;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                bh.d(fileOutputStream);
                bh.d(inputStream);
                throw th;
            }
        }
    }
}
