package com.tencent.mm.plugin.sns.model;

import android.util.Base64;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.bjb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l extends k implements com.tencent.mm.network.k {
    public static List<Long> qTJ = Collections.synchronizedList(new LinkedList());
    private b gJQ;
    public e gJT;
    private String hTv;
    private long qQJ;

    public static boolean ev(long j) {
        if (qTJ.contains(Long.valueOf(j))) {
            return false;
        }
        qTJ.add(Long.valueOf(j));
        return true;
    }

    private static boolean ew(long j) {
        qTJ.remove(Long.valueOf(j));
        return true;
    }

    public l(long j, int i, String str) {
        boolean z;
        bdn com_tencent_mm_protocal_c_bdn = null;
        this.qQJ = j;
        a aVar = new a();
        aVar.hmj = new bja();
        aVar.hmk = new bjb();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
        aVar.hmi = 683;
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        this.hTv = stringBuilder.append(g.Dj().cachePath).append("ad_detail_session").toString();
        byte[] d = FileOp.d(this.hTv, 0, -1);
        this.gJQ = aVar.JZ();
        ((bja) this.gJQ.hmg.hmo).vPO = j;
        ((bja) this.gJQ.hmg.hmo).wMo = n.N(d);
        ((bja) this.gJQ.hmg.hmo).rYW = i;
        if (str != null && str.length() > 0) {
            bja com_tencent_mm_protocal_c_bja = (bja) this.gJQ.hmg.hmo;
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                if (decode != null) {
                    com_tencent_mm_protocal_c_bdn = new bdn();
                    com_tencent_mm_protocal_c_bdn.bj(decode);
                }
            }
            com_tencent_mm_protocal_c_bja.wMp = com_tencent_mm_protocal_c_bdn;
        }
        String str2 = "MicroMsg.NetSceneSnsAdObjectDetial";
        StringBuilder append = new StringBuilder("req snsId ").append(j).append(" ").append(i.eq(j)).append(" scene ").append(i).append(" buf is null? ");
        if (d == null) {
            z = true;
        } else {
            z = false;
        }
        x.d(str2, append.append(z).toString());
        x.i("MicroMsg.NetSceneSnsAdObjectDetial", "do adObjectDetail snsId[%d] scene[%d] syncBuffer[%s]", new Object[]{Long.valueOf(j), Integer.valueOf(i), str});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 683;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        byte[] a;
        Object obj = 1;
        x.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + i2 + " errCode " + i3);
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 4 && i3 == 1) {
                a = n.a(((bjb) this.gJQ.hmh.hmo).wMo);
                if (a != null) {
                    FileOp.deleteFile(this.hTv);
                    FileOp.b(this.hTv, a, a.length);
                }
                obj = null;
            } else {
                obj = null;
            }
        }
        if (obj == null) {
            this.gJT.a(i2, i3, str, this);
            ew(this.qQJ);
            return;
        }
        a = n.a(((bjb) this.gJQ.hmh.hmo).wMo);
        FileOp.deleteFile(this.hTv);
        FileOp.b(this.hTv, a, a.length);
        biz com_tencent_mm_protocal_c_biz = ((bjb) this.gJQ.hmh.hmo).wMq;
        bdn com_tencent_mm_protocal_c_bdn = ((bjb) this.gJQ.hmh.hmo).wMr;
        if (com_tencent_mm_protocal_c_biz != null) {
            x.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + n.b(com_tencent_mm_protocal_c_biz.wMm.wMW));
            x.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + com_tencent_mm_protocal_c_biz.wMn);
        }
        if (com_tencent_mm_protocal_c_biz == null || com_tencent_mm_protocal_c_biz.wMm == null || com_tencent_mm_protocal_c_biz.wMm.wzr <= 0) {
            if (!(com_tencent_mm_protocal_c_biz == null || com_tencent_mm_protocal_c_biz.wMm == null)) {
                x.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment:" + com_tencent_mm_protocal_c_biz.wMm.wNd.size() + " like: " + com_tencent_mm_protocal_c_biz.wMm.wNa.size());
            }
            a.a(com_tencent_mm_protocal_c_biz, com_tencent_mm_protocal_c_bdn);
            this.gJT.a(i2, i3, str, this);
            ew(this.qQJ);
            return;
        }
        x.i("MicroMsg.NetSceneSnsAdObjectDetial", com_tencent_mm_protocal_c_biz.wMm.vPO + " will remove by get detail ");
        ew(this.qQJ);
        ae.bvy().delete(com_tencent_mm_protocal_c_biz.wMm.vPO);
        ae.bvA().eM(com_tencent_mm_protocal_c_biz.wMm.vPO);
        this.gJT.a(i2, i3, str, this);
    }
}
