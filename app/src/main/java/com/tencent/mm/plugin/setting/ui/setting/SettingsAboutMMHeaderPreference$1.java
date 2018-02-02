package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bc.m;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;

class SettingsAboutMMHeaderPreference$1 implements OnClickListener {
    private long qhV = 0;
    final /* synthetic */ SettingsAboutMMHeaderPreference qhW;

    SettingsAboutMMHeaderPreference$1(SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference) {
        this.qhW = settingsAboutMMHeaderPreference;
    }

    public final void onClick(View view) {
        long Wp = bh.Wp();
        if (this.qhV > Wp || Wp - this.qhV > 300) {
            this.qhV = Wp;
            return;
        }
        this.qhV = Wp;
        Context context = this.qhW.mContext;
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{f.b(context, d.vAz, true), Integer.valueOf(d.vAz)}));
        stringBuilder.append(e.asP());
        stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(f.fdS)}));
        stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(g.zN(0))}));
        stringBuilder.append(String.format("[l.ver] %d\n", new Object[]{Integer.valueOf(g.zN(1))}));
        stringBuilder.append(String.format("[ws.ver] %d\n", new Object[]{Integer.valueOf(m.Ri())}));
        stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{"0x26060235"}));
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvv);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        h.a(context, null, textView, null);
    }
}
