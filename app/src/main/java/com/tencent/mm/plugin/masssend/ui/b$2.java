package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b onk;

    b$2(b bVar) {
        this.onk = bVar;
    }

    public final void onError() {
        this.onk.onf.reset();
        this.onk.kEu.TG();
        this.onk.kEv.TG();
        ae.Vd("keep_app_silent");
        this.onk.one.aJO();
        x.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
        Toast.makeText(this.onk.ond, this.onk.ond.getString(R.l.dSD), 0).show();
    }
}
