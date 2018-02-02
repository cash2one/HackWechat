package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.l;

class FMessageConversationUI$3 implements OnItemLongClickListener {
    final /* synthetic */ l kBU;
    final /* synthetic */ FMessageConversationUI rXh;

    FMessageConversationUI$3(FMessageConversationUI fMessageConversationUI, l lVar) {
        this.rXh = fMessageConversationUI;
        this.kBU = lVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < FMessageConversationUI.b(this.rXh).getHeaderViewsCount()) {
            x.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
        } else {
            View view2 = view;
            this.kBU.a(view2, i - FMessageConversationUI.b(this.rXh).getHeaderViewsCount(), j, this.rXh, FMessageConversationUI.c(this.rXh));
        }
        return true;
    }
}
