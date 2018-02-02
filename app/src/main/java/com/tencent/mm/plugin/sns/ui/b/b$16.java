package com.tencent.mm.plugin.sns.ui.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class b$16 implements OnTouchListener {
    final /* synthetic */ b rPY;

    b$16(b bVar) {
        this.rPY = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        x.d("MicroMsg.TimelineClickListener", "v " + view.getId() + "  ");
        this.rPY.cD(view);
        return false;
    }
}
