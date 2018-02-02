package com.tencent.mm.ui.chatting.b;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Arrays;
import java.util.LinkedList;

class f$8 implements OnClickListener {
    final /* synthetic */ f yzA;
    final /* synthetic */ LinearLayout yzF;

    f$8(f fVar, LinearLayout linearLayout) {
        this.yzA = fVar;
        this.yzF = linearLayout;
    }

    public final void onClick(View view) {
        if (this.yzA.fhr.csl()) {
            q qVar = this.yzA.yvR;
            int i = this.yzA.qra;
            if (qVar.kvB != null) {
                ar.CG().a(new o(2, Arrays.asList(new String[]{qVar.fhr.vS()}), Arrays.asList(new Integer[]{Integer.valueOf(18)}), String.format(qVar.fhr.csq().getMMString(R.l.dKp), new Object[]{bh.ou(q.FU())}), ""), 0);
                qVar.yAw = true;
            } else {
                c nb = l.Ty().nb(qVar.fhr.vS());
                ar.CG().a(new o(qVar.fhr.vS(), nb.field_ticket, i), 0);
                nb.field_flag = 2;
                l.Ty().c(nb, new String[0]);
            }
            qVar.yAv.ctu();
            return;
        }
        if (((int) this.yzA.fhr.csi().gJd) == 0) {
            ar.Hg();
            if (com.tencent.mm.z.c.EY().S(this.yzA.fhr.csi()) != -1) {
                p pVar = this.yzA.fhr;
                ar.Hg();
                pVar.U(com.tencent.mm.z.c.EY().WO(this.yzA.yzm));
            }
        }
        String str = s.eV(this.yzA.fhr.csi().field_username) ? this.yzA.fhr.csi().field_username : "";
        ar.Hg();
        af WO = com.tencent.mm.z.c.EY().WO(this.yzA.yzm);
        Object az = WO != null ? bh.az(WO.fWF, "") : "";
        x.i("MicroMsg.ChattingUI.ChattingHeadereMgr", "dkverify banner add:%s chat:%s ticket", new Object[]{this.yzA.yzm, str, az});
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(az)) {
            a aVar = new a(this.yzA.fhr.csq().getContext(), new 1(this));
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(3));
            aVar.Sk(az);
            aVar.b(this.yzA.yzm, str, linkedList);
        } else {
            ak.a.hfL.a(this.yzA.yzm, str, new 2(this, str));
        }
        g.pQN.h(11004, new Object[]{this.yzA.yzm, Integer.valueOf(3)});
    }
}
