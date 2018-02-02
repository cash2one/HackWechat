package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends BaseAdapter {
    private LayoutInflater DF;
    private Context mContext;
    SparseArray<String> okP = null;
    int okQ;
    private final int olj = 3;
    private final int olk = 9;
    List<ArrayList<c>> oll = new ArrayList();
    d olm;
    private boolean oln = true;
    int olo = 0;
    int olp = 0;
    boolean olq = false;
    private boolean olr = false;

    class a {
        public String olA = null;
        public String olB = null;
        public ImageView olC = null;
        public ImageView olD = null;
        public ImageView olE = null;
        public ImageView olF = null;
        final /* synthetic */ b ols;
        public View olv = null;
        public ImageView olw = null;
        public ImageView olx = null;
        public TextView oly = null;
        public TextView olz = null;

        a(b bVar) {
            this.ols = bVar;
        }
    }

    public b(Context context, int i) {
        this.mContext = context;
        this.okQ = i;
        this.DF = LayoutInflater.from(this.mContext);
    }

    public final int getCount() {
        return this.oll.size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        Object obj;
        b bVar;
        b bVar2;
        List list;
        int i3;
        int i4;
        Object obj2;
        CharSequence charSequence;
        Object obj3;
        ViewGroup viewGroup2;
        a aVar;
        View inflate;
        a aVar2;
        if (this.olo > 9) {
            int i5 = 0;
            for (i2 = 0; i2 <= i; i2++) {
                i5 += ((ArrayList) this.oll.get(i2)).size();
            }
            if (i <= this.olp) {
                if (i5 > 9 && this.oln) {
                    obj = 1;
                    if (view == null) {
                        bVar = (b) view.getTag();
                    } else {
                        bVar2 = new b(this);
                        view = this.DF.inflate(a$g.uCL, viewGroup, false);
                        bVar2.olG = (LinearLayout) view.findViewById(f.upS);
                        bVar2.olH = (TextView) view.findViewById(f.upR);
                        bVar2.olI = view.findViewById(f.divider);
                        bVar2.olJ = view.findViewById(f.ulR);
                        bVar2.olK = view.findViewById(f.ury);
                        bVar2.olM = (TextView) view.findViewById(f.urz);
                        bVar2.olL = (ImageView) view.findViewById(f.urx);
                        bVar2.olN = view.findViewById(f.urK);
                        bVar2.olK.setOnClickListener(new 1(this));
                        view.setTag(bVar2);
                        bVar = bVar2;
                    }
                    if (obj == null) {
                    }
                    bVar.olG.setVisibility(0);
                    list = (List) this.oll.get(i);
                    i3 = ((c) list.get(0)).olO.type;
                    if (list.size() > 0) {
                        bVar.olH.setVisibility(8);
                        bVar.olI.setVisibility(8);
                        bVar.olJ.setVisibility(8);
                    } else {
                        i4 = ((c) list.get(0)).olO.type;
                        if (this.okP == null) {
                            obj2 = (String) this.okP.get(i4);
                        } else {
                            charSequence = null;
                        }
                        if (!bh.ov(charSequence)) {
                            obj3 = i != 0 ? 1 : 1;
                            if (obj3 == null) {
                                bVar.olH.setText(charSequence);
                                bVar.olH.setVisibility(0);
                                bVar.olI.setVisibility(0);
                                bVar.olJ.setVisibility(0);
                            } else {
                                bVar.olH.setVisibility(8);
                                bVar.olI.setVisibility(8);
                                bVar.olJ.setVisibility(8);
                            }
                        }
                        obj3 = null;
                        if (obj3 == null) {
                            bVar.olH.setVisibility(8);
                            bVar.olI.setVisibility(8);
                            bVar.olJ.setVisibility(8);
                        } else {
                            bVar.olH.setText(charSequence);
                            bVar.olH.setVisibility(0);
                            bVar.olI.setVisibility(0);
                            bVar.olJ.setVisibility(0);
                        }
                    }
                    viewGroup2 = bVar.olG;
                    viewGroup2.setFocusable(true);
                    i2 = 0;
                    while (i2 < 3) {
                        if (i2 < viewGroup2.getChildCount()) {
                        }
                        aVar = new a(this);
                        inflate = this.DF.inflate(a$g.uCN, viewGroup2, false);
                        aVar.olv = inflate.findViewById(f.upW);
                        aVar.olw = (ImageView) inflate.findViewById(f.upV);
                        aVar.oly = (TextView) inflate.findViewById(f.upY);
                        aVar.olz = (TextView) inflate.findViewById(f.upU);
                        aVar.olx = (ImageView) inflate.findViewById(f.urP);
                        aVar.olC = (ImageView) inflate.findViewById(f.ujL);
                        aVar.olD = (ImageView) inflate.findViewById(f.ujK);
                        aVar.olE = (ImageView) inflate.findViewById(f.ccl);
                        aVar.olF = (ImageView) inflate.findViewById(f.ujI);
                        inflate.setTag(aVar);
                        if (i2 < list.size()) {
                            inflate.setFocusable(true);
                            aVar2 = (a) inflate.getTag();
                            aVar2.olv.setVisibility(4);
                            inflate.setOnClickListener(null);
                            inflate.setEnabled(false);
                            inflate.setClickable(false);
                            a(aVar2);
                        } else {
                            a(inflate, (c) list.get(i2));
                        }
                        viewGroup2.addView(inflate, new LayoutParams(-2, a.aXY(), 1.0f));
                        i2++;
                    }
                    if (obj != null) {
                        bVar.olK.setVisibility(8);
                    } else {
                        bVar.olH.setVisibility(8);
                        bVar.olI.setVisibility(8);
                        bVar.olJ.setVisibility(8);
                        bVar.olK.setVisibility(0);
                        bVar.olL.setImageResource(a$h.uGJ);
                        if (this.oln) {
                            bVar.olM.setText(this.mContext.getString(a$i.uLb));
                        } else {
                            bVar.olM.setText(this.mContext.getString(a$i.uLc));
                        }
                    }
                    bVar.olN.setVisibility(8);
                    return view;
                } else if (i == this.olp && !this.oln) {
                    int i6 = 1;
                    if (view == null) {
                        bVar2 = new b(this);
                        view = this.DF.inflate(a$g.uCL, viewGroup, false);
                        bVar2.olG = (LinearLayout) view.findViewById(f.upS);
                        bVar2.olH = (TextView) view.findViewById(f.upR);
                        bVar2.olI = view.findViewById(f.divider);
                        bVar2.olJ = view.findViewById(f.ulR);
                        bVar2.olK = view.findViewById(f.ury);
                        bVar2.olM = (TextView) view.findViewById(f.urz);
                        bVar2.olL = (ImageView) view.findViewById(f.urx);
                        bVar2.olN = view.findViewById(f.urK);
                        bVar2.olK.setOnClickListener(new 1(this));
                        view.setTag(bVar2);
                        bVar = bVar2;
                    } else {
                        bVar = (b) view.getTag();
                    }
                    if (obj == null && this.oln) {
                        bVar.olH.setVisibility(8);
                        bVar.olI.setVisibility(8);
                        bVar.olJ.setVisibility(8);
                        bVar.olK.setVisibility(0);
                        bVar.olL.setImageResource(a$h.uGI);
                        bVar.olM.setText(this.mContext.getString(a$i.uLc));
                        bVar.olG.setVisibility(8);
                        if (!this.olq || this.olr) {
                            bVar.olN.setVisibility(8);
                        } else {
                            bVar.olN.setVisibility(0);
                        }
                    } else {
                        bVar.olG.setVisibility(0);
                        list = (List) this.oll.get(i);
                        i3 = ((c) list.get(0)).olO.type;
                        if (list.size() > 0) {
                            i4 = ((c) list.get(0)).olO.type;
                            if (this.okP == null) {
                                charSequence = null;
                            } else {
                                obj2 = (String) this.okP.get(i4);
                            }
                            if (bh.ov(charSequence)) {
                                if (i != 0) {
                                    if (((ArrayList) this.oll.get(i - 1)).size() > 0 && i4 != ((c) ((ArrayList) this.oll.get(i - 1)).get(0)).olO.type) {
                                    }
                                }
                                if (obj3 == null) {
                                    bVar.olH.setText(charSequence);
                                    bVar.olH.setVisibility(0);
                                    bVar.olI.setVisibility(0);
                                    bVar.olJ.setVisibility(0);
                                } else {
                                    bVar.olH.setVisibility(8);
                                    bVar.olI.setVisibility(8);
                                    bVar.olJ.setVisibility(8);
                                }
                            }
                            obj3 = null;
                            if (obj3 == null) {
                                bVar.olH.setVisibility(8);
                                bVar.olI.setVisibility(8);
                                bVar.olJ.setVisibility(8);
                            } else {
                                bVar.olH.setText(charSequence);
                                bVar.olH.setVisibility(0);
                                bVar.olI.setVisibility(0);
                                bVar.olJ.setVisibility(0);
                            }
                        } else {
                            bVar.olH.setVisibility(8);
                            bVar.olI.setVisibility(8);
                            bVar.olJ.setVisibility(8);
                        }
                        viewGroup2 = bVar.olG;
                        viewGroup2.setFocusable(true);
                        i2 = 0;
                        while (i2 < 3) {
                            if (i2 < viewGroup2.getChildCount() || viewGroup2.getChildAt(i2) == null) {
                                aVar = new a(this);
                                inflate = this.DF.inflate(a$g.uCN, viewGroup2, false);
                                aVar.olv = inflate.findViewById(f.upW);
                                aVar.olw = (ImageView) inflate.findViewById(f.upV);
                                aVar.oly = (TextView) inflate.findViewById(f.upY);
                                aVar.olz = (TextView) inflate.findViewById(f.upU);
                                aVar.olx = (ImageView) inflate.findViewById(f.urP);
                                aVar.olC = (ImageView) inflate.findViewById(f.ujL);
                                aVar.olD = (ImageView) inflate.findViewById(f.ujK);
                                aVar.olE = (ImageView) inflate.findViewById(f.ccl);
                                aVar.olF = (ImageView) inflate.findViewById(f.ujI);
                                inflate.setTag(aVar);
                                if (i2 < list.size()) {
                                    a(inflate, (c) list.get(i2));
                                } else {
                                    inflate.setFocusable(true);
                                    aVar2 = (a) inflate.getTag();
                                    aVar2.olv.setVisibility(4);
                                    inflate.setOnClickListener(null);
                                    inflate.setEnabled(false);
                                    inflate.setClickable(false);
                                    a(aVar2);
                                }
                                viewGroup2.addView(inflate, new LayoutParams(-2, a.aXY(), 1.0f));
                            } else {
                                View childAt = viewGroup2.getChildAt(i2);
                                childAt.setVisibility(0);
                                if (i2 < list.size()) {
                                    a(childAt, (c) list.get(i2));
                                } else {
                                    viewGroup2.getChildAt(i2).setFocusable(true);
                                    viewGroup2.getChildAt(i2).setOnClickListener(null);
                                    aVar2 = (a) viewGroup2.getChildAt(i2).getTag();
                                    aVar2.olv.setVisibility(4);
                                    childAt.setEnabled(false);
                                    childAt.setClickable(false);
                                    a(aVar2);
                                }
                            }
                            i2++;
                        }
                        if (obj != null) {
                            bVar.olH.setVisibility(8);
                            bVar.olI.setVisibility(8);
                            bVar.olJ.setVisibility(8);
                            bVar.olK.setVisibility(0);
                            bVar.olL.setImageResource(a$h.uGJ);
                            if (this.oln) {
                                bVar.olM.setText(this.mContext.getString(a$i.uLc));
                            } else {
                                bVar.olM.setText(this.mContext.getString(a$i.uLb));
                            }
                        } else {
                            bVar.olK.setVisibility(8);
                        }
                        bVar.olN.setVisibility(8);
                    }
                    return view;
                }
            }
        }
        obj = null;
        if (view == null) {
            bVar2 = new b(this);
            view = this.DF.inflate(a$g.uCL, viewGroup, false);
            bVar2.olG = (LinearLayout) view.findViewById(f.upS);
            bVar2.olH = (TextView) view.findViewById(f.upR);
            bVar2.olI = view.findViewById(f.divider);
            bVar2.olJ = view.findViewById(f.ulR);
            bVar2.olK = view.findViewById(f.ury);
            bVar2.olM = (TextView) view.findViewById(f.urz);
            bVar2.olL = (ImageView) view.findViewById(f.urx);
            bVar2.olN = view.findViewById(f.urK);
            bVar2.olK.setOnClickListener(new 1(this));
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (obj == null) {
        }
        bVar.olG.setVisibility(0);
        list = (List) this.oll.get(i);
        i3 = ((c) list.get(0)).olO.type;
        if (list.size() > 0) {
            i4 = ((c) list.get(0)).olO.type;
            if (this.okP == null) {
                charSequence = null;
            } else {
                obj2 = (String) this.okP.get(i4);
            }
            if (bh.ov(charSequence)) {
                if (i != 0) {
                }
                if (obj3 == null) {
                    bVar.olH.setText(charSequence);
                    bVar.olH.setVisibility(0);
                    bVar.olI.setVisibility(0);
                    bVar.olJ.setVisibility(0);
                } else {
                    bVar.olH.setVisibility(8);
                    bVar.olI.setVisibility(8);
                    bVar.olJ.setVisibility(8);
                }
            }
            obj3 = null;
            if (obj3 == null) {
                bVar.olH.setVisibility(8);
                bVar.olI.setVisibility(8);
                bVar.olJ.setVisibility(8);
            } else {
                bVar.olH.setText(charSequence);
                bVar.olH.setVisibility(0);
                bVar.olI.setVisibility(0);
                bVar.olJ.setVisibility(0);
            }
        } else {
            bVar.olH.setVisibility(8);
            bVar.olI.setVisibility(8);
            bVar.olJ.setVisibility(8);
        }
        viewGroup2 = bVar.olG;
        viewGroup2.setFocusable(true);
        i2 = 0;
        while (i2 < 3) {
            if (i2 < viewGroup2.getChildCount()) {
            }
            aVar = new a(this);
            inflate = this.DF.inflate(a$g.uCN, viewGroup2, false);
            aVar.olv = inflate.findViewById(f.upW);
            aVar.olw = (ImageView) inflate.findViewById(f.upV);
            aVar.oly = (TextView) inflate.findViewById(f.upY);
            aVar.olz = (TextView) inflate.findViewById(f.upU);
            aVar.olx = (ImageView) inflate.findViewById(f.urP);
            aVar.olC = (ImageView) inflate.findViewById(f.ujL);
            aVar.olD = (ImageView) inflate.findViewById(f.ujK);
            aVar.olE = (ImageView) inflate.findViewById(f.ccl);
            aVar.olF = (ImageView) inflate.findViewById(f.ujI);
            inflate.setTag(aVar);
            if (i2 < list.size()) {
                a(inflate, (c) list.get(i2));
            } else {
                inflate.setFocusable(true);
                aVar2 = (a) inflate.getTag();
                aVar2.olv.setVisibility(4);
                inflate.setOnClickListener(null);
                inflate.setEnabled(false);
                inflate.setClickable(false);
                a(aVar2);
            }
            viewGroup2.addView(inflate, new LayoutParams(-2, a.aXY(), 1.0f));
            i2++;
        }
        if (obj != null) {
            bVar.olH.setVisibility(8);
            bVar.olI.setVisibility(8);
            bVar.olJ.setVisibility(8);
            bVar.olK.setVisibility(0);
            bVar.olL.setImageResource(a$h.uGJ);
            if (this.oln) {
                bVar.olM.setText(this.mContext.getString(a$i.uLc));
            } else {
                bVar.olM.setText(this.mContext.getString(a$i.uLb));
            }
        } else {
            bVar.olK.setVisibility(8);
        }
        bVar.olN.setVisibility(8);
        return view;
    }

    private static void a(a aVar) {
        aVar.olD.setVisibility(4);
    }

    final boolean aYb() {
        if (this.oll.size() > 3) {
            ArrayList arrayList = (ArrayList) this.oll.get(3);
            if (arrayList != null && arrayList.size() > 0) {
                int i = ((c) arrayList.get(0)).olO.type;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.olO.type != i) {
                        break;
                    } else if (a(cVar.olO)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(MallFunction mallFunction) {
        if (mallFunction.sQt == null || bh.ov(mallFunction.sQt.sQC) || !b(mallFunction) || d.bMi().Nd(mallFunction.pBK) == null) {
            return false;
        }
        return true;
    }

    private void a(View view, c cVar) {
        if (view != null) {
            a aVar = (a) view.getTag();
            final MallFunction mallFunction = cVar.olO;
            final int i = cVar.olP;
            aVar.olB = mallFunction.olB;
            aVar.olA = mallFunction.olA;
            com.tencent.mm.plugin.mall.b.a.f(aVar.olw, aVar.olA, a$h.uGy);
            aVar.oly.setText(mallFunction.fII);
            aVar.olx.setVisibility(8);
            if (mallFunction.sQt == null || bh.ov(mallFunction.sQt.sQC) || !b(mallFunction)) {
                if (mallFunction.sQt == null || mallFunction.sQt.sQH != 1) {
                    aVar.olz.setText("");
                    aVar.olz.setVisibility(4);
                } else {
                    aVar.olz.setText(mallFunction.sQt.sQC);
                    aVar.olz.setVisibility(0);
                }
                aVar.olx.setImageBitmap(null);
                aVar.olx.setVisibility(8);
            } else {
                if (d.bMi().Nd(mallFunction.pBK) != null) {
                    x.w("MicroMsg.FunctionListAdapter", "show the news : " + d.bMi().Nd(mallFunction.pBK).sQC);
                    aVar.olz.setText(mallFunction.sQt.sQC);
                    aVar.olz.setVisibility(0);
                } else {
                    aVar.olz.setVisibility(4);
                }
                com.tencent.mm.plugin.mall.b.a.k(aVar.olx, aVar.olB);
                aVar.olx.setVisibility(0);
                String str = mallFunction.pBK;
            }
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b ols;

                public final void onClick(View view) {
                    x.v("MicroMsg.FunctionListAdapter", "on Click");
                    if (this.ols.olm != null) {
                        this.ols.olm.a(i, mallFunction);
                    }
                }
            });
            aVar.olv.setVisibility(0);
            view.setEnabled(true);
            view.setClickable(true);
            aVar.olD.setVisibility(0);
            aVar.olE.setVisibility(0);
        }
    }

    private static boolean b(MallFunction mallFunction) {
        MallNews Nd = d.bMi().Nd(mallFunction.pBK);
        if (Nd == null || bh.ov(Nd.rVK) || !Nd.rVK.equals(mallFunction.sQt.rVK)) {
            x.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[]{mallFunction.sQt.rVK, mallFunction.fII});
            d bMi = d.bMi();
            Nd = mallFunction.sQt;
            if (Nd == null) {
                x.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
            } else {
                Nd.sQI = "<sysmsg><mallactivitynew><functionid>" + Nd.sQB + "</functionid><activityid>" + Nd.rVK + "</activityid><type>" + Nd.type + "</type><showflag>" + Nd.sQz + "</showflag><newsTipFlag>" + Nd.sQA + "</newsTipFlag></mallactivitynew></sysmsg>;";
                bMi.sQL.put(Nd.sQB, Nd);
                bMi.bjh();
            }
            return true;
        } else if (Nd == null) {
            return false;
        } else {
            if ("0".equals(Nd.sQz)) {
                x.d("MicroMsg.FunctionListAdapter", "still old news and should show");
                return true;
            }
            x.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
            return false;
        }
    }
}
