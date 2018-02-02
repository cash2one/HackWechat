package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.h.a;
import com.tencent.mm.ui.chatting.viewitems.h.b;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;

public class h$d extends b {
    protected a yKm;
    private ChattingUI.a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 1048625) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddR);
        view.setTag(new b().q(view, false));
        return view;
    }

    public final void a(b.a aVar, int i, ChattingUI.a aVar2, au auVar, String str) {
        this.yqa = aVar2;
        aVar2.yvP.aT(auVar);
        aVar = (b) aVar;
        if (auVar != null) {
            EmojiInfo emojiInfo;
            g.a aVar3;
            EmojiInfo emojiInfo2;
            RTChattingEmojiView rTChattingEmojiView;
            String str2 = auVar.field_content;
            aj Xp = aj.Xp(auVar.field_content);
            if (Xp.hVA) {
                emojiInfo = null;
                aVar3 = null;
            } else {
                if (str2 != null) {
                    aVar3 = g.a.I(str2, auVar.field_reserved);
                } else {
                    aVar3 = null;
                }
                emojiInfo = aVar3 != null ? ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().yc(aVar3.hbd) : null;
            }
            if (Xp.fqR == null || Xp.fqR.equals("-1") || emojiInfo != null) {
                emojiInfo2 = emojiInfo;
            } else {
                emojiInfo2 = ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().yc(Xp.fqR);
            }
            if (emojiInfo2 == null || !emojiInfo2.cks()) {
                long j;
                String B = o.Pw().B(auVar.field_imgPath, true);
                Bitmap lz = o.PA().lz(B);
                if (lz == null || lz.isRecycled()) {
                    lz = d.decodeFile(B, null);
                    o.PA().i(B, lz);
                }
                aVar.psA.setVisibility(8);
                aVar.yKj.setVisibility(0);
                aVar.yKi.setVisibility(8);
                TextView textView = aVar.yKk;
                if (aVar3 == null) {
                    j = 0;
                } else {
                    j = (long) aVar3.hbb;
                }
                textView.setText(t.bx(j));
                aVar.yKk.setVisibility(0);
                aVar.yKj.setImageResource(R.g.bBP);
                if (lz == null || lz.isRecycled()) {
                    lz = d.u(this.yqa.getResources().getDrawable(R.g.byY));
                }
                aVar.yKg.setImageBitmap(lz);
                if (!(aVar3 == null || bh.ov(aVar3.hbd))) {
                    b.yKl.put(aVar3.hbd, new WeakReference(aVar));
                }
            } else {
                int i2;
                aVar.yKg.a(emojiInfo2, auVar.field_msgId);
                rTChattingEmojiView = aVar.yKg;
                if (rTChattingEmojiView.vsN != null) {
                    rTChattingEmojiView.vsN.resume();
                }
                boolean z = auVar.field_status != 1;
                ProgressBar progressBar = aVar.psA;
                if (z) {
                    i2 = 4;
                } else {
                    i2 = 0;
                }
                progressBar.setVisibility(i2);
                a(auVar, emojiInfo2);
            }
            if (cvy()) {
                if (auVar != null && auVar.field_status == 2 && a(aVar2.ysf, auVar.field_msgId)) {
                    if (aVar.yJk != null) {
                        aVar.yJk.setVisibility(0);
                    }
                } else if (aVar.yJk != null) {
                    aVar.yJk.setVisibility(8);
                }
            }
            aVar.yKg.setTag(new ar(auVar, aVar2.ypn, i, aVar2.ysf.hlJ, (byte) 0));
            rTChattingEmojiView = aVar.yKg;
            if (this.yKm == null) {
                this.yKm = new a(aVar2);
            }
            rTChattingEmojiView.setOnClickListener(this.yKm);
            aVar.yKg.setOnLongClickListener(s(aVar2));
            aVar.yKg.setOnTouchListener(aVar2.ysf.ysV);
            a(i, aVar, auVar, aVar2.ysf.hlJ, aVar2.ypn, aVar2);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ar.Hg();
        if (com.tencent.mm.z.c.isSDCardAvailable()) {
            g.a aVar;
            int i = ((ar) view.getTag()).position;
            aj Xp = aj.Xp(auVar.field_content);
            g.a I = g.a.I(auVar.field_content, auVar.field_reserved);
            if (I == null) {
                I = new g.a();
                I.hbd = Xp.fqR;
                aVar = I;
            } else {
                aVar = I;
            }
            if (!(t.ov(aVar.hbd) || aVar.hbd.equals("-1"))) {
                EmojiInfo yc = ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().yc(aVar.hbd);
                if (yc != null) {
                    if (!(yc.field_catalog == EmojiInfo.xAk || yc.ckv())) {
                        contextMenu.add(i, 104, 0, view.getContext().getString(R.l.dRR));
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(12789, new Object[]{Integer.valueOf(0), yc.Nr(), Integer.valueOf(0), yc.field_designerID, yc.field_groupId, "", "", "", "", yc.field_activityid});
                    boolean cks = yc.cks();
                    if (yc.field_catalog == EmojiInfo.xAk || bh.ov(yc.field_groupId) || (!bh.ov(yc.field_groupId) && ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().yf(yc.field_groupId))) {
                        if (cks) {
                            contextMenu.add(i, 113, 0, R.l.eEC);
                        } else {
                            x.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                } else {
                    x.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[]{aVar.hbd});
                }
            }
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dSI));
            }
            if (!auVar.ciV() && auVar.cjk() && ((auVar.field_status == 2 || auVar.gjJ == 1) && a(auVar, this.yqa) && Zq(auVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
            }
            if (!this.yqa.csV()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRF));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, ChattingUI.a aVar, au auVar) {
        return false;
    }

    public final boolean b(View view, ChattingUI.a aVar, au auVar) {
        return false;
    }
}
