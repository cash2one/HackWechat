package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.chatroom.ui.SelectDelRoomMemberUI.a;
import com.tencent.mm.sdk.platformtools.bh;

class SelectDelRoomMemberUI$4 implements OnItemClickListener {
    final /* synthetic */ SelectDelRoomMemberUI ldt;

    SelectDelRoomMemberUI$4(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        this.ldt = selectDelRoomMemberUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        SelectDelRoomMemberUI.b(this.ldt);
        af oh = a.oh(i);
        if (oh != null) {
            SelectDelRoomMemberUI.a(this.ldt, oh.field_username);
            String str = oh.field_nickname;
            String b = SelectDelRoomMemberUI.b(SelectDelRoomMemberUI.c(this.ldt), SelectDelRoomMemberUI.d(this.ldt));
            if (bh.ov(b)) {
                SelectDelRoomMemberUI.b(this.ldt, oh.AQ());
            } else {
                SelectDelRoomMemberUI.b(this.ldt, b);
            }
            SelectDelRoomMemberUI.a(this.ldt, SelectDelRoomMemberUI.d(this.ldt), SelectDelRoomMemberUI.e(this.ldt), str);
        }
    }
}
