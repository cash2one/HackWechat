package com.tencent.mm.booter.notification.a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.booter.notification.a.f.a;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.k.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e;
import java.io.File;

public final class b {
    public int gAr = 0;

    public final int a(Context context, boolean z, boolean z2, Notification notification, String str) {
        int i;
        String zs;
        if (f.zn()) {
            i = 0;
            if (notification == null) {
                notification = new Notification();
            }
            x.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), g.a(notification.vibrate), notification.sound});
            if (z2) {
                notification.vibrate = bh.iev;
            }
            if (z) {
                zs = f.zs();
                if (aH(context)) {
                    i = 0;
                    notification.sound = null;
                    a.xs().ev(zs);
                    x.i("MicroMsg.NotificationDefaults", "initDefaults, wireOn & playSound by ourselves: %s(if null play follow system notification sound)", new Object[]{zs});
                } else if (zs == null || zs == e.f.gHY) {
                    i = 1;
                } else {
                    i = 0;
                    notification.sound = Uri.parse(zs);
                }
            }
            x.i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", new Object[]{Integer.valueOf(i), g.a(notification.vibrate), notification.sound});
            this.gAr = i;
            return this.gAr;
        }
        boolean z3;
        int i2;
        boolean z4;
        boolean z5;
        x.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), notification.vibrate, notification.sound});
        if (!z) {
            z3 = false;
            i = 0;
        } else if (aH(context)) {
            z3 = true;
            i = 0;
        } else {
            z3 = false;
            i = 1;
        }
        if (z2) {
            i |= 2;
        }
        zs = f.zs();
        if (bh.ov(str)) {
            x.d("MicroMsg.NotificationDefaults", "msgContent is null");
        }
        if (zs != null && new File(zs).exists()) {
            zs = e.f.gHY;
        }
        if (q.gGe.gEX != 2) {
            if (((i & 2) > 0 ? 1 : null) != null) {
                i2 = i & -3;
                bh.m(context, true);
                z4 = true;
            } else {
                i2 = i;
                z4 = false;
            }
            if (!fr(i2) || z3) {
                z5 = z4;
                z4 = false;
            } else {
                int i3 = i2 & -2;
                a.xs().ev(zs);
                i2 = i3;
                z5 = z4;
                z4 = true;
            }
        } else {
            z5 = false;
            i2 = i;
            z4 = false;
        }
        if (z3) {
            i2 &= -2;
            a.xs().ev(zs);
            z4 = true;
        } else if (fr(i2) && zs != null) {
            i2 &= -2;
            notification.sound = Uri.parse(zs);
        }
        this.gAr = i2;
        x.i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, DeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", new Object[]{Integer.valueOf(notification.defaults), g.a(notification.vibrate), notification.sound, zs, Boolean.valueOf(z3), Boolean.valueOf(r5), Boolean.valueOf(z5), Boolean.valueOf(z4)});
        return this.gAr;
    }

    private static boolean fr(int i) {
        return (i & 1) > 0;
    }

    private static boolean aH(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        return audioManager == null ? false : audioManager.isWiredHeadsetOn();
    }
}
