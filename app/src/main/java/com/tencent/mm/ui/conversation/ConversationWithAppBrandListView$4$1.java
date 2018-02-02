package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.4;

class ConversationWithAppBrandListView$4$1 implements Runnable {
    final /* synthetic */ 4 yYo;

    ConversationWithAppBrandListView$4$1(4 4) {
        this.yYo = 4;
    }

    public final void run() {
        if (this.yYo.yYn) {
            this.yYo.yYl.yYc = true;
            this.yYo.yYl.Gq(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
            this.yYo.yYl.postDelayed(new Runnable(this) {
                final /* synthetic */ ConversationWithAppBrandListView$4$1 yYp;

                {
                    this.yYp = r1;
                }

                public final void run() {
                    this.yYp.yYo.yYl.yYc = false;
                }
            }, 2000);
            return;
        }
        super.setSelection(0);
    }
}
