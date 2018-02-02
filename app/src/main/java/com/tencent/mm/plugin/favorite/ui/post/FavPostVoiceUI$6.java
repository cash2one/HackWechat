package com.tencent.mm.plugin.favorite.ui.post;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;

class FavPostVoiceUI$6 extends af {
    final /* synthetic */ FavPostVoiceUI myN;

    FavPostVoiceUI$6(FavPostVoiceUI favPostVoiceUI) {
        this.myN = favPostVoiceUI;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        this.myN.aJO();
        FavPostVoiceUI.g(this.myN).setBackgroundResource(R.g.bFh);
        FavPostVoiceUI.g(this.myN).setEnabled(true);
    }
}
