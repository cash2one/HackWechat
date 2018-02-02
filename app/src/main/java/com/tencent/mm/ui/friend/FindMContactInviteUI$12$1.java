package com.tencent.mm.ui.friend;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ui.friend.FindMContactInviteUI.12;
import com.tencent.mm.z.ar;

class FindMContactInviteUI$12$1 implements e {
    final /* synthetic */ 12 zcy;

    FindMContactInviteUI$12$1(12 12) {
        this.zcy = 12;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (FindMContactInviteUI.a(this.zcy.zcx) != null) {
            FindMContactInviteUI.a(this.zcy.zcx).dismiss();
            FindMContactInviteUI.a(this.zcy.zcx, null);
        }
        if (FindMContactInviteUI.k(this.zcy.zcx) != null) {
            ar.CG().b(432, FindMContactInviteUI.k(this.zcy.zcx));
            FindMContactInviteUI.a(this.zcy.zcx, null);
        }
        FindMContactInviteUI.l(this.zcy.zcx);
    }
}
