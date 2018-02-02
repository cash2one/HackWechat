package com.tencent.mm.ui.chatting.viewitems;

import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.r.l;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.chatting.viewitems.s.c;
import com.tencent.mm.z.ar;

public class s$b extends b {
    protected c yMe;
    protected l yMf;
    private ChattingUI$a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 47) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddZ);
        view.setTag(new s$d().q(view, false));
        return view;
    }

    public final void a(a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        this.yqa = chattingUI$a;
        aVar = (s$d) aVar;
        EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(auVar.field_imgPath);
        if (yc != null) {
            aj Xp = aj.Xp(auVar.field_content);
            aVar.yKg.a(yc, auVar.field_msgId, Xp);
            if (aVar.yMg != null) {
                if (Xp.xyz) {
                    aVar.yMg.setVisibility(0);
                    TextView textView = (TextView) aVar.mUL.findViewById(R.h.bUS).findViewById(R.h.bTS);
                    TextView textView2 = textView;
                    textView2.setText(Html.fromHtml(chattingUI$a.getString(R.l.dZB)));
                    ImageView imageView = (ImageView) aVar.mUL.findViewById(R.h.bUS).findViewById(R.h.bTR);
                    textView2 = textView;
                    textView2.setTag(new ar(auVar, false, i, chattingUI$a.ysf.hlJ, false, "", "", "", "", yc.field_groupId, "", true, false));
                    textView.setOnClickListener(x(chattingUI$a));
                    if (((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aAU()) {
                        imageView.setVisibility(0);
                        ImageView imageView2 = imageView;
                        imageView2.setTag(new ar(auVar, chattingUI$a.ypn, i, chattingUI$a.ysf.hlJ, (byte) 0));
                        if (this.yMf == null) {
                            this.yMf = new l(chattingUI$a);
                        }
                        imageView.setOnClickListener(this.yMf);
                    } else {
                        imageView.setVisibility(8);
                    }
                } else {
                    aVar.yMg.setVisibility(8);
                }
            }
            if (yc.Yz() && !Xp.hVA) {
                Xp.hVA = true;
                auVar.setContent(Xp.ciN());
                ar.Hg();
                auVar.eQ(com.tencent.mm.z.c.Fa().dH(auVar.field_msgId).field_status);
                ar.Hg();
                com.tencent.mm.z.c.Fa().S(auVar);
            }
            if (cvy()) {
                aVar.psA.setVisibility(8);
                if (auVar != null && auVar.field_status == 2 && a(chattingUI$a.ysf, auVar.field_msgId)) {
                    if (aVar.yJk != null) {
                        aVar.yJk.setVisibility(0);
                    }
                } else if (aVar.yJk != null) {
                    aVar.yJk.setVisibility(8);
                }
            } else {
                if (aVar.yJk != null) {
                    aVar.yJk.setVisibility(8);
                }
                if (aVar.psA != null) {
                    aVar.psA.setVisibility(0);
                    if (auVar.field_status >= 2) {
                        aVar.psA.setVisibility(8);
                    }
                }
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
        aVar.yKg.setContentDescription(this.yqa.getContext().getString(R.l.eaY) + str2);
        aVar.yKg.setTag(new ar(auVar, chattingUI$a.ypn, i, chattingUI$a.ysf.hlJ, (byte) 0));
        RTChattingEmojiView rTChattingEmojiView = aVar.yKg;
        if (this.yMe == null) {
            this.yMe = new c(chattingUI$a);
        }
        rTChattingEmojiView.setOnClickListener(this.yMe);
        aVar.yKg.setOnLongClickListener(s(chattingUI$a));
        aVar.yKg.setOnTouchListener(chattingUI$a.ysf.ysV);
        a(i, aVar, auVar, chattingUI$a.ysf.hlJ, chattingUI$a.ypn, chattingUI$a);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (auVar.cjj()) {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                int i = ((ar) view.getTag()).position;
                EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(auVar.field_imgPath);
                if (yc == null) {
                    String str;
                    String str2 = "MicroMsg.emoji.ChattingItemEmojiTo";
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
                            x.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (yc.field_catalog == EmojiInfo.xAk || bh.ov(yc.field_groupId) || (!bh.ov(yc.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yf(yc.field_groupId))) {
                        if (cks) {
                            contextMenu.add(i, 113, 0, R.l.eEC);
                        } else {
                            x.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (!(bh.ov(yc.field_groupId) || yc.Yz() || yc.ckw())) {
                        contextMenu.add(i, 127, 0, R.l.dRT);
                    }
                    if (!auVar.ciV() && auVar.cjj() && ((auVar.field_status == 2 || auVar.gjJ == 1) && a(auVar, this.yqa) && Zq(auVar.field_talker))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
                    }
                    if (!this.yqa.csV()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRF));
                    }
                    if (auVar.field_status == 5) {
                        contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dSI));
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(12789, new Object[]{Integer.valueOf(0), yc.Nr(), Integer.valueOf(0), yc.field_designerID, yc.field_groupId, "", "", "", "", "", yc.field_activityid});
                }
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, ChattingUI$a chattingUI$a, au auVar) {
        return false;
    }

    public final boolean b(View view, ChattingUI$a chattingUI$a, au auVar) {
        return false;
    }
}
