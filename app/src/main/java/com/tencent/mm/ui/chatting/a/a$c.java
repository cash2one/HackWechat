package com.tencent.mm.ui.chatting.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g.a;

public class a$c {
    public au fEJ;
    public long hOG;
    public String imagePath;
    boolean oqy;
    public int type = 0;
    public a yyl = new a(this);

    public final boolean equals(Object obj) {
        if (this.fEJ == null || !(obj instanceof au) || obj == null) {
            return super.equals(obj);
        }
        return this.fEJ.field_msgId == ((au) obj).field_msgId;
    }

    public a$c(au auVar) {
        String nu;
        this.fEJ = auVar;
        if (auVar.cjh() || auVar.cji()) {
            this.oqy = true;
            o.TU();
            nu = s.nu(auVar.field_imgPath);
            r nF = t.nF(auVar.field_imgPath);
            if (nF != null) {
                this.yyl.yym = bh.iW(nF.hVH);
            }
            this.yyl.fEt = a.I(auVar.field_content, auVar.field_reserved);
        } else {
            nu = com.tencent.mm.aq.o.Pw().b(auVar.field_imgPath, false, false);
            if (!(bh.ov(nu) || nu.endsWith("hd") || !FileOp.bO(nu + "hd"))) {
                nu = nu + "hd";
            }
        }
        if (auVar.cjm()) {
            a fT = a.fT(auVar.field_content);
            String str = null;
            if (!(fT == null || fT.fny == null || fT.fny.length() <= 0)) {
                b Rz = an.aqd().Rz(fT.fny);
                if (Rz != null) {
                    str = Rz.field_fileFullPath;
                }
            }
            if (str != null) {
                nu = str;
            }
        }
        this.imagePath = nu;
        this.hOG = auVar.field_createTime;
    }

    public a$c(long j) {
        this.hOG = j;
        this.type = Integer.MAX_VALUE;
    }
}
