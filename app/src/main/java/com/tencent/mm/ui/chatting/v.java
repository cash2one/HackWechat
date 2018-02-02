package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.io.FileInputStream;
import java.io.InputStream;

public final class v implements j {
    private Context context;
    private x jLe;
    private String ysi;
    private boolean yvm = true;
    private boolean yvn = true;

    public v(Context context, x xVar, String str) {
        this.context = context;
        this.jLe = xVar;
        this.ysi = str;
        if (x.gy(this.ysi)) {
            this.yvn = false;
        }
        if (x.Wz(this.ysi)) {
            this.yvm = false;
        }
        if (x.Wx(this.ysi)) {
            this.yvm = false;
        }
        String str2 = (this.jLe == null || !x.gy(this.jLe.field_username)) ? this.jLe == null ? null : this.jLe.field_username : this.ysi;
        if (s.gA(str2)) {
            this.yvn = false;
        }
    }

    public final void l(EmojiInfo emojiInfo) {
        ar.Hg();
        if (!c.isSDCardAvailable()) {
            u.fI(this.context);
        } else if (emojiInfo != null) {
            int i;
            if (this.jLe.field_username.equals("medianote") && (q.FW() & 16384) == 0) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i != 0) {
                emojiInfo.field_start = 0;
                emojiInfo.field_state = EmojiInfo.xAs;
                ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().d(emojiInfo);
                cf auVar = new au();
                auVar.setType(47);
                auVar.dS("medianote");
                auVar.eR(1);
                if (emojiInfo.Yz()) {
                    auVar.setContent(aj.a(q.FS(), 0, false, emojiInfo.Nr(), false, ""));
                }
                auVar.dT(emojiInfo.Nr());
                auVar.aq(ba.hR(auVar.field_talker));
                auVar.eQ(2);
                ar.Hg();
                c.Fa().Q(auVar);
                return;
            }
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(bh.ov(this.ysi) ? this.jLe.field_username : this.ysi, emojiInfo, null);
        }
    }

    public final void m(EmojiInfo emojiInfo) {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            String stringBuilder2 = stringBuilder.append(c.Fp()).append(emojiInfo.Nr()).toString();
            if (e.bO(stringBuilder2 + "_thumb")) {
                wXMediaMessage.thumbData = e.d(stringBuilder2 + "_thumb", 0, e.bN(stringBuilder2 + "_thumb"));
            } else {
                try {
                    InputStream fileInputStream = new FileInputStream(stringBuilder2);
                    wXMediaMessage.setThumbImage(b.a(fileInputStream, 1.0f));
                    fileInputStream.close();
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ChattingSmileyPanelImpl", e, "", new Object[0]);
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
                }
            }
            wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
            l.a(wXMediaMessage, emojiInfo.field_app_id, null, this.ysi, 1, emojiInfo.Nr());
            return;
        }
        u.fI(this.context);
    }

    public final boolean aZd() {
        return this.yvn;
    }

    public final boolean aZe() {
        return this.yvm;
    }

    public final void aZf() {
    }
}
