package com.tencent.mm.plugin.music.model.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.av.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.g.c;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$2 extends BroadcastReceiver {
    final /* synthetic */ a oLX;

    a$2(a aVar) {
        this.oLX = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && !bh.ov(intent.getAction())) {
            String stringExtra = intent.getStringExtra("mm_music_notification_action_key");
            if (bh.ov(stringExtra)) {
                x.e("MicroMsg.Music.MMMusicNotification", "action is null, err, return");
                return;
            }
            x.i("MicroMsg.Music.MMMusicNotification", "action:%s", stringExtra);
            c bdn = h.bdz().bdn();
            if (bdn == null) {
                x.e("MicroMsg.Music.MMMusicNotification", "musicPlayer is null, return");
                return;
            }
            a bdo = h.bdz().bdo();
            if (bdo == null) {
                x.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
            } else if (stringExtra.equals("mm_music_notification_action_play")) {
                bdn.resume();
                f.a(2, bdo);
            } else if (stringExtra.equals("mm_music_notification_action_pause")) {
                bdn.bdN();
                h.bdC().bdl();
                f.a(3, bdo);
            } else if (stringExtra.equals("mm_music_notification_action_pre")) {
                if (bdo.field_musicType == 11) {
                    h.bdz().bds();
                } else if (h.bdz().mode == 2) {
                    e bdz = h.bdz();
                    if (bdz.mode != 1) {
                        bdz.oJA = (bdz.oJA + bdz.oJB.size()) - 1;
                        bdz.oJA %= bdz.oJB.size();
                        bdz.bds();
                        bdz.e(null);
                    }
                } else {
                    bdn.if(0);
                    bdn.resume();
                }
                a.a(bdo, 13, bdn.bdP());
                f.a(1, bdo);
            } else if (stringExtra.equals("mm_music_notification_action_next")) {
                if (bdo.field_musicType == 11) {
                    h.bdz().bds();
                } else if (h.bdz().mode == 2) {
                    h.bdz().bdr();
                } else {
                    bdn.if(0);
                    bdn.resume();
                }
                a.a(bdo, 14, bdn.bdP());
                f.a(4, bdo);
            } else if (stringExtra.equals("mm_music_notification_action_close")) {
                ag.y(this.oLX.oLV);
                bdn.stopPlay();
                f.a(5, bdo);
            }
        }
    }
}
