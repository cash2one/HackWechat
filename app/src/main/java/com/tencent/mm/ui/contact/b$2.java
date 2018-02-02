package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.MMActivity;

class b$2 implements OnTouchListener {
    final /* synthetic */ b yQH;

    b$2(b bVar) {
        this.yQH = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (b.a(this.yQH) instanceof MMActivity) {
            ((MMActivity) b.a(this.yQH)).aWs();
        }
        return false;
    }
}
