package com.tencent.mm.ui.bindmobile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class FindMContactLearmMoreUI$2 implements OnClickListener {
    final /* synthetic */ FindMContactLearmMoreUI ymn;

    FindMContactLearmMoreUI$2(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        this.ymn = findMContactLearmMoreUI;
    }

    public final void onClick(View view) {
        ar.Hg();
        c.CU().set(12322, Boolean.valueOf(false));
        m.k(false, false);
        FindMContactLearmMoreUI.b(this.ymn);
    }
}
