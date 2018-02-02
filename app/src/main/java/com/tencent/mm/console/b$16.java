package com.tencent.mm.console;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.k;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.z.ar;

class b$16 implements OnClickListener {
    final /* synthetic */ String gIE;
    final /* synthetic */ Context gIm;
    final /* synthetic */ Activity oZ;

    b$16(String str, Context context, Activity activity) {
        this.gIE = str;
        this.gIm = context;
        this.oZ = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        s sVar = new s(w.gZK + "SdcardInfo.cfg");
        sVar.set(1, this.gIE);
        x.i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + sVar.get(1));
        ae.Vd("welcome_page_show");
        k.e(this.gIm, true);
        b yVar = new y();
        yVar.fnQ.fnR = false;
        a.xef.m(yVar);
        WorkerProfile.uu().fgy.up();
        ar.getNotification().wY();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        ac.getContext().sendBroadcast(intent);
        if (q$a.vcr != null) {
            q$a.vcr.ar(this.oZ);
        }
        this.oZ.finish();
    }
}
