package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.b.c;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.plugin.record.ui.b.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

public abstract class h extends BaseAdapter {
    ListView Fv;
    protected Context context;
    private Runnable mrT = new 2(this);
    protected List<uq> pFF = new LinkedList();
    protected af pFW = null;
    SparseArray<b> pFX = new SparseArray();
    boolean pFY = false;
    private boolean pFZ = false;
    protected a pGa;
    protected a pGb;
    private int padding = com.tencent.mm.bv.a.fromDPToPix(this.context, 35);

    public interface a {
        Bitmap a(b bVar);

        Bitmap a(c cVar);

        void a(a aVar);

        void bmV();
    }

    public abstract void a(a aVar);

    public abstract void d(b bVar);

    public /* synthetic */ Object getItem(int i) {
        return vt(i);
    }

    public h(Context context, a aVar) {
        this.context = context;
        this.pFW = new 1(this, Looper.getMainLooper());
        this.pGb = aVar;
    }

    public final void bnd() {
        this.pFX.put(0, new d(this.context));
        this.pFX.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.pGb, this.Fv));
        this.pFX.put(2, new e());
        this.pFX.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.pGb, this.pFW));
        this.pFX.put(4, new c(this.pGb));
    }

    public final void destroy() {
        for (int i = 0; i < this.pFX.size(); i++) {
            b bVar = (b) this.pFX.valueAt(i);
            if (bVar != null) {
                bVar.destroy();
            }
        }
        if (this.pGb != null) {
            this.pGb.bmV();
            this.pGb = null;
        }
    }

    public int getItemViewType(int i) {
        return m(vt(i));
    }

    private static int m(uq uqVar) {
        switch (uqVar.bjS) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 3;
        }
    }

    public int getViewTypeCount() {
        return 5;
    }

    public int getCount() {
        return this.pFF == null ? 0 : this.pFF.size();
    }

    private uq vt(int i) {
        if (this.pFF != null && i >= 0 && i < this.pFF.size()) {
            return (uq) this.pFF.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b aVar;
        uq vt = vt(i);
        b bVar = (b) this.pFX.get(m(vt));
        if (view == null) {
            view = bVar.dp(this.context);
        }
        switch (vt.bjS) {
            case 2:
                aVar = new com.tencent.mm.plugin.record.ui.a.a();
                break;
            case 15:
                aVar = new com.tencent.mm.plugin.record.ui.a.c();
                break;
            default:
                aVar = new b();
                break;
        }
        aVar.fve = vt;
        d(aVar);
        bVar.a(view, i, aVar);
        ImageView imageView = (ImageView) view.findViewById(R.h.cGU);
        TextView textView = (TextView) view.findViewById(R.h.cGY);
        textView.setText(i.b(textView.getContext(), vt.wdF, textView.getTextSize()));
        textView = (TextView) view.findViewById(R.h.cGX);
        x.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", vt.wdH);
        if (vt.wdH != null) {
            if (this.pFY) {
                String str = vt.wdH;
                textView.setText(str.substring(str.indexOf("-") + 1));
            } else {
                String[] split = vt.wdH.split(" ");
                if (split.length < 2) {
                    textView.setText(vt.wdH);
                } else {
                    textView.setText(split[1]);
                }
            }
        }
        if (i == 0) {
            if (vt.wdD != null) {
                us usVar = vt.wdD.wdX;
                imageView.setVisibility(0);
                if (usVar.weu) {
                    Im(usVar.wet);
                    if (com.tencent.mm.ag.a.e.km(usVar.wet)) {
                        o.PA().a(com.tencent.mm.ag.a.e.kp(usVar.wet), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, usVar.wet);
                    }
                } else if (!usVar.wep || (q.FS().equals(usVar.fzO) && usVar.fzO.equals(usVar.toUser))) {
                    imageView.setVisibility(8);
                    view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                    this.pFZ = true;
                } else {
                    Im(usVar.fzO);
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, usVar.fzO);
                }
            } else {
                imageView.setVisibility(8);
                view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                this.pFZ = true;
            }
        } else if (i <= 0 || this.pFZ) {
            imageView.setVisibility(8);
            view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
        } else {
            String str2 = "";
            us usVar2 = vt.wdD.wdX;
            if (vt(i - 1).wdD.wdX.weu) {
                str2 = vt(i - 1).wdD.wdX.wet;
            } else if (vt(i - 1).wdD.wdX.wep) {
                str2 = vt(i - 1).wdD.wdX.fzO;
            }
            imageView.setVisibility(0);
            String str3;
            if (vt.wdD.wdX.weu) {
                str3 = vt.wdD.wdX.wet;
                if (str2.equals(str3)) {
                    imageView.setVisibility(4);
                } else {
                    Im(str3);
                    if (com.tencent.mm.ag.a.e.km(usVar2.wet)) {
                        o.PA().a(com.tencent.mm.ag.a.e.kp(usVar2.wet), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3);
                    }
                }
            } else if (vt.wdD.wdX.wep) {
                str3 = vt.wdD.wdX.fzO;
                if (str2.equals(str3)) {
                    imageView.setVisibility(4);
                } else {
                    Im(str3);
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3);
                }
            } else {
                imageView.setVisibility(4);
            }
        }
        if (i == getCount() - 1) {
            view.findViewById(R.h.cGW).setVisibility(8);
        } else {
            view.findViewById(R.h.cGW).setVisibility(0);
        }
        return view;
    }

    private static void Im(String str) {
        if (!s.gE(str)) {
            com.tencent.mm.ad.h hVar = new com.tencent.mm.ad.h();
            hVar.username = str;
            n.JQ().a(hVar);
        }
    }

    protected final void bne() {
        this.pFW.post(this.mrT);
    }
}
