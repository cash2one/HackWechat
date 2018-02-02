package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final SparseArray<WakeLock> tR = new SparseArray();
    private static int tS = 1;

    public static ComponentName b(Context context, Intent intent) {
        synchronized (tR) {
            int i = tS;
            int i2 = tS + 1;
            tS = i2;
            if (i2 <= 0) {
                tS = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            tR.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean b(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (tR) {
            WakeLock wakeLock = (WakeLock) tR.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                tR.remove(intExtra);
                return true;
            }
            return true;
        }
    }
}
