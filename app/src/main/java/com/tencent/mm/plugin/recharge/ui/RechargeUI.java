package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.ui.MallEditText.b;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.adg;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI extends MMActivity implements e, com.tencent.mm.platformtools.j.a, b {
    protected Dialog ilS = null;
    private Button lRZ = null;
    private LinearLayout pDA = null;
    private a pDB = null;
    private a pDC = null;
    private MallEditText pDD;
    private TextView pDE;
    private int pDF;
    private MallRechargeProduct pDG = null;
    private String pDH = null;
    private MallNews pDI = null;
    private boolean pDJ = false;
    private boolean pDK = true;
    private Map<String, Integer> pDL = new HashMap();
    private String pDM;
    public String pDN;
    private String pDO;
    public String pDP;
    private MallFunction pDd = null;
    private TextView pDt = null;
    private TextView pDu = null;
    private TextView pDv = null;
    private TextView pDw = null;
    private FrameLayout pDx = null;
    private ImageView pDy = null;
    private ImageView pDz = null;
    private boolean pfG = false;
    private c pfJ = new 10(this);

    private class a extends BaseAdapter {
        private List<MallRechargeProduct> pBV;
        final /* synthetic */ RechargeUI pDQ;

        private a(RechargeUI rechargeUI) {
            this.pDQ = rechargeUI;
            this.pBV = null;
        }

        public final /* synthetic */ Object getItem(int i) {
            return vo(i);
        }

        public final void bw(List<MallRechargeProduct> list) {
            this.pBV = list;
            notifyDataSetChanged();
        }

        public final void vn(int i) {
            for (int i2 = 0; i2 < this.pBV.size(); i2++) {
                ((MallRechargeProduct) this.pBV.get(i2)).isDefault = false;
            }
            ((MallRechargeProduct) this.pBV.get(i)).isDefault = true;
        }

        public final int getCount() {
            return this.pBV == null ? 0 : this.pBV.size();
        }

        public final MallRechargeProduct vo(int i) {
            return (MallRechargeProduct) this.pBV.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            if (vo(i).isValid()) {
                return super.isEnabled(i);
            }
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.pDQ, g.uDU, null);
            MallRechargeProduct vo = vo(i);
            checkedTextView.setText(vo.lEM);
            checkedTextView.setEnabled(vo.isValid());
            if (vo.isDefault) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ boolean c(RechargeUI rechargeUI) {
        if (rechargeUI.pDD.bmw().fqd != 0) {
            return true;
        }
        Context context = rechargeUI;
        h.a(context, rechargeUI.getString(i.uLP, new Object[]{rechargeUI.pDD.getText().toString()}), "", rechargeUI.getString(i.dHd), rechargeUI.getString(i.dFR), new OnClickListener(rechargeUI) {
            final /* synthetic */ RechargeUI pDQ;

            {
                this.pDQ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.pDQ.n(new com.tencent.mm.plugin.recharge.model.g(this.pDQ.pDG, this.pDQ.bmC()));
            }
        }, null);
        return false;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                final int color = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.ubH);
                final int color2 = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bui);
                View inflate = getLayoutInflater().inflate(g.uDT, null);
                final TextView textView = (TextView) inflate.findViewById(a$f.uuU);
                final ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(a$f.uuY);
                final ListViewInScrollView listViewInScrollView2 = (ListViewInScrollView) inflate.findViewById(a$f.uvc);
                final TextView textView2 = (TextView) inflate.findViewById(a$f.uuV);
                final View findViewById = inflate.findViewById(a$f.uuX);
                final TextView textView3 = (TextView) inflate.findViewById(a$f.uuZ);
                final View findViewById2 = inflate.findViewById(a$f.uvb);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(a$f.uvk);
                LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = (getResources().getDimensionPixelSize(d.ubJ) * this.pDF) + 4;
                relativeLayout.setLayoutParams(layoutParams);
                listViewInScrollView.setAdapter(this.pDB);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ RechargeUI pDQ;

                    {
                        this.pDQ = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.pDQ.dismissDialog(1);
                        x.d("MicroMsg.MallRechargeUI", "onItemClick : " + i);
                        x.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.pDQ.pDG);
                        this.pDQ.pDG = this.pDQ.pDB.vo(i);
                        this.pDQ.pDB.vn(i);
                        this.pDQ.pDB.notifyDataSetChanged();
                        x.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.pDQ.pDG);
                        this.pDQ.au();
                    }
                });
                listViewInScrollView2.setAdapter(this.pDC);
                listViewInScrollView2.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ RechargeUI pDQ;

                    {
                        this.pDQ = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.pDQ.dismissDialog(1);
                        x.d("MicroMsg.MallRechargeUI", "onItemClick : " + i);
                        this.pDQ.pDG = this.pDQ.pDC.vo(i);
                        this.pDQ.pDC.vn(i);
                        this.pDQ.pDC.notifyDataSetChanged();
                        this.pDQ.pDL.remove(RechargeUI.p(this.pDQ.pDG.pBR, this.pDQ.pDG.fqV, this.pDQ.bmD()));
                        this.pDQ.XK();
                        this.pDQ.au();
                    }
                });
                inflate.findViewById(a$f.uuW).setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ RechargeUI pDQ;

                    public final void onClick(View view) {
                        findViewById.setVisibility(0);
                        textView2.setTextColor(color2);
                        listViewInScrollView.setVisibility(0);
                        findViewById2.setVisibility(8);
                        textView3.setTextColor(color);
                        listViewInScrollView2.setVisibility(8);
                        if (this.pDQ.pDB.getCount() == 0) {
                            textView.setVisibility(0);
                        } else {
                            textView.setVisibility(8);
                        }
                    }
                });
                final View view = findViewById2;
                final TextView textView4 = textView3;
                final int i2 = color2;
                final ListViewInScrollView listViewInScrollView3 = listViewInScrollView2;
                final View view2 = findViewById;
                final TextView textView5 = textView2;
                final int i3 = color;
                final ListViewInScrollView listViewInScrollView4 = listViewInScrollView;
                final TextView textView6 = textView;
                inflate.findViewById(a$f.uva).setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ RechargeUI pDQ;

                    public final void onClick(View view) {
                        view.setVisibility(0);
                        textView4.setTextColor(i2);
                        listViewInScrollView3.setVisibility(0);
                        view2.setVisibility(8);
                        textView5.setTextColor(i3);
                        listViewInScrollView4.setVisibility(8);
                        if (this.pDQ.pDC.getCount() == 0) {
                            textView6.setVisibility(0);
                        } else {
                            textView6.setVisibility(8);
                        }
                    }
                });
                if (this.pDB.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this);
                aVar.YF(null);
                aVar.dk(inflate);
                aVar.d(null);
                return aVar.akx();
            default:
                return h.b(this, getString(i.uLU), "", true);
        }
    }

    protected final int getLayoutId() {
        return g.uDW;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.pDd = (MallFunction) intent.getParcelableExtra("key_func_info");
        List parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_product_list");
        this.pDK = !intent.getBooleanExtra("key_is_hide_progress", false);
        if (this.pDd == null) {
            x.e("MicroMsg.MallRechargeUI", "function info is null");
            u.makeText(this, "function info is null", 1).show();
            return;
        }
        if (parcelableArrayListExtra == null) {
            x.d("MicroMsg.MallRechargeUI", "function info : " + this.pDd.fII);
            n(new com.tencent.mm.plugin.recharge.model.e(this.pDd.pBK));
        } else {
            this.pDG = a.bu(parcelableArrayListExtra);
        }
        x.i("MicroMsg.MallRechargeUI", "onCreate()");
        this.pDI = com.tencent.mm.plugin.wallet_core.model.mall.c.bMe().Nb(this.pDd.pBK);
        initView();
    }

    protected final void initView() {
        setMMTitle(this.pDd.fII);
        x.v("MicroMsg.MallRechargeUI", "initView");
        setBackBtn(new 1(this));
        this.pDt = (TextView) findViewById(a$f.uqx);
        this.pDu = (TextView) findViewById(a$f.uru);
        this.pDv = (TextView) findViewById(a$f.urw);
        this.lRZ = (Button) findViewById(a$f.cAg);
        this.pDA = (LinearLayout) findViewById(a$f.uqa);
        this.pDw = (TextView) findViewById(a$f.urv);
        this.pDw.setOnClickListener(new 11(this));
        this.lRZ.setOnClickListener(new 12(this));
        this.pDD = (MallEditText) findViewById(a$f.uqd);
        this.pDD.imR.setOnClickListener(new 13(this));
        this.pDE = (TextView) findViewById(a$f.uqC);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_product_list");
        List c = c(0, parcelableArrayListExtra);
        List c2 = c(2, parcelableArrayListExtra);
        this.pDF = c.size() > c2.size() ? c.size() : c2.size();
        this.pDB = new a();
        this.pDB.bw(c);
        this.pDC = new a();
        this.pDC.bw(c2);
        this.pDA.setOnClickListener(new 14(this));
        this.pDx = (FrameLayout) findViewById(a$f.urr);
        this.pDy = (ImageView) findViewById(a$f.urt);
        this.pDz = (ImageView) findViewById(a$f.urs);
        this.pDz.setOnClickListener(new 15(this));
        this.pDx.setOnClickListener(new 16(this));
        this.pDD.pCo = this;
        this.pDD.setOnClickListener(new 17(this));
        bmx();
        j.a((com.tencent.mm.platformtools.j.a) this);
        au();
    }

    private void au() {
        x.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.pDG);
        if (this.pDG != null) {
            CharSequence string;
            this.pDE.setText(this.pDG.lEM);
            TextView textView = this.pDv;
            MallRechargeProduct mallRechargeProduct = this.pDG;
            if (!mallRechargeProduct.isValid()) {
                string = getString(i.uLT);
            } else if (mallRechargeProduct.pBM != mallRechargeProduct.pBN || (bmE() && this.pDG.pBS)) {
                string = "";
            } else {
                string = String.format(getString(i.uLV), new Object[]{Float.valueOf(mallRechargeProduct.pBM)});
            }
            textView.setText(string);
        }
        if (this.pDI != null && this.pDd.sQt != null && this.pDI.equals(this.pDd.sQt) && !"1".equals(this.pDI.sQz)) {
            this.pDx.setVisibility(8);
            x.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.pDI.toString());
        } else if (this.pDd.sQt == null || bh.ov(this.pDd.sQt.sQE)) {
            this.pDx.setVisibility(8);
            x.d("MicroMsg.MallRechargeUI", "dismiss banner!");
        } else {
            this.pDH = this.pDd.sQt.sQE;
            this.pDy.setImageBitmap(j.a(new com.tencent.mm.plugin.recharge.b.a(this.pDH)));
            this.pDx.setVisibility(0);
            x.d("MicroMsg.MallRechargeUI", "Show banner!");
        }
        this.pDu.setVisibility(4);
        if (!XK()) {
            this.pDt.setText("");
        } else if (!(this.pDG == null || bmE())) {
            this.pDt.setText(this.pDG.pBL);
            this.pDt.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO));
        }
        String string2 = getString(i.uLN);
        if (!TextUtils.isEmpty(this.pDN)) {
            string2 = this.pDN;
        }
        if (!bh.ov(this.pDM)) {
            addTextOptionMenu(0, string2, new 18(this));
        }
        if (bh.ov(this.pDO)) {
            this.pDw.setVisibility(8);
        } else {
            this.pDw.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.pDP)) {
            this.pDw.setText(this.pDP);
        }
    }

    private static List<MallRechargeProduct> c(int i, List<MallRechargeProduct> list) {
        List<MallRechargeProduct> arrayList = new ArrayList();
        if (list != null) {
            boolean z = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.pBR == i) {
                    arrayList.add(mallRechargeProduct);
                    if (mallRechargeProduct.isDefault) {
                        if (z) {
                            mallRechargeProduct.isDefault = false;
                        }
                        z = true;
                    }
                }
            }
            if (!z && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
        }
        return arrayList;
    }

    private void n(k kVar) {
        if (kVar.getType() == 497 || kVar.getType() == 1555) {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(kVar, 0);
        } else if (this.pDK) {
            if (this.ilS == null || !(this.ilS == null || this.ilS.isShowing())) {
                this.ilS = com.tencent.mm.wallet_core.ui.g.a(this.mController.xIM, true, new 3(this, kVar));
            }
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(kVar, 0);
        } else {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(kVar, 0);
        }
    }

    private boolean XK() {
        boolean z;
        MallEditText mallEditText = this.pDD;
        if (mallEditText.getVisibility() == 0) {
            if (bh.ov(mallEditText.getText())) {
                x.d("MicroMsg.MallEditText", "View:" + mallEditText.imT + ", editType:" + mallEditText.imU + " checkInputValid : empty ");
                z = false;
            } else if (!mallEditText.imY) {
                x.d("MicroMsg.MallEditText", "View:" + mallEditText.imT + ", editType:" + mallEditText.imU + " checkInputValid : illegal ");
                z = false;
            }
            if (z) {
                z = false;
            } else {
                z = true;
            }
            if (z || this.pDG == null || !this.pDG.isValid()) {
                if (!(this.pDJ || z || this.pDG == null)) {
                    this.pDG.isValid();
                }
                this.lRZ.setEnabled(false);
                this.lRZ.setClickable(false);
                x.d("MicroMsg.MallRechargeUI", "checkInfo : false");
                return false;
            }
            if (bmE() && this.pDG.pBS) {
                n(new com.tencent.mm.plugin.recharge.model.d(this.pDG.pBR, this.pDd.pBK, this.pDG.fqV, this.pDG.appId, bmC(), bmD()));
            }
            aWs();
            this.lRZ.setEnabled(true);
            this.lRZ.setClickable(true);
            x.d("MicroMsg.MallRechargeUI", "checkInfo : true");
            return true;
        }
        z = true;
        if (z) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        }
        this.pDG.isValid();
        this.lRZ.setEnabled(false);
        this.lRZ.setClickable(false);
        x.d("MicroMsg.MallRechargeUI", "checkInfo : false");
        return false;
    }

    private String bmC() {
        return "mobile=" + com.tencent.mm.plugin.recharge.model.b.Id(this.pDD.getText());
    }

    private String bmD() {
        return com.tencent.mm.plugin.recharge.model.b.Id(this.pDD.getText());
    }

    private static String p(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("-");
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private boolean bmE() {
        return !this.pDL.containsKey(p(this.pDG.pBR, this.pDG.fqV, bmD()));
    }

    public final void hx(boolean z) {
        if (!z) {
            this.pDL.clear();
            this.pDt.setText("");
            this.pDu.setVisibility(4);
        }
        XK();
    }

    public final void bmx() {
        if (bh.ov(this.pDD.getText()) || this.pDD.XO()) {
            this.pDD.vk(com.tencent.mm.plugin.wxpay.a.e.udC);
        } else {
            this.pDD.vk(com.tencent.mm.plugin.wxpay.a.e.bDo);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + i + ", errCode = " + i2);
        if (!(this.ilS == null || !this.ilS.isShowing() || kVar.getType() == 497)) {
            this.ilS.dismiss();
            this.ilS = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.recharge.model.e) {
                com.tencent.mm.plugin.recharge.model.e eVar = (com.tencent.mm.plugin.recharge.model.e) kVar;
                List list = eVar.pBX;
                if (list != null) {
                    this.pDG = a.bu(list);
                    x.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.pDG);
                }
                this.pDM = eVar.pBY;
                this.pDN = eVar.pBZ;
                this.pDO = eVar.pCa;
                this.pDP = eVar.pCb;
                x.d("MicroMsg.MallRechargeUI", "mProductList " + list);
                au();
                List c = c(0, list);
                List c2 = c(2, list);
                this.pDF = c.size() > c2.size() ? c.size() : c2.size();
                this.pDB.bw(c);
                this.pDC.bw(c2);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.d) {
                x.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.pDG);
                com.tencent.mm.plugin.recharge.model.d dVar = (com.tencent.mm.plugin.recharge.model.d) kVar;
                if (!(this.pDG == null || this.pDG.fqV == null || dVar.pBU == null || ((!this.pDG.fqV.equals(dVar.pBU.fqV) || !bmD().equals(dVar.ikY)) && dVar.pBR == 2))) {
                    MallRechargeProduct.a(dVar.pBU, this.pDG);
                    this.pDG.isDefault = true;
                    this.pDL.put(p(dVar.pBR, dVar.pBU.fqV, dVar.ikY), Integer.valueOf(1));
                    au();
                    this.pDu.setText(str);
                    this.pDu.setVisibility(0);
                    this.pDu.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uaJ));
                }
                if (dVar.pBR == 2) {
                    if (this.pDG == null || !this.pDG.fqV.equals(dVar.pBW) || !bmD().equals(dVar.ikY)) {
                        this.lRZ.setEnabled(true);
                        this.lRZ.setClickable(true);
                        this.pDu.setText(null);
                    } else if (((adg) dVar.gJQ.hmh.hmo).wgv == 0 && this.pDG.fqV.equals(dVar.pBU.fqV)) {
                        n(new com.tencent.mm.plugin.recharge.model.c(this.pDG.pBK, bmD(), this.pDG.lEM, this.pDG.appId, bmC()));
                    } else {
                        this.lRZ.setEnabled(false);
                        this.lRZ.setClickable(false);
                        this.pDu.setText(((adg) dVar.gJQ.hmh.hmo).wgw);
                        this.pDu.setVisibility(0);
                        this.pDu.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btB));
                    }
                }
                bv(dVar.pBV);
                x.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.pDG);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.g) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) kVar).pCn;
                payInfo.fCV = 6;
                payInfo.vzu = 100;
                com.tencent.mm.pluginsdk.wallet.h.a((Context) this, payInfo, 2);
                com.tencent.mm.sdk.b.a.xef.b(this.pfJ);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.c) {
                com.tencent.mm.plugin.recharge.model.c cVar = (com.tencent.mm.plugin.recharge.model.c) kVar;
                if (this.pDG == null || !this.pDG.lEM.equals(cVar.lEM) || !bmD().equals(cVar.fAf)) {
                    this.lRZ.setEnabled(true);
                    this.lRZ.setClickable(true);
                    this.pDu.setText(null);
                } else if (((wa) cVar.gJQ.hmh.hmo).wgv != 0) {
                    this.lRZ.setEnabled(false);
                    this.lRZ.setClickable(false);
                    this.pDu.setText(((wa) cVar.gJQ.hmh.hmo).wgw);
                    this.pDu.setVisibility(0);
                    this.pDu.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btB));
                }
            }
        } else if (!(kVar instanceof com.tencent.mm.plugin.recharge.model.c)) {
            if (kVar instanceof com.tencent.mm.plugin.recharge.model.d) {
                if (i2 == 100) {
                    this.lRZ.setEnabled(true);
                    this.lRZ.setClickable(true);
                } else {
                    this.lRZ.setEnabled(false);
                    this.lRZ.setClickable(false);
                }
                bv(((com.tencent.mm.plugin.recharge.model.d) kVar).pBV);
                this.pDu.setText(str);
                this.pDu.setVisibility(0);
                this.pDu.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btB));
                this.pDt.setText(((com.tencent.mm.plugin.recharge.model.d) kVar).pBL);
                this.pDt.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btB));
                return;
            }
            if (bh.ov(str)) {
                str = getString(i.uXa);
            }
            h.a(this, str, null, false, new 4(this));
        }
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(496, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(497, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(498, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(1555, (e) this);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(496, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(497, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(498, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(1555, (e) this);
    }

    private void bv(List<MallRechargeProduct> list) {
        if (list != null) {
            List arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.pBR == 2) {
                    if (this.pDG != null && mallRechargeProduct.fqV.equals(this.pDG.fqV)) {
                        mallRechargeProduct.isDefault = true;
                        i = true;
                    }
                    arrayList.add(mallRechargeProduct);
                }
            }
            if (i == 0 && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
            this.pDC.bw(arrayList);
            return;
        }
        this.pDC.bw(new ArrayList());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data != null) {
                        if (com.tencent.mm.pluginsdk.g.a.aZ(this, "android.permission.READ_CONTACTS")) {
                            String str2;
                            Cursor query = getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + query.getString(query.getColumnIndex("_id")), null, null);
                                    if (query2.moveToFirst()) {
                                        str2 = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                            String string = query2.getString(columnIndex);
                                            str = query2.getString(columnIndex2);
                                            x.d("MicroMsg.MallRechargeUI", "username : " + str);
                                            if (string != null) {
                                                x.d("MicroMsg.MallRechargeUI", "phoneNumber : " + string);
                                                string = com.tencent.mm.plugin.recharge.model.b.Id(string);
                                                x.d("MicroMsg.MallRechargeUI", "phoneNumber : " + string);
                                                if (!PhoneNumberUtils.isGlobalPhoneNumber(string)) {
                                                    string = str2;
                                                }
                                                x.d("MicroMsg.MallRechargeUI", "phoneResult : " + string);
                                            } else {
                                                string = str2;
                                            }
                                            query2.moveToNext();
                                            str2 = string;
                                        }
                                    } else {
                                        str2 = null;
                                    }
                                    if (!query2.isClosed()) {
                                        query2.close();
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                        this.pDL.clear();
                                        this.pDD.b(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                        this.pDt.setText("");
                                        this.pDu.setVisibility(4);
                                        XK();
                                        break;
                                    }
                                    showDialog(2);
                                    break;
                                }
                            }
                            str2 = null;
                            query.close();
                            if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                this.pDL.clear();
                                this.pDD.b(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                this.pDt.setText("");
                                this.pDu.setVisibility(4);
                                XK();
                            } else {
                                showDialog(2);
                            }
                            break;
                        }
                        x.e("MicroMsg.MallRechargeUI", "no contact permission");
                        return;
                    }
                    x.e("MicroMsg.MallRechargeUI", "uri == null");
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.pfG) {
                        x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.bmr().a(this.pDD.bmw());
                        finish();
                        this.pfG = true;
                        break;
                    }
                }
                x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.pfJ);
        super.onDestroy();
    }

    public final void l(String str, final Bitmap bitmap) {
        if (this.pDH != null && str.equals(this.pDH)) {
            this.pDy.post(new Runnable(this) {
                final /* synthetic */ RechargeUI pDQ;

                public final void run() {
                    this.pDQ.pDy.setImageBitmap(bitmap);
                }
            });
        }
    }

    public final void showVKB() {
        x.d("MicroMsg.MallRechargeUI", "showVKB");
        this.pDD.vk(com.tencent.mm.plugin.wxpay.a.e.bDo);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.showSoftInput(currentFocus, 2);
            }
        }
    }

    public final void aWs() {
        x.d("MicroMsg.MallRechargeUI", "hideVKB");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }
}
