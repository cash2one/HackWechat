package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class a$16 implements OnClickListener {
    final /* synthetic */ String AsA;
    final /* synthetic */ String AsB;
    final /* synthetic */ boolean AsC;
    final /* synthetic */ a Asx;

    a$16(a aVar, String str, String str2, boolean z) {
        this.Asx = aVar;
        this.AsA = str;
        this.AsB = str2;
        this.AsC = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.Asx.x(this.AsA, this.AsB, this.AsC);
    }
}
