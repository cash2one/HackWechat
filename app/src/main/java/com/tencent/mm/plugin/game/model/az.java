package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bi;
import com.tencent.mm.plugin.game.c.bj;
import com.tencent.mm.plugin.game.c.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class az extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b lMW;

    public az(String str, LinkedList<String> linkedList, t tVar, t tVar2, t tVar3, boolean z) {
        x.i("MicroMsg.NetSceneGetGameIndex2", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetGameIndex2", "install id:[%s]", new Object[]{(String) it.next()});
        }
        a aVar = new a();
        aVar.hmj = new bi();
        aVar.hmk = new bj();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex2";
        aVar.hmi = 1238;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        bi biVar = (bi) this.lMW.hmg.hmo;
        biVar.nhF = str;
        biVar.nic = linkedList;
        String cO = g.cO(ac.getContext());
        if (bh.ov(cO)) {
            cO = bh.cgv();
        }
        if (!bh.ov(m.countryCode)) {
            cO = m.countryCode;
        }
        biVar.hvC = cO;
        if (tVar == null) {
            if (tVar2 != null) {
                tVar = tVar2;
            } else if (tVar3 != null) {
                tVar = tVar3;
            } else {
                tVar = null;
            }
        }
        biVar.nid = new s();
        if (tVar != null) {
            biVar.nid.ngn = tVar.ncl.nda;
            biVar.nid.ngo = tVar.field_appId;
            biVar.nid.nfl = tVar.ncT;
            if (tVar.field_msgType == 100) {
                biVar.nid.ngq = tVar.ncS;
            } else {
                biVar.nid.ngq = tVar.field_msgType;
            }
        }
        if (tVar2 != null) {
            s sVar = biVar.nid;
            sVar.ngp |= 1;
        }
        if (tVar3 != null) {
            sVar = biVar.nid;
            sVar.ngp |= 2;
        }
        biVar.nie = SubCoreGameCenter.aRd().aQx();
        biVar.nif = z;
        biVar.nhG = bh.cgC() ? 1 : 0;
        x.i("MicroMsg.NetSceneGetGameIndex2", "Country Code: %s", new Object[]{cO});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndex2", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1238;
    }
}
