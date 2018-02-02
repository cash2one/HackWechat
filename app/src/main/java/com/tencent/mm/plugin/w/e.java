package com.tencent.mm.plugin.w;

import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.w.a.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ao;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class e implements a, ao {
    public static e oFx;
    public int fAo;
    private String gze;
    private i.a hBx = new 1(this);
    String oFA;
    String oFB;
    int oFC;
    public long oFD;
    long oFE;
    long oFF;
    long oFG;
    boolean oFH = false;
    final com.tencent.mm.ae.e oFI = new 2(this);
    public c oFy = new c();
    public byte[] oFz;

    public final void a(String str, int i, String str2, int i2, long j, long j2) {
        x.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d", new Object[]{str, Integer.valueOf(i)});
        this.oFE = (long) i2;
        this.oFF = j;
        this.oFG = j2;
        this.gze = str2;
        String str3 = "MSG_SYNCHRONIZE_" + i + "_" + bh.Wp();
        i iVar = new i();
        iVar.htt = this.hBx;
        iVar.field_mediaId = str3;
        iVar.field_fullpath = str;
        iVar.field_fileType = b.MediaType_FILE;
        iVar.field_talker = (String) d.aqe().aqf().CU().get(2, null);
        iVar.field_priority = b.hrK;
        if (!g.MJ().c(iVar)) {
            x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", new Object[]{str3});
            com.tencent.mm.plugin.report.service.g.pQN.a(466, 2, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(14108, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.fAo)});
        }
    }

    public final void GX() {
        x.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", new Object[]{Boolean.valueOf(this.oFH), Boolean.valueOf(com.tencent.mm.kernel.a.gB(com.tencent.mm.kernel.g.Dh().gPs))});
        if (this.oFH && com.tencent.mm.kernel.a.gB(com.tencent.mm.kernel.g.Dh().gPs)) {
            x.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
            ar.Hg();
            c.b(this);
            this.oFH = false;
            bbM();
        }
    }

    final void bbM() {
        x.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg.");
        ar.CG().a(222, this.oFI);
        ar.CG().a(new d(this.oFA, this.oFB, this.oFC, this.gze), 0);
    }

    public final void onCancel() {
        x.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", new Object[]{ai.cfH()});
        this.oFy.oFr = true;
    }
}
