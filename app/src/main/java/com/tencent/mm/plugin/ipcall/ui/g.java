package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.ipcall.a.d.m;
import com.tencent.mm.plugin.ipcall.a.e;
import com.tencent.mm.plugin.ipcall.a.e.d;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.pluginsdk.i.a.b.b;
import com.tencent.mm.protocal.c.bwm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.PasterEditText;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g extends Dialog {
    private ScrollView jjn;
    View kND;
    private Activity mActivity;
    private Context mContext;
    private af mHandler = new af();
    private ArrayList<a> mItemList;
    private OnClickListener mOnClickListener = new 3(this);
    private int muB = R.e.bsn;
    private int muC = R.g.bCg;
    private int nJV = 0;
    private int nJW;
    private long nJX;
    private LinearLayout nJY;
    private LinearLayout nJZ;
    private RelativeLayout nKa;
    private RelativeLayout nKb;
    private RelativeLayout nKc;
    private ImageView nKd;
    private ImageView nKe;
    private ImageView nKf;
    private int nKg;
    private FrameLayout nKh;
    private FlowLayout nKi;
    private Button nKj;
    private Button nKk;
    private PasterEditText nKl;
    private Button nKm;
    private Button nKn;
    private TextView nKo;
    private Animation nKp;
    private int nKq = R.g.bCf;
    private int nKr = R.e.buj;
    private CharSequence uU;

    static /* synthetic */ void a(g gVar, TextView textView) {
        a aVar = (a) textView.getTag();
        textView.setTextSize(0, gVar.getContext().getResources().getDimension(R.f.bxj) * a.eu(gVar.getContext()));
        if (aVar.nKu) {
            textView.setBackgroundResource(gVar.nKq);
            textView.setTextColor(gVar.mContext.getResources().getColor(gVar.nKr));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            return;
        }
        textView.setBackgroundResource(gVar.muC);
        textView.setTextColor(gVar.mContext.getResources().getColor(gVar.muB));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    static /* synthetic */ void g(g gVar) {
        ar.CG().a(new m(gVar.nJW, gVar.nKg, gVar.rB(gVar.nKg)), 0);
        if (gVar.nKg == 3) {
            gVar.rC(2);
            return;
        }
        gVar.hide();
        gVar.mHandler.postDelayed(new 9(gVar), 1800);
        com.tencent.mm.ui.snackbar.a.h(gVar.mActivity, gVar.mContext.getString(R.l.erC));
        d.a(1, -1, gVar.nKg, gVar.rA(gVar.nKg), 0, -1, -1, gVar.nJW, gVar.nJX);
    }

    public g(Activity activity, Context context, int i, long j) {
        CharSequence format;
        super(context, R.m.eYV);
        setCancelable(false);
        this.mContext = context;
        this.nJW = i;
        this.nJX = j;
        this.mActivity = activity;
        this.kND = View.inflate(this.mContext, R.i.dmj, null);
        this.nJY = (LinearLayout) this.kND.findViewById(R.h.csA);
        this.nJZ = (LinearLayout) this.kND.findViewById(R.h.csB);
        this.nKp = AnimationUtils.loadAnimation(ac.getContext(), R.a.bpO);
        this.nKp.setDuration(200);
        this.nKp.setStartOffset(100);
        aUw();
        this.nKa = (RelativeLayout) this.kND.findViewById(R.h.csE);
        this.nKb = (RelativeLayout) this.kND.findViewById(R.h.csF);
        this.nKc = (RelativeLayout) this.kND.findViewById(R.h.csG);
        this.nKa.setOnClickListener(this.mOnClickListener);
        this.nKb.setOnClickListener(this.mOnClickListener);
        this.nKc.setOnClickListener(this.mOnClickListener);
        this.nKd = (ImageView) this.kND.findViewById(R.h.cpC);
        this.nKe = (ImageView) this.kND.findViewById(R.h.cpD);
        this.nKf = (ImageView) this.kND.findViewById(R.h.cpE);
        this.nKg = 0;
        rz(this.nKg);
        this.nKm = (Button) this.kND.findViewById(R.h.cpU);
        this.nKn = (Button) this.kND.findViewById(R.h.cpV);
        this.nKo = (TextView) this.kND.findViewById(R.h.cpW);
        if (c.aUQ() != null) {
            format = String.format(this.mContext.getString(R.l.esb), new Object[]{r0.wpy});
        } else {
            format = null;
        }
        if (bh.ov(format)) {
            this.nKo.setVisibility(4);
        } else {
            this.nKo.setVisibility(0);
            this.nKo.setText(format);
        }
        this.nKm.setOnClickListener(new 7(this));
        this.nKn.setOnClickListener(new 8(this));
        this.jjn = (ScrollView) this.kND.findViewById(R.h.chy);
        View childAt = ((ViewGroup) this.mActivity.findViewById(16908290)).getChildAt(0);
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new 1(this, childAt));
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.kND);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        rC(0);
    }

    private void rz(int i) {
        this.nKg = i;
        if (i == 0) {
            this.nKd.setVisibility(4);
            this.nKe.setVisibility(4);
            this.nKf.setVisibility(4);
            this.nKk.setEnabled(false);
            rC(0);
        } else if (i == 1) {
            this.nKd.setVisibility(0);
            this.nKe.setVisibility(4);
            this.nKf.setVisibility(4);
            this.nKk.setEnabled(true);
            rC(1);
        } else if (i == 2) {
            this.nKd.setVisibility(0);
            this.nKe.setVisibility(0);
            this.nKf.setVisibility(4);
            this.nKk.setEnabled(true);
            rC(1);
        } else if (i == 3) {
            this.nKd.setVisibility(0);
            this.nKe.setVisibility(0);
            this.nKf.setVisibility(0);
            this.nKk.setEnabled(true);
            rC(0);
        }
    }

    private void aUw() {
        String ex;
        f fVar;
        this.nKh = (FrameLayout) this.kND.findViewById(R.h.cim);
        this.nKi = (FlowLayout) this.kND.findViewById(R.h.cil);
        this.nKj = (Button) this.kND.findViewById(R.h.bWO);
        this.nKk = (Button) this.kND.findViewById(R.h.bWP);
        this.nKl = (PasterEditText) this.kND.findViewById(R.h.bWU);
        this.nKj.setOnClickListener(new 4(this));
        this.nKk.setOnClickListener(new 5(this));
        e aTq = e.aTq();
        if (aTq.nCx == null) {
            x.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
            b.c.bZm();
            ex = b.ex(39, 1);
            if (bh.ov(ex)) {
                x.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
            } else {
                byte[] e = com.tencent.mm.a.e.e(ex, 0, -1);
                if (e != null) {
                    aTq.az(e);
                } else {
                    x.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
                }
            }
        }
        if (aTq.nCx != null) {
            String str;
            ex = w.e(ac.getContext().getSharedPreferences(ac.cfs(), 0));
            if (!"language_default".equalsIgnoreCase(ex) || Locale.getDefault() == null) {
                str = ex;
            } else {
                str = Locale.getDefault().toString();
            }
            Iterator it = aTq.nCx.iterator();
            while (it.hasNext()) {
                fVar = (f) it.next();
                if (str.equalsIgnoreCase(fVar.nGL)) {
                    x.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[]{str, Integer.valueOf(aTq.nCx.size())});
                    break;
                }
            }
            x.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[]{str, Integer.valueOf(aTq.nCx.size())});
        }
        fVar = null;
        if (fVar != null) {
            ArrayList arrayList = fVar.nGM;
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.tencent.mm.plugin.ipcall.a.g.e eVar = (com.tencent.mm.plugin.ipcall.a.g.e) it2.next();
                a aVar = new a();
                aVar.nGJ = eVar.nGJ;
                aVar.nGK = eVar.nGK;
                aVar.nKu = false;
                arrayList2.add(aVar);
            }
            this.mItemList = arrayList2;
            Iterator it3 = this.mItemList.iterator();
            while (it3.hasNext()) {
                a aVar2 = (a) it3.next();
                FlowLayout flowLayout = this.nKi;
                View textView = new TextView(getContext());
                textView.setTextSize(0, getContext().getResources().getDimension(R.f.bxj) * a.eu(getContext()));
                textView.setBackgroundResource(this.muC);
                textView.setTextColor(this.mContext.getResources().getColor(this.muB));
                textView.setTag(aVar2);
                textView.setGravity(17);
                textView.setEllipsize(TruncateAt.END);
                textView.setSingleLine();
                textView.setText(aVar2.nGK);
                textView.setOnClickListener(new 6(this));
                flowLayout.addView(textView);
            }
        }
    }

    private String rA(int i) {
        String str = "";
        if (i == 3) {
            return "";
        }
        if (!bh.ov(this.nKl.getText().toString().trim())) {
            str = "0";
        }
        if (this.mItemList == null) {
            return str;
        }
        Iterator it = this.mItemList.iterator();
        String str2 = str;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!aVar.nKu) {
                str = str2;
            } else if (str2.equals("")) {
                str2 = aVar.nGJ;
            } else {
                str = str2 + "_" + aVar.nGJ;
            }
            str2 = str;
        }
        return str2;
    }

    private LinkedList<bwm> rB(int i) {
        LinkedList<bwm> linkedList = new LinkedList();
        if (i == 3) {
            return linkedList;
        }
        String trim = this.nKl.getText().toString().trim();
        if (!bh.ov(trim)) {
            bwm com_tencent_mm_protocal_c_bwm = new bwm();
            com_tencent_mm_protocal_c_bwm.fgt = 0;
            com_tencent_mm_protocal_c_bwm.nje = trim;
            linkedList.add(com_tencent_mm_protocal_c_bwm);
        }
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.nKu) {
                    bwm com_tencent_mm_protocal_c_bwm2 = new bwm();
                    try {
                        com_tencent_mm_protocal_c_bwm2.fgt = bh.getInt(aVar.nGJ, 0);
                        linkedList.add(com_tencent_mm_protocal_c_bwm2);
                    } catch (NumberFormatException e) {
                        x.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + aVar.nGJ);
                    }
                }
            }
        }
        return linkedList;
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.uU = charSequence;
        } else {
            this.uU = null;
        }
    }

    public final void show() {
        super.show();
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    private void rC(int i) {
        if (i == 0) {
            this.nJY.setVisibility(0);
            this.nJZ.setVisibility(4);
            if (this.nJV == 1) {
                ((LayoutParams) this.nKh.getLayoutParams()).height = 0;
                this.nKh.requestLayout();
            }
            bh.hideVKB(this.kND);
        } else if (i == 1) {
            this.nJY.setVisibility(0);
            this.nJZ.setVisibility(4);
            if (this.nJV == 0) {
                ((LayoutParams) this.nKh.getLayoutParams()).height = -2;
                this.nKh.requestLayout();
                this.nKh.startAnimation(this.nKp);
            }
        } else if (i == 2) {
            this.nJY.setVisibility(4);
            this.nJZ.setVisibility(0);
            bh.hideVKB(this.kND);
        }
        this.nJV = i;
    }
}
