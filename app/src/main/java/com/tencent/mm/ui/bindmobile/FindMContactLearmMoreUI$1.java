package com.tencent.mm.ui.bindmobile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class FindMContactLearmMoreUI$1 implements OnClickListener {
    final /* synthetic */ FindMContactLearmMoreUI ymn;

    FindMContactLearmMoreUI$1(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        this.ymn = findMContactLearmMoreUI;
    }

    public final void onClick(View view) {
        ar.Hg();
        c.CU().set(12322, Boolean.valueOf(true));
        m.k(true, false);
        FindMContactLearmMoreUI.a(this.ymn);
    }
}
