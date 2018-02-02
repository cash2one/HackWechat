package com.tencent.mm.ui.friend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.z.ar;

class FindMContactAddUI$8 implements OnClickListener {
    final /* synthetic */ FindMContactAddUI zcv;

    FindMContactAddUI$8(FindMContactAddUI findMContactAddUI) {
        this.zcv = findMContactAddUI;
    }

    public final void onClick(View view) {
        b.oI(ar.CB() + "," + this.zcv.getClass().getName() + ",R300_300_AddAllButton," + ar.fH("R300_300_AddAllButton") + ",3");
        if (FindMContactAddUI.e(this.zcv) == 2) {
            FindMContactAddUI.c(this.zcv).bN(true);
            FindMContactAddUI.c(this.zcv).notifyDataSetChanged();
            FindMContactAddUI.f(this.zcv).setVisibility(8);
            if (FindMContactAddUI.g(this.zcv) != null) {
                FindMContactAddUI.g(this.zcv).setVisibility(0);
            }
        } else if (FindMContactAddUI.e(this.zcv) == 1) {
            FindMContactAddUI.c(this.zcv).bN(true);
            FindMContactAddUI.c(this.zcv).notifyDataSetChanged();
            FindMContactAddUI.i(this.zcv);
        } else {
            FindMContactAddUI.c(this.zcv).bN(true);
            FindMContactAddUI.c(this.zcv).notifyDataSetChanged();
            FindMContactAddUI.f(this.zcv).setVisibility(8);
            if (FindMContactAddUI.g(this.zcv) != null) {
                FindMContactAddUI.g(this.zcv).setVisibility(0);
            }
        }
    }
}
