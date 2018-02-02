package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$2 implements e {
    final /* synthetic */ AppBrandServiceConversationFmUI yVG;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$2(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI) {
        this.yVG = appBrandServiceConversationFmUI;
    }

    public final void bo(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.AppBrandServiceConversationFmUI", "onItemDel object null");
            return;
        }
        AppBrandServiceConversationFmUI.access$800(this.yVG, obj.toString());
    }
}
