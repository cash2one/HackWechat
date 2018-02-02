package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class e$10 implements OnClickListener {
    final /* synthetic */ e xTT;

    e$10(e eVar) {
        this.xTT = eVar;
    }

    public final void onClick(View view) {
        h.a(this.xTT.xTM, this.xTT.xTM.getString(R.l.eDX) + this.xTT.hNv, this.xTT.xTM.getString(R.l.eDY), this.xTT.xTM.getString(R.l.dFU), this.xTT.xTM.getString(R.l.dEn), false, new 1(this), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ e$10 xTW;

            {
                this.xTW = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.xTW.xTT.xTM.xTZ.reset();
            }
        });
    }
}
