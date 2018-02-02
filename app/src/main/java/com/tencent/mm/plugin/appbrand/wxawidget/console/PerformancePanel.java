package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn$a;

public class PerformancePanel extends FrameLayout {
    MMSwitchBtn iVe;
    MMSwitchBtn iVf;
    MMSwitchBtn iVg;

    private static class d implements h<IPCBoolean, IPCVoid> {
        private d() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            c.cs(((IPCBoolean) obj).value);
        }
    }

    public PerformancePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PerformancePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(b.c.kgW, this, true);
        TextView textView = (TextView) findViewById(b.b.kgR);
        View findViewById = findViewById(b.b.kgX);
        findViewById.setOnClickListener(new 1(this, textView));
        findViewById(b.b.bWg).setOnClickListener(new 2(this, textView));
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(b.b.kgT);
        boolean abq = c.abq();
        mMSwitchBtn.nB(abq);
        mMSwitchBtn.zvp = new 3(this, findViewById);
        findViewById.setEnabled(abq);
        this.iVe = (MMSwitchBtn) findViewById(b.b.kgt);
        this.iVe.setEnabled(abq);
        this.iVe.nB(c.qr("jsapi_draw_canvas"));
        this.iVe.zvp = new MMSwitchBtn$a(this) {
            final /* synthetic */ PerformancePanel khR;

            {
                this.khR = r1;
            }

            public final void cw(boolean z) {
                f.a("com.tencent.mm:support", new IPCBoolean(z), b.class, null);
                if (z) {
                    c.qp("jsapi_draw_canvas");
                } else {
                    c.qq("jsapi_draw_canvas");
                }
            }
        };
        this.iVf = (MMSwitchBtn) findViewById(b.b.kgv);
        this.iVf.setEnabled(abq);
        this.iVf.nB(c.qr("widget_launch"));
        this.iVf.zvp = new 5(this);
        this.iVg = (MMSwitchBtn) findViewById(b.b.kgu);
        this.iVg.setEnabled(abq);
        this.iVg.nB(com.tencent.mm.plugin.appbrand.collector.f.abr());
        this.iVg.zvp = new 6(this);
    }
}
