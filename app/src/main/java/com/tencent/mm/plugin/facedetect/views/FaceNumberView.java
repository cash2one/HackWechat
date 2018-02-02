package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Timer;

public class FaceNumberView extends LinearLayout {
    private String mmZ;
    private int mna;
    public ViewGroup mnb;
    public FaceNumberItemView[] mnc;
    public int mnd;
    private Animation mne;
    private int mnf;

    public FaceNumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public FaceNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mmZ = null;
        this.mnc = null;
        this.mnd = 0;
        this.mne = null;
        this.mnf = a.mnh;
        this.mnb = (ViewGroup) inflate(getContext(), g.mdG, null);
        addView(this.mnb);
        this.mne = AnimationUtils.loadAnimation(getContext(), a.bqk);
    }

    private static void a(FaceNumberItemView faceNumberItemView, String str) {
        if (faceNumberItemView != null) {
            if (str.equals("0")) {
                faceNumberItemView.setImageResource(d.mcE);
            } else if (str.equals("1")) {
                faceNumberItemView.setImageResource(d.mcF);
            } else if (str.equals("2")) {
                faceNumberItemView.setImageResource(d.mcG);
            } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                faceNumberItemView.setImageResource(d.mcH);
            } else if (str.equals("4")) {
                faceNumberItemView.setImageResource(d.mcI);
            } else if (str.equals("5")) {
                faceNumberItemView.setImageResource(d.mcJ);
            } else if (str.equals("6")) {
                faceNumberItemView.setImageResource(d.mcK);
            } else if (str.equals("7")) {
                faceNumberItemView.setImageResource(d.mcL);
            } else if (str.equals("8")) {
                faceNumberItemView.setImageResource(d.mcM);
            } else if (str.equals("9")) {
                faceNumberItemView.setImageResource(d.mcN);
            } else {
                faceNumberItemView.setImageResource(d.mcO);
            }
        }
    }

    public final void zP(String str) {
        int i = 0;
        this.mmZ = str;
        if (this.mmZ != null) {
            this.mna = this.mmZ.length();
        } else {
            this.mna = 0;
        }
        if (this.mnc != null && this.mnc.length > 0) {
            if (bh.ov(this.mmZ)) {
                while (i < this.mnc.length) {
                    a(this.mnc[i], "point");
                    i++;
                }
                return;
            }
            for (int i2 = 0; i2 < this.mnc.length; i2++) {
                String str2;
                if (this.mna > i2) {
                    String str3 = this.mmZ.charAt(i2);
                    FaceNumberItemView faceNumberItemView;
                    if (this.mna == i2 + 1) {
                        faceNumberItemView = this.mnc[i2];
                        if (faceNumberItemView.mmO != null) {
                            faceNumberItemView.aHG();
                        }
                        faceNumberItemView.mmO = new Timer("FaceNumberItemView_karaoke", true);
                        faceNumberItemView.mmO.scheduleAtFixedRate(new FaceNumberItemView.a(faceNumberItemView, faceNumberItemView.mmW, (byte) 0), 0, FaceNumberItemView.mmP);
                        str2 = str3;
                    } else {
                        this.mnc[i2].aHG();
                        faceNumberItemView = this.mnc[i2];
                        faceNumberItemView.mmV = 30;
                        faceNumberItemView.invalidate();
                        str2 = str3;
                    }
                } else {
                    str2 = "";
                }
                a(this.mnc[i2], str2);
            }
        }
    }
}
