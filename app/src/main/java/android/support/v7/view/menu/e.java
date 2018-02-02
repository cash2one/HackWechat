package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.a.a.h;
import android.support.v7.app.b;
import android.support.v7.app.b.a.AnonymousClass1;
import android.support.v7.app.b.a.AnonymousClass2;
import android.support.v7.app.b.a.AnonymousClass3;
import android.support.v7.app.b.a.AnonymousClass4;
import android.support.v7.app.c;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;

public final class e implements l, OnItemClickListener {
    LayoutInflater DF;
    int KK;
    ExpandedMenuView KY;
    private int KZ;
    int La;
    a Lb;
    public android.support.v7.view.menu.l.a ef;
    f eg;
    Context mContext;
    private int mId;

    private class a extends BaseAdapter {
        private int Lc = -1;
        final /* synthetic */ e Ld;

        public final /* synthetic */ Object getItem(int i) {
            return aE(i);
        }

        public a(e eVar) {
            this.Ld = eVar;
            ds();
        }

        public final int getCount() {
            int size = this.Ld.eg.dC().size() - this.Ld.KZ;
            return this.Lc < 0 ? size : size - 1;
        }

        public final h aE(int i) {
            ArrayList dC = this.Ld.eg.dC();
            int a = this.Ld.KZ + i;
            if (this.Lc >= 0 && a >= this.Lc) {
                a++;
            }
            return (h) dC.get(a);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.Ld.DF.inflate(this.Ld.KK, viewGroup, false);
            } else {
                inflate = view;
            }
            ((android.support.v7.view.menu.m.a) inflate).a(aE(i));
            return inflate;
        }

        private void ds() {
            h hVar = this.Ld.eg.Ly;
            if (hVar != null) {
                ArrayList dC = this.Ld.eg.dC();
                int size = dC.size();
                for (int i = 0; i < size; i++) {
                    if (((h) dC.get(i)) == hVar) {
                        this.Lc = i;
                        return;
                    }
                }
            }
            this.Lc = -1;
        }

        public final void notifyDataSetChanged() {
            ds();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i) {
        this(i);
        this.mContext = context;
        this.DF = LayoutInflater.from(this.mContext);
    }

    private e(int i) {
        this.KK = i;
        this.La = 0;
    }

