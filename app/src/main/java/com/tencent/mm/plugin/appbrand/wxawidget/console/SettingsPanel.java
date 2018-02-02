package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class SettingsPanel extends FrameLayout {
    private Button khS;
    private Button khT;
    OnClickListener khU;
    Runnable khV;

    public SettingsPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SettingsPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(c.khb, this, true);
        findViewById(b.kgY).setOnClickListener(new 1(this));
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(b.kgE);
        mMSwitchBtn.nB(((e) g.h(e.class)).IX().IZ());
        mMSwitchBtn.zvp = new 2(this);
        this.khS = (Button) findViewById(b.kgC);
        mw(com.tencent.mm.plugin.appbrand.dynamic.widget.c.adm());
        this.khS.setOnClickListener(new 3(this));
        this.khT = (Button) findViewById(b.kgI);
        mx(com.tencent.mm.v.g.Cf());
        this.khT.setOnClickListener(new 4(this));
        findViewById(b.kgs).setOnClickListener(new 5(this));
        if (((e) g.h(e.class)).IX().Ja()) {
            findViewById(b.kgF).setVisibility(0);
            findViewById(b.kgD).setVisibility(0);
            findViewById(b.kgJ).setVisibility(0);
        }
    }

    private void mw(int i) {
        this.khS.setTag(Integer.valueOf(i));
        switch (i) {
            case 1:
                this.khS.setText("MTextureView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.kb(1);
                return;
            case 2:
                this.khS.setText("MSurfaceView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.kb(2);
                return;
            case 3:
                this.khS.setText("MCanvasView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.kb(3);
                return;
            case 4:
                this.khS.setText("MDrawableView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.kb(4);
                return;
            default:
                this.khS.setText("MHADrawableView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.kb(0);
                return;
        }
    }

    private void mx(int i) {
        CharSequence charSequence;
        int i2;
        this.khT.setTag(Integer.valueOf(i));
        switch (i) {
            case 1:
                charSequence = "Minimal-json";
                i2 = 1;
                break;
            default:
                charSequence = "Normal";
                i2 = 0;
                break;
        }
        this.khT.setText(charSequence);
        com.tencent.mm.v.g.gy(i2);
        f.a("com.tencent.mm:support", new IPCInteger(i2), a.class, null);
    }
}
