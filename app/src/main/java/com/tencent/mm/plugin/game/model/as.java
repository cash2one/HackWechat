package com.tencent.mm.plugin.game.model;

import com.tencent.mm.a.g;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.aq;
import com.tencent.mm.plugin.game.c.bo;
import com.tencent.mm.plugin.game.c.bp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class as extends k implements com.tencent.mm.network.k {
    public static final String neu = (a.bnF + "Game/TabNav/");
    private e gJT;
    final b lMW;

    static /* synthetic */ void a(bp bpVar) {
        if (bpVar == null) {
            return;
        }
        if (bh.cA(bpVar.ngS)) {
            x.i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
            return;
        }
        List arrayList = new ArrayList();
        Iterator it = bpVar.ngS.iterator();
        while (it.hasNext()) {
            aq aqVar = (aq) it.next();
            if (aqVar != null) {
                arrayList.add(aqVar.nhj);
                arrayList.add(aqVar.nhk);
            }
        }
        a(arrayList, new 2(bpVar));
    }

    public as() {
        b.a aVar = new b.a();
        aVar.hmj = new bo();
        aVar.hmk = new bp();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
        aVar.hmi = 2641;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 != 0 || i3 != 0) {
            this.gJT.a(i2, i3, str, this);
        } else if (((bp) ((b) qVar).hmh.hmo) == null) {
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 2641;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public static void a(a aVar) {
        x.i("MicroMsg.NetSceneGameIndex4TabNav", "pull gameIndexTabNav data");
        ar.CG().a(2641, new 1(aVar));
        ar.CG().a(new as(), 0);
    }

    private static void a(List<String> list, b bVar) {
        while (!bh.cA(list)) {
            String str = (String) list.remove(0);
            if (bh.ov(str)) {
                x.e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
            } else {
                String str2 = neu + g.s(str.getBytes());
                c.a aVar = new c.a();
                aVar.hDA = true;
                aVar.hDC = str2;
                o.PA().a(str, aVar.PK(), new 3(str, list, bVar));
                return;
            }
        }
        if (bVar != null) {
            bVar.onComplete();
        }
    }
}
