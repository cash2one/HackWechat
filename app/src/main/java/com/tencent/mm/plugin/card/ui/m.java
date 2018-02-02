package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.List;

public final class m extends BaseAdapter {
    List<b> kIO = new ArrayList();
    OnClickListener kVM;
    boolean kVN = false;
    private Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return nX(i);
    }

    public m(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.kIO.size();
    }

    private b nX(int i) {
        return (b) this.kIO.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        final b nX = nX(i);
        switch (nX.kKa) {
            case 2:
                view = View.inflate(this.mContext, R.i.dbI, null);
                TextView textView = (TextView) view.findViewById(R.h.bPY);
                TextView textView2 = (TextView) view.findViewById(R.h.bPX);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.cOb);
                if (TextUtils.isEmpty(nX.kKe)) {
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout.setTag(nX.kKe);
                    linearLayout.setOnClickListener(new 1(this));
                    ((ImageView) view.findViewById(R.h.bPW)).setBackgroundColor(l.wO(nX.hbM));
                    linearLayout.setVisibility(0);
                }
                textView.setText(nX.title);
                textView2.setText(nX.kJQ);
                break;
            default:
                a aVar;
                boolean z;
                if (view != null) {
                    aVar = (a) view.getTag();
                } else {
                    aVar = null;
                }
                if (view == null || r0 == null) {
                    view = View.inflate(this.mContext, R.i.dbJ, null);
                    a aVar2 = new a(this, (byte) 0);
                    aVar2.kUP = (TextView) view.findViewById(R.h.bPV);
                    aVar2.kVS = (TextView) view.findViewById(R.h.bPU);
                    aVar2.kVT = (TextView) view.findViewById(R.h.bPR);
                    aVar2.kVU = (ImageView) view.findViewById(R.h.bPT);
                    aVar2.kpZ = view.findViewById(R.h.bPQ);
                    aVar2.kVV = (CheckBox) view.findViewById(R.h.bPS);
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
                aVar.kUP.setText(nX.title);
                if (nX.kKc) {
                    aVar.kVV.setVisibility(0);
                    aVar.kVV.setChecked(nX.kKd);
                    aVar.kVV.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ m kVO;

                        public final void onClick(View view) {
                            if (((CheckBox) view).isChecked()) {
                                nX.kKd = true;
                            } else {
                                nX.kKd = false;
                            }
                        }
                    });
                } else {
                    aVar.kVV.setVisibility(8);
                }
                if (TextUtils.isEmpty(nX.kJQ)) {
                    aVar.kVS.setVisibility(4);
                } else {
                    aVar.kVS.setVisibility(0);
                    aVar.kVS.setText(nX.kJQ);
                }
                if ((nX.vSM & 1) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    aVar.kUP.setGravity(17);
                    aVar.kUP.setTextColor(this.mContext.getResources().getColor(R.e.btd));
                    aVar.kVS.setVisibility(8);
                } else {
                    aVar.kUP.setGravity(3);
                    aVar.kUP.setTextColor(this.mContext.getResources().getColor(R.e.bsU));
                }
                if (nX.kKb) {
                    aVar.kVT.setVisibility(0);
                } else {
                    aVar.kVT.setVisibility(8);
                }
                aVar.kVS.setTextColor(this.mContext.getResources().getColor(R.e.bsT));
                if (bh.ov(nX.oZC)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    aVar.kVU.setVisibility(0);
                    com.tencent.mm.plugin.card.b.m.a(aVar.kVU, nX.oZC, a.fromDPToPix(this.mContext, 20), R.g.bDT, false);
                } else {
                    aVar.kVU.setVisibility(8);
                }
                if (i + 1 >= getCount()) {
                    if (i + 1 == getCount()) {
                        if (!this.kVN) {
                            h(aVar.kpZ, false);
                            break;
                        }
                        h(aVar.kpZ, true);
                        break;
                    }
                }
                a(aVar.kpZ, nX(i));
                a(aVar.kpZ, nX(i + 1));
                break;
                break;
        }
        return view;
    }

    private static void a(View view, b bVar) {
        if (bVar != null) {
            h(view, bVar.kKb);
        }
    }

    private static void h(View view, boolean z) {
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            view.setBackgroundResource(R.g.bDJ);
        } else {
            view.setBackgroundResource(R.g.bDp);
        }
        view.setLayoutParams(layoutParams);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
