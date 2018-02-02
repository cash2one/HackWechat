package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.protocal.c.aqv;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    public au fEJ;
    private final b gJQ;
    private e gJT;
    public int kZx;

    public k(String str, List<String> list) {
        a aVar = new a();
        aVar.hmj = new alj();
        aVar.hmk = new alk();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        aVar.hmi = 610;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        alj com_tencent_mm_protocal_c_alj = (alj) this.gJQ.hmg.hmo;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            aqv com_tencent_mm_protocal_c_aqv = new aqv();
            com_tencent_mm_protocal_c_aqv.vYO = n.os(str2);
            linkedList.add(com_tencent_mm_protocal_c_aqv);
        }
        com_tencent_mm_protocal_c_alj.vGF = linkedList;
        com_tencent_mm_protocal_c_alj.kZx = linkedList.size();
        com_tencent_mm_protocal_c_alj.vGG = n.os(str);
        com_tencent_mm_protocal_c_alj.wsz = 0;
    }

    public k(String str, List<String> list, String str2, au auVar) {
        this.fEJ = auVar;
        a aVar = new a();
        aVar.hmj = new alj();
        aVar.hmk = new alk();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        aVar.hmi = 610;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        alj com_tencent_mm_protocal_c_alj = (alj) this.gJQ.hmg.hmo;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            aqv com_tencent_mm_protocal_c_aqv = new aqv();
            com_tencent_mm_protocal_c_aqv.vYO = n.os(str3);
            linkedList.add(com_tencent_mm_protocal_c_aqv);
        }
        this.kZx = linkedList.size();
        com_tencent_mm_protocal_c_alj.vGF = linkedList;
        com_tencent_mm_protocal_c_alj.kZx = linkedList.size();
        com_tencent_mm_protocal_c_alj.vGG = n.os(str);
        com_tencent_mm_protocal_c_alj.wsz = 2;
        com_tencent_mm_protocal_c_alj.wsA = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 610;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gJT.a(i2, i3, str, this);
    }
}
