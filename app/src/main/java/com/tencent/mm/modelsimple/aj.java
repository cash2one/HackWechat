package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.blv;
import com.tencent.mm.protocal.c.blw;
import com.tencent.mm.protocal.c.blx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.HashSet;

public final class aj extends k implements com.tencent.mm.network.k {
    private static HashSet<Long> hOi = new HashSet();
    private final b gJQ;
    private e gJT;
    private final String toUserName;

    public static void S(String str, int i) {
        if (bh.ov(str) || !g.Dh().Cy()) {
            return;
        }
        if (!s.hn(str) || s.gJ(str)) {
            g.Di().gPJ.a(new aj(str, i), 0);
        }
    }

    public static void t(au auVar) {
        g.Dk();
        if (!((Boolean) g.Dj().CU().get(a.xtu, Boolean.valueOf(true))).booleanValue()) {
            x.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
        } else if (hOi.contains(Long.valueOf(auVar.field_msgId))) {
            x.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgId)});
        } else {
            hOi.add(Long.valueOf(auVar.field_msgId));
            if (g.Dh().Cy()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<![CDATA[<downloadList>");
                stringBuilder.append("<downloadItem>");
                stringBuilder.append("<username>");
                stringBuilder.append(auVar.field_talker);
                stringBuilder.append("</username>");
                stringBuilder.append("<msgsvrid>");
                stringBuilder.append(auVar.field_msgSvrId);
                stringBuilder.append("</msgsvrid>");
                stringBuilder.append("</downloadItem>");
                stringBuilder.append("</downloadList>]]>");
                String stringBuilder2 = stringBuilder.toString();
                x.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", new Object[]{Long.valueOf(auVar.field_msgId), stringBuilder});
                g.Di().gPJ.a(new aj(q.FS(), 11, "DownloadFile", stringBuilder2), 0);
            }
        }
    }

    public static void a(String str, int i, String str2, String str3) {
        if (!bh.ov(str) && !s.hn(str) && g.Dh().Cy()) {
            g.Di().gPJ.a(new aj(str, i, str2, str3), 0);
        }
    }

    public aj(String str, int i) {
        this.toUserName = str;
        b.a aVar = new b.a();
        aVar.hmj = new blw();
        aVar.hmk = new blx();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        aVar.hmi = 251;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        blw com_tencent_mm_protocal_c_blw = (blw) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_blw.nkp = q.FS();
        com_tencent_mm_protocal_c_blw.wPs = i;
        com_tencent_mm_protocal_c_blw.nko = str;
        com_tencent_mm_protocal_c_blw.vHU = System.currentTimeMillis();
        x.d("MicroMsg.NetSceneStatusNotify", "toUserName = " + str);
    }

    private aj(String str, int i, String str2, String str3) {
        this.toUserName = str;
        b.a aVar = new b.a();
        aVar.hmj = new blw();
        aVar.hmk = new blx();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        aVar.hmi = 251;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        blw com_tencent_mm_protocal_c_blw = (blw) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_blw.nkp = q.FS();
        com_tencent_mm_protocal_c_blw.wPs = i;
        com_tencent_mm_protocal_c_blw.nko = str;
        com_tencent_mm_protocal_c_blw.vHU = System.currentTimeMillis();
        com_tencent_mm_protocal_c_blw.wPv = new blv();
        com_tencent_mm_protocal_c_blw.wPv.nfp = str2;
        com_tencent_mm_protocal_c_blw.wPv.wPr = str3;
    }

    public final int getType() {
        return 251;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.toUserName);
        }
        this.gJT.a(i2, i3, str, this);
    }
}
