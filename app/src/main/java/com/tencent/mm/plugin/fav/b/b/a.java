package com.tencent.mm.plugin.fav.b.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.protocal.c.mz;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private e gJT = null;
    private b hFi;

    public a(List<uw> list) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new mx();
        aVar.hmk = new my();
        aVar.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        aVar.hmi = 405;
        aVar.hml = 196;
        aVar.hmm = 1000000196;
        this.hFi = aVar.JZ();
        mx mxVar = (mx) this.hFi.hmg.hmo;
        mxVar.vVI = new LinkedList();
        mxVar.vVI.addAll(list);
        mxVar.rYW = 1;
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", new Object[]{Integer.valueOf(list.size())});
    }

    public a(vh vhVar) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new mx();
        aVar.hmk = new my();
        aVar.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        aVar.hmi = 405;
        aVar.hml = 196;
        aVar.hmm = 1000000196;
        this.hFi = aVar.JZ();
        mx mxVar = (mx) this.hFi.hmg.hmo;
        mxVar.vVJ = vhVar;
        mxVar.rYW = 2;
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", new Object[]{Integer.valueOf(vhVar.vGM)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        my myVar = (my) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            Iterator it = myVar.vVK.iterator();
            while (it.hasNext()) {
                mz mzVar = (mz) it.next();
                x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", new Object[]{Integer.valueOf(mzVar.vGM), Integer.valueOf(mzVar.vJU)});
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
        this.gJT.a(i2, i3, str, this);
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 10;
    }

    public final int getType() {
        return 405;
    }
}
