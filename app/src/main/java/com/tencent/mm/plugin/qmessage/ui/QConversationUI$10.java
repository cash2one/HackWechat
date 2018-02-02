package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.i;

class QConversationUI$10 implements OnItemLongClickListener {
    final /* synthetic */ QConversationUI pnT;
    final /* synthetic */ i pnU;

    QConversationUI$10(QConversationUI qConversationUI, i iVar) {
        this.pnT = qConversationUI;
        this.pnU = iVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < QConversationUI.c(this.pnT).getHeaderViewsCount()) {
            x.w("MicroMsg.QConversationUI", "on header view long click, ignore");
            return true;
        }
        this.pnU.a(view, i, j, this.pnT, QConversationUI.d(this.pnT), 0, 0);
        return true;
    }
}
