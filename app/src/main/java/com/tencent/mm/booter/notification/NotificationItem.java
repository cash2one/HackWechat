package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.ag;
import android.support.v4.app.ag.f;
import android.support.v4.app.z;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public class NotificationItem implements Parcelable {
    public static final Creator<NotificationItem> CREATOR = new 1();
    private final String TAG;
    private Bitmap b;
    PendingIntent gAa;
    public String gAb;
    public long gAc;
    public int gAd;
    public boolean gAe;
    public int gAf;
    public int gAg;
    public int id;
    Notification sx;

    public NotificationItem(int i, String str, Notification notification) {
        this(i, str, notification, true);
    }

    public NotificationItem(int i, Notification notification, boolean z) {
        this(i, null, notification, z);
    }

    public NotificationItem(Notification notification, boolean z) {
        this(-1, notification, z);
    }

    @TargetApi(11)
    private NotificationItem(int i, String str, Notification notification, boolean z) {
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.gAc = 0;
        this.gAd = 0;
        this.gAe = true;
        this.gAf = 0;
        this.gAg = 0;
        this.id = i;
        this.gAb = str;
        if (VERSION.SDK_INT >= 11) {
            this.b = notification.largeIcon;
        }
        this.sx = notification;
        this.gAe = z;
        this.gAf = 0;
    }

    public final synchronized void clear() {
        if (!(this.b == null || this.b.isRecycled())) {
            x.i("MicroMsg.NotificationItem", "recycle bitmap:%s", this.b.toString());
            this.b.recycle();
        }
        this.sx = null;
        this.b = null;
        this.gAa = null;
    }

    public final synchronized int a(g gVar) {
        int i;
        NotificationItem notificationItem = null;
        synchronized (this) {
            this.id = this.id == -1 ? b.xi().aX(this.gAe) : this.id;
            Context context = ac.getContext();
            if (context == null) {
                x.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
                i = -1;
            } else if (this.sx == null) {
                x.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
                i = -1;
            } else {
                NotificationItem notificationItem2;
                b xi = b.xi();
                String str = this.gAb;
                if (t.ov(str)) {
                    notificationItem2 = null;
                } else {
                    Iterator it = xi.iterator();
                    while (it.hasNext()) {
                        notificationItem2 = (NotificationItem) it.next();
                        if (notificationItem2 != null && notificationItem2.gAb != null && notificationItem2.gAb.equals(str)) {
                            break;
                        }
                    }
                    notificationItem2 = null;
                }
                if (notificationItem2 != null) {
                    b xi2 = b.xi();
                    x.d("MicroMsg.Notification.Queue", "mark: %d", Integer.valueOf(notificationItem2.id));
                    xi2.mark = r7;
                }
                if (!(notificationItem2 == null || notificationItem2.sx.tickerText == null || this.sx.tickerText == null || !notificationItem2.sx.tickerText.equals(this.sx.tickerText))) {
                    this.sx.tickerText += " ";
                }
                xi = b.xi();
                if (this == null) {
                    x.e("MicroMsg.Notification.Queue", "notification item null when put");
                } else if (this.id == -1) {
                    x.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
                } else {
                    if (xi.mark > 0) {
                        if (xi.mark == this.id) {
                            x.d("MicroMsg.Notification.Queue", "remove mark: %d", Integer.valueOf(xi.mark));
                            xi.remove(xi.mark);
                        }
                        xi.mark = -1;
                    }
                    xi.remove(this.id);
                    if (xi.size() >= 5) {
                        notificationItem = xi.xj();
                    }
                    xi.gAn.d(this);
                    xi.gAo.b(this);
                    x.i("MicroMsg.Notification.Queue", "put item: %d, queuesize: %d", Integer.valueOf(this.id), Integer.valueOf(xi.size()));
                }
                if (notificationItem != null) {
                    b.xi().cancel(notificationItem.id);
                }
                this.gAg = d.a(this.sx, gVar);
                if (context != null) {
                    if (this.sx == null) {
                        x.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
                    } else {
                        Context context2 = ac.getContext();
                        if (context2 == null) {
                            x.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
                        } else if (this.sx == null) {
                            x.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                        } else {
                            if (context2.getResources().getDrawable(this.sx.icon) == null) {
                                this.sx.icon = R.g.icon;
                            }
                        }
                        x.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", Integer.valueOf(this.sx.defaults), this.sx.sound, g.a(this.sx.vibrate));
                        try {
                            if (e.xr() == 1 && this.sx.defaults != 2 && this.sx.vibrate == null) {
                                this.sx.defaults = 0;
                                this.sx.sound = null;
                                x.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                            }
                            ag j = ag.j(ac.getContext());
                            int i2 = this.id;
                            Notification notification = this.sx;
                            Bundle a = z.a(notification);
                            Object obj = (a == null || !a.getBoolean("android.support.useSideChannel")) ? null : 1;
                            if (obj != null) {
                                j.a(new f(j.mContext.getPackageName(), i2, null, notification));
                                ag.ta.a(j.sX, null, i2);
                            } else {
                                ag.ta.a(j.sX, null, i2, notification);
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NotificationItem", e, "Notification Exception?", new Object[0]);
                        }
                        if (this.gAc != 0) {
                            c.aA(this.gAc);
                        }
                    }
                }
                i = this.id;
            }
        }
        return i;
    }

    private NotificationItem(Parcel parcel) {
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.gAc = 0;
        this.gAd = 0;
        this.gAe = true;
        this.gAf = 0;
        this.gAg = 0;
        if (parcel != null) {
            boolean z;
            this.id = parcel.readInt();
            this.gAb = parcel.readString();
            this.b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
            this.sx = (Notification) parcel.readParcelable(Notification.class.getClassLoader());
            this.gAa = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.gAe = z;
            this.gAc = parcel.readLong();
            this.gAd = parcel.readInt();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeInt(this.id);
        parcel.writeString(this.gAb == null ? "" : this.gAb);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.sx, 0);
        parcel.writeParcelable(this.gAa, 0);
        if (this.gAe) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.gAc);
        parcel.writeInt(this.gAd);
    }

    public String toString() {
        return "id: " + this.id + ",msgId: " + this.gAc + ",userName: " + this.gAb + ",unreadCount: " + this.gAd;
    }
}
