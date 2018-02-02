package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.modelsimple.b;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a;
import com.tencent.mm.ui.base.h;

class SettingsManageAuthUI$a$1 implements OnClickListener {
    final /* synthetic */ int kI;
    final /* synthetic */ a qjG;

    SettingsManageAuthUI$a$1(a aVar, int i) {
        this.qjG = aVar;
        this.kI = i;
    }

    public final void onClick(View view) {
        if (this.qjG.vT(this.kI) != null) {
            k bVar = new b(this.qjG.vT(this.kI).fFm, 1);
            if (SettingsManageAuthUI.f(this.qjG.qjE) != null) {
                SettingsManageAuthUI.f(this.qjG.qjE).dismiss();
            }
            g.CG().a(bVar, 0);
            SettingsManageAuthUI.a(this.qjG.qjE, h.a(this.qjG.qjE, this.qjG.qjE.getString(R.l.dGB), true, new 1(this, bVar)));
        }
    }
}
