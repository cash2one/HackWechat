package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bqv;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

public final class s extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private int hyU;
    private List<String> lzl = new ArrayList();

    public s(List<String> list, int i) {
        a aVar = new a();
        aVar.hmj = new bqv();
        aVar.hmk = new bqw();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
        aVar.hmi = 717;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.lzl = list;
        this.hyU = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            ar.Hg();
            c.CU().a(w.a.xnh, Long.valueOf(System.currentTimeMillis()));
            ar.Hg();
            c.CU().a(w.a.xnk, Boolean.valueOf(true));
            g.pQN.a(165, 0, 1, false);
        } else {
            ar.Hg();
            c.CU().a(w.a.xnh, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            g.pQN.a(165, 1, 1, false);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 717;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        bqv com_tencent_mm_protocal_c_bqv = (bqv) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bqv.vDW = this.hyU;
        if (this.lzl != null) {
            for (Object obj : this.lzl) {
                Object obj2;
                if (!bh.ov(obj2) && obj2.equals(String.valueOf(EmojiGroupInfo.xAb))) {
                    obj2 = "com.tencent.xin.emoticon.tusiji";
                }
                com_tencent_mm_protocal_c_bqv.wSo.add(obj2);
                x.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[]{obj2});
            }
            x.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[]{Integer.valueOf(this.hyU), Integer.valueOf(this.lzl.size())});
        }
        return a(eVar, this.gJQ, this);
    }
}
