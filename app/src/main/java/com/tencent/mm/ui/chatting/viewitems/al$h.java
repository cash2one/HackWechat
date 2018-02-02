package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r$d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class al$h extends r$d {
    public al$h(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        String str = auVar.field_content;
        b spVar = new sp();
        spVar.fKq.fuL = 1;
        spVar.fKq.content = str;
        com.tencent.mm.sdk.b.a.xef.m(spVar);
        b soVar;
        if (!(spVar.fKr.type == 2) && !auVar.field_content.equals(au.xzd)) {
            boolean z;
            str = auVar.field_content;
            spVar = new sp();
            spVar.fKq.fuL = 1;
            spVar.fKq.content = str;
            com.tencent.mm.sdk.b.a.xef.m(spVar);
            if (spVar.fKr.type == 3) {
                z = true;
            } else {
                z = false;
            }
            if ((z || auVar.field_content.equals(au.xzc)) && !com.tencent.mm.p.a.aU(this.yqa.getContext())) {
                soVar = new so();
                com.tencent.mm.sdk.b.a.xef.m(soVar);
                if (arVar.fEJ.field_talker.equals(soVar.fKm.talker) || !(soVar.fKm.fKo || soVar.fKm.fKp)) {
                    arVar.fEJ.eQ(6);
                    ar.Hg();
                    c.Fa().a(arVar.fEJ.field_msgId, arVar.fEJ);
                    this.yqa.ywe.ctH();
                    soVar = new sp();
                    soVar.fKq.fuL = 5;
                    soVar.fKq.talker = arVar.fEJ.field_talker;
                    soVar.fKq.context = this.yqa.getContext();
                    soVar.fKq.fKl = 4;
                    com.tencent.mm.sdk.b.a.xef.m(soVar);
                    g gVar = g.pQN;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Integer.valueOf(2);
                    int i = (arVar.fEJ.gjF == null || arVar.fEJ.gjF.length() <= 0) ? 1 : 3;
                    objArr[2] = Integer.valueOf(i);
                    gVar.h(11033, objArr);
                    return;
                }
                Toast.makeText(this.yqa.getContext(), soVar.fKm.fKn ? R.l.dNq : R.l.dNr, 0).show();
                x.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
            }
        } else if (!com.tencent.mm.p.a.aU(this.yqa.getContext())) {
            soVar = new so();
            com.tencent.mm.sdk.b.a.xef.m(soVar);
            if (arVar.fEJ.field_talker.equals(soVar.fKm.talker) || !(soVar.fKm.fKo || soVar.fKm.fKp)) {
                soVar = new ri();
                soVar.fJc.fJe = true;
                com.tencent.mm.sdk.b.a.xef.m(soVar);
                str = soVar.fJd.fJg;
                if (t.ov(str)) {
                    a(arVar);
                    return;
                }
                x.v("MicroMsg.VoipClickListener", "Talkroom is on: " + str);
                h.a(this.yqa.getContext(), this.yqa.getContext().getString(R.l.eQx), "", this.yqa.getContext().getString(R.l.dFU), this.yqa.getContext().getString(R.l.dEn), new 1(this, arVar), new OnClickListener(this) {
                    final /* synthetic */ al$h yOn;

                    {
                        this.yOn = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            }
            Toast.makeText(this.yqa.getContext(), soVar.fKm.fKn ? R.l.dNq : R.l.dNr, 0).show();
            x.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
        }
    }

    private void a(ar arVar) {
        int i = 3;
        arVar.fEJ.eQ(6);
        ar.Hg();
        c.Fa().a(arVar.fEJ.field_msgId, arVar.fEJ);
        this.yqa.ywe.ctH();
        b spVar = new sp();
        spVar.fKq.fuL = 5;
        spVar.fKq.talker = arVar.fEJ.field_talker;
        spVar.fKq.context = this.yqa.getContext();
        spVar.fKq.fKl = 2;
        com.tencent.mm.sdk.b.a.xef.m(spVar);
        g gVar = g.pQN;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(3);
        objArr[1] = Integer.valueOf(1);
        if (arVar.fEJ.gjF == null || arVar.fEJ.gjF.length() <= 0) {
            i = 1;
        }
        objArr[2] = Integer.valueOf(i);
        gVar.h(11033, objArr);
    }
}
