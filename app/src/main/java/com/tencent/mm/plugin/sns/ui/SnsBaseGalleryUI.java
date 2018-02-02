package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;

public abstract class SnsBaseGalleryUI extends MMActivity implements a {
    private boolean kBz = true;
    private LinearLayout ryS;
    s ryT;
    private LinearLayout ryU;
    t ryV;
    private boolean ryW = true;
    private TextView ryX = null;
    protected SnsInfoFlip ryY;
    protected Button ryZ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ae.bvq().I(3, true);
        this.ryS = (LinearLayout) findViewById(f.qCD);
        this.ryU = (LinearLayout) findViewById(f.content);
        this.ryV = new t(this, this);
        t tVar = this.ryV;
        x.i("MicroMsg.GalleryTitleManager", "onAttach");
        g.Dk();
        g.Di().gPJ.a(218, tVar);
        com.tencent.mm.sdk.b.a.xef.b(tVar.msq);
        com.tencent.mm.sdk.b.a.xef.b(tVar.rsI);
    }

    public void onResume() {
        super.onResume();
        if (this.ryT != null) {
            this.ryT.refresh();
        }
    }

    public final void addView(View view) {
        this.ryS.addView(view, new LayoutParams(-1, -1));
    }

    @SuppressLint({"ResourceAsColor"})
    public final void u(boolean z, int i) {
        this.ryT = new s(this, i, z);
        this.ryT.setBackgroundColor(c.transparent);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.ryT.getBackground().setAlpha(50);
        this.ryU.addView(this.ryT, layoutParams);
        this.ryT.fug = getIntent().getIntExtra("sns_source", 0);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.ryV != null) {
            t tVar = this.ryV;
            x.i("MicroMsg.GalleryTitleManager", "onDetch");
            g.Dk();
            g.Di().gPJ.b(218, tVar);
            com.tencent.mm.sdk.b.a.xef.c(tVar.msq);
            com.tencent.mm.sdk.b.a.xef.c(tVar.rsI);
        }
        if (this.ryY != null) {
            SnsInfoFlip snsInfoFlip = this.ryY;
            if (snsInfoFlip.rBU != null && (snsInfoFlip.rBU instanceof MMGestureGallery)) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) snsInfoFlip.rBU;
                mMGestureGallery.zlc.release();
                mMGestureGallery.zld.release();
                mMGestureGallery.zlb.release();
            }
            this.ryY.onDestroy();
        }
    }

    protected int getLayoutId() {
        return i.g.qHo;
    }

    public void ci(String str, int i) {
        if (this.ryW && !ae.bve()) {
            m Lm = ae.bvv().Lm(str);
            if (Lm == null || Lm.field_snsId == 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        }
    }

    protected void onPause() {
        if (this.ryY != null) {
            this.ryY.onPause();
        }
        if (this.ryV != null) {
            t tVar = this.ryV;
            if (tVar.rsF != null) {
                b ajVar = new aj();
                ajVar.fou.activity = (Activity) tVar.context;
                ajVar.fou.fov = tVar.rsF;
                com.tencent.mm.sdk.b.a.xef.m(ajVar);
                tVar.rsF = null;
                tVar.fqc = 0;
                tVar.fqb = 0;
            }
        }
        super.onPause();
    }

    public final void ep(String str, String str2) {
        if (this.ryW) {
            setMMTitle(str);
            setMMSubTitle(str2);
        }
    }

    public void ch(String str, int i) {
    }

    public void arJ() {
        int i = 8;
        boolean z = false;
        if (this.ryW) {
            int i2;
            if (this.kBz) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            setTitleVisibility(i2);
            if (this.ryT != null) {
                s sVar = this.ryT;
                if (!this.kBz) {
                    i = 0;
                }
                sVar.setVisibility(i);
            }
            if (!this.kBz) {
                z = true;
            }
            this.kBz = z;
        }
    }

    public final void bzq() {
        this.kBz = false;
        setTitleVisibility(8);
        if (this.ryT != null) {
            this.ryT.setVisibility(8);
        }
    }
}
