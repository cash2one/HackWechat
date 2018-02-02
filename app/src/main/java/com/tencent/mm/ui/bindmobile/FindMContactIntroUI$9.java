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

class FindMContactIntroUI$9 implements e {
    final /* synthetic */ FindMContactIntroUI ymj;

    FindMContactIntroUI$9(FindMContactIntroUI findMContactIntroUI) {
        this.ymj = findMContactIntroUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (FindMContactIntroUI.g(this.ymj) != null) {
            FindMContactIntroUI.g(this.ymj).dismiss();
            FindMContactIntroUI.h(this.ymj);
        }
        if (FindMContactIntroUI.i(this.ymj) != null) {
            ar.CG().b(d.CTRL_INDEX, FindMContactIntroUI.i(this.ymj));
            FindMContactIntroUI.j(this.ymj);
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
            String str2 = "MicroMsg.FindMContactIntroUI";
            String str3 = "tigerreg data size=%d, addcount=%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(Oq == null ? 0 : Oq.size());
            objArr[1] = Integer.valueOf(i3);
            x.d(str2, str3, objArr);
            if (FindMContactIntroUI.d(this.ymj) == null || !FindMContactIntroUI.d(this.ymj).contains("1") || r0 == 0) {
                FindMContactIntroUI.b(this.ymj);
                return;
            }
            b.oH("R300_300_phone");
            Intent intent = new Intent(this.ymj, FindMContactAddUI.class);
            intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(this.ymj));
            intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(this.ymj));
            intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(this.ymj));
            intent.putExtra("login_type", 0);
            MMWizardActivity.A(this.ymj, intent);
            return;
        }
        Toast.makeText(this.ymj, this.ymj.getString(R.l.dEP, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }
}
