package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ag.a.c;

class BizChatFavUI$3 implements OnItemClickListener {
    final /* synthetic */ BizChatFavUI ynN;

    BizChatFavUI$3(BizChatFavUI bizChatFavUI) {
        this.ynN = bizChatFavUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BizChatFavUI.b(this.ynN, ((c) BizChatFavUI.c(this.ynN).getItem(i)).field_bizChatLocalId);
    }
}
