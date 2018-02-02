package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

class RoomAnnouncementUI$2 extends p {
    final /* synthetic */ RoomAnnouncementUI lbs;

    RoomAnnouncementUI$2(RoomAnnouncementUI roomAnnouncementUI) {
        this.lbs = roomAnnouncementUI;
    }

    public final boolean b(WebView webView, String str) {
        if (!str.equals("weixin://chatroom/upgradeagree")) {
            return false;
        }
        a.a(this.lbs, RoomAnnouncementUI.b(this.lbs), RoomAnnouncementUI.c(this.lbs));
        return true;
    }
}
