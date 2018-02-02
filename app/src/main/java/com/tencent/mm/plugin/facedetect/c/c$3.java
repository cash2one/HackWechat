package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class c$3 implements OnClickListener {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ c mfK;
    final /* synthetic */ Bundle mfM;

    c$3(c cVar, int i, int i2, String str, Bundle bundle) {
        this.mfK = cVar;
        this.fma = i;
        this.fmb = i2;
        this.hnj = str;
        this.mfM = bundle;
    }

    public final void onClick(View view) {
        this.mfK.b(this.fma, this.fmb, this.hnj, this.mfM);
    }
}
