package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class g extends u {
    Context mContext;
    private ArrayList<b> pfN;
    private boolean pfO;
    a pfP;
    private List<String> pfr;

    class b implements a {
        public ImageView fyg = null;
        final /* synthetic */ g pfQ;
        public String url;

        public b(g gVar, String str) {
            this.pfQ = gVar;
            this.url = str;
            this.fyg = (ImageView) ((LayoutInflater) gVar.mContext.getSystemService("layout_inflater")).inflate(com.tencent.mm.plugin.wxpay.a.g.uDx, null);
            this.fyg.setImageBitmap(j.a(new c(str)));
            this.fyg.setOnClickListener(new 1(this, gVar));
            j.a(this);
        }

        public final void l(String str, final Bitmap bitmap) {
            x.d("MicroMsg.MallProductImageAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.url != null && str.equals(this.url)) {
                this.fyg.post(new Runnable(this) {
                    final /* synthetic */ b pfS;

                    public final void run() {
                        this.pfS.fyg.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public g(Context context) {
        this(context, (byte) 0);
    }

    private g(Context context, byte b) {
        this.pfO = false;
        this.pfP = null;
        this.mContext = context;
        this.pfr = null;
        ax(this.pfr);
    }

    public final void ax(List<String> list) {
        if (list != null) {
            if (list.size() > 0) {
                this.pfr = list;
            }
            if (this.pfN == null) {
                this.pfN = new ArrayList();
            } else {
                this.pfN.clear();
            }
            for (String bVar : this.pfr) {
                this.pfN.add(new b(this, bVar));
            }
        }
    }

    public final int getCount() {
        if (this.pfr == null) {
            return 0;
        }
        if (this.pfO) {
            return Integer.MAX_VALUE;
        }
        return this.pfr.size();
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        x.d("MicroMsg.MallProductImageAdapter", "destroy item");
        if (this.pfN != null) {
            viewGroup.removeView(((b) this.pfN.get(i)).fyg);
        }
    }

    public final int k(Object obj) {
        return -2;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.pfN == null) {
            return super.b(viewGroup, i);
        }
        x.d("MicroMsg.MallProductImageAdapter", "data valid");
        viewGroup.addView(((b) this.pfN.get(i)).fyg, 0);
        return ((b) this.pfN.get(i)).fyg;
    }
}
