package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.bh;

class e$3 implements OnClickListener {
    final /* synthetic */ e srL;

    e$3(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        boolean a = bh.a((Boolean) view.getTag(), false);
        view.setTag(Boolean.valueOf(!a));
        if (a) {
            e.i(this.srL).setVisibility(8);
            Toast.makeText(this.srL.getActivity(), "stop face detect", 0).show();
        } else {
            Toast.makeText(this.srL.getActivity(), "start face detect", 0).show();
        }
        if (this.srL.spN != null && this.srL.spN.get() != null) {
            ((c) this.srL.spN.get()).bHf();
        }
    }
}
