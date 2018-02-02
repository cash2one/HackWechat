package com.tencent.mm.plugin.notification.d;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;

public final class d extends a<au> {
    private c oUq = new 1(this);
    private c oUr = new 2(this);

    static /* synthetic */ boolean GN(String str) {
        return !(x.Wx(str) || x.Wz(str)) || x.gy(str);
    }

    protected final /* bridge */ /* synthetic */ long bD(Object obj) {
        return ((au) obj).field_msgId;
    }

    protected final /* synthetic */ ArrayList bE(Object obj) {
        return f.U((au) obj);
    }

    public final void bgC() {
        com.tencent.mm.sdk.b.a.xef.b(this.oUq);
    }

    public final void bgD() {
        com.tencent.mm.sdk.b.a.xef.b(this.oUr);
    }

    public final void dT(long j) {
        ar.Hg();
        ag.y(new 3(this, j, com.tencent.mm.z.c.Fa().dH(j)));
    }

    public final void bgE() {
        com.tencent.mm.sdk.b.a.xef.c(this.oUq);
    }

    public final void bgF() {
        com.tencent.mm.sdk.b.a.xef.c(this.oUr);
    }

    protected final void bgx() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[]{Integer.valueOf(this.oTZ.oUk.size())});
        if (this.oTZ.oUk.size() > 1) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (VERSION.SDK_INT < 16) {
                intent.putExtra("resend_fail_messages", true);
            }
            intent.putExtra("From_fail_notify", true);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
            com.tencent.mm.bm.d.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
        } else if (this.oTZ.oUk.size() == 1) {
            long j = this.oTZ.get(0);
            ar.Hg();
            String str = com.tencent.mm.z.c.Fa().dH(j).field_talker;
            Intent intent2 = new Intent();
            intent2.putExtra("Main_User", str);
            intent2.putExtra("From_fail_notify", true);
            intent2.addFlags(67108864);
            intent2.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (VERSION.SDK_INT < 16) {
                intent2.putExtra("resend_fail_messages", true);
            }
            com.tencent.mm.bm.d.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent2);
        }
    }

    protected final int getType() {
        return 1;
    }

    protected final void K(ArrayList<Long> arrayList) {
        ar.Hg();
        com.tencent.mm.z.c.Fa().G(arrayList);
    }

    protected final String ui(int i) {
        return this.mContext.getString(R.l.eyu, new Object[]{Integer.valueOf(i)});
    }

    protected final String cZ(int i, int i2) {
        return this.mContext.getString(R.l.eza, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    protected final String U(int i, int i2, int i3) {
        return this.mContext.getString(R.l.ezb, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
    }

    protected final String da(int i, int i2) {
        if (i2 <= 0) {
            return this.mContext.getString(R.l.eyY, new Object[]{Integer.valueOf(i)});
        }
        return this.mContext.getString(R.l.eyX, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean dU(long j) {
        ar.Hg();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[]{Long.valueOf(j), Long.valueOf(com.tencent.mm.z.c.Fa().dH(j).field_msgId)});
        if (com.tencent.mm.z.c.Fa().dH(j).field_msgId != 0) {
            return true;
        }
        return false;
    }
}
