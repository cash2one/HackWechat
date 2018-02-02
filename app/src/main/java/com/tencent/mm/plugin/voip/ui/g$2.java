package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

class g$2 implements OnClickListener {
    final /* synthetic */ g ssx;
    final /* synthetic */ Intent val$intent;

    g$2(g gVar, Intent intent) {
        this.ssx = gVar;
        this.val$intent = intent;
    }

    public final void onClick(View view) {
        this.val$intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        ac.getContext().startActivity(this.val$intent);
        view.setOnClickListener(null);
        g.a(this.ssx, new ak(new a(this) {
            final /* synthetic */ g$2 ssy;

            {
                this.ssy = r1;
            }

            public final boolean uF() {
                x.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
                this.ssy.ssx.dismiss();
                if (g.a(this.ssy.ssx) != null) {
                    g.a(this.ssy.ssx).TG();
                }
                return true;
            }
        }, false));
        g.a(this.ssx).J(2000, 2000);
    }
}
