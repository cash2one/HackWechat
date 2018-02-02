package com.tencent.c.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import com.tencent.c.e.a.a.c;
import com.tencent.c.e.a.a.k;
import com.tencent.c.f.f;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class e$a extends c {
    int mCount;
    int mMaxCount;
    final /* synthetic */ e zTM;
    long zTS;

    private e$a(e eVar) {
        this.zTM = eVar;
        this.mCount = 1;
        this.mMaxCount = 3;
        this.zTS = 0;
    }

    public final void cDz() {
        k kVar = new k();
        synchronized (this.zTM) {
            Object systemService;
            int i;
            Context context = e.a(this.zTM).context;
            try {
                if (VERSION.SDK_INT >= 20) {
                    Class cls = Class.forName("android.hardware.display.DisplayManager");
                    Field field = context.getClass().getField("DISPLAY_SERVICE");
                    field.setAccessible(true);
                    systemService = context.getSystemService((String) field.get(context));
                    if (systemService == null) {
                        i = 0;
                    } else {
                        Method method = cls.getMethod("getDisplays", new Class[0]);
                        if (method == null) {
                            i = 0;
                        } else {
                            method.setAccessible(true);
                            Display[] displayArr = (Display[]) method.invoke(systemService, new Object[0]);
                            Method method2 = Display.class.getMethod("getState", new Class[0]);
                            method2.setAccessible(true);
                            Field field2 = Display.class.getField("STATE_OFF");
                            field2.setAccessible(true);
                            int length = displayArr.length;
                            int i2 = 0;
                            Object obj = null;
                            while (i2 < length) {
                                Object obj2 = displayArr[i2];
                                if (((Integer) method2.invoke(obj2, new Object[0])).intValue() != field2.getInt(obj2)) {
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                i2++;
                                obj = obj2;
                            }
                            kVar.zUl = obj != null ? 1 : 2;
                            i = kVar.zUl;
                        }
                    }
                    kVar.zUl = i;
                } else {
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (powerManager != null) {
                        kVar.zUl = powerManager.isScreenOn() ? 1 : 2;
                    }
                }
            } catch (Throwable th) {
            }
            CharSequence O = f.O(new File("/sys/class/android_usb/android0/state"));
            if (!TextUtils.isEmpty(O)) {
                if ("CONFIGURED".equals(O)) {
                    kVar.zUn = 1;
                } else if ("DISCONNECTED".equals(O)) {
                    kVar.zUn = 2;
                } else if ("CONNECTED".equals(O)) {
                    kVar.zUn = 3;
                }
            }
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
                systemService = (i == 2 || i == 5) ? 1 : null;
                if (systemService == null) {
                    kVar.zUo = 1;
                } else {
                    i = registerReceiver.getIntExtra("plugged", -1);
                    if (i == 2) {
                        kVar.zUo = 3;
                    } else if (i == 1) {
                        kVar.zUo = 2;
                    } else {
                        kVar.zUo = 0;
                    }
                }
            }
        }
        synchronized (e.b(this.zTM)) {
            e.b(this.zTM).add(kVar);
        }
        if (this.mCount >= this.mMaxCount) {
            synchronized (this.zTM) {
                if (e.c(this.zTM)) {
                    this.zTM.vo();
                    return;
                }
                return;
            }
        }
        this.mCount++;
        long currentTimeMillis = (this.zTS + (com.tencent.c.e.a.a.f.zTV * ((long) this.mCount))) - System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            e.e(this.zTM).postDelayed(e.d(this.zTM), currentTimeMillis);
        } else {
            e.e(this.zTM).post(e.d(this.zTM));
        }
    }

    public final void cDA() {
        if (e.f(this.zTM) != null) {
            e.f(this.zTM);
        }
    }
}
