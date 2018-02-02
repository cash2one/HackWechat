package com.tencent.mm.plugin.chatroom.a;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.tencent.mm.plugin.chatroom.ui.b;
import com.tencent.mm.plugin.chatroom.ui.b$a;

public class b$b extends t {
    final b kZi;

    public b$b(View view, b$a com_tencent_mm_plugin_chatroom_ui_b_a) {
        super(view);
        this.kZi = (b) view;
        this.kZi.setLayoutParams(new LayoutParams(-1, -1));
        this.kZi.setClickable(true);
        this.kZi.leQ = com_tencent_mm_plugin_chatroom_ui_b_a;
    }
}
