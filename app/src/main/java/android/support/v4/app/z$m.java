package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.z.l;
import com.tencent.wcdb.FileUtils;

class z$m extends l {
    z$m() {
    }

    public final Notification b(z$d android_support_v4_app_z_d) {
        Notification notification = android_support_v4_app_z_d.sx;
        Context context = android_support_v4_app_z_d.mContext;
        CharSequence charSequence = android_support_v4_app_z_d.rY;
        CharSequence charSequence2 = android_support_v4_app_z_d.rZ;
        PendingIntent pendingIntent = android_support_v4_app_z_d.sa;
        PendingIntent pendingIntent2 = android_support_v4_app_z_d.sc;
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        if (android_support_v4_app_z_d.mPriority > 0) {
            notification.flags |= FileUtils.S_IWUSR;
        }
        return notification;
    }
}
