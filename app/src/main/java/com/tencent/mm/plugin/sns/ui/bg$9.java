package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.a;
import com.tencent.wcdb.database.SQLiteDatabase;

class bg$9 implements OnClickListener {
    final /* synthetic */ bg rMH;

    bg$9(bg bgVar) {
        this.rMH = bgVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof bd) {
            bd bdVar = (bd) view.getTag();
            if (bh.ov(bdVar.rMd)) {
                x.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
                Toast.makeText(this.rMH.context, this.rMH.context.getString(j.ejg, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                return;
            }
            g.Dk();
            af WO = ((h) g.h(h.class)).EY().WO(bdVar.rMd);
            if (WO == null || !WO.field_username.equals(bdVar.rMd)) {
                a.hfL.a(bdVar.rMd, "", new 1(this));
                bg bgVar = this.rMH;
                Context context = this.rMH.context;
                this.rMH.context.getString(j.dGO);
                bgVar.tipDialog = com.tencent.mm.ui.base.h.a(context, this.rMH.context.getString(j.dHc), true, new 2(this, bdVar));
                return;
            }
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", bdVar.rMd);
            com.tencent.mm.plugin.report.service.g.pQN.k(10298, bdVar.rMd + ",37");
            intent.putExtra("Contact_Scene", 37);
            com.tencent.mm.plugin.sns.c.a.ifs.d(intent, this.rMH.context);
        }
    }
}
