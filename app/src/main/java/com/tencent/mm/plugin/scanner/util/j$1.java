package com.tencent.mm.plugin.scanner.util;

import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.compatible.a.a$a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class j$1 implements a$a {
    final /* synthetic */ j qaQ;

    j$1(j jVar) {
        this.qaQ = jVar;
    }

    public final void run() {
        Throwable e;
        FileOutputStream fileOutputStream = null;
        YuvImage yuvImage = new YuvImage(j.a(this.qaQ), 17, j.b(this.qaQ), j.c(this.qaQ), null);
        x.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by YuvImage");
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, j.b(this.qaQ), j.c(this.qaQ)), j.d(this.qaQ), byteArrayOutputStream);
        this.qaQ.pZF = byteArrayOutputStream.toByteArray();
        try {
            FileOutputStream fileOutputStream2;
            if (r.idh) {
                fileOutputStream2 = new FileOutputStream(new File(h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage.JPEG"));
                try {
                    fileOutputStream2.write(this.qaQ.pZF);
                    fileOutputStream2.flush();
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        x.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode() ApiTask : [%s]", new Object[]{e.getMessage()});
                        x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e3) {
                                x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e3, "", new Object[0]);
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e32, "", new Object[0]);
                            return;
                        }
                    } catch (Throwable th) {
                        e32 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e4, "", new Object[0]);
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e42) {
                            x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e42, "", new Object[0]);
                        }
                        throw e32;
                    }
                } catch (Throwable th2) {
                    e32 = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    byteArrayOutputStream.close();
                    throw e32;
                }
            }
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Throwable e322) {
                    x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e322, "", new Object[0]);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable e3222) {
                x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e3222, "", new Object[0]);
            }
        } catch (IOException e5) {
            e3222 = e5;
            x.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode() ApiTask : [%s]", new Object[]{e3222.getMessage()});
            x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e3222, "", new Object[0]);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            byteArrayOutputStream.close();
        }
    }
}
