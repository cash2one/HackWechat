package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.telephony.PhoneNumberUtils;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.method.NumberKeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class MallEditText extends LinearLayout implements OnFocusChangeListener {
    private int gravity;
    private TextView iiQ;
    private OnFocusChangeListener imO;
    ImageView imR;
    private String imS;
    String imT;
    int imU;
    public boolean imW;
    boolean imY;
    private int imZ;
    private int imeOptions;
    private int ina;
    private int inputType;
    b pCo;
    AutoCompleteTextView pCp;
    boolean pCq;
    private a pCr;
    private boolean pCs;
    private List<String[]> pCt;
    private com.tencent.mm.plugin.recharge.model.a pCu;
    private Runnable pCv;
    private boolean pCw;
    private int pCx;

    private class a extends BaseAdapter implements Filterable {
        public boolean pCA;
        private List<com.tencent.mm.plugin.recharge.model.a> pCB;
        private a pCC;
        private String pCD;
        final /* synthetic */ MallEditText pCy;
        public List<com.tencent.mm.plugin.recharge.model.a> pCz;

        private a(MallEditText mallEditText) {
            this.pCy = mallEditText;
            this.pCz = new ArrayList();
            this.pCA = false;
        }

        public final /* synthetic */ Object getItem(int i) {
            return vl(i);
        }

        public final void bt(List<com.tencent.mm.plugin.recharge.model.a> list) {
            this.pCB = list;
            this.pCz.clear();
            this.pCA = false;
        }

        public final Filter getFilter() {
            x.d("MicroMsg.MallEditText", "getFilter");
            if (this.pCC == null) {
                this.pCC = new a(this, (byte) 0);
            }
            return this.pCC;
        }

        public final int getCount() {
            if (this.pCA) {
                return this.pCz.size() + 2;
            }
            return this.pCz.size() > 0 ? this.pCz.size() + 1 : 0;
        }

        public final synchronized com.tencent.mm.plugin.recharge.model.a vl(int i) {
            com.tencent.mm.plugin.recharge.model.a aVar = null;
            synchronized (this) {
                if (this.pCA) {
                    if (i != 0) {
                        if (i <= this.pCz.size()) {
                            aVar = (com.tencent.mm.plugin.recharge.model.a) this.pCz.get(i - 1);
                        }
                    }
                } else if (i < this.pCz.size()) {
                    aVar = (com.tencent.mm.plugin.recharge.model.a) this.pCz.get(i);
                }
            }
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    c cVar;
                    if (view == null) {
                        view = View.inflate(this.pCy.getContext(), a$g.uDR, null);
                        c cVar2 = new c(this.pCy, (byte) 0);
                        cVar2.pCH = (TextView) view.findViewById(f.uqc);
                        cVar2.inw = (TextView) view.findViewById(f.uqb);
                        view.setTag(cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (c) view.getTag();
                    }
                    com.tencent.mm.plugin.recharge.model.a vl = vl(i);
                    if (vl == null || cVar == null || cVar.pCH == null || cVar.inw == null) {
                        return view;
                    }
                    CharSequence Ie = b.Ie(vl.pBH);
                    x.d("MicroMsg.MallEditText", "record.record " + Ie + ", record.name " + vl.name);
                    if (com.tencent.mm.plugin.recharge.model.a.pBF.equals(vl.pBJ)) {
                        cVar.pCH.setText(Ie);
                    } else {
                        CharSequence spannableStringBuilder = new SpannableStringBuilder(Ie);
                        for (int i2 : vl.pBJ) {
                            int i22;
                            if (i22 >= 0) {
                                if (i22 >= 7) {
                                    i22 += 2;
                                } else if (i22 >= 3) {
                                    i22++;
                                }
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), i22, i22 + 1, 34);
                            }
                        }
                        cVar.pCH.setText(spannableStringBuilder);
                    }
                    if (vl.name == null || bh.ov(vl.name.trim())) {
                        cVar.inw.setText("");
                    } else {
                        cVar.inw.setText(this.pCy.getResources().getString(a$i.uLX, new Object[]{vl.name}));
                    }
                    view.setBackgroundResource(e.bBx);
                    return view;
                case 1:
                    view = View.inflate(this.pCy.getContext(), a$g.uDS, null);
                    view.setOnClickListener(new 2(this));
                    return view;
                case 2:
                    view = View.inflate(this.pCy.getContext(), a$g.uDQ, null);
                    view.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a pCE;

                        {
                            this.pCE = r1;
                        }

                        public final void onClick(View view) {
                            this.pCE.pCy.pCp.dismissDropDown();
                        }
                    });
                    return view;
                case 3:
                    View inflate = View.inflate(this.pCy.getContext(), a$g.uDS, null);
                    ((TextView) inflate).setText(a$i.uLO);
                    inflate.setOnClickListener(new 3(this));
                    return inflate;
                default:
                    return view;
            }
        }

        public final int getItemViewType(int i) {
            if (this.pCA) {
                if (i == 0) {
                    return 2;
                }
                if (i > this.pCz.size()) {
                    return 3;
                }
                return 0;
            } else if (i >= this.pCz.size()) {
                return 1;
            } else {
                return 0;
            }
        }

        public final int getViewTypeCount() {
            return 4;
        }
    }

    public MallEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.pCr = null;
        this.imS = "";
        this.imT = "";
        this.inputType = 1;
        this.pCs = true;
        this.ina = -1;
        this.imZ = 1;
        this.gravity = 19;
        this.imU = -1;
        this.imY = false;
        this.pCu = null;
        this.imW = true;
        this.pCv = null;
        this.pCw = false;
        this.pCx = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$k.uYS, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(a$k.uYZ, 0);
        if (resourceId != 0) {
            this.imS = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(a$k.uZa, 0);
        if (resourceId != 0) {
            this.imT = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(a$k.uYX, 1);
        this.imW = obtainStyledAttributes.getBoolean(a$k.uYW, true);
        this.gravity = obtainStyledAttributes.getInt(a$k.uYT, 19);
        this.pCs = obtainStyledAttributes.getBoolean(a$k.uYU, true);
        this.ina = obtainStyledAttributes.getInteger(a$k.uYV, -1);
        this.imU = obtainStyledAttributes.getInteger(a$k.uZb, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(a$k.uYY, 5);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(a$g.uDP, this, true);
        this.iiQ = (TextView) inflate.findViewById(f.cUq);
        this.pCp = (AutoCompleteTextView) inflate.findViewById(f.coA);
        if (com.tencent.mm.bv.a.ey(context)) {
            this.pCp.setTextSize(0, ((float) context.getResources().getDimensionPixelSize(d.bvK)) * 1.25f);
        } else {
            this.pCp.setTextSize(0, (float) com.tencent.mm.bv.a.aa(context, d.bvK));
        }
        this.imR = (ImageView) inflate.findViewById(f.cpN);
        x.d("MicroMsg.MallEditText", "setFormat editType:" + this.imU);
        this.pCp.setImeOptions(this.imeOptions);
        switch (this.imU) {
            case 0:
                if (!this.imW) {
                    this.imR.setImageResource(e.udh);
                    this.imR.setVisibility(0);
                    break;
                }
                break;
            case 1:
                this.imZ = 13;
                this.ina = 13;
                this.inputType = 2;
                vk(e.udC);
                this.imR.setVisibility(0);
                break;
        }
        this.inputType = 1;
        this.pCp.addTextChangedListener(new 1(this));
        this.pCp.setOnFocusChangeListener(this);
        if (!bh.ov(this.imS)) {
            this.pCp.setHint(this.imS);
        }
        if (this.inputType == 2) {
            this.pCp.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ MallEditText pCy;

                {
                    this.pCy = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
                }
            });
        } else {
            this.pCp.setInputType(this.inputType);
            this.pCp.setRawInputType(this.inputType);
        }
        this.pCp.setGravity(this.gravity);
        if (!this.pCs) {
            this.pCp.setEnabled(false);
            this.pCp.setTextColor(getResources().getColor(c.black));
            this.pCp.setFocusable(false);
            this.pCp.setClickable(false);
        }
        if (this.imW) {
            this.imY = false;
        } else {
            this.imY = true;
            this.pCp.setEnabled(false);
            this.pCp.setFocusable(false);
            this.pCp.setClickable(false);
        }
        if (this.ina != -1) {
            this.pCp.setFilters(new InputFilter[]{new LengthFilter(this.ina)});
        }
        x.d("MicroMsg.MallEditText", "initData editType:" + this.imU);
        switch (this.imU) {
            case 1:
                x.d("MicroMsg.MallEditText", "setMobileEditTv");
                List bms = com.tencent.mm.plugin.recharge.a.a.bmr().bms();
                this.pCr = new a();
                this.pCr.bt(bms);
                if (bms != null && bms.size() > 0) {
                    this.pCu = (com.tencent.mm.plugin.recharge.model.a) bms.get(0);
                    b(this.pCu);
                } else if (this.pCt == null) {
                    new Runnable(this) {
                        final /* synthetic */ MallEditText pCy;

                        {
                            this.pCy = r1;
                        }

                        public final void run() {
                            try {
                                this.pCy.pCt = com.tencent.mm.pluginsdk.a.bV(this.pCy.getContext());
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                            }
                        }
                    }.run();
                }
                if (bms == null || bms.size() == 0) {
                    g.Dk();
                    this.pCp.setText((String) g.Dj().CU().get(6, null));
                    this.pCp.setSelection(this.pCp.getText().length());
                    bmv();
                }
                this.pCp.setAdapter(this.pCr);
                this.pCp.setOnItemClickListener(new 4(this));
                return;
            default:
                return;
        }
    }

    public MallEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void vk(int i) {
        this.pCq = i == e.bDo;
        this.imR.setImageResource(i);
    }

    public final void b(com.tencent.mm.plugin.recharge.model.a aVar) {
        this.pCu = aVar;
        if (aVar != null) {
            this.pCp.setText(aVar.pBH);
            this.pCp.setSelection(this.pCp.getText().length());
            bmv();
            x.d("MicroMsg.MallEditText", "editTv.setText " + aVar.pBH + ", name " + aVar.name + ", isInputValid " + this.imY);
            if (bh.ov(aVar.name) || !this.imY) {
                this.iiQ.setText("");
                this.iiQ.setVisibility(8);
                return;
            }
            this.iiQ.setText(aVar.name);
            this.iiQ.setVisibility(0);
            return;
        }
        this.pCp.setText("");
        bmv();
        x.d("MicroMsg.MallEditText", "editTv.setText null");
        this.iiQ.setText("");
        this.iiQ.setVisibility(8);
    }

    private void bmv() {
        boolean XO = XO();
        if (XO != this.imY) {
            x.d("MicroMsg.MallEditText", "View:" + this.imT + ", editType:" + this.imU + " inputValid change to " + XO);
            this.imY = XO;
            if (this.pCo != null) {
                this.pCo.hx(this.imY);
            }
            if (!XO) {
                if (this.iiQ.getVisibility() == 0) {
                    this.iiQ.setText("");
                    this.iiQ.setVisibility(8);
                }
                this.pCu = null;
            }
        }
        if (this.pCo != null) {
            this.pCo.bmx();
        }
    }

    public final String getText() {
        switch (this.imU) {
            case 1:
                return bh.az(this.pCp.getText().toString(), "");
            default:
                return bh.az(this.pCp.getText().toString(), "");
        }
    }

    public final boolean XO() {
        switch (this.imU) {
            case 1:
                String obj = this.pCp.getText().toString();
                if (obj.length() < this.imZ || obj.length() > this.ina || !PhoneNumberUtils.isGlobalPhoneNumber(b.Id(obj))) {
                    return false;
                }
                return true;
            default:
                if (this.pCp.getText().length() >= this.imZ) {
                    return true;
                }
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.imW) {
            return false;
        }
        return true;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.pCp.setOnClickListener(onClickListener);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.imO = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.imO != null) {
            this.imO.onFocusChange(this, z);
        }
        if (!((!this.pCw) != z || z || this.pCv == null)) {
            this.pCv.run();
        }
        this.pCw = z;
        x.d("MicroMsg.MallEditText", "View:" + this.imT + ", editType:" + this.imU + " onFocusChange to " + z);
        if (this.pCo != null) {
            this.pCo.hx(this.imY);
        }
    }

    public final com.tencent.mm.plugin.recharge.model.a bmw() {
        if (this.pCu != null) {
            return this.pCu;
        }
        this.pCu = new com.tencent.mm.plugin.recharge.model.a(getText(), this.iiQ.getText().toString(), 0);
        return this.pCu;
    }
}
