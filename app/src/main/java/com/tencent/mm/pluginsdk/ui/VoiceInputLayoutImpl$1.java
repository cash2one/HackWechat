package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputLayoutImpl$1 implements OnLongClickListener {
    final /* synthetic */ VoiceInputLayoutImpl vmk;

    VoiceInputLayoutImpl$1(VoiceInputLayoutImpl voiceInputLayoutImpl) {
        this.vmk = voiceInputLayoutImpl;
    }

    public final boolean onLongClick(View view) {
        x.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", Integer.valueOf(this.vmk.vlD));
        VoiceInputLayoutImpl.a(this.vmk, true);
        VoiceInputLayoutImpl.a(this.vmk).caq();
        return true;
    }
}
