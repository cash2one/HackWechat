package com.tencent.mm.al;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.k.b;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import junit.framework.Assert;

public final class a extends k implements com.tencent.mm.network.k {
    private au fnB = new au();
    private e gJT;
    private af handler = new 1(this);

    public a(String str, String str2) {
        boolean z = true;
        this.fnB.eQ(1);
        this.fnB.dS(str);
        this.fnB.aq(ba.hR(str));
        this.fnB.eR(1);
        this.fnB.setContent(str2);
        this.fnB.setType(s.hp(str));
        ar.Hg();
        long Q = c.Fa().Q(this.fnB);
        if (Q == -1) {
            z = false;
        }
        Assert.assertTrue(z);
        x.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = " + Q);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.fnB.field_msgId);
        this.handler.sendEmptyMessageDelayed(0, 500);
        return 999;
    }

    public final int getType() {
        return 522;
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.fnB.field_msgId);
        this.fnB.eQ(2);
        this.fnB.aq(ba.n(this.fnB.field_talker, System.currentTimeMillis() / 1000));
        ar.Hg();
        c.Fa().a(this.fnB.field_msgId, this.fnB);
        this.gJT.a(0, 0, str, this);
    }
}
