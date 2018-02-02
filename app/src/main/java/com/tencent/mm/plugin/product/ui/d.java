package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.f;
import java.util.List;

public final class d {

    static class a extends BaseAdapter {
        private final Context context;
        List<String> pfy;
        int pfz = -1;
        private final int style;

        public a(Context context) {
            this.context = context;
            this.style = 1;
        }

        public final int getCount() {
            return this.pfy != null ? this.pfy.size() : 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            if (view == null) {
                view = View.inflate(this.context, a$g.gXK, null);
                b bVar = new b();
                bVar.pfA = (TextView) view.findViewById(f.text);
                bVar.pfB = (CheckBox) view.findViewById(f.gVp);
                bVar.pfC = (RadioButton) view.findViewById(f.radio);
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            bVar2.pfA.setText((CharSequence) this.pfy.get(i));
            switch (this.style) {
                case 1:
                    bVar2.pfB.setVisibility(8);
                    bVar2.pfC.setVisibility(0);
                    bVar2.pfC.setChecked(i == this.pfz);
                    break;
                case 2:
                    bVar2.pfB.setVisibility(0);
                    bVar2.pfC.setVisibility(8);
                    CheckBox checkBox = bVar2.pfB;
                    if (i != this.pfz) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    break;
                default:
                    bVar2.pfB.setVisibility(8);
                    bVar2.pfC.setVisibility(8);
                    break;
            }
            return view;
        }
    }
}
