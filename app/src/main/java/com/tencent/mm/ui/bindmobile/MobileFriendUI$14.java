package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.ui.friend.InviteFriendUI;

class MobileFriendUI$14 implements OnItemClickListener {
    final /* synthetic */ MobileFriendUI ymF;

    MobileFriendUI$14(MobileFriendUI mobileFriendUI) {
        this.ymF = mobileFriendUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= MobileFriendUI.f(this.ymF).getHeaderViewsCount()) {
            b bVar = (b) MobileFriendUI.d(this.ymF).getItem(i - MobileFriendUI.f(this.ymF).getHeaderViewsCount());
            if (bVar.status == 1 || bVar.status == 2) {
                this.ymF.b(bVar);
            }
            if (bVar.status == 0) {
                Intent intent = new Intent(this.ymF, InviteFriendUI.class);
                intent.putExtra("friend_type", 1);
                intent.putExtra("friend_user_name", bVar.getUsername());
                intent.putExtra("friend_num", bVar.Nz());
                intent.putExtra("friend_nick", bVar.Nt());
                intent.putExtra("friend_weixin_nick", bVar.Nw());
                intent.putExtra("friend_scene", 13);
                this.ymF.startActivity(intent);
            }
        }
    }
}
