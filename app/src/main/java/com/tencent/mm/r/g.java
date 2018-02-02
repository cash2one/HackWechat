package com.tencent.mm.r;

import android.os.Looper;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private aci gJR;
    acj gJS;
    e gJT = null;
    d gJU;
    private String gJV = null;
    private af handler = new af(Looper.getMainLooper());
    private int retryCount = 0;

    public g(d dVar) {
        if (dVar != null) {
            this.gJU = dVar;
            x.d("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[]{dVar.field_cgi, Integer.valueOf(dVar.field_cmdid), dVar.field_functionmsgid});
            a aVar = new a();
            aVar.hmj = new aci();
            aVar.hmk = new acj();
            aVar.hmi = 825;
            aVar.uri = dVar.field_cgi;
            aVar.hml = dVar.field_cmdid;
            aVar.hmm = 0;
            this.gJQ = aVar.JZ();
            this.gJR = (aci) this.gJQ.hmg.hmo;
            this.gJR.wld = dVar.field_functionmsgid;
            if (dVar.field_custombuff != null) {
                this.gJR.wle = dVar.field_custombuff;
            }
        }
    }

    public final int getType() {
        return 825;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.gJU != null) {
            x.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[]{this.gJU.field_functionmsgid});
            this.gJU.field_status = 1;
        }
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    protected final int Bh() {
        return 6;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJS = (acj) ((b) qVar).hmh.hmo;
        this.gJV = this.gJS.wle;
        x.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.gJS.vDW), Boolean.valueOf(bh.ov(this.gJV)), Long.valueOf(this.gJS.wlf)});
        if (!bh.ov(this.gJV)) {
            this.gJR = (aci) this.gJQ.hmg.hmo;
            this.gJR.wle = this.gJV;
        }
        if (i2 == 0 || i3 == 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a((long) this.gJU.field_reportid, (long) this.gJU.field_successkey, 1, false);
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 4) {
            x.i("MicroMsg.NetSceneGetFuncMsg", "server error");
            if (this.gJS.vDW != 1) {
                Bi();
                return;
            }
            x.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, stop retry, directly return");
            this.gJT.a(i2, i3, str, this);
        } else {
            x.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
            com.tencent.mm.plugin.report.service.g.pQN.a((long) this.gJU.field_reportid, (long) this.gJU.field_failkey, 1, false);
            if (this.retryCount < 2) {
                x.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, retry, retryCount: %s", new Object[]{Integer.valueOf(this.retryCount)});
                this.retryCount++;
                Bi();
                return;
            }
            x.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, reach retry limit, directly return");
            com.tencent.mm.plugin.report.service.g.pQN.a((long) this.gJU.field_reportid, (long) this.gJU.field_finalfailkey, 1, false);
            this.gJT.a(i2, i3, str, this);
        }
    }

    private void Bi() {
        this.handler.postDelayed(new 1(this), (long) (this.gJU.field_retryinterval * 1000));
    }
}
