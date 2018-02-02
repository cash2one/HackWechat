package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.q;

public final class a extends d {
    public a(Context context, String str, String str2, com.tencent.mm.plugin.base.stub.d.a aVar) {
        super(context, str, str2, aVar);
    }

    protected final void Wb() {
        h.a(this.context, R.l.emP, R.l.dGO, false, new OnClickListener(this) {
            final /* synthetic */ a kuJ;

            {
                this.kuJ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                j jVar = com.tencent.mm.pluginsdk.q.a.vcu;
                if (jVar != null) {
                    jVar.M(this.kuJ.openId, q.FV(), this.kuJ.appId);
                }
                this.kuJ.kuN.dP(false);
            }
        });
    }
}
