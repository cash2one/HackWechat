package com.tencent.mm.pluginsdk.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputLayoutImpl$2 implements OnTouchListener {
    final /* synthetic */ VoiceInputLayoutImpl vmk;

    VoiceInputLayoutImpl$2(VoiceInputLayoutImpl voiceInputLayoutImpl) {
        this.vmk = voiceInputLayoutImpl;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                VoiceInputLayoutImpl.a(this.vmk, false);
                VoiceInputLayoutImpl.a(this.vmk, bh.Wq());
                x.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(this.vmk.vlD), Long.valueOf(VoiceInputLayoutImpl.b(this.vmk)));
                VoiceInputLayoutImpl.a(this.vmk).cas();
                this.vmk.O(false, false);
                break;
            case 1:
                x.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(this.vmk.vlD), Boolean.valueOf(VoiceInputLayoutImpl.c(this.vmk)));
                if (!VoiceInputLayoutImpl.c(this.vmk)) {
                    this.vmk.O(false, true);
                    break;
                }
                this.vmk.O(true, false);
                VoiceInputLayoutImpl.a(this.vmk, false);
                VoiceInputLayoutImpl.a(this.vmk, 0);
                break;
        }
        return false;
    }
}
