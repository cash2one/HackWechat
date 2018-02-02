package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.j;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;

class NormalUserFooterPreference$j$2 implements OnClickListener {
    final /* synthetic */ j pkU;

    NormalUserFooterPreference$j$2(j jVar) {
        this.pkU = jVar;
    }

    public final void onClick(View view) {
        if (NormalUserFooterPreference.a(this.pkU.pkA).AF()) {
            s.i(NormalUserFooterPreference.a(this.pkU.pkA));
            NormalUserFooterPreference.a(this.pkU.pkA).Aj();
            this.pkU.bjD();
            return;
        }
        h.a(this.pkU.pkA.mContext, this.pkU.pkA.mContext.getString(R.l.dVI), this.pkU.pkA.mContext.getString(R.l.dVH), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ NormalUserFooterPreference$j$2 pkV;

            {
                this.pkV = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                s.h(NormalUserFooterPreference.a(this.pkV.pkU.pkA));
                NormalUserFooterPreference.a(this.pkV.pkU.pkA).Ai();
                this.pkV.pkU.bjD();
            }
        }, null);
    }
}
