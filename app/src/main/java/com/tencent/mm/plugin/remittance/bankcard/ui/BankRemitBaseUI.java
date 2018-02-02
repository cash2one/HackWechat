package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.reflect.Field;

public abstract class BankRemitBaseUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ayW();
        setBackBtn(new 1(this), h.dvO);
    }

    protected void ayW() {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.uaF)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(a$f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(c.black));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(c.black));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(c.uaF));
        }
        x.i("BankRemitBase", "ret: %s", Integer.valueOf(H(this)));
        this.mController.contentView.setFitsSystemWindows(true);
    }

    public static int H(Activity activity) {
        if (VERSION.SDK_INT < 19) {
            return 0;
        }
        if (VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(8192);
            return 3;
        } else if (I(activity)) {
            return 1;
        } else {
            if (e(activity.getWindow())) {
                return 2;
            }
            return 0;
        }
    }

    private static boolean e(Window window) {
        if (window != null) {
            try {
                LayoutParams attributes = window.getAttributes();
                Field declaredField = LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField2.setInt(attributes, declaredField.getInt(null) | declaredField2.getInt(attributes));
                window.setAttributes(attributes);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static boolean I(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return false;
        }
        Class cls = window.getClass();
        try {
            Class cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(window, new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
            try {
                if (VERSION.SDK_INT < 23) {
                    return true;
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(8192);
                return true;
            } catch (Exception e) {
                return true;
            }
        } catch (Exception e2) {
            return false;
        }
    }
}
