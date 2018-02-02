package com.tencent.mm.ui.snackbar;

import android.view.View;
import android.view.View.OnClickListener;

class b$2 implements OnClickListener {
    final /* synthetic */ b zfI;

    b$2(b bVar) {
        this.zfI = bVar;
    }

    public final void onClick(View view) {
        if (this.zfI.zfF != null && this.zfI.zfE.isShowing()) {
            this.zfI.zfF.aPO();
        }
        this.zfI.mHandler.postDelayed(new 1(this), 100);
    }
}
