package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.pv;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.m;
import java.util.LinkedList;
import java.util.List;

public final class g extends k implements com.tencent.mm.network.k {
    public List<String> fAN;
    private b gJQ;
    private e gJT;

    public g(String str, List<String> list) {
        this(str, list, 0);
    }

    public g(String str, List<String> list, int i) {
        a aVar = new a();
        aVar.hmj = new pv();
        aVar.hmk = new pw();
        aVar.uri = "/cgi-bin/micromsg-bin/delchatroommember";
        aVar.hmi = 179;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        pv pvVar = (pv) this.gJQ.hmg.hmo;
        pvVar.vYJ = str;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            qe qeVar = new qe();
            qeVar.vYO = n.os(str2);
            linkedList.add(qeVar);
        }
        pvVar.vGF = linkedList;
        pvVar.kZx = linkedList.size();
        pvVar.rYW = i;
        this.fAN = list;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 179;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        pv pvVar = (pv) this.gJQ.hmg.hmo;
        pw pwVar = (pw) this.gJQ.hmh.hmo;
        if (this.gJQ.hmh.vBp != 0) {
            this.gJT.a(i2, i3, str, this);
            return;
        }
        m.a(pvVar.vYJ, pwVar);
        this.gJT.a(i2, i3, str, this);
    }
}
