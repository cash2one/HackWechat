package com.tencent.mm.view.c;

import com.tencent.mm.bx.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelInfo";
    public int kaM;
    public String lyH;
    public int tfR;
    public int tfS;
    public com.tencent.mm.view.f.a zDs;
    public com.tencent.mm.view.e.a zFQ;
    public int zFR;
    public int zFS;
    public boolean zFT = false;
    public int zFU;

    public a(EmojiGroupInfo emojiGroupInfo, int i, int i2, com.tencent.mm.view.f.a aVar, com.tencent.mm.view.e.a aVar2, boolean z) {
        if (emojiGroupInfo == null || bh.ov(emojiGroupInfo.field_productID)) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "catch invalid Smiley Tab want add??!!");
            return;
        }
        this.zFQ = aVar2;
        this.zDs = aVar;
        this.lyH = emojiGroupInfo.field_productID;
        this.kaM = i;
        this.zFU = i2;
        if (z || emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.xAb))) {
            int anm;
            com.tencent.mm.view.f.a aVar3;
            String str;
            com.tencent.mm.view.f.a aVar4 = this.zDs;
            if (emojiGroupInfo != null) {
                int ym;
                if (emojiGroupInfo.field_productID.equals("TAG_DEFAULT_TAB")) {
                    anm = e.chc().anm();
                } else if (emojiGroupInfo.field_productID.equals(String.valueOf(EmojiGroupInfo.xAc))) {
                    anm = com.tencent.mm.view.f.a.isSDCardAvailable() ? ((c) g.k(c.class)).getProvider().aBa() + 1 : 0;
                } else if (emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.xAb))) {
                    anm = com.tencent.mm.view.f.a.isSDCardAvailable() ? 16 : 0;
                } else if (com.tencent.mm.view.f.a.d(emojiGroupInfo)) {
                    anm = 1;
                    if (emojiGroupInfo != null) {
                        if (emojiGroupInfo.field_count > 0) {
                            anm = emojiGroupInfo.field_count;
                        } else {
                            ym = ((c) g.k(c.class)).getProvider().ym(emojiGroupInfo.field_productID);
                            emojiGroupInfo.field_count = ym;
                            long currentTimeMillis = System.currentTimeMillis();
                            ((c) g.k(c.class)).getProvider().a(emojiGroupInfo);
                            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            anm = ym;
                        }
                    }
                    if (anm == 0) {
                        anm = 1;
                    }
                    if (!com.tencent.mm.view.f.a.isSDCardAvailable()) {
                        anm = 0;
                    }
                }
                if (aVar4.zGH) {
                    anm--;
                }
                this.zFR = anm;
                aVar3 = this.zDs;
                str = this.lyH;
                if (aVar3.kbf > 0 || bh.ov(str)) {
                    anm = 1;
                } else if (str.equals("TAG_STORE_TAB")) {
                    anm = 1;
                } else {
                    ym = aVar3.kbf / aVar3.aaq(str);
                    anm = bh.ov(str) ? 0 : str.equals("TAG_DEFAULT_TAB") ? 3 : 2;
                    if (ym <= anm) {
                        anm = ym;
                    }
                    if (anm <= 0) {
                        anm = 1;
                    }
                }
                this.tfR = anm;
                this.tfS = this.zDs.aat(this.lyH);
                this.zFS = this.zDs.dA(this.lyH, this.tfR);
            }
            anm = 1;
            if (aVar4.zGH) {
                anm--;
            }
            this.zFR = anm;
            aVar3 = this.zDs;
            str = this.lyH;
            if (aVar3.kbf > 0) {
            }
            anm = 1;
            this.tfR = anm;
            this.tfS = this.zDs.aat(this.lyH);
            this.zFS = this.zDs.dA(this.lyH, this.tfR);
        } else {
            this.zFR = 1;
            this.tfR = 1;
            this.tfS = 1;
            this.zFS = this.zDs.dA(this.lyH, this.tfR);
        }
        this.zFT = z;
        x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "smiley panel tab: productId: %s, startIndex: %d mAllEmojiNums: %d mRow:%d mCol:%d mSpacing:%d ", new Object[]{this.lyH, Integer.valueOf(i), Integer.valueOf(this.zFR), Integer.valueOf(this.tfR), Integer.valueOf(this.tfS), Integer.valueOf(this.zFS)});
    }

    public final int getType() {
        String str = this.lyH;
        if (str.equals("TAG_DEFAULT_TAB")) {
            return 20;
        }
        return str.equals(String.valueOf(EmojiGroupInfo.xAc)) ? 25 : 23;
    }

    public final int ant() {
        return this.tfR * this.tfS;
    }

    public final int cAJ() {
        if (ant() <= 0) {
            return 0;
        }
        if ("TAG_DEFAULT_TAB".equals(this.lyH)) {
            return (int) Math.ceil(((double) this.zFR) / ((double) (ant() - 1)));
        }
        return (int) Math.ceil(((double) this.zFR) / ((double) ant()));
    }

    public final int getColumnWidth() {
        return this.zDs.cAT() / (this.zDs.cAT() / this.zDs.zGw);
    }

    public final j cAo() {
        com.tencent.mm.view.e.a aVar = this.zFQ;
        return aVar.zGk == null ? null : aVar.zGk.cAo();
    }
}
