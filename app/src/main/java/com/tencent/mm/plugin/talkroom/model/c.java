package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.plugin.talkroom.a;
import com.tencent.mm.pluginsdk.q.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c implements o {
    af mHandler = new af(Looper.getMainLooper());
    public String nTT = "";
    public boolean nUw = false;
    public boolean sbb = false;
    private Notification sbc;
    private String sbd;

    private static boolean bEG() {
        if (!bh.ov(b.bEC().sbR)) {
            return true;
        }
        x.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
        x.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        bEI();
        return false;
    }

    public final void aWb() {
        this.nUw = false;
    }

    public final void J(String str, int i, int i2) {
        this.nUw = false;
    }

    public final void aWc() {
    }

    public final void rN(int i) {
    }

    public final void DM(String str) {
        this.nTT = str;
    }

    public final void df(String str, String str2) {
        if (!this.sbb) {
            bEH();
        }
    }

    public final void j(int i, int i2, String str) {
    }

    public final void aWd() {
        x.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        bEI();
    }

    public final void aWe() {
    }

    public final void aWf() {
    }

    public final void aWg() {
    }

    public final void Mp(String str) {
        if (bEG()) {
            x.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: " + str);
            this.sbd = str;
            this.sbc = new Builder(ac.getContext()).setTicker(str).setWhen(0).getNotification();
            this.sbc.icon = R.g.bGM;
            this.sbc.flags = 32;
            bEH();
        }
    }

    private void bEH() {
        if (!bEG()) {
            return;
        }
        if (this.sbc == null) {
            x.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
            return;
        }
        CharSequence string;
        CharSequence aA = h.aA(ac.getContext(), b.bEC().sbR);
        if (b.bEC().scf) {
            string = ac.getContext().getString(R.l.eQH);
        } else {
            string = ac.getContext().getString(R.l.eQE, new Object[]{Integer.valueOf(b.bEC().aVC().size())});
        }
        Intent uq = a.ift.uq();
        uq.putExtra("enter_chat_usrname", b.bEC().sbR);
        this.sbc = new Builder(ac.getContext()).setTicker(this.sbd).setWhen(0).setContentTitle(aA).setContentText(string).setContentIntent(PendingIntent.getActivity(ac.getContext(), 100, uq, SQLiteDatabase.CREATE_IF_NECESSARY)).getNotification();
        this.sbc.icon = R.g.bGM;
        this.sbc.flags = 32;
        ar.getNotification().a(100, this.sbc, false);
    }

    public static void bEI() {
        x.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
        ar.getNotification().cancel(100);
    }
}
