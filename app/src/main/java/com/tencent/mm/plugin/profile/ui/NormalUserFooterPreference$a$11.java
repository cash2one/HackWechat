package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.ui.widget.g;

class NormalUserFooterPreference$a$11 implements OnMenuItemClickListener {
    final /* synthetic */ a pkC;
    final /* synthetic */ boolean pkH;
    final /* synthetic */ boolean pkI;

    NormalUserFooterPreference$a$11(a aVar, boolean z, boolean z2) {
        this.pkC = aVar;
        this.pkH = z;
        this.pkI = z2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.pkC.pkA.fmM, g.ztp, false);
        gVar.rKD = new 1(this);
        gVar.rKC = new 2(this);
        gVar.bUk();
        return true;
    }
}
