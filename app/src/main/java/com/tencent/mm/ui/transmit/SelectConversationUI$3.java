package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.i.a.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;

class SelectConversationUI$3 implements a {
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$3(SelectConversationUI selectConversationUI) {
        this.zpv = selectConversationUI;
    }

    public final void aJL() {
        Intent intent = new Intent(this.zpv.mController.xIM, ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", SelectConversationUI.i(this.zpv));
        intent.putExtra("img_gallery_msg_svr_id", SelectConversationUI.j(this.zpv).field_msgSvrId);
        intent.putExtra("img_gallery_talker", SelectConversationUI.j(this.zpv).field_talker);
        intent.putExtra("img_gallery_chatroom_name", SelectConversationUI.j(this.zpv).field_talker);
        intent.putExtra("img_preview_only", true);
        this.zpv.startActivity(intent);
        b.fF(this.zpv.mController.xIM);
    }
}
