package com.tencent.mm.ui.chatting.b;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.z.ar;
import java.util.ArrayList;

public final class l {
    public p fhr;
    public c yzW = new c<q>(this) {
        final /* synthetic */ l yzY;

        {
            this.yzY = r2;
            this.xen = q.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            q qVar = (q) bVar;
            if (this.yzY.fhr.csy() != null) {
                if (qVar.fnx.status == 1) {
                    if (this.yzY.fhr.css() != null) {
                        this.yzY.fhr.css().post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 yzZ;

                            {
                                this.yzZ = r1;
                            }

                            public final void run() {
                                this.yzZ.yzY.fhr.cpl();
                            }
                        });
                    }
                } else if (this.yzY.fhr.css() != null) {
                    this.yzY.fhr.css().post(new 2(this, qVar));
                }
            }
            return false;
        }
    };
    public c yzX = new 2(this);

    public l(p pVar) {
        this.fhr = pVar;
    }

    public final boolean a(String str, String str2, ArrayList<String> arrayList, int i, int i2) {
        long bN = (long) e.bN(str2);
        if (p.UR(str2) && this.fhr.csB() != null && this.fhr.csB().vjC != null && (this.fhr.csB().vjC instanceof v)) {
            Object obj = null;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            d.decodeFile(str2, options);
            if (options.outHeight > com.tencent.mm.k.b.zE() || options.outWidth > com.tencent.mm.k.b.zE()) {
                obj = 1;
            }
            if (x.fV(str)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.EmojImpl", "tummy, add gif msg filePath");
                arrayList.add(str2);
                return true;
            } else if (bN <= ((long) i) && r0 == null) {
                EmojiInfo yc;
                EmojiInfo yc2 = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(com.tencent.mm.a.g.bV(str2));
                if (yc2 == null) {
                    com.tencent.mm.pluginsdk.b.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr();
                    this.fhr.csq().getContext();
                    yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(emojiMgr.yd(str2));
                } else {
                    yc = yc2;
                }
                if (yc != null) {
                    ((v) this.fhr.csB().vjC).l(yc);
                    com.tencent.mm.plugin.report.service.g.pQN.h(13459, new Object[]{Long.valueOf(bN), Integer.valueOf(0), yc.Nr(), Integer.valueOf(0)});
                } else {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI.EmojImpl", "emoji is null");
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.EmojImpl", "cpan send custom emoji.");
                return true;
            } else if (bN > ((long) i2) || r0 != null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.EmojImpl", "cpan emoji is too large, ignore.filePath:%s", new Object[]{str2});
            } else {
                String a = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.fhr.csq().getContext(), new WXMediaMessage(new WXEmojiObject(str2)), null);
                if (a != null) {
                    ((v) this.fhr.csB().vjC).m(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(a));
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(13459, new Object[]{Long.valueOf(bN), Integer.valueOf(0), a, Integer.valueOf(0)});
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.EmojImpl", "cpan send app emoji msg.");
                return true;
            }
        }
        return false;
    }

    public final boolean aN(au auVar) {
        if (auVar.cjj()) {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.EmojImpl", "resendEmoji");
                if (!this.fhr.csi().field_username.equals("medianote")) {
                    ar.Hg();
                    com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.e(auVar.field_talker, auVar.field_msgSvrId));
                }
                af.aF(auVar);
                return true;
            }
            u.fI(this.fhr.csq().getContext());
            return true;
        } else if (!auVar.cjk()) {
            return false;
        } else {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.EmojImpl", "resendAppMsgEmoji");
            if (!this.fhr.csi().field_username.equals("medianote")) {
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.e(auVar.field_talker, auVar.field_msgSvrId));
            }
            af.aG(auVar);
            this.fhr.mM(true);
            return true;
        }
    }
}
