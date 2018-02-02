package com.tencent.mm.ui;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

class MultiTalkRoomPopupNav$a {
    private Button mkk;
    TextView titleView;
    final /* synthetic */ MultiTalkRoomPopupNav xLr;
    LinearLayout xLs;

    private MultiTalkRoomPopupNav$a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, boolean z) {
        this.xLr = multiTalkRoomPopupNav;
        this.mkk = (Button) multiTalkRoomPopupNav.findViewById(R.h.cxO);
        this.titleView = (TextView) multiTalkRoomPopupNav.findViewById(R.h.cya);
        this.xLs = (LinearLayout) multiTalkRoomPopupNav.findViewById(R.h.cxR);
        if (z) {
            this.xLs.setBackgroundResource(R.g.bDQ);
            this.mkk.setTextColor(multiTalkRoomPopupNav.getResources().getColor(R.e.btm));
            return;
        }
        this.xLs.setBackgroundResource(R.g.bDP);
        this.mkk.setTextColor(multiTalkRoomPopupNav.getResources().getColor(R.e.brF));
    }
}
