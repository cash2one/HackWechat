package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.R$styleable;

final class c extends o<a> {
    private static short onm = (short) 1;
    private static short onn = (short) 2;
    private static short ono = (short) 3;
    private static short onp = (short) 4;
    private MMActivity fmM;
    int hKb;
    int kUH;
    private LayoutInflater nny;
    private short[] onq;
    private List<String> onr;
    String ons = "";
    e ont;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (a) obj;
        if (obj == null) {
            obj = new a();
        }
        obj.b(cursor);
        return obj;
    }

    public c(Context context) {
        super(context, new a());
        this.fmM = (MMActivity) context;
        this.onr = new LinkedList();
        this.kUH = 10;
        this.hKb = this.kUH;
        this.nny = v.fv(context);
    }

    protected final void Xz() {
        Xy();
    }

    public final boolean awe() {
        return this.kUH >= this.hKb;
    }

    public final void Xy() {
        int i;
        Cursor a = h.aYD().hhp.a("SELECT count(*) FROM massendinfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        this.hKb = i;
        b aYD = h.aYD();
        int i2 = this.kUH;
        String str = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + i2 + " offset (SELECT count(*) FROM massendinfo ) -" + i2;
        x.v("MicroMsg.MasSendInfoStorage", "getCursor sql:" + str);
        setCursor(aYD.hhp.a(str, null, 0));
        i = getCount();
        if (i > 0) {
            this.onq = new short[i];
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        a aVar;
        CharSequence charSequence;
        a aVar2 = (a) getItem(i);
        if (i != 0) {
            long j = ((a) getItem(i - 1)).hVE;
            aVar2 = (a) getItem(i);
            long j2 = aVar2.hVE;
            obj = j2 - j < 60000 ? 1 : null;
            Object obj2 = (j2 - j) / 180000 < 1 ? 1 : null;
            if (obj == null && obj2 == null) {
                this.onq[i] = (short) 1;
                aVar = aVar2;
            } else {
                this.onq[i] = (short) 2;
                aVar = aVar2;
            }
        } else {
            this.onq[i] = (short) 1;
            aVar = aVar2;
        }
        obj = (this.onq[i] != (short) 1 || aVar.hVE <= 1000) ? null : 1;
        f fVar;
        switch (aVar.msgType) {
            case 1:
                fVar = new f();
                if (view == null || ((f) view.getTag()).onC != onm) {
                    view = this.nny.inflate(R.i.dnb, null);
                    fVar.onv = (TextView) view.findViewById(R.h.cve);
                    fVar.onw = (TextView) view.findViewById(R.h.cvg);
                    fVar.onx = (TextView) view.findViewById(R.h.cvh);
                    fVar.onz = (TextView) view.findViewById(R.h.cvc);
                    fVar.nou = (TextView) view.findViewById(R.h.cvm);
                    fVar.onB = view.findViewById(R.h.cvd);
                    fVar.onC = onm;
                    view.setTag(fVar);
                    break;
                }
            case 3:
                fVar = new f();
                if (view == null || ((f) view.getTag()).onC != onn) {
                    view = this.nny.inflate(R.i.dna, null);
                    fVar.onv = (TextView) view.findViewById(R.h.cve);
                    fVar.onw = (TextView) view.findViewById(R.h.cvg);
                    fVar.msx = (ImageView) view.findViewById(R.h.cvi);
                    fVar.onz = (TextView) view.findViewById(R.h.cvc);
                    fVar.nou = (TextView) view.findViewById(R.h.cvm);
                    fVar.onB = view.findViewById(R.h.cvd);
                    fVar.onC = onn;
                    view.setTag(fVar);
                    break;
                }
            case 34:
                fVar = new f();
                if (view == null || ((f) view.getTag()).onC != onp) {
                    view = this.nny.inflate(R.i.dnd, null);
                    fVar.onv = (TextView) view.findViewById(R.h.cve);
                    fVar.onw = (TextView) view.findViewById(R.h.cvg);
                    fVar.ony = (TextView) view.findViewById(R.h.cvf);
                    fVar.onx = (TextView) view.findViewById(R.h.cvl);
                    fVar.onA = (AnimImageView) view.findViewById(R.h.cvk);
                    fVar.onz = (TextView) view.findViewById(R.h.cvc);
                    fVar.nou = (TextView) view.findViewById(R.h.cvm);
                    fVar.onB = view.findViewById(R.h.cvd);
                    fVar.onC = onp;
                    view.setTag(fVar);
                    break;
                }
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                fVar = new f();
                if (view == null || ((f) view.getTag()).onC != ono) {
                    view = this.nny.inflate(R.i.dnc, null);
                    fVar.onv = (TextView) view.findViewById(R.h.cve);
                    fVar.onw = (TextView) view.findViewById(R.h.cvg);
                    fVar.msx = (ImageView) view.findViewById(R.h.cvi);
                    fVar.ony = (TextView) view.findViewById(R.h.cvj);
                    fVar.onz = (TextView) view.findViewById(R.h.cvc);
                    fVar.nou = (TextView) view.findViewById(R.h.cvm);
                    fVar.onB = view.findViewById(R.h.cvd);
                    fVar.onC = ono;
                    view.setTag(fVar);
                    break;
                }
        }
        f fVar2 = (f) view.getTag();
        if (obj != null) {
            fVar2.nou.setVisibility(0);
            fVar2.nou.setText(n.c(this.fmM, aVar.hVE, false));
        } else {
            fVar2.nou.setVisibility(8);
        }
        switch (aVar.msgType) {
            case 1:
                fVar2 = (f) view.getTag();
                fVar2.onx.setText(aVar.aYw());
                i.f(fVar2.onx, 1);
                break;
            case 3:
                fVar2 = (f) view.getTag();
                ar.Hg();
                if (com.tencent.mm.z.c.isSDCardAvailable()) {
                    h.aYD();
                    Bitmap Ed = b.Ed(aVar.aYw());
                    if (Ed != null) {
                        fVar2.msx.setImageBitmap(Ed);
                    } else {
                        h.aYD();
                        fVar2.msx.setImageBitmap(b.a(aVar.aYx(), com.tencent.mm.bv.a.getDensity(fVar2.msx.getContext())));
                    }
                } else {
                    fVar2.msx.setImageDrawable(com.tencent.mm.bv.a.b(this.fmM, R.g.bEi));
                }
                fVar2.msx.setOnClickListener(new a(this, aVar.aYw(), aVar.omT));
                break;
            case 34:
                fVar2 = (f) view.getTag();
                float bv = q.bv((long) aVar.omP);
                if (aVar.aYv().equals(this.ons)) {
                    fVar2.onA.setVisibility(0);
                    fVar2.onA.coI();
                    fVar2.onx.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else {
                    fVar2.onA.setVisibility(8);
                    fVar2.onA.bnk();
                    fVar2.onx.setCompoundDrawablesWithIntrinsicBounds(null, null, this.fmM.getResources().getDrawable(R.k.dxK), null);
                }
                fVar2.ony.setText(this.fmM.getString(R.l.ejo, new Object[]{Integer.valueOf((int) bv)}));
                fVar2.onx.setWidth(com.tencent.mm.bv.a.fromDPToPix(fVar2.onx.getContext(), nr((int) bv)));
                fVar2.onA.setWidth(com.tencent.mm.bv.a.fromDPToPix(fVar2.onx.getContext(), nr((int) bv)));
                fVar2.onx.setOnClickListener(new d(this, aVar.aYv()));
                break;
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                f fVar3 = (f) view.getTag();
                com.tencent.mm.modelvideo.o.TU();
                Bitmap a = com.tencent.mm.aq.o.Pw().a(s.nu(aVar.aYw()), com.tencent.mm.bv.a.getDensity(fVar3.msx.getContext()), this.fmM);
                if (a == null) {
                    ar.Hg();
                    if (com.tencent.mm.z.c.isSDCardAvailable()) {
                        fVar3.msx.setImageDrawable(com.tencent.mm.bv.a.b(this.fmM, R.e.bsI));
                    } else {
                        fVar3.msx.setImageDrawable(com.tencent.mm.bv.a.b(this.fmM, R.k.dBw));
                    }
                } else {
                    fVar3.msx.setImageBitmap(a);
                }
                fVar3.msx.setOnClickListener(new c(this, aVar.aYw(), aVar.omS, aVar.fdR, aVar.omP));
                if (aVar.omS != 2) {
                    fVar3.ony.setVisibility(0);
                    fVar3.ony.setText(bh.iW(aVar.omP));
                    break;
                }
                fVar3.ony.setVisibility(8);
                break;
        }
        fVar2 = (f) view.getTag();
        fVar2.onv.setText(this.fmM.getResources().getQuantityString(R.j.duA, aVar.omO, new Object[]{Integer.valueOf(aVar.omO)}));
        if (this.onr.contains(aVar.aYv())) {
            fVar2.onw.setSingleLine(false);
            fVar2.onw.setEllipsize(null);
        } else {
            fVar2.onw.setSingleLine(true);
            fVar2.onw.setEllipsize(TruncateAt.END);
        }
        TextView textView = fVar2.onw;
        Context context = this.fmM;
        ArrayList arrayList = new ArrayList();
        if (aVar.aYy() == null || aVar.aYy().equals("")) {
            charSequence = "";
        } else {
            List F;
            String[] split = aVar.aYy().split(";");
            if (split == null || split.length <= 0) {
                Object obj3 = arrayList;
            } else {
                F = bh.F(split);
            }
            if (F == null) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 = 0; i2 < F.size(); i2++) {
                    String gu = r.gu((String) F.get(i2));
                    if (i2 == F.size() - 1) {
                        stringBuilder.append(gu);
                    } else {
                        stringBuilder.append(gu + ", ");
                    }
                }
                charSequence = stringBuilder.toString();
            }
        }
        textView.setText(i.b(context, charSequence, fVar2.onw.getTextSize()));
        int textSize = (int) fVar2.onw.getTextSize();
        String charSequence2 = fVar2.onw.getText().toString();
        com.tencent.mm.bv.a.fromDPToPix(this.fmM, 255);
        Paint paint = new Paint();
        paint.setTextSize((float) textSize);
        paint.measureText(charSequence2);
        fVar2.onz.setOnClickListener(new b(this, aVar.aYv()));
        return view;
    }

    public final void Eh(String str) {
        this.ons = str;
        notifyDataSetChanged();
    }

    private static int nr(int i) {
        if (i <= 2) {
            return 100;
        }
        if (i < 10) {
            return ((i - 2) * 8) + 100;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 8) + 100;
        }
        return d.CTRL_INDEX;
    }
}
