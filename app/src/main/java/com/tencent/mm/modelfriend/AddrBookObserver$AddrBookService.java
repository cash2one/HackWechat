package com.tencent.mm.modelfriend;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.plugin.ipcall.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public class AddrBookObserver$AddrBookService extends Service {
    public static boolean aBT = false;
    public static boolean huT = false;
    public static String huV = "key_sync_session";
    private b huW = new 1(this);

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        String str = "MicroMsg.AddrBookObserver";
        String str2 = "service start intent:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (intent == null) {
            x.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
            stopSelf();
        } else {
            float floatExtra = intent.getFloatExtra(huV, -1.0f);
            if (floatExtra == -1.0f) {
                x.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
                stopSelf();
            } else {
                SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences(ac.cfs(), 0);
                if (sharedPreferences.getFloat(huV, 0.0f) == floatExtra) {
                    x.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", new Object[]{Float.valueOf(sharedPreferences.getFloat(huV, 0.0f))});
                    stopSelf();
                } else {
                    sharedPreferences.edit().putFloat(huV, floatExtra).commit();
                    x.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", new Object[]{Float.valueOf(floatExtra)});
                    if (aBT) {
                        x.i("MicroMsg.AddrBookObserver", "service canceled");
                        aBT = false;
                        stopSelf();
                    } else if (ar.GZ()) {
                        x.e("MicroMsg.AddrBookObserver", "[onStartCommand] getCode is null, stop service");
                        stopSelf();
                    } else {
                        try {
                            if (ar.Hj()) {
                                if (d.aTd()) {
                                    a.xef.m(new ij());
                                }
                                if (!m.NQ() || m.NM()) {
                                    x.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
                                    stopSelf();
                                } else {
                                    x.i("MicroMsg.AddrBookObserver", "start sync");
                                    if (com.tencent.mm.modelsimple.d.bu(this)) {
                                        x.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
                                        stopSelf();
                                    } else {
                                        huT = true;
                                        a.a(this.huW);
                                    }
                                }
                            } else {
                                x.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
                                stopSelf();
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.AddrBookObserver", e, "", new Object[0]);
                            x.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", new Object[]{e.getMessage()});
                            stopSelf();
                        }
                    }
                }
            }
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
