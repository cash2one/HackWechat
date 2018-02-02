package com.tencent.mm.plugin.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements OnTouchListener {
    final /* synthetic */ e pVm;

    e$1(e eVar) {
        this.pVm = eVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            x.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
            e.a(this.pVm).setVisibility(4);
            e.b(this.pVm).setMaxLines(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
            this.pVm.pVh = true;
            if (e.c(this.pVm) != null) {
                e.c(this.pVm).a(this.pVm.ibD, Boolean.valueOf(true));
                e.c(this.pVm).bpf();
            }
        }
        return false;
    }
}
