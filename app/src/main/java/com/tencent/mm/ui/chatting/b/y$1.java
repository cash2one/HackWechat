package com.tencent.mm.ui.chatting.b;

import android.database.Cursor;
import com.tencent.mm.ae.k;
import com.tencent.mm.al.a;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.i;
import com.tencent.mm.bf.l;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.LinkedList;

class y$1 implements Runnable {
    final /* synthetic */ String gIt;
    final /* synthetic */ int qR;
    final /* synthetic */ y yBS;

    y$1(y yVar, String str, int i) {
        this.yBS = yVar;
        this.gIt = str;
        this.qR = i;
    }

    public final void run() {
        f.vz(20);
        int i = (this.yBS.fhr.csi().field_username.equals("medianote") && (q.FW() & 16384) == 0) ? 1 : 0;
        if (i != 0) {
            this.yBS.fhr.csv();
            ar.CG().a(new a(this.yBS.fhr.csi().field_username, this.gIt), 0);
            return;
        }
        String csk;
        if (this.yBS.fhr.csy().getCount() == 0 && x.Wz(this.yBS.fhr.crz())) {
            bo.HS().c(10076, Integer.valueOf(1));
        }
        String crz = this.yBS.fhr.crz();
        int hp = s.hp(crz);
        String str = this.gIt;
        q qVar = this.yBS.yvR;
        if (qVar.fhr.csl()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.LbsImp", "[oneliang]encrypt:" + qVar.fhr.vS() + ",raw:" + qVar.fhr.csk());
            csk = bh.ov(qVar.fhr.vS()) ? qVar.fhr.csk() : qVar.fhr.vS();
        } else {
            csk = crz;
        }
        if (bh.ov(csk)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI.TextImp", "tempUser is null");
            return;
        }
        ChatFooter csB = this.yBS.fhr.csB();
        int i2 = this.qR;
        int i3 = csB.vqg.vrh.containsKey(crz) ? ((LinkedList) csB.vqg.vrh.get(crz)).size() > 0 ? JsApiCreateAudioInstance.CTRL_INDEX : i2 : i2;
        k jVar = new j(csk, str, hp, i3, this.yBS.fhr.csB().ff(crz, str));
        q qVar2 = this.yBS.yvR;
        if (qVar2.fhr.csl()) {
            h hVar;
            csk = qVar2.kvB;
            i Ty = l.Ty();
            String vS = qVar2.fhr.vS();
            Cursor a = Ty.gJP.a("SELECT * FROM " + Ty.getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0" + " ORDER BY createtime desc LIMIT 1", new String[]{vS}, 2);
            if (a == null) {
                hVar = null;
            } else if (a.moveToFirst()) {
                hVar = new h();
                hVar.b(a);
                a.close();
            } else {
                a.close();
                hVar = null;
            }
            if (!(hVar == null || bh.ov(hVar.field_ticket))) {
                csk = hVar.field_ticket;
            }
            if (bh.ov(csk)) {
                hVar = l.Ty().nb(qVar2.fhr.vS());
                if (!(hVar == null || bh.ov(hVar.field_ticket))) {
                    csk = hVar.field_ticket;
                }
            }
            if (csk != null) {
                jVar.hFF = new com.tencent.mm.plugin.bbom.h(csk);
            }
        }
        ar.CG().a(jVar, 0);
        if (s.hl(crz)) {
            ar.CG().a(new n(com.tencent.mm.compatible.d.q.yT(), this.gIt + " key " + be.cjW() + " local key " + be.cjV() + "NetType:" + an.getNetTypeString(this.yBS.fhr.csq().getContext().getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.d.n.yv() + " isArmv6: " + com.tencent.mm.compatible.d.n.yx() + " isArmv7: " + com.tencent.mm.compatible.d.n.yw()), 0);
        }
    }
}
