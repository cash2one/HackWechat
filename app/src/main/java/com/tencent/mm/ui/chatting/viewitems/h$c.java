package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.emoji.b.c;
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
import java.lang.ref.WeakReference;

public class h$c extends b {
    protected a yKm;
    private ChattingUI.a yqa;

    private a y(ChattingUI.a aVar) {
        if (this.yKm == null) {
            this.yKm = new a(aVar);
        }
        return this.yKm;
    }

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 1048625) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddm);
        view.setTag(new b().q(view, true));
        return view;
    }

    public final void a(b.a aVar, int i, ChattingUI.a aVar2, au auVar, String str) {
        g.a I;
        EmojiInfo emojiInfo;
        this.yqa = aVar2;
        aVar2.yvP.aT(auVar);
        b bVar = (b) aVar;
        String str2 = auVar.field_content;
        if (str2 != null) {
            I = g.a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I == null || I.hbd == null) {
            emojiInfo = null;
        } else {
            emojiInfo = ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().yc(I.hbd);
        }
        if (emojiInfo == null || !emojiInfo.cks()) {
            Bitmap u;
            String B = o.Pw().B(auVar.field_imgPath, true);
            Bitmap lz = o.PA().lz(B);
            if (lz == null || lz.isRecycled()) {
                lz = d.decodeFile(B, null);
                o.PA().i(B, lz);
            }
            if (emojiInfo == null) {
                bVar.yKj.setVisibility(0);
                bVar.yKi.setVisibility(8);
                bVar.yKk.setText(t.bx(I == null ? 0 : (long) I.hbb));
                bVar.yKk.setVisibility(0);
                bVar.yKj.setImageResource(R.g.bBP);
            } else {
                bVar.yKi.setVisibility(0);
                bVar.yKk.setVisibility(8);
                bVar.yKj.setVisibility(8);
                bVar.yKi.setProgress(0);
                bVar.yKk.setVisibility(8);
            }
            if (!(I == null || bh.ov(I.hbd))) {
                b.yKl.put(I.hbd, new WeakReference(bVar));
            }
            if (lz == null || lz.isRecycled()) {
                u = d.u(this.yqa.getResources().getDrawable(R.g.byY));
            } else {
                u = lz;
            }
            bVar.yKg.setImageBitmap(u);
        } else {
            bVar.yKg.a(emojiInfo, auVar.field_msgId);
            bVar.yKj.setVisibility(8);
            bVar.yKi.setVisibility(8);
            bVar.yKk.setVisibility(8);
            bVar.yKj.setVisibility(8);
            if (!(I == null || bh.ov(I.hbd))) {
                b.yKl.remove(I.hbd);
            }
            a(auVar, emojiInfo);
        }
        bVar.yKg.setTag(new ar(auVar, aVar2.ypn, i, str, (byte) 0));
        bVar.yKg.setOnClickListener(y(aVar2));
        bVar.yKg.setOnLongClickListener(s(aVar2));
        bVar.yKg.setOnTouchListener(aVar2.ysf.ysV);
        bVar.yKj.setOnClickListener(y(aVar2));
        bVar.yKj.setOnLongClickListener(s(aVar2));
        bVar.yKj.setTag(bVar.yKg.getTag());
    }

    protected final boolean r(ChattingUI.a aVar) {
        return aVar.ypn;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
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
                if (yc != null) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(12789, new Object[]{Integer.valueOf(0), yc.Nr(), Integer.valueOf(0), yc.field_designerID, yc.field_groupId, "", "", "", "", yc.field_activityid});
                }
                boolean cks = yc.cks();
                if (yc.field_catalog == EmojiInfo.xAk || bh.ov(yc.field_groupId) || (!bh.ov(yc.field_groupId) && ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().yf(yc.field_groupId))) {
                    if (cks) {
                        contextMenu.add(i, 113, 0, R.l.eEC);
                    } else {
                        x.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
                    }
                }
            }
        }
        if (!this.yqa.csV()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRF));
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
