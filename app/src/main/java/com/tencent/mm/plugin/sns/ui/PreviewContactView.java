package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class PreviewContactView extends LinearLayout {
    private final Context context;
    private List<String> list = new ArrayList();
    private TableLayout rvR;
    private final Map<Integer, View> rvS = new HashMap();
    @SuppressLint({"UseSparseArrays"})
    private final Map<Integer, TableRow> rvT = new HashMap();
    private final int rvU = 5;

    public PreviewContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.rvR = (TableLayout) LayoutInflater.from(this.context).inflate(i$g.qHJ, this, true).findViewById(f.content);
    }

    public final void bV(List<String> list) {
        if (list != null) {
            this.list = list;
            this.rvR.removeAllViews();
            if (list.size() != 0) {
                boolean size = list.size();
                int i = 0;
                boolean z;
                for (boolean z2 = false; z2 < size; z2 = z) {
                    View view;
                    View view2 = (TableRow) this.rvT.get(Integer.valueOf(i));
                    if (view2 == null) {
                        view2 = new TableRow(this.context);
                        this.rvT.put(Integer.valueOf(i), view2);
                        view = view2;
                    } else {
                        view = view2;
                    }
                    view.removeAllViews();
                    int i2 = 0;
                    z = z2;
                    while (i2 < 5 && z < size) {
                        view2 = (View) this.rvS.get(Integer.valueOf(z));
                        if (view2 == null) {
                            view2 = View.inflate(this.context, i$g.qHI, null);
                            this.rvS.put(Integer.valueOf(z), view2);
                        }
                        View view3 = view2;
                        String str = (String) list.get(z);
                        ImageView imageView = (ImageView) view3.findViewById(f.qCB);
                        imageView.setBackgroundDrawable(null);
                        b.a(imageView, str);
                        view3.setTag(Integer.valueOf(0));
                        view3.setClickable(false);
                        view.addView(view3);
                        i2++;
                        z++;
                    }
                    this.rvR.addView(view);
                    i++;
                }
            }
        }
    }
}
