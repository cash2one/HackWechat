package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class EmojiStoreDetailUI$8 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$8(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (a.yO(EmojiStoreDetailUI.a(this.lDM))) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
            com.tencent.mm.plugin.emoji.f.a.aBJ().aBL();
        } else {
            ar.CG().c(EmojiStoreDetailUI.v(this.lDM));
        }
        if (!TextUtils.isEmpty(EmojiStoreDetailUI.w(this.lDM))) {
            g.MJ().kI(EmojiStoreDetailUI.w(this.lDM));
            x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[]{EmojiStoreDetailUI.w(this.lDM)});
        }
        if (e.co(EmojiStoreDetailUI.b(this.lDM).waw, 1) || e.oK(EmojiStoreDetailUI.b(this.lDM).wav)) {
            EmojiStoreDetailUI.a(this.lDM, 3);
        } else {
            EmojiStoreDetailUI.a(this.lDM, -1);
        }
        i.aBG().f(EmojiStoreDetailUI.a(this.lDM), EmojiStoreDetailUI.x(this.lDM), 0, EmojiStoreDetailUI.w(this.lDM));
        EmojiStoreDetailUI.i(this.lDM).setVisibility(8);
        EmojiStoreDetailUI.l(this.lDM).setProgress(0);
        EmojiStoreDetailUI.j(this.lDM).setVisibility(4);
        EmojiStoreDetailUI.h(this.lDM).setVisibility(0);
        EmojiStoreDetailUI.y(this.lDM);
        EmojiStoreDetailUI.g(this.lDM);
        ar.CG().a(new q(EmojiStoreDetailUI.a(this.lDM), 2), 0);
    }
}
