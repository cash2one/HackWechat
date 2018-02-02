package com.tencent.mm.ui.bindgooglecontact;

import com.tencent.mm.modelfriend.o;
import com.tencent.mm.ui.base.h$d;
import java.util.ArrayList;

class GoogleFriendUI$4 implements h$d {
    final /* synthetic */ GoogleFriendUI ykV;
    final /* synthetic */ ArrayList ykW;
    final /* synthetic */ o ykX;

    GoogleFriendUI$4(GoogleFriendUI googleFriendUI, ArrayList arrayList, o oVar) {
        this.ykV = googleFriendUI;
        this.ykW = arrayList;
        this.ykX = oVar;
    }

    public final void cn(int i, int i2) {
        if (i2 != -1) {
            GoogleFriendUI.a(this.ykV, (o) this.ykW.get(i2), this.ykX);
        }
    }
}
