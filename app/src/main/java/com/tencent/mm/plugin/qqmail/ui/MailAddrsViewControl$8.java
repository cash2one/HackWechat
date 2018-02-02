package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.plugin.qqmail.b.i;

class MailAddrsViewControl$8 extends SimpleOnGestureListener {
    final /* synthetic */ MailAddrsViewControl ptc;

    MailAddrsViewControl$8(MailAddrsViewControl mailAddrsViewControl) {
        this.ptc = mailAddrsViewControl;
    }

    private void blb() {
        i iVar = (i) MailAddrsViewControl.c(this.ptc).getTag();
        if (MailAddrsViewControl.g(this.ptc) != null) {
            MailAddrsViewControl.g(this.ptc);
            MailAddrsViewControl.c(this.ptc);
        }
        Intent intent = new Intent(this.ptc.getContext(), MailAddrProfileUI.class);
        intent.putExtra("name", iVar.name);
        intent.putExtra("addr", iVar.nQt);
        intent.putExtra("can_compose", !MailAddrsViewControl.h(this.ptc));
        this.ptc.getContext().startActivity(intent);
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (!MailAddrsViewControl.h(this.ptc)) {
            blb();
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (MailAddrsViewControl.g(this.ptc) != null && MailAddrsViewControl.c(this.ptc) != null) {
            MailAddrsViewControl.g(this.ptc);
            MailAddrsViewControl.c(this.ptc);
            MailAddrsViewControl.c(this.ptc).getTag();
        }
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        blb();
        return true;
    }
}
