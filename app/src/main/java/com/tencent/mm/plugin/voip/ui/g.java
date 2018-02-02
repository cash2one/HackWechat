package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import android.graphics.Point;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.a.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class g {
    private static final String ffq;
    private static final String ffr;
    public static final int oHW = a.fromDPToPix(ac.getContext(), 8);
    public static final int oIc = a.fromDPToPix(ac.getContext(), 96);
    public static final int oId = a.fromDPToPix(ac.getContext(), 76);
    public Intent intent;
    public h sss;
    private Point sst;
    private a ssu;
    private ak ssv;

    static {
        String yF = q.yF();
        ffq = yF;
        ffr = o.getString(yF.hashCode());
    }

    public final void a(Intent intent, a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
            return;
        }
        this.intent = intent;
        this.ssu = aVar;
        if (b.aM(ac.getContext())) {
            W(intent);
            return;
        }
        x.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
        VoipWarningDialog.a(ac.getContext(), new 1(this, aVar, intent));
    }

    private void W(Intent intent) {
        x.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
        if (this.sss != null) {
            dismiss();
        }
        if (this.sss == null) {
            this.sss = new h(ac.getContext());
        }
        if (this.ssv != null) {
            this.ssv.TG();
        }
        this.sss.setOnClickListener(new 2(this, intent));
        WindowManager windowManager = (WindowManager) ac.getContext().getSystemService("window");
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        layoutParams.width = oId;
        layoutParams.height = oIc;
        if (this.sst == null) {
            ar.Hg();
            int i = c.CU().getInt(327947, 0);
            int i2 = oHW;
            layoutParams.x = (a.eA(ac.getContext()) - layoutParams.width) - i2;
            layoutParams.y = i + i2;
        } else {
            layoutParams.x = this.sst.x;
            layoutParams.y = this.sst.y;
        }
        try {
            windowManager.addView(this.sss, layoutParams);
        } catch (Exception e) {
            x.e("MicroMsg.VoipVoiceMiniManager", "add failed", new Object[]{e});
        }
        this.ssu.a(intent, this.sss);
    }

    public final void wZ(int i) {
        if (this.sss != null) {
            this.sss.MF(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
        }
    }

    public final void ME(String str) {
        if (this.sss != null) {
            this.sss.ME(str);
        }
    }

    public final void dismiss() {
        x.i("MicroMsg.VoipVoiceMiniManager", "dismiss now..");
        WindowManager windowManager = (WindowManager) ac.getContext().getSystemService("window");
        try {
            if (this.sss != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.sss.getLayoutParams();
                this.sst = new Point(layoutParams.x, layoutParams.y);
                windowManager.removeView(this.sss);
                this.sss.setOnClickListener(null);
                this.sss = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.VoipVoiceMiniManager", "remove failed", new Object[]{e});
        }
    }
}
