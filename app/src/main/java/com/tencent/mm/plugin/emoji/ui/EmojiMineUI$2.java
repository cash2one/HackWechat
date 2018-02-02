package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EmojiMineUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiMineUI lCv;

    EmojiMineUI$2(EmojiMineUI emojiMineUI) {
        this.lCv = emojiMineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ArrayList ckq = i.aBE().lwM.ckq();
        List arrayList = new ArrayList();
        Iterator it = ckq.iterator();
        while (it.hasNext()) {
            EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) it.next();
            if (emojiGroupInfo.field_type != EmojiGroupInfo.TYPE_CUSTOM) {
                arrayList.add(emojiGroupInfo);
            }
        }
        if (arrayList.size() <= 1) {
            h.h(this.lCv.mController.xIM, R.l.dZA, R.l.dGO);
        } else if (an.isConnected(ac.getContext())) {
            Intent intent = new Intent();
            intent.setClass(this.lCv, EmojiSortUI.class);
            this.lCv.startActivity(intent);
        } else {
            EmojiMineUI.a(this.lCv);
        }
        return true;
    }
}
