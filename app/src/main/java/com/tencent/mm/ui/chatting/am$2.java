package com.tencent.mm.ui.chatting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bo;

class am$2 implements a {
    final /* synthetic */ WXMediaMessage rLc;
    final /* synthetic */ f yyb;
    final /* synthetic */ am yyc;

    am$2(am amVar, WXMediaMessage wXMediaMessage, f fVar) {
        this.yyc = amVar;
        this.rLc = wXMediaMessage;
        this.yyb = fVar;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            String str2 = null;
            if (this.rLc.getType() == 8) {
                if (this.rLc.thumbData == null) {
                    x.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                    return;
                }
                str2 = ((c) g.k(c.class)).getEmojiMgr().a(am.a(this.yyc).getContext(), this.rLc, this.yyb.field_appId);
                if (str2 == null) {
                    x.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
                    return;
                }
            }
            bo.HS().c(27, new Object[]{Integer.valueOf(1)});
            x.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", new Object[]{this.rLc.messageAction, this.rLc.messageExt});
            l.a(this.rLc, this.yyb.field_appId, this.yyb.field_appName, am.b(this.yyc).crz(), 1, str2);
        }
    }
}
