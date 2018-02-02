package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class SayHiWithSnsPermissionUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ SayHiWithSnsPermissionUI plm;

    SayHiWithSnsPermissionUI$6(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        this.plm = sayHiWithSnsPermissionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Context context;
        if (SayHiWithSnsPermissionUI.d(this.plm)) {
            int i;
            List linkedList = new LinkedList();
            linkedList.add(SayHiWithSnsPermissionUI.e(this.plm));
            List linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(SayHiWithSnsPermissionUI.f(this.plm)));
            String g = SayHiWithSnsPermissionUI.g(this.plm);
            Map hashMap = new HashMap();
            if (SayHiWithSnsPermissionUI.h(this.plm).zvg) {
                i = 1;
            } else {
                i = 0;
            }
            hashMap.put(SayHiWithSnsPermissionUI.e(this.plm), Integer.valueOf(i));
            x.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[]{Integer.valueOf(i)});
            k oVar = new o(2, linkedList, linkedList2, g, "", hashMap, SayHiWithSnsPermissionUI.i(this.plm));
            String stringExtra = this.plm.getIntent().getStringExtra("source_from_user_name");
            String stringExtra2 = this.plm.getIntent().getStringExtra("source_from_nick_name");
            if (!bh.ov(stringExtra)) {
                oVar.fc(stringExtra, stringExtra2);
            }
            ar.CG().a(oVar, 0);
            SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI = this.plm;
            context = this.plm.mController.xIM;
            this.plm.getString(R.l.dGO);
            SayHiWithSnsPermissionUI.a(sayHiWithSnsPermissionUI, h.a(context, this.plm.getString(R.l.eKe), true, new 1(this, oVar)));
        } else if (SayHiWithSnsPermissionUI.j(this.plm)) {
            k oVar2 = new o(SayHiWithSnsPermissionUI.e(this.plm), this.plm.getIntent().getStringExtra("Verify_ticket"), SayHiWithSnsPermissionUI.f(this.plm));
            ar.CG().a(oVar2, 0);
            SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI2 = this.plm;
            context = this.plm.mController.xIM;
            this.plm.getString(R.l.dGO);
            SayHiWithSnsPermissionUI.a(sayHiWithSnsPermissionUI2, h.a(context, this.plm.getString(R.l.dUN), true, new 2(this, oVar2)));
        }
        return false;
    }
}
