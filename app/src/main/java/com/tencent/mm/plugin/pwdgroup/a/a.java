package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ul;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.protocal.c.un;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public int plw;

    public a(int i, String str, String str2, float f, float f2, int i2, int i3, String str3, String str4) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new ul();
        aVar.hmk = new um();
        aVar.uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
        this.gJQ = aVar.JZ();
        ul ulVar = (ul) this.gJQ.hmg.hmo;
        this.plw = i;
        ulVar.vDW = i;
        ulVar.wcq = str;
        ulVar.vZK = str2;
        ulVar.vQt = f2;
        ulVar.vQu = f;
        ulVar.wcr = i2;
        if (!bh.ov(str3)) {
            ulVar.wcs = str3;
        }
        if (!bh.ov(str4)) {
            ulVar.wct = str4;
        }
        ulVar.wcu = i3;
        x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", Integer.valueOf(i), str2, Float.valueOf(f2), Float.valueOf(f), Integer.valueOf(i2), str3, str4, Integer.valueOf(i3));
        o.a(TXLiveConstants.PLAY_EVT_PLAY_LOADING, f2, f, i2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.plw == 0) {
            um bjN = bjN();
            if (bjN != null) {
                LinkedList linkedList = bjN.vGF;
                if (linkedList != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int size = linkedList.size();
                    List arrayList = new ArrayList();
                    for (int i4 = 0; i4 < size; i4++) {
                        un unVar = (un) linkedList.get(i4);
                        h hVar = new h();
                        if (bh.ov(unVar.ksU)) {
                            hVar.username = unVar.wcv;
                        } else {
                            hVar.username = unVar.ksU;
                        }
                        x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", unVar.ksU, unVar.wao);
                        hVar.hlx = unVar.wao;
                        hVar.bA(true);
                        arrayList.add(hVar);
                    }
                    n.JQ().H(arrayList);
                    x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 653;
    }

    public final um bjN() {
        return (um) this.gJQ.hmh.hmo;
    }
}
