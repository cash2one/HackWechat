package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.oq;

public final class z extends i {
    private View kXj;

    public final void initView() {
    }

    public final void update() {
        if (this.kXj == null) {
            this.kXj = ((ViewStub) findViewById(R.h.bSi)).inflate();
        }
        oq oqVar = this.kWz.avI().atC().vRj;
        if (this.kXj != null) {
            ((TextView) this.kXj.findViewById(R.h.cQM)).setText(oqVar.title);
            ((TextView) this.kXj.findViewById(R.h.cQL)).setText(oqVar.kJQ);
            int i = (this.kWz.avN().awp() && this.kWz.avN().awq()) ? 0 : 1;
            if (i != 0) {
                ((LayoutParams) ((LinearLayout) this.kXj).getLayoutParams()).bottomMargin = 0;
            } else {
                ((LayoutParams) ((LinearLayout) this.kXj).getLayoutParams()).bottomMargin = this.kWz.avL().getResources().getDimensionPixelSize(R.f.bvP);
            }
        }
    }

    public final void awW() {
        if (this.kXj != null) {
            this.kXj.setVisibility(8);
        }
    }
}
