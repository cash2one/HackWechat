package com.tencent.mm.console;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import java.util.List;

class b$7 implements Runnable {
    final /* synthetic */ String gIt;
    final /* synthetic */ q gIw;
    final /* synthetic */ String gIx;

    b$7(q qVar, String str, String str2) {
        this.gIw = qVar;
        this.gIx = str;
        this.gIt = str2;
    }

    public final void run() {
        int chQ = this.gIw.chQ();
        int i = this.gIw.field_chatroomdataflag;
        int chT = this.gIw.chT();
        q qVar = this.gIw;
        if (qVar.b(qVar.xmy)) {
            qVar.chP();
        }
        int i2 = qVar.xmy.status;
        int chU = this.gIw.chU();
        qVar = this.gIw;
        if (qVar.b(qVar.xmy)) {
            qVar.chP();
        }
        String str = qVar.xmy.gBJ;
        List Ms = this.gIw.Ms();
        ar.Hg();
        cf dk = c.Fa().dk(this.gIx, " and flag != 0 and msgSeq != 0");
        boolean z = dk != null && dk.field_msgId > 0;
        ar.Hg();
        x.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", new Object[]{this.gIx, Integer.valueOf(chQ), Integer.valueOf(i), Integer.valueOf(chT), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(c.Fa().EM(this.gIx)), Integer.valueOf(chU), str, Integer.valueOf(Ms.size())});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---chatroominfo---\nid:").append(this.gIx).append("\nver:").append(chQ).append("\nflag:").append(i).append("\ntype:").append(chT).append("\nstatus:").append(i2).append("\nget:").append(z).append("\nmsgCount:").append(r8).append("\nmaxCount:").append(chU).append("\nupgrader:").append(str).append("\nmembersize:").append(Ms.size());
        int i3 = -1;
        try {
            i3 = bh.getInt(this.gIt.split(" ")[1], 0);
        } catch (Exception e) {
        }
        if (i3 == -1) {
            i3 = Ms.size();
        }
        if (i3 > Ms.size()) {
            i3 = Ms.size();
        }
        if (i3 > 10) {
            i = 10;
        } else {
            i = i3;
        }
        if (i > 0) {
            stringBuilder.append("\nmember:");
        }
        for (chQ = 0; chQ < i; chQ++) {
            stringBuilder.append("\n").append((String) Ms.get(chQ));
        }
        au auVar = new au();
        auVar.dS(this.gIx);
        auVar.eR(2);
        auVar.setType(1);
        auVar.aq(System.currentTimeMillis());
        auVar.setContent(stringBuilder.toString());
        ba.i(auVar);
    }
}
