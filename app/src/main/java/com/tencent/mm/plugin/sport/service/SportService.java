package com.tencent.mm.plugin.sport.service;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a.a;
import com.tencent.mm.plugin.sport.c.c;
import com.tencent.mm.plugin.sport.c.g;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.k;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class SportService extends Service implements c {
    private SensorManager hRa;
    private k rUm;
    private boolean rUn = false;
    private final a rUo = new a(this) {
        final /* synthetic */ SportService rUp;

        {
            this.rUp = r1;
        }

        public final long bDh() {
            try {
                long cgt = bh.cgt() / 10000;
                long yd = i.yd(202);
                long yd2 = i.yd(201);
                int bDw = (int) k.bDw();
                if (k.bDx() == cgt) {
                    x.i("MicroMsg.Sport.SportService", "cacheTime %s cacheStep:%s", new Object[]{Long.valueOf(k.bDx()), Integer.valueOf(bDw)});
                    return (long) bDw;
                } else if (yd == cgt) {
                    x.i("MicroMsg.Sport.SportService", "saveTime %s saveStep:%s", new Object[]{Long.valueOf(yd), Long.valueOf(yd2)});
                    return (long) ((int) yd2);
                } else {
                    x.i("MicroMsg.Sport.SportService", "getStepCount:0, new day");
                    x.i("MicroMsg.Sport.SportService", "saveTime:%s, cacheTime: %S, beginOfToday:%s", new Object[]{Long.valueOf(yd), Long.valueOf(r8), Long.valueOf(cgt)});
                    return 0;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Sport.SportService", e, "exception in :exdevice getTodayDeviceStepCount", new Object[0]);
                return 0;
            }
        }

        public final void Mg(String str) {
            g.Mh(str);
            if (!this.rUp.bDB()) {
                this.rUp.stopSelf();
            }
        }

        public final void bDi() {
        }

        public final void J(int i, long j) {
            ((PluginSport) com.tencent.mm.kernel.g.k(PluginSport.class)).getSportFileStorage().setLong(i, j);
        }

        public final long getLong(int i, long j) {
            return ((PluginSport) com.tencent.mm.kernel.g.k(PluginSport.class)).getSportFileStorage().getLong(i, j);
        }

        public final void bDj() {
            ((PluginSport) com.tencent.mm.kernel.g.k(PluginSport.class)).getSportFileStorage().reset();
            Process.killProcess(Process.myPid());
        }
    };
    private Sensor sensor;

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.Sport.SportService", "onCreate");
        this.rUn = n.dz(this);
        x.i("MicroMsg.Sport.SportService", "isSupportDeviceStep %b", new Object[]{Boolean.valueOf(this.rUn)});
        if (this.rUn) {
            bDz();
            return;
        }
        x.i("MicroMsg.Sport.SportService", "stop self");
        stopSelf();
    }

    public IBinder onBind(Intent intent) {
        return this.rUo;
    }

    private boolean bDz() {
        try {
            if (this.hRa == null) {
                this.hRa = (SensorManager) getSystemService("sensor");
            }
            if (this.rUm == null) {
                this.rUm = new k();
                this.rUm.rUf = this;
            }
            if (this.hRa == null || !getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                x.i("MicroMsg.Sport.SportService", "no step sensor");
                return false;
            }
            this.sensor = this.hRa.getDefaultSensor(19);
            if (this.sensor == null) {
                x.i("MicroMsg.Sport.SportService", " TYPE_STEP_COUNTER sensor null");
                return false;
            }
            boolean registerListener = this.hRa.registerListener(this.rUm, this.sensor, g.bDr().optInt("stepCounterRateUs", 60000));
            if (!registerListener) {
                bDA();
            }
            x.i("MicroMsg.Sport.SportService", "registerDetector() ok.(result : %s)", new Object[]{Boolean.valueOf(registerListener)});
            return registerListener;
        } catch (Exception e) {
            x.e("MicroMsg.Sport.SportService", "Exception in registerDetector %s", new Object[]{e.getMessage()});
        }
    }

    private void bDA() {
        try {
            if (this.hRa == null) {
                this.hRa = (SensorManager) getSystemService("sensor");
            }
            this.hRa.unregisterListener(this.rUm);
            x.i("MicroMsg.Sport.SportService", "unregisterDetector() success!");
        } catch (Exception e) {
            x.e("MicroMsg.Sport.SportService", "Exception in unregisterDetector %s", new Object[]{e.getMessage()});
        }
    }

    public void onDestroy() {
        x.i("MicroMsg.Sport.SportService", "onDestroy");
        if (this.rUn) {
            bDA();
        }
        super.onDestroy();
    }

    public final boolean bDB() {
        this.rUn = n.dz(this);
        if (!this.rUn) {
            return false;
        }
        bDA();
        return bDz();
    }

    public final void bDp() {
        bDA();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.Sport.SportService", "onStartCommand");
        try {
            if (this.rUn) {
                if (this.rUm != null) {
                    this.rUm.rUf = this;
                }
                if (bDB()) {
                    return 1;
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sport.SportService", e, "Exception onStartCommand %s", new Object[0]);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
