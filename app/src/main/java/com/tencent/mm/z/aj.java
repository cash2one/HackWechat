package com.tencent.mm.z;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public interface aj extends al {
    int a(Notification notification, boolean z);

    Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i2, String str4, PendingIntent pendingIntent2, int i3, String str5, PendingIntent pendingIntent3, String str6);

    Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    void a(int i, Notification notification, boolean z);

    void aU(boolean z);

    void aV(boolean z);

    int b(Notification notification);

    void cancel(int i);

    void cancelNotification(String str);

    void eo(String str);

    void ep(String str);

    void fk(int i);

    void fl(int i);

    void fm(int i);

    void n(int i, String str);

    void notify(int i, Notification notification);

    void up();

    void v(String str, int i);

    String wX();

    void wY();

    boolean wZ();

    void xa();

    void xb();
}
