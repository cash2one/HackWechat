package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.l;

class BizChatFavUI$2 implements OnItemLongClickListener {
    final /* synthetic */ l kBU;
    final /* synthetic */ BizChatFavUI ynN;

    BizChatFavUI$2(BizChatFavUI bizChatFavUI, l lVar) {
        this.ynN = bizChatFavUI;
        this.kBU = lVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < BizChatFavUI.e(this.ynN).getHeaderViewsCount()) {
            x.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
        } else {
            this.kBU.a(view, i, j, this.ynN, BizChatFavUI.g(this.ynN));
        }
        return true;
    }
}
