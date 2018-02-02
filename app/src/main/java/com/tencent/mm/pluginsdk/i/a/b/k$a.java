package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.pluginsdk.i.a.b.b.c;
import com.tencent.mm.pluginsdk.i.a.d.f.d;
import com.tencent.mm.pluginsdk.i.a.e.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class k$a extends d<a> {
    protected k$a(a aVar) {
        super(aVar);
    }

    public final void run() {
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[]{((a) aai()).vgd});
        a aVar = (a) aai();
        int i = aVar.fpm;
        int i2 = aVar.fpn;
        int i3 = aVar.fpo;
        try {
            l lVar;
            aVar = (a) aai();
            l lVar2 = new l(aVar.fpm, aVar.fpn, aVar.filePath, aVar.vge, aVar.vgf, aVar.vgg, aVar.vgh, aVar.vgk, aVar.fpp, aVar.vgi, aVar.vgj, aVar.vgm, aVar.vgl, aVar.url, aVar.vgn, aVar.vgo, aVar.fpo);
            if (lVar2.vgM) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[]{lVar2.vgd});
                lVar2.vhm = lVar2.filePath + ".decompressed";
                lVar2.state = 32;
                if (lVar2.bZt() != null) {
                    lVar2.state = 16;
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[]{lVar2.vgd});
                }
                lVar = lVar2;
            } else if (lVar2.vgN) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[]{lVar2.vgd});
                lVar2.vhm = lVar2.filePath + ".decrypted";
                lVar2.state = 32;
                if (lVar2.bZt() != null) {
                    lVar2.state = 16;
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[]{lVar2.vgd});
                }
                lVar = lVar2;
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[]{lVar2.vgd});
                lVar2.vhm = lVar2.filePath;
                lVar2.state = 32;
                if (lVar2.bZt() != null) {
                    lVar2.state = 16;
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[]{lVar2.vgd});
                }
                lVar = lVar2;
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + lVar.bZu(), new Object[]{lVar.vgd});
            if (16 != lVar.state) {
                if (lVar.vgN) {
                    lVar.vhm = lVar.filePath;
                    lVar.vhn = lVar.filePath + ".decrypted";
                    lVar.state = 1;
                } else if (lVar.vgM) {
                    lVar.vhm = lVar.filePath;
                    lVar.vhn = lVar.filePath + ".decompressed";
                    lVar.state = 2;
                } else {
                    lVar.vhm = lVar.filePath;
                    lVar.state = 4;
                }
            }
            String bZt = lVar.bZr().bZs().bZt();
            if (bh.ov(bZt)) {
                a.Sa(((a) aai()).filePath + ".decrypted");
                a.Sa(((a) aai()).filePath + ".decompressed");
            } else {
                c.bZm().b(i, i2, bZt, i3);
            }
            if (Thread.interrupted()) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[]{((a) aai()).vgd});
                a.Sa(((a) aai()).filePath);
                a.Sa(((a) aai()).filePath + ".decrypted");
                a.Sa(((a) aai()).filePath + ".decompressed");
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (Thread.interrupted()) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[]{((a) aai()).vgd});
                a.Sa(((a) aai()).filePath);
                a.Sa(((a) aai()).filePath + ".decrypted");
                a.Sa(((a) aai()).filePath + ".decompressed");
            }
        }
    }
}
