package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;

public final class DialogPreference extends Preference {
    private i pyk;
    public a yia;
    private final d yic;
    a yid;

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yic = new d(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.eZz, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(m.gYV, -1);
        if (resourceId != -1) {
            this.yic.yhY = context.getResources().getStringArray(resourceId);
        }
        this.yic.yhZ = obtainStyledAttributes.getTextArray(m.gYW);
        obtainStyledAttributes.recycle();
        this.yic.cql();
    }

    public final void a(a aVar) {
        this.yia = aVar;
    }

    public final String getValue() {
        return this.yic.value;
    }

    public final void setValue(String str) {
        this.yic.value = str;
        c cVar = (c) this.yic.values.get(str);
        if (cVar == null) {
            this.yic.pfz = -1;
            return;
        }
        this.yic.pfz = cVar.id;
    }

    public final void onBindView(View view) {
        c cVar = (c) this.yic.values.get(this.yic.value);
        if (cVar != null) {
            setSummary(cVar.text);
        }
        super.onBindView(view);
    }

    protected final void showDialog() {
        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this.mContext, h.gXz, null);
        listViewInScrollView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ DialogPreference yie;

            {
                this.yie = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.yie.pyk != null) {
                    this.yie.pyk.dismiss();
                }
                this.yie.setValue((String) this.yie.yic.yhZ[i]);
                if (this.yie.yid != null) {
                    this.yie.yid.cqm();
                }
                if (this.yie.yia != null) {
                    this.yie.yia.a(this.yie, this.yie.getValue());
                }
            }
        });
        listViewInScrollView.setAdapter(this.yic);
        i.a aVar = new i.a(this.mContext);
        aVar.YF(getTitle().toString());
        aVar.dk(listViewInScrollView);
        this.pyk = aVar.akx();
        this.pyk.show();
        com.tencent.mm.ui.base.h.a(this.mContext, this.pyk);
    }
}
