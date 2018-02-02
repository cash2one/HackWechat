package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.by.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import java.util.List;

public final class a extends o<f> {
    public static final ColorStateList nPr = com.tencent.mm.bv.a.Z(ac.getContext(), R.e.bth);
    public static final ColorStateList nPs = com.tencent.mm.bv.a.Z(ac.getContext(), R.e.bsO);
    List<String> nPt;

    protected static class a {
        public AddressView nPw;

        public a(View view) {
            this.nPw = (AddressView) view.findViewById(R.h.cyz);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return rK(i);
    }

    public a(Context context) {
        super(context, new f());
    }

    public final int getCount() {
        return super.getCount();
    }

    public final f rK(int i) {
        if (qY(i)) {
            return (f) aRG();
        }
        f fVar;
        if (this.xIh != null) {
            fVar = (f) this.xIh.get(Integer.valueOf(i));
            if (fVar != null) {
                return fVar;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        fVar = a(null, getCursor());
        if (this.xIh == null) {
            lU(true);
        }
        if (this.xIh == null) {
            return fVar;
        }
        this.xIh.put(Integer.valueOf(i), fVar);
        return fVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence = null;
        af afVar = rK(i).jLe;
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.context, R.i.deR, null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        b.a(aVar.nPw, afVar.field_username);
        if (afVar.field_verifyFlag != 0) {
            String gP = com.tencent.mm.z.ak.a.hfN.gP(afVar.field_verifyFlag);
            if (gP != null) {
                aVar.nPw.setMaskBitmap(m.kf(gP));
            } else {
                aVar.nPw.setMaskBitmap(null);
            }
        } else {
            aVar.nPw.setMaskBitmap(null);
        }
        if (afVar.field_deleteFlag == 1) {
            aVar.nPw.setNickNameTextColor(nPs);
        } else {
            aVar.nPw.setNickNameTextColor(nPr);
        }
        aVar.nPw.updateTextColors();
        CharSequence charSequence2 = afVar.xmu;
        if (charSequence2 == null) {
            try {
                Context context = this.context;
                gP = afVar.field_username;
                charSequence2 = r.gu(afVar.field_username);
                String str = "";
                if (str.length() > 0 && !str.equals(charSequence2)) {
                    StringBuilder stringBuilder = new StringBuilder(32);
                    stringBuilder.append(charSequence2);
                    stringBuilder.append("(");
                    stringBuilder.append(str);
                    stringBuilder.append(")");
                    charSequence2 = stringBuilder.toString();
                }
                charSequence = i.b(context, charSequence2, aVar.nPw.getNickNameSize());
            } catch (Exception e) {
            }
            if (charSequence == null) {
                charSequence = "";
            }
            aVar.nPw.setName(charSequence);
            afVar.xmu = charSequence;
        } else {
            aVar.nPw.setName(charSequence2);
        }
        aVar.nPw.updatePositionFlag();
        return view;
    }

    public final synchronized void Xy() {
        Cursor ckM;
        Object obj = Looper.myLooper() == Looper.getMainLooper() ? 1 : null;
        if (this.nPt == null || this.nPt.size() <= 0) {
            ckM = d.ckM();
        } else {
            ar.Hg();
            ckM = c.EY().cK(this.nPt);
        }
        if (obj != null) {
            i(ckM);
        } else {
            ag.y(new 1(this, ckM));
        }
    }

    protected final void Xz() {
        Xy();
    }

    private static f a(f fVar, Cursor cursor) {
        if (fVar == null) {
            fVar = new f();
        }
        ar.Hg();
        x WJ = c.EY().WJ(x.k(cursor));
        if (WJ == null) {
            fVar.jLe.b(cursor);
            ar.Hg();
            c.EY().O(fVar.jLe);
        } else {
            fVar.jLe = WJ;
        }
        return fVar;
    }

    public final void i(Cursor cursor) {
        aUn();
        setCursor(cursor);
        notifyDataSetChanged();
    }
}
