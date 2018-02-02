package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class t extends i implements SensorEventListener {
    private SensorManager bgR;
    Sensor bkA;
    Sensor bkC;
    ImageView fvf;
    ProgressBar lAk;
    final int rkA = 1;
    HorizontalScrollView rkB;
    float[] rkC;
    float[] rkD;
    private int rkE = 0;
    boolean rkF = true;
    int rky;
    final float rkz = 10.0f;

    public t(Context context, o oVar, ViewGroup viewGroup) {
        super(context, oVar, viewGroup);
    }

    protected final int bjK() {
        return i$g.qGK;
    }

    public final View bwW() {
        View view = this.contentView;
        this.bgR = (SensorManager) this.context.getSystemService("sensor");
        this.bkA = this.bgR.getDefaultSensor(1);
        this.bkC = this.bgR.getDefaultSensor(2);
        this.rkB = (HorizontalScrollView) view.findViewById(f.qAc);
        this.fvf = (ImageView) view.findViewById(f.qAd);
        this.lAk = (ProgressBar) view.findViewById(f.cEd);
        this.lAk.setVisibility(8);
        return view;
    }

    protected final void bxa() {
        if (!e.bO(d.ei("adId", ((o) this.rji).rgz))) {
            this.rkF = false;
        }
        this.rkB.setLayoutParams(new LayoutParams(this.kDP, this.kDQ));
        this.fvf.setLayoutParams(new LayoutParams(this.kDP, this.kDQ));
        this.contentView.setLayoutParams(new LinearLayout.LayoutParams(this.kDP, this.kDQ));
        this.contentView.setPadding(this.contentView.getPaddingLeft(), (int) ((o) this.rji).rgM, this.contentView.getPaddingRight(), (int) ((o) this.rji).rgN);
        String str = ((o) this.rji).rgz;
        Bitmap ek = d.ek("adId", str);
        if (ek != null) {
            x.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  " + str);
            H(ek);
            return;
        }
        startLoading();
        d.a(str, ((o) this.rji).rgL, new 1(this));
    }

    public final void startLoading() {
        this.lAk.setVisibility(0);
    }

    public final void H(Bitmap bitmap) {
        if (bitmap == null) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
        } else if (this.fvf == null) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
        } else if (bitmap.getHeight() == 0) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
        } else {
            this.lAk.setVisibility(8);
            this.fvf.setImageBitmap(bitmap);
            this.fvf.setLayoutParams(new LayoutParams((bitmap.getWidth() * this.kDQ) / bitmap.getHeight(), this.kDQ));
            this.fvf.post(new 2(this));
            if (bitmap.getHeight() != 0) {
                this.contentView.setLayoutParams(new LinearLayout.LayoutParams((bitmap.getWidth() * this.kDQ) / bitmap.getHeight(), this.kDQ));
            }
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = -10.0f;
        if (sensorEvent.sensor.getType() == 1) {
            this.rkC = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.rkD = sensorEvent.values;
        }
        if (this.rkC != null && this.rkD != null) {
            float[] fArr = new float[9];
            if (SensorManager.getRotationMatrix(fArr, new float[9], this.rkC, this.rkD)) {
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(fArr, fArr2);
                float f2 = fArr2[2];
                if (this.rky != 0) {
                    if (f2 > 10.0f) {
                        f2 = 10.0f;
                    }
                    if (f2 >= -10.0f) {
                        f = f2;
                    }
                    this.rkB.scrollBy((int) ((f * ((float) this.rky)) / 10.0f), 0);
                }
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void bwH() {
        super.bwH();
        this.bgR.registerListener(this, this.bkA, 1);
        this.bgR.registerListener(this, this.bkC, 1);
    }

    public final void bwI() {
        super.bwI();
        this.bgR.unregisterListener(this);
    }

    public final boolean S(JSONObject jSONObject) {
        if (!super.S(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("swipeCount", this.rkE);
            if (!this.rkF) {
                String UZ = ab.UZ(((o) this.rji).rgz);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", UZ);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", e, "", new Object[0]);
            return false;
        }
    }
}
