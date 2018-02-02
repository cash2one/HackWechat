package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b mkI;

    b$1(b bVar) {
        this.mkI = bVar;
    }

    public final void onClick(View view) {
        if (this.mkI.mkH != null) {
            this.mkI.mkH.onCancel();
        }
        this.mkI.dismiss();
    }
}
