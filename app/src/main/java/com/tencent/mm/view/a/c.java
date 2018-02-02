package com.tencent.mm.view.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.aq.a.c.d;
import com.tencent.mm.aq.a.c.e;
import com.tencent.mm.aq.a.c.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.v;
import com.tencent.mm.view.f.a;
import java.util.ArrayList;

public final class c extends a {
    private l hEq = new 3(this);
    private d lBS = new 2(this);
    ArrayList<EmojiInfo> lDO;
    private e zEq = new 1(this);

    public final /* synthetic */ Object getItem(int i) {
        return oO(i);
    }

    public c(Context context, a aVar) {
        super(context, aVar);
    }

    public final int getCount() {
        if (this.zEm != this.zDn - 1) {
            return this.zEl;
        }
        int i = this.kFr - (this.zEm * this.zEl);
        if (i < 0) {
            return 0;
        }
        return i;
    }

    private EmojiInfo oO(int i) {
        int i2 = (this.zEm * this.zEl) + i;
        if (this.zDl == 25 && this.zDu.irz != ChatFooterPanel.vjG) {
            i2--;
        }
        if (this.lDO == null || i2 < 0 || i2 >= this.lDO.size()) {
            return null;
        }
        return (EmojiInfo) this.lDO.get(i2);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = v.fv(this.mContext).inflate(f.lJA, null);
            view.setLayoutParams(new LayoutParams(this.zDu.getColumnWidth(), this.zDu.zGv));
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.zDl == 25 && this.zEm == 0 && i == 0 && this.zDu.irz != ChatFooterPanel.vjG) {
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a("", aVar.jCP);
            aVar.jCP.setBackgroundResource(com.tencent.mm.plugin.m.a.d.lJb);
            aVar.jCP.setImageResource(com.tencent.mm.plugin.m.a.g.lJF);
            aVar.jCP.setContentDescription(view.getContext().getString(h.eLm));
            int aBa = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBa();
            com.tencent.mm.bu.a.cdS();
            if (aBa > (((com.tencent.mm.kernel.b.h) g.Dg().CN()).DS() ? bh.getInt(com.tencent.mm.k.g.zY().getValue("CustomEmojiMaxSize"), 150) : com.tencent.mm.bu.a.xbp.getInt("EmotionRecommandCount", 3))) {
                aVar.zEs.setVisibility(0);
                aVar.zEs.setText(h.lJM);
            } else {
                aVar.zEs.setVisibility(8);
            }
        } else {
            aVar.zEs.setVisibility(8);
            EmojiInfo oO = oO(i);
            if (oO == null) {
                x.w("MicroMsg.smiley.EmojiSmileyAdapter", "emoji is null.");
                aVar.jCP.setVisibility(8);
                aVar.iir.setVisibility(8);
                ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a("", aVar.jCP);
            } else {
                aVar.jCP.setVisibility(0);
                CharSequence xZ = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().xZ(oO.Nr());
                if (bh.ov(xZ) || this.zDl != 23) {
                    aVar.iir.setVisibility(8);
                } else {
                    aVar.iir.setText(xZ);
                    aVar.iir.setVisibility(0);
                }
                aVar.jCP.setBackgroundResource(com.tencent.mm.plugin.m.a.d.bGr);
                String name;
                String replaceAll;
                com.tencent.mm.aq.a.a aBe;
                com.tencent.mm.aq.a.a.c.a aVar3;
                com.tencent.mm.aq.a.a.c PK;
                if (this.zDl == 25) {
                    if (oO.field_catalog == EmojiGroupInfo.xAc || oO.field_catalog == EmojiInfo.xAj || oO.field_catalog == EmojiInfo.xAi) {
                        name = oO.getName();
                        if (bh.ov(name)) {
                            x.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                        } else {
                            replaceAll = name.replaceAll(".png", "");
                            aBe = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe();
                            ImageView imageView = aVar.jCP;
                            com.tencent.mm.aq.a.a.c.a aVar4 = new com.tencent.mm.aq.a.a.c.a();
                            aVar4.hDF = 3;
                            aVar4.hDT = com.tencent.mm.plugin.m.a.d.bGr;
                            aBe.a(replaceAll, imageView, aVar4.PK());
                            if (replaceAll.equalsIgnoreCase("dice")) {
                                aVar.jCP.setContentDescription(view.getContext().getString(h.lJK));
                            } else if (replaceAll.equalsIgnoreCase("jsb")) {
                                aVar.jCP.setContentDescription(view.getContext().getString(h.lJL));
                            }
                        }
                    } else {
                        replaceAll = oO.ckB();
                        name = replaceAll + "_cover";
                        aVar3 = new com.tencent.mm.aq.a.a.c.a();
                        aVar3.hDF = 1;
                        aVar3.hDT = com.tencent.mm.plugin.m.a.d.bGr;
                        aVar3.hDM = true;
                        aVar3.fvC = name;
                        aVar3.hDC = replaceAll;
                        aVar3.hDN = true;
                        aVar3.hEd = new Object[]{oO};
                        aVar3.hEc = true;
                        PK = aVar3.PK();
                        if (((com.tencent.mm.kernel.b.h) g.Dg().CN()).DS()) {
                            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a(replaceAll, aVar.jCP, PK, this.zEq, this.lBS, this.hEq);
                        } else {
                            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a(replaceAll, aVar.jCP, PK, null, this.lBS, this.hEq);
                        }
                    }
                } else if (!oO.field_groupId.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.xAb))) {
                    replaceAll = oO.ckB();
                    name = replaceAll + "_cover";
                    aVar3 = new com.tencent.mm.aq.a.a.c.a();
                    aVar3.hDF = 1;
                    aVar3.hDT = com.tencent.mm.plugin.m.a.d.bGr;
                    aVar3.hDM = true;
                    aVar3.fvC = name;
                    aVar3.hDC = replaceAll;
                    aVar3.hDN = true;
                    aVar3.hEd = new Object[]{oO};
                    aVar3.hEc = true;
                    PK = aVar3.PK();
                    if (((com.tencent.mm.kernel.b.h) g.Dg().CN()).DS()) {
                        ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a(replaceAll, aVar.jCP, PK, this.zEq, this.lBS, this.hEq);
                    } else {
                        ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a(replaceAll, aVar.jCP, PK, null, this.lBS, this.hEq);
                    }
                } else if (bh.ov(oO.getName())) {
                    x.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                } else {
                    replaceAll = (bh.ov(oO.we()) ? oO.getName() : oO.we()).replaceAll(".png", "");
                    aBe = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe();
                    ImageView imageView2 = aVar.jCP;
                    com.tencent.mm.aq.a.a.c.a aVar5 = new com.tencent.mm.aq.a.a.c.a();
                    aVar5.hDF = 3;
                    aVar5.hDT = com.tencent.mm.plugin.m.a.d.bGr;
                    aBe.a(replaceAll, imageView2, aVar5.PK());
                }
            }
        }
        return view;
    }
}
