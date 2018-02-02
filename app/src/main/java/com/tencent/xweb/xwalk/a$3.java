package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.xweb.k;

class a$3 implements OnClickListener {
    final /* synthetic */ a Asx;
    final /* synthetic */ Button Asy;

    a$3(a aVar, Button button) {
        this.Asx = aVar;
        this.Asy = button;
    }

    public final void onClick(View view) {
        boolean z = !k.cIo().Aqh;
        k.cIo().oa(z);
        this.Asx.a(z, this.Asy, true);
    }
}
