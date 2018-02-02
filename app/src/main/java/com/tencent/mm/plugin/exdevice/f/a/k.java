package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.protocal.c.aif;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k extends a<aie, aif> {
    private final WeakReference<b<k>> lKt;
    public List<String> lPx;
    public List<String> lPy;
    public List<String> lPz;

    protected final /* synthetic */ com.tencent.mm.bq.a aDC() {
        return new aie();
    }

    protected final /* synthetic */ com.tencent.mm.bq.a aDD() {
        return new aif();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bq.a aVar) {
    }

    public k(b<k> bVar) {
        this.lKt = new WeakReference(bVar);
    }

    public final int getType() {
        return 1758;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            aif com_tencent_mm_protocal_c_aif = (aif) apH();
            this.lPz = new ArrayList();
            Iterator it = com_tencent_mm_protocal_c_aif.wpD.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                ar.Hg();
                if (c.EY().WK(str2)) {
                    this.lPz.add(str2);
                }
            }
            this.lPx = new ArrayList();
            this.lPy = new ArrayList();
            if (com_tencent_mm_protocal_c_aif.wpE != null) {
                Iterator it2 = com_tencent_mm_protocal_c_aif.wpE.iterator();
                while (it2.hasNext()) {
                    wd wdVar = (wd) it2.next();
                    if (wdVar.wgB) {
                        this.lPy.add(wdVar.username);
                    }
                    ar.Hg();
                    if (c.EY().WK(wdVar.username)) {
                        this.lPx.add(wdVar.username);
                    }
                }
            }
            x.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", Integer.valueOf(this.lPy.size()), this.lPy.toString());
            x.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", Integer.valueOf(this.lPx.size()), this.lPx);
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.lKt.get();
        if (bVar != null) {
            x.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
            bVar.b(i2, i3, str, this);
            return;
        }
        x.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
    }
}
