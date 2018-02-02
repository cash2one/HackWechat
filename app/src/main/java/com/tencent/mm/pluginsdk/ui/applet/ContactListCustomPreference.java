package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference extends Preference {
    int background = -1;
    OnClickListener pGO;
    private View tyZ;
    private final OnTouchListener voi = new 1(this);

    public ContactListCustomPreference(Context context) {
        super(context);
        setLayoutResource(f.lnT);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(f.lnT);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(f.lnT);
    }

    public final void setCustomView(View view) {
        if (view != null) {
            this.tyZ = view;
        }
    }

    public final void onBindView(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        if (!(this.tyZ == null || this.tyZ == null)) {
            viewGroup.removeAllViews();
            if (this.tyZ.getParent() != null) {
                ((ViewGroup) this.tyZ.getParent()).removeAllViews();
            }
            viewGroup.addView(this.tyZ);
            if (this.pGO != null) {
                viewGroup.setOnClickListener(this.pGO);
            } else {
                viewGroup.setOnTouchListener(this.voi);
            }
        }
        if (this.background >= 0) {
            view.setBackgroundResource(this.background);
        }
    }
}
