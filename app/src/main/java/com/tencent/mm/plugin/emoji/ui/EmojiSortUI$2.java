package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.ui.EmojiSortUI.3;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

class EmojiSortUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiSortUI lCD;

    EmojiSortUI$2(EmojiSortUI emojiSortUI) {
        this.lCD = emojiSortUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (an.isConnected(ac.getContext())) {
            Context context = this.lCD;
            context.getString(R.l.dGO);
            context.ltM = h.a(context, context.getString(R.l.dHc), true, new 3(context));
            List arrayList = new ArrayList();
            if (!(EmojiSortUI.b(this.lCD) == null || EmojiSortUI.b(this.lCD).ltR == null)) {
                for (EmojiGroupInfo emojiGroupInfo : EmojiSortUI.b(this.lCD).ltR) {
                    arrayList.add(emojiGroupInfo.field_productID);
                }
            }
            EmojiSortUI.a(this.lCD, new s(arrayList, 2));
            ar.CG().a(EmojiSortUI.c(this.lCD), 0);
        } else {
            EmojiSortUI.a(this.lCD);
        }
        return true;
    }
}
