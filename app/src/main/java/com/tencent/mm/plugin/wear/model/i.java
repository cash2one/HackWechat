package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ae.g$a;
import com.tencent.mm.ae.g.b;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;

public final class i {
    private g$a ftW = new 1(this);
    private b ftX = new 2(this);
    AudioManager gCe = ((AudioManager) ac.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    a tiB;
    BroadcastReceiver tiC = new BroadcastReceiver(this) {
        final /* synthetic */ i tiD;

        {
            this.tiD = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("state") && intent.getIntExtra("state", 2) == 0) {
                this.tiD.bOA();
            }
        }
    };

    public i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        ac.getContext().registerReceiver(this.tiC, intentFilter);
    }

    public final void bOA() {
        a(this.tiB);
    }

    private static a a(a aVar) {
        if (aVar != null) {
            aVar.mql.stop();
            aVar.mql.a(null);
            aVar.mql.a(null);
            aVar.tiE.clear();
        }
        return null;
    }

    final void b(a aVar) {
        while (aVar != null) {
            if (aVar.tiE.size() > 0) {
                au auVar = (au) aVar.tiE.getLast();
                aVar.tiE.removeLast();
                q.E(auVar);
                x.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[]{Long.valueOf(auVar.field_msgId), q.getFullPath(auVar.field_imgPath)});
                if (aVar.mql.a(q.getFullPath(auVar.field_imgPath), true, true, -1)) {
                    aVar.mql.a(this.ftW);
                    aVar.mql.a(this.ftX);
                    return;
                }
            }
            a(aVar);
            return;
        }
    }
}
