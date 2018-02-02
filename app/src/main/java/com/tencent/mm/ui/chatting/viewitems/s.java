package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;

public final class s {

    public static class c extends d {
        public c(a aVar) {
            super(aVar);
        }

        public final void a(View view, a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(arVar.fEJ.field_imgPath);
                if (yc != null && !yc.Yz()) {
                    Intent intent = new Intent();
                    intent.putExtra("custom_smiley_preview_md5", arVar.fEJ.field_imgPath);
                    intent.putExtra("custom_to_talker_name", arVar.fEJ.field_talker);
                    if (!(yc.field_catalog == EmojiGroupInfo.xAd || yc.field_catalog == EmojiGroupInfo.xAc || yc.field_catalog == EmojiGroupInfo.xAb)) {
                        intent.putExtra("custom_smiley_preview_productid", yc.field_groupId);
                    }
                    intent.putExtra("msg_id", arVar.fEJ.field_msgSvrId);
                    intent.putExtra("msg_content", arVar.fEJ.field_content);
                    String str = arVar.fEJ.field_talker;
                    intent.putExtra("msg_sender", com.tencent.mm.z.s.eV(str) ? ba.hP(arVar.fEJ.field_content) : str);
                    com.tencent.mm.bm.d.b(this.yqa.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", intent);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11592, new Object[]{Integer.valueOf(0)});
                }
            }
        }
    }
}
