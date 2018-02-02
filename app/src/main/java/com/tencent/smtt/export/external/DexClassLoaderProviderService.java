package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.ArrayList;

public class DexClassLoaderProviderService extends Service {
    private static final String LOGTAG = "dexloader";

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        DexClassLoaderProvider.setForceLoadDexFlag(true, this);
    }

    public void onDestroy() {
        System.exit(0);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("dex2oat");
            if (stringArrayListExtra != null) {
                stringArrayListExtra.get(0);
                DexClassLoaderProvider.createDexClassLoader((String) stringArrayListExtra.get(1), (String) stringArrayListExtra.get(2), (String) stringArrayListExtra.get(3), getClassLoader(), getApplicationContext());
            }
        }
        return 1;
    }
}
