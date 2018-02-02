package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class EmojiStoreV2RewardUI$8 implements OnCancelListener {
    final /* synthetic */ EmojiStoreV2RewardUI lGQ;

    EmojiStoreV2RewardUI$8(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.lGQ = emojiStoreV2RewardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(EmojiStoreV2RewardUI.k(this.lGQ));
    }
}
