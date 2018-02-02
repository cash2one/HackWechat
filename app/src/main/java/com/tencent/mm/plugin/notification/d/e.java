package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class e extends a<c> {
    private c oUx = new c<qd>(this) {
        final /* synthetic */ e oUz;

        {
            this.oUz = r2;
            this.xen = qd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ag.y(new 1(this, (qd) bVar));
            return false;
        }
    };
    private c oUy = new c<qc>(this) {
        final /* synthetic */ e oUz;

        {
            this.oUz = r2;
            this.xen = qc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final qc qcVar = (qc) bVar;
            ag.y(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 oUD;

                public final void run() {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(589825, Boolean.valueOf(true));
                    qc qcVar = qcVar;
                    c cVar = new c();
                    cVar.id = qcVar.fHK.fHL;
                    this.oUD.oUz.bB(cVar);
                }
            });
            return false;
        }
    };

    protected final /* bridge */ /* synthetic */ long bD(Object obj) {
        return ((c) obj).id;
    }

    protected final /* synthetic */ ArrayList bE(Object obj) {
        ArrayList buh = n.qQE.buh();
        if (buh.size() == 0) {
            x.e("MicroMsg.SendSnsFailNotification", "getAllFailMsgFromDb, resendList is empty");
        }
        return buh;
    }

    protected final void bgx() {
        List runningTasks = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            if (componentName != null) {
                x.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", componentName.getClassName());
                if (componentName.getClassName().contains("SnsTimeLineUI")) {
                    x.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
                    return;
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("sns_resume_state", false);
        intent.putExtra("sns_timeline_NeedFirstLoadint", true);
        intent.putExtra("preferred_tab", 2);
        if (VERSION.SDK_INT < 16) {
            intent.putExtra("is_need_resend_sns", true);
        }
        intent.putExtra("From_fail_notify", true);
        intent.putExtra("jump_sns_from_notify", true);
        intent.addFlags(67108864);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        d.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
    }

    protected final int getType() {
        return 2;
    }

    protected final void K(ArrayList<Long> arrayList) {
        b kuVar = new ku();
        kuVar.fCd.fxf = arrayList;
        com.tencent.mm.sdk.b.a.xef.m(kuVar);
    }

    public final void bgC() {
        com.tencent.mm.sdk.b.a.xef.b(this.oUy);
    }

    public final void bgD() {
        com.tencent.mm.sdk.b.a.xef.b(this.oUx);
    }

    public final void dT(long j) {
        ag.y(new 3(this, j));
    }

    public final void bgE() {
        com.tencent.mm.sdk.b.a.xef.c(this.oUy);
    }

    public final void bgF() {
        com.tencent.mm.sdk.b.a.xef.c(this.oUx);
    }

    protected final String ui(int i) {
        return this.mContext.getString(R.l.eyv, new Object[]{Integer.valueOf(i)});
    }

    protected final String cZ(int i, int i2) {
        return this.mContext.getString(R.l.ezc, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    protected final String U(int i, int i2, int i3) {
        return this.mContext.getString(R.l.ezd, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
    }

    protected final String da(int i, int i2) {
        if (i2 <= 0) {
            return this.mContext.getString(R.l.eyZ, new Object[]{Integer.valueOf(i)});
        }
        return this.mContext.getString(R.l.eyw, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean dU(long j) {
        x.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", Long.valueOf(j), Boolean.valueOf(n.qQE.ws((int) j)));
        return n.qQE.ws((int) j);
    }

    protected final void bgn() {
        if (ar.Hj()) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(589825, Boolean.valueOf(false));
        }
    }
}
