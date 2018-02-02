package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.z.d;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.v;
import com.tencent.mm.k.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    public static String gzJ = "com.tencent.preference.notification.key.unread.msg";
    public static String gzK = "com.tencent.preference.notification.key.unread.talker";
    public static String gzL = "com.tencent.preference.notification.key.all.notified.msgid";
    g fgv = new g(this.mContext);
    Context mContext = ac.getContext();

    static Notification xc() {
        Notification notification = new Notification();
        notification.icon = R.g.icon;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 300;
        notification.ledOffMS = 1000;
        return notification;
    }

    public static boolean a(String str, au auVar, int i, boolean z) {
        x.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[]{str, Integer.valueOf(i)});
        if (!ar.Hj()) {
            x.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[]{str, Integer.valueOf(i)});
            return false;
        } else if (auVar != null && aB(auVar.field_msgSvrId) && !z) {
            x.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", new Object[]{Long.valueOf(auVar.field_msgSvrId)});
            return false;
        } else if ((i & 1) == 0) {
            x.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[]{str, Integer.valueOf(i)});
            return false;
        } else {
            ar.Hg();
            if (com.tencent.mm.z.c.ET() && !q.gL(q.FY())) {
                r4 = new Object[4];
                ar.Hg();
                r4[2] = Boolean.valueOf(com.tencent.mm.z.c.ET());
                r4[3] = Boolean.valueOf(q.gL(q.FY()));
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", r4);
                return false;
            } else if (s.gA(str)) {
                b iuVar = new iu();
                iuVar.fzl.fut = 3;
                a.xef.m(iuVar);
                if (!iuVar.fzm.fpW) {
                    iuVar = new iu();
                    iuVar.fzl.fut = 1;
                    iuVar.fzl.fzn = str;
                    iuVar.fzl.fzo = 3;
                    a.xef.m(iuVar);
                }
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[]{str, Integer.valueOf(i)});
                return false;
            } else if (!s.hs(str) && (!s.eV(str) || s.hr(str) || auVar == null || auVar.Xq(q.FS()) || auVar.getType() == 64 || auVar == null || auVar.cjD())) {
                return true;
            } else {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[]{str, Integer.valueOf(i)});
                return false;
            }
        }
    }

    public final int a(NotificationItem notificationItem, g gVar) {
        if (!(m.df(this.mContext) || VERSION.SDK_INT < 16 || notificationItem == null || notificationItem.sx == null)) {
            notificationItem.sx.priority = 1;
            if (!f.zn()) {
                notificationItem.sx.vibrate = new long[0];
                if (!(gVar.gAS || gVar.gAR)) {
                    notificationItem.sx.priority = 0;
                }
            }
        }
        return super.a(notificationItem, gVar);
    }

    @TargetApi(11)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, 0, null, null, 0, null, null, str4);
    }

    @TargetApi(21)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i3, String str4, PendingIntent pendingIntent2, int i4, String str5, PendingIntent pendingIntent3, String str6) {
        if (VERSION.SDK_INT < 11) {
            return notification;
        }
        d dVar = new d(this.mContext);
        if (i == -1) {
            i = com.tencent.mm.bl.a.bXV();
        }
        dVar.sx.ledARGB = -16711936;
        dVar.sx.ledOnMS = 300;
        dVar.sx.ledOffMS = 1000;
        Object obj = (dVar.sx.ledOnMS == 0 || dVar.sx.ledOffMS == 0) ? null : 1;
        dVar.sx.flags = (obj != null ? 1 : 0) | (dVar.sx.flags & -2);
        dVar.U(i).c(str3).sa = pendingIntent;
        dVar.ss = true;
        if (str != null) {
            dVar.a(str);
        }
        if (str2 != null) {
            dVar.b(str2);
        }
        dVar.sx.defaults = i2;
        if ((i2 & 4) != 0) {
            Notification notification2 = dVar.sx;
            notification2.flags |= 1;
        }
        if (bitmap != null) {
            dVar.se = bitmap;
        }
        if (notification != null) {
            if (notification.sound != null) {
                dVar.sx.sound = notification.sound;
                dVar.sx.audioStreamType = -1;
            }
            if (notification.vibrate != null) {
                dVar.sx.vibrate = notification.vibrate;
            }
        }
        if (VERSION.SDK_INT >= 16) {
            if (str4 != null) {
                dVar.a(i3, str4, pendingIntent2);
            }
            if (str5 != null) {
                dVar.a(i4, str5, pendingIntent3);
            }
        }
        if (VERSION.SDK_INT >= 21) {
            dVar.st = "msg";
            b vVar = new v();
            vVar.fnN.username = str6;
            vVar.fnN.title = str;
            a.xef.m(vVar);
            if (vVar.fnN.fnO != null) {
                vVar.fnN.fnO.a(dVar);
            }
        }
        return dVar.getNotification();
    }

    public final void a(long j, String str, String str2, String str3, String str4, boolean z, int i) {
        Context context = ac.getContext();
        boolean xq = e.xq();
        boolean xo = e.xo();
        x.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", new Object[]{Boolean.valueOf(xq), Boolean.valueOf(xo)});
        if (j != 0) {
            if (bh.ov(str) || bh.ov(str2) || bh.ov(str3)) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
            } else if (f.zP() && !f.zQ()) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
            } else if (!f.zo()) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
            } else if (aB(j)) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
            } else {
                com.tencent.mm.booter.notification.queue.b.xi().restore();
                int xd = xd() + 1;
                a a = a(xe(), str);
                int i2 = (a == null ? 0 : a.gzM) + 1;
                List xe = xe();
                if (xe == null) {
                    xe = new ArrayList();
                }
                a a2 = a(xe, str);
                if (a2 == null) {
                    a2 = new a((byte) 0);
                    a2.userName = str;
                    a2.gzM = 1;
                    xe.add(a2);
                } else {
                    a2.gzM++;
                }
                d(xe);
                fn(xd() + 1);
                int size = xe.size();
                if (e.xn()) {
                    xo = false;
                    xq = false;
                }
                Notification xc = xc();
                int er = com.tencent.mm.booter.notification.queue.b.xi().er(str);
                this.fgv.gAM = xd;
                this.fgv.gAL = size;
                this.fgv.gAS = xq;
                this.fgv.gAR = xo;
                boolean zq = f.zq();
                int bXV = com.tencent.mm.bl.a.bXV();
                g gVar = this.fgv;
                gVar.gAE.a(gVar.mContext, xo, xq, xc, null);
                int i3 = gVar.gAE.gAr;
                x.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", new Object[]{Integer.valueOf(er), str, Integer.valueOf(i), Integer.valueOf(xd), Integer.valueOf(size), Boolean.valueOf(false), Boolean.valueOf(zq)});
                Intent intent = new Intent(context, LauncherUI.class);
                intent.putExtra("nofification_type", "new_msg_nofification");
                intent.putExtra("Main_User", str);
                intent.putExtra("MainUI_User_Last_Msg_Type", i);
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
                if (zq) {
                    intent.putExtra("talkerCount", 1);
                    intent.putExtra("Intro_Is_Muti_Talker", false);
                } else {
                    if (size <= 1) {
                        intent.putExtra("Intro_Is_Muti_Talker", false);
                    } else {
                        intent.putExtra("Intro_Is_Muti_Talker", true);
                    }
                    intent.putExtra("talkerCount", size);
                }
                intent.putExtra("pushcontent_unread_count", xd);
                NotificationItem notificationItem = new NotificationItem(er, str, a(xc, bXV, i3, com.tencent.mm.booter.notification.a.d.a(context, er, intent), h.c(context, str2, zq), h.a(context, str3, size, xd, i2, zq), h.d(context, str3, zq), f.zq() ? com.tencent.mm.booter.notification.a.a.b(context, com.tencent.mm.booter.notification.a.a.C(str, str4)) : null, str));
                notificationItem.gAc = j;
                notificationItem.gAd = i2;
                a(notificationItem, this.fgv);
                d.fo(this.fgv.gAM);
                d.w(str, i2);
            }
        }
    }

    private static a a(List<a> list, String str) {
        if (list == null || str == null) {
            return null;
        }
        for (a aVar : list) {
            if (aVar.userName.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private static int xd() {
        return f.zm().getInt(gzJ, 0);
    }

    public static ArrayList<a> xe() {
        try {
            ArrayList<a> arrayList = (ArrayList) com.tencent.mm.booter.notification.queue.c.es(f.zm().getString(gzK, ""));
            if (arrayList == null) {
                return new ArrayList();
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e, "", new Object[0]);
            return new ArrayList();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e2, "", new Object[0]);
            return new ArrayList();
        }
    }

    public static void d(ArrayList<a> arrayList) {
        if (arrayList == null) {
            f.zm().edit().putString(gzK, "").apply();
        } else {
            try {
                f.zm().edit().putString(gzK, com.tencent.mm.booter.notification.queue.c.a(new ArrayList(arrayList))).apply();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e, "", new Object[0]);
                f.zm().edit().putString(gzK, "").apply();
            }
        }
        String str = "MicroMsg.Notification.AppMsg.Handle";
        String str2 = "saveTotalUnreadTalker %s";
        Object[] objArr = new Object[1];
        objArr[0] = arrayList == null ? "null" : arrayList.toString();
        x.i(str, str2, objArr);
    }

    public static void fn(int i) {
        f.zm().edit().putInt(gzJ, Math.max(0, i)).apply();
        x.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", new Object[]{Integer.valueOf(r0)});
    }

    public static void aA(long j) {
        if (j != 0) {
            String xf = xf();
            if (xf.length() > 3000) {
                xf = xf.substring(xf.length() / 2, xf.length());
            }
            if (!aB(j)) {
                f.zm().edit().putString(gzL, xf + j + "%").apply();
                x.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", new Object[]{xf});
            }
        }
    }

    private static boolean aB(long j) {
        if (j == 0) {
            return false;
        }
        x.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", new Object[]{xf(), Long.valueOf(j)});
        if (xf().contains(j + "%")) {
            return true;
        }
        return false;
    }

    private static String xf() {
        return f.zm().getString(gzL, "");
    }

    public static void xb() {
        f.zm().edit().putString(gzL, "").apply();
    }
}
