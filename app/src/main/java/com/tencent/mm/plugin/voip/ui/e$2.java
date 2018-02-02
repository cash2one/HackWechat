package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

class e$2 implements OnClickListener {
    final /* synthetic */ e srL;

    e$2(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        e.a(this.srL, !e.h(this.srL));
        if (!e.h(this.srL)) {
            e.i(this.srL).setVisibility(8);
        }
        Toast.makeText(this.srL.getActivity(), String.format("mIsShowFaceRect:%b", new Object[]{Boolean.valueOf(e.h(this.srL))}), 0).show();
    }
}
