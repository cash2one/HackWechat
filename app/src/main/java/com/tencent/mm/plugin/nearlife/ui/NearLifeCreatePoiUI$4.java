package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

class NearLifeCreatePoiUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ NearLifeCreatePoiUI oRe;

    NearLifeCreatePoiUI$4(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.oRe = nearLifeCreatePoiUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g.pQN.h(11138, new Object[]{"2", "0", NearLifeCreatePoiUI.b(this.oRe)});
        NearLifeCreatePoiUI nearLifeCreatePoiUI = this.oRe;
        Context context = this.oRe.mController.xIM;
        this.oRe.getString(R.l.exW);
        NearLifeCreatePoiUI.a(nearLifeCreatePoiUI, h.a(context, this.oRe.getString(R.l.exX), true, new OnCancelListener(this) {
            final /* synthetic */ NearLifeCreatePoiUI$4 oRf;

            {
                this.oRf = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ar.CG().c(NearLifeCreatePoiUI.c(this.oRf.oRe));
            }
        }));
        NearLifeCreatePoiUI.a(this.oRe, NearLifeCreatePoiUI.d(this.oRe).getText().toString());
        NearLifeCreatePoiUI.b(this.oRe, NearLifeCreatePoiUI.e(this.oRe).getText().toString());
        NearLifeCreatePoiUI.c(this.oRe, NearLifeCreatePoiUI.f(this.oRe).getText().toString());
        String obj = ((EditText) this.oRe.findViewById(R.h.ceQ)).getText().toString();
        LinkedList g = NearLifeCreatePoiUI.g(this.oRe);
        NearLifeCreatePoiUI.a(this.oRe, new b(NearLifeCreatePoiUI.h(this.oRe), NearLifeCreatePoiUI.i(this.oRe), NearLifeCreatePoiUI.j(this.oRe), NearLifeCreatePoiUI.k(this.oRe), g.size(), g, obj));
        ar.CG().a(NearLifeCreatePoiUI.c(this.oRe), 0);
        x.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
        return true;
    }
}
