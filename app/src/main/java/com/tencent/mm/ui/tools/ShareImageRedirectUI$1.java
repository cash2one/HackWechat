package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.mm.R;

class ShareImageRedirectUI$1 implements OnTouchListener {
    final /* synthetic */ ShareImageRedirectUI zmH;

    ShareImageRedirectUI$1(ShareImageRedirectUI shareImageRedirectUI) {
        this.zmH = shareImageRedirectUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Toast.makeText(this.zmH, R.l.ePq, 1).show();
        this.zmH.finish();
        return false;
    }
}
