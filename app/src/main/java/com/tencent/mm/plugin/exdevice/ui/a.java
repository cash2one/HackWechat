package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.f.a.e;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import java.util.ArrayList;
import java.util.List;

final class a extends BaseAdapter {
    String jKk;
    c lUX;
    private boolean lUY;
    boolean lUZ;
    int lVa;
    int lVb;
    ArrayList<c> lVc;
    List<jm> lVd;
    private View lVe;
    private String mAppName;
    private Context mContext;

    public a(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.jKk = str2;
        this.lUY = z;
        this.mAppName = str;
    }

    public final int getCount() {
        if (this.lUY) {
            return (this.lVa + 5) + this.lVb;
        }
        return 2;
    }

    public final int getViewTypeCount() {
        return 8;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        if (this.lUY) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 6;
            }
            if (i > 1 && i <= this.lVa + 1) {
                return 1;
            }
            if (i == this.lVa + 2) {
                return 2;
            }
            if (i == this.lVa + 3) {
                return 5;
            }
            if (i <= this.lVa + 3 || i > (this.lVa + 3) + this.lVb) {
                return i == (this.lVa + this.lVb) + 4 ? 7 : 5;
            } else {
                return 3;
            }
        } else if (i == 0) {
            return 0;
        } else {
            return 4;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        d dVar;
        e eVar;
        f fVar;
        b bVar = null;
        int itemViewType = getItemViewType(i);
        c cVar;
        b bVar2;
        if (view != null) {
            switch (itemViewType) {
                case 0:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = (f) view.getTag();
                    bVar2 = null;
                    break;
                case 1:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = (e) view.getTag();
                    fVar = null;
                    bVar2 = null;
                    break;
                case 2:
                    cVar = null;
                    aVar = (a) view.getTag();
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar2 = null;
                    break;
                case 3:
                    cVar = (c) view.getTag();
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar2 = null;
                    break;
                case 4:
                    cVar = null;
                    aVar = null;
                    dVar = (d) view.getTag();
                    eVar = null;
                    fVar = null;
                    bVar2 = null;
                    break;
                case 5:
                    view.getTag();
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 6:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar2 = null;
                    bVar = (b) view.getTag();
                    break;
                case 7:
                    bVar2 = (b) view.getTag();
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                default:
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
            }
        }
        switch (itemViewType) {
            case 0:
                if (this.lVe == null) {
                    this.lVe = LayoutInflater.from(this.mContext).inflate(R.i.dgV, viewGroup, false);
                }
                view = this.lVe;
                f fVar2 = new f(this);
                fVar2.lkk = (ImageView) view.findViewById(R.h.cff);
                view.setTag(fVar2);
                bVar2 = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = fVar2;
                cVar = null;
                break;
            case 1:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgU, viewGroup, false);
                e eVar2 = new e(this);
                eVar2.lVl = (NoMeasuredTextView) view.findViewById(R.h.cfq);
                eVar2.lVm = (TextView) view.findViewById(R.h.cfr);
                eVar2.lkk = (ImageView) view.findViewById(R.h.cfo);
                eVar2.lVh = view.findViewById(R.h.cfp);
                eVar2.lVl.O(this.mContext.getResources().getDimension(R.f.buR));
                eVar2.lVl.setTextColor(this.mContext.getResources().getColor(R.e.bsk));
                eVar2.lVl.cpw();
                eVar2.lVl.ygb = true;
                view.setTag(eVar2);
                bVar2 = null;
                aVar = null;
                dVar = null;
                eVar = eVar2;
                fVar = null;
                cVar = null;
                break;
            case 2:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgR, viewGroup, false);
                a aVar2 = new a(this);
                aVar2.lVg = (TextView) view.findViewById(R.h.cfk);
                aVar2.lVh = view.findViewById(R.h.cfi);
                aVar2.lSc = (ImageView) view.findViewById(R.h.cfj);
                view.setTag(aVar2);
                bVar2 = null;
                aVar = aVar2;
                dVar = null;
                eVar = null;
                fVar = null;
                cVar = null;
                break;
            case 3:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgR, viewGroup, false);
                cVar = new c(this);
                cVar.lVg = (TextView) view.findViewById(R.h.cfk);
                cVar.lVh = view.findViewById(R.h.cfi);
                cVar.lSc = (ImageView) view.findViewById(R.h.cfj);
                cVar.lVj = view.findViewById(R.h.cfh);
                view.setTag(cVar);
                bVar2 = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 4:
                view = LayoutInflater.from(this.mContext).inflate(R.i.cfn, viewGroup, false);
                d dVar2 = new d(this);
                dVar2.lVk = (Button) view.findViewById(R.h.cfn);
                view.setTag(dVar2);
                bVar2 = null;
                aVar = null;
                dVar = dVar2;
                eVar = null;
                fVar = null;
                cVar = null;
                break;
            case 5:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgT, viewGroup, false);
                view.setTag(new b(this));
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 6:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgT, viewGroup, false);
                b bVar3 = new b(this);
                bVar3.lVg = (TextView) view.findViewById(R.h.cfm);
                view.setTag(bVar3);
                bVar2 = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                b bVar4 = bVar3;
                cVar = null;
                bVar = bVar4;
                break;
            case 7:
                view = LayoutInflater.from(this.mContext).inflate(R.i.dgT, viewGroup, false);
                bVar2 = new b(this);
                bVar2.lVi = view.findViewById(R.h.cfl);
                view.setTag(bVar2);
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            default:
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
        }
        switch (itemViewType) {
            case 0:
                b.p(fVar.lkk, this.jKk);
                fVar.lkk.setOnClickListener(new 1(this));
                break;
            case 1:
                if (i - 2 >= 0 && !bh.cA(this.lVc)) {
                    c cVar2 = (c) this.lVc.get(i - 2);
                    if (cVar2 != null) {
                        int i2 = cVar2.field_step;
                        String str = cVar2.field_username;
                        if (cVar2.field_step >= 10000) {
                            eVar.lVm.setTextColor(this.mContext.getResources().getColor(R.e.bsj));
                        } else {
                            eVar.lVm.setTextColor(this.mContext.getResources().getColor(R.e.bsi));
                        }
                        eVar.lVl.setText(i.b(this.mContext, r.gu(str), eVar.lVl.gu.getTextSize()));
                        eVar.lVm.setText(String.valueOf(i2));
                        b.o(eVar.lkk, str);
                        eVar.lVh.setOnClickListener(new 2(this, str));
                        break;
                    }
                }
                break;
            case 2:
                aVar.lVg.setText(this.mContext.getResources().getText(R.l.edt));
                aVar.lSc.setImageResource(R.k.dyp);
                aVar.lVh.setOnClickListener(new 3(this));
                break;
            case 3:
                if ((i - this.lVa) - 4 >= 0 && !bh.cA(this.lVd)) {
                    jm jmVar = (jm) this.lVd.get((i - this.lVa) - 4);
                    if (jmVar != null) {
                        CharSequence charSequence = jmVar.title;
                        String str2 = jmVar.fDI;
                        final String str3 = jmVar.url;
                        cVar.lVg.setText(charSequence);
                        if ((i - this.lVa) - 4 != this.lVb - 1) {
                            cVar.lVj.setVisibility(0);
                        }
                        e.a(this.mContext, cVar.lSc, str2, R.e.brW);
                        cVar.lVh.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ a lVf;

                            public final void onClick(View view) {
                                d.pY(8);
                                f.V(this.lVf.mContext, str3);
                            }
                        });
                        break;
                    }
                }
                break;
            case 4:
                if (!this.lUZ) {
                    ar.Hg();
                    if (com.tencent.mm.z.c.EY().WK(this.jKk)) {
                        dVar.lVk.setVisibility(0);
                        dVar.lVk.setOnClickListener(new 5(this));
                        break;
                    }
                }
                dVar.lVk.setVisibility(4);
                break;
            case 6:
                bVar.lVg.setText(this.mContext.getString(R.l.edz));
                break;
            case 7:
                bVar2.lVi.setVisibility(0);
                break;
        }
        return view;
    }
}
