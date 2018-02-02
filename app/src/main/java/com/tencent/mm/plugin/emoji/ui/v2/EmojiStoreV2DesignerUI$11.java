package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.ui.v2.d.a;
import com.tencent.mm.protocal.c.rw;

class EmojiStoreV2DesignerUI$11 implements a {
    final /* synthetic */ EmojiStoreV2DesignerUI lFV;

    EmojiStoreV2DesignerUI$11(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.lFV = emojiStoreV2DesignerUI;
    }

    public final void mv(int i) {
        if (EmojiStoreV2DesignerUI.f(this.lFV) != null && EmojiStoreV2DesignerUI.g(this.lFV) != null) {
            rw oZ = EmojiStoreV2DesignerUI.g(this.lFV).oZ(i);
            if (oZ != null) {
                try {
                    Intent intent = new Intent();
                    intent.putExtra("extra_object", oZ.toByteArray());
                    intent.setClass(this.lFV.mController.xIM, EmojiStoreV2SingleProductDialogUI.class);
                    this.lFV.startActivity(intent);
                    this.lFV.overridePendingTransition(R.a.bqk, R.a.bql);
                } catch (Exception e) {
                }
            }
        }
    }
}
