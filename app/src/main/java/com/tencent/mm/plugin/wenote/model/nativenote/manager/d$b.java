package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.a.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

final class d$b implements a {
    String fileName;
    String hTp;
    private int owu;
    private int owv;
    d$a tSR;
    j tSS;
    String tTb;
    int tTc;
    VideoTransPara tTd;
    private boolean tTe;
    private int tTf;

    private d$b() {
        this.tTf = 0;
    }

    public final boolean JB() {
        synchronized (d.bWC()) {
            Object obj = !d.bWD().containsKey(this.fileName) ? 1 : null;
        }
        if (obj == null) {
            obj = t.nF(this.fileName) == null ? 1 : null;
        }
        if (obj != null) {
            x.w("MicroMsg.NoteVideoCompress", "remuxing job has been removed, filename %s", new Object[]{this.fileName});
            return true;
        }
        if (this.tTd == null || this.tTd.isDefault) {
            int[] iArr = new int[2];
            d.d(this.hTp, iArr);
            this.owu = iArr[0];
            this.owv = iArr[1];
        } else {
            this.owu = this.tTd.width;
            this.owv = this.tTd.height;
        }
        PString pString = new PString();
        PInt pInt = new PInt();
        ar.Hg();
        if (c.Ff().a(this.hTp, pString, pInt) && k.fp(pString.value, this.tTb)) {
            x.i("MicroMsg.NoteVideoCompress", "copy remuxing file success, do not remuxing again.");
            this.tTc = pInt.value;
            this.tTe = true;
            return true;
        }
        long Wq = bh.Wq();
        if (this.tTd != null) {
            x.i("MicroMsg.NoteVideoCompress", "remuxing new para %s", new Object[]{this.tTd});
            this.tTc = SightVideoJNI.remuxing(this.hTp, this.tTb, this.owu, this.owv, this.tTd.videoBitrate, this.tTd.huf, 8, this.tTd.hue, 25.0f, (float) this.tTd.fps, null, 0, false);
        } else {
            x.w("MicroMsg.NoteVideoCompress", "remuxing but new para is null. %s", new Object[]{this.fileName});
            this.tTc = SightVideoJNI.remuxing(this.hTp, this.tTb, this.owu, this.owv, b.qsX, b.qsW, 8, 2, 25.0f, b.qsY, null, 0, false);
        }
        this.tTf = (int) bh.bA(Wq);
        x.i("MicroMsg.NoteVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{this.hTp, this.tTb, Integer.valueOf(this.tTc), Integer.valueOf(this.owu), Integer.valueOf(this.owv)});
        this.tTe = this.tTc >= 0;
        PInt pInt2 = new PInt();
        if (t.a(this.tTb, pInt2, new PInt())) {
            this.tTc = pInt2.value;
        }
        if (this.tTe) {
            x.i("MicroMsg.NoteVideoCompress", "remuxing video sucess,insert to media duplication storage");
            try {
                String name = new File(this.tTb).getName();
                String str = this.tTb + ".tmp";
                if (d.b(this.tTb, str, new PInt(0))) {
                    boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(this.tTb);
                    File file = new File(str);
                    boolean g = e.g(file.getParent() + File.separator, file.getName(), name);
                    x.i("MicroMsg.NoteVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[]{Boolean.valueOf(deleteFile), Boolean.valueOf(g), file.getAbsolutePath(), this.tTb});
                } else {
                    x.i("MicroMsg.NoteVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[]{Integer.valueOf(new PInt(0).value), this.hTp, this.tTb});
                }
                ar.Hg();
                c.Ff().G(this.hTp, this.tTb, this.tTc);
            } catch (Exception e) {
                x.e("MicroMsg.NoteVideoCompress", "fast start exception e[%s]", new Object[]{e.toString()});
            }
        } else {
            x.w("MicroMsg.NoteVideoCompress", "remuxing video error, copy source video to send.");
            com.tencent.mm.loader.stub.b.deleteFile(this.tTb);
            k.q(this.hTp, this.tTb, false);
        }
        return true;
    }

    public final boolean JC() {
        synchronized (d.bWC()) {
            d.bWD().remove(this.fileName);
        }
        if (this.tSR != null) {
            this.tSR.b(this.tTb, this.tSS);
        }
        return false;
    }
}
