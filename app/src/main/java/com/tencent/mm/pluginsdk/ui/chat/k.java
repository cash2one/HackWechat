package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.api.n;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class k extends n implements j {
    public final void l(EmojiInfo emojiInfo) {
        this.fdM.a(emojiInfo);
    }

    public final void m(EmojiInfo emojiInfo) {
    }

    public final boolean aZd() {
        return false;
    }

    public final boolean aZe() {
        return true;
    }

    public final void aZf() {
        this.fdM.onHide();
    }
}
