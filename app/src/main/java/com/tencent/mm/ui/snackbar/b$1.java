package com.tencent.mm.ui.snackbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class b$1 implements OnTouchListener {
    final /* synthetic */ b zfI;

    b$1(b bVar) {
        this.zfI = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (a.aHh() && this.zfI.zfE.isShowing()) {
            a.nm(false);
            this.zfI.mHandler.postDelayed(new 1(this), 100);
        }
        return true;
    }
}
