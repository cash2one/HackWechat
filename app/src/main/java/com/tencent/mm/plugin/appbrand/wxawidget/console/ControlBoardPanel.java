package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.sdk.platformtools.x;

public class ControlBoardPanel extends FrameLayout {
    ConsolePanel iUX;
    a khG;
    View khH;
    SettingsPanel khI;
    View khJ;
    View khK;
    View khL;
    View khM;
    WindowManager khN;
    LayoutParams khO;
    boolean khP;

    static /* synthetic */ void a(ControlBoardPanel controlBoardPanel) {
        controlBoardPanel.khO.width = -2;
        controlBoardPanel.khO.height = -2;
        controlBoardPanel.khO.flags = 520;
        controlBoardPanel.khN.updateViewLayout(controlBoardPanel, controlBoardPanel.khO);
    }

    static /* synthetic */ void b(ControlBoardPanel controlBoardPanel) {
        controlBoardPanel.khO.width = -1;
        controlBoardPanel.khO.height = -1;
        controlBoardPanel.khO.flags = 544;
        controlBoardPanel.khN.updateViewLayout(controlBoardPanel, controlBoardPanel.khO);
    }

    public ControlBoardPanel(Context context) {
        super(context);
        init();
    }

    public ControlBoardPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ControlBoardPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        Context context = getContext();
        this.khN = (WindowManager) context.getSystemService("window");
        LayoutInflater.from(context).inflate(c.khe, this, true);
        this.khH = findViewById(b.kgA);
        this.iUX = (ConsolePanel) findViewById(b.kgy);
        this.khI = (SettingsPanel) findViewById(b.khb);
        this.khJ = findViewById(b.kgW);
        this.khK = findViewById(b.kgw);
        this.khL = findViewById(b.kha);
        this.khM = findViewById(b.kgV);
        if (!((e) g.h(e.class)).IX().Ja()) {
            this.khM.setVisibility(8);
        }
        this.khK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlBoardPanel khQ;

            {
                this.khQ = r1;
            }

            public final void onClick(View view) {
                if (this.khQ.iUX.getVisibility() == 0) {
                    this.khQ.khH.setVisibility(8);
                    this.khQ.iUX.setVisibility(8);
                    this.khQ.khK.setSelected(false);
                    ControlBoardPanel.a(this.khQ);
                    return;
                }
                this.khQ.khH.setVisibility(0);
                this.khQ.iUX.setVisibility(0);
                this.khQ.khI.setVisibility(8);
                this.khQ.khJ.setVisibility(8);
                this.khQ.khK.setSelected(true);
                this.khQ.khL.setSelected(false);
                this.khQ.khM.setSelected(false);
                ControlBoardPanel.b(this.khQ);
            }
        });
        this.khL.setOnClickListener(new 2(this));
        this.khM.setOnClickListener(new 3(this));
        setOnKeyListener(new 4(this));
        this.khI.khU = new 5(this);
        this.khI.khV = new 6(this);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        x.i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", new Object[]{Integer.valueOf(i), keyEvent});
        return super.onKeyUp(i, keyEvent);
    }

    public final void reset() {
        d.b(this.iUX);
        d.a(this.iUX);
    }
}
