package com.tencent.mm.plugin.ipcall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class i extends AlertDialog implements e {
    private TextView FN;
    private View kND;
    private MMDotView kba;
    private Context mContext;
    private b nNc;
    private IPCallShareViewPager nNd;
    private OnClickListener nNe;
    private LinkedList<Integer> nNf;
    private CharSequence uU;

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        setContentView(this.kND);
    }

    public final void ae(int i) {
        if (this.nNc.getCount() <= 1) {
            this.kba.setVisibility(4);
            return;
        }
        this.kba.setVisibility(0);
        this.kba.EH(this.nNc.getCount());
        this.kba.EI(i);
    }

    public final void af(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.uU = charSequence;
        } else {
            this.uU = null;
        }
    }

    public final void show() {
        if (this.nNf != null && this.nNf.size() != 0) {
            this.nNd.b(this);
            b bVar = new b(this);
            bVar.nNg = this.nNe;
            bVar.nNl = this.nNf;
            if (bVar.nNl.size() > 0) {
                bVar.mCount = ((bVar.nNl.size() - 1) / 9) + 1;
            } else {
                bVar.mCount = 0;
            }
            int i = 0;
            while (i < bVar.mCount) {
                View inflate = ((LayoutInflater) bVar.nNn.mContext.getSystemService("layout_inflater")).inflate(R.i.dmt, null);
                GridView gridView = (GridView) inflate.findViewById(R.h.crn);
                List arrayList = new ArrayList();
                int i2 = i * 9;
                while (i2 < bVar.nNl.size() && i2 < (i * 9) + 9) {
                    arrayList.add(bVar.nNl.get(i2));
                    i2++;
                }
                ListAdapter aVar = new a(bVar.nNn.getContext());
                aVar.nNg = bVar.nNg;
                aVar.not = arrayList;
                gridView.setAdapter(aVar);
                bVar.nNm.add(inflate);
                i++;
            }
            this.nNc = bVar;
            this.nNd.a(this.nNc);
            this.FN.setText(this.uU);
            super.show();
        }
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
