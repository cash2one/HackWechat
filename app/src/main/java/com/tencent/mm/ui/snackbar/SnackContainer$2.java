package com.tencent.mm.ui.snackbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.snackbar.SnackContainer.a;

class SnackContainer$2 implements OnTouchListener {
    final /* synthetic */ SnackContainer zfQ;
    final /* synthetic */ a zfR;

    SnackContainer$2(SnackContainer snackContainer, a aVar) {
        this.zfQ = snackContainer;
        this.zfR = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 4:
                this.zfQ.removeCallbacks(SnackContainer.b(this.zfQ));
                SnackContainer.b(this.zfR);
                this.zfQ.startAnimation(SnackContainer.c(this.zfQ));
                if (!SnackContainer.a(this.zfQ).isEmpty()) {
                    SnackContainer.a(this.zfQ).clear();
                    break;
                }
                break;
        }
        SnackContainer.a(this.zfQ, y);
        return true;
    }
}
