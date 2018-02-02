package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI;

public class EmojiStoreV2RankUI extends BaseEmojiStoreUI {
    protected final void initView() {
        super.initView();
        setMMTitle(R.l.eaC);
    }

    protected final a aCj() {
        return new f(this.mController.xIM);
    }

    protected final int aCq() {
        return 10;
    }

    protected final int aCh() {
        return 5;
    }

    protected final int aCi() {
        return 105;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
