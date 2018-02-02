package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.c;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.ui.v;
import java.util.LinkedList;

class EmojiStoreV2RewardUI$b extends BaseAdapter {
    final /* synthetic */ EmojiStoreV2RewardUI lGQ;
    LinkedList<sm> lGr;

    EmojiStoreV2RewardUI$b(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.lGQ = emojiStoreV2RewardUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return oT(i);
    }

    public final int getCount() {
        return this.lGr == null ? 0 : this.lGr.size();
    }

    public final sm oT(int i) {
        if (i < 0 || i > getCount() || this.lGr == null) {
            return null;
        }
        return (sm) this.lGr.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = v.fv(this.lGQ.mController.xIM).inflate(R.i.dfY, null);
            cVar = new c(this.lGQ, view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        sm oT = oT(i);
        if (oT != null) {
            cVar.lGV.setVisibility(0);
            cVar.lGV.setText(oT.waO + oT.njX);
        } else {
            cVar.lGV.setVisibility(8);
        }
        return view;
    }
}
