package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import com.tencent.mm.R;
import com.tencent.mm.ui.snackbar.a;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.ui.snackbar.b.c;

class c$5 implements OnClickListener {
    final /* synthetic */ Activity oZ;
    final /* synthetic */ Fragment qS;
    final /* synthetic */ OnClickListener vdj;
    final /* synthetic */ b vdk;
    final /* synthetic */ c vdl;

    c$5(OnClickListener onClickListener, Fragment fragment, b bVar, c cVar, Activity activity) {
        this.vdj = onClickListener;
        this.qS = fragment;
        this.vdk = bVar;
        this.vdl = cVar;
        this.oZ = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.vdj != null) {
            this.vdj.onClick(dialogInterface, -2);
        }
        if (this.qS != null) {
            a.a(0, this.qS, this.qS.getActivity().getString(R.l.efV), this.qS.getActivity().getString(R.l.eeF), this.vdk, this.vdl);
        } else {
            a.a(0, this.oZ, this.oZ.getString(R.l.efV), this.oZ.getString(R.l.eeF), this.vdk, this.vdl);
        }
    }
}
