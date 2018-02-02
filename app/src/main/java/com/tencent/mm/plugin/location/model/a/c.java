package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbq;
import com.tencent.mm.protocal.c.bbr;
import com.tencent.mm.protocal.c.bod;
import com.tencent.mm.protocal.c.brr;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gJT;
    private Runnable hOe;
    public String jcO;
    public int nSf;
    public bod nSg = null;
    public List<brr> nSh = null;
    public bbr nSi;
    public int nSj;
    private String nSk;

    public c(String str, int i, brr com_tencent_mm_protocal_c_brr, int i2, bod com_tencent_mm_protocal_c_bod) {
        a aVar = new a();
        aVar.hmj = new bbq();
        aVar.hmk = new bbr();
        aVar.uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
        aVar.hmi = 492;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bbq com_tencent_mm_protocal_c_bbq = (bbq) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bbq.wbr = str;
        com_tencent_mm_protocal_c_bbq.ktN = i;
        com_tencent_mm_protocal_c_bbq.wHX = com_tencent_mm_protocal_c_brr;
        com_tencent_mm_protocal_c_bbq.nhw = i2;
        com_tencent_mm_protocal_c_bbq.wHY = com_tencent_mm_protocal_c_bod;
        this.nSk = str;
        this.nSj = com_tencent_mm_protocal_c_bbq.ktN;
        x.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + com_tencent_mm_protocal_c_brr.vIy + " " + com_tencent_mm_protocal_c_brr.wTo.vNP + " " + com_tencent_mm_protocal_c_brr.wTo.vNO + " heading:" + com_tencent_mm_protocal_c_brr.wTo.wEE);
        x.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + com_tencent_mm_protocal_c_bod.vNP + " " + com_tencent_mm_protocal_c_bod.vNO + " " + com_tencent_mm_protocal_c_bod.nfp);
        x.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + str + " uploadStatus:" + i);
    }

    public final int getType() {
        return 492;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.nSi = (bbr) ((b) qVar).hmh.hmo;
        if (this.nSi != null) {
            this.jcO = this.nSi.vQQ;
        }
        if (i2 == 0 && i3 == 0) {
            this.nSf = this.nSi.wux;
            this.nSg = this.nSi.wIa;
            this.nSh = this.nSi.wHZ;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format("[ resp count %d ] ", new Object[]{Integer.valueOf(this.nSi.ksO)}));
            if (this.nSg != null) {
                stringBuffer.append(String.format("[ roomPoi  %f %f %s] ", new Object[]{Double.valueOf(this.nSg.vNP), Double.valueOf(this.nSg.vNO), this.nSg.nfp}));
            }
            x.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + stringBuffer.toString());
            List linkedList = new LinkedList();
            Iterator it = this.nSi.wHZ.iterator();
            while (it.hasNext()) {
                brr com_tencent_mm_protocal_c_brr = (brr) it.next();
                if (com_tencent_mm_protocal_c_brr == null) {
                    linkedList.add(com_tencent_mm_protocal_c_brr);
                } else {
                    if (com_tencent_mm_protocal_c_brr.wTo == null) {
                        linkedList.add(com_tencent_mm_protocal_c_brr);
                    }
                    if (Math.abs(com_tencent_mm_protocal_c_brr.wTo.vNO) > 180.0d || Math.abs(com_tencent_mm_protocal_c_brr.wTo.vNP) > 90.0d) {
                        x.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[]{com_tencent_mm_protocal_c_brr.vIy, Double.valueOf(com_tencent_mm_protocal_c_brr.wTo.vNP), Double.valueOf(com_tencent_mm_protocal_c_brr.wTo.vNO), Double.valueOf(com_tencent_mm_protocal_c_brr.wTo.wEE)});
                        linkedList.add(com_tencent_mm_protocal_c_brr);
                    }
                }
            }
            this.nSi.ksO = this.nSi.wHZ.size();
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
        if (this.hOe != null) {
            this.hOe.run();
        }
    }
}
