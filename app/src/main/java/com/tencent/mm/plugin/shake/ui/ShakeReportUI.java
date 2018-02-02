package com.tencent.mm.plugin.shake.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.k.g;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.k.1;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.pluginsdk.ui.f$a;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ao;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShakeReportUI extends MMActivity implements com.tencent.mm.platformtools.j.a, com.tencent.mm.plugin.shake.b.l.a, com.tencent.mm.plugin.shake.c.a.f.a, com.tencent.mm.sdk.e.j.a, b, ao {
    private static List<com.tencent.mm.plugin.shake.d.a.h.a> gyD = new CopyOnWriteArrayList();
    private boolean gyB = false;
    private Map<String, com.tencent.mm.plugin.shake.d.a.h.a> gyC = new ConcurrentHashMap();
    private com.tencent.mm.modelgeo.a.a gyF = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ ShakeReportUI qsi;

        {
            this.qsi = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                x.d("MicroMsg.ShakeReportUI", "on location get ok");
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xoa, String.valueOf(f2));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xob, String.valueOf(f));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xqr, String.valueOf(d2));
                this.qsi.gyB = true;
                if (this.qsi.gyy != null) {
                    this.qsi.gyy.c(this.qsi.gyF);
                }
            } else {
                x.w("MicroMsg.ShakeReportUI", "getLocation fail");
            }
            return false;
        }
    };
    private com.tencent.mm.modelgeo.c gyy;
    private com.tencent.mm.aq.a.a hCG = null;
    private ImageView ihQ;
    private com.tencent.mm.pluginsdk.k.c oNJ;
    private boolean pyw = true;
    private boolean qqT = false;
    private boolean qqU = false;
    private boolean qqV;
    private boolean qqW = false;
    private boolean qqX = false;
    private boolean qqY = false;
    private boolean qqZ = false;
    private d qrA = null;
    private ImageView qrB;
    private ImageView qrC;
    private ImageView qrD;
    private ImageView qrE;
    private ImageView qrF;
    private ImageView qrG;
    private TextView qrH;
    private int qrI = 1;
    private int qrJ = 0;
    private View qrK;
    private ImageView qrL;
    private ImageView qrM;
    private ImageView qrN;
    private ImageView qrO;
    private View qrP;
    private View qrQ;
    private View qrR;
    private View qrS;
    private View qrT = null;
    private int qrU = 0;
    private com.tencent.mm.plugin.shake.c.b.a qrV;
    private boolean qrW = false;
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, Boolean> qrX = new HashMap();
    private boolean qrY = false;
    private boolean qrZ = false;
    private int qra = 22;
    private c qrb;
    private l qrc = new l();
    private f qrd;
    private View qre;
    private View qrf;
    private TextView qrg;
    private TextView qrh;
    private TextView qri;
    private View qrj;
    private View qrk;
    private View qrl;
    private View qrm;
    private Animation qrn;
    private Animation qro;
    private Animation qrp;
    private Animation qrq;
    private View qrr = null;
    private View qrs = null;
    private MMImageView qrt = null;
    private TextView qru = null;
    private ImageView qrv = null;
    private String qrw = "";
    private Bitmap qrx = null;
    private Dialog qry;
    private ImageView qrz = null;
    private boolean qsa = false;
    private boolean qsb = false;
    private int qsc = 1;
    private long qsd = 0;
    private boolean qse = false;
    private com.tencent.mm.sdk.b.c qsf = new 24(this);
    private com.tencent.mm.sdk.b.c qsg = new 25(this);
    private OnClickListener qsh = new 18(this);

    static class a extends com.tencent.mm.pluginsdk.k.c.a {
        private final long[] iev = new long[]{300, 200, 300, 200};
        private long kCU = bh.Wq();
        private Vibrator kEd;
        WeakReference<ShakeReportUI> qso;

        public a(ShakeReportUI shakeReportUI) {
            this.qso = new WeakReference(shakeReportUI);
        }

        public final void beP() {
            ShakeReportUI shakeReportUI = (ShakeReportUI) this.qso.get();
            if (shakeReportUI != null) {
                if (shakeReportUI.isFinishing()) {
                    x.e("MicroMsg.ShakeReportUI", "ui finished");
                } else if (shakeReportUI.qqY) {
                    shakeReportUI.bss();
                    long bA = bh.bA(this.kCU);
                    if (bA < 1200) {
                        x.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:" + bA);
                        return;
                    }
                    x.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:" + bA);
                    this.kCU = bh.Wq();
                    if (shakeReportUI.qrb != null) {
                        c w = shakeReportUI.qrb;
                        if (w.view != null) {
                            w.view.setKeepScreenOn(true);
                        }
                        w.fhK.J(30000, 30000);
                    }
                    if (shakeReportUI.qrd != null) {
                        f q = shakeReportUI.qrd;
                        if (q.ojL != null) {
                            q.ojL.dismiss();
                        }
                    }
                    ShakeReportUI shakeReportUI2;
                    if (shakeReportUI.qqV) {
                        shakeReportUI2 = (ShakeReportUI) this.qso.get();
                        if (shakeReportUI2 != null) {
                            com.tencent.mm.sdk.platformtools.ar.H(shakeReportUI2, R.l.eOY);
                        }
                    } else {
                        shakeReportUI2 = (ShakeReportUI) this.qso.get();
                        if (shakeReportUI2 != null) {
                            if (this.kEd == null) {
                                this.kEd = (Vibrator) shakeReportUI2.getSystemService("vibrator");
                            }
                            if (this.kEd != null) {
                                this.kEd.vibrate(this.iev, -1);
                            }
                        }
                    }
                    reset();
                    ShakeReportUI.y(shakeReportUI);
                } else {
                    x.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
                }
            }
        }

        public final void onRelease() {
        }
    }

    static /* synthetic */ void h(ShakeReportUI shakeReportUI) {
        if (bsx()) {
            ViewGroup viewGroup = (ViewGroup) shakeReportUI.findViewById(R.h.cMX);
            if (viewGroup != null) {
                int i;
                int childCount = viewGroup.getChildCount();
                List arrayList = new ArrayList();
                int i2 = 0;
                for (i = 0; i < childCount; i++) {
                    if (viewGroup.getChildAt(i).getVisibility() == 0) {
                        i2++;
                        arrayList.add(viewGroup.getChildAt(i));
                    }
                }
                int width;
                Animation animationSet;
                Animation alphaAnimation;
                Animation translateAnimation;
                View view;
                if (!shakeReportUI.qrY && (shakeReportUI.qrZ || shakeReportUI.qsb)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    animationSet = new AnimationSet(false);
                    alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(600);
                    translateAnimation = new TranslateAnimation((float) viewGroup.getWidth(), (float) (viewGroup.getWidth() - childCount), 0.0f, 0.0f);
                    animationSet.addAnimation(alphaAnimation);
                    translateAnimation.setDuration(600);
                    animationSet.addAnimation(translateAnimation);
                    shakeReportUI.findViewById(R.h.cNk).setAnimation(animationSet);
                    if (i2 < 4) {
                        for (i = 0; i < i2; i++) {
                            view = (View) arrayList.get(i);
                            translateAnimation = new TranslateAnimation((float) (((i * width) + (width / 2)) - ((i * childCount) + (childCount / 2))), 0.0f, 0.0f, 0.0f);
                            translateAnimation.setDuration(600);
                            view.setAnimation(translateAnimation);
                        }
                    }
                } else if (!(shakeReportUI.qrY || shakeReportUI.qrZ || shakeReportUI.qsb)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    Animation animationSet2 = new AnimationSet(false);
                    animationSet = new AlphaAnimation(0.0f, 1.0f);
                    animationSet.setDuration(1200);
                    alphaAnimation = new TranslateAnimation((float) ((-childCount) / 2), 0.0f, 0.0f, 0.0f);
                    animationSet2.addAnimation(animationSet);
                    alphaAnimation.setDuration(600);
                    animationSet2.addAnimation(alphaAnimation);
                    shakeReportUI.findViewById(R.h.cNh).setAnimation(animationSet2);
                    for (i = 1; i < i2 + 1; i++) {
                        view = (View) arrayList.get(i - 1);
                        translateAnimation = new TranslateAnimation((float) (-(((i * childCount) + (childCount / 2)) - (((i - 1) * width) + (width / 2)))), 0.0f, 0.0f, 0.0f);
                        translateAnimation.setDuration(600);
                        view.setAnimation(translateAnimation);
                    }
                }
                shakeReportUI.qrY = true;
                shakeReportUI.qrI = 5;
                shakeReportUI.qse = true;
                shakeReportUI.bsv();
                shakeReportUI.bso();
                shakeReportUI.hU(false);
            }
        }
    }

    static /* synthetic */ void y(ShakeReportUI shakeReportUI) {
        if (shakeReportUI.qrj == null) {
            shakeReportUI.qrj = shakeReportUI.findViewById(R.h.cNF);
        }
        if (shakeReportUI.qrk == null) {
            shakeReportUI.qrk = shakeReportUI.findViewById(R.h.cMC);
        }
        if (shakeReportUI.qrl == null) {
            shakeReportUI.qrl = shakeReportUI.findViewById(R.h.cMH);
        }
        if (shakeReportUI.qrm == null) {
            shakeReportUI.qrm = shakeReportUI.findViewById(R.h.cMI);
        }
        if (shakeReportUI.qrn == null) {
            shakeReportUI.qrn = AnimationUtils.loadAnimation(shakeReportUI.mController.xIM, R.a.bqI);
            shakeReportUI.qrn.setAnimationListener(new 10(shakeReportUI));
        }
        if (shakeReportUI.qro == null) {
            shakeReportUI.qro = AnimationUtils.loadAnimation(shakeReportUI.mController.xIM, R.a.bqG);
        }
        if (shakeReportUI.qrp == null) {
            shakeReportUI.qrp = AnimationUtils.loadAnimation(shakeReportUI.mController.xIM, R.a.bqt);
        }
        if (!(shakeReportUI.qrq == null || shakeReportUI.qrh == null)) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.c(shakeReportUI.qrh, shakeReportUI.qrq);
        }
        shakeReportUI.wi(3);
        shakeReportUI.qrl.startAnimation(shakeReportUI.qrp);
        shakeReportUI.qrm.startAnimation(shakeReportUI.qrp);
        shakeReportUI.qrl.setVisibility(0);
        shakeReportUI.qrm.setVisibility(0);
        shakeReportUI.qrg.setVisibility(4);
        shakeReportUI.qrj.startAnimation(shakeReportUI.qrn);
        shakeReportUI.qrk.startAnimation(shakeReportUI.qro);
        if (shakeReportUI.qre != null && shakeReportUI.qre.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(shakeReportUI.mController.xIM, R.a.bqv);
            loadAnimation.setFillAfter(true);
            shakeReportUI.qre.startAnimation(loadAnimation);
            new af().postDelayed(new 11(shakeReportUI), loadAnimation.getDuration());
        }
        shakeReportUI.qqZ = false;
        new af().postDelayed(new 13(shakeReportUI), 1200);
    }

    protected final int getLayoutId() {
        return R.i.dsu;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        super.onCreate(bundle);
        setMMTitle(R.l.eOL);
        this.gyy = com.tencent.mm.modelgeo.c.OP();
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xoa, "");
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xob, "");
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xqr, "");
        this.qrT = findViewById(R.h.cNh);
        bi HQ = bi.HQ();
        String ou = bh.ou(HQ.hhx);
        String ou2 = bh.ou(HQ.hhw);
        String F = g.zZ().F("IBeacon", "GatedLaunch");
        if (bh.ov(F)) {
            F = null;
        }
        this.qrZ = false;
        this.qsa = false;
        if (F != null) {
            try {
                JSONObject jSONObject = new JSONObject(F);
                i = jSONObject.getInt("gatedlaunch");
                ar.Hj();
                if (i != 0) {
                    JSONArray jSONArray;
                    int length;
                    String string;
                    int i3;
                    JSONArray jSONArray2;
                    if (i == 1) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(ou) && i3 == 1) {
                                this.qrZ = true;
                            } else if (string.equals(ou) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(ou2)) {
                                        this.qrZ = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 2) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(ou) && i3 == 1) {
                                this.qsa = true;
                                this.qrZ = true;
                            } else if (string.equals(ou) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(ou2)) {
                                        this.qsa = true;
                                        this.qrZ = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 3) {
                        this.qrZ = true;
                        this.qsa = false;
                    } else if (i == 4) {
                        this.qrZ = true;
                        this.qsa = true;
                    }
                }
            } catch (JSONException e) {
                x.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
                this.qrZ = false;
                this.qsa = false;
            }
        }
        if (ar.Hj()) {
            ar.Hg();
            if (((Integer) c.CU().get(com.tencent.mm.storage.w.a.xqj, Integer.valueOf(0))).intValue() == 1) {
                this.qsb = true;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean hasSystemFeature = ac.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter == null || !hasSystemFeature || VERSION.SDK_INT < 18 || defaultAdapter.getState() != 12) {
            this.qsc = 1;
        } else {
            this.qsc = 0;
        }
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (hasSystemFeature) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.qrZ) {
            com.tencent.mm.plugin.report.service.g.pQN.h(13139, new Object[]{ou, ou2, Integer.valueOf(1), Integer.valueOf(this.qsc), Integer.valueOf(i2), Integer.valueOf(i)});
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.h(13139, new Object[]{ou, ou2, Integer.valueOf(0), Integer.valueOf(this.qsc), Integer.valueOf(i2), Integer.valueOf(i)});
        }
        if (this.qsb || this.qrZ) {
            this.qrY = true;
            this.qrT = findViewById(R.h.cNk);
            if (this.qsa) {
                if (defaultAdapter == null || defaultAdapter.getState() != 12) {
                    this.qrY = false;
                } else if (defaultAdapter != null) {
                    defaultAdapter.getState();
                }
            }
        }
        com.tencent.mm.plugin.shake.c.a.f brH = m.brH();
        if (brH.kIv == null) {
            brH.kIv = new ArrayList();
        }
        if (this != null) {
            brH.kIv.add(new WeakReference(this));
        }
        Boolean valueOf = Boolean.valueOf(false);
        long Wo = bh.Wo();
        long j = 0;
        long j2 = 0;
        if (ar.Hj()) {
            ar.Hg();
            c.CU().a(com.tencent.mm.storage.w.a.xqg, Boolean.valueOf(true));
            ar.Hg();
            Boolean valueOf2 = Boolean.valueOf(bh.a((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xqe, null), false));
            ar.Hg();
            j = bh.a((Long) c.CU().get(com.tencent.mm.storage.w.a.xqf, null), 0);
            ar.Hg();
            j2 = bh.a((Long) c.CU().get(com.tencent.mm.storage.w.a.xpZ, null), 0);
            valueOf = valueOf2;
        }
        if (!valueOf.booleanValue() || Wo - r6 >= r4) {
            initView();
        } else {
            this.qrI = 5;
            this.qrY = true;
            this.qqW = true;
            initView();
            bso();
            ar.Hg();
            String az = bh.az((String) c.CU().get(com.tencent.mm.storage.w.a.xqd, null), "");
            ar.Hg();
            F = bh.az((String) c.CU().get(com.tencent.mm.storage.w.a.xqc, null), "");
            if (!(F == null || F.equals(""))) {
                String[] split = F.split(",");
                d dVar = new d();
                dVar.field_type = 11;
                dVar.field_username = split[0];
                dVar.field_nickname = split[0];
                dVar.field_signature = split[1];
                dVar.field_province = split[2];
                dVar.field_city = split[3];
                dVar.field_sex = 1;
                try {
                    dVar.field_lvbuffer = (String.valueOf(split[4]) + "," + String.valueOf(split[5]) + "," + String.valueOf(split[6])).getBytes(ProtocolPackage.ServerEncoding);
                } catch (UnsupportedEncodingException e2) {
                    x.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
                }
                dVar.field_insertBatch = 2;
                e brC = m.brC();
                brC.bru();
                brC.a(dVar, true);
                List linkedList = new LinkedList();
                linkedList.add(dVar);
                d(linkedList, 1);
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xqc, "");
                F = az + "," + split[4] + split[5] + split[6];
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xqd, F);
            }
        }
        this.qrb = new c(this.mController.xIy);
        this.oNJ = new com.tencent.mm.pluginsdk.k.c(this);
        if (!this.oNJ.bZN()) {
            h.a(this, R.l.eOK, R.l.dGO, new 12(this));
        }
        if (com.tencent.mm.plugin.shake.a.ift != null) {
            com.tencent.mm.plugin.shake.a.ift.um();
        }
        j.b(this);
        x.i("MicroMsg.ShakeReportUI", "%s", new Object[]{getResources().getDisplayMetrics().toString()});
        i = m.brD().Tq();
        com.tencent.mm.plugin.report.service.g.pQN.h(11317, new Object[]{Integer.valueOf(i), e.bsz()});
        com.tencent.mm.plugin.report.service.g.pQN.h(11710, new Object[]{Integer.valueOf(1)});
    }

    protected void onResume() {
        super.onResume();
        if (this.pyw) {
            x.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")), bh.cgy(), this});
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                blL();
            }
        }
    }

    private void blL() {
        bsn();
        ar.Hg();
        c.a(this);
        ar.Hg();
        c.CU().a(this);
        m.brC().c(this);
        if (this.qrc.qnQ != null) {
            this.qrc.qnQ.resume();
        }
        this.qqY = true;
        if (!(this.qrV == null || !this.qrV.isShowing() || this.qrV.qoY)) {
            this.qqY = false;
        }
        x.i("MicroMsg.ShakeReportUI", "tryStartShake");
        if (!(this.oNJ == null || this.oNJ.bZL())) {
            this.oNJ.a(new a(this));
            if (!this.oNJ.bZN() || this.qrg == null) {
                this.qrg.setText(getString(R.l.eOK));
            } else {
                this.qrg.setText(getString(R.l.eNY));
            }
        }
        new af().postDelayed(new 22(this), 1000);
        if (this.oNJ != null) {
            this.oNJ.bZM();
        }
        hV(false);
        hW(false);
        bsp();
        ar.Hg();
        String str = (String) c.CU().get(327696, "1");
        if (k.brA()) {
            if (this.qrI == 4) {
                hS(true);
            }
            if (str.equals("4")) {
                ct(findViewById(R.h.cNp));
            }
        }
        if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            ct(findViewById(R.h.cNm));
        } else if (str.equals("6") && com.tencent.mm.plugin.shake.c.c.a.bsb()) {
            ct(findViewById(R.h.cNc));
        }
        boolean aR = com.tencent.mm.s.c.Bq().aR(262154, 266258);
        if (getIntent().getBooleanExtra("shake_music", false) && com.tencent.mm.av.c.Qx() && this.qrc.qnP != 3) {
            getIntent().putExtra("shake_music", false);
            this.qrI = 3;
        } else if (getIntent().getBooleanExtra("shake_tv", false) && this.qrc.qnP != 4 && k.brA()) {
            getIntent().putExtra("shake_tv", false);
            this.qrI = 4;
        } else if (this.qrc.qnP != 6 && com.tencent.mm.plugin.shake.c.c.a.bsb() && (aR || getIntent().getBooleanExtra("shake_card", false))) {
            this.qrU = getIntent().getIntExtra("shake_card", 0);
            getIntent().putExtra("shake_card", false);
            x.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
            this.qrI = 6;
        }
        bso();
        hT(true);
        x.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[]{Boolean.valueOf(r.idj)});
        if (r.idj) {
            ar.CG().a(new com.tencent.mm.az.k(7), 0);
        }
        hX(true);
        bsv();
        bsl();
    }

    protected void onPause() {
        ar.Hg();
        c.b(this);
        ar.Hg();
        c.CU().b(this);
        m.brC().j(this);
        if (this.qrc.qnQ != null) {
            this.qrc.qnQ.pause();
        }
        this.qqY = false;
        if (this.oNJ != null) {
            this.oNJ.aPV();
        }
        this.qrb.bsj();
        if (this.qrI != 5) {
            ar.Hg();
            c.CU().set(327696, this.qrI);
        }
        if (this.qrI == 4) {
            hS(false);
        }
        bsm();
        super.onPause();
    }

    protected void onDestroy() {
        if (!(this.qrx == null || this.qrx.isRecycled())) {
            this.qrx.recycle();
        }
        if (this.qry != null && this.qry.isShowing()) {
            this.qry.dismiss();
            this.qry = null;
        }
        if (this.qrc.qnQ != null) {
            this.qrc.qnQ.brp();
        }
        if (this.oNJ != null) {
            this.oNJ.aPV();
            this.oNJ = null;
        }
        com.tencent.mm.plugin.shake.d.a.j a = com.tencent.mm.plugin.shake.d.a.j.a(null);
        if (com.tencent.mm.plugin.shake.d.a.j.oxo) {
            com.tencent.mm.plugin.shake.d.a.j.oxo = false;
            if (!a.qpS.bsd()) {
                x.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
            }
        }
        com.tencent.mm.plugin.shake.d.a.j.qpT = null;
        j.c(this);
        com.tencent.mm.sdk.b.a.xef.c(this.qsf);
        com.tencent.mm.sdk.b.a.xef.c(this.qsg);
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xqg, Boolean.valueOf(false));
        bsm();
        if (com.tencent.mm.plugin.shake.c.c.a.bsb()) {
            com.tencent.mm.s.c.Bq().p(262154, false);
        }
        bss();
        com.tencent.mm.plugin.shake.c.a.f brH = m.brH();
        if (brH.kIv != null && this != null) {
            for (int i = 0; i < brH.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) brH.kIv.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.shake.c.a.f.a aVar = (com.tencent.mm.plugin.shake.c.a.f.a) weakReference.get();
                    if (aVar != null && aVar.equals(this)) {
                        brH.kIv.remove(weakReference);
                        break;
                    }
                }
            }
        }
        com.tencent.mm.plugin.shake.c.a.d brI = m.brI();
        brI.gyz = -85.0f;
        brI.gyA = -1000.0f;
        if (this.gyy != null) {
            this.gyy.c(this.gyF);
        }
        super.onDestroy();
    }

    private void bsl() {
        if (bsx() && BluetoothAdapter.getDefaultAdapter() != null) {
            List<String> zN = g.zZ().zN();
            if (zN != null) {
                this.qsd = System.currentTimeMillis();
                for (String str : zN) {
                    x.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", new Object[]{str});
                    com.tencent.mm.sdk.b.b djVar = new dj();
                    djVar.frU.frW = str;
                    djVar.frU.frT = true;
                    com.tencent.mm.sdk.b.a.xef.m(djVar);
                }
            }
        }
    }

    private void bsm() {
        ar.Hg();
        if (!Boolean.valueOf(bh.a((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xqg, null), false)).booleanValue()) {
            this.gyC.clear();
            gyD = new CopyOnWriteArrayList();
        }
        if (VERSION.SDK_INT >= 18) {
            List<String> zN = g.zZ().zN();
            if (zN != null) {
                for (String str : zN) {
                    com.tencent.mm.sdk.b.b djVar = new dj();
                    x.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", new Object[]{str});
                    djVar.frU.frW = str;
                    djVar.frU.frT = false;
                    com.tencent.mm.sdk.b.a.xef.m(djVar);
                }
            }
        }
    }

    protected final void initView() {
        com.tencent.mm.plugin.shake.c.c.a.brw();
        this.qrX.put(Integer.valueOf(1), Boolean.valueOf(true));
        this.qrX.put(Integer.valueOf(3), Boolean.valueOf(false));
        this.qrX.put(Integer.valueOf(4), Boolean.valueOf(false));
        this.qrX.put(Integer.valueOf(5), Boolean.valueOf(false));
        this.qrX.put(Integer.valueOf(6), Boolean.valueOf(false));
        this.hCG = new com.tencent.mm.aq.a.a(this);
        this.qrg = (TextView) findViewById(R.h.cNa);
        this.qrf = findViewById(R.h.cNq);
        this.qrh = (TextView) findViewById(R.h.cMV);
        this.qri = (TextView) findViewById(R.h.cMZ);
        this.qrK = findViewById(R.h.cNE);
        this.qrL = (ImageView) findViewById(R.h.cNs);
        this.qrM = (ImageView) findViewById(R.h.cNu);
        this.qrN = (ImageView) findViewById(R.h.cNw);
        this.qrO = (ImageView) findViewById(R.h.cNy);
        this.qrP = findViewById(R.h.cNt);
        this.qrQ = findViewById(R.h.cNv);
        this.qrR = findViewById(R.h.cNx);
        this.qrS = findViewById(R.h.cNz);
        this.qre = findViewById(R.h.cMY);
        this.qre.setOnClickListener(this.qsh);
        this.ihQ = (ImageView) this.qre.findViewById(R.h.cMK);
        this.ihQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI qsi;

            {
                this.qsi = r1;
            }

            public final void onClick(View view) {
                if (this.qsi.qrI != 5) {
                    this.qsi.qrd = new f(this.qsi, (String) this.qsi.qre.getTag(), null, f$a.vjW);
                    this.qsi.qrd.caa();
                }
            }
        });
        bsn();
        View inflate = View.inflate(this.mController.xIM, R.i.dsr, null);
        this.qry = new com.tencent.mm.ui.base.k(this.mController.xIM, R.m.eYV);
        this.qry.setContentView(inflate);
        this.qry.setOnCancelListener(new 4(this));
        ((Button) inflate.findViewById(R.h.cME)).setOnClickListener(new 5(this));
        ar.Hg();
        boolean c = bh.c((Boolean) c.CU().get(4108, null));
        ar.Hg();
        boolean c2 = bh.c((Boolean) c.CU().get(4117, null));
        if (!c) {
            inflate.setVisibility(0);
            this.qry.show();
            ar.Hg();
            c.CU().set(4108, Boolean.valueOf(true));
        } else if (!c2) {
            Looper.myQueue().addIdleHandler(new 6(this));
        }
        setBackBtn(new 27(this));
        addIconOptionMenu(0, R.l.dCn, R.k.dvc, new 28(this));
        OnClickListener 29 = new 29(this);
        if (this.qsb || this.qrZ) {
            this.qrz = (ImageView) findViewById(R.h.cNj);
        } else {
            this.qrz = (ImageView) findViewById(R.h.cNi);
        }
        this.qrB = (ImageView) findViewById(R.h.cNf);
        this.qrC = (ImageView) findViewById(R.h.cNl);
        this.qrD = (ImageView) findViewById(R.h.cNo);
        this.qrE = (ImageView) findViewById(R.h.cNb);
        this.qrH = (TextView) findViewById(R.h.cNe);
        this.qrG = (ImageView) findViewById(R.h.cNd);
        this.qrF = (ImageView) findViewById(R.h.cNn);
        bsu();
        this.qrT.setOnClickListener(29);
        findViewById(R.h.cNk).setOnClickListener(29);
        findViewById(R.h.cNg).setOnClickListener(29);
        findViewById(R.h.cNm).setOnClickListener(29);
        findViewById(R.h.cNp).setOnClickListener(29);
        findViewById(R.h.cNc).setOnClickListener(29);
        com.tencent.mm.sdk.b.a.xef.b(this.qsf);
        com.tencent.mm.sdk.b.a.xef.b(this.qsg);
        bsq();
        bst();
        hX(true);
    }

    private void bsn() {
        ar.Hg();
        int a = bh.a((Integer) c.CU().get(12290, null), 0);
        ImageView imageView = (ImageView) findViewById(R.h.cMW);
        if (!(this.qrx == null || this.qrx.isRecycled())) {
            this.qrx.recycle();
        }
        ar.Hg();
        if (bh.b((Boolean) c.CU().get(4110, null))) {
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            String stringBuilder2 = stringBuilder.append(c.Fi()).append("default_shake_img_filename.jpg").toString();
            if (com.tencent.mm.a.e.bO(stringBuilder2)) {
                this.qrx = j.op(stringBuilder2);
                imageView.setImageDrawable(new BitmapDrawable(this.qrx));
            } else {
                Drawable bitmapDrawable;
                try {
                    bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.decodeStream(this.mController.xIM.getAssets().open("resource/shakehideimg_man.jpg")));
                } catch (IOException e) {
                    x.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + e.getLocalizedMessage());
                    bitmapDrawable = null;
                }
                imageView.setImageDrawable(bitmapDrawable);
            }
        } else {
            ar.Hg();
            this.qrx = j.op((String) c.CU().get(4111, null));
            imageView.setImageDrawable(new BitmapDrawable(this.qrx));
        }
        imageView = (ImageView) findViewById(R.h.bGb);
        ImageView imageView2 = (ImageView) findViewById(R.h.bFY);
        imageView.setImageResource(a == 2 ? R.g.bGa : R.g.bGb);
        imageView2.setImageResource(a == 2 ? R.g.bFZ : R.g.bFY);
        OnClickListener 7 = new 7(this);
        imageView.setOnClickListener(7);
        imageView2.setOnClickListener(7);
        if (this.qrl == null) {
            this.qrl = findViewById(R.h.cMH);
        }
        this.qrl.setOnClickListener(7);
        if (this.qrm == null) {
            this.qrm = findViewById(R.h.cMI);
        }
        this.qrm.setOnClickListener(7);
    }

    private void hS(boolean z) {
        String format = String.format("%1$s-shaketype-%2$d", new Object[]{getClass().getName(), Integer.valueOf(4)});
        x.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + format + ", isActive=" + z);
        com.tencent.mm.ui.base.ac.a(z, new Intent().putExtra("classname", format));
    }

    private void bso() {
        l.b bVar;
        if (this.qrI == 3 && com.tencent.mm.av.c.Qx()) {
            this.qrI = 3;
            this.qri.setText(R.l.eOS);
            this.qrz.setBackgroundResource(R.g.bFQ);
            this.qrB.setBackgroundResource(R.g.bFU);
            this.qrC.setBackgroundResource(R.g.bFT);
            this.qrD.setBackgroundResource(R.g.bFW);
            this.qrE.setBackgroundResource(R.g.bFO);
            findViewById(R.h.cMX).setVisibility(0);
            setMMTitle(R.l.eOO);
            com.tencent.mm.plugin.report.service.g.pQN.h(11720, new Object[]{Integer.valueOf(2)});
        } else if (this.qrI == 4 && k.brA()) {
            this.qrI = 4;
            this.qri.setText(R.l.eOT);
            this.qrz.setBackgroundResource(R.g.bFQ);
            this.qrB.setBackgroundResource(R.g.bFU);
            this.qrC.setBackgroundResource(R.g.bFS);
            this.qrD.setBackgroundResource(R.g.bFX);
            this.qrE.setBackgroundResource(R.g.bFO);
            findViewById(R.h.cMX).setVisibility(0);
            setMMTitle(R.l.eOP);
            com.tencent.mm.plugin.report.service.g.pQN.h(11720, new Object[]{Integer.valueOf(3)});
        } else if (this.qrI == 5 && bsw()) {
            this.qrI = 5;
            this.qri.setText(R.l.eOR);
            this.qrz.setBackgroundResource(R.g.bFR);
            this.qrB.setBackgroundResource(R.g.bFU);
            this.qrC.setBackgroundResource(R.g.bFS);
            this.qrD.setBackgroundResource(R.g.bFW);
            this.qrE.setBackgroundResource(R.g.bFO);
            findViewById(R.h.cMX).setVisibility(0);
            setMMTitle(R.l.eON);
            com.tencent.mm.plugin.report.service.g.pQN.h(11720, new Object[]{Integer.valueOf(4)});
        } else if (this.qrI == 6 && com.tencent.mm.plugin.shake.c.c.a.bsb()) {
            this.qrI = 6;
            this.qri.setText(R.l.eOQ);
            this.qrz.setBackgroundResource(R.g.bFQ);
            this.qrB.setBackgroundResource(R.g.bFU);
            this.qrC.setBackgroundResource(R.g.bFS);
            this.qrD.setBackgroundResource(R.g.bFW);
            this.qrE.setBackgroundResource(R.g.bFP);
            findViewById(R.h.cMX).setVisibility(0);
            setMMTitle(R.l.eOM);
            bsr();
            bsu();
            com.tencent.mm.plugin.report.service.g.pQN.h(11720, new Object[]{Integer.valueOf(5)});
        } else {
            this.qrI = 1;
            this.qri.setText(R.l.eOf);
            this.qrz.setBackgroundResource(R.g.bFQ);
            this.qrB.setBackgroundResource(R.g.bFV);
            this.qrC.setBackgroundResource(R.g.bFS);
            this.qrD.setBackgroundResource(R.g.bFW);
            this.qrE.setBackgroundResource(R.g.bFO);
            if (com.tencent.mm.av.c.Qx()) {
                findViewById(R.h.cMX).setVisibility(0);
            }
            setMMTitle(R.l.eOL);
            com.tencent.mm.plugin.report.service.g.pQN.h(11720, new Object[]{Integer.valueOf(1)});
        }
        l lVar = this.qrc;
        int i = this.qrI;
        if (i == lVar.qnP) {
            bVar = lVar.qnQ;
        } else {
            if (lVar.qnQ != null) {
                lVar.qnQ.brp();
            }
            switch (i) {
                case 1:
                    lVar.qnQ = new com.tencent.mm.plugin.shake.b.c(this, this);
                    break;
                case 3:
                    lVar.qnQ = com.tencent.mm.plugin.shake.d.a.j.a(this);
                    break;
                case 4:
                    lVar.qnQ = new com.tencent.mm.plugin.shake.d.a.l(this, this);
                    break;
                case 5:
                    lVar.qnQ = new com.tencent.mm.plugin.shake.d.a.h(this);
                    break;
                case 6:
                    lVar.qnQ = new com.tencent.mm.plugin.shake.c.a.g(this);
                    break;
            }
            lVar.qnP = i;
            lVar.qnQ.init();
            bVar = lVar.qnQ;
        }
        if (!this.qqW) {
            hW(false);
        }
        if (com.tencent.mm.plugin.shake.c.c.a.bsb() && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
            com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
            int i2 = this.qrU;
            gVar.kFm = i2;
            x.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:" + i2);
            if (this.qrU == 3) {
                x.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
                com.tencent.mm.plugin.shake.c.a.g gVar2 = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                String stringExtra = getIntent().getStringExtra("key_shake_card_ext_info");
                if (stringExtra == null || stringExtra.length() > 256) {
                    x.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:" + stringExtra);
                    return;
                }
                x.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + gVar2.jcA);
                gVar2.jcA = stringExtra;
            }
        }
    }

    private void bsp() {
        ar.Hg();
        this.qqV = bh.b((Boolean) c.CU().get(4112, null));
        if (this.qqV) {
            setTitleMuteIconVisibility(8);
        } else {
            setTitleMuteIconVisibility(0);
        }
    }

    private void hT(boolean z) {
        com.tencent.mm.plugin.shake.b.f fVar = null;
        hU(z);
        if (this.qrs == null) {
            this.qrs = findViewById(R.h.cnQ);
        }
        if (z) {
            if (m.brD().Tq() <= 0) {
                this.qrs.setVisibility(8);
                return;
            }
            if (this.qru == null) {
                this.qru = (TextView) this.qrs.findViewById(R.h.cMO);
            }
            this.qru.setText(getString(R.l.eOD, new Object[]{Integer.valueOf(r2)}));
            this.qrs.setOnClickListener(new 9(this));
            if (this.qrt == null) {
                this.qrt = (MMImageView) findViewById(R.h.cMU);
            }
            com.tencent.mm.plugin.shake.b.g brD = m.brD();
            Cursor a = brD.gJP.a("SELECT * FROM " + brD.getTableName() + " where status != 1 ORDER BY rowid" + " DESC LIMIT 1", null, 2);
            if (a != null) {
                com.tencent.mm.plugin.shake.b.f fVar2;
                if (a.moveToFirst()) {
                    fVar2 = new com.tencent.mm.plugin.shake.b.f();
                    fVar2.b(a);
                } else {
                    fVar2 = null;
                }
                a.close();
                fVar = fVar2;
            }
            if (fVar != null) {
                String str = fVar.field_thumburl;
                if (bh.ov(str)) {
                    this.qrt.setImageResource(R.k.dvD);
                } else {
                    Object bVar = new com.tencent.mm.plugin.shake.e.b(str);
                    Bitmap a2 = j.a(bVar);
                    this.qrt.setTag(bVar.Wh());
                    if (a2 == null || a2.isRecycled()) {
                        this.qrt.setImageResource(R.k.dvD);
                    } else {
                        this.qrt.setImageBitmap(a2);
                    }
                }
            }
            this.qrs.setVisibility(0);
            return;
        }
        this.qrs.setVisibility(8);
    }

    private void hU(boolean z) {
        if (this.qrr == null) {
            this.qrr = findViewById(R.h.cnP);
        }
        if (this.qrc.qnP == 3 || this.qrc.qnP == 4 || this.qrc.qnP == 5 || this.qrc.qnP == 6 || !z) {
            this.qrr.setVisibility(8);
            return;
        }
        int Tq = com.tencent.mm.bf.l.Tz().Tq();
        if (Tq <= 0) {
            this.qrr.setVisibility(8);
            return;
        }
        this.qrr.setVisibility(0);
        ((TextView) this.qrr.findViewById(R.h.cIH)).setText(getResources().getQuantityString(R.j.duK, Tq, new Object[]{Integer.valueOf(Tq)}));
        this.qrr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI qsi;

            {
                this.qsi = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.qsi, ShakeSayHiListUI.class);
                intent.putExtra("IntentSayHiType", 1);
                this.qsi.startActivity(intent);
            }
        });
        if (this.qrv == null) {
            this.qrv = (ImageView) findViewById(R.h.cvt);
        }
        com.tencent.mm.bf.j Tu = com.tencent.mm.bf.l.Tz().Tu();
        if (Tu != null) {
            this.qrw = Tu.field_sayhiuser;
            com.tencent.mm.pluginsdk.ui.a.b.a(this.qrv, this.qrw);
        }
    }

    private void hV(boolean z) {
        if (this.qrh == null) {
            return;
        }
        if (z) {
            this.qrh.setVisibility(0);
            return;
        }
        this.qrh.setVisibility(8);
        this.qrh.cancelLongPress();
    }

    private void hW(boolean z) {
        if (this.qrf == null) {
            return;
        }
        if (z) {
            this.qrf.setVisibility(0);
        } else {
            this.qrf.setVisibility(4);
        }
    }

    private void wi(int i) {
        hW(i == 1);
        if (i == 2) {
            hV(true);
        } else {
            hV(false);
        }
    }

    public final void GX() {
        bso();
    }

    private void Jn(String str) {
        this.qqW = false;
        if (this.qqV) {
            com.tencent.mm.sdk.platformtools.ar.H(this.mController.xIM, R.l.eOJ);
        }
        if (this.qrq == null) {
            this.qrq = AnimationUtils.loadAnimation(this.mController.xIM, R.a.bpY);
        }
        wi(2);
        if (str == null || str.length() <= 1) {
            this.qrh.setText(R.l.eOl);
        } else {
            this.qrh.setText(str);
        }
        this.qrh.startAnimation(this.qrq);
        this.qqZ = true;
        ag.h(new Runnable(this) {
            final /* synthetic */ ShakeReportUI qsi;

            {
                this.qsi = r1;
            }

            public final void run() {
                this.qsi.hV(false);
                this.qsi.hW(false);
            }
        }, this.qrq.getDuration());
    }

    public final void d(List<d> list, long j) {
        hX(true);
        if (list == null || !this.qqW || j == 6) {
            this.qrA = null;
            if (j == 6) {
                Jn(getString(R.l.eOt));
                return;
            } else if (j == 7) {
                Jn(getString(R.l.eOr));
                return;
            } else if (j == 8) {
                Jn(getString(R.l.eOp));
                return;
            } else if (j == 9) {
                Jn(getString(R.l.eOo));
                return;
            } else if (j == 10) {
                Jn(getString(R.l.eOs));
                return;
            } else {
                Jn(null);
                return;
            }
        }
        this.qqW = false;
        if (list.size() > 0) {
            this.qrA = (d) list.get(0);
        }
        int size;
        d dVar;
        Intent intent;
        if (this.qrc.qnP == 1) {
            if (list.size() <= 0 || ((d) list.get(0)).field_type == 0) {
                this.qra = ((d) list.get(0)).scene;
                size = list.size();
                if (size == 0) {
                    Jn(null);
                    return;
                } else if (size == 1) {
                    x.i("MicroMsg.ShakeReportUI", "1 u:" + ((d) list.get(0)).field_username + " n:" + ((d) list.get(0)).field_nickname + " d:" + ((d) list.get(0)).field_distance);
                    if (this.qqV) {
                        com.tencent.mm.sdk.platformtools.ar.H(this.mController.xIM, R.l.eOB);
                    }
                    wi(3);
                    dVar = (d) list.get(0);
                    if (!bh.ov(dVar.field_username)) {
                        this.qre.setTag(dVar.field_username);
                        this.qre.setVisibility(0);
                        ar.Hg();
                        com.tencent.mm.g.b.af WO = c.EY().WO(dVar.field_username);
                        String str = dVar.field_nickname + (com.tencent.mm.l.a.fZ(WO.field_type) ? getString(R.l.eOC) : "");
                        if (dVar.field_sex == 1) {
                            this.qre.setContentDescription(str + dVar.field_distance + this.mController.xIM.getString(R.l.eOX));
                        } else if (dVar.field_sex == 2) {
                            this.qre.setContentDescription(str + dVar.field_distance + this.mController.xIM.getString(R.l.eOW));
                        } else {
                            this.qre.setContentDescription(str + dVar.field_distance);
                        }
                        TextView textView = (TextView) this.qre.findViewById(R.h.cML);
                        textView.setText(i.b(this.mController.xIM, dVar.field_nickname + (com.tencent.mm.l.a.fZ(WO.field_type) ? getString(R.l.eOC) : ""), textView.getTextSize()));
                        if (this.ihQ != null) {
                            if (bh.ov(str)) {
                                this.ihQ.setContentDescription(getString(R.l.eOb));
                            } else {
                                this.ihQ.setContentDescription(String.format(getString(R.l.eOa), new Object[]{str}));
                            }
                        }
                        ((TextView) this.qre.findViewById(R.h.cMJ)).setText(dVar.field_distance);
                        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) this.qre.findViewById(R.h.cMK), dVar.field_username);
                        ImageView imageView = (ImageView) this.qre.findViewById(R.h.cMN);
                        if (dVar.field_reserved1 != 0) {
                            imageView.setVisibility(0);
                            imageView.setImageBitmap(BackwardSupportUtil.b.b(com.tencent.mm.z.ak.a.hfN.gO(dVar.field_reserved1), 2.0f));
                        } else {
                            imageView.setVisibility(8);
                        }
                        if (dVar.field_reserved1 != 0 || dVar.field_sex == 0) {
                            this.qre.findViewById(R.h.cMM).setVisibility(8);
                        } else {
                            Drawable b = com.tencent.mm.bv.a.b(this, dVar.field_sex == 1 ? R.k.dyN : R.k.dyM);
                            this.qre.findViewById(R.h.cMM).setVisibility(0);
                            ((ImageView) this.qre.findViewById(R.h.cMM)).setImageDrawable(b);
                        }
                        if (dVar.getProvince() == null) {
                            x.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
                            dVar.field_province = "";
                        }
                        if (dVar.getCity() == null) {
                            x.e("MicroMsg.ShakeReportUI", "CITY NULL");
                            dVar.field_city = "";
                        }
                        this.qre.startAnimation(AnimationUtils.loadAnimation(this.mController.xIM, R.a.bqu));
                        return;
                    }
                    return;
                } else {
                    if (this.qqV) {
                        com.tencent.mm.sdk.platformtools.ar.H(this.mController.xIM, R.l.eOB);
                    }
                    wi(3);
                    hU(false);
                    intent = new Intent(this, ShakeItemListUI.class);
                    intent.putExtra("_key_show_type_", -1);
                    intent.putExtra("_key_title_", getString(R.l.eOA));
                    startActivity(intent);
                    return;
                }
            }
            Jn(null);
        } else if (this.qrc.qnP == 3) {
            size = list.size();
            if (size == 0) {
                Jn(getString(R.l.eOI));
            } else if (size == 1) {
                if (this.qqV) {
                    com.tencent.mm.sdk.platformtools.ar.H(this.mController.xIM, R.l.eOB);
                }
                wi(3);
                if (((d) list.get(0)).field_type == 4) {
                    asv c = com.tencent.mm.plugin.shake.d.a.i.c(((d) list.get(0)).field_lvbuffer, j);
                    com.tencent.mm.av.b.c(c);
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_mode", 1);
                    intent2.putExtra("key_offset", c.wAj);
                    intent2.putExtra("music_player_beg_time", c.qRn);
                    intent2.putExtra("key_scene", 3);
                    if (com.tencent.mm.av.c.Qy()) {
                        intent2.putExtra("KGlobalShakeMusic", true);
                    }
                    com.tencent.mm.bm.d.b(this, "music", ".ui.MusicMainUI", intent2);
                    return;
                }
                x.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
            }
        } else if (this.qrc.qnP == 4) {
            hX(true);
            size = list.size();
            if (size == 0) {
                Jn(getString(R.l.ePd));
            } else if (size == 1) {
                if (this.qqV) {
                    com.tencent.mm.sdk.platformtools.ar.H(this.mController.xIM, R.l.eOB);
                }
                wi(3);
                new af().postDelayed(new 1((d) list.get(0), this), 100);
            }
        } else if (this.qrc.qnP == 5) {
            switch ((int) j) {
                case 1:
                    if (list.isEmpty() || ((d) list.get(0)).field_type != 11) {
                        Jn(null);
                        return;
                    } else if (list.size() == 1) {
                        if (this.qqV) {
                            com.tencent.mm.sdk.platformtools.ar.H(this.mController.xIM, R.l.eOB);
                        }
                        wi(3);
                        dVar = (d) list.get(0);
                        if (!bh.ov(dVar.field_username)) {
                            this.qre.setTag(dVar.field_username);
                            ((TextView) this.qre.findViewById(R.h.cML)).setText(dVar.field_username);
                            this.qre.setContentDescription(bh.ou(dVar.field_nickname));
                            ((TextView) this.qre.findViewById(R.h.cMJ)).setText(dVar.field_signature);
                            this.hCG.a(dVar.getProvince(), (ImageView) this.qre.findViewById(R.h.cMK));
                            this.qre.findViewById(R.h.cMM).setVisibility(8);
                            this.qre.startAnimation(AnimationUtils.loadAnimation(this.mController.xIM, R.a.bqu));
                            this.qre.setVisibility(0);
                            return;
                        }
                        return;
                    } else {
                        if (this.qqV) {
                            com.tencent.mm.sdk.platformtools.ar.H(this.mController.xIM, R.l.eOB);
                        }
                        wi(3);
                        hU(false);
                        intent = new Intent(this, ShakeItemListUI.class);
                        intent.putExtra("_key_show_type_", -12);
                        intent.putExtra("_key_title_", getString(R.l.eOz));
                        intent.putExtra("_key_show_from_shake_", true);
                        intent.putExtra("_ibeacon_new_insert_size", list.size());
                        startActivity(intent);
                        return;
                    }
                case 6:
                    Jn(getString(R.l.eOt));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, final com.tencent.mm.plugin.shake.c.a.e eVar, long j) {
        this.qrW = true;
        if (i == 1251) {
            if (eVar != null) {
                x.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
                com.tencent.mm.plugin.shake.c.c.a.brw();
                bsv();
                bsq();
                bst();
                this.qrU = 4;
                m.brI().putValue("key_shake_card_item", eVar);
            }
        } else if (i != 1250) {
        } else {
            if (eVar == null) {
                this.qrA = null;
                Jn(null);
            } else if ((eVar == null || this.qqW) && !this.qqW) {
                this.qrA = null;
                Jn(null);
            } else {
                this.qqW = false;
                x.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
                if (this.qrc.qnP == 6) {
                    l.b bVar = this.qrc.qnQ;
                    if (bVar != null && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
                        com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                        switch ((int) j) {
                            case 1:
                                x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
                                if (gVar.kLy == 3) {
                                    x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
                                    if (eVar == null || TextUtils.isEmpty(eVar.qos)) {
                                        Jn(getString(R.l.eOc));
                                        return;
                                    } else {
                                        Jn(eVar.qos);
                                        return;
                                    }
                                }
                                x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + gVar.kLy);
                                wi(3);
                                if (eVar.kLy == 1) {
                                    this.qqY = false;
                                }
                                if (this.qrV != null && this.qrV.isShowing()) {
                                    return;
                                }
                                if (eVar.qou) {
                                    ViewStub viewStub = (ViewStub) findViewById(R.h.cVT);
                                    if (viewStub != null) {
                                        viewStub.inflate();
                                    }
                                    ((ShakeEggAnimFrame) findViewById(R.h.bSN)).J(this);
                                    new af().postDelayed(new Runnable(this) {
                                        final /* synthetic */ ShakeReportUI qsi;

                                        public final void run() {
                                            this.qsi.a(eVar);
                                        }
                                    }, 1000);
                                    return;
                                }
                                a(eVar);
                                return;
                            case 2:
                                x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
                                Jn(getString(R.l.eOc));
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        }
    }

    private void a(com.tencent.mm.plugin.shake.c.a.e eVar) {
        this.qrV = com.tencent.mm.plugin.shake.c.b.a.a(this, eVar, new 16(this), new 17(this));
    }

    private void ct(View view) {
        if (view != null) {
            x.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), bh.cgy(), this});
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")) {
                az("", false);
                if (view.getId() == R.h.cNg) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11722, new Object[]{Integer.valueOf(1)});
                    if (this.qrI != 1) {
                        if (this.qrI == 4) {
                            hS(false);
                        }
                        this.qrI = 1;
                        bso();
                        hU(false);
                        if (this.qre != null) {
                            this.qre.setVisibility(8);
                        }
                    }
                } else if (view.getId() == R.h.cNm) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11722, new Object[]{Integer.valueOf(2)});
                    if (!(this.gyB || this.gyy == null)) {
                        this.gyy.a(this.gyF, true);
                    }
                    if (!(com.tencent.mm.p.a.aW(this) || com.tencent.mm.p.a.aU(this) || this.qrI == 3)) {
                        if (this.qrI == 4) {
                            hS(false);
                        }
                        this.qrI = 3;
                        bso();
                        hU(false);
                        if (this.qre != null) {
                            this.qre.setVisibility(8);
                        }
                    }
                    if (com.tencent.mm.av.c.Qy()) {
                        ar.Hg();
                        if (c.CU().getInt(4118, 0) == 0) {
                            com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this.mController.xIM);
                            aVar.Ez(R.l.dGO);
                            aVar.EA(R.l.eOv);
                            aVar.EC(R.l.eOu).a(new 2(this));
                            aVar.mi(true);
                            aVar.d(new 3(this));
                            this.qry = aVar.akx();
                            this.qry.show();
                        }
                    }
                } else if (view.getId() == R.h.cNp) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11722, new Object[]{Integer.valueOf(3)});
                    if (!(this.gyB || this.gyy == null)) {
                        this.gyy.a(this.gyF, true);
                    }
                    if (!(com.tencent.mm.p.a.aW(this) || com.tencent.mm.p.a.aU(this) || this.qrI == 4)) {
                        hS(true);
                        this.qrI = 4;
                        bso();
                        hU(false);
                        if (this.qre != null) {
                            this.qre.setVisibility(8);
                        }
                    }
                } else if (view.getId() == R.h.cNk || view.getId() == R.h.cNh) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11722, new Object[]{Integer.valueOf(4)});
                    if (this.qrI != 5) {
                        this.qrI = 5;
                        bso();
                        hU(false);
                        if (this.qre != null) {
                            this.qre.setVisibility(8);
                        }
                        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
                            boolean isProviderEnabled;
                            LocationManager locationManager = (LocationManager) ac.getContext().getSystemService("location");
                            if (locationManager != null) {
                                isProviderEnabled = locationManager.isProviderEnabled("gps");
                            } else {
                                isProviderEnabled = true;
                            }
                            if (!isProviderEnabled) {
                                Jn(getString(R.l.eOp));
                            }
                        }
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
                            Jn(getString(R.l.eOo));
                        } else if (defaultAdapter == null) {
                            Jn(getString(R.l.eOs));
                        }
                    }
                } else if (view.getId() == R.h.cNc) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11722, new Object[]{Integer.valueOf(5)});
                    if (this.qrI != 6) {
                        if (this.qrI == 4) {
                            hS(false);
                        }
                        this.qrI = 6;
                        bso();
                        hU(false);
                        if (this.qre != null) {
                            this.qre.setVisibility(8);
                        }
                        com.tencent.mm.s.c.Bq().p(262155, false);
                        this.qrG.setVisibility(8);
                    }
                }
                hT(true);
                hW(false);
                hX(true);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    ar.Hg();
                    intent2.putExtra("CropImage_OutputPath", stringBuilder.append(c.Fi()).append("custom_shake_img_filename.jpg").toString());
                    com.tencent.mm.plugin.shake.a.ifs.a(intent2, 2, this, intent);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ar.Hg();
                    c.CU().set(4110, Boolean.valueOf(false));
                    ar.Hg();
                    c.CU().set(4111, stringExtra);
                    bsn();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        bsp();
        if (!this.qqX) {
            hT(true);
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        a("", null);
    }

    public final void l(String str, Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled() && this.qrt != null && this.qrt.getTag() != null && str.equals((String) this.qrt.getTag())) {
            this.qrt.setImageBitmap(bitmap);
        }
    }

    public final void brL() {
        com.tencent.mm.plugin.shake.c.c.a.brw();
        bsq();
        bsr();
        bsu();
        bsv();
        bst();
    }

    private void bsq() {
        if (!com.tencent.mm.plugin.shake.c.c.a.bsb()) {
            return;
        }
        if (com.tencent.mm.s.c.Bq().aR(262155, 266259)) {
            this.qrG.setVisibility(0);
        } else {
            this.qrG.setVisibility(8);
        }
    }

    private void bsr() {
        if (this.qrI == 6 && com.tencent.mm.plugin.shake.c.c.a.bsb()) {
            boolean aR = com.tencent.mm.s.c.Bq().aR(262154, 266258);
            boolean aR2 = com.tencent.mm.s.c.Bq().aR(262155, 266259);
            if (aR) {
                az(com.tencent.mm.plugin.shake.c.c.a.brW(), true);
            } else if (aR2) {
                az(com.tencent.mm.plugin.shake.c.c.a.brY(), true);
            } else if (!this.qrW) {
                if (TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.brU())) {
                    az(getString(R.l.eOd), true);
                } else {
                    az(com.tencent.mm.plugin.shake.c.c.a.brU(), true);
                }
            }
        }
    }

    private void az(String str, boolean z) {
        this.qqW = false;
        if (this.qrq == null) {
            this.qrq = AnimationUtils.loadAnimation(this.mController.xIM, R.a.bpY);
        }
        wi(2);
        hV(true);
        if (str != null && str.length() > 1) {
            this.qrh.setText(str);
        } else if (z) {
            this.qrh.setText(R.l.eOd);
        } else {
            this.qrh.setText("");
            hV(false);
        }
        this.qqZ = true;
    }

    private void bss() {
        if (this.qrV != null && this.qrV.isShowing()) {
            this.qrV.dismiss();
        }
        this.qrV = null;
    }

    private void bst() {
        int intExtra;
        int i;
        int i2 = 1;
        boolean brx = com.tencent.mm.plugin.shake.c.c.a.brx();
        boolean aR = com.tencent.mm.s.c.Bq().aR(262154, 266258);
        boolean aR2 = com.tencent.mm.s.c.Bq().aR(262155, 266259);
        if (getIntent().getBooleanExtra("shake_card", false)) {
            intExtra = getIntent().getIntExtra("shake_card", 0);
        } else {
            intExtra = 0;
        }
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(intExtra);
        if (aR) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(brx ? 1 : 0);
        objArr[4] = com.tencent.mm.plugin.shake.c.c.a.brX();
        objArr[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.brT());
        gVar.h(11668, objArr);
        com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr2 = new Object[6];
        objArr2[0] = Integer.valueOf(2);
        objArr2[1] = Integer.valueOf(intExtra);
        if (aR2) {
            intExtra = 1;
        } else {
            intExtra = 0;
        }
        objArr2[2] = Integer.valueOf(intExtra);
        if (!brx) {
            i2 = 0;
        }
        objArr2[3] = Integer.valueOf(i2);
        objArr2[4] = com.tencent.mm.plugin.shake.c.c.a.brX();
        objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.brT());
        gVar2.h(11668, objArr2);
    }

    private void bsu() {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.brV())) {
            this.qrH.setText(com.tencent.mm.plugin.shake.c.c.a.brV());
        }
    }

    private void bsv() {
        if (com.tencent.mm.av.c.Qx()) {
            x.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
            this.qrX.put(Integer.valueOf(3), Boolean.valueOf(true));
            findViewById(R.h.cNm).setVisibility(0);
            if (com.tencent.mm.av.c.Qy()) {
                ar.Hg();
                if (c.CU().getInt(4118, 0) == 0) {
                    this.qrF.setVisibility(0);
                } else {
                    this.qrF.setVisibility(8);
                }
            }
        } else {
            this.qrX.put(Integer.valueOf(3), Boolean.valueOf(false));
            findViewById(R.h.cNm).setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
        }
        if (k.brA()) {
            this.qrX.put(Integer.valueOf(4), Boolean.valueOf(true));
            findViewById(R.h.cNp).setVisibility(0);
            x.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        } else {
            this.qrX.put(Integer.valueOf(4), Boolean.valueOf(false));
            findViewById(R.h.cNp).setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
        }
        if (com.tencent.mm.plugin.shake.c.c.a.bsb()) {
            this.qrX.put(Integer.valueOf(6), Boolean.valueOf(true));
            findViewById(R.h.cNc).setVisibility(0);
            x.i("MicroMsg.ShakeReportUI", "show shake card tab");
        } else {
            findViewById(R.h.cNc).setVisibility(8);
            this.qrX.put(Integer.valueOf(6), Boolean.valueOf(false));
            x.i("MicroMsg.ShakeReportUI", "hide shake card tab");
        }
        if (bsw()) {
            this.qrX.put(Integer.valueOf(5), Boolean.valueOf(true));
            this.qrT.setVisibility(0);
            x.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        } else {
            this.qrX.put(Integer.valueOf(5), Boolean.valueOf(false));
            this.qrT.setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
        }
        int i = 0;
        for (Boolean booleanValue : this.qrX.values()) {
            int i2;
            if (booleanValue.booleanValue()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        this.qrJ = i;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.cMX);
        if (i == 1) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
        if (i > 4 && this.qse) {
            findViewById(R.h.cNp).setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
            this.qrJ--;
        } else if (i > 4 && !this.qse) {
            this.qrT.setVisibility(8);
            this.qrY = false;
            this.qrJ--;
            x.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
        }
    }

    private boolean bsw() {
        x.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + w.cfe() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + w.cfi());
        return this.qrY && bsx();
    }

    private static boolean bsx() {
        return w.cfe() || w.cfi().equals("en") || w.cfi().equals("ja");
    }

    private void hX(boolean z) {
        this.qrK.setVisibility(8);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ShakeReportUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.ShakeReportUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    blL();
                    return;
                }
                this.pyw = false;
                h.a(this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 21(this), new 23(this));
                return;
            case 80:
                if (iArr[0] != 0) {
                    h.a(this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 19(this), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ShakeReportUI qsi;

                        {
                            this.qsi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
