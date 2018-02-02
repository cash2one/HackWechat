package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.z.ar;

class EmojiStoreDetailUI$5 implements OnCancelListener {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$5(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(EmojiStoreDetailUI.r(this.lDM));
        EmojiStoreDetailUI.s(this.lDM).setText(R.l.eay);
        EmojiStoreDetailUI.t(this.lDM);
    }
}
