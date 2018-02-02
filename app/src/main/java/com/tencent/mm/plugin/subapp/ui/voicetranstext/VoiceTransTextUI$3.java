package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class VoiceTransTextUI$3 implements OnTouchListener {
    final /* synthetic */ VoiceTransTextUI rZw;

    VoiceTransTextUI$3(VoiceTransTextUI voiceTransTextUI) {
        this.rZw = voiceTransTextUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                VoiceTransTextUI.c(this.rZw);
                VoiceTransTextUI.a(this.rZw, view.getScrollY());
                VoiceTransTextUI.b(this.rZw, VoiceTransTextUI.d(this.rZw));
                VoiceTransTextUI.e(this.rZw).removeMessages(0);
                if (VoiceTransTextUI.f(this.rZw)) {
                    VoiceTransTextUI.g(this.rZw);
                    VoiceTransTextUI.a(this.rZw, true);
                    break;
                }
                break;
            case 1:
            case 3:
            case 4:
                if (Math.abs(VoiceTransTextUI.h(this.rZw) - view.getScrollY()) > VoiceTransTextUI.i(this.rZw)) {
                    VoiceTransTextUI.e(this.rZw).sendMessage(VoiceTransTextUI.e(this.rZw).obtainMessage(0, view));
                }
                if (VoiceTransTextUI.j(this.rZw) < 800 && Math.abs(VoiceTransTextUI.h(this.rZw) - view.getScrollY()) <= VoiceTransTextUI.i(this.rZw) && !VoiceTransTextUI.k(this.rZw)) {
                    VoiceTransTextUI.e(this.rZw).removeMessages(0);
                    VoiceTransTextUI.l(this.rZw);
                    this.rZw.finish();
                }
                VoiceTransTextUI.a(this.rZw, false);
                break;
        }
        return false;
    }
}
