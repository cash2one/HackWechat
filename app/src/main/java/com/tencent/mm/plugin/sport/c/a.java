package com.tencent.mm.plugin.sport.c;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.a.a$a;
import com.tencent.mm.plugin.sport.service.SportService;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Calendar;

public final class a {
    public c<qo> rTE = new 1(this);
    public f rTF;
    private long rTG;
    long rTH;
    public com.tencent.mm.plugin.sport.a.a rTI;
    private ServiceConnection rTJ = new ServiceConnection(this) {
        final /* synthetic */ a rTK;

        {
            this.rTK = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.i("MicroMsg.Sport.DeviceStepManager", "onServiceConnected %s", new Object[]{componentName.toShortString()});
            this.rTK.rTI = a$a.S(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.i("MicroMsg.Sport.DeviceStepManager", "onServiceDisconnected %s", new Object[]{componentName.toShortString()});
            this.rTK.rTI = null;
        }
    };

    static /* synthetic */ boolean bDn() {
        return n.dz(ac.getContext()) && n.bDd();
    }

    public a() {
        this.rTE.ceO();
    }

    public final boolean fb(long j) {
        if (this.rTF != null) {
            g.CG().c(this.rTF);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        x.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", new Object[]{n.bp(System.currentTimeMillis()), Long.valueOf(j)});
        this.rTF = new f("", "gh_43f2581f6fd6", (int) (timeInMillis / 1000), (int) (r6 / 1000), (int) j, be.cjW(), 1);
        g.CG().a(this.rTF, 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.rTH = currentTimeMillis;
        i.L(3, currentTimeMillis);
        this.rTG = j;
        i.L(4, this.rTG);
        return true;
    }

    public final long bDk() {
        if (this.rTG == 0) {
            this.rTG = i.K(4, 0);
        }
        return this.rTG;
    }

    public final long bDl() {
        long bDh;
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        if (this.rTI != null) {
            try {
                bDh = this.rTI.bDh();
                try {
                    str = "exdevice";
                } catch (RemoteException e) {
                }
            } catch (RemoteException e2) {
                bDh = -1;
            }
        } else {
            bDh = -1;
        }
        if (bDh == -1) {
            long cgt = bh.cgt() / 10000;
            long yd = i.yd(202);
            bDh = i.yd(201);
            if (yd == cgt) {
                str = "mm";
            } else {
                str = "unknow";
                bDh = 0;
            }
        }
        x.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", new Object[]{str, Long.valueOf(bDh), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return bDh;
    }

    public final void bDm() {
        if (!n.dz(ac.getContext())) {
            try {
                if (this.rTI != null) {
                    ac.getContext().unbindService(this.rTJ);
                }
                ac.getContext().stopService(new Intent(ac.getContext(), SportService.class));
            } catch (Exception e) {
            }
            this.rTI = null;
        } else if (this.rTI != null) {
            x.i("MicroMsg.Sport.DeviceStepManager", "Not need bind");
        } else {
            x.i("MicroMsg.Sport.DeviceStepManager", "start to bind sport aidl");
            try {
                Intent intent = new Intent(ac.getContext(), SportService.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                ac.getContext().bindService(intent, this.rTJ, 1);
            } catch (Exception e2) {
            }
        }
    }
}
