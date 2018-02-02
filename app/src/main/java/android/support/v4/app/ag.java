package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.provider.Settings.Secure;
import java.util.HashSet;
import java.util.Set;

public final class ag {
    private static final int sT = ta.bm();
    private static final Object sU = new Object();
    private static String sV;
    private static Set<String> sW = new HashSet();
    private static final Object sY = new Object();
    private static h sZ;
    public static final b ta;
    public final Context mContext;
    public final NotificationManager sX = ((NotificationManager) this.mContext.getSystemService("notification"));

    private static class a implements i {
        final int id;
        final String packageName;
        final String tag = null;
        final boolean tb = false;

        public a(String str, int i, String str2) {
            this.packageName = str;
            this.id = i;
        }

        public final void a(s sVar) {
            if (this.tb) {
                sVar.q(this.packageName);
            } else {
                sVar.b(this.packageName, this.id, this.tag);
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append(", all:").append(this.tb);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    interface b {
        void a(NotificationManager notificationManager, String str, int i);

        void a(NotificationManager notificationManager, String str, int i, Notification notification);

        int bm();
    }

    private static class g {
        final ComponentName td;
        final IBinder te;

        public g(ComponentName componentName, IBinder iBinder) {
            this.td = componentName;
            this.te = iBinder;
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            ta = new e();
        } else if (VERSION.SDK_INT >= 5) {
            ta = new d();
        } else {
            ta = new c();
        }
    }

    public static ag j(Context context) {
        return new ag(context);
    }

    private ag(Context context) {
        this.mContext = context;
    }

    public static Set<String> k(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (!(string == null || string.equals(sV))) {
            String[] split = string.split(":");
            Set hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (sU) {
                sW = hashSet;
                sV = string;
            }
        }
        return sW;
    }

    public final void a(i iVar) {
        synchronized (sY) {
            if (sZ == null) {
                sZ = new h(this.mContext.getApplicationContext());
            }
        }
        sZ.mHandler.obtainMessage(0, iVar).sendToTarget();
    }
}
