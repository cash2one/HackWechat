package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.ag;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.y;
import com.tencent.mm.booter.notification.a.d;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.k.f;
import com.tencent.mm.platformtools.l.2;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.jsapi.bq;
import com.tencent.mm.plugin.bbom.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.aj;
import com.tencent.mm.z.am;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b implements aj, am {
    Context context = null;
    au fEJ;
    private int gzA;
    private boolean gzB;
    private long gzC;
    f gzD = f$a.gAi;
    private e gzE;
    @SuppressLint({"HandlerLeak"})
    af gzF = new af(this, Looper.getMainLooper()) {
        final /* synthetic */ b gzI;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ac.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", true).apply();
            String string = message.getData().getString("notification.show.talker");
            String string2 = message.getData().getString("notification.show.message.content");
            int i = message.getData().getInt("notification.show.message.type");
            int i2 = message.getData().getInt("notification.show.tipsflag");
            x.i("MicroMsg.MMNotification", "notify need to deal: %s", new Object[]{string});
            try {
                if (message.what == 1) {
                    b.a(this.gzI, string, string2, i, i2, true);
                } else {
                    b.a(this.gzI, string, string2, i, i2, false);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMNotification", e, "showNotifiHandler", new Object[0]);
            }
        }
    };
    private final c gzG = new 2(this);
    private final c gzH = new 3(this);
    private String gzv;
    private String gzw;
    String gzx;
    Intent gzy;
    private boolean gzz;
    String talker;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(b bVar, String str, String str2, int i, int i2, boolean z) {
        boolean[] zArr;
        Object obj;
        x.i("MicroMsg.MMNotification", "jacks dealNotify, talker:%s, msgtype:%d, tipsFlag:%d, isRevokeMesasge:%B content:%s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), bh.VT(str2)});
        if (z) {
            zArr = new boolean[]{false, false};
        } else {
            e eVar = bVar.gzE;
            au auVar = bVar.fEJ;
            boolean z2 = bVar.gzB;
            long j = bVar.gzC;
            boolean[] zArr2 = new boolean[]{true, true};
            if (!e.a(zArr2, e.xo(), e.xq())) {
                if (!e.a(zArr2, !e.xn())) {
                    if (!(e.a(zArr2, !e.eu(str)) || e.a(zArr2, e.fs(i2), e.ft(i2)))) {
                        eVar.gAu = false;
                        if (ae.Ve("keep_app_silent")) {
                            eVar.gAu = true;
                        } else if (j <= 0) {
                            eVar.gAu = false;
                        } else if (System.currentTimeMillis() > j && System.currentTimeMillis() < j + 5000) {
                            eVar.gAu = z2;
                        }
                        String str3 = "MicroMsg.Notification.Silent.Handle";
                        String str4 = "check Refresh Keep is NOT Silent: %B";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(!eVar.gAu);
                        x.i(str3, str4, objArr);
                        if (!e.a(zArr2, !eVar.gAu)) {
                            if (!e.a(zArr2, !e.a(str, auVar))) {
                                if (zArr2[0]) {
                                    zArr2[0] = (!e.et(str) ? 1 : 0) & zArr2[0];
                                }
                                if (zArr2[0]) {
                                    zArr2[0] = zArr2[0] & e.o(i, str2);
                                }
                                e.a(zArr2, !e.xp());
                            }
                        }
                    }
                }
            }
            x.i("MicroMsg.Notification.Silent.Handle", "finally silent, sound: %B, shake: %B", new Object[]{Boolean.valueOf(zArr2[0]), Boolean.valueOf(zArr2[1])});
            zArr = zArr2;
        }
        boolean z3 = zArr[0];
        boolean z4 = zArr[1];
        boolean z5 = (z3 || z4) ? false : true;
        x.d("MicroMsg.MMNotification", "updateNotifyInfo: silent = " + z5);
        bVar.gzB = true;
        if (!z5) {
            x.d("MicroMsg.MMNotification", "updateNotifyInfo : modify lastNotSilentTime = " + bVar.gzC);
            bVar.gzC = System.currentTimeMillis();
        }
        f fVar = bVar.gzD;
        String str5 = bVar.gzv;
        c cVar = fVar.gAh.gzZ;
        x.d("MicroMsg.Notification.AppMsg.Handle", "dealCurChattingTalker, talker: %s, curChattingTalker: %s, needSound: %B, needShake: %B", new Object[]{str, str5, Boolean.valueOf(z3), Boolean.valueOf(z4)});
        if (bh.ov(str) || bh.ov(str5) || !str.equals(str5)) {
            obj = null;
        } else if ((z4 || z3) && f.zo()) {
            x.i("MicroMsg.Notification.AppMsg.Handle", "notification.shake: curChatting needShake~: %B", new Object[]{Boolean.valueOf(z4)});
            bh.m(cVar.mContext, z4);
            if (z3) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "notification.playSound: curChattingTalker: %s", new Object[]{f.zs()});
                cVar.fgv.ew(str3);
            }
            x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] is current talker end. talker[%s], current ChattingTalker[%s]. shake %B, sound: %B", new Object[]{str, str5, Boolean.valueOf(z4), Boolean.valueOf(z3)});
            obj = 1;
        } else {
            x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] is current talker chatroom & no shake & no sound");
            obj = 1;
        }
        if (obj != null) {
            x.w("MicroMsg.MMNotification", "[no notificaion], iscurrent Chatting Talker true, talker[%s] curChattingTalker[%s] needSound[%B] needShake[%B]", new Object[]{str, bVar.gzv, Boolean.valueOf(z3), Boolean.valueOf(z4)});
            return;
        }
        fVar = bVar.gzD;
        boolean z6 = bVar.gzz;
        cVar = fVar.gAh.gzZ;
        if (!z6) {
            obj = null;
        } else if ((z4 || z3) && f.zo()) {
            x.i("MicroMsg.Notification.AppMsg.Handle", "notification.shake: mainUI needShake~: %B", new Object[]{Boolean.valueOf(z4)});
            if (z4 && f.zt()) {
                bh.m(cVar.mContext, z4);
            }
            if (z3 && f.zr()) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "notification.playSound: is mainUItalker: %s", new Object[]{f.zs()});
                cVar.fgv.ew(str5);
            }
            x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] is mainUI end. shake %B, sound: %B", new Object[]{Boolean.valueOf(z4), Boolean.valueOf(z3)});
            obj = 1;
        } else {
            x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] is mainUI & no shake & no sound");
            obj = 1;
        }
        if (obj != null) {
            x.w("MicroMsg.MMNotification", "[no notificaion], isMainUI true, needSound[%B] needShake[%B]", new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)});
            return;
        }
        if (i == 436207665) {
            a fT = a.fT(bh.VH(str2));
            if (fT != null) {
                x.e("MicroMsg.MMNotification", "ljd:c2c hongbao message for c2cShowNotification is " + fT.hcO);
            }
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(bq.CTRL_INDEX);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            IDKey iDKey2;
            if (fT != null && "1002".equals(fT.hcG) && fT.hcO == 1) {
                iDKey2 = new IDKey();
                iDKey2.SetID(bq.CTRL_INDEX);
                iDKey2.SetKey(1);
                iDKey2.SetValue(1);
                arrayList.add(iDKey2);
                g.pQN.a(arrayList, true);
                x.e("MicroMsg.MMNotification", "ljd:c2c hongbao message for notification is hide!");
                return;
            } else if (fT != null && "1002".equals(fT.hcG)) {
                iDKey2 = new IDKey();
                iDKey2.SetID(bq.CTRL_INDEX);
                iDKey2.SetKey(2);
                iDKey2.SetValue(1);
                arrayList.add(iDKey2);
                g.pQN.a(arrayList, true);
                x.i("MicroMsg.MMNotification", "ljd:c2c hongbao message for notification is show!");
            }
        }
        if (i == 318767153) {
            ar.Hg();
            if (!com.tencent.mm.z.c.CU().getBoolean(w.a.xsq, true)) {
                x.i("MicroMsg.MMNotification", "It is a service notify message and the show tips switch is off. So do not show notification.");
                return;
            }
        }
        if (bVar.fEJ != null && ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fV(bVar.fEJ.field_talker)) {
            ar.Hg();
            if (!com.tencent.mm.z.c.CU().getBoolean(w.a.xsr, true)) {
                x.i("MicroMsg.MMNotification", "It is a wxa custom session notify message and the show tips switch is off. So do not show notification.");
                return;
            }
        }
        f fVar2 = bVar.gzD;
        long j2 = bVar.fEJ == null ? 0 : bVar.fEJ.field_msgSvrId;
        String str6 = bVar.gzx;
        Intent intent = bVar.gzy;
        e eVar2 = fVar2.gAh;
        if (!f.zq()) {
            e.cancel();
        }
        c cVar2 = eVar2.gzZ;
        x.i("MicroMsg.Notification.AppMsg.Handle", "in sample Notify: needSound: %B, needShake: %B, msgContent: ==, msgType: %d, talker: %s, customNotify: %s, isRevokeMessage:%b", new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), str, str6, Boolean.valueOf(z)});
        if (!f.zo()) {
            x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
        } else if (f.zp() || !(i == 64 || i == 50 || i == 52 || i == 53)) {
            String str7 = f.eU(str) ? "@bottle" : str;
            com.tencent.mm.booter.notification.a.g gVar = cVar2.fgv;
            gVar.gAN = f.eU(str7) ? f.zV() : 0;
            gVar.gAL = f.zS();
            gVar.gAM = f.zU();
            gVar.gAK = f.eT(str7);
            obj = (!z || cVar2.fgv.gAL > 0 || cVar2.fgv.gAM > 0 || cVar2.fgv.gAO) ? null : 1;
            if (obj != null) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] no refresh notify by revoke");
            } else {
                int eX;
                h hVar;
                int max;
                Notification xc = c.xc();
                com.tencent.mm.booter.notification.a.g gVar2 = cVar2.fgv;
                if (gVar2.gAN == -1) {
                    gVar2.gAN = f.eU(str7) ? f.zV() : 0;
                }
                if (gVar2.gAL == -1) {
                    gVar2.gAL = f.zS();
                }
                if (gVar2.gAM == -1) {
                    gVar2.gAM = f.zU();
                }
                if (gVar2.gAK == -1) {
                    gVar2.gAK = f.eT(str7);
                }
                gVar2.gAO = f.zq();
                gVar2.gAR = z3;
                gVar2.gAS = z4;
                gVar2.gAE.a(gVar2.mContext, z3, z4, xc, str2);
                gVar2.gAF.y(str2, i);
                d dVar = gVar2.gAG;
                Context context = gVar2.mContext;
                int i3 = gVar2.gAL;
                int i4 = gVar2.gAN;
                boolean z7 = gVar2.gAO;
                if (intent != null) {
                    dVar.Ks = intent;
                } else {
                    boolean eW = f.eW(str7);
                    if (i4 < 0) {
                        i4 = f.zV();
                    }
                    Intent intent2 = new Intent(context, LauncherUI.class);
                    intent2.putExtra("nofification_type", "new_msg_nofification");
                    intent2.putExtra("Main_User", str7);
                    intent2.putExtra("MainUI_User_Last_Msg_Type", i);
                    intent2.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                    intent2.addFlags(67108864);
                    if (z7) {
                        intent2.putExtra("talkerCount", 1);
                        if (!eW) {
                            intent2.putExtra("Intro_Is_Muti_Talker", false);
                            intent2.putExtra("Intro_Bottle_unread_count", i4);
                        }
                    } else {
                        if (i3 < 0) {
                            i3 = f.zS();
                        }
                        if (i3 > 1 || eW) {
                            intent2.putExtra("Intro_Is_Muti_Talker", true);
                        } else {
                            intent2.putExtra("Intro_Is_Muti_Talker", false);
                            intent2.putExtra("Intro_Bottle_unread_count", i4);
                        }
                        intent2.putExtra("talkerCount", i3);
                    }
                    dVar.Ks = intent2;
                }
                String quantityString;
                int i5;
                if (gVar2.gAO) {
                    String stringBuilder;
                    Object obj2;
                    h hVar2 = gVar2.gAH;
                    Context context2 = gVar2.mContext;
                    i4 = gVar2.gAN;
                    int i6 = gVar2.gAK;
                    String str8 = "";
                    z6 = f.eU(str7);
                    if (i4 < 0) {
                        i4 = f.zV();
                    }
                    if (z6) {
                        i4 = Math.max(1, i4);
                        str5 = context2.getString(R.l.epB);
                        quantityString = context2.getResources().getQuantityString(R.j.duE, i4, new Object[]{Integer.valueOf(i4)});
                        str4 = quantityString;
                    } else {
                        String str9;
                        quantityString = null;
                        if (TextUtils.isEmpty(str7)) {
                            quantityString = null;
                        } else {
                            ar.Hg();
                            com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(str7);
                            if (WO == null) {
                                quantityString = null;
                            } else {
                                if (i == 318767153 && !TextUtils.isEmpty(str2)) {
                                    quantityString = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).bK(str2, str7);
                                }
                                if (s.hk(str7)) {
                                    quantityString = WO.AP();
                                } else if (com.tencent.mm.storage.x.gy(str7)) {
                                    quantityString = context2.getString(R.l.dMG, new Object[]{h.b(WO)}).trim();
                                } else if (f.eV(str7) && bh.ov(WO.field_nickname)) {
                                    ar.Hg();
                                    str5 = com.tencent.mm.z.c.Fh().gu(str7);
                                    if (!bh.ov(str5)) {
                                        quantityString = str5;
                                    }
                                } else if (WO.AQ() != null && WO.AQ().length() > 0) {
                                    quantityString = WO.AQ();
                                }
                            }
                        }
                        if (bh.ov(quantityString)) {
                            if (f.eV(str7)) {
                                quantityString = context2.getString(R.l.dSN);
                            } else {
                                quantityString = context2.getString(R.l.epB);
                                str5 = h.a(context2, str2, str7, i);
                                str4 = str5;
                                str9 = quantityString;
                                quantityString = str5;
                                str5 = str9;
                            }
                        }
                        quantityString = com.tencent.mm.bx.b.cgX().Wj(quantityString);
                        str5 = h.a(context2, str2, str7, i);
                        str4 = str5;
                        str9 = quantityString;
                        quantityString = str5;
                        str5 = str9;
                    }
                    ar.Hg();
                    cf Ex = com.tencent.mm.z.c.Fa().Ex(str7);
                    boolean eV = f.eV(str7);
                    if (eV) {
                        eX = f.eX(str7);
                        boolean eW2 = f.eW(str7);
                        if (eX > 0) {
                            StringBuilder append = new StringBuilder().append(context2.getString(R.l.eud));
                            if (eW2) {
                                quantityString = "";
                            } else if (i6 <= 1) {
                                quantityString = " " + str2;
                            }
                            stringBuilder = append.append(quantityString).toString();
                            if (z) {
                                str4 = null;
                                obj2 = null;
                            } else if (bh.ov(str6)) {
                                obj2 = null;
                                str4 = str6;
                            } else if (Ex == null && Ex.field_bizChatId != -1 && com.tencent.mm.ag.f.eE(str7)) {
                                com.tencent.mm.ag.a.c ag = y.Mh().ag(Ex.field_bizChatId);
                                if (ag.Mt()) {
                                    quantityString = bh.ov(ag.field_chatName) ? ac.getContext().getString(R.l.eFx) + ": " + h.ez(str4) : ag.field_chatName + ": " + h.ez(str4);
                                } else {
                                    j ca = y.Mj().ca(Ex.field_bizChatUserId);
                                    quantityString = ca != null ? bh.ov(ca.field_userName) ? h.ez(str4) : ca.field_userName + ": " + h.ez(str4) : str8;
                                }
                                if (bh.ov(quantityString)) {
                                    quantityString = str5 + ": " + h.ez(str4);
                                }
                                i5 = 1;
                                str4 = quantityString;
                            } else if (!eV) {
                                str4 = str5 + ": " + h.ez(str4);
                                obj2 = null;
                            } else if (str4.contains(":\n")) {
                                str4 = h.ez(str4);
                                obj2 = null;
                            } else {
                                str4 = (str4.contains(":\n") ? str4.substring(0, str4.indexOf(":\n")) : h.g(context2, str7, str4)) + ": " + h.ez(ba.hQ(str4));
                                obj2 = null;
                            }
                            quantityString = z ? eV ? str2 : context2.getString(R.l.eze) : str4;
                            if (i6 > 1) {
                                quantityString = context2.getResources().getQuantityString(R.j.duF, i6, new Object[]{Integer.valueOf(i6)}) + quantityString;
                            } else if (!eV) {
                                quantityString = obj2 == null ? str4 : stringBuilder;
                            }
                            hVar2.mTitle = str5;
                            hVar2.gAT = quantityString;
                            hVar = hVar2;
                        }
                    }
                    stringBuilder = quantityString;
                    if (z) {
                        str4 = null;
                        obj2 = null;
                    } else if (bh.ov(str6)) {
                        if (Ex == null) {
                        }
                        if (!eV) {
                            str4 = str5 + ": " + h.ez(str4);
                            obj2 = null;
                        } else if (str4.contains(":\n")) {
                            str4 = h.ez(str4);
                            obj2 = null;
                        } else {
                            if (str4.contains(":\n")) {
                            }
                            str4 = (str4.contains(":\n") ? str4.substring(0, str4.indexOf(":\n")) : h.g(context2, str7, str4)) + ": " + h.ez(ba.hQ(str4));
                            obj2 = null;
                        }
                    } else {
                        obj2 = null;
                        str4 = str6;
                    }
                    if (z) {
                        if (eV) {
                        }
                    }
                    if (i6 > 1) {
                        quantityString = context2.getResources().getQuantityString(R.j.duF, i6, new Object[]{Integer.valueOf(i6)}) + quantityString;
                    } else if (eV) {
                        if (obj2 == null) {
                        }
                    }
                    hVar2.mTitle = str5;
                    hVar2.gAT = quantityString;
                    hVar = hVar2;
                } else {
                    h hVar3 = gVar2.gAH;
                    context = gVar2.mContext;
                    i5 = gVar2.gAL;
                    i4 = gVar2.gAM;
                    int i7 = gVar2.gAN;
                    if (i5 < 0) {
                        i5 = f.zS();
                    }
                    if (i4 < 0) {
                        i4 = f.zU();
                    }
                    i5 = Math.max(1, i5);
                    max = Math.max(1, i4);
                    i4 = i7 >= 0 ? i7 : f.zV();
                    quantityString = (i5 != 1 || i4 <= 0) ? context.getResources().getQuantityString(R.j.duG, i5, new Object[]{Integer.valueOf(i5), Integer.valueOf(max)}) : context.getResources().getQuantityString(R.j.duE, i4, new Object[]{Integer.valueOf(i4)});
                    if (f.eX(null) > 0) {
                        quantityString = context.getString(R.l.eud) + quantityString;
                    }
                    hVar3.gAT = quantityString;
                    hVar3.mTitle = context.getString(R.l.epB);
                    if (z) {
                        str4 = null;
                        hVar = hVar3;
                    } else {
                        str4 = context.getString(R.l.ezf);
                        hVar = hVar3;
                    }
                }
                hVar.gAU = str4;
                com.tencent.mm.booter.notification.a.a aVar = gVar2.gAJ;
                z5 = gVar2.gAO;
                if (!(z5 || aVar.gAq == null)) {
                    x.i("MicroMsg.NotificationAvatar", "recycle bitmap:%s", new Object[]{aVar.gAq.toString()});
                    aVar.gAq.recycle();
                }
                aVar.gAq = null;
                Context context3 = ac.getContext();
                if (z5 && !f.eU(str7)) {
                    Bitmap bitmap;
                    if (context3 == null || t.ov(str7)) {
                        bitmap = null;
                    } else {
                        bitmap = com.tencent.mm.ad.b.a(str7, false, -1);
                        bitmap = bitmap == null ? null : com.tencent.mm.booter.notification.a.a.b(context3, bitmap);
                    }
                    aVar.gAq = bitmap;
                }
                i4 = com.tencent.mm.booter.notification.queue.b.xi().er(str7);
                eX = cVar2.fgv.gAF.gAs;
                max = cVar2.fgv.gAE.gAr;
                gVar = cVar2.fgv;
                dVar = gVar.gAG;
                NotificationItem notificationItem = new NotificationItem(i4, str7, cVar2.a(xc, eX, max, dVar.Ks == null ? null : d.a(gVar.mContext, i4, dVar.Ks), cVar2.fgv.gAH.mTitle, cVar2.fgv.gAH.gAT, cVar2.fgv.gAH.gAU, cVar2.fgv.gAJ.gAq, str7));
                notificationItem.gAc = j2;
                notificationItem.gAd = f.eT(str7);
                cVar2.a(notificationItem, cVar2.fgv);
                com.tencent.mm.booter.notification.a.g gVar3 = cVar2.fgv;
                gVar3.gAN = -1;
                gVar3.gAL = -1;
                gVar3.gAM = -1;
                gVar3.gAK = -1;
            }
        } else {
            x.i("MicroMsg.Notification.AppMsg.Handle", "NotificationConfig.isNewVoipMsgNotification() is false,msgType is " + i);
        }
        com.tencent.mm.sdk.b.b kdVar = new kd();
        kdVar.fBv.talker = str;
        kdVar.fBv.fBw = !z3;
        kdVar.fBv.fBx = z4;
        kdVar.fBv.fnm = f.eT(str);
        com.tencent.mm.sdk.b.a.xef.m(kdVar);
        bVar.gzA = com.tencent.mm.z.t.hw(s.hfk);
    }

    public b(Context context) {
        this.context = context;
        this.talker = "";
        this.gzx = "";
        this.gzv = "";
        this.gzC = 0;
        this.gzB = false;
        this.gzy = null;
        this.gzE = new e();
        q.a(this);
        com.tencent.mm.modelvoice.e.a(this);
        com.tencent.mm.plugin.base.stub.b.a(this);
        com.tencent.mm.sdk.b.a.xef.b(this.gzH);
        com.tencent.mm.sdk.b.a.xef.b(this.gzG);
    }

    public final void eo(String str) {
        this.gzv = str;
    }

    public final String wX() {
        return this.gzv;
    }

    public final void aU(boolean z) {
        x.i("MicroMsg.MMNotification", "set isMainUI: %s, stack[%s]", new Object[]{Boolean.valueOf(z), bh.cgy()});
        this.gzz = z;
    }

    public final void cancelNotification(String str) {
        Object obj = 1;
        x.v("MicroMsg.MMNotification", "cancel notification talker:" + str + " last talker:" + this.gzw + "  curChattingTalker:" + this.gzv + " talker count:" + this.gzA);
        if (this.gzB) {
            if (!(this.gzw != null && this.gzw.equals(this.gzv) && this.gzA == 1)) {
                obj = null;
            }
            if (obj != null) {
                cancel();
                return;
            }
            ar.Hg();
            com.tencent.mm.g.b.aj WY = com.tencent.mm.z.c.Fd().WY(str);
            if (WY != null && WY.field_unReadCount != 0) {
                cancel();
            } else if (com.tencent.mm.z.t.hv(s.hfk) == 0) {
                cancel();
            }
        }
    }

    public final void wY() {
        try {
            String string = ac.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
            if (string != null) {
                for (String VI : string.split(",")) {
                    int VI2 = bh.VI(VI);
                    if (VI2 > 0) {
                        ar.getNotification().cancel(VI2);
                    }
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMNotification", e, "try cancel notification fail: %s", new Object[]{e.getMessage()});
        }
    }

    public final void up() {
        x.d("MicroMsg.MMNotification", "force cancelNotification");
        cancel();
    }

    private void cancel() {
        this.gzB = false;
        e.cancel();
    }

    public final void a(au auVar) {
        if (auVar != null) {
            if (auVar.field_isSend == 1) {
                x.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[]{Long.valueOf(auVar.field_msgSvrId)});
                return;
            }
            com.tencent.mm.z.ba.b hT = ba.hT(auVar.gjF);
            if (hT == null || hT.scene != 1) {
                int d = f.d(auVar);
                this.fEJ = auVar;
                this.talker = auVar.field_talker;
                String str = auVar.field_content;
                int type = auVar.getType();
                this.gzx = "";
                this.gzy = null;
                x.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[]{this.talker, Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(d), bh.VT(str)});
                if (this.gzD.a(this.talker, this.fEJ, d, false)) {
                    this.gzF.sendMessageDelayed(a(this.talker, str, type, d, 0), 200);
                } else {
                    x.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                }
            }
        }
    }

    static Message a(String str, String str2, int i, int i2, int i3) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("notification.show.talker", str);
        bundle.putString("notification.show.message.content", str2);
        bundle.putInt("notification.show.message.type", i);
        bundle.putInt("notification.show.tipsflag", i2);
        obtain.setData(bundle);
        obtain.what = i3;
        return obtain;
    }

    public final Looper getLooper() {
        return Looper.getMainLooper();
    }

    public final void y(List<au> list) {
        int i;
        if (list == null || list.size() <= 0) {
            String str = "MicroMsg.MMNotification";
            String str2 = "notifyOther newMsgList:%d :%s";
            Object[] objArr = new Object[2];
            if (list == null) {
                i = -1;
            } else {
                i = list.size();
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        cf cfVar;
        int size = list.size() - 1;
        i = 0;
        while (size >= 0) {
            cf cfVar2 = (au) list.get(size);
            int d = f.d(cfVar2);
            if (this.gzD.a(cfVar2.field_talker, cfVar2, d, false)) {
                int i2 = d;
                cfVar = cfVar2;
                i = i2;
                break;
            }
            size--;
            i = d;
        }
        cfVar = null;
        if (cfVar == null) {
            x.w("MicroMsg.MMNotification", "notifyOther msg == null");
            return;
        }
        this.gzx = "";
        this.talker = cfVar.field_talker;
        str2 = cfVar.field_content;
        size = cfVar.getType();
        this.fEJ = cfVar;
        x.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[]{this.talker, Long.valueOf(cfVar.field_msgSvrId), Integer.valueOf(size), Integer.valueOf(i), bh.VT(str2)});
        this.gzF.sendMessageDelayed(a(this.talker, str2, size, i, 0), 200);
    }

    public final void ep(String str) {
        Intent intent = new Intent(this.context, LauncherUI.class);
        intent.putExtra("Intro_Notify", true);
        intent.putExtra("Intro_Notify_User", this.talker);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.addFlags(67108864);
        if (!bh.ov(str) && str.startsWith("autoauth_errmsg_")) {
            str = str.substring(16);
        }
        if (!bh.ov(str) && str.startsWith("<")) {
            Map y = bi.y(str, "e");
            if (!(y == null || bh.ov((String) y.get(".e.Content")))) {
                str = (String) y.get(".e.Content");
            }
        }
        Notification notification = new Builder(this.context).setContentTitle(str).setContentText(null).setContentIntent(PendingIntent.getActivity(this.context, 0, intent, SQLiteDatabase.CREATE_IF_NECESSARY)).getNotification();
        notification.icon = com.tencent.mm.bl.a.bXV();
        notification.flags = 16;
        a(notification, true);
    }

    public final void fk(int i) {
        Intent intent = new Intent(this.context, LauncherUI.class);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.addFlags(67108864);
        intent.putExtra("nofification_type", "update_nofification");
        intent.putExtra("show_update_dialog", true);
        intent.putExtra("update_type", i);
        Notification notification = new Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.dGT)).setContentText(this.context.getString(R.l.dGr)).setContentIntent(PendingIntent.getActivity(this.context, 0, intent, 0)).getNotification();
        notification.flags |= 16;
        a(34, notification, false);
    }

    @TargetApi(16)
    public final boolean wZ() {
        boolean z = true;
        x.d("MicroMsg.MMNotification", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", new Object[]{((RunningTaskInfo) ((ActivityManager) this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName()});
        if (MobileVerifyUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
            z = false;
        }
        if (z) {
            Notification build;
            Intent intent = new Intent(this.context, MobileVerifyUI.class);
            intent.addFlags(2);
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.addFlags(67108864);
            intent.putExtra("nofification_type", "no_reg_notification");
            PendingIntent activity = PendingIntent.getActivity(this.context, 36, intent, 1073741824);
            if (VERSION.SDK_INT >= 16) {
                Builder builder = new Builder(this.context);
                builder.setContentTitle(this.context.getString(R.l.dGq));
                builder.setSmallIcon(com.tencent.mm.bl.a.bXV());
                builder.setWhen(System.currentTimeMillis());
                builder.setContentIntent(activity);
                build = new BigTextStyle(builder).bigText(this.context.getString(R.l.eva)).build();
                build.defaults |= 1;
                build.flags |= 16;
            } else {
                build = new Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.dGq)).setContentText(this.context.getString(R.l.eva)).setContentIntent(activity).getNotification();
                build.icon = com.tencent.mm.bl.a.bXV();
                build.defaults |= 1;
                build.flags |= 16;
            }
            a(36, build, false);
        }
        return z;
    }

    public final void xa() {
        cancel(36);
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
        com.tencent.mm.bm.d.a("webview", new l$1(str3, str4, bundle, str, str2, i), new 2());
    }

    public final Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i2, String str4, PendingIntent pendingIntent2, int i3, String str5, PendingIntent pendingIntent3, String str6) {
        return f$a.gAi.gAh.gzZ.a(notification, i, 1, pendingIntent, str, str2, str3, bitmap, i2, str4, pendingIntent2, i3, str5, pendingIntent3, str6);
    }

    public final void n(int i, String str) {
        f$a.gAi.n(i, str);
    }

    public final void xb() {
        f$a.gAi;
        c.xb();
    }

    public final void fl(int i) {
        d.fo(i);
    }

    public final void v(String str, int i) {
        d.w(str, i);
    }

    public final void aV(boolean z) {
        d.aW(z);
    }

    public final void fm(int i) {
        f$a.gAi;
        if (i != 0) {
            List<Integer> fp = com.tencent.mm.booter.notification.queue.b.xi().gAo.fp(i);
            if (!fp.isEmpty()) {
                ag j = ag.j(ac.getContext());
                for (Integer intValue : fp) {
                    com.tencent.mm.booter.notification.queue.b.xi().a(j, intValue.intValue());
                }
            }
        }
    }

    public final void notify(int i, Notification notification) {
        a(i, notification, true);
    }

    public final void a(int i, Notification notification, boolean z) {
        f$a.gAi.a(new NotificationItem(i, notification, z));
    }

    public final int a(Notification notification, boolean z) {
        return f$a.gAi.a(new NotificationItem(notification, z));
    }

    public final int b(Notification notification) {
        return a(notification, true);
    }

    public final void cancel(int i) {
        f$a.gAi;
        com.tencent.mm.booter.notification.queue.b.xi().cancel(i);
    }

    public final Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a(null, -1, 0, pendingIntent, str, str2, str3, bitmap, str4);
    }

    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return f$a.gAi.gAh.gzZ.a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
    }
}
