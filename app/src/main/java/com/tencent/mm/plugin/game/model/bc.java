package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bq.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bs;
import com.tencent.mm.plugin.game.c.bt;
import com.tencent.mm.plugin.game.c.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class bc extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b lMW;

    public bc(String str, LinkedList<String> linkedList, t tVar, t tVar2, t tVar3, boolean z) {
        x.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[]{(String) it.next()});
        }
        a bsVar = new bs();
        bsVar.nhF = str;
        bsVar.nic = linkedList;
        String cO = g.cO(ac.getContext());
        if (bh.ov(cO)) {
            cO = bh.cgv();
        }
        if (!bh.ov(m.countryCode)) {
            cO = m.countryCode;
        }
        bsVar.hvC = cO;
        if (tVar == null) {
            if (tVar2 != null) {
                tVar = tVar2;
            } else if (tVar3 != null) {
                tVar = tVar3;
            } else {
                tVar = null;
            }
        }
        bsVar.nid = new s();
        if (tVar != null) {
            bsVar.nid.ngn = tVar.ncl.nda;
            bsVar.nid.ngo = tVar.field_appId;
            bsVar.nid.nfl = tVar.ncT;
            if (tVar.field_msgType == 100) {
                bsVar.nid.ngq = tVar.ncS;
            } else {
                bsVar.nid.ngq = tVar.field_msgType;
            }
        }
        if (tVar2 != null) {
            s sVar = bsVar.nid;
            sVar.ngp |= 1;
        }
        if (tVar3 != null) {
            sVar = bsVar.nid;
            sVar.ngp |= 2;
        }
        bsVar.nie = SubCoreGameCenter.aRd().aQx();
        bsVar.nif = z;
        bsVar.nhG = bh.cgC() ? 1 : 0;
        x.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[]{cO});
        b.a aVar = new b.a();
        aVar.hmj = bsVar;
        aVar.hmk = new bt();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
        aVar.hmi = 2855;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
    }

    public final int getType() {
        return 2855;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
