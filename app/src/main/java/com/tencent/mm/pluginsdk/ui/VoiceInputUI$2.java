package com.tencent.mm.pluginsdk.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;

class VoiceInputUI$2 implements OnTouchListener {
    final /* synthetic */ VoiceInputUI vmw;

    VoiceInputUI$2(VoiceInputUI voiceInputUI) {
        this.vmw = voiceInputUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            VoiceInputUI.a(this.vmw);
        } else if (motionEvent.getAction() == 1) {
            VoiceInputFooter b;
            if (VoiceInputUI.b(this.vmw).cav()) {
                b = VoiceInputUI.b(this.vmw);
                b.caw();
                b.setVisibility(8);
            }
            if (VoiceInputUI.b(this.vmw).bCe()) {
                b = VoiceInputUI.b(this.vmw);
                b.hideSmileyPanel();
                b.setVisibility(8);
            }
            b = VoiceInputUI.b(this.vmw);
            b.setVisibility(0);
            if (b.vlH != null) {
                b.vlH.setImageResource(R.g.bBn);
            }
        }
        return false;
    }
}
