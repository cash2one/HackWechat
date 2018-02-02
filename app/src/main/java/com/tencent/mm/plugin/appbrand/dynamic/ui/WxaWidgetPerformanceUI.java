package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.wxawidget.b$c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetPerformanceUI extends MMActivity {
    MMSwitchBtn iVe;
    MMSwitchBtn iVf;
    MMSwitchBtn iVg;

    private static class a implements h<IPCVoid, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            com.tencent.mm.plugin.appbrand.collector.c.clear();
        }
    }

    private static class b implements h<IPCBoolean, IPCVoid> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.collector.c.qp("jsapi_draw_canvas");
            } else {
                com.tencent.mm.plugin.appbrand.collector.c.qq("jsapi_draw_canvas");
            }
        }
    }

    private static class c implements h<IPCBoolean, IPCVoid> {
        private c() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.collector.c.qp("widget_launch");
            } else {
                com.tencent.mm.plugin.appbrand.collector.c.qq("widget_launch");
            }
        }
    }

    private static class d implements h<IPCBoolean, IPCVoid> {
        private d() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            com.tencent.mm.plugin.appbrand.collector.c.cs(((IPCBoolean) obj).value);
        }
    }

    private static class e implements j<IPCString, IPCString> {
        private e() {
        }

        public final /* synthetic */ Object at(Object obj) {
            return new IPCString(com.tencent.mm.plugin.appbrand.collector.c.qo(((IPCString) obj).value).toString());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(com.tencent.mm.plugin.appbrand.wxawidget.b.e.khm);
        TextView textView = (TextView) findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kgR);
        View findViewById = findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kgX);
        findViewById.setOnClickListener(new 2(this, textView));
        findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.bWg).setOnClickListener(new 3(this, textView));
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kgT);
        boolean abq = com.tencent.mm.plugin.appbrand.collector.c.abq();
        mMSwitchBtn.nB(abq);
        mMSwitchBtn.zvp = new 4(this, findViewById);
        findViewById.setEnabled(abq);
        this.iVe = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kgt);
        this.iVe.setEnabled(abq);
        this.iVe.nB(com.tencent.mm.plugin.appbrand.collector.c.qr("jsapi_draw_canvas"));
        this.iVe.zvp = new 5(this);
        this.iVf = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kgv);
        this.iVf.setEnabled(abq);
        this.iVf.nB(com.tencent.mm.plugin.appbrand.collector.c.qr("widget_launch"));
        this.iVf.zvp = new com.tencent.mm.ui.widget.MMSwitchBtn.a(this) {
            final /* synthetic */ WxaWidgetPerformanceUI iVh;

            {
                this.iVh = r1;
            }

            public final void cw(boolean z) {
                f.a("com.tencent.mm:support", new IPCBoolean(z), c.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.qp("widget_launch");
                } else {
                    com.tencent.mm.plugin.appbrand.collector.c.qq("widget_launch");
                }
            }
        };
        this.iVg = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kgu);
        this.iVg.setEnabled(abq);
        this.iVg.nB(com.tencent.mm.plugin.appbrand.collector.f.abr());
        this.iVg.zvp = new 7(this);
    }

    public void finish() {
        if (!isFinishing() && !this.xIq) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            overridePendingTransition(resourceId, resourceId2);
        }
    }

    protected final int getLayoutId() {
        return b$c.khh;
    }
}
