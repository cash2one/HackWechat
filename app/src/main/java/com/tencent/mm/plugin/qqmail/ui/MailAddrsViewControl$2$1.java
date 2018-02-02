package com.tencent.mm.plugin.qqmail.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.2;

class MailAddrsViewControl$2$1 implements OnTouchListener {
    final /* synthetic */ 2 pte;

    MailAddrsViewControl$2$1(2 2) {
        this.pte = 2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!(MailAddrsViewControl.c(this.pte.ptc) == null || MailAddrsViewControl.c(this.pte.ptc) == view || !MailAddrsViewControl.c(this.pte.ptc).isSelected())) {
            MailAddrsViewControl.c(this.pte.ptc).setSelected(false);
            MailAddrsViewControl.a(this.pte.ptc, null);
        }
        MailAddrsViewControl.a(this.pte.ptc, view);
        if (this.pte.ptc.psV != null && motionEvent.getAction() == 0) {
            this.pte.ptd.setSelected(!this.pte.ptd.isSelected());
            this.pte.ptc.psV.setVisibility(0);
            this.pte.ptc.psV.requestFocus();
            ((InputMethodManager) this.pte.ptc.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
        }
        return MailAddrsViewControl.d(this.pte.ptc).onTouchEvent(motionEvent);
    }
}
