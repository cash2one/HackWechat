package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class h$b extends BaseAdapter implements com.tencent.mm.platformtools.j.a {
    private LayoutInflater DF = null;
    Map<String, WeakReference<ImageView>> pVE = new HashMap();
    private int pVH;
    List<com.tencent.mm.plugin.scanner.a.a.a> pVI = new ArrayList();
    final /* synthetic */ h pVJ;

    class a {
        TextView lkn;
        ImageView pTN;
        final /* synthetic */ h$b pVL;

        a(h$b com_tencent_mm_plugin_scanner_ui_h_b) {
            this.pVL = com_tencent_mm_plugin_scanner_ui_h_b;
        }
    }

    public h$b(h hVar) {
        this.pVJ = hVar;
        this.DF = LayoutInflater.from(h.a(hVar));
        j.a(this);
        this.pVH = h.a(hVar).getResources().getColor(R.e.bsJ);
    }

    public final int getCount() {
        return this.pVI.size();
    }

    public final Object getItem(int i) {
        return this.pVI.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.DF.inflate(R.i.dpA, viewGroup, false);
            aVar = new a(this);
            aVar.pTN = (ImageView) view.findViewById(R.h.cnU);
            aVar.lkn = (TextView) view.findViewById(R.h.cnT);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) this.pVI.get(i);
        Bitmap a = j.a(new h$a(aVar2.iconUrl));
        if (a == null || a.isRecycled()) {
            aVar.pTN.setBackgroundColor(this.pVH);
            aVar.pTN.setImageBitmap(null);
        } else {
            aVar.pTN.setImageBitmap(a);
            aVar.pTN.setBackgroundColor(0);
        }
        aVar.pTN.setOnClickListener(new 1(this, aVar2.pSy, aVar2));
        aVar.pTN.setTag(aVar2.iconUrl);
        this.pVE.put(aVar2.iconUrl, new WeakReference(aVar.pTN));
        aVar.lkn.setText(aVar2.name);
        return view;
    }

    public final void l(String str, final Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled() && !bh.ov(str)) {
            x.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=" + str);
            if (((WeakReference) this.pVE.get(str)) != null) {
                final ImageView imageView = (ImageView) ((WeakReference) this.pVE.get(str)).get();
                if (imageView != null && str.equals((String) imageView.getTag())) {
                    ag.y(new Runnable(this) {
                        final /* synthetic */ h$b pVL;

                        public final void run() {
                            imageView.setImageBitmap(bitmap);
                            imageView.setBackgroundColor(0);
                        }
                    });
                }
            }
        }
    }
}
