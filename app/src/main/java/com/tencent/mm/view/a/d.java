package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.view.SmileyGrid;
import com.tencent.mm.view.f.a;

public final class d extends y {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter";
    private Context mContext;
    public int mCount;
    private a zDs;
    public boolean zEt;
    private View zEu;

    public d(a aVar, Context context) {
        this.mContext = context;
        this.zDs = aVar;
    }

    public final View d(int i, View view) {
        a aVar;
        com.tencent.mm.view.c.a Hx = this.zDs.Hx(i);
        String str = Hx.lyH;
        a.a aVar2 = "TAG_DEFAULT_TAB".equals(str) ? a.a.zGY : (String.valueOf(EmojiGroupInfo.xAc).equals(str) || String.valueOf(EmojiGroupInfo.xAb).equals(str)) ? a.a.zGZ : !Hx.zFT ? a.a.zGX : a.a.zGZ;
        if (view == null || view.getTag() == null || view.getTag(e.lJu) != aVar2) {
            View h;
            switch (1.zEv[aVar2.ordinal()]) {
                case 1:
                    h = com.tencent.mm.pluginsdk.ui.chat.e.vrp.h(this.mContext, this.zDs.cBc());
                    break;
                default:
                    h = LayoutInflater.from(this.mContext).inflate(f.lJE, null);
                    break;
            }
            a aVar3 = new a(this, h, aVar2);
            h.setTag(aVar3);
            h.setTag(e.lJu, aVar2);
            aVar = aVar3;
            view = h;
        } else {
            a aVar4 = (a) view.getTag();
            view.setTag(e.lJu, aVar2);
            aVar = aVar4;
        }
        int i2;
        switch (1.zEv[aVar2.ordinal()]) {
            case 1:
                aVar.zEw.yN(Hx.lyH);
                break;
            case 2:
                ChatFooterPanel.a aVar5;
                b bVar = new b(this.mContext, this.zDs);
                aVar.zEx.setAdapter(bVar);
                aVar.zEx.cAm();
                aVar.zEx.vrG = Hx.cAo();
                SmileyGrid smileyGrid = aVar.zEx;
                com.tencent.mm.view.e.a aVar6 = Hx.zFQ;
                if (aVar6.zGk == null) {
                    aVar5 = null;
                } else {
                    aVar5 = aVar6.zGk.cAn();
                }
                smileyGrid.zDo = aVar5;
                aVar.zEx.setNumColumns(Hx.tfS);
                aVar.zEx.setColumnWidth(Hx.getColumnWidth());
                aVar.zEx.setScrollbarFadingEnabled(false);
                aVar.zEx.setVerticalScrollBarEnabled(false);
                aVar.zEx.setSelector(com.tencent.mm.plugin.m.a.d.bDJ);
                aVar.zEx.setHorizontalScrollBarEnabled(false);
                aVar.zEx.setVerticalScrollBarEnabled(false);
                aVar.zEx.setLongClickable(false);
                aVar.zEx.cAm();
                i2 = this.zDs.aas(Hx.lyH).zFS;
                aVar.zEx.setPadding(0, i2 == 0 ? this.zDs.zGD : i2, 0, 0);
                aVar.zEx.setVerticalSpacing(i2 / 2);
                aVar.zEx.j(Hx.getType(), i - Hx.kaM, Hx.zFR, Hx.ant(), Hx.cAJ());
                aVar.zEx.zEh = false;
                aVar.zEx.irz = this.zDs.irz;
                bVar.c(Hx.getType(), Hx.zFR, Hx.ant(), Hx.cAJ(), i - Hx.kaM, Hx.tfR, Hx.tfS);
                bVar.zEn = Hx.lyH;
                break;
            case 3:
                c cVar = new c(this.mContext, this.zDs);
                aVar.zEx.setAdapter(cVar);
                aVar.zEx.cAm();
                aVar.zEx.setNumColumns(Hx.tfS);
                aVar.zEx.setColumnWidth(Hx.getColumnWidth());
                aVar.zEx.setScrollbarFadingEnabled(false);
                aVar.zEx.setHorizontalScrollBarEnabled(false);
                aVar.zEx.setVerticalScrollBarEnabled(false);
                aVar.zEx.vrG = Hx.cAo();
                aVar.zEx.setFastScrollEnabled(false);
                aVar.zEx.zEb = Hx.zFQ.zFZ;
                aVar.zEx.cAm();
                i2 = this.zDs.aas(Hx.lyH).zFS;
                aVar.zEx.setPadding(0, i2 == 0 ? this.zDs.zGD : i2, 0, 0);
                aVar.zEx.setVerticalSpacing(i2 / 2);
                aVar.zEx.zEh = true;
                aVar.zEx.irz = this.zDs.irz;
                aVar.zEx.j(Hx.getType(), i - Hx.kaM, Hx.zFR, Hx.ant(), Hx.cAJ());
                cVar.c(Hx.getType(), Hx.zFR, Hx.tfS * Hx.tfR, Hx.cAJ(), i - Hx.kaM, Hx.tfR, Hx.tfS);
                cVar.zEn = Hx.lyH;
                if (cVar.zDl != 23) {
                    if (cVar.zDl == 25) {
                        cVar.lDO = ((c) g.k(c.class)).getProvider().aBd();
                        break;
                    }
                }
                cVar.lDO = ((c) g.k(c.class)).getProvider().yn(cVar.zEn);
                break;
                break;
        }
        this.zEu = view;
        return view;
    }

    public final int getCount() {
        return this.mCount;
    }

    public final int k(Object obj) {
        if (!this.zEt) {
            return super.k(obj);
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "get item position always changed");
        return -2;
    }

    public final void cAr() {
        a aVar = this.zDs;
        this.mCount = aVar.zGG ? aVar.aas("TAG_DEFAULT_TAB").cAJ() : aVar.mNk;
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "refresh data mCount:%d", Integer.valueOf(this.mCount));
    }
}
