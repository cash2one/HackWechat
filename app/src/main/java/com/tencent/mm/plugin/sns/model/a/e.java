package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends f {
    public e(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final boolean bwh() {
        Object obj;
        long Wq;
        long j = -1;
        String l = i.l(this.fHC);
        String str = this.qYF.getPath() + this.qYF.bwf();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        long me = FileOp.me(str);
        if (this.qZe || toLowerCase.contains("webp")) {
            obj = null;
        } else if (this.qZf || toLowerCase.contains("vcodec")) {
            r16 = 1;
        } else {
            r16 = 2;
        }
        long Wq2;
        long bA;
        switch (obj) {
            case null:
                g.pQN.a(22, 64, 1, true);
                FileOp.deleteFile(this.qYF.getPath() + l);
                Wq2 = bh.Wq();
                r.c(this.qYF.getPath(), this.qYF.getPath() + this.qYF.bwf(), l, false);
                bA = bh.bA(Wq2);
                FileOp.deleteFile(this.qYF.getPath() + this.qYF.bwf());
                j = bh.bA(Wq2);
                c.a(this.qYF.getPath() + l, this.qYF.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, me, bA);
                break;
            case 1:
                x.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[]{this.qYF.getPath() + this.qYF.bwf()});
                FileOp.deleteFile(this.qYF.getPath() + l);
                Wq2 = bh.Wq();
                r.c(this.qYF.getPath(), this.qYF.getPath() + this.qYF.bwf(), l, false);
                bA = bh.bA(Wq2);
                FileOp.deleteFile(this.qYF.getPath() + this.qYF.bwf());
                j = bh.bA(Wq2);
                c.a(this.qYF.getPath() + l, this.qYF.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, me, bA);
                break;
            case 2:
                bA = -1;
                if (i.JR(this.qYF.getPath() + this.qYF.bwf())) {
                    x.w("MicroMsg.SnsDownloadImage", "the " + this.qYF.mediaId + " is too max ! " + this.qYF.url);
                    FileOp.deleteFile(this.qYF.getPath() + l);
                    Wq = bh.Wq();
                    r.X(this.qYF.getPath(), this.qYF.getPath() + this.qYF.bwf(), l);
                    bA = bh.bA(Wq);
                    FileOp.deleteFile(this.qYF.getPath() + this.qYF.bwf());
                    j = bh.bA(Wq);
                } else {
                    FileOp.g(this.qYF.getPath(), this.qYF.bwf(), l);
                    j = 0;
                }
                int i = -1;
                if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                    i = MMNativeJpeg.queryQuality(this.qYF.getPath() + l);
                    if (i == 0) {
                        i = -1;
                    }
                }
                c.a(this.qYF.getPath() + l, this.qYF.url, 0, options.outMimeType, options.outWidth, options.outHeight, i, me, bA);
                break;
        }
        x.i("MicroMsg.SnsDownloadImage", "donwload big pic isWebp " + (obj == null));
        Wq = FileOp.me(this.qYF.getPath() + l);
        g.pQN.h(11696, new Object[]{Integer.valueOf(3), Long.valueOf(j), Long.valueOf(Wq), Thread.currentThread().getName(), ae.bvJ(), com.tencent.mm.compatible.util.e.bnD});
        Object obj2 = this.qYF.qYB != 3 ? 1 : null;
        if (!(this.qYF.qQL == null || this.qYF.qQL.qQR == 4 || this.qYF.qQL.qQR == 5)) {
            obj2 = null;
        }
        if (obj2 != null) {
            toLowerCase = i.e(this.fHC);
            if (FileOp.bO(this.qYF.getPath() + toLowerCase)) {
                FileOp.deleteFile(this.qYF.getPath() + toLowerCase);
            }
            long Wq3 = bh.Wq();
            r.a(this.qYF.getPath(), l, toLowerCase, (float) ae.bvE());
            Wq3 = bh.bA(Wq3);
            FileOp.me(this.qYF.getPath() + toLowerCase);
            g.pQN.h(11696, new Object[]{Integer.valueOf(3), Long.valueOf(Wq3), Long.valueOf(Wq), Thread.currentThread().getName(), ae.bvJ(), com.tencent.mm.compatible.util.e.bnD});
            toLowerCase = i.f(this.fHC);
            if (!FileOp.bO(this.qYF.getPath() + toLowerCase)) {
                r.b(this.qYF.getPath(), l, toLowerCase, (float) ae.bvD());
            }
        }
        return true;
    }

    protected final int bwi() {
        return 1;
    }
}
