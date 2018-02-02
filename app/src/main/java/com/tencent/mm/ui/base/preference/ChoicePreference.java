package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference extends Preference {
    private int pfz;
    String value;
    private final HashMap<CharSequence, b> values;
    private RadioGroup yhX;
    private CharSequence[] yhY;
    private CharSequence[] yhZ;
    public a yia;

    public ChoicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChoicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.values = new HashMap();
        this.pfz = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.eZz, i, 0);
        this.yhY = obtainStyledAttributes.getTextArray(m.gYV);
        this.yhZ = obtainStyledAttributes.getTextArray(m.gYW);
        obtainStyledAttributes.recycle();
        cql();
    }

    public final void a(a aVar) {
        this.yia = aVar;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(h.gXF, viewGroup2);
        this.yhX = (RadioGroup) onCreateView.findViewById(g.atY);
        for (int i = 0; i < this.yhZ.length; i++) {
            b bVar = (b) this.values.get(this.yhZ[i]);
            if (bVar != null) {
                RadioButton radioButton;
                if (i == 0) {
                    radioButton = (RadioButton) layoutInflater.inflate(h.gXr, null);
                    bVar.a(radioButton);
                    this.yhX.addView(radioButton);
                } else if (i == this.yhZ.length - 1) {
                    radioButton = (RadioButton) layoutInflater.inflate(h.gXt, null);
                    bVar.a(radioButton);
                    this.yhX.addView(radioButton);
                } else {
                    radioButton = (RadioButton) layoutInflater.inflate(h.gXs, null);
                    bVar.a(radioButton);
                    this.yhX.addView(radioButton);
                }
            }
        }
        this.yhX.setOnCheckedChangeListener(new 1(this));
        return onCreateView;
    }

    private void cql() {
        boolean z;
        int i = 0;
        if (this.yhY == null) {
            this.yhY = new CharSequence[0];
        }
        if (this.yhZ == null) {
            this.yhZ = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.yhY.length == this.yhZ.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.values.clear();
        while (i < this.yhZ.length) {
            this.values.put(this.yhZ[i], new b(this.yhY[i], 1048576 + i));
            i++;
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.yhX != null) {
            this.yhX.check(this.pfz);
        }
    }

    public final void setValue(String str) {
        this.value = str;
        b bVar = (b) this.values.get(str);
        if (bVar == null) {
            this.pfz = -1;
        } else {
            this.pfz = bVar.id;
        }
    }
}
