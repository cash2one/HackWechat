package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.p.b;

public class SetTextSizeUI extends MMPreference {
    private f ilB;
    private float qhL;
    private int qhM = 1;

    public final int XB() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.qhL = dt(this);
        this.ilB = this.yjd;
        setMMTitle(R.l.eNs);
        setBackBtn(new 1(this));
        a(0, getString(R.l.eLA), new 2(this), b.xJz);
        refresh();
    }

    public static float dt(Context context) {
        float eu = a.eu(context);
        if (eu == 1.0f || eu == 0.875f || eu == 1.125f || eu == 1.25f || eu == 1.375f || eu == 1.625f || eu == 1.875f || eu == 2.025f) {
            return eu;
        }
        return 1.0f;
    }

    public static int du(Context context) {
        float dt = dt(context);
        if (dt == 0.875f) {
            return R.l.eKq;
        }
        if (dt == 1.125f) {
            return R.l.eKo;
        }
        if (dt == 1.25f) {
            return R.l.eKr;
        }
        if (dt == 1.375f) {
            return R.l.eKn;
        }
        return R.l.eKp;
    }

    public static float ao(float f) {
        if (f == 0.875f) {
            return 14.0f;
        }
        if (f == 1.0f) {
            return 16.0f;
        }
        if (f == 1.125f) {
            return 18.0f;
        }
        if (f == 1.25f) {
            return 20.0f;
        }
        if (f == 1.375f) {
            return 22.0f;
        }
        if (f == 1.625f) {
            return 26.0f;
        }
        if (f == 1.875f) {
            return 28.0f;
        }
        if (f == 2.025f) {
            return 30.0f;
        }
        return 16.0f;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        this.qhM = 1;
        if (str.equals("setting_text_size_small")) {
            this.qhL = 0.875f;
            this.qhM = 0;
        } else if (str.equals("setting_text_size_normal")) {
            this.qhL = 1.0f;
            this.qhM = 1;
        } else if (str.equals("setting_text_size_large")) {
            this.qhL = 1.125f;
            this.qhM = 2;
        } else if (str.equals("setting_text_size_super")) {
            this.qhL = 1.25f;
            this.qhM = 3;
        } else if (str.equals("setting_text_size_huge")) {
            this.qhL = 1.375f;
            this.qhM = 4;
        } else if (str.equals("setting_text_size_huger")) {
            this.qhL = 1.625f;
            this.qhM = 5;
        } else if (str.equals("setting_text_size_hugers")) {
            this.qhL = 1.625f;
            this.qhM = 6;
        } else if (str.equals("setting_text_size_hugerss")) {
            this.qhL = 1.625f;
            this.qhM = 7;
        }
        refresh();
        return false;
    }

    private void refresh() {
        this.ilB.removeAll();
        Preference aVar = new a(this, this, 0.875f);
        aVar.setKey("setting_text_size_small");
        aVar.setLayoutResource(R.i.dnt);
        if (this.qhL == 0.875f) {
            aVar.setWidgetLayoutResource(R.i.dnZ);
        } else {
            aVar.setWidgetLayoutResource(R.i.doa);
        }
        this.ilB.a(aVar);
        aVar = new a(this, this, 1.0f);
        aVar.setKey("setting_text_size_normal");
        aVar.setLayoutResource(R.i.dnt);
        if (this.qhL == 1.0f) {
            aVar.setWidgetLayoutResource(R.i.dnZ);
        } else {
            aVar.setWidgetLayoutResource(R.i.doa);
        }
        this.ilB.a(aVar);
        aVar = new a(this, this, 1.125f);
        aVar.setKey("setting_text_size_large");
        aVar.setLayoutResource(R.i.dnt);
        if (this.qhL == 1.125f) {
            aVar.setWidgetLayoutResource(R.i.dnZ);
        } else {
            aVar.setWidgetLayoutResource(R.i.doa);
        }
        this.ilB.a(aVar);
        aVar = new a(this, this, 1.25f);
        aVar.setKey("setting_text_size_super");
        aVar.setLayoutResource(R.i.dnt);
        if (this.qhL == 1.25f) {
            aVar.setWidgetLayoutResource(R.i.dnZ);
        } else {
            aVar.setWidgetLayoutResource(R.i.doa);
        }
        this.ilB.a(aVar);
        aVar = new a(this, this, 1.375f);
        aVar.setKey("setting_text_size_huge");
        aVar.setLayoutResource(R.i.dnt);
        if (this.qhL == 1.375f) {
            aVar.setWidgetLayoutResource(R.i.dnZ);
        } else {
            aVar.setWidgetLayoutResource(R.i.doa);
        }
        this.ilB.a(aVar);
        this.ilB.a(new PreferenceCategory(this));
        this.ilB.notifyDataSetChanged();
        ViewGroup viewGroup = (ViewGroup) this.mController.xIy;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                x.d("ui.settings.SetTextSize", "id=" + childAt.getId());
            }
        }
    }
}
