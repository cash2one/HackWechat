package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.HashSet;
import java.util.List;

public final class a extends BaseAdapter {
    private List<c> dataList;
    HashSet<Integer> kmb = new HashSet();
    CleanChattingUI lgk;

    class a {
        ImageView iip;
        TextView iiq;
        TextView iir;
        CheckBox iis;
        RelativeLayout kme;
        final /* synthetic */ a lgl;

        a(a aVar) {
            this.lgl = aVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return ok(i);
    }

    public a(CleanChattingUI cleanChattingUI, List<c> list) {
        this.lgk = cleanChattingUI;
        this.dataList = list;
    }

    public final int getCount() {
        return this.dataList.size();
    }

    public final c ok(int i) {
        return (c) this.dataList.get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.lgk.getLayoutInflater().inflate(R.i.dew, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.iip = (ImageView) view.findViewById(R.h.bLL);
            aVar2.iiq = (TextView) view.findViewById(R.h.cSu);
            aVar2.iir = (TextView) view.findViewById(R.h.caS);
            aVar2.iis = (CheckBox) view.findViewById(R.h.cKI);
            aVar2.kme = (RelativeLayout) view.findViewById(R.h.cKJ);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kme.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a lgl;

            public final void onClick(View view) {
                if (this.lgl.kmb.contains(Integer.valueOf(i))) {
                    this.lgl.kmb.remove(Integer.valueOf(i));
                } else {
                    this.lgl.kmb.add(Integer.valueOf(i));
                }
                this.lgl.notifyDataSetChanged();
                this.lgl.lgk.a(this.lgl.kmb);
            }
        });
        c ok = ok(i);
        b.a(aVar.iip, ok.username);
        aVar.iiq.setText(bh.bx(ok.size));
        if (s.eV(ok.username)) {
            aVar.iir.setText(i.b(this.lgk, r.L(ok.username, ok.username), aVar.iir.getTextSize()));
        } else {
            aVar.iir.setText(i.b(this.lgk, r.gu(ok.username), aVar.iir.getTextSize()));
        }
        if (this.kmb.contains(Integer.valueOf(i))) {
            aVar.iis.setChecked(true);
        } else {
            aVar.iis.setChecked(false);
        }
        return view;
    }

    public final void ayy() {
        this.kmb.clear();
        this.lgk.a(this.kmb);
    }
}
