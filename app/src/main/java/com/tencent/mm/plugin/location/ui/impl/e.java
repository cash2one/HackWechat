package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bc.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class e extends BaseAdapter {
    String aAM = "";
    byte[] buffer = null;
    private Context context = null;
    boolean kMn = false;
    String muF = "";
    boolean nXf = false;
    List<f> nXr = new ArrayList();
    int nXs = 0;
    boolean nXt = false;

    public final /* synthetic */ Object getItem(int i) {
        return rS(i);
    }

    public e(Context context) {
        this.context = context;
    }

    public final void clean() {
        this.buffer = null;
        this.kMn = false;
        this.aAM = "";
        this.nXr.clear();
    }

    public final void DP(String str) {
        this.aAM = str;
        x.i("MicroMsg.PoiAdapter", "initdata key %s", new Object[]{str});
    }

    public final void b(f fVar) {
        if (this.nXr.size() >= 0) {
            this.nXr.add(0, fVar);
            notifyDataSetChanged();
        }
    }

    public final void a(List<f> list, byte[] bArr, boolean z, String str) {
        if (this.aAM == null || !this.aAM.equals(str)) {
            x.i("MicroMsg.PoiAdapter", "old key come pass it %s %s", new Object[]{this.aAM, str});
            return;
        }
        int size = this.nXr.size();
        int i = size;
        for (f fVar : list) {
            fVar.nXK = i;
            i++;
            this.nXr.add(fVar);
        }
        this.buffer = bArr;
        this.kMn = z;
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.nXr.size();
    }

    public final f rS(int i) {
        return (f) this.nXr.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.i.dpn, null);
            aVar = new a();
            aVar.titleView = (TextView) view.findViewById(R.h.title);
            aVar.nXu = (TextView) view.findViewById(R.h.subtitle);
            aVar.nXv = (ImageView) view.findViewById(R.h.cRW);
            aVar.nXx = view.findViewById(R.h.cfK);
            aVar.nXw = view.findViewById(R.h.cpQ);
            aVar.jOk = (TextView) view.findViewById(R.h.cRS);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (((f) this.nXr.get(i)).type == 1 || ((f) this.nXr.get(i)).type == 2) {
            aVar.nXx.setVisibility(0);
            aVar.nXw.setVisibility(8);
            aVar.jOk.setText(bh.az(((f) this.nXr.get(i)).nXy, ""));
        } else {
            aVar.nXx.setVisibility(8);
            aVar.nXw.setVisibility(0);
        }
        if (i != 0 || this.nXt) {
            CharSequence DQ;
            CharSequence DQ2;
            f fVar = (f) this.nXr.get(i);
            String az = bh.az(fVar.mName, "");
            String az2 = bh.az(fVar.nXy, "");
            if (!this.nXt || bh.ov(this.muF)) {
                Object obj = az;
                Object obj2 = az2;
            } else {
                DQ = DQ(az);
                DQ2 = DQ(az2);
            }
            aVar.titleView.setText(DQ);
            aVar.nXu.setText(DQ2);
            aVar.nXu.setVisibility(0);
        } else if (this.nXf) {
            aVar.titleView.setText(bh.az(((f) this.nXr.get(0)).mName, ""));
            aVar.nXu.setVisibility(0);
            aVar.nXu.setText(bh.az(((f) this.nXr.get(0)).nXy, ""));
        } else {
            aVar.nXu.setVisibility(8);
            if (!bh.ov(((f) this.nXr.get(0)).nXy)) {
                aVar.titleView.setText(bh.az(((f) this.nXr.get(i)).nXy, ""));
            } else if (bh.ov(((f) this.nXr.get(0)).nXH)) {
                aVar.titleView.setText(bh.az(((f) this.nXr.get(i)).mName, ""));
            } else {
                aVar.titleView.setText(bh.az(((f) this.nXr.get(i)).nXH, ""));
            }
        }
        if (i == this.nXs) {
            aVar.nXv.setVisibility(0);
        } else {
            aVar.nXv.setVisibility(4);
        }
        return view;
    }

    private Spannable DQ(String str) {
        return b.a((CharSequence) str, this.muF);
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        x.i("MicroMsg.PoiAdapter", "map notifyDataChange " + bh.cgy().toString() + " threadId : " + Thread.currentThread().getId());
    }
}
