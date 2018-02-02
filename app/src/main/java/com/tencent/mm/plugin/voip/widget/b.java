package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.VoipWarningDialog;
import com.tencent.mm.plugin.voip.ui.VoipWarningDialog.a;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import com.tencent.pb.common.c.g;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b implements com.tencent.mm.plugin.voip.ui.b {
    private static final String ffq;
    private static final String ffr;
    private int mStatus = -1;
    private CaptureView slO;
    private x slS;
    private boolean slT;
    private boolean slU;
    private int slY = 1;
    private long slZ = -1;
    private boolean sne = false;
    private ak ssv;
    private c svC;
    private BaseSmallView svD;
    private ak svE;
    private WakeLock svF;
    private long svG = -1;
    private boolean svH = false;
    private OnClickListener svI = new OnClickListener(this) {
        final /* synthetic */ b svK;

        {
            this.svK = r1;
        }

        public final void onClick(View view) {
            if (this.svK.svD != null) {
                this.svK.svD.setOnClickListener(null);
            }
            this.svK.ssv = new ak(new 1(this), false);
            this.svK.ssv.J(2000, 2000);
            Intent intent = new Intent(ac.getContext(), VideoActivity.class);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ac.getContext().startActivity(intent);
        }
    };
    private ak svJ;

    static {
        String yF = q.yF();
        ffq = yF;
        ffr = o.getString(yF.hashCode());
    }

    public b(c cVar, int i, x xVar, boolean z, boolean z2, boolean z3) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[]{com.tencent.mm.plugin.voip.b.b.yP(i), xVar.field_username, Boolean.valueOf(z)});
        this.slS = xVar;
        this.svC = cVar;
        this.slU = z;
        this.slT = z2;
        this.sne = z3;
        dQ(0, i);
        this.svF = ((PowerManager) ac.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
        this.svF.acquire();
    }

    public final void yL(int i) {
    }

    public final void setMute(boolean z) {
    }

    public final void dQ(int i, int i2) {
        Integer num = null;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", new Object[]{com.tencent.mm.plugin.voip.b.b.yP(i2)});
        if (i2 == this.mStatus) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
            return;
        }
        this.mStatus = i2;
        String string;
        switch (i2) {
            case 0:
            case 2:
            case 4:
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "showVideoInviting");
                if (this.svD != null) {
                    num = (Integer) this.svD.getTag();
                }
                if (num == null || !(num.intValue() == 0 || 2 == num.intValue() || 4 == num.intValue())) {
                    string = ac.getContext().getString(R.l.eVS);
                    e(string, string, "", true);
                    if (this.svC != null) {
                        this.svC.a(this, 2);
                        return;
                    }
                    return;
                }
                return;
            case 1:
            case 3:
            case 5:
            case 257:
            case 259:
                if (2 == this.slY) {
                    yW(R.l.eUc);
                }
                bIQ();
                string = ac.getContext().getString(R.l.eVZ);
                e(string, r.gu(this.slS.field_username), string, true);
                bIO();
                if (this.svC != null) {
                    this.svC.a(this, 2);
                    return;
                }
                return;
            case 6:
            case GameJsApiLaunchApplication.CTRL_BYTE /*260*/:
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
                this.svH = true;
                if (-1 == this.svG) {
                    this.svG = System.currentTimeMillis();
                }
                if (this.svC != null) {
                    this.svC.a(this, 2);
                }
                if (com.tencent.mm.compatible.e.b.aM(ac.getContext())) {
                    bIM();
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking, permission denied");
                    VoipWarningDialog.a(ac.getContext(), new a(this) {
                        final /* synthetic */ b svK;

                        {
                            this.svK = r1;
                        }

                        public final void a(VoipWarningDialog voipWarningDialog) {
                            voipWarningDialog.finish();
                            String string = ac.getContext().getString(R.l.eVS);
                            this.svK.e(string, r.gu(this.svK.slS.field_username), string, false);
                            if (com.tencent.mm.plugin.voip.b.b.yU(this.svK.mStatus) || com.tencent.mm.plugin.voip.b.b.yS(this.svK.mStatus)) {
                                this.svK.bIM();
                            }
                        }

                        public final void b(VoipWarningDialog voipWarningDialog) {
                            voipWarningDialog.finish();
                        }
                    });
                    if (!d.bGj().snc) {
                        d.bGj().snc = true;
                        ar.Hg();
                        if (System.currentTimeMillis() - com.tencent.mm.z.c.CU().Dm(327950) > 86400000) {
                            String str = "have not permission to showing floating window\n";
                            ar.Hg();
                            com.tencent.mm.z.c.CU().setLong(327950, System.currentTimeMillis());
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + str.length());
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.vAz).append("\n");
                            stringBuilder.append("#accinfo.revision=").append(e.REV).append("\n");
                            stringBuilder.append("#accinfo.uin=").append(aq.hfP.H("last_login_uin", ffr)).append("\n");
                            stringBuilder.append("#accinfo.dev=").append(ffq).append("\n");
                            stringBuilder.append("#accinfo.build=").append(e.TIME).append(":").append(e.HOSTNAME).append(":").append(f.fdS).append("\n");
                            Date date = new Date();
                            stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
                            stringBuilder.append("#accinfo.content:\n");
                            Intent intent = new Intent();
                            intent.setClassName(ac.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
                            intent.setAction("uncatch_exception");
                            intent.putExtra("exceptionWriteSdcard", false);
                            intent.putExtra("exceptionPid", Process.myPid());
                            String str2 = "userName";
                            string = aq.hfP.H("login_weixin_username", "");
                            if (bh.ov(string)) {
                                string = aq.hfP.H("login_user_name", "never_login_crash");
                            }
                            intent.putExtra(str2, string);
                            intent.putExtra("tag", "float_window_permission");
                            intent.putExtra("exceptionMsg", Base64.encodeToString((stringBuilder.toString() + str).getBytes(), 2));
                            ac.getContext().startService(intent);
                        }
                    }
                }
                string = ac.getContext().getString(R.l.eVS);
                e(string, r.gu(this.slS.field_username), string, false);
                return;
            case 7:
            case 261:
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
                if (-1 == this.svG) {
                    this.svG = System.currentTimeMillis();
                }
                if (2 == this.slY) {
                    yW(R.l.eUc);
                }
                bIQ();
                if (this.svC != null) {
                    this.svC.a(this, 2);
                }
                this.svE = new ak(new ak.a(this) {
                    final /* synthetic */ b svK;

                    {
                        this.svK = r1;
                    }

                    public final boolean uF() {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + this.svK.mStatus);
                        if (this.svK.mStatus == 8 || this.svK.mStatus == 262 || !com.tencent.mm.plugin.voip.b.d.bIq()) {
                            ar.getNotification().cancel(40);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking...CALLING_STATE_FINISH state..cancel notification..");
                            if (this.svK.svE == null || this.svK.svE.cfK()) {
                                return false;
                            }
                            this.svK.svE.TG();
                            return false;
                        }
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "show voice talking, first timer trigger..");
                        String h = this.svK.bIP();
                        this.svK.e(h, r.gu(this.svK.slS.field_username), h, false);
                        return true;
                    }
                }, true);
                this.svE.J(5000, 5000);
                string = bIP();
                e(string, r.gu(this.slS.field_username), string, false);
                bIO();
                if (4101 == i) {
                    yW(R.l.eVM);
                    return;
                }
                return;
            case 8:
            case 262:
                int i3;
                switch (i) {
                    case 4099:
                        if (!this.slU) {
                            i3 = R.l.eUb;
                            break;
                        } else {
                            i3 = R.l.eVR;
                            break;
                        }
                    case 4105:
                        i3 = R.l.eVB;
                        break;
                    case 4106:
                        i3 = R.l.eVK;
                        break;
                    default:
                        bIQ();
                        return;
                }
                yW(i3);
                bIQ();
                return;
            case 256:
            case 258:
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "showCalledVideoInviting");
                if (this.svD != null) {
                    num = (Integer) this.svD.getTag();
                }
                if (num == null || !(256 == num.intValue() || 258 == num.intValue())) {
                    string = ac.getContext().getString(R.l.eVS);
                    e(string, string, "", true);
                    if (this.svC != null) {
                        this.svC.a(this, 2);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void yW(int i) {
        Context context = ac.getContext();
        Toast.makeText(context, context.getString(i), 1).show();
    }

    private void bIM() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "show mini..");
        bIQ();
        Context context = ac.getContext();
        d.bGj();
        this.svD = new a(context, m.jk(false));
        this.svD.fe(this.slZ);
        context = ac.getContext();
        d.bGj();
        int height = (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight() / 5) + com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 7.0f);
        int b = (int) (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 7.0f)) + (m.jk(true) * ((float) height)));
        this.svD.dU(b, height);
        this.svD.setOnClickListener(this.svI);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
        Point point = new Point(b, height);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
        if (com.tencent.mm.plugin.voip.b.b.yU(this.mStatus) || com.tencent.mm.plugin.voip.b.b.yS(this.mStatus)) {
            if (this.svE != null) {
                this.svE.TG();
            }
            if (this.svJ != null) {
                this.svJ.TG();
            }
            if (this.ssv != null) {
                this.ssv.TG();
            }
            ar.getNotification().cancel(40);
            WindowManager windowManager = (WindowManager) ac.getContext().getSystemService("window");
            LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2002;
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.gravity = 51;
            context = ac.getContext();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.width = point.x;
            layoutParams.height = point.y;
            point = d.bGj().snb;
            if (point == null) {
                ar.Hg();
                int i = com.tencent.mm.z.c.CU().getInt(327947, 0);
                b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 5.0f);
                layoutParams.x = (displayMetrics.widthPixels - layoutParams.width) - b;
                layoutParams.y = b + i;
            } else {
                layoutParams.x = point.x;
                layoutParams.y = point.y;
            }
            if (this.slO != null) {
                if (this.slO.getParent() != null && (this.slO.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.slO.getParent()).removeView(this.slO);
                }
                this.svD.a(this.slO);
            }
            this.svD.setTag(Integer.valueOf(this.mStatus));
            try {
                windowManager.addView(this.svD, layoutParams);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager failed: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
    }

    public final String bIN() {
        String format;
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.slZ);
        if (this.slZ == -1) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 3600) {
            format = String.format(Locale.US, "%d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        } else {
            format = String.format(Locale.US, "%d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        if (g.AA(format)) {
            return "00:00";
        }
        return format;
    }

    private void bIO() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
        boolean z = false;
        if (this.mStatus == 261 || this.mStatus == 7) {
            this.svJ = new ak(new 4(this), true);
            this.svJ.J(1000, 1000);
            z = true;
        }
        Intent intent = new Intent();
        intent.setClass(ac.getContext(), VideoActivity.class);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("Voip_User", this.slS.field_username);
        intent.putExtra("Voip_Outcall", this.slT);
        intent.putExtra("Voip_VideoCall", this.slU);
        intent.putExtra("Voip_Is_Talking", z);
        d.bGk().a(intent, new 5(this));
    }

    private String bIP() {
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.slZ);
        if (this.slZ == -1) {
            currentTimeMillis = 0;
        }
        String string = ac.getContext().getString(R.l.eVZ);
        if (currentTimeMillis >= 3600) {
            return string + String.format(Locale.US, "    %d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        return string + String.format(Locale.US, "    %d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
    }

    public final void e(String str, String str2, String str3, boolean z) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + str + ",title:" + str2 + ",content:" + str3 + ",breathEffect:" + z);
        com.tencent.mm.sdk.platformtools.x.j("MicroMsg.Voip.VoipSmallWindow", "breathEffect " + z, new Object[0]);
        if (z) {
            this.svE = new ak(new 6(this, str, str2, str3), true);
            this.svE.J(5000, 5000);
        }
        Intent intent = new Intent();
        intent.setClass(ac.getContext(), VideoActivity.class);
        intent.putExtra("Voip_User", this.slS.field_username);
        intent.putExtra("Voip_Outcall", this.slT);
        intent.putExtra("Voip_VideoCall", this.slU);
        Notification a = com.tencent.mm.plugin.voip.b.d.a(new Builder(ac.getContext()).setTicker(str).setWhen(System.currentTimeMillis()).setContentTitle(str2).setContentText(str3).setContentIntent(PendingIntent.getActivity(ac.getContext(), 40, intent, 134217728)).setOngoing(true));
        a.icon = VERSION.SDK_INT < 19 ? R.g.bEp : R.g.bEq;
        ar.getNotification().a(40, a, false);
    }

    private void bIQ() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView");
        if (this.svE != null) {
            this.svE.TG();
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "remove small view..cancel notification first..");
        ar.getNotification().cancel(40);
        if (this.svD != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.svD.getLayoutParams();
            d.bGj().snb = new Point(layoutParams.x, layoutParams.y);
            this.svD.uninit();
            try {
                ((WindowManager) ac.getContext().getSystemService("window")).removeView(this.svD);
            } catch (IllegalArgumentException e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VoipSmallWindow", "remove failed", new Object[]{e});
            }
            this.svD = null;
        }
        d.bGk().ME(ac.getContext().getString(R.l.evX));
        if (this.svJ != null) {
            this.svJ.TG();
        }
        d.bGk().dismiss();
    }

    public final void aJ(int i, String str) {
        int i2;
        if (i == GameJsApiGetGameCommInfo.CTRL_BYTE) {
            Toast.makeText(ac.getContext(), str, 1).show();
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode " + i);
        if (i == 235) {
            i2 = R.l.eVe;
        } else if (i == 233) {
            d.bGj().bHu();
            i2 = R.l.eVd;
        } else {
            i2 = i == bd.CTRL_BYTE ? (!com.tencent.mm.ar.b.PT() || this.slU) ? R.l.eVf : R.l.eVh : i == JsApiGetSetting.CTRL_INDEX ? R.l.eVr : i == h.CTRL_INDEX ? R.l.eVg : 0;
        }
        if (i2 == 0) {
            yW(R.l.eVc);
        } else {
            yW(i2);
        }
    }

    public final void MD(String str) {
    }

    public final void b(int i, int i2, int[] iArr) {
        if ((GameJsApiLaunchApplication.CTRL_BYTE == this.mStatus || 6 == this.mStatus) && this.svD != null) {
            this.svD.b(i, i2, iArr);
        }
    }

    public final void bGZ() {
        if (this.svD != null) {
            this.svD.bGZ();
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if ((GameJsApiLaunchApplication.CTRL_BYTE == this.mStatus || 6 == this.mStatus) && this.svD != null) {
            this.svD.a(bArr, j, i, i2, i3, i4, i5);
        }
    }

    public final Context bIa() {
        return null;
    }

    public final void uninit() {
        int i = 3;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
        if (-1 != this.svG) {
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[3];
            if (this.svH) {
                i = 2;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Long.valueOf((System.currentTimeMillis() - this.svG) / 1000);
            objArr[2] = Integer.valueOf(this.sne ? 1 : 2);
            gVar.h(11620, objArr);
        }
        if (this.svF != null && this.svF.isHeld()) {
            this.svF.release();
        }
        bIQ();
        if (this.svE != null) {
            this.svE.TG();
        }
        if (this.svJ != null) {
            this.svJ.TG();
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
        ar.getNotification().cancel(40);
        this.slO = null;
    }

    public final void fe(long j) {
        this.slZ = j;
        if (this.svD != null) {
            this.svD.fe(j);
        } else if (261 == this.mStatus || 7 == this.mStatus) {
            String bIP = bIP();
            e(bIP, r.gu(this.slS.field_username), bIP, false);
        }
    }

    public final void bIb() {
        Toast.makeText(ac.getContext(), R.l.eVy, 1).show();
    }

    public final void aUI() {
    }

    public final void a(CaptureView captureView) {
        this.slO = captureView;
        if (this.svD != null && this.slO != null) {
            if (this.slO.getParent() != null && (this.slO.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.slO.getParent()).removeView(this.slO);
            }
            this.svD.a(captureView);
        }
    }
}
