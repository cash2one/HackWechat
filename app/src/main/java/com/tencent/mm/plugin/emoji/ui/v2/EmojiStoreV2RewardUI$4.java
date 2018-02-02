package com.tencent.mm.plugin.emoji.ui.v2;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.R;

class EmojiStoreV2RewardUI$4 implements TextWatcher {
    final /* synthetic */ EmojiStoreV2RewardUI lGQ;

    EmojiStoreV2RewardUI$4(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.lGQ = emojiStoreV2RewardUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (EmojiStoreV2RewardUI.h(this.lGQ) != null) {
            if (editable != null && editable.length() > 0) {
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                if (indexOf > 0 && (obj.length() - indexOf) - 1 > 2) {
                    editable.delete(indexOf + 3, indexOf + 4);
                }
                float f = 0.0f;
                try {
                    f = Float.valueOf(editable.toString()).floatValue();
                } catch (NumberFormatException e) {
                }
                if (f > 200.0f || f < 1.0f) {
                    EmojiStoreV2RewardUI.e(this.lGQ).pqM.setTextColor(this.lGQ.mController.xIM.getResources().getColor(R.e.btB));
                } else {
                    EmojiStoreV2RewardUI.e(this.lGQ).pqM.setTextColor(this.lGQ.mController.xIM.getResources().getColor(R.e.btv));
                    EmojiStoreV2RewardUI.h(this.lGQ).setEnabled(true);
                    return;
                }
            }
            EmojiStoreV2RewardUI.h(this.lGQ).setEnabled(false);
        }
    }
}
