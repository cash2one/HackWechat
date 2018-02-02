package com.tencent.mm.ui.friend;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.protocal.c.wh;

class RecommendFriendUI$1 implements OnItemClickListener {
    final /* synthetic */ RecommendFriendUI zdr;

    RecommendFriendUI$1(RecommendFriendUI recommendFriendUI) {
        this.zdr = recommendFriendUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 0;
        if (RecommendFriendUI.a(this.zdr)) {
            RecommendFriendUI recommendFriendUI = this.zdr;
            b b = RecommendFriendUI.b(this.zdr);
            if (b.zcA) {
                i2 = ((wh) b.zcz.get(i)).wgF;
            }
            RecommendFriendUI.a(recommendFriendUI, i2);
            return;
        }
        RecommendFriendUI.b(this.zdr).jf(i);
        if (RecommendFriendUI.b(this.zdr).cwU().length > 0) {
            this.zdr.showOptionMenu(true);
        } else {
            this.zdr.showOptionMenu(false);
        }
    }
}
