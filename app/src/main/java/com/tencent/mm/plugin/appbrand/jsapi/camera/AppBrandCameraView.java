package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView$a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppBrandCameraView extends RelativeLayout implements d, e, f {
    private ImageView fvf;
    p jia;
    int jib;
    private String jic = "back";
    String jid = "auto";
    String jie = "high";
    boolean jif;
    private boolean jig = false;
    private int jih = 1080;
    private int jii = 1920;
    private int jij = 1080;
    private int jik = 1920;
    c jil;
    b jim;
    MMSightRecordView jin;
    private String jio;
    private String jip;
    private String jiq;
    int jir = -1;
    boolean jis = false;
    long jit = -1;
    long jiu = -1;
    MMSightRecordView$a jiv = new 3(this);
    String mAppId;
    Context mContext;

    static /* synthetic */ void a(AppBrandCameraView appBrandCameraView, int i, String str, String str2) {
        x.i("MicroMsg.AppBrandCameraView", "onTakePhoto.ret:%d, path:%s, errMsg:%s", new Object[]{Integer.valueOf(i), str, str2});
        if (appBrandCameraView.jil != null) {
            appBrandCameraView.jil.b(i, str, str2, appBrandCameraView.jij, appBrandCameraView.jik);
        }
        appBrandCameraView.jis = false;
        appBrandCameraView.agd();
        appBrandCameraView.jir = 1;
    }

    public AppBrandCameraView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(h.iwM, this);
    }

    public final void initView() {
        x.i("MicroMsg.AppBrandCameraView", "initView");
        if (a.afZ().afY()) {
            age();
            agd();
            agb();
            agc();
        }
    }

    public final void T(String str, boolean z) {
        if (!bh.fu(this.jic, str)) {
            this.jic = str;
            if (!z && this.jin != null) {
                this.jin.oqX.switchCamera();
            }
        }
    }

    public final void sl(String str) {
        if (!bh.fu(this.jid, str)) {
            this.jid = str;
        }
    }

    public final boolean bH(int i, int i2) {
        if (this.jih == i && this.jii == i2) {
            return false;
        }
        x.i("MicroMsg.AppBrandCameraView", "setViewSize");
        this.jih = i;
        this.jii = i2;
        return true;
    }

    public final void afA() {
        Map hashMap;
        String jSONObject;
        com.tencent.mm.plugin.appbrand.jsapi.f a;
        x.i("MicroMsg.AppBrandCameraView", "onUIPause");
        if (this.jir == 2) {
            x.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
            hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(this.jib));
            hashMap.put("errMsg", "stop on record");
            jSONObject = new JSONObject(hashMap).toString();
            a = new g().a(this.jia);
            a.mData = jSONObject;
            a.afs();
        }
        if (this.jin != null) {
            Bitmap Ym = this.jin.oqX.Ym();
            if (Ym != null) {
                this.fvf.setImageBitmap(Ym);
            }
        }
        release();
        hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(this.jib));
        jSONObject = new JSONObject(hashMap).toString();
        a = new e().a(this.jia);
        a.mData = jSONObject;
        a.afs();
    }

    public final void aga() {
        x.i("MicroMsg.AppBrandCameraView", "onUIResume");
        synchronized (AppBrandCameraView.class) {
            agb();
        }
    }

    public final void onDestroy() {
        release();
    }

    public final void release() {
        x.i("MicroMsg.AppBrandCameraView", "release");
        synchronized (AppBrandCameraView.class) {
            if (this.jin != null) {
                this.jin.oqX.release();
                removeView(this.jin);
                this.jir = -1;
                this.jin = null;
            }
        }
    }

    private String sm(String str) {
        if (bh.ov(str)) {
            return str;
        }
        AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(this.mAppId, str, true);
        if (attach != null) {
            return attach.fus;
        }
        return null;
    }

    private void agb() {
        x.i("MicroMsg.AppBrandCameraView", "initCamera.");
        if (!a.afZ().afY()) {
            Toast.makeText(this.mContext, j.iBY, 1).show();
            x.w("MicroMsg.AppBrandCameraView", "no permission");
        } else if (this.jin != null) {
            x.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
        } else {
            if (this.fvf == null) {
                this.fvf = new ImageView(this.mContext);
                this.fvf.setScaleType(ScaleType.FIT_XY);
                addView(this.fvf, new LayoutParams(-1, -1));
            } else {
                this.fvf.setImageBitmap(null);
            }
            this.jin = new MMSightRecordView(this.mContext);
            addView(this.jin);
            this.jin.jp(720);
            this.jin.oqX.Yl();
            this.jin.R((((float) this.jih) * 1.0f) / ((float) this.jii));
            this.jin.sK(600000);
            this.jin.oP(this.jio);
            this.jin.aZS();
            this.jin.aZR();
            MMSightRecordView mMSightRecordView = this.jin;
            mMSightRecordView.oqX.ck("back".equals(this.jic));
            this.jin.oqX.startPreview();
            this.jin.oqX.Yc();
            mMSightRecordView = this.jin;
            mMSightRecordView.oqX.a(new c(this) {
                final /* synthetic */ AppBrandCameraView jiw;

                {
                    this.jiw = r1;
                }

                public final void agh() {
                    x.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
                    Map hashMap = new HashMap();
                    hashMap.put("cameraId", Integer.valueOf(this.jiw.jib));
                    String jSONObject = new JSONObject(hashMap).toString();
                    com.tencent.mm.plugin.appbrand.jsapi.f a = new d().a(this.jiw.jia);
                    a.mData = jSONObject;
                    a.afs();
                }
            });
            this.jir = 1;
        }
    }

    public final void agc() {
        if (this.jin == null) {
            x.i("MicroMsg.AppBrandCameraView", "recordView is null");
            return;
        }
        if (this.jif) {
            this.jin.a(this.jiv);
        } else {
            this.jin.a(null);
        }
        agf();
    }

    private void agd() {
        this.jiq = com.tencent.mm.compatible.util.e.gHu + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
    }

    private void age() {
        String str = "MicroMsg_" + System.currentTimeMillis();
        this.jio = com.tencent.mm.compatible.util.e.gHu + str + ".mp4";
        this.jip = com.tencent.mm.compatible.util.e.gHu + str + ".jpeg";
        if (this.jin != null) {
            this.jin.oP(this.jio);
        }
    }

    public final void agf() {
        if (this.jin != null && this.jid != null) {
            if (this.jir != 2) {
                if (this.jin.oqX.Yj() == 1) {
                    this.jin.jq(2);
                }
                if (this.jid.equals("auto")) {
                    this.jin.jq(3);
                }
            } else if (this.jid.equals("on")) {
                this.jin.jq(1);
            } else {
                this.jin.jq(2);
            }
        }
    }

    final void I(int i, String str) {
        if (this.jil != null) {
            this.jil.I(i, str);
        }
    }

    public final void uE() {
        x.i("MicroMsg.AppBrandCameraView", JsApiStopRecordVoice.NAME);
        if (this.jin == null) {
            x.i("MicroMsg.AppBrandCameraView", "recordView is null");
            c(-1, "camera is null", null, null);
        } else if (this.jir != 2) {
            x.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
            c(-1, "is not recording", null, null);
        } else if (this.jig) {
            x.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
            c(-1, "is stopping", null, null);
        } else {
            this.jig = true;
            this.jin.a(new MMSightRecordView.f(this) {
                final /* synthetic */ AppBrandCameraView jiw;

                {
                    this.jiw = r1;
                }

                public final void cJ(boolean z) {
                    x.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", new Object[]{Boolean.valueOf(z)});
                    if (this.jiw.jin == null) {
                        x.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
                        this.jiw.c(-1, "camera is null", null, null);
                        return;
                    }
                    this.jiw.jir = 1;
                    if (z) {
                        this.jiw.c(-1, "stop error", null, null);
                    } else {
                        this.jiw.a(com.tencent.mm.plugin.sight.base.d.R(this.jiw.jin.oqX.Yb(), this.jiw.jih, this.jiw.jii), this.jiw.jip);
                        this.jiw.c(0, "", this.jiw.jip, this.jiw.jin.oqX.Yb());
                    }
                    this.jiw.age();
                    this.jiw.jig = false;
                }
            });
        }
    }

    private void c(int i, String str, String str2, String str3) {
        if (this.jil != null) {
            this.jil.c(i, str, sm(str2), sm(str3));
        }
        agf();
    }

    private boolean a(Bitmap bitmap, String str) {
        if (!(bitmap == null || bitmap.isRecycled())) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (!(width == 0 || height == 0)) {
                    if ("normal".equals(this.jie)) {
                        bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, (height * 2) / 3, (width * 2) / 3, false, true);
                    } else if ("low".equals(this.jie)) {
                        bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, height / 2, width / 2, false, true);
                    }
                }
                this.jij = bitmap.getWidth();
                this.jik = bitmap.getHeight();
                com.tencent.mm.sdk.platformtools.d.a(bitmap, 90, CompressFormat.JPEG, str, true);
                x.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[]{Long.valueOf(FileOp.me(str))});
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", new Object[]{e.getMessage()});
            }
        }
        return false;
    }
}
