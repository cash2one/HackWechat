package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class c$2 implements OnClickListener {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ c mfK;
    final /* synthetic */ boolean mfL;
    final /* synthetic */ Bundle mfM;

    c$2(c cVar, boolean z, int i, int i2, String str, Bundle bundle) {
        this.mfK = cVar;
        this.mfL = z;
        this.fma = i;
        this.fmb = i2;
        this.hnj = str;
        this.mfM = bundle;
    }

    public final void onClick(View view) {
        if (this.mfL) {
            c cVar = this.mfK;
            cVar.aGl();
            cVar.liZ = true;
            return;
        }
        this.mfK.b(this.fma, this.fmb, this.hnj, this.mfM);
    }
}
