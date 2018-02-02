package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.chatroom.ui.SeeRoomMemberUI.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.u;

class SeeRoomMemberUI$7 implements OnItemClickListener {
    final /* synthetic */ SeeRoomMemberUI lde;

    SeeRoomMemberUI$7(SeeRoomMemberUI seeRoomMemberUI) {
        this.lde = seeRoomMemberUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a og = SeeRoomMemberUI.c(this.lde).og(i);
        if (og.type == 2) {
            x.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
            g.pQN.a(219, 6, 1, true);
            SeeRoomMemberUI.d(this.lde);
        } else if (og.type == 3) {
            x.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
            SeeRoomMemberUI.e(this.lde);
        } else if (og.type == 1) {
            af afVar = SeeRoomMemberUI.c(this.lde).og(i).jLe;
            if (afVar == null) {
                x.e("MicroMsg.SeeRoomMemberUI", "cont is null");
                return;
            }
            SeeRoomMemberUI.a(this.lde, afVar.field_username);
            String str = afVar.field_nickname;
            String a = SeeRoomMemberUI.a(SeeRoomMemberUI.f(this.lde), SeeRoomMemberUI.g(this.lde));
            if (bh.ov(a)) {
                SeeRoomMemberUI.b(this.lde, afVar.AQ());
            } else {
                SeeRoomMemberUI.b(this.lde, a);
            }
            u.l(SeeRoomMemberUI.h(this.lde).getText().toString(), 1, 6, i + 1);
            SeeRoomMemberUI.a(this.lde, SeeRoomMemberUI.g(this.lde), SeeRoomMemberUI.i(this.lde), str);
        }
    }
}
