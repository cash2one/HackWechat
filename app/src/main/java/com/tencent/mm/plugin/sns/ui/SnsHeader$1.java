package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class SnsHeader$1 implements OnClickListener {
    final /* synthetic */ SnsHeader rBL;
    final /* synthetic */ Context val$context;

    SnsHeader$1(SnsHeader snsHeader, Context context) {
        this.rBL = snsHeader;
        this.val$context = context;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.SnsHeader", "change backGround");
        if (SnsHeader.a(this.rBL) == null || !SnsHeader.a(this.rBL).isShowing()) {
            String d;
            if (SnsHeader.b(this.rBL) != null) {
                SnsHeader.b(this.rBL).bAV();
            }
            if (SnsHeader.c(this.rBL) == 1) {
                d = SnsHeader.d(this.rBL);
            } else {
                d = SnsHeader.e(this.rBL);
            }
            k Lq = ae.bvz().Lq(d);
            long j = Lq.field_snsBgId;
            if (SnsHeader.f(this.rBL) || j != 0) {
                String[] strArr;
                SnsHeader.a(this.rBL, Lq.byf());
                if (SnsHeader.c(this.rBL) == 1 || SnsHeader.d(this.rBL).trim().equals(SnsHeader.e(this.rBL).trim())) {
                    strArr = new String[]{this.val$context.getString(j.qME)};
                    SnsHeader.a(this.rBL, false);
                } else {
                    strArr = SnsHeader.g(this.rBL) ? new String[0] : new String[]{this.val$context.getString(j.qLB)};
                }
                String string = SnsHeader.g(this.rBL) ? this.val$context.getString(j.qMe) : "";
                if (SnsHeader.g(this.rBL)) {
                    this.val$context.getString(j.dFU);
                } else {
                    this.val$context.getString(j.dEn);
                }
                SnsHeader.a(this.rBL, h.a(this.rBL.getContext(), string, strArr, new 1(this, j)));
            }
        }
    }
}
