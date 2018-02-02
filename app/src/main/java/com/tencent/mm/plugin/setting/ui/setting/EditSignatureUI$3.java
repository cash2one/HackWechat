package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.k.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.q;

class EditSignatureUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ EditSignatureUI qgS;

    EditSignatureUI$3(EditSignatureUI editSignatureUI) {
        this.qgS = editSignatureUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String trim = EditSignatureUI.a(this.qgS).getText().toString().trim();
        String zI = b.zI();
        if (bh.ov(zI) || !trim.matches(".*[" + zI + "].*")) {
            EditSignatureUI editSignatureUI = this.qgS;
            Context context = this.qgS.mController.xIM;
            this.qgS.getString(R.l.dGO);
            EditSignatureUI.a(editSignatureUI, h.a(context, this.qgS.getString(R.l.dUD), false, null));
            EditSignatureUI.a(this.qgS, q.q(18, trim));
            EditSignatureUI.f(this.qgS);
            this.qgS.aWs();
            return true;
        }
        h.b(this.qgS.mController.xIM, this.qgS.getString(R.l.epE, new Object[]{zI}), this.qgS.getString(R.l.dGO), true);
        return false;
    }
}
