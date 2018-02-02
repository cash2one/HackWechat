package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.e.2;
import com.tencent.mm.plugin.profile.ui.e.3;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

class e$1 implements OnClickListener {
    final /* synthetic */ e pje;

    e$1(e eVar) {
        this.pje = eVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e eVar = this.pje;
        eVar.isDeleteCancel = false;
        Context context = eVar.context;
        eVar.context.getString(R.l.dGO);
        eVar.tipDialog = h.a(context, eVar.context.getString(R.l.dHc), true, new 2(eVar));
        ba.a("fmessage", new 3(eVar));
        ar.Hg();
        c.Fd().WX("fmessage");
    }
}
