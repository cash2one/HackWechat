package com.tencent.mm.plugin.emoji.f;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.by.h;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.abs;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.anx;
import com.tencent.mm.protocal.c.si;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.c;
import java.util.Iterator;
import java.util.List;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gOB;
    private a lyW;
    private boolean lyX = false;
    private mg lyY = null;
    public String lyx = "";

    public k(String str) {
        b.a aVar = new b.a();
        aVar.hmj = new abs();
        aVar.hmk = new abt();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar.hmi = 521;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.lyx = str;
        this.lyY = new mg();
    }

    public k(String str, a aVar) {
        b.a aVar2 = new b.a();
        aVar2.hmj = new abs();
        aVar2.hmk = new abt();
        aVar2.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar2.hmi = 521;
        aVar2.hml = 0;
        aVar2.hmm = 0;
        this.gJQ = aVar2.JZ();
        this.lyx = str;
        this.lyW = aVar;
        this.lyX = true;
        this.lyY = new mg();
    }

    public final int getType() {
        return 521;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[]{this.lyx});
        this.gOB = eVar2;
        ((abs) this.gJQ.hmg.hmo).vIR = this.lyx;
        if (!TextUtils.isEmpty(this.lyx)) {
            return a(eVar, this.gJQ, this);
        }
        x.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
        return -1;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 != 0 || i3 != 0) {
            x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), this.lyx});
            if (this.lyX) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
            }
        } else if (!this.lyX) {
            List<si> list = ((abt) this.gJQ.hmh.hmo).ksP;
            c cVar = i.aBE().lwN;
            String str2 = this.lyx;
            int i4 = ((abt) this.gJQ.hmh.hmo).wkA;
            int aBR = aBR();
            if (cVar.xAA != null) {
                cVar.xAA.edit().putLong("274544" + str2, System.currentTimeMillis()).commit();
            }
            if (list != null && list.size() > 0) {
                long dz;
                h hVar;
                if (cVar.gJP instanceof h) {
                    h hVar2 = (h) cVar.gJP;
                    dz = hVar2.dz(Thread.currentThread().getId());
                    hVar = hVar2;
                } else {
                    hVar = null;
                    dz = -1;
                }
                cVar.gJP.delete("EmojiInfoDesc", "groupId=?", new String[]{str2});
                com.tencent.mm.storage.emotion.b bVar = new com.tencent.mm.storage.emotion.b();
                bVar.field_groupId = str2;
                bVar.field_click_flag = i4;
                bVar.field_download_flag = aBR;
                for (si siVar : list) {
                    bVar.field_md5 = siVar.vZL;
                    Iterator it = siVar.ksP.iterator();
                    while (it.hasNext()) {
                        anx com_tencent_mm_protocal_c_anx = (anx) it.next();
                        bVar.field_desc = com_tencent_mm_protocal_c_anx.nfe;
                        bVar.field_lang = com_tencent_mm_protocal_c_anx.nhF;
                        bVar.field_md5_lang = bVar.field_md5 + bVar.field_lang;
                        if (cVar.gJP.replace("EmojiInfoDesc", "md5_lang", bVar.vI()) < 0) {
                            if (hVar != null) {
                                hVar.fS(dz);
                            }
                        }
                    }
                }
                cVar.gJP.replace("EmojiInfoDesc", "md5_lang", bVar.vI());
                if (hVar != null) {
                    hVar.fS(dz);
                }
            }
            if (list != null && list.size() > 0) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[]{this.lyx});
                this.lyY.fEd.fqV = this.lyx;
                com.tencent.mm.sdk.b.a.xef.m(this.lyY);
            }
        } else if ((aBR() & 1) == 1) {
            com.tencent.mm.plugin.emoji.g.c.a(this.lyW);
        } else {
            x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        }
        this.gOB.a(i2, i3, str, this);
    }

    private int aBR() {
        return ((abt) this.gJQ.hmh.hmo).wkC;
    }

    protected final int Bh() {
        return 50;
    }

    protected final int a(q qVar) {
        return com.tencent.mm.ae.k.b.hmP;
    }
}
