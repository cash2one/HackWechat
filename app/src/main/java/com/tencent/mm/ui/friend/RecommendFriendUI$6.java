package com.tencent.mm.ui.friend;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class RecommendFriendUI$6 implements OnClickListener {
    final /* synthetic */ RecommendFriendUI zdr;

    RecommendFriendUI$6(RecommendFriendUI recommendFriendUI) {
        this.zdr = recommendFriendUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zdr.finish();
    }
}
