package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.lib.c.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.io.File;

public class TinkerPatchService extends IntentService {
    private static a Aiv = null;
    private static Class<? extends AbstractResultService> Aiw = null;
    private static int gAk = -1119860829;

    public TinkerPatchService() {
        super(TinkerPatchService.class.getSimpleName());
    }

    public static void bT(Context context, String str) {
        try {
            Intent intent = new Intent(context, TinkerPatchService.class);
            intent.putExtra("patch_path_extra", str);
            intent.putExtra("patch_result_class", Aiw.getName());
            context.startService(intent);
        } catch (Throwable th) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "start patch service fail, exception:" + th, new Object[0]);
        }
    }

    public static void a(a aVar, Class<? extends AbstractResultService> cls) {
        Aiv = aVar;
        Aiw = cls;
        try {
            Class.forName(cls.getName());
        } catch (ClassNotFoundException e) {
        }
    }

    public static String ao(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.j(intent, "patch_path_extra");
        }
        throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }

    protected void onHandleIntent(Intent intent) {
        boolean z = false;
        Context applicationContext = getApplicationContext();
        com.tencent.tinker.lib.e.a ip = com.tencent.tinker.lib.e.a.ip(applicationContext);
        ip.AiC.M(intent);
        if (intent == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[z]);
            return;
        }
        String ao = ao(intent);
        if (ao == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[z]);
            return;
        }
        File file = new File(ao);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Throwable th = null;
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[z]);
        try {
            Notification notification = new Notification();
            if (VERSION.SDK_INT < 18) {
                startForeground(gAk, notification);
            } else {
                startForeground(gAk, notification);
                startService(new Intent(this, InnerService.class));
            }
        } catch (Throwable th2) {
            com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "try to increase patch process priority error:" + th2, new Object[z]);
        }
        a aVar = new a();
        try {
            if (Aiv == null) {
                throw new TinkerRuntimeException("upgradePatchProcessor is null.");
            }
            z = Aiv.a(applicationContext, ao, aVar);
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            ip.AiC.a(file, z, elapsedRealtime);
            aVar.fsH = z;
            aVar.Ait = ao;
            aVar.jHU = elapsedRealtime;
            aVar.zRu = th;
            if (intent == null) {
                throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
            }
            AbstractResultService.a(applicationContext, aVar, ShareIntentUtil.j(intent, "patch_result_class"));
        } catch (Throwable th3) {
            th = th3;
            ip.AiC.a(file, th);
        }
    }
}
