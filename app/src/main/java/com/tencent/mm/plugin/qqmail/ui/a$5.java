package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.qqmail.b.n;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class a$5 implements OnClickListener {
    final /* synthetic */ boolean mrh;
    final /* synthetic */ a prY;
    final /* synthetic */ EditText psa;

    a$5(a aVar, boolean z, EditText editText) {
        this.prY = aVar;
        this.mrh = z;
        this.psa = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        k nVar = new n(this.mrh, g.s(this.psa.getText().toString().trim().getBytes()));
        ar.CG().a(nVar, 0);
        a aVar = this.prY;
        Context a = a.a(this.prY);
        a.a(this.prY).getString(R.l.dVS);
        a.a(aVar, h.a(a, a.a(this.prY).getString(R.l.dHc), true, new 1(this, nVar)));
    }
}
