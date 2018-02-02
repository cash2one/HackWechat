package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreVpHeader$a extends af {
    final /* synthetic */ EmojiStoreVpHeader lEg;

    private EmojiStoreVpHeader$a(EmojiStoreVpHeader emojiStoreVpHeader) {
        this.lEg = emojiStoreVpHeader;
    }

    public final void handleMessage(Message message) {
        if (!EmojiStoreVpHeader.d(this.lEg) && message.what != 0) {
            return;
        }
        if (EmojiStoreVpHeader.b(this.lEg) == null || EmojiStoreVpHeader.b(this.lEg).size() <= 1) {
            x.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
        } else if (EmojiStoreVpHeader.a(this.lEg) == null) {
            x.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
        } else {
            int i = EmojiStoreVpHeader.e(this.lEg).yF + 1;
            if (i >= EmojiStoreVpHeader.a(this.lEg).getCount()) {
                i = (EmojiStoreVpHeader.b(this.lEg).size() * i.lur) / 2;
            }
            EmojiStoreVpHeader.e(this.lEg).ah(i);
            if (EmojiStoreVpHeader.d(this.lEg) && EmojiStoreVpHeader.f(this.lEg) != null) {
                sendMessageDelayed(EmojiStoreVpHeader.f(this.lEg).obtainMessage(0), 5000);
            }
        }
    }
}
