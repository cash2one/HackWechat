package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ag.d;
import com.tencent.mm.storage.x;

class b$1 implements OnClickListener {
    final /* synthetic */ Activity icz;
    final /* synthetic */ x laS;
    final /* synthetic */ d zgS;
    final /* synthetic */ boolean zgT;
    final /* synthetic */ int zgU;
    final /* synthetic */ Runnable zgV;

    b$1(d dVar, Activity activity, x xVar, boolean z, int i, Runnable runnable) {
        this.zgS = dVar;
        this.icz = activity;
        this.laS = xVar;
        this.zgT = z;
        this.zgU = i;
        this.zgV = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(this.zgS, this.icz, this.laS, this.zgT, this.zgU);
        if (this.zgV != null) {
            this.zgV.run();
        }
    }
}
