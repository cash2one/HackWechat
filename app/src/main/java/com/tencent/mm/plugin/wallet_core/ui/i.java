package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.m$a;
import com.tencent.mm.plugin.wallet_core.model.m.1;
import com.tencent.mm.plugin.wallet_core.model.m.b;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.k;
import java.util.LinkedList;
import java.util.List;

public final class i extends k {
    private LayoutInflater DF;
    private View kND;
    private a sFy;
    private MaxListView sTB = ((MaxListView) this.kND.findViewById(f.uyT));
    private TextView sTC = ((TextView) this.kND.findViewById(f.uyR));
    private a sTD = new a(this);
    private b sTE;

    private i(Context context) {
        super(context, j.uYC);
        this.DF = LayoutInflater.from(context);
        this.kND = LayoutInflater.from(context).inflate(a$g.uET, null);
        this.sTB.setAdapter(this.sTD);
        this.kND.findViewById(f.uyS).setOnClickListener(new 1(this));
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.kND);
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    public static i a(Context context, Orders orders, String str, b bVar) {
        Dialog iVar = new i(context);
        iVar.setOnCancelListener(null);
        iVar.setCancelable(true);
        iVar.sFy = b.sRa.a(orders);
        if (iVar.sFy == null) {
            x.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
            iVar.dismiss();
        } else {
            int i;
            Object obj;
            a aVar = iVar.sTD;
            com.tencent.mm.plugin.wallet.a.f fVar = aVar.sTF.sFy.sQU;
            String Nm = aVar.sTF.sFy.Nm(str);
            aVar.sTH = aVar.sTF.sFy.bMo();
            aVar.sTI = aVar.sTF.sFy.Ni(Nm);
            aVar.sTG = -1;
            for (i = 0; i < aVar.sTH.size(); i++) {
                if ((((q) aVar.sTH.get(i)).sEh != 0 ? 1 : null) != null) {
                    aVar.sTG = i;
                    break;
                }
            }
            List linkedList = new LinkedList();
            if (aVar.sTH != null) {
                for (i = 0; i < aVar.sTH.size(); i++) {
                    linkedList.add(((q) aVar.sTH.get(i)).sDk);
                }
                List linkedList2 = new LinkedList();
                if (!(fVar == null || fVar.sDr == null)) {
                    for (i = 0; i < fVar.sDr.size(); i++) {
                        String str2 = ((q) fVar.sDr.get(i)).sDk;
                        if (!linkedList.contains(str2)) {
                            linkedList2.add(str2);
                        }
                    }
                }
                List linkedList3 = new LinkedList();
                if (fVar == null || fVar.sDs == null || fVar.sDs.sDC == null) {
                    x.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
                    obj = null;
                } else {
                    List list = fVar.sDs.sDC;
                    for (i = 0; i < list.size(); i++) {
                        String str3 = ((h) list.get(i)).sDE;
                        for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                            if (str3.contains((CharSequence) linkedList2.get(i2))) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            linkedList3.add(str3);
                        }
                    }
                    List linkedList4 = new LinkedList();
                    if (!(bh.ov(Nm) || Nm.equals("0"))) {
                        String[] split = Nm.split("-");
                        if (split != null) {
                            for (Object add : split) {
                                linkedList4.add(add);
                            }
                        } else {
                            x.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
                            obj = null;
                        }
                    }
                    aVar.sTJ.d(linkedList, linkedList4, linkedList3);
                    obj = 1;
                }
            } else {
                x.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
                obj = null;
            }
            if (obj == null) {
                x.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
                iVar.dismiss();
            } else {
                iVar.sTC.setText(a$i.uRB);
                iVar.sTB.setOnItemClickListener(new OnItemClickListener(iVar) {
                    final /* synthetic */ i sTF;

                    {
                        this.sTF = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        a b = this.sTF.sTD;
                        m mVar = b.sTJ;
                        if (i < mVar.sNi.size()) {
                            int i2 = ((b) mVar.sNi.get(i)).sNq;
                            int i3 = m$a.sNm;
                            switch (1.sNk[i2 - 1]) {
                                case 1:
                                    mVar.dZ(i, m$a.sNm);
                                    break;
                                case 2:
                                    mVar.dZ(i, m$a.sNn);
                                    break;
                            }
                            mVar.bLj();
                        }
                        b.notifyDataSetChanged();
                    }
                });
            }
        }
        iVar.sTE = bVar;
        iVar.show();
        com.tencent.mm.ui.base.h.a(context, iVar);
        return iVar;
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    private void bMB() {
        x.d("MicroMsg.WalletFavorDialog", "On selection done");
        if (this.sTD != null) {
            m mVar = this.sTD.sTJ;
            this.sTE.a(this.sFy.Nl(mVar.a(mVar.sNi, -1)));
        }
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bMB();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
