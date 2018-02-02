package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.LinkedList;
import java.util.List;

class SayHiEditUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ String hpU;
    final /* synthetic */ int yUc;
    final /* synthetic */ String yUd;
    final /* synthetic */ SayHiEditUI yUe;

    SayHiEditUI$1(SayHiEditUI sayHiEditUI, String str, int i, String str2) {
        this.yUe = sayHiEditUI;
        this.hpU = str;
        this.yUc = i;
        this.yUd = str2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yUe.aWs();
        d.oSu.T(2, 1, 3);
        List linkedList = new LinkedList();
        linkedList.add(this.hpU);
        List linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(this.yUc));
        List linkedList3 = new LinkedList();
        if (!t.ov(this.yUd)) {
            linkedList3.add(this.yUd);
        }
        final k oVar = new o(2, linkedList, linkedList2, linkedList3, SayHiEditUI.a(this.yUe), "", null, null, "");
        ar.CG().a(oVar, 0);
        SayHiEditUI sayHiEditUI = this.yUe;
        Context context = this.yUe.mController.xIM;
        this.yUe.getString(R.l.dGO);
        SayHiEditUI.a(sayHiEditUI, h.a(context, this.yUe.getString(R.l.eKe), true, new OnCancelListener(this) {
            final /* synthetic */ SayHiEditUI$1 yUf;

            public final void onCancel(DialogInterface dialogInterface) {
                ar.CG().c(oVar);
            }
        }));
        return false;
    }
}
