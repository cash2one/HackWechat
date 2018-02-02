package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.e;

public enum af$a {
    ;

    public static void a(Activity activity, View view) {
        if (anj() && activity.getResources().getConfiguration().orientation != 2) {
            activity.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            activity.getWindow().addFlags(2048);
            view.setPadding(0, e.eb(activity), 0, 0);
        }
    }

    private static boolean anj() {
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            if (Build.DEVICE.equals("mx2")) {
                return true;
            }
            if (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) {
                return false;
            }
            return false;
        }
    }
}
