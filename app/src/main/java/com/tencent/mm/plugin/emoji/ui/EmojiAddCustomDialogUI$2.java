package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.tools.a.b;
import com.tencent.mm.ui.tools.a.b.a;

class EmojiAddCustomDialogUI$2 implements a {
    final /* synthetic */ EmojiAddCustomDialogUI lBu;
    final /* synthetic */ EmojiInfo lvA;

    EmojiAddCustomDialogUI$2(EmojiAddCustomDialogUI emojiAddCustomDialogUI, EmojiInfo emojiInfo) {
        this.lBu = emojiAddCustomDialogUI;
        this.lvA = emojiInfo;
    }

    public final void a(b bVar) {
        if (i.aBE().lwL.lI(false) >= n.aBn()) {
            x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
            this.lBu.aCx();
            EmojiAddCustomDialogUI.a(this.lBu);
            g.pQN.h(10431, new Object[]{Integer.valueOf(EmojiAddCustomDialogUI.b(this.lBu)), EmojiAddCustomDialogUI.c(this.lBu).Nr(), EmojiAddCustomDialogUI.c(this.lBu).field_designerID, EmojiAddCustomDialogUI.c(this.lBu).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.c(this.lBu).field_size), EmojiAddCustomDialogUI.d(this.lBu), EmojiAddCustomDialogUI.c(this.lBu).field_activityid});
        } else if (this.lvA.field_catalog == EmojiInfo.xAk || bh.ov(this.lvA.field_groupId) || (!bh.ov(this.lvA.field_groupId) && ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().yf(this.lvA.field_groupId))) {
            EmojiAddCustomDialogUI.j(this.lvA);
        } else {
            EmojiAddCustomDialogUI.k(this.lvA);
        }
    }

    public final void aCH() {
        this.lBu.aCx();
        EmojiAddCustomDialogUI.e(this.lBu);
        g.pQN.h(10431, new Object[]{Integer.valueOf(EmojiAddCustomDialogUI.b(this.lBu)), EmojiAddCustomDialogUI.c(this.lBu).Nr(), EmojiAddCustomDialogUI.c(this.lBu).field_designerID, EmojiAddCustomDialogUI.c(this.lBu).field_groupId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(EmojiAddCustomDialogUI.c(this.lBu).field_size), EmojiAddCustomDialogUI.d(this.lBu), EmojiAddCustomDialogUI.c(this.lBu).field_activityid});
    }
}
