package com.tencent.mm.ui.chatting.b;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class f$6 implements OnMenuItemClickListener {
    final /* synthetic */ f yzA;

    f$6(f fVar) {
        this.yzA = fVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        b spVar = new sp();
        spVar.fKq.fuL = 5;
        spVar.fKq.talker = this.yzA.fhr.csi().field_username;
        spVar.fKq.context = this.yzA.fhr.csq().getContext();
        if (menuItem.getItemId() == 1) {
            spVar.fKq.fKl = 4;
        } else if (menuItem.getItemId() == 2) {
            spVar.fKq.fKl = 2;
        }
        a.xef.m(spVar);
        return true;
    }
}
