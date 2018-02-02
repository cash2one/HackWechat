package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2RewardUI$2 implements OnClickListener {
    final /* synthetic */ EmojiStoreV2RewardUI lGQ;

    EmojiStoreV2RewardUI$2(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.lGQ = emojiStoreV2RewardUI;
    }

    public final void onClick(View view) {
        if (EmojiStoreV2RewardUI.d(this.lGQ) != null) {
            sm oT = EmojiStoreV2RewardUI.d(this.lGQ).oT(0);
            if (EmojiStoreV2RewardUI.e(this.lGQ).getText() != null) {
                oT.waO = EmojiStoreV2RewardUI.e(this.lGQ).getText().toString();
                EmojiStoreV2RewardUI.a(this.lGQ, EmojiStoreV2RewardUI.f(this.lGQ), oT);
                return;
            }
            x.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
            return;
        }
        x.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
    }
}
