package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.s.c;
import com.tencent.mm.ui.chatting.viewitems.s.d;
import com.tencent.mm.z.ar;

public class s$a extends b {
    protected c yMe;
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 47) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddu);
        view.setTag(new d().q(view, true));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        if (auVar == null) {
            x.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", new Object[]{str});
            return;
        }
        this.yqa = aVar2;
        EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(auVar.field_imgPath);
        yc.talker = auVar.field_talker;
        d dVar = (d) aVar;
        if (yc != null) {
            aj Xp = aj.Xp(auVar.field_content);
            dVar.yKg.a(yc, auVar.field_msgId, Xp);
            if (yc.Yz() && !Xp.hVA) {
                Xp.hVA = true;
                auVar.setContent(Xp.ciN());
                ar.Hg();
                com.tencent.mm.z.c.Fa().a(auVar.field_msgId, auVar);
            }
        }
        String str2 = "";
        if (yc == null || !yc.Yz()) {
            if (yc != null) {
                str2 = bh.az(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().xZ(yc.Nr()), "");
            }
        } else if (yc.field_name.startsWith("jsb_j")) {
            str2 = this.yqa.getContext().getString(R.l.dZS);
        } else if (yc.field_name.startsWith("jsb_s")) {
            str2 = this.yqa.getContext().getString(R.l.dZT);
        } else if (yc.field_name.startsWith("jsb_b")) {
            str2 = this.yqa.getContext().getString(R.l.dZR);
        } else if (yc.field_name.startsWith("dice")) {
            str2 = yc.field_name.replace("dice_", "").replace(".png", "");
        }
        dVar.yKg.setContentDescription(this.yqa.getContext().getString(R.l.eaY) + str2);
        dVar.yKg.setTag(new ar(auVar, aVar2.ypn, i, str, (byte) 0));
        RTChattingEmojiView rTChattingEmojiView = dVar.yKg;
        if (this.yMe == null) {
            this.yMe = new c(aVar2);
        }
        rTChattingEmojiView.setOnClickListener(this.yMe);
        dVar.yKg.setOnLongClickListener(s(aVar2));
        dVar.yKg.setOnTouchListener(aVar2.ysf.ysV);
    }

    protected final boolean r(a aVar) {
        return aVar.ypn;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (auVar.cjj()) {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                int i = ((ar) view.getTag()).position;
                EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(auVar.field_imgPath);
                if (yc == null) {
                    String str;
                    String str2 = "MicroMsg.emoji.ChattingItemEmojiFrom";
                    String str3 = "emoji is null. md5:%s";
                    Object[] objArr = new Object[1];
                    if (auVar == null) {
                        str = "";
                    } else {
                        str = auVar.field_imgPath;
                    }
                    objArr[0] = str;
                    x.w(str2, str3, objArr);
                } else {
                    boolean cks = yc.cks();
                    if (!(yc.field_catalog == EmojiInfo.xAk || yc.ckv() || yc.ckw())) {
                        if (cks) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(R.l.dRR));
                        } else {
                            x.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (yc.field_catalog == EmojiInfo.xAk || bh.ov(yc.field_groupId) || (!bh.ov(yc.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yf(yc.field_groupId))) {
                        if (cks) {
                            contextMenu.add(i, 113, 0, R.l.eEC);
                        } else {
                            x.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (!(bh.ov(yc.field_groupId) || yc.Yz() || yc.ckw())) {
                        contextMenu.add(i, 127, 0, R.l.dRT);
                    }
                    if (!this.yqa.csV()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRF));
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(12789, new Object[]{Integer.valueOf(0), yc.Nr(), Integer.valueOf(0), yc.field_designerID, yc.field_groupId, "", "", "", "", yc.field_activityid});
                }
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        return false;
    }
}
