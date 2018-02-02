package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.ArrayList;

public class c {
    public static c lvw;
    public ArrayList<String> lvx = new ArrayList();
    public boolean lvy = true;
    public boolean lvz = false;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ EmojiInfo lvA;
        final /* synthetic */ c lvB;

        AnonymousClass1(c cVar, EmojiInfo emojiInfo) {
            this.lvB = cVar;
            this.lvA = emojiInfo;
        }

        public final void run() {
            if (this.lvA != null && !this.lvA.ckA()) {
                x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "chatting emoji broken. try to recover:%s", new Object[]{this.lvA.Nr()});
                c.a(this.lvA, true);
            }
        }
    }

    static /* synthetic */ void a(c cVar, Context context, EmojiInfo emojiInfo) {
        if (context != null && emojiInfo != null && !cVar.lvx.contains(emojiInfo.field_groupId)) {
            if (!aAP() || cVar.lvz) {
                if (aAP()) {
                    cVar.b(emojiInfo, false);
                    x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", new Object[]{emojiInfo.field_groupId});
                    return;
                }
                cVar.b(emojiInfo, true);
                x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in wifi netword:%s", new Object[]{emojiInfo.field_groupId});
            } else if (cVar.lvy) {
                h.a(context, context.getString(R.l.eaI), "", new 3(cVar, emojiInfo), new 4(cVar));
                cVar.lvy = false;
            } else {
                x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "has alert recover.");
            }
        }
    }

    public static c aAO() {
        if (lvw == null) {
            synchronized (c.class) {
                lvw = new c();
            }
        }
        return lvw;
    }

    public static void a(EmojiInfo emojiInfo, boolean z) {
        if (emojiInfo != null) {
            emojiInfo.field_reserved4 = 0;
            i.aBE().lwL.q(emojiInfo);
            i.aBy().g(emojiInfo);
            if (z) {
                g.pQN.a(231, 0, 1, false);
            } else {
                g.pQN.a(231, 1, 1, false);
            }
        }
    }

    private void b(EmojiInfo emojiInfo, boolean z) {
        if (this.lvx == null) {
            this.lvx = new ArrayList();
        }
        this.lvx.add(emojiInfo.field_groupId);
        ar.CG().a(new com.tencent.mm.plugin.emoji.f.g(emojiInfo.field_groupId), 0);
        if (z) {
            g.pQN.a(231, 3, 1, false);
        } else {
            g.pQN.a(231, 2, 1, false);
        }
    }

    private static boolean aAP() {
        return an.is3G(ac.getContext()) || an.is4G(ac.getContext()) || an.is2G(ac.getContext());
    }
}
