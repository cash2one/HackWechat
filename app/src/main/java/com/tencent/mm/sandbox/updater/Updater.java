package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ay.q;
import com.tencent.mm.c.i;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.be;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.pluginsdk.q.s;
import com.tencent.mm.protocal.c.agw;
import com.tencent.mm.protocal.c.ass;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.a.a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class Updater extends LinearLayout implements e, s {
    private boolean fpa;
    private int xcb;
    private r xdh = null;
    private boolean xdi = false;
    private boolean xdj = false;
    private boolean xdk = false;
    private e xdl;
    private e xdm;

    static /* synthetic */ void a(Updater updater, Intent intent, com.tencent.mm.network.e eVar, a aVar) {
        intent.putExtra("intent_short_ips", bZi());
        intent.putExtra("intent_client_version", d.vAz);
        intent.putExtra("intent_extra_session", eVar.Kx().CF());
        intent.putExtra("intent_extra_cookie", eVar.Kx().Ks());
        intent.putExtra("intent_extra_ecdhkey", eVar.Kx().Ku());
        intent.putExtra("intent_extra_uin", eVar.Kx().Cg());
        intent.putExtra("intent_update_type", updater.xcb);
        intent.putExtra("intent_extra_desc", ((agw) aVar.gJQ.hmh.hmo).woj);
        intent.putExtra("intent_extra_md5", aVar.ced());
        intent.putExtra("intent_extra_size", aVar.cec());
        intent.putExtra("intent_extra_download_url", aVar.bYb());
        intent.putExtra("intent_extra_patchInfo", aVar.cee());
        intent.putExtra("intent_extra_updateMode", f.fdU);
        intent.putExtra("intent_extra_marketUrl", f.xez);
        x.d("MicroMsg.NetSceneGetUpdateInfo", "summerupdate extInfo[%s], stack[%s]", new Object[]{bh.ou(n.b(((agw) aVar.gJQ.hmh.hmo).woq)), bh.cgy()});
        intent.putExtra("intent_extra_extinfo", r0);
    }

    private Updater(Context context) {
        super(context);
    }

    public Updater(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void onStart() {
        ar.CG().a(11, this);
        g.pQN.a(405, 42, 1, true);
    }

    public final void onStop() {
        g.pQN.a(405, 43, 1, true);
        cancel();
    }

    public static Updater c(Context context, OnCancelListener onCancelListener) {
        if (context == null) {
            return null;
        }
        if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) context).getWindow() == null)) {
            x.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
            return null;
        }
        ac.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bh.Wo()).commit();
        ar.getNotification().cancel(34);
        x.i("MicroMsg.Updater", "showWithProgress");
        Updater updater = (Updater) View.inflate(context, R.i.dtp, null);
        updater.onStart();
        r a = r.a(context, context.getString(R.l.eRW), true, 0, null);
        a.setCancelable(true);
        a.setOnCancelListener(new 1(updater, onCancelListener));
        try {
            updater.xdh = a;
            updater.xdh.show();
            updater.fpa = true;
            g.pQN.a(405, 46, 1, true);
            return updater;
        } catch (Throwable e) {
            x.e("MicroMsg.Updater", "exception in showWithProgress, ", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.Updater", e, "", new Object[0]);
            return null;
        }
    }

    public static Updater d(Context context, final OnCancelListener onCancelListener) {
        ac.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bh.Wo()).commit();
        ar.getNotification().cancel(34);
        x.i("MicroMsg.Updater", "show update dialog");
        final Updater updater = (Updater) View.inflate(context, R.i.dtp, null);
        updater.onStart();
        r a = r.a(context, "", true, 0, null);
        a.setCancelable(true);
        a.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                ar.getNotification().cancel(99);
                g.pQN.a(405, 49, 1, true);
                Updater.CY(2);
                updater.onStop();
                if (!updater.xdi && onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        g.pQN.a(405, 48, 1, true);
        updater.xdh = a;
        updater.fpa = false;
        return updater;
    }

    public static Updater eE(Context context) {
        ac.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bh.Wo()).commit();
        ar.getNotification().cancel(34);
        g.pQN.a(405, 50, 1, true);
        x.i("MicroMsg.Updater", "updater silence");
        Updater updater = new Updater(context);
        updater.onStart();
        updater.xdj = true;
        return updater;
    }

    public static void ds(Context context) {
        context.startActivity(new Intent(context, AppInstallerUI.class));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            g.pQN.a(405, 51, 1, true);
            x.i("MicroMsg.Updater", "isShow " + this.fpa);
            if (!(this.fpa || this.xdh == null)) {
                this.xdh.show();
            }
            this.xdi = true;
            if (this.xdh != null) {
                this.xdh.cancel();
            }
            final a aVar = (a) kVar;
            ar.CG().a(new bd(new bd.a(this) {
                final /* synthetic */ Updater xdq;

                public final void a(com.tencent.mm.network.e eVar) {
                    long j;
                    String bYY;
                    if (eVar == null) {
                        g.pQN.a(405, 52, 1, true);
                        Assert.assertTrue("updater invalid assert", false);
                    }
                    ar.getNotification().cancel(34);
                    x.i("MicroMsg.Updater", "go to update");
                    if (!h.getExternalStorageState().equals("mounted")) {
                        x.e("MicroMsg.Updater", "no sdcard.");
                        g.pQN.a(405, 53, 1, true);
                        this.xdq.xdj = false;
                    }
                    int cec = aVar.cec();
                    i cj = i.cj(aVar.cee());
                    String ek = p.ek(this.xdq.getContext());
                    i.a aVar = null;
                    if (cj != null) {
                        aVar = cj.ci(ek);
                    }
                    if (aVar == null) {
                        j = (long) cec;
                    } else {
                        j = (long) (aVar.size + cec);
                    }
                    if (!com.tencent.mm.compatible.util.f.aC(j)) {
                        x.e("MicroMsg.Updater", "no enough space.");
                        g.pQN.a(405, 54, 1, true);
                        this.xdq.xdj = false;
                    }
                    if ((f.fdU & 1) != 0) {
                        x.i("MicroMsg.Updater", "channel pack, not silence download.");
                        g.pQN.a(405, 55, 1, true);
                        this.xdq.xdj = false;
                    }
                    if (this.xdq.xcb == 2 && !this.xdq.xdk) {
                        bYY = i.bYY();
                        if (!(c.IB(aVar.ced()) == null || bh.ov(bYY) || !bYY.equals(aVar.ced()))) {
                            x.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[]{bYY});
                            g.pQN.a(405, 56, 1, true);
                            return;
                        }
                    }
                    agw bYc = aVar.bYc();
                    if (bYc == null || bYc.won == 0 || bh.ov(bYc.woo)) {
                        if (this.xdq.xdj) {
                            x.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
                            g.pQN.a(405, 58, 1, true);
                            ar.CG().a(725, this.xdq.xdl = new 1(this, eVar));
                            ar.CG().a(new t(), 0);
                        } else {
                            x.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
                            Intent intent = new Intent(this.xdq.getContext(), AppUpdaterUI.class);
                            Updater.a(this.xdq, intent, eVar, aVar);
                            x.i("MicroMsg.Updater", "current updateType : %s", new Object[]{Integer.valueOf(this.xdq.xcb)});
                            if (this.xdq.xcb == 1) {
                                intent.putExtra("intent_extra_download_mode", 0);
                                g.pQN.a(405, 60, 1, true);
                            } else {
                                g.pQN.a(405, 61, 1, true);
                                intent.putExtra("intent_extra_download_mode", 1);
                            }
                            this.xdq.getContext().startActivity(intent);
                        }
                        com.tencent.mm.s.c.Bq().o(262145, true);
                        com.tencent.mm.pluginsdk.model.app.a.bYA();
                        return;
                    }
                    bYY = bYc.woo;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", bYY);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    com.tencent.mm.bm.d.b(this.xdq.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    i.cew();
                    g.pQN.a(405, 57, 1, true);
                }
            }), 0);
            onStop();
            return;
        }
        g.pQN.a(405, 62, 1, true);
        if (this.xdh != null) {
            r rVar = this.xdh;
            if (rVar.jVF != null) {
                rVar.jVF.setVisibility(8);
            }
            TextView textView = (TextView) this.xdh.findViewById(R.h.cwq);
            if (i == 4 && i2 == -18) {
                com.tencent.mm.sdk.b.a.xef.m(new be());
                com.tencent.mm.ae.n CG = ar.CG();
                e 4 = new 4(this, textView);
                this.xdm = 4;
                CG.a(922, 4);
            } else if (textView != null) {
                g.pQN.a(405, 64, 1, true);
                textView.setText(R.l.eRR);
                com.tencent.mm.pluginsdk.ui.d.i.f(textView, 1);
            }
        }
        i.ceA();
        cancel();
    }

    public static void a(Intent intent, e eVar) {
        String str;
        intent.putExtra("intent_short_ips", bZi());
        intent.putExtra("intent_client_version", d.vAz);
        intent.putExtra("intent_update_type", 3);
        String str2 = "intent_extra_desc";
        boolean z = (eVar.nBl == null || eVar.nBl.isEmpty() || !eVar.nBl.containsKey(Integer.valueOf(4))) ? false : true;
        if (z) {
            HashMap hashMap = eVar.nBl;
            if (hashMap == null || hashMap.isEmpty()) {
                str = "";
            } else {
                str = "";
                LinkedList linkedList = (LinkedList) hashMap.get(Integer.valueOf(4));
                if (linkedList != null && !linkedList.isEmpty()) {
                    int size = linkedList.size();
                    int i = 0;
                    while (i < size) {
                        String str3;
                        ass com_tencent_mm_protocal_c_ass = (ass) linkedList.get(i);
                        if (com_tencent_mm_protocal_c_ass.lang.equalsIgnoreCase("default")) {
                            str3 = new String(Base64.decode(com_tencent_mm_protocal_c_ass.content, 0));
                        } else if (com_tencent_mm_protocal_c_ass.lang.equalsIgnoreCase(w.cfi())) {
                            str = new String(Base64.decode(com_tencent_mm_protocal_c_ass.content, 0));
                            break;
                        } else {
                            str3 = str;
                        }
                        i++;
                        str = str3;
                    }
                }
            }
        } else {
            str = "";
        }
        intent.putExtra(str2, str);
        intent.putExtra("intent_extra_md5", eVar.nBp);
        intent.putExtra("intent_extra_size", eVar.fileSize);
        intent.putExtra("intent_extra_download_url", new String[]{eVar.nBo});
        intent.putExtra("intent_extra_patchInfo", eVar.cer());
        intent.putExtra("intent_extra_updateMode", f.fdU);
        intent.putExtra("intent_extra_marketUrl", f.xez);
        intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
        intent.putExtra("intent_extra_tinker_patch", true);
        intent.putExtra("intent_extra_download_mode", 1);
    }

    private void cancel() {
        ar.CG().b(11, this);
    }

    private static String[] bZi() {
        int i = 0;
        if (com.tencent.mm.platformtools.r.idc == null || com.tencent.mm.platformtools.r.idc.length() <= 0) {
            String string = ac.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List To = com.tencent.mm.protocal.n.To(string);
            String[] strArr = new String[To.size()];
            while (i < To.size()) {
                strArr[i] = ((com.tencent.mm.protocal.n) To.get(i)).nQt;
                i++;
            }
            return strArr;
        }
        return new String[]{com.tencent.mm.platformtools.r.idc};
    }

    public final void update(int i) {
        ab(i, false);
    }

    public final void ab(int i, boolean z) {
        x.i("MicroMsg.Updater", "summerupdate begin update routine, type=" + i);
        this.xcb = i;
        this.xdk = z;
        g.pQN.a(405, 44, 1, true);
        ar.CG().a(new a(i), 0);
    }

    public static void c(String str, int i, String str2, String str3) {
        Intent intent = new Intent(ac.getContext(), UpdaterService.class);
        intent.putExtra("intent_client_version", d.vAz);
        intent.putExtra("intent_update_type", 4);
        intent.putExtra("intent_extra_desc", str2);
        intent.putExtra("intent_extra_md5", str);
        intent.putExtra("intent_extra_size", i);
        intent.putExtra("intent_extra_download_url", new String[]{str3});
        intent.putExtra("intent_extra_updateMode", f.fdU);
        intent.putExtra("intent_extra_marketUrl", f.xez);
        intent.putExtra("intent_extra_run_in_foreground", true);
        intent.putExtra("intent_extra_download_mode", 2);
        g.pQN.a(405, 45, 1, true);
        ac.getContext().startService(intent);
    }

    public static void CY(int i) {
        if (ar.Hj()) {
            x.d("MicroMsg.Updater", "reportUpdateStat : opCode = " + i);
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new q(i));
        }
    }
}
