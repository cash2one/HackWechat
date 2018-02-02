package com.tencent.mm.plugin.subapp.ui.voicetranstext;

class VoiceTransTextUI$7 implements Runnable {
    final /* synthetic */ VoiceTransTextUI rZw;
    final /* synthetic */ boolean rZz;

    VoiceTransTextUI$7(VoiceTransTextUI voiceTransTextUI, boolean z) {
        this.rZw = voiceTransTextUI;
        this.rZz = z;
    }

    public final void run() {
        if (VoiceTransTextUI.r(this.rZw).getMeasuredHeight() >= VoiceTransTextUI.s(this.rZw).getMeasuredHeight()) {
            VoiceTransTextUI.r(this.rZw).fullScroll(130);
            int scrollY = VoiceTransTextUI.r(this.rZw).getScrollY();
            VoiceTransTextUI.d(this.rZw, VoiceTransTextUI.r(this.rZw).getPaddingTop());
            VoiceTransTextUI.d(this.rZw, VoiceTransTextUI.t(this.rZw) - scrollY);
            if (this.rZz) {
                VoiceTransTextUI.r(this.rZw).setPadding(0, 0, 0, 0);
                VoiceTransTextUI.u(this.rZw).setVisibility(8);
                VoiceTransTextUI.u(this.rZw).setHeight(0);
            } else if (VoiceTransTextUI.t(this.rZw) > 0) {
                VoiceTransTextUI.r(this.rZw).setPadding(0, VoiceTransTextUI.t(this.rZw), 0, 0);
            }
        }
    }
}
