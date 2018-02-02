package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aqv;
import com.tencent.mm.protocal.c.aqw;
import com.tencent.mm.protocal.c.bl;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends k implements com.tencent.mm.network.k {
    public String chatroomName = null;
    public final List<String> fAN;
    public final List<String> fAQ;
    public final List<String> fAS;
    public final List<String> fAT;
    public int fzQ = 0;
    private final b gJQ;
    private e gJT = null;
    public final List<String> kZl;
    public final List<String> kZm;
    public final List<String> kZn;

    public d(String str, List<String> list, String str2) {
        a aVar = new a();
        aVar.hmj = new bl();
        aVar.hmk = new bm();
        aVar.uri = "/cgi-bin/micromsg-bin/addchatroommember";
        aVar.hmi = 120;
        aVar.hml = 36;
        aVar.hmm = 1000000036;
        this.gJQ = aVar.JZ();
        bl blVar = (bl) this.gJQ.hmg.hmo;
        blVar.vGG = n.os(str);
        this.chatroomName = str;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            aqv com_tencent_mm_protocal_c_aqv = new aqv();
            com_tencent_mm_protocal_c_aqv.vYO = n.os(str3);
            linkedList.add(com_tencent_mm_protocal_c_aqv);
        }
        blVar.vGF = linkedList;
        blVar.kZx = linkedList.size();
        this.kZl = new ArrayList();
        this.fAQ = new LinkedList();
        this.kZm = new LinkedList();
        this.fAS = new LinkedList();
        this.fAT = new LinkedList();
        this.kZn = new ArrayList();
        this.fAN = list;
        blVar.vGI = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 120;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bl blVar = (bl) this.gJQ.hmg.hmo;
        bm bmVar = (bm) this.gJQ.hmh.hmo;
        this.fzQ = bmVar.kZx;
        List list = bmVar.vGF;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int i5 = ((aqw) list.get(i4)).wyG;
            if (i5 == 0) {
                this.kZl.add(n.a(((aqw) list.get(i4)).vYO));
            } else if (i5 == 3) {
                x.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((aqw) list.get(i4)).vYO);
                this.kZm.add(n.a(((aqw) list.get(i4)).vYO));
            } else if (i5 == 1) {
                x.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((aqw) list.get(i4)).vYO);
                this.fAS.add(n.a(((aqw) list.get(i4)).vYO));
            } else if (i5 == 2) {
                x.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((aqw) list.get(i4)).vYO);
                this.fAQ.add(n.a(((aqw) list.get(i4)).vYO));
            } else if (i5 == 4) {
                x.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((aqw) list.get(i4)).vYO);
                this.fAT.add(n.a(((aqw) list.get(i4)).vYO));
            } else if (i5 != 5) {
                if (i5 == 6) {
                    this.kZn.add(n.a(((aqw) list.get(i4)).vYO));
                } else {
                    x.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = " + i5);
                }
            }
        }
        this.gJT.a(i2, i3, str, this);
        if (i2 == 0 && i3 == 0) {
            m.a(n.a(blVar.vGG), bmVar);
        }
    }
}
