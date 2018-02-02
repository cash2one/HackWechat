package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.sns.model.ae;

class SnsHeader$2 implements OnClickListener {
    final /* synthetic */ SnsHeader rBL;
    final /* synthetic */ Context val$context;

    SnsHeader$2(SnsHeader snsHeader, Context context) {
        this.rBL = snsHeader;
        this.val$context = context;
    }

    public final void onClick(View view) {
        af WO = ae.bvj().WO(SnsHeader.e(this.rBL));
        if (WO == null || !(a.fZ(WO.field_type) || SnsHeader.f(this.rBL))) {
            Intent intent = ((Activity) this.val$context).getIntent();
            intent.putExtra("Contact_User", SnsHeader.e(this.rBL));
            com.tencent.mm.plugin.sns.c.a.ifs.d(intent, this.val$context);
            return;
        }
        intent = new Intent();
        intent.putExtra("Contact_User", SnsHeader.e(this.rBL));
        if (SnsHeader.e(this.rBL) != null && SnsHeader.e(this.rBL).length() > 0) {
            com.tencent.mm.plugin.sns.c.a.ifs.d(intent, this.val$context);
        }
    }
}
