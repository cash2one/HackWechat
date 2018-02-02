package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.ui.v;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.HashMap;
import junit.framework.Assert;

final class d extends BaseAdapter {
    private final Context context;
    protected int pfz = -1;
    private final int style;
    protected String value;
    protected final HashMap<CharSequence, c> values = new HashMap();
    protected CharSequence[] yhY;
    protected CharSequence[] yhZ;

    public d(Context context) {
        this.context = context;
        this.style = 1;
    }

    protected final void cql() {
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
            this.values.put(this.yhZ[i], new c(this.yhY[i], 1048576 + i));
            i++;
        }
    }

    public final int getCount() {
        return this.yhZ.length;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = v.fv(this.context).inflate(h.gXK, null);
            a aVar = new a();
            aVar.pfA = (TextView) view.findViewById(g.text);
            aVar.pfB = (CheckBox) view.findViewById(g.gVp);
            aVar.pfC = (RadioButton) view.findViewById(g.radio);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.pfA.setText(this.yhY[i]);
        switch (this.style) {
            case 1:
                aVar2.pfB.setVisibility(8);
                aVar2.pfC.setVisibility(0);
                aVar2.pfC.setChecked(this.yhZ[i].equals(this.value));
                break;
            case 2:
                aVar2.pfB.setVisibility(0);
                aVar2.pfC.setVisibility(8);
                aVar2.pfB.setChecked(this.yhZ[i].equals(this.value));
                break;
            default:
                aVar2.pfB.setVisibility(8);
                aVar2.pfC.setVisibility(8);
                break;
        }
        return view;
    }
}
