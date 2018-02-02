package com.tencent.mm.ui.friend;

import com.tencent.mm.R;
import com.tencent.mm.modelfriend.j$a;

class FindMContactAddUI$7 implements j$a {
    final /* synthetic */ FindMContactAddUI zcv;

    FindMContactAddUI$7(FindMContactAddUI findMContactAddUI) {
        this.zcv = findMContactAddUI;
    }

    public final void notifyDataSetChanged() {
        if (FindMContactAddUI.e(this.zcv) == 2 || FindMContactAddUI.e(this.zcv) != 1) {
            FindMContactAddUI.f(this.zcv).setText(this.zcv.getString(R.l.ehE, new Object[]{Integer.valueOf(FindMContactAddUI.c(this.zcv).getCount())}));
        } else {
            FindMContactAddUI.f(this.zcv).setText(this.zcv.getString(R.l.ehF));
        }
        if (FindMContactAddUI.c(this.zcv).NI()) {
            if (!(FindMContactAddUI.e(this.zcv) == 1 || FindMContactAddUI.f(this.zcv).getVisibility() != 0 || FindMContactAddUI.g(this.zcv) == null)) {
                FindMContactAddUI.f(this.zcv).setVisibility(8);
                FindMContactAddUI.g(this.zcv).setVisibility(0);
            }
        } else if (!(FindMContactAddUI.e(this.zcv) == 1 || FindMContactAddUI.f(this.zcv).getVisibility() != 8 || FindMContactAddUI.g(this.zcv) == null)) {
            FindMContactAddUI.f(this.zcv).setVisibility(0);
            FindMContactAddUI.g(this.zcv).setVisibility(8);
        }
        if (FindMContactAddUI.c(this.zcv).NH() <= 0 || FindMContactAddUI.e(this.zcv) == 1) {
            FindMContactAddUI.h(this.zcv).setText(this.zcv.getResources().getQuantityString(R.j.dus, FindMContactAddUI.c(this.zcv).getCount(), new Object[]{Integer.valueOf(FindMContactAddUI.c(this.zcv).getCount())}));
            return;
        }
        FindMContactAddUI.h(this.zcv).setText(this.zcv.getResources().getQuantityString(R.j.dup, FindMContactAddUI.c(this.zcv).NH(), new Object[]{Integer.valueOf(FindMContactAddUI.c(this.zcv).NH())}));
    }
}
