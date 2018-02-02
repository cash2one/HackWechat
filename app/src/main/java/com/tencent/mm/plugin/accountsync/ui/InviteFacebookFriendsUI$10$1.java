package com.tencent.mm.plugin.accountsync.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ay.i;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.q;
import com.tencent.mm.plugin.accountsync.ui.InviteFacebookFriendsUI.10;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

class InviteFacebookFriendsUI$10$1 implements a {
    final /* synthetic */ long[] ilu;
    final /* synthetic */ 10 ilv;

    InviteFacebookFriendsUI$10$1(10 10, long[] jArr) {
        this.ilv = 10;
        this.ilu = jArr;
    }

    public final void a(d dVar) {
        x.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
    }

    public final void a(b bVar) {
        x.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
    }

    public final void k(Bundle bundle) {
        x.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
        List arrayList = new ArrayList();
        arrayList.add(new i.a(33, Integer.toString(this.ilu.length)));
        ar.Hg();
        c.EX().b(new i(arrayList));
        for (long j : this.ilu) {
            q qVar = new q();
            qVar.username = Long.toString(j);
            qVar.hwn = 5;
            qVar.hpd = (int) bh.Wo();
            af.OH().a(qVar);
        }
        h.a(this.ilv.ilq, R.l.eep, R.l.dGO, R.l.dHd, R.l.dFR, new 1(this), new OnClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI$10$1 ilw;

            {
                this.ilw = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.ilw.ilv.ilq.finish();
            }
        });
    }

    public final void onCancel() {
        x.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
    }
}
