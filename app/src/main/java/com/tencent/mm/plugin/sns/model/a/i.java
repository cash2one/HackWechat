package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends f {
    private boolean hfG = false;

    public i(a aVar, a aVar2) {
        super(aVar, aVar2);
        g.pQN.a(150, 10, 1, true);
    }

    public final boolean bwh() {
        if (this.qYF.qQL != null) {
            int queryQuality;
            String str;
            String e = com.tencent.mm.plugin.sns.data.i.e(this.fHC);
            this.hfG = r.LC(this.qYF.getPath() + this.qYF.bwf());
            if (this.qZe) {
                this.hfG = true;
            }
            if (this.hfG) {
                g.pQN.a(22, 64, 1, true);
            }
            String str2 = this.qYF.getPath() + this.qYF.bwf();
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile(str2, options, null, 0, new int[0]);
            String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || bh.ov(options.outMimeType)) {
                g.pQN.a(150, 35, 1, true);
            }
            if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                queryQuality = MMNativeJpeg.queryQuality(str2);
                if (queryQuality == 0) {
                    queryQuality = -1;
                }
            } else {
                queryQuality = -1;
            }
            long me = FileOp.me(str2);
            if (me <= 0) {
                g.pQN.a(150, 23, 1, true);
            }
            long Wq = bh.Wq();
            String i = com.tencent.mm.plugin.sns.data.i.i(this.fHC);
            FileOp.x(this.qYF.getPath() + this.qYF.bwf(), this.qYF.getPath() + i);
            x.v("MicroMsg.SnsDownloadThumb", "file src" + FileOp.bO(this.qYF.getPath() + i));
            long Wq2 = bh.Wq();
            if (!r.a(this.qYF.getPath(), this.qYF.bwf(), e, (float) ae.bvE())) {
                x.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
                g.pQN.a(150, 27, 1, true);
            }
            Wq2 = bh.bA(Wq2);
            FileOp.deleteFile(this.qYF.getPath() + this.qYF.bwf());
            Wq = bh.bA(Wq);
            if (!FileOp.bO(this.qYF.getPath() + e)) {
                g.pQN.a(150, 31, 1, true);
            }
            g.pQN.h(11696, new Object[]{Integer.valueOf(3), Long.valueOf(Wq), Integer.valueOf(this.qYZ), Thread.currentThread().getName(), ae.bvJ(), e.bnD});
            if (this.qYF.qQL.qQR == 0 || this.qYF.qQL.qQR == 5) {
                i = com.tencent.mm.plugin.sns.data.i.f(this.fHC);
                r.b(this.qYF.getPath(), e, i, (float) ae.bvD());
                str = i;
            } else {
                str = e;
            }
            c.a(this.qYF.getPath() + str, this.qYF.url, 1, options.outMimeType, options.outWidth, options.outHeight, queryQuality, me, Wq2);
            this.qYE = com.tencent.mm.plugin.sns.data.i.JM(this.qYF.getPath() + str);
            boolean b = com.tencent.mm.plugin.sns.data.i.b(this.qYE);
            x.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b + " isWebp: " + this.hfG + " srcImgFileSize: " + me);
            if (!b) {
                g.pQN.a(150, 65, 1, true);
                if (this.qZg) {
                    g.pQN.a(150, 50, 1, true);
                } else {
                    g.pQN.a(150, 51, 1, true);
                }
                if (this.qZf) {
                    g.pQN.a(150, 54, 1, true);
                }
                if (this.qZe) {
                    g.pQN.a(150, 57, 1, true);
                }
            }
            if (this.hfG && !b) {
                g.pQN.a(22, 65, 1, true);
            }
            if (this.qZg && b) {
                b.pY(v.CTRL_INDEX);
            }
        }
        return true;
    }

    protected final int bwi() {
        return 3;
    }
}
