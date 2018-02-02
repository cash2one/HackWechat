package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

class EmojiStoreDetailUI$b extends a {
    final /* synthetic */ EmojiStoreDetailUI lDM;
    private ArrayList<EmojiInfo> lDO;

    public final /* synthetic */ Object getItem(int i) {
        return oO(i);
    }

    public EmojiStoreDetailUI$b(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
        super(emojiStoreDetailUI);
        this.lDO = new ArrayList();
        this.lDO = (ArrayList) i.aBE().lwL.ye(com.tencent.mm.plugin.emoji.h.a.aDB());
    }

    public final int getCount() {
        return this.lDO == null ? 0 : this.lDO.size();
    }

    private EmojiInfo oO(int i) {
        return this.lDO == null ? null : (EmojiInfo) this.lDO.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        EmojiStoreDetailUI$c emojiStoreDetailUI$c;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(EmojiStoreDetailUI.p(this.lDM)).inflate(R.i.dfJ, null);
            emojiStoreDetailUI$c = new EmojiStoreDetailUI$c(this.lDM, view);
            view.setTag(emojiStoreDetailUI$c);
        } else {
            emojiStoreDetailUI$c = (EmojiStoreDetailUI$c) view.getTag();
        }
        emojiStoreDetailUI$c.lDP.setBackgroundResource(R.g.bGr);
        EmojiInfo oO = oO(i);
        o.PA().a((bh.ov(oO.we()) ? oO.getName() : oO.we()).split("\\.")[0], emojiStoreDetailUI$c.lDP, f.aAT());
        return view;
    }
}
