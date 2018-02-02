package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.sns.i.f;

class a$2 implements OnLongClickListener {
    final /* synthetic */ View rML;
    final /* synthetic */ a rNC;

    a$2(a aVar, View view) {
        this.rNC = aVar;
        this.rML = view;
    }

    public final boolean onLongClick(View view) {
        int[] iArr;
        int[] iArr2 = new int[2];
        if (view.getTag(f.cSF) instanceof int[]) {
            iArr = (int[]) view.getTag(f.cSF);
        } else {
            iArr = iArr2;
        }
        this.rNC.qZU.kGt.a(this.rML, this.rNC.qZU.qZo.rPC, this.rNC.qZU.qZo.rPp, iArr[0], iArr[1]);
        return true;
    }
}
