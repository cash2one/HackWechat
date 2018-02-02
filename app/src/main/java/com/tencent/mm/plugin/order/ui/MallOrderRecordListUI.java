package com.tencent.mm.plugin.order.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.st;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallOrderRecordListUI extends WalletBaseUI {
    public boolean acS = false;
    public MMLoadMoreListView ldB;
    public int mCount = 0;
    public af mHandler = null;
    public Dialog mzP = null;
    public boolean ogC = true;
    public a pcp = null;
    public List<i> pcq = new ArrayList();
    protected String pcr = null;
    public boolean pcs = false;
    protected Map<String, String> pct = new HashMap();
    public int wn = 0;

    protected class a extends BaseAdapter {
        final /* synthetic */ MallOrderRecordListUI pcu;

        protected a(MallOrderRecordListUI mallOrderRecordListUI) {
            this.pcu = mallOrderRecordListUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return uA(i);
        }

        public final int getCount() {
            return this.pcu.pcq.size();
        }

        private i uA(int i) {
            return (i) this.pcu.pcq.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            Object obj;
            String dh;
            int i2;
            if (view == null) {
                view = View.inflate(this.pcu, g.uDc, null);
                bVar = new b();
                bVar.pcw = (TextView) view.findViewById(a$f.usx);
                bVar.pcy = (TextView) view.findViewById(a$f.usw);
                bVar.pcx = (TextView) view.findViewById(a$f.usv);
                bVar.pcz = (TextView) view.findViewById(a$f.ust);
                bVar.pcB = view.findViewById(a$f.usq);
                bVar.pcC = (TextView) view.findViewById(a$f.uss);
                bVar.pcD = (TextView) view.findViewById(a$f.usr);
                bVar.pcA = (TextView) view.findViewById(a$f.usu);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            i uA = uA(i);
            if (i == 0) {
                i uA2 = uA(0);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeInMillis(((long) uA2.pbl) * 1000);
                obj = 1;
                dh = MallOrderRecordListUI.dg(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1);
            } else {
                i uA3 = uA(i);
                i uA4 = uA(i - 1);
                if (uA3.pbl > 0 && uA4.pbl > 0) {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(((long) uA4.pbl) * 1000);
                    GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                    gregorianCalendar3.setTimeInMillis(((long) uA3.pbl) * 1000);
                    if (!(gregorianCalendar2.get(1) == gregorianCalendar3.get(1) && gregorianCalendar2.get(2) == gregorianCalendar3.get(2))) {
                        i2 = 1;
                        dh = MallOrderRecordListUI.dg(gregorianCalendar3.get(1), gregorianCalendar3.get(2) + 1);
                    }
                }
                obj = null;
                dh = null;
            }
            if (obj != null) {
                bVar.pcC.setText(new SimpleDateFormat(this.pcu.getString(com.tencent.mm.plugin.wxpay.a.i.eju, new Object[]{""})).format(new Date(((long) uA(i).pbl) * 1000)));
                if (!(bh.ov(dh) || bh.ov((String) this.pcu.pct.get(dh)))) {
                    bVar.pcD.setText((CharSequence) this.pcu.pct.get(dh));
                }
                bVar.pcB.setVisibility(0);
            } else {
                bVar.pcB.setVisibility(8);
            }
            bVar.pcw.setText(uA.pbk);
            bVar.pcx.setText(uA.pbm);
            i2 = this.pcu.mController.xIM.getResources().getColor(c.ubd);
            if (!bh.ov(uA.pby)) {
                try {
                    i2 = Color.parseColor(uA.pby);
                } catch (Exception e) {
                    x.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bh.ou(uA.pby));
                }
            }
            bVar.pcx.setTextColor(i2);
            bVar.pcy.setText(this.pcu.uz(uA.pbl));
            i2 = this.pcu.mController.xIM.getResources().getColor(c.ube);
            if (!bh.ov(uA.pbz)) {
                try {
                    i2 = Color.parseColor(uA.pbz);
                } catch (Exception e2) {
                    x.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bh.ou(uA.pbz));
                }
            }
            if (uA.pbj != uA.pbA) {
                Object d = e.d(uA.pbj / 100.0d, uA.pbo);
                CharSequence spannableString = new SpannableString(d);
                spannableString.setSpan(new StrikethroughSpan(), 0, d.length(), 33);
                bVar.pcz.setText(spannableString);
            } else {
                bVar.pcz.setText("");
            }
            bVar.pcA.setTextColor(i2);
            bVar.pcA.setText(e.d(uA.pbA / 100.0d, uA.pbo));
            return view;
        }
    }

    private class b {
        TextView pcA;
        View pcB;
        TextView pcC;
        TextView pcD;
        final /* synthetic */ MallOrderRecordListUI pcu;
        TextView pcw;
        TextView pcx;
        TextView pcy;
        TextView pcz;

        private b(MallOrderRecordListUI mallOrderRecordListUI) {
            this.pcu = mallOrderRecordListUI;
        }
    }

    protected final int getLayoutId() {
        return g.uDb;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new af();
        biH();
        initView();
        this.wn = 0;
        this.pcr = null;
    }

    public void biH() {
        ji(bb.CTRL_INDEX);
        ji(bf.CTRL_INDEX);
    }

    public void biI() {
        jj(bb.CTRL_INDEX);
        jj(bf.CTRL_INDEX);
    }

    public void onResume() {
        super.onResume();
        if (this.pcp != null) {
            this.pcp.notifyDataSetChanged();
        }
    }

    public void dG(String str, String str2) {
        l(new com.tencent.mm.plugin.order.model.g(str, str2, 1));
    }

    public void biJ() {
        l(new com.tencent.mm.plugin.order.model.e(this.wn, this.pcr));
    }

    protected final void initView() {
        if (com.tencent.mm.wallet_core.a.ag(this) instanceof com.tencent.mm.plugin.order.a.a) {
            this.acS = true;
            biJ();
        }
        setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uLd);
        this.ldB = (MMLoadMoreListView) findViewById(a$f.uqt);
        this.pcp = new a(this);
        this.ldB.setAdapter(this.pcp);
        this.ldB.setOnItemClickListener(new 1(this));
        this.ldB.setOnItemLongClickListener(new 2(this));
        this.ldB.ybX = new 3(this);
        com.tencent.mm.sdk.b.b stVar = new st();
        stVar.fKA.fKC = "6";
        stVar.fqI = new 4(this, stVar);
        com.tencent.mm.sdk.b.a.xef.m(stVar);
        com.tencent.mm.plugin.order.a.b.bit().asi();
        this.pcp.notifyDataSetChanged();
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[1];
        com.tencent.mm.plugin.order.a.b.bit();
        objArr[0] = Integer.valueOf(com.tencent.mm.plugin.order.a.b.biw().biB());
        gVar.h(11036, objArr);
    }

    public final void bl(List<i> list) {
        if (list != null && list.size() != 0) {
            if (this.pcq == null) {
                this.pcq = new ArrayList();
            }
            for (int i = 0; i < list.size(); i++) {
                i iVar = (i) list.get(i);
                if (!Hn(iVar.pbi)) {
                    this.pcq.add(iVar);
                }
            }
        }
    }

    private boolean Hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.pcq.size(); i++) {
            i iVar = (i) this.pcq.get(i);
            if (iVar != null && str.equals(iVar.pbi)) {
                return true;
            }
        }
        return false;
    }

    public void onDestroy() {
        biI();
        super.onDestroy();
    }

    public String uz(int i) {
        return e.HE(i);
    }

    public final void bm(List<d> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                d dVar = (d) list.get(i);
                if (dVar != null) {
                    this.pct.put(dg(dVar.year, dVar.month), dVar.pbc);
                }
            }
        }
    }

    private static String dg(int i, int i2) {
        return i + "-" + i2;
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.order.model.e) {
            if (this.mzP != null) {
                this.mzP.dismiss();
                this.mzP = null;
            }
            com.tencent.mm.plugin.order.model.e eVar = (com.tencent.mm.plugin.order.model.e) kVar;
            this.pcr = eVar.pbf;
            bl(eVar.pbd);
            bm(eVar.pbe);
            this.mCount = this.pcq.size();
            this.ogC = eVar.liB > this.mCount;
            this.pcp.notifyDataSetChanged();
            x.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
            x.d("MicroMsg.WalletOrderListUI", "orders list total record: " + eVar.liB);
            x.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.ogC);
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ MallOrderRecordListUI pcu;

                {
                    this.pcu = r1;
                }

                public final void run() {
                    if (this.pcu.ogC) {
                        x.v("MicroMsg.WalletOrderListUI", "has more");
                        if (!this.pcu.pcs) {
                            this.pcu.ldB.cpp();
                            this.pcu.ldB.setAdapter(this.pcu.pcp);
                            this.pcu.pcs = true;
                        }
                    } else {
                        x.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
                        this.pcu.ldB.cpq();
                    }
                    this.pcu.pcp.notifyDataSetChanged();
                }
            });
            this.acS = false;
        } else if (kVar instanceof com.tencent.mm.plugin.order.model.g) {
            if (this.mzP != null) {
                this.mzP.dismiss();
                this.mzP = null;
            }
            com.tencent.mm.plugin.order.model.g gVar = (com.tencent.mm.plugin.order.model.g) kVar;
            if (gVar.biC() == 2) {
                if (this.pcq != null) {
                    this.pcq.clear();
                }
                this.mCount = 0;
                this.ogC = false;
                this.ldB.cpq();
            } else {
                String biD = gVar.biD();
                x.d("MicroMsg.WalletOrderListUI", "delete transId:" + biD);
                if (!bh.ov(biD)) {
                    for (i iVar : this.pcq) {
                        if (biD.equals(iVar.pbi)) {
                            this.pcq.remove(iVar);
                            this.mCount = this.pcq.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ MallOrderRecordListUI pcu;

                {
                    this.pcu = r1;
                }

                public final void run() {
                    this.pcu.pcp.notifyDataSetChanged();
                }
            });
        }
        if (this.mCount > 0 || this.pcq.size() != 0) {
            showOptionMenu(true);
            findViewById(a$f.ujY).setVisibility(8);
        } else {
            showOptionMenu(false);
            findViewById(a$f.ujY).setVisibility(0);
        }
        return true;
    }
}
