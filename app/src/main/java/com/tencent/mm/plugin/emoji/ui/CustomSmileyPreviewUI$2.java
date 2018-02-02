package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class CustomSmileyPreviewUI$2 implements d {
    final /* synthetic */ CustomSmileyPreviewUI lBm;

    CustomSmileyPreviewUI$2(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.lBm = customSmileyPreviewUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                Context context = this.lBm;
                EmojiInfo XU = i.aBE().lwL.XU(context.getIntent().getStringExtra("custom_smiley_preview_md5"));
                if (XU == null) {
                    x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "[cpan] save custom emoji failed. emoji is null.");
                    return;
                } else if (XU.field_catalog == EmojiInfo.xAg) {
                    return;
                } else {
                    if (XU.field_catalog == EmojiInfo.xAk) {
                        h.bu(context, context.getString(R.l.dDL));
                        return;
                    } else {
                        i.aBA().a(context.mController.xIM, XU, 4, context.lBj);
                        return;
                    }
                }
            case 1:
                CustomSmileyPreviewUI.n(this.lBm);
                return;
            case 2:
                CustomSmileyPreviewUI.o(this.lBm);
                return;
            default:
                return;
        }
    }
}
