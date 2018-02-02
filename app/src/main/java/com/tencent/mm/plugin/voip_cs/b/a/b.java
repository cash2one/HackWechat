package com.tencent.mm.plugin.voip_cs.b.a;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.brandservice.a.j;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.k.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.pb.common.c.g;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;

public final class b implements SurfaceTextureListener, OnClickListener, a, f {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] sqb = new int[]{-1, R.l.eUT, R.l.eUY, R.l.eUX};
    public boolean fvI = false;
    private af hae;
    private Timer jwk;
    public TextView kBH;
    private TextView ldK;
    private View oIE;
    public com.tencent.mm.plugin.voip.video.a oIP;
    public ObservableTextureView oIR;
    private ImageButton oIm;
    private OpenGlView sqA;
    public OpenGlRender sqB;
    public OpenGlRender sqC;
    private VoipBigIconButton sqW;
    private OpenGlView sqz;
    private OnClickListener srH = new 3(this);
    private boolean srp = false;
    Drawable sxA = null;
    public VoipCSMainUI sxd;
    public RelativeLayout sxe;
    private TextView sxf;
    private TextView sxg;
    private TextView sxh;
    private TextView sxi;
    public ImageView sxj;
    private af sxk;
    private boolean sxl = false;
    protected long sxm = -1;
    private boolean sxn = false;
    private boolean sxo = false;
    public int sxp = 60000;
    public int sxq = 5000;
    private com.tencent.mm.plugin.voip_cs.c.a sxr = new com.tencent.mm.plugin.voip_cs.c.a();
    public String sxs = "";
    public String sxt = "";
    public ak sxu = new ak(Looper.getMainLooper(), new 1(this), false);
    public ak sxv = new ak(Looper.getMainLooper(), new 2(this), false);
    a sxw = new a(this, (byte) 0);
    c sxx;
    b sxy;
    String sxz = "";

    class b implements Runnable {
        final /* synthetic */ b sxB;

        b(b bVar) {
            this.sxB = bVar;
        }

        public final void run() {
            this.sxB.sxA = b.MK(this.sxB.sxz);
            Message message = new Message();
            message.what = 12;
            this.sxB.sxk.sendMessage(message);
            e.remove(this.sxB.sxy);
        }
    }

    class c implements Runnable {
        boolean skQ = false;
        final /* synthetic */ b sxB;

        c(b bVar) {
            this.sxB = bVar;
        }

        public final void run() {
            while (!this.skQ && !this.sxB.fvI) {
                if (com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.videoDecode(com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.soW) == 1) {
                    int i = com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.field_remoteImgWidth;
                    int i2 = com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.field_remoteImgHeight;
                    if (OpenGlRender.suw == 1) {
                        if (this.sxB.srp) {
                            this.sxB.sqC.a(com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.soW, i, i2, OpenGlRender.suc + OpenGlRender.sui);
                        } else {
                            this.sxB.sqB.a(com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.soW, i, i2, OpenGlRender.suc + OpenGlRender.sui);
                        }
                    } else if (this.sxB.srp) {
                        this.sxB.sqC.a(com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.soW, i, i2, OpenGlRender.suf + OpenGlRender.sui);
                    } else {
                        this.sxB.sqB.a(com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.soW, i, i2, OpenGlRender.suf + OpenGlRender.sui);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", e, "", new Object[0]);
                }
            }
        }
    }

    public b(VoipCSMainUI voipCSMainUI) {
        this.sxd = voipCSMainUI;
        WindowManager windowManager = (WindowManager) voipCSMainUI.getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) voipCSMainUI.findViewById(R.h.cIi)).setPadding(0, 0, 0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(voipCSMainUI.mController.xIM, 40.0f));
        }
        this.sqA = new MovableVideoView(voipCSMainUI.getApplicationContext());
        ((MovableVideoView) this.sqA).dR(width, height);
        this.sqA.setVisibility(8);
        this.sqB = new OpenGlRender(this.sqA, OpenGlRender.sum);
        this.sqA.a(this.sqB);
        this.sqA.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.sqA.setZOrderOnTop(true);
        } else {
            this.sqA.setZOrderMediaOverlay(true);
        }
        this.ldK = (TextView) voipCSMainUI.findViewById(R.h.cRs);
        this.ldK.setVisibility(0);
        this.jwk = new Timer("voip_cs_talking_time");
        this.sxf = (TextView) voipCSMainUI.findViewById(R.h.cXq);
        this.sxf.setVisibility(0);
        this.sxg = (TextView) voipCSMainUI.findViewById(R.h.cXv);
        if (voipCSMainUI.fKC.equals("1")) {
            if (voipCSMainUI.type.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                this.sxg.setText(ac.getContext().getString(R.l.eUC));
            } else {
                this.sxg.setText(ac.getContext().getString(R.l.eUD));
            }
        } else if (voipCSMainUI.type.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            this.sxg.setText(ac.getContext().getString(R.l.eUE));
        } else {
            this.sxg.setText(ac.getContext().getString(R.l.eUD));
        }
        this.sxg.setVisibility(0);
        this.kBH = (TextView) voipCSMainUI.findViewById(R.h.cXx);
        this.kBH.setVisibility(0);
        this.sxj = (ImageView) voipCSMainUI.findViewById(R.h.cXr);
        this.sxj.setVisibility(0);
        this.sxi = (TextView) voipCSMainUI.findViewById(R.h.cXu);
        this.sxh = (TextView) voipCSMainUI.findViewById(R.h.cXw);
        this.sqW = (VoipBigIconButton) voipCSMainUI.findViewById(R.h.cXs);
        if (voipCSMainUI.sxJ == null || !voipCSMainUI.sxJ.equals("1")) {
            this.sqW.setVisibility(8);
        } else {
            this.sqW.setVisibility(0);
            this.sqW.setOnClickListener(this.srH);
        }
        this.hae = new af();
        this.sxk = new 4(this);
        this.oIE = voipCSMainUI.findViewById(R.h.cXo);
        this.oIm = (ImageButton) voipCSMainUI.findViewById(R.h.cXt);
        this.sxe = (RelativeLayout) voipCSMainUI.findViewById(R.h.cXo);
        mScreenWidth = com.tencent.mm.bv.a.eA(voipCSMainUI.mController.xIM);
        mScreenHeight = com.tencent.mm.plugin.voip_cs.c.b.dI(voipCSMainUI.mController.xIM);
        this.sqz = (OpenGlView) voipCSMainUI.findViewById(R.h.cXp);
        this.sqz.dS(mScreenWidth, mScreenHeight);
        this.sqC = new OpenGlRender(this.sqz, OpenGlRender.sul);
        this.sqz.a(this.sqC);
        this.sqz.setRenderMode(0);
        this.sqz.setVisibility(0);
        x.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[]{Integer.valueOf(mScreenHeight)});
        this.oIm.setOnClickListener(this);
        this.sxe.addView(this.sqA);
        this.sqA.setOnClickListener(new 5(this));
        this.sqB.stS = true;
        this.sqC.stS = true;
        if (!d.dD(ac.getContext())) {
            d.dE(ac.getContext());
        }
        SharedPreferences cft = ac.cft();
        this.sxs = cft.getString(bJc(), "");
        if (this.sxd.jiK != null && !this.sxd.jiK.equals("")) {
            MJ(this.sxd.jiK);
        } else if (!g.isNullOrEmpty(this.sxs)) {
            MJ(this.sxs);
        }
        this.sxt = cft.getString(bJd(), "");
        if (!g.isNullOrEmpty(this.sxt)) {
            MI(this.sxt);
        }
        com.tencent.mm.ae.e bIT = com.tencent.mm.plugin.voip_cs.b.b.bIT();
        String str = this.sxd.swW;
        x.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:" + str);
        ar.CG().a(455, bIT);
        ar.CG().a(new j(str), 0);
    }

    public final void MI(String str) {
        CharSequence charSequence;
        if (this.sxd.sxM) {
            charSequence = str + ac.getContext().getString(R.l.eUw);
        } else {
            charSequence = str + ac.getContext().getString(R.l.eUx);
        }
        this.kBH.setText(charSequence);
    }

    public final void MJ(String str) {
        if (!g.isNullOrEmpty(str)) {
            this.sxy = new b(this);
            if (this.sxd.jiK == null || this.sxd.jiK.equals("")) {
                this.sxz = str;
            } else {
                this.sxz = this.sxd.jiK;
            }
            e.b(this.sxy, "VOIPCS_netPic", 10);
        }
    }

    public final String bJc() {
        return "voip_cs_headImageUrl_" + this.sxd.swW;
    }

    public final String bJd() {
        return "voip_cs_nickname_" + this.sxd.swW;
    }

    private Point jm(boolean z) {
        int height = ((WindowManager) this.sxd.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
        return new Point((int) (jk(!z) * ((float) height)), height);
    }

    private static float jk(boolean z) {
        byte[] bArr;
        float f = 0.74766356f;
        if (z) {
            try {
                bArr = com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.field_capInfo;
            } catch (Exception e) {
                x.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + e.getMessage());
            }
        } else {
            bArr = com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.sof;
        }
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (wrap.getInt() > 65535) {
                wrap.order(ByteOrder.LITTLE_ENDIAN);
            }
            wrap.getShort();
            wrap.getShort();
            float f2 = ((float) wrap.getInt()) / 100.0f;
            if (f2 != 0.0f) {
                f = f2;
            }
            x.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", new Object[]{Float.valueOf(f), Boolean.valueOf(z)});
        }
        return f;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (view.getId() == R.h.cXt) {
            if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV < 2) {
                com.tencent.mm.plugin.voip_cs.b.b.bIU().bjS = 2;
            } else {
                com.tencent.mm.plugin.voip_cs.b.b.bIU().bjS = 4;
            }
            com.tencent.mm.plugin.voip_cs.b.c bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
            bIU.svY = 1;
            bIU.swv = 1;
            bIU.svZ = (int) (System.currentTimeMillis() / 1000);
            bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
            x.d("MicroMsg.VoipCSReportHelper", "selfCancel");
            if (bIU.sws == 0) {
                bIU.swn = 3;
                if (bIU.sww == 0 && bIU.swI != 0) {
                    bIU.sww = (long) (((int) (System.currentTimeMillis() / 1000)) - bIU.swI);
                }
            }
            com.tencent.mm.plugin.voip_cs.b.b.bIU().bIV();
            x.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
            za(0);
            return;
        }
        int i = this.oIm.getVisibility() == 0 ? 8 : 0;
        this.oIm.setVisibility(i);
        this.ldK.setVisibility(i);
        this.sxf.setVisibility(i);
        yZ(i);
        if (i == 0) {
            z = true;
        }
        jr(z);
    }

    private void yZ(int i) {
        if (this.sxd.sxJ == null || !this.sxd.sxJ.equals("1")) {
            this.sqW.setVisibility(8);
        } else {
            this.sqW.setVisibility(i);
        }
    }

    public final void bJe() {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
        if (this.oIR != null) {
            this.sxe.removeView(this.oIR);
            this.oIR = null;
        }
        if (this.oIP != null) {
            this.oIP.bIw();
            com.tencent.mm.plugin.voip.video.a.bIx();
            this.oIP = null;
        }
    }

    private void bJf() {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
        this.hae.postDelayed(new 6(this), 10000);
    }

    private void jr(boolean z) {
        if (Build.MANUFACTURER.equalsIgnoreCase("sony")) {
            x.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
        } else if (z) {
            this.sxd.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            this.sxd.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
    }

    public final void aSV() {
        this.sxu.TG();
        this.sxv.TG();
        this.sxr.bIg();
        this.sxh.setVisibility(8);
        this.sxg.setText(R.l.eUW);
        this.sxf.setText(R.l.eUK);
        yZ(0);
        this.oIE.setOnClickListener(this);
        if (this.sxd.sxK != null && this.sxd.sxK.equals("1")) {
            this.sqA.setVisibility(0);
            this.srp = true;
            Point jm = jm(this.srp);
            ((MovableVideoView) this.sqA).dR(jm.x, jm.y);
            bJg();
        }
        bJf();
        this.sxn = true;
        if (this.jwk == null) {
            this.jwk = new Timer("voip_cs_talking_time");
        }
        if (!this.sxl) {
            if (this.sxm == -1) {
                this.sxm = bh.Wo();
            }
            this.sxl = true;
            this.jwk.schedule(new 7(this), 1000, 1000);
            k.bHh().bHi();
            k.bHh().smH = this;
        }
    }

    public static Drawable MK(String str) {
        try {
            return Drawable.createFromStream((InputStream) new URL(str).getContent(), "urlDrawable");
        } catch (Exception e) {
            x.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
            return null;
        }
    }

    protected static String bp(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    public final void za(int i) {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:" + i);
        if (this.jwk != null) {
            this.jwk.cancel();
            this.jwk = null;
        }
        if (!this.sxu.cfK()) {
            this.sxu.TG();
        }
        if (!this.sxv.cfK()) {
            this.sxv.TG();
        }
        this.sxr.bIg();
        this.sxl = false;
        this.sxi.setVisibility(0);
        this.sxi.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.sxi.setBackgroundResource(R.g.bHH);
        this.sxi.setCompoundDrawables(null, null, null, null);
        this.sxi.setCompoundDrawablePadding(0);
        this.sxi.setText(zb(i));
        if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV == 2) {
            e.post(new 8(this), "VoipCS_play_end_sound");
        }
        this.hae.postDelayed(new Runnable(this) {
            final /* synthetic */ b sxB;

            {
                this.sxB = r1;
            }

            public final void run() {
                this.sxB.sxd.finish();
            }
        }, 2000);
    }

    private static int zb(int i) {
        if (i == 1) {
            return R.l.eUB;
        }
        if (i == 0) {
            return R.l.eUG;
        }
        if (i == -1 || i == 5) {
            return R.l.eUR;
        }
        if (i == ap.CTRL_INDEX || i == TencentLocation.ERROR_UNKNOWN) {
            return R.l.eUZ;
        }
        if (i == 6) {
            return R.l.eUU;
        }
        if (i == 1001) {
            return R.l.eUQ;
        }
        if (i == 10) {
            return R.l.eUF;
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.bIT().swV < 2) {
            return R.l.eUA;
        }
        return R.l.eUG;
    }

    public final void aSW() {
        this.sxi.setVisibility(0);
        this.sxi.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.sxi.setBackgroundResource(R.g.bHH);
        this.sxi.setCompoundDrawables(null, null, null, null);
        this.sxi.setCompoundDrawablePadding(0);
        this.sxi.setText(zb(1001));
    }

    public final void aSX() {
        this.sxi.setVisibility(8);
    }

    public final void c(byte[] bArr, long j, int i, int i2, int i3) {
        x.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.fvI);
        if (!this.fvI) {
            if (this.sxw.oGZ == null) {
                this.sxw.w = i;
                this.sxw.h = i2;
                this.sxw.oGZ = new int[(this.sxw.w * this.sxw.h)];
            }
            int i4 = this.oIP.bIy() ? OpenGlRender.suk : 0;
            int i5 = this.oIP.bIz() ? OpenGlRender.suj : OpenGlRender.sui;
            if (this.sxn) {
                x.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = " + com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.videoEncodeToSend(bArr, bArr.length, i, i2, i3));
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG;
                com_tencent_mm_plugin_voip_model_v2protocal.spp++;
            }
            com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.videoEncodeToLocal(bArr, (int) j, i, i2, i3, 0, 75, this.sxw.oGZ);
            if (OpenGlRender.suw == 1) {
                if (this.srp) {
                    this.sqB.a(this.sxw.oGZ, i, i2, (OpenGlRender.sud + i4) + i5);
                } else {
                    this.sqC.a(this.sxw.oGZ, i, i2, (OpenGlRender.sud + i4) + i5);
                }
            } else if (OpenGlRender.suw != 2) {
            } else {
                if (this.srp) {
                    this.sqB.c(bArr, i, i2, (OpenGlRender.suh + i4) + i5);
                } else {
                    this.sqC.c(bArr, i, i2, (OpenGlRender.suh + i4) + i5);
                }
            }
        }
    }

    public final void bdd() {
        x.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    }

    public final void bJg() {
        bJh();
        this.sxx = new c(this);
        e.b(this.sxx, "VOIPCS_VideoDecode", 10);
        x.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    }

    public final void bJh() {
        if (this.sxx != null) {
            x.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
            this.sxx.skQ = true;
            e.remove(this.sxx);
            this.sxx = null;
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