    public final void a(Context context, f fVar) {
        if (this.La != 0) {
            this.mContext = new ContextThemeWrapper(context, this.La);
            this.DF = LayoutInflater.from(this.mContext);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.DF == null) {
                this.DF = LayoutInflater.from(this.mContext);
            }
        }
        this.eg = fVar;
        if (this.Lb != null) {
            this.Lb.notifyDataSetChanged();
        }
    }

    public final m c(ViewGroup viewGroup) {
        if (this.KY == null) {
            this.KY = (ExpandedMenuView) this.DF.inflate(h.abc_expanded_menu_layout, viewGroup, false);
            if (this.Lb == null) {
                this.Lb = new a(this);
            }
            this.KY.setAdapter(this.Lb);
            this.KY.setOnItemClickListener(this);
        }
        return this.KY;
    }

    public final ListAdapter getAdapter() {
        if (this.Lb == null) {
            this.Lb = new a(this);
        }
        return this.Lb;
    }

    public final void f(boolean z) {
        if (this.Lb != null) {
            this.Lb.notifyDataSetChanged();
        }
    }

    public final boolean a(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        g gVar = new g(pVar);
        f fVar = gVar.eg;
        android.support.v7.app.c.a aVar = new android.support.v7.app.c.a(fVar.mContext);
        gVar.LB = new e(aVar.GD.mContext, h.abc_list_menu_item_layout);
        gVar.LB.ef = gVar;
        gVar.eg.a(gVar.LB);
        aVar.GD.FP = gVar.LB.getAdapter();
        aVar.GD.Gn = gVar;
        View view = fVar.Lr;
        if (view != null) {
            aVar.GD.FO = view;
        } else {
            aVar.GD.jY = fVar.Lq;
            aVar.GD.uU = fVar.Lp;
        }
        aVar.GD.Gl = gVar;
        c cVar = new c(aVar.GD.mContext, aVar.pX);
        android.support.v7.app.b.a aVar2 = aVar.GD;
        b a = cVar.GC;
        if (aVar2.FO != null) {
            a.FO = aVar2.FO;
        } else {
            if (aVar2.uU != null) {
                a.setTitle(aVar2.uU);
            }
            if (aVar2.jY != null) {
                Drawable drawable = aVar2.jY;
                a.jY = drawable;
                a.FM = 0;
                if (a.kP != null) {
                    if (drawable != null) {
                        a.kP.setVisibility(0);
                        a.kP.setImageDrawable(drawable);
                    } else {
                        a.kP.setVisibility(8);
                    }
                }
            }
            if (aVar2.FM != 0) {
                a.setIcon(aVar2.FM);
            }
            if (aVar2.Gc != 0) {
                int i = aVar2.Gc;
                TypedValue typedValue = new TypedValue();
                a.mContext.getTheme().resolveAttribute(i, typedValue, true);
                a.setIcon(typedValue.resourceId);
            }
        }
        if (aVar2.Fu != null) {
            CharSequence charSequence = aVar2.Fu;
            a.Fu = charSequence;
            if (a.jy != null) {
                a.jy.setText(charSequence);
            }
        }
        if (aVar2.Gd != null) {
            a.a(-1, aVar2.Gd, aVar2.Ge, null);
        }
        if (aVar2.Gf != null) {
            a.a(-2, aVar2.Gf, aVar2.Gg, null);
        }
        if (aVar2.Gh != null) {
            a.a(-3, aVar2.Gh, aVar2.Gi, null);
        }
        if (!(aVar2.Gm == null && aVar2.BA == null && aVar2.FP == null)) {
            ListAdapter cVar2;
            ListView listView = (ListView) aVar2.DF.inflate(a.FT, null);
            Object simpleCursorAdapter;
            if (!aVar2.Gp) {
                int i2 = aVar2.Gq ? a.FV : a.FW;
                if (aVar2.BA != null) {
                    simpleCursorAdapter = new SimpleCursorAdapter(aVar2.mContext, i2, aVar2.BA, new String[]{aVar2.Gs}, new int[]{16908308});
                } else {
                    cVar2 = aVar2.FP != null ? aVar2.FP : new c(aVar2.mContext, i2, aVar2.Gm);
                }
            } else if (aVar2.BA == null) {
                cVar2 = new AnonymousClass1(aVar2, aVar2.mContext, a.FU, aVar2.Gm, listView);
            } else {
                simpleCursorAdapter = new AnonymousClass2(aVar2, aVar2.mContext, aVar2.BA, listView, a);
            }
            a.FP = cVar2;
            a.FQ = aVar2.FQ;
            if (aVar2.Gn != null) {
                listView.setOnItemClickListener(new AnonymousClass3(aVar2, a));
            } else if (aVar2.Gr != null) {
                listView.setOnItemClickListener(new AnonymousClass4(aVar2, listView, a));
            }
            if (aVar2.Gu != null) {
                listView.setOnItemSelectedListener(aVar2.Gu);
            }
            if (aVar2.Gq) {
                listView.setChoiceMode(1);
            } else if (aVar2.Gp) {
                listView.setChoiceMode(2);
            }
            a.Fv = listView;
        }
        if (aVar2.mView != null) {
            if (aVar2.FB) {
                View view2 = aVar2.mView;
                int i3 = aVar2.Fx;
                int i4 = aVar2.Fy;
                int i5 = aVar2.Fz;
                int i6 = aVar2.FA;
                a.mView = view2;
                a.Fw = 0;
                a.FB = true;
                a.Fx = i3;
                a.Fy = i4;
                a.Fz = i5;
                a.FA = i6;
            } else {
                a.mView = aVar2.mView;
                a.Fw = 0;
                a.FB = false;
            }
        } else if (aVar2.Fw != 0) {
            i = aVar2.Fw;
            a.mView = null;
            a.Fw = i;
            a.FB = false;
        }
        cVar.setCancelable(aVar.GD.pY);
        if (aVar.GD.pY) {
            cVar.setCanceledOnTouchOutside(true);
        }
        cVar.setOnCancelListener(aVar.GD.Gj);
        cVar.setOnDismissListener(aVar.GD.Gk);
        if (aVar.GD.Gl != null) {
            cVar.setOnKeyListener(aVar.GD.Gl);
        }
        gVar.LA = cVar;
        gVar.LA.setOnDismissListener(gVar);
        LayoutParams attributes = gVar.LA.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        gVar.LA.show();
        if (this.ef != null) {
            this.ef.d(pVar);
        }
        return true;
    }

    public final void a(f fVar, boolean z) {
        if (this.ef != null) {
            this.ef.a(fVar, z);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eg.a(this.Lb.aE(i), (l) this, 0);
    }

    public final boolean D() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }

    public final Parcelable onSaveInstanceState() {
        if (this.KY == null) {
            return null;
        }
        Parcelable bundle = new Bundle();
        SparseArray sparseArray = new SparseArray();
        if (this.KY != null) {
            this.KY.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.KY.restoreHierarchyState(sparseParcelableArray);
        }
    }
}
