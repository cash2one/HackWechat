package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a$a;
import com.tencent.mm.plugin.facedetect.a$e;
import com.tencent.mm.plugin.facedetect.a$g;
import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;

public final class c implements b {
    private static String TAG = "MicroMsg.NormalFaceMotion";
    private static long mhw = 500;
    private View mhA = null;
    private String mhB;
    private long mhC;
    private final Object mhD = new Object();
    private Timer mhE = null;
    private volatile boolean mhF = false;
    private Animation mhG;
    private volatile boolean mhH = false;
    private volatile boolean mhI = false;
    private boolean mhx = false;
    private boolean mhy = false;
    private View mhz = null;

    public c(String str, long j) {
        this.mhB = str;
        this.mhC = j;
        this.mhG = AnimationUtils.loadAnimation(ac.getContext(), a$a.bqB);
    }

    public final boolean aGU() {
        return this.mhx && this.mhy;
    }

    public final TextView aGZ() {
        if (!this.mhx && this.mhz != null) {
            return (TextView) this.mhz.findViewById(a$e.mdu);
        }
        if (!this.mhx || this.mhA == null) {
            return null;
        }
        return (TextView) this.mhA.findViewById(a$e.mdu);
    }

    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.mhz = LayoutInflater.from(context).inflate(a$g.mdD, viewGroup);
        this.mhA = LayoutInflater.from(context).inflate(a$g.mdE, viewGroup2);
        this.mhA.setVisibility(4);
        if (aGZ() != null) {
            aGZ().setText(this.mhB);
        }
        x.i(TAG, "hy: starting tween timer: tween: %d", Long.valueOf(this.mhC));
        if (this.mhE != null) {
            this.mhE.cancel();
        }
        this.mhE = new Timer("FaceDetect_hint", true);
        this.mhF = true;
        this.mhE.scheduleAtFixedRate(new 2(this), 0, r4);
    }

    public final boolean aGV() {
        return false;
    }

    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        if (!this.mhx || faceCharacteristicsResult == null || faceCharacteristicsResult.errCode != 18) {
            return false;
        }
        x.d(TAG, "hy: ignore too active");
        return true;
    }

    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        if (faceCharacteristicsResult.errCode == -1) {
            this.mhx = true;
            if (!this.mhH) {
                ar.H(ac.getContext(), a$h.eBs);
                TextView textView = (TextView) this.mhz.findViewById(a$e.mdu);
                Animation loadAnimation = AnimationUtils.loadAnimation(ac.getContext(), a$a.bpY);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(ac.getContext(), a$a.bpZ);
                loadAnimation.setDuration(mhw);
                loadAnimation2.setDuration(mhw);
                textView.startAnimation(loadAnimation);
                textView.setVisibility(4);
                this.mhA.setVisibility(0);
                this.mhA.startAnimation(loadAnimation2);
                this.mhA.findViewById(a$e.mda).setOnClickListener(new 1(this));
                this.mhH = true;
                return true;
            }
        }
        return false;
    }

    public final void aGW() {
        this.mhF = false;
        if (this.mhE != null) {
            this.mhE.cancel();
        }
        this.mhx = false;
        this.mhH = false;
        this.mhI = false;
        this.mhy = false;
    }

    public final b aGX() {
        if (this.mhx) {
            return new b(90025, "user cancelled in intermediate page");
        }
        return new b(90004, "user cancelled in processing");
    }

    public final a aGY() {
        if (!this.mhx || this.mhI) {
            return null;
        }
        this.mhI = true;
        return new a();
    }
}
