package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class d$2 implements OnClickListener {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ boolean mfL;
    final /* synthetic */ Bundle mfM;
    final /* synthetic */ d mfO;

    d$2(d dVar, boolean z, int i, int i2, String str, Bundle bundle) {
        this.mfO = dVar;
        this.mfL = z;
        this.fma = i;
        this.fmb = i2;
        this.hnj = str;
        this.mfM = bundle;
    }

    public final void onClick(View view) {
        if (this.mfL) {
            d dVar = this.mfO;
            dVar.aGl();
            dVar.liZ = true;
            return;
        }
        this.mfO.b(this.fma, this.fmb, this.hnj, this.mfM);
    }
}
