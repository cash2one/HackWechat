package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.q.a.a;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bjr;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;

class b$9 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$9(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof m) {
            String str;
            m mVar = (m) view.getTag();
            if (mVar.field_type == 21 && q.FS().equals(mVar.field_userName)) {
                str = mVar.bxV().nGJ;
                com.tencent.mm.plugin.sns.lucky.a.m.j(mVar);
                com.tencent.mm.plugin.sns.lucky.a.m.i(mVar);
                System.currentTimeMillis();
                b.pY(24);
            }
            Intent intent = new Intent();
            intent.putExtra("key_sendid", mVar.bxW());
            intent.putExtra("key_feedid", mVar.byq());
            intent.setClassName(this.rPY.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
            this.rPY.activity.startActivity(intent);
            str = mVar.byq();
            mVar.bxW();
            Mf(str);
        }
    }

    private static void Mf(String str) {
        m eR = ae.bvv().eR(ae.bvv().Lm(str).field_snsId);
        if (eR != null) {
            List list;
            bnp bxV = eR.bxV();
            if (bxV != null) {
                list = bxV.wQo.vYd;
                if (list.size() > 0) {
                    list.get(0);
                }
            }
            bjv n = ai.n(eR);
            list = new ArrayList();
            List list2 = n.wNo.wNR;
            if (list2 != null) {
                for (int i = 0; i < list2.size(); i++) {
                    bjr com_tencent_mm_protocal_c_bjr = (bjr) list2.get(i);
                    a aVar = new a();
                    aVar.jKk = com_tencent_mm_protocal_c_bjr.vIy;
                    aVar.nYI = com_tencent_mm_protocal_c_bjr.pbl;
                    aVar.nYJ = com_tencent_mm_protocal_c_bjr.wMA;
                    list.add(aVar);
                }
            }
            com.tencent.mm.plugin.q.a.i(str, list);
        }
    }
}
