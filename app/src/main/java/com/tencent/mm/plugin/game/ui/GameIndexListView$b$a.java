package com.tencent.mm.plugin.game.ui;

import android.support.v7.widget.RecyclerView$t;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.game.ui.GameIndexListView.b;

public class GameIndexListView$b$a extends RecyclerView$t {
    public View contentView;
    final /* synthetic */ b nrl;

    public GameIndexListView$b$a(b bVar, View view) {
        this.nrl = bVar;
        super(view);
        this.contentView = ((ViewGroup) view).getChildAt(0);
    }
}
