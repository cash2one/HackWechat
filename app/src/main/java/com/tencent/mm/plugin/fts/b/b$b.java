package com.tencent.mm.plugin.fts.b;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class b$b extends a {
    final /* synthetic */ b mNv;

    private b$b(b bVar) {
        this.mNv = bVar;
    }

    public final boolean execute() {
        InputStream open;
        Throwable e;
        InputStream inputStream;
        b bcVar;
        OutputStream outputStream = null;
        x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to check feature resource task %d", Integer.valueOf(b.D(b.aNb())));
        if (b.D(b.aNb()) < 0) {
            File file = new File(ac.getContext().getCacheDir(), "fts_feature.zip");
            try {
                open = ac.getContext().getAssets().open("fts_feature.zip");
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    OutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            int read = open.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        e.c(open);
                        e.a(fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        outputStream = fileOutputStream;
                        inputStream = open;
                        try {
                            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                            e.c(inputStream);
                            e.a(outputStream);
                            if (file.exists()) {
                                bcVar = new bc();
                                bcVar.fpl.fpm = 35;
                                bcVar.fpl.fpn = 1;
                                bcVar.fpl.filePath = file.getAbsolutePath();
                                com.tencent.mm.sdk.b.a.xef.a(bcVar, Looper.getMainLooper());
                            }
                            return true;
                        } catch (Throwable th) {
                            e = th;
                            open = inputStream;
                            e.c(open);
                            e.a(outputStream);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        outputStream = fileOutputStream;
                        e.c(open);
                        e.a(outputStream);
                        throw e;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = open;
                    x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                    e.c(inputStream);
                    e.a(outputStream);
                    if (file.exists()) {
                        bcVar = new bc();
                        bcVar.fpl.fpm = 35;
                        bcVar.fpl.fpn = 1;
                        bcVar.fpl.filePath = file.getAbsolutePath();
                        com.tencent.mm.sdk.b.a.xef.a(bcVar, Looper.getMainLooper());
                    }
                    return true;
                } catch (Throwable th3) {
                    e = th3;
                    e.c(open);
                    e.a(outputStream);
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = null;
                x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                e.c(inputStream);
                e.a(outputStream);
                if (file.exists()) {
                    bcVar = new bc();
                    bcVar.fpl.fpm = 35;
                    bcVar.fpl.fpn = 1;
                    bcVar.fpl.filePath = file.getAbsolutePath();
                    com.tencent.mm.sdk.b.a.xef.a(bcVar, Looper.getMainLooper());
                }
                return true;
            } catch (Throwable th4) {
                e = th4;
                open = null;
                e.c(open);
                e.a(outputStream);
                throw e;
            }
            if (file.exists()) {
                bcVar = new bc();
                bcVar.fpl.fpm = 35;
                bcVar.fpl.fpn = 1;
                bcVar.fpl.filePath = file.getAbsolutePath();
                com.tencent.mm.sdk.b.a.xef.a(bcVar, Looper.getMainLooper());
            }
        }
        return true;
    }

    public final String getName() {
        return "CheckFeatureResourceTask";
    }
}
