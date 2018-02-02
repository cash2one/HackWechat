package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.LinkedList;

class FindMContactLearmMoreUI$3 implements e {
    final /* synthetic */ FindMContactLearmMoreUI ymn;

    FindMContactLearmMoreUI$3(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        this.ymn = findMContactLearmMoreUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (FindMContactLearmMoreUI.c(this.ymn) != null) {
            FindMContactLearmMoreUI.c(this.ymn).dismiss();
            FindMContactLearmMoreUI.d(this.ymn);
        }
        if (FindMContactLearmMoreUI.e(this.ymn) != null) {
            ar.CG().b((int) d.CTRL_INDEX, FindMContactLearmMoreUI.e(this.ymn));
            FindMContactLearmMoreUI.f(this.ymn);
        }
        if (i == 0 && i2 == 0) {
            int i3;
            LinkedList Oq = ((y) kVar).Oq();
            af.f(Oq);
            int i4;
            if (Oq == null || Oq.size() <= 0) {
                i4 = 0;
                i3 = 0;
            } else {
                Iterator it = Oq.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    aou com_tencent_mm_protocal_c_aou = (aou) it.next();
                    if (com_tencent_mm_protocal_c_aou != null) {
                        if (com_tencent_mm_protocal_c_aou.ktm == 1) {
                            i4 = i3 + 1;
                        } else {
                            i4 = i3;
                        }
                        i3 = i4;
                    }
                }
                i4 = i3 > 0 ? 1 : 0;
            }
            String str2 = "MicroMsg.FindMContactLearmMoreUI";
            String str3 = "tigerreg data size=%d, addcount=%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(Oq == null ? 0 : Oq.size());
            objArr[1] = Integer.valueOf(i3);
            x.d(str2, str3, objArr);
            if (FindMContactLearmMoreUI.g(this.ymn) == null || !FindMContactLearmMoreUI.g(this.ymn).contains("1") || r0 == 0) {
                FindMContactLearmMoreUI.b(this.ymn);
                return;
            }
            b.oH("R300_300_phone");
            Intent intent = new Intent(this.ymn, FindMContactAddUI.class);
            intent.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.h(this.ymn));
            intent.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.g(this.ymn));
            intent.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.i(this.ymn));
            intent.putExtra("login_type", 0);
            MMWizardActivity.A(this.ymn, intent);
            return;
        }
        Toast.makeText(this.ymn, this.ymn.getString(R.l.dEP, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        FindMContactLearmMoreUI.b(this.ymn);
    }
}
