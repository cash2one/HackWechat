package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.view.ViewPager;
import android.support.v4.view.u;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.mm.plugin.facedetect.a$a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;

public final class b {
    View ltB;
    Button miR;
    Animation miV;
    u mkG;
    a mkH;
    ViewPager xS;

    public b() {
        this.ltB = null;
        this.miV = null;
        this.miV = AnimationUtils.loadAnimation(ac.getContext(), a$a.bpP);
        this.miV.setDuration(500);
    }

    public final void dismiss() {
        if (this.ltB.getVisibility() == 0) {
            ag.y(new 3(this));
        }
    }
}
