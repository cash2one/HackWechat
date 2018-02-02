package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bq.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bq;
import com.tencent.mm.plugin.game.c.br;
import com.tencent.mm.plugin.game.c.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class bb extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b lMW;

    public bb(String str, LinkedList<String> linkedList, t tVar, t tVar2, t tVar3, boolean z) {
        x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", new Object[]{(String) it.next()});
        }
        a bqVar = new bq();
        bqVar.nhF = str;
        bqVar.nic = linkedList;
        String cO = g.cO(ac.getContext());
        if (bh.ov(cO)) {
            cO = bh.cgv();
        }
        if (!bh.ov(m.countryCode)) {
            cO = m.countryCode;
        }
        bqVar.hvC = cO;
        if (tVar == null) {
            if (tVar2 != null) {
                tVar = tVar2;
            } else if (tVar3 != null) {
                tVar = tVar3;
            } else {
                tVar = null;
            }
        }
        bqVar.nid = new s();
        if (tVar != null) {
            bqVar.nid.ngn = tVar.ncl.nda;
            bqVar.nid.ngo = tVar.field_appId;
            bqVar.nid.nfl = tVar.ncT;
            if (tVar.field_msgType == 100) {
                bqVar.nid.ngq = tVar.ncS;
            } else {
                bqVar.nid.ngq = tVar.field_msgType;
            }
        }
        if (tVar2 != null) {
            s sVar = bqVar.nid;
            sVar.ngp |= 1;
        }
        if (tVar3 != null) {
            sVar = bqVar.nid;
            sVar.ngp |= 2;
        }
        bqVar.nie = SubCoreGameCenter.aRd().aQx();
        bqVar.nif = z;
        bqVar.nhG = bh.cgC() ? 1 : 0;
        x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", new Object[]{cO});
        b.a aVar = new b.a();
        aVar.hmj = bqVar;
        aVar.hmk = new br();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
        aVar.hmi = 2586;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
    }

    public final int getType() {
        return 2586;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
