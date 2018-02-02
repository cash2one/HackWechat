package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.ui.widget.picker.c;
import java.util.Locale;

public final class AppBrandTimePicker extends TimePicker implements e<String> {
    public int jpJ = -1;
    public int jpK = -1;
    public int jpL = -1;
    public int jpM = -1;
    public NumberPicker kdu;
    private NumberPicker kdv;

    public final /* synthetic */ Object anJ() {
        return String.format(Locale.US, "%02d:%02d", new Object[]{getCurrentHour(), getCurrentMinute()});
    }

    @Keep
    public AppBrandTimePicker(Context context) {
        super(new ContextThemeWrapper(context, k.iCc));
        setIs24HourView(Boolean.valueOf(true));
        this.kdu = vc("mHourSpinner");
        this.kdv = vc("mMinuteSpinner");
        c.c(this.kdu);
        c.c(this.kdv);
        f.a(this.kdu);
        f.a(this.kdv);
        Drawable drawable = getResources().getDrawable(f.iti);
        c.a(this.kdu, drawable);
        c.a(this.kdv, drawable);
        if (this.kdu != null) {
            this.kdu.setOnValueChangedListener(new 1(this));
        }
        if (this.kdv != null && VERSION.SDK_INT >= 21) {
            this.kdv.setOnValueChangedListener(new 2(this));
        }
        c.e(this.kdu);
        c.e(this.kdv);
    }

    public final void anN() {
        if (g.mo(this.jpJ) && g.mn(this.jpK) && this.kdu != null && this.kdv != null) {
            if (this.kdu.getValue() == this.jpJ) {
                this.kdv.setMinValue(this.jpK);
            } else {
                this.kdv.setMinValue(0);
            }
        }
        if (g.mo(this.jpL) && this.kdu != null && this.kdv != null) {
            if (this.kdu.getValue() == this.jpL) {
                this.kdv.setMaxValue(this.jpM);
            } else {
                this.kdv.setMaxValue(59);
            }
        }
    }

    public final void setCurrentMinute(Integer num) {
        super.setCurrentMinute(Integer.valueOf(num == null ? 0 : num.intValue()));
        anN();
    }

    public final void setCurrentHour(Integer num) {
        super.setCurrentHour(Integer.valueOf(num == null ? 0 : num.intValue()));
        anN();
    }

    private NumberPicker vc(String str) {
        if (VERSION.SDK_INT >= 21) {
            return ve(str);
        }
        return vd(str);
    }

    private NumberPicker vd(String str) {
        try {
            return (NumberPicker) new com.tencent.mm.compatible.loader.c(this, str, null).get();
        } catch (Exception e) {
            return null;
        }
    }

    private NumberPicker ve(String str) {
        try {
            Object obj = new com.tencent.mm.compatible.loader.c(this, "mDelegate", null).get();
            if (obj != null) {
                return (NumberPicker) new com.tencent.mm.compatible.loader.c(obj, str, null).get();
            }
        } catch (Exception e) {
        }
        return null;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.d(this.kdu);
        c.d(this.kdv);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void anH() {
    }

    public final void b(d dVar) {
    }

    public final void anI() {
    }
}
