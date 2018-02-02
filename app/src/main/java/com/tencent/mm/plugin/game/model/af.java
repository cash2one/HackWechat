package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.bh;
import com.tencent.mm.plugin.game.c.cc;
import com.tencent.mm.plugin.game.c.cf;
import com.tencent.mm.plugin.game.c.ci;
import com.tencent.mm.plugin.game.c.cz;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class af extends ad {
    public bh ndt;
    private boolean ndu;
    public d ndv;
    public ag ndw;

    public static class a {
        public String desc;
        public String title;
        public String url;
    }

    public af(com.tencent.mm.bq.a aVar) {
        if (aVar == null) {
            this.ndt = new bh();
            return;
        }
        this.ndt = (bh) aVar;
        this.ndu = false;
        WT();
    }

    public af(byte[] bArr) {
        this.ndt = new bh();
        if (bArr != null && bArr.length != 0) {
            try {
                this.ndt.aF(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            this.ndu = true;
            WT();
        }
    }

    private void WT() {
        d a = ad.a(this.ndt.nfh);
        if (a != null) {
            a.scene = 12;
            a.fFj = 1201;
        }
        this.ndv = a;
        if (this.ndu) {
            this.ndw = new ag(this.ndv.field_appId);
        } else {
            this.ndw = new ag(this.ndv.field_appId, this.ndt.nhX != null ? this.ndt.nhX.njS : null);
        }
        if (!this.ndu) {
            d.a(this.ndv);
            SubCoreGameCenter.aRh().a(this.ndv.field_appId, this.ndt);
        }
    }

    public final String aQz() {
        if (this.ndt.nib != null) {
            return this.ndt.nib.title;
        }
        if (this.ndt.nhW != null) {
            return this.ndt.nhW.fon;
        }
        return null;
    }

    public final LinkedList<b> aQA() {
        LinkedList<b> linkedList;
        Iterator it;
        b bVar;
        if (this.ndt.nib != null && this.ndt.nib.kNr != null) {
            linkedList = new LinkedList();
            it = this.ndt.nib.kNr.iterator();
            while (it.hasNext()) {
                ci ciVar = (ci) it.next();
                bVar = new b();
                bVar.fDI = ciVar.fDI;
                bVar.desc = ciVar.desc;
                linkedList.add(bVar);
            }
            return linkedList;
        } else if (this.ndt.nhW == null || this.ndt.nhW.niQ == null) {
            return null;
        } else {
            linkedList = new LinkedList();
            it = this.ndt.nhW.niQ.iterator();
            while (it.hasNext()) {
                cc ccVar = (cc) it.next();
                bVar = new b();
                bVar.fDI = ccVar.niT;
                bVar.title = ccVar.fon;
                bVar.desc = ccVar.ngs;
                bVar.url = ccVar.nfj;
                linkedList.add(bVar);
            }
            return linkedList;
        }
    }

    public final int aQB() {
        if (this.ndt.nib != null) {
            return 2;
        }
        return 1;
    }

    public final LinkedList<com.tencent.mm.plugin.game.ui.GameMediaList.a> aQC() {
        LinkedList<com.tencent.mm.plugin.game.ui.GameMediaList.a> linkedList = new LinkedList();
        if (this.ndt.nhU == null || this.ndt.nhU.njs == null) {
            return linkedList;
        }
        Iterator it = this.ndt.nhU.njs.iterator();
        while (it.hasNext()) {
            cz czVar = (cz) it.next();
            com.tencent.mm.plugin.game.ui.GameMediaList.a aVar = new com.tencent.mm.plugin.game.ui.GameMediaList.a();
            aVar.type = czVar.njA;
            aVar.nsV = czVar.njB;
            aVar.url = czVar.njC;
            linkedList.add(aVar);
        }
        return linkedList;
    }

    public final String aQD() {
        if (this.ndt.nhU == null || this.ndt.nhU.fon == null) {
            return null;
        }
        return this.ndt.nhU.fon;
    }

    public final String aQE() {
        if (this.ndt.nhU == null || this.ndt.nhU.ngs == null) {
            return null;
        }
        return this.ndt.nhU.ngs;
    }

    public final String aQF() {
        if (this.ndt.nhV == null) {
            return null;
        }
        return this.ndt.nhV.fon;
    }

    public final LinkedList<cf> aQG() {
        if (this.ndt.nhV == null) {
            return null;
        }
        return this.ndt.nhV.niW;
    }
}
