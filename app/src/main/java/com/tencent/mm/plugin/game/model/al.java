package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.c.bv;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.dj;
import com.tencent.mm.plugin.game.c.dv;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class al extends ad {
    public bv ndV;
    public LinkedList<d> ndW;
    public LinkedList<d> ndX;
    private int nds;

    public al(a aVar, boolean z, int i) {
        this.nds = 0;
        if (aVar == null) {
            this.ndV = new bv();
            return;
        }
        this.ndV = (bv) aVar;
        this.nds = i;
        this.ndW = aQQ();
        this.ndX = aQR();
        if (z) {
            SubCoreGameCenter.aRh().a("pb_library", aVar);
        }
        d.U(this.ndW);
        d.U(this.ndX);
    }

    public al(byte[] bArr) {
        this.nds = 0;
        this.ndV = new bv();
        if (bArr != null && bArr.length != 0) {
            try {
                this.ndV.aF(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", e.getMessage());
            }
            this.ndW = aQQ();
            this.ndX = aQR();
            d.U(this.ndW);
            d.U(this.ndX);
        }
    }

    private LinkedList<d> aQQ() {
        LinkedList<d> linkedList = new LinkedList();
        if (this.ndV.niH == null || this.ndV.niH.njv == null || this.ndV.niH.njv.njP == null) {
            return linkedList;
        }
        Iterator it = this.ndV.niH.njv.njP.iterator();
        int i = 1;
        while (it.hasNext()) {
            dj djVar = (dj) it.next();
            d a = a(djVar.nfh);
            if (a != null) {
                a.nba = djVar.nfh.nfw;
                a.scene = 11;
                a.fFj = 1110;
                int i2 = i + 1;
                a.position = i;
                linkedList.add(a);
                i = i2;
            }
        }
        return linkedList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private LinkedList<d> aQR() {
        LinkedList<d> linkedList = new LinkedList();
        if (this.ndV.niI == null) {
            return linkedList;
        }
        int i = this.nds + 1;
        int i2 = (this.nds / 15) + 901;
        Iterator it = this.ndV.niI.iterator();
        int i3 = i;
        i = i2;
        while (it.hasNext()) {
            d dVar;
            c cVar = (c) it.next();
            switch (cVar.ktN) {
                case 1:
                    d a = a(cVar.nfh);
                    if (a == null) {
                        d dVar2 = a;
                        i2 = i;
                        i = i3;
                        dVar = dVar2;
                        break;
                    }
                    int i4 = i3 + 1;
                    a.position = i3;
                    dVar = a;
                    i2 = i;
                    i = i4;
                    break;
                case 2:
                    if (cVar.nfk != null) {
                        d a2 = a(cVar.nfk.nfh);
                        if (a2 == null) {
                            i2 = i;
                            i = i3;
                            dVar = a2;
                            break;
                        }
                        a2.type = 1;
                        a2.naS = cVar.nfk.nfj;
                        a2.naT = cVar.nfk.nfi;
                        i2 = i + 1;
                        a2.position = i;
                        i = i3;
                        dVar = a2;
                        break;
                    }
                default:
                    i2 = i;
                    i = i3;
                    dVar = null;
                    break;
            }
            if (dVar != null) {
                dVar.scene = 11;
                dVar.fFj = 1111;
                linkedList.add(dVar);
                i3 = i;
                i = i2;
            } else {
                i3 = i;
                i = i2;
            }
        }
        return linkedList;
    }

    public final HashMap<Integer, String> aQS() {
        HashMap<Integer, String> linkedHashMap = new LinkedHashMap();
        if (this.ndV.niH == null || this.ndV.niH.njy == null) {
            return linkedHashMap;
        }
        Iterator it = this.ndV.niH.njy.iterator();
        while (it.hasNext()) {
            dv dvVar = (dv) it.next();
            int i = dvVar.niF;
            linkedHashMap.put(Integer.valueOf(i), dvVar.nfp);
        }
        return linkedHashMap;
    }

    public final LinkedList<GameLibraryCategoriesView.a> aQT() {
        if (this.ndV.niH == null || this.ndV.niH.njw == null) {
            return null;
        }
        LinkedList<GameLibraryCategoriesView.a> linkedList = new LinkedList();
        Iterator it = this.ndV.niH.njw.iterator();
        int i = 0;
        while (it.hasNext()) {
            n nVar = (n) it.next();
            GameLibraryCategoriesView.a aVar = new GameLibraryCategoriesView.a();
            aVar.nse = nVar.nfY;
            aVar.nsf = nVar.nfp;
            aVar.nsg = nVar.nfj;
            aVar.iKm = nVar.nfo;
            int i2 = i + 1;
            aVar.position = i2;
            linkedList.add(aVar);
            i = i2;
        }
        return linkedList;
    }
}
