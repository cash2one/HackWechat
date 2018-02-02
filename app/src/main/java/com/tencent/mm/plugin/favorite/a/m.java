package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.protocal.c.fh;
import com.tencent.mm.protocal.c.fi;
import com.tencent.mm.protocal.c.qb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class m extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT = null;
    private LinkedList<Integer> mqw;
    private int mqx = 0;

    public m(LinkedList<Integer> linkedList) {
        a aVar = new a();
        aVar.hmj = new fh();
        aVar.hmk = new fi();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
        aVar.hmi = ap.CTRL_INDEX;
        aVar.hml = JsApiUploadEncryptedFileToCDN.CTRL_INDEX;
        aVar.hmm = 1000000194;
        this.gJQ = aVar.JZ();
        this.mqw = linkedList;
    }

    private boolean aIR() {
        boolean z;
        if (this.mqw == null || this.mqx >= this.mqw.size()) {
            z = false;
        } else {
            z = true;
        }
        x.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.mqw == null || this.mqw.isEmpty() || this.mqx >= this.mqw.size()) {
            x.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[]{Integer.valueOf(this.mqx)});
            return -1;
        }
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[]{Integer.valueOf(this.mqw.size()), Integer.valueOf(this.mqx), this.mqw});
        fh fhVar = (fh) this.gJQ.hmg.hmo;
        fhVar.vLf.clear();
        int i = 0;
        int i2 = this.mqx;
        while (i2 < this.mqw.size()) {
            int intValue = ((Integer) this.mqw.get(i2)).intValue();
            if (intValue > 0) {
                fhVar.vLf.add(Integer.valueOf(intValue));
                intValue = i + 1;
            } else {
                intValue = i;
            }
            if (intValue >= 20) {
                break;
            }
            i2++;
            i = intValue;
        }
        this.mqx = i2 + 1;
        fhVar.ksO = fhVar.vLf.size();
        x.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[]{Integer.valueOf(fhVar.ksO), fhVar.vLf});
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mqx), Integer.valueOf(this.mqw.size()), str});
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((fi) ((b) qVar).hmh.hmo).ksP;
            if (linkedList == null || linkedList.size() == 0) {
                x.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
                if (aIR()) {
                    a(this.hmA, this.gJT);
                    return;
                } else {
                    this.gJT.a(i2, i3, str, this);
                    return;
                }
            }
            List arrayList = new ArrayList();
            x.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", new Object[]{Integer.valueOf(linkedList.size())});
            for (int i4 = 0; i4 < linkedList.size(); i4++) {
                qb qbVar = (qb) linkedList.get(i4);
                if (qbVar.vJU < 0) {
                    x.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[]{Integer.valueOf(qbVar.vGM)});
                } else {
                    arrayList.add(Integer.valueOf(qbVar.vGM));
                    x.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[]{Integer.valueOf(qbVar.vGM)});
                }
            }
            j.aL(arrayList);
            if (aIR()) {
                a(this.hmA, this.gJT);
            } else {
                this.gJT.a(i2, i3, str, this);
            }
        } else if (aIR()) {
            a(this.hmA, this.gJT);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 10;
    }

    public final int getType() {
        return ap.CTRL_INDEX;
    }
}
