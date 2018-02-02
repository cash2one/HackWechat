package com.tencent.mm.modelsimple;

import android.content.Intent;
import com.tencent.mm.modelsimple.o.1.1;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.wcdb.database.SQLiteDatabase;

class o$1$1$1 implements Runnable {
    final /* synthetic */ 1 hNf;

    o$1$1$1(1 1) {
        this.hNf = 1;
    }

    public final void run() {
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony[%b]", new Object[]{Boolean.valueOf(ac.cfp())});
        Intent intent = new Intent();
        intent.putExtra("key_disaster_content", this.hNf.hNc);
        intent.putExtra("key_disaster_url", this.hNf.hNd);
        intent.setClass(ac.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        ac.getContext().startActivity(intent);
    }
}
