package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class EmojiStoreV2DesignerUI$7 implements OnCancelListener {
    final /* synthetic */ EmojiStoreV2DesignerUI lFV;

    EmojiStoreV2DesignerUI$7(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.lFV = emojiStoreV2DesignerUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (EmojiStoreV2DesignerUI.o(this.lFV) != null) {
            ar.CG().c(EmojiStoreV2DesignerUI.o(this.lFV));
        }
    }
}
