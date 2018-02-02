package com.tencent.mm.be;

import android.os.Looper;
import com.tencent.mm.be.d.a;
import com.tencent.mm.be.d.b;
import com.tencent.mm.e.b.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class e {
    private static e hPq = null;
    private byte[] gOg = new byte[0];
    private String hPr;
    private com.tencent.mm.ae.e hPs = new 3(this);
    public as hxL = new as(1, "speex_worker");

    static /* synthetic */ void b(e eVar) {
        x.d("MicroMsg.SpeexUploadCore", "uploadOneFile");
        synchronized (eVar.gOg) {
            if (eVar.hPr != null) {
                x.d("MicroMsg.SpeexUploadCore", "uploading...");
                return;
            }
            a SK = a.SK();
            if (SK != null) {
                Object obj;
                File bm;
                File file;
                String name;
                b bVar;
                String[] split;
                if (1 != g.t("EnableSpeexVoiceUpload", 0)) {
                    if (SK.SI() == 0) {
                        obj = null;
                    } else if (an.isWifi(ac.getContext())) {
                        com.tencent.mm.kernel.g.Dk();
                        boolean z = SK.fWf == 0 ? true : SK.fWf == bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(12290, null), 0);
                        x.d("upload", "fitSex " + SK.fWf + " " + z + " " + SK.fWf);
                        if (!z) {
                            obj = null;
                        } else if (!SK.SH()) {
                            obj = null;
                        }
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        bm = bm(SK.hPj, SK.hPk);
                        if (bm != null) {
                            x.d("MicroMsg.SpeexUploadCore", "no target to upload");
                            return;
                        }
                        try {
                            file = new File(bm.getPath().replace(".spx", ".uploading"));
                            if (bm.renameTo(file)) {
                                x.d("MicroMsg.SpeexUploadCore", "delete " + bm.getPath());
                                bm.delete();
                                return;
                            }
                            eVar.hPr = file.getPath();
                            name = file.getName();
                            x.d("MicroMsg.SpeexUploadCore", "upload file " + eVar.hPr);
                            bVar = new b();
                            split = name.substring(0, name.indexOf(46)).split("_");
                            if (split.length == 5) {
                                try {
                                    bVar.hMi = split[0];
                                    bVar.sampleRate = bh.getInt(split[1], 0);
                                    bVar.hOV = bh.getInt(split[2], 0);
                                    bVar.hOW = bh.getInt(split[3], 0);
                                } catch (NumberFormatException e) {
                                    x.e("upload", "wrong format", new Object[]{e});
                                }
                            }
                            com.tencent.mm.kernel.g.CG().a(240, eVar.hPs);
                            com.tencent.mm.kernel.g.CG().a(new a(eVar.hPr, d.mI(name), bVar.sampleRate, bVar.hOV, bVar.hOW), 0);
                            return;
                        } catch (Throwable e2) {
                            x.e("MicroMsg.SpeexUploadCore", "exception:%s", new Object[]{bh.i(e2)});
                        }
                    }
                }
                int i = 1;
                if (obj != null) {
                    bm = bm(SK.hPj, SK.hPk);
                    if (bm != null) {
                        file = new File(bm.getPath().replace(".spx", ".uploading"));
                        if (bm.renameTo(file)) {
                            x.d("MicroMsg.SpeexUploadCore", "delete " + bm.getPath());
                            bm.delete();
                            return;
                        }
                        eVar.hPr = file.getPath();
                        name = file.getName();
                        x.d("MicroMsg.SpeexUploadCore", "upload file " + eVar.hPr);
                        bVar = new b();
                        split = name.substring(0, name.indexOf(46)).split("_");
                        if (split.length == 5) {
                            bVar.hMi = split[0];
                            bVar.sampleRate = bh.getInt(split[1], 0);
                            bVar.hOV = bh.getInt(split[2], 0);
                            bVar.hOW = bh.getInt(split[3], 0);
                        }
                        com.tencent.mm.kernel.g.CG().a(240, eVar.hPs);
                        com.tencent.mm.kernel.g.CG().a(new a(eVar.hPr, d.mI(name), bVar.sampleRate, bVar.hOV, bVar.hOW), 0);
                        return;
                    }
                    x.d("MicroMsg.SpeexUploadCore", "no target to upload");
                    return;
                }
            }
            x.d("MicroMsg.SpeexUploadCore", "SpeexConfig not allow");
        }
    }

    public static e SL() {
        if (hPq == null) {
            hPq = new e();
        }
        return hPq;
    }

    public final void b(as.a aVar) {
        x.d("MicroMsg.SpeexUploadCore", "pushWork");
        this.hxL.c(aVar);
    }

    public final void start() {
        if (an.isWifi(ac.getContext())) {
            new af(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ e hPt;

                {
                    this.hPt = r1;
                }

                public final void run() {
                    Looper.myQueue().addIdleHandler(new 1(this));
                }
            }, 100);
        }
    }

    private static File bm(int i, int i2) {
        File file = new File(b.SC());
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        int i3 = 0;
        file = null;
        while (listFiles != null && i3 < listFiles.length) {
            file = listFiles[i3];
            if (file != null && file.isFile()) {
                x.d("MicroMsg.SpeexUploadCore", "file " + file.getPath());
                String path = file.getPath();
                long length = file.length();
                if (!file.getName().endsWith(".spx")) {
                    file = null;
                } else if (length >= ((long) i) && length <= ((long) i2)) {
                    return file;
                } else {
                    x.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", new Object[]{path, Integer.valueOf(i), Integer.valueOf(i2)});
                    com.tencent.mm.loader.stub.b.deleteFile(path);
                    file = null;
                }
            }
            i3++;
        }
        return file;
    }
}
