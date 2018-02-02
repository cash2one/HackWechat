package android.support.v4.app;

import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;

final class aa {
    public static void a(Builder builder, ac$a android_support_v4_app_ac_a) {
        Action.Builder builder2 = new Action.Builder(android_support_v4_app_ac_a.getIcon(), android_support_v4_app_ac_a.getTitle(), android_support_v4_app_ac_a.bi());
        if (android_support_v4_app_ac_a.bj() != null) {
            for (RemoteInput addRemoteInput : ai.a(android_support_v4_app_ac_a.bj())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (android_support_v4_app_ac_a.getExtras() != null) {
            builder2.addExtras(android_support_v4_app_ac_a.getExtras());
        }
        builder.addAction(builder2.build());
    }
}
