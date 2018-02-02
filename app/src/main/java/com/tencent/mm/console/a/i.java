package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class i implements a {
    static {
        b.a(new i(), new String[]{"//version"});
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        int i;
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{f.b(context, d.vAz, true), Integer.valueOf(d.vAz)}));
        stringBuilder.append(e.asP());
        stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(f.fdS)}));
        stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(g.zN(0))}));
        stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{"0x26060235"}));
        try {
            Map y = bi.y(bh.convertStreamToString(context.getAssets().open("merged_features.xml")), "merged");
            if (y != null) {
                for (i = 0; ((String) y.get("merged.feature#" + i)) != null; i++) {
                    stringBuilder.append(String.format("[feature#%02d] %s\n", new Object[]{Integer.valueOf(i), (String) y.get("merged.feature#" + i)}));
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Version", e, "", new Object[0]);
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        i = context.getResources().getDimensionPixelSize(R.f.bvv);
        textView.setPadding(i, i, i, i);
        h.a(context, null, textView, null);
        return true;
    }
}
