package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.oq;

public final class c extends a {
    protected TextView kYg;
    protected TextView kYh;

    public c(Context context) {
        super(context);
    }

    protected final void axn() {
        this.kYh = (TextView) axm().findViewById(R.h.bPG);
        this.kYg = (TextView) axm().findViewById(R.h.bSf);
    }

    protected final void axo() {
        if (this.kIK.atB().vRI != null && this.kIK.atB().vRI.size() > 0) {
            oq oqVar = (oq) this.kIK.atB().vRI.get(0);
            if (this.kXX != null) {
                this.kXX.setText(oqVar.title);
            }
            if (this.kYg != null) {
                if (TextUtils.isEmpty(oqVar.kJQ)) {
                    this.kYg.setVisibility(8);
                } else {
                    this.kYg.setText(oqVar.kJQ);
                }
            }
            if (this.kYh == null) {
                return;
            }
            if (TextUtils.isEmpty(oqVar.kJR)) {
                this.kYh.setVisibility(8);
            } else {
                this.kYh.setText(oqVar.kJR);
            }
        }
    }

    public final void r(boolean z, boolean z2) {
    }
}
