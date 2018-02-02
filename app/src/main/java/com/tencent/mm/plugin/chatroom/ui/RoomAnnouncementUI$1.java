package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.ui.base.h;
import com.tencent.xweb.WebView;
import com.tencent.xweb.f;
import com.tencent.xweb.j;

class RoomAnnouncementUI$1 extends j {
    final /* synthetic */ RoomAnnouncementUI lbs;

    RoomAnnouncementUI$1(RoomAnnouncementUI roomAnnouncementUI) {
        this.lbs = roomAnnouncementUI;
    }

    public final boolean a(WebView webView, String str, String str2, f fVar) {
        h.a(this.lbs, str2, null, new 1(this));
        fVar.cancel();
        return true;
    }
}
