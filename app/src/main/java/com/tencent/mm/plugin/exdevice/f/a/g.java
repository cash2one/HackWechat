package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.bv;
import com.tencent.mm.protocal.c.wb;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g extends a<bu, bv> {
    List<String> kqI;
    private final WeakReference<b<g>> lKt;
    public ArrayList<wb> lOT;

    protected final /* synthetic */ com.tencent.mm.bq.a aDC() {
        return new bu();
    }

    protected final /* synthetic */ com.tencent.mm.bq.a aDD() {
        return new bv();
    }

    protected final /* synthetic */ void g(com.tencent.mm.bq.a aVar) {
        bu buVar = (bu) aVar;
        for (String add : this.kqI) {
            buVar.hIA.add(add);
        }
    }

    public g(List<String> list, b<g> bVar) {
        this.kqI = list;
        this.lKt = new WeakReference(bVar);
    }

    public final int getType() {
        return 1777;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            bv bvVar = (bv) apH();
            this.lOT = new ArrayList();
            if (bvVar.vGV != null) {
                Iterator it = bvVar.vGV.iterator();
                while (it.hasNext()) {
                    x.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[]{Integer.valueOf(r1.index), Integer.valueOf(r1.jer), ((wb) it.next()).username});
                    this.lOT.add(r1);
                }
                x.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[]{this.lOT.toString(), Integer.valueOf(bvVar.vGV.size())});
            }
            ad.aEm().a(this.lOT, "hardcode_rank_id", "hardcode_app_name");
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.lKt.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/addfollow";
    }
}
