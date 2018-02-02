package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.pluginsdk.q.aa;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class k implements a {
    static {
        b.a(new k(), new String[]{"//wear"});
    }

    public static void init() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr) {
        boolean z = false;
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        switch (str.hashCode()) {
            case 107332:
                if (str.equals("log")) {
                    break;
                }
            case 351608024:
                if (str.equals("version")) {
                    z = true;
                    break;
                }
            case 990157655:
                if (str.equals("reconnect")) {
                    z = true;
                    break;
                }
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                aa.vcE.bOw();
                break;
            case true:
                View textView = new TextView(context);
                textView.setText(aa.vcE.bOv());
                textView.setGravity(19);
                textView.setTextSize(1, 10.0f);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setTextColor(-16711936);
                textView.setTypeface(Typeface.MONOSPACE);
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvv);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                h.a(context, null, textView, null);
                break;
        }
        return true;
    }
}
