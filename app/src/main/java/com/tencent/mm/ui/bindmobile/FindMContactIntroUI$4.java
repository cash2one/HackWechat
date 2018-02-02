package com.tencent.mm.ui.bindmobile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class FindMContactIntroUI$4 implements OnClickListener {
    final /* synthetic */ FindMContactIntroUI ymj;

    FindMContactIntroUI$4(FindMContactIntroUI findMContactIntroUI) {
        this.ymj = findMContactIntroUI;
    }

    public final void onClick(View view) {
        h.a(this.ymj, this.ymj.getString(R.l.ehU), null, this.ymj.getString(R.l.ehV), this.ymj.getString(R.l.ehT), new 1(this), new 2(this));
    }
}
