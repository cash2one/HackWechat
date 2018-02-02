package com.tencent.mm.plugin.emoji.e;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

class c$3 implements OnClickListener {
    final /* synthetic */ EmojiInfo lvA;
    final /* synthetic */ c lvB;

    c$3(c cVar, EmojiInfo emojiInfo) {
        this.lvB = cVar;
        this.lvA = emojiInfo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.a(this.lvB, this.lvA);
        this.lvB.lvz = true;
        x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", new Object[]{this.lvA.field_groupId});
    }
}
