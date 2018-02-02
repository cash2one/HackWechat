package com.tencent.mm.view.a;

import android.view.View;
import com.tencent.mm.plugin.m.a$e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.view.SmileySubGrid;
import com.tencent.mm.view.a.d.1;
import com.tencent.mm.view.f.a.a;

class d$a {
    RecommendView zEw;
    SmileySubGrid zEx;
    final /* synthetic */ d zEy;

    public d$a(d dVar, View view, a aVar) {
        this.zEy = dVar;
        switch (1.zEv[aVar.ordinal()]) {
            case 1:
                this.zEw = (RecommendView) view;
                return;
            case 2:
            case 3:
                this.zEx = (SmileySubGrid) view.findViewById(a$e.lJt);
                return;
            default:
                return;
        }
    }
}
