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

class FindMContactAlertUI$9 implements e {
    final /* synthetic */ FindMContactAlertUI ymg;

    FindMContactAlertUI$9(FindMContactAlertUI findMContactAlertUI) {
        this.ymg = findMContactAlertUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (FindMContactAlertUI.f(this.ymg) != null) {
            FindMContactAlertUI.f(this.ymg).dismiss();
            FindMContactAlertUI.g(this.ymg);
        }
        if (FindMContactAlertUI.h(this.ymg) != null) {
            ar.CG().b(d.CTRL_INDEX, FindMContactAlertUI.h(this.ymg));
            FindMContactAlertUI.i(this.ymg);
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
            String str2 = "MicroMsg.FindMContactAlertUI";
            String str3 = "tigerreg data size=%d, addcount=%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(Oq == null ? 0 : Oq.size());
            objArr[1] = Integer.valueOf(i3);
            x.d(str2, str3, objArr);
            if (FindMContactAlertUI.b(this.ymg) == null || !FindMContactAlertUI.b(this.ymg).contains("1") || r0 == 0) {
                FindMContactAlertUI.d(this.ymg);
                return;
            }
            b.oH("R300_300_phone");
            Intent intent = new Intent(this.ymg, FindMContactAddUI.class);
            intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(this.ymg));
            intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(this.ymg));
            intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(this.ymg));
            intent.putExtra("login_type", 0);
            MMWizardActivity.A(this.ymg, intent);
            return;
        }
        Toast.makeText(this.ymg, this.ymg.getString(R.l.dEP, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        FindMContactAlertUI.d(this.ymg);
    }
}
