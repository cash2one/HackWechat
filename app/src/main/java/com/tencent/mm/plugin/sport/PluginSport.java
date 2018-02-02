package com.tencent.mm.plugin.sport;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sport.c.g;
import com.tencent.mm.plugin.sport.c.h;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.j;
import com.tencent.mm.plugin.sport.c.l;
import com.tencent.mm.plugin.sport.c.m;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.plugin.sport.service.SportService;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class PluginSport extends f implements b, a, c, a {
    public static HashMap<Integer, d> gwY;
    private h rTr;
    private com.tencent.mm.plugin.sport.b.b rTs;
    private com.tencent.mm.plugin.sport.c.a rTt;
    private com.tencent.mm.plugin.sport.c.b rTu;
    private l rTv;
    private m rTw;
    private g.a rTx = new g.a(this) {
        final /* synthetic */ PluginSport rTy;

        {
            this.rTy = r1;
        }

        public final void bDb() {
            if (this.rTy.rTt != null) {
                this.rTy.rTt.bDm();
            }
            if (n.dz(ac.getContext()) && n.bDd()) {
                Context context = ac.getContext();
                AlarmManager alarmManager = (AlarmManager) ac.getContext().getSystemService("alarm");
                Calendar instance = Calendar.getInstance();
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                Random random = new Random();
                instance.set(11, 6);
                long timeInMillis = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
                instance.set(11, 12);
                long timeInMillis2 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
                instance.set(11, 18);
                long timeInMillis3 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
                instance.set(11, 21);
                long timeInMillis4 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
                instance.set(11, 24);
                long timeInMillis5 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
                Intent intent = new Intent(context, SportService.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                try {
                    alarmManager.setRepeating(0, timeInMillis, 86400000, PendingIntent.getService(context, 20481, intent, 134217728));
                    alarmManager.setRepeating(0, timeInMillis2, 86400000, PendingIntent.getService(context, 20482, intent, 134217728));
                    alarmManager.setRepeating(0, timeInMillis3, 86400000, PendingIntent.getService(context, 20483, intent, 134217728));
                    alarmManager.setRepeating(0, timeInMillis4, 86400000, PendingIntent.getService(context, 20484, intent, 134217728));
                    alarmManager.setRepeating(0, timeInMillis5, 86400000, PendingIntent.getService(context, 20485, intent, 134217728));
                    x.i("MicroMsg.Sport.SportAlarmLogic", "start sport alarm %s %s %s %s %s", new Object[]{n.bp(timeInMillis), n.bp(timeInMillis2), n.bp(timeInMillis3), n.bp(timeInMillis4), n.bp(timeInMillis5)});
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Sport.SportAlarmLogic", e, "startSportAlarm", new Object[0]);
                    return;
                }
            }
            Context context2 = ac.getContext();
            x.i("MicroMsg.Sport.SportAlarmLogic", "stop sport alarm");
            Intent intent2 = new Intent(context2, SportService.class);
            try {
                PendingIntent service = PendingIntent.getService(context2, 20481, intent2, 134217728);
                if (service != null) {
                    service.cancel();
                }
                service = PendingIntent.getService(context2, 20482, intent2, 134217728);
                if (service != null) {
                    service.cancel();
                }
                service = PendingIntent.getService(context2, 20483, intent2, 134217728);
                if (service != null) {
                    service.cancel();
                }
                service = PendingIntent.getService(context2, 20484, intent2, 134217728);
                if (service != null) {
                    service.cancel();
                }
                PendingIntent service2 = PendingIntent.getService(context2, 20485, intent2, 134217728);
                if (service2 != null) {
                    service2.cancel();
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Sport.SportAlarmLogic", e2, "stopSportAlarm", new Object[0]);
            }
        }
    };

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        ExdeviceProcessReceiver.a(new j());
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
        if (this.rTr == null) {
            this.rTr = i.bDv();
        }
        if (gVar.DS()) {
            this.rTs = new c();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.b.b.class, new com.tencent.mm.kernel.c.d(this.rTs));
        }
    }

    public void onAccountInitialized(e.c cVar) {
        this.rTt = new com.tencent.mm.plugin.sport.c.a();
        this.rTu = new com.tencent.mm.plugin.sport.c.b();
        this.rTw = new m();
        this.rTv = new l();
        g.a(this.rTx);
        this.rTx.bDb();
    }

    public h getSportFileStorage() {
        if (this.rTr == null) {
            this.rTr = i.bDv();
        }
        return this.rTr;
    }

    public com.tencent.mm.plugin.sport.c.a getDeviceStepManager() {
        return this.rTt;
    }

    public com.tencent.mm.plugin.sport.c.b getExtApiStepManager() {
        return this.rTu;
    }

    public l getSportStepManager() {
        return this.rTv;
    }

    public m getSportStepStorage() {
        return this.rTw;
    }

    public void onAccountRelease() {
        g.a(null);
        if (this.rTt != null) {
            com.tencent.mm.plugin.sport.c.a aVar = this.rTt;
            aVar.rTE.dead();
            if (aVar.rTF != null) {
                com.tencent.mm.kernel.g.CG().c(aVar.rTF);
            }
            this.rTt = null;
        }
        if (this.rTu != null) {
            com.tencent.mm.plugin.sport.c.b bVar = this.rTu;
            bVar.rTL.dead();
            bVar.rTE.dead();
            if (bVar.rTF != null) {
                com.tencent.mm.kernel.g.CG().c(bVar.rTF);
            }
            this.rTu = null;
        }
    }

    public void parallelsDependency() {
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aJ(com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class));
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("SPORTSTEP_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return m.rUj;
            }
        });
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return gwY;
    }
}
