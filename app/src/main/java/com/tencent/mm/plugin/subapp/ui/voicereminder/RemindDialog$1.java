package com.tencent.mm.plugin.subapp.ui.voicereminder;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.d;

class RemindDialog$1 implements d {
    final /* synthetic */ RemindDialog rYR;

    RemindDialog$1(RemindDialog remindDialog) {
        this.rYR = remindDialog;
    }

    public final void m(String str, long j) {
        x.d("MicroMsg.RemindDialog", "onVoiceRemind " + str);
        RemindDialog.a(this.rYR).add(str);
        RemindDialog.b(this.rYR);
    }
}
