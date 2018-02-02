package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.a.d.f;
import com.tencent.mm.plugin.ipcall.a.e.g;
import com.tencent.mm.plugin.ipcall.a.e.h;
import com.tencent.mm.plugin.ipcall.a.e.j;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.i$a;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.bwl;
import com.tencent.mm.protocal.c.bwq;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class IPCallRechargeUI extends MMActivity implements e {
    private i$a lDL = new 1(this);
    private int lDv = -1;
    private String[] lDx;
    TextView lkn;
    private af mHandler = new 3(this);
    ProgressDialog nIK;
    private String nLA;
    private String nLB;
    private h nLC = new h();
    private g nLD = new g();
    private j nLE = new j();
    RelativeLayout nLF;
    GridView nLG;
    ListView nLH;
    a nLI;
    Button nLJ;
    f nLK;
    private String[] nLt;
    private String[] nLu;
    private String nLv;
    private String nLw;
    private boolean nLx = false;
    private int nLy;
    private int nLz = -1;

    private static class a extends BaseAdapter {
        private IPCallRechargeUI nLN = null;
        aib nLO = null;
        List<bwl> not = null;

        public a(IPCallRechargeUI iPCallRechargeUI) {
            Assert.assertTrue(iPCallRechargeUI != null);
            this.nLN = iPCallRechargeUI;
        }

        public final int getCount() {
            return this.not == null ? 0 : this.not.size();
        }

        public final Object getItem(int i) {
            if (this.not != null) {
                return this.not.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.nLN.getSystemService("layout_inflater")).inflate(R.i.dmr, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.nKT = (TextView) view.findViewById(R.h.cSW);
                aVar.nLQ = (TextView) view.findViewById(R.h.cSV);
                aVar.nLR = (TextView) view.findViewById(R.h.cSU);
                aVar.nLS = (TextView) view.findViewById(R.h.cST);
                aVar.nLT = (Button) view.findViewById(R.h.bOY);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            bwl com_tencent_mm_protocal_c_bwl = (bwl) getItem(i);
            if (com_tencent_mm_protocal_c_bwl != null) {
                aVar.nKT.setText(com_tencent_mm_protocal_c_bwl.wEW);
                aVar.nLQ.setText(com_tencent_mm_protocal_c_bwl.wXA);
                aVar.nLR.setText(com_tencent_mm_protocal_c_bwl.wXB);
                if (bh.ov(com_tencent_mm_protocal_c_bwl.wXB)) {
                    aVar.nLR.setVisibility(8);
                } else {
                    aVar.nLR.setVisibility(0);
                }
                if (this.nLO != null) {
                    aVar.nLS.setText(String.format(this.nLN.getString(R.l.erb), new Object[]{com.tencent.mm.plugin.ipcall.b.a.Db(this.nLO.wpi), String.valueOf(com_tencent_mm_protocal_c_bwl.wXy)}));
                }
                aVar.nLT.setTag(Integer.valueOf(i));
                aVar.nLT.setOnClickListener(new 1(this));
            }
            return view;
        }
    }

    static /* synthetic */ void b(IPCallRechargeUI iPCallRechargeUI, int i) {
        String string;
        boolean z;
        if (iPCallRechargeUI.lDv != -1) {
            CharSequence string2;
            switch (iPCallRechargeUI.lDv) {
                case 10233:
                    string2 = iPCallRechargeUI.getString(R.l.erH);
                    if (!iPCallRechargeUI.CU(string2)) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    }
                    break;
                case 10234:
                    string = iPCallRechargeUI.getString(R.l.erD);
                    if (!iPCallRechargeUI.CU(string)) {
                        com.tencent.mm.ui.base.h.a(iPCallRechargeUI, string, iPCallRechargeUI.getString(R.l.erJ), true, null);
                        break;
                    }
                    break;
                case 10235:
                    string2 = iPCallRechargeUI.getString(R.l.esn);
                    if (!iPCallRechargeUI.CU(string2)) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    }
                    break;
                default:
                    string2 = iPCallRechargeUI.getString(R.l.eqN);
                    if (!iPCallRechargeUI.CU(string2)) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            iPCallRechargeUI.nLz = i;
            x.i("MicroMsg.IPCallRechargeUI", "ProductId:%s, PackPrice:%s,Currency:%s, index:%d", new Object[]{iPCallRechargeUI.lDx[i], iPCallRechargeUI.nLt[i], iPCallRechargeUI.nLu[i], Integer.valueOf(i)});
            com.tencent.mm.plugin.report.service.g.pQN.a(257, 5, 1, true);
            iPCallRechargeUI.nLD.start();
            if (iPCallRechargeUI.nLI.getItem(i) instanceof bwl) {
                iPCallRechargeUI.nLD.nGj = ((bwl) iPCallRechargeUI.nLI.getItem(i)).wXz;
            }
            iPCallRechargeUI.nLD.nGk = iPCallRechargeUI.nLu[i];
            iPCallRechargeUI.nLD.nGi = (long) i;
            iPCallRechargeUI.nLD.nGo = iPCallRechargeUI.lDx[i];
            Intent intent = new Intent();
            intent.putExtra("key_product_id", iPCallRechargeUI.lDx[i]);
            intent.putExtra("key_currency_type", iPCallRechargeUI.nLu[i]);
            intent.putExtra("key_price", iPCallRechargeUI.nLu[i] + iPCallRechargeUI.nLt[i]);
            intent.putExtra("key_force_google", true);
            if (iPCallRechargeUI.nLI.getItem(i) instanceof bwl) {
                string = ((bwl) iPCallRechargeUI.nLI.getItem(i)).wXC;
                if (!bh.ov(string)) {
                    x.i("md5:%s", string);
                    bwq com_tencent_mm_protocal_c_bwq = new bwq();
                    com_tencent_mm_protocal_c_bwq.wXC = string;
                    try {
                        intent.putExtra("key_ext_info", Base64.encodeToString(com_tencent_mm_protocal_c_bwq.toByteArray(), 2));
                    } catch (IOException e) {
                        x.e("MicroMsg.IPCallRechargeUI", e.getMessage());
                    }
                }
            }
            d.b(iPCallRechargeUI, "wallet_index", ".ui.WalletIapUI", intent, 2001);
        }
    }

    static /* synthetic */ void j(IPCallRechargeUI iPCallRechargeUI) {
        if (iPCallRechargeUI.nLI != null) {
            iPCallRechargeUI.nLI.not = null;
            iPCallRechargeUI.nLI.notifyDataSetChanged();
        }
        if (iPCallRechargeUI.nLH != null) {
            iPCallRechargeUI.nLH.setVisibility(4);
        }
        if (iPCallRechargeUI.nIK != null) {
            iPCallRechargeUI.nIK.show();
        }
        iPCallRechargeUI.CT("");
    }

    static /* synthetic */ void k(IPCallRechargeUI iPCallRechargeUI) {
        if (!bh.ov(iPCallRechargeUI.nLA) && !bh.ov(iPCallRechargeUI.nLB)) {
            x.i("MicroMsg.IPCallRechargeUI", "showGotoExchangeRecordsAlert");
            com.tencent.mm.ui.base.h.a(iPCallRechargeUI, iPCallRechargeUI.nLB, iPCallRechargeUI.nLA, iPCallRechargeUI.getString(R.l.eqZ), iPCallRechargeUI.getString(R.l.era), false, null, new OnClickListener(iPCallRechargeUI) {
                final /* synthetic */ IPCallRechargeUI nLL;

                {
                    this.nLL = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.nLL.finish();
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.nLL.getString(R.l.eqG));
                    intent.putExtra("showShare", false);
                    d.b(this.nLL, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(929, this);
        setMMTitle(R.l.eqY);
        setBackBtn(new 5(this));
        addIconOptionMenu(0, R.g.bDI, new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallRechargeUI nLL;

            {
                this.nLL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.h.a(this.nLL.mController.xIM, null, null, this.nLL.getResources().getString(R.l.erV), false, new 9(this.nLL));
                return true;
            }
        });
        this.nLF = (RelativeLayout) findViewById(R.h.layout);
        this.nLG = (GridView) findViewById(R.h.cGq);
        this.nLH = (ListView) findViewById(R.h.cGs);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.mController.xIM, R.i.dmq, null);
        this.nLH.addFooterView(viewGroup, null, false);
        this.nLI = new a(this);
        this.nLH.setAdapter(this.nLI);
        this.lkn = (TextView) viewGroup.findViewById(R.h.cRV);
        this.nLJ = (Button) findViewById(R.h.bPk);
        Object string = getString(R.l.erd);
        CharSequence newSpannable = Factory.getInstance().newSpannable(string);
        newSpannable.setSpan(new 7(this), 0, string.length(), 33);
        this.lkn.setText(newSpannable);
        this.lkn.setMovementMethod(LinkMovementMethod.getInstance());
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.nIK = com.tencent.mm.ui.base.h.a(context, getString(R.l.eqO), true, new OnCancelListener(this) {
            final /* synthetic */ IPCallRechargeUI nLL;

            {
                this.nLL = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                try {
                    if (this.nLL.nLK != null) {
                        ar.CG().c(this.nLL.nLK);
                    }
                    this.nLL.finish();
                } catch (Exception e) {
                    x.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", new Object[]{e.getMessage()});
                }
            }
        });
        CT("");
        this.nLC.start();
        com.tencent.mm.plugin.report.service.g.pQN.a(257, 4, 1, true);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.nLC.nFU = System.currentTimeMillis();
        this.nLC.finish();
        ar.CG().b(929, this);
    }

    protected final int getLayoutId() {
        return R.i.dms;
    }

    private void CT(String str) {
        String Dd;
        List aTm = c.aTj().aTm();
        if (aTm.size() == 0) {
            Dd = com.tencent.mm.plugin.ipcall.b.a.Dd(com.tencent.mm.plugin.ipcall.b.c.aUO());
        } else {
            Dd = com.tencent.mm.plugin.ipcall.b.a.Dd(((Integer) aTm.get(0)).toString());
        }
        this.nLK = new f(Dd, str);
        ar.CG().a(this.nLK, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        boolean z;
        int i3;
        ArrayList stringArrayListExtra;
        if (i == 2001) {
            int intExtra;
            int i4;
            String str;
            String str2 = "";
            z = false;
            if (intent != null) {
                String string;
                int intExtra2 = intent.getIntExtra("key_err_code", 0);
                String stringExtra = intent.getStringExtra("key_err_msg");
                long longExtra = intent.getLongExtra("key_launch_ts", 0);
                intExtra = intent.getIntExtra("key_gw_error_code", 0);
                int intExtra3 = intent.getIntExtra("key_response_position", 0);
                if (intExtra2 == 100000001) {
                    z = true;
                }
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[]{Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Integer.valueOf(intExtra3), String.valueOf(z)});
                if (intExtra2 != 6 || intExtra == 0) {
                    this.nLD.nGm = (long) intExtra2;
                } else {
                    this.nLD.nGm = (long) intExtra;
                }
                if (intExtra3 == 3) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(257, 9, 1, true);
                    com.tencent.mm.plugin.report.service.g.pQN.a(257, 11, 1, true);
                    this.nLD.nGm = 0;
                    this.nLD.nGn = 2;
                    string = getString(R.l.eso);
                } else {
                    if (intExtra3 != 1) {
                        if (i2 == -1 && intExtra2 == 0) {
                            com.tencent.mm.plugin.report.service.g.pQN.a(257, 9, 1, true);
                            string = stringExtra;
                        } else if (z) {
                            com.tencent.mm.plugin.report.service.g.pQN.a(257, 9, 1, true);
                            com.tencent.mm.plugin.report.service.g.pQN.a(257, 12, 1, true);
                            this.nLD.nGm = 0;
                            this.nLD.nGn = 1;
                        }
                    }
                    string = stringExtra;
                }
                this.nLD.nGl = longExtra;
                this.nLD.nFU = System.currentTimeMillis();
                this.nLD.finish();
                i4 = intExtra3;
                str = string;
                i3 = intExtra;
                intExtra = intExtra2;
            } else {
                i3 = 0;
                i4 = 0;
                intExtra = 0;
                str = str2;
            }
            if (i2 != -1) {
                return;
            }
            if (intent != null && intExtra == 0) {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                intent.getStringArrayListExtra("key_response_series_ids");
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    x.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", new Object[]{bh.ou((String) it.next())});
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(257, 6, 1, true);
                com.tencent.mm.plugin.report.service.g.pQN.a(257, 10, 1, true);
                Toast.makeText(this, R.l.erK, 0).show();
                finish();
            } else if (intent != null && intExtra == 100000002) {
                com.tencent.mm.plugin.report.service.g.pQN.a(257, 6, 1, true);
                yy(str);
            } else if (intent != null && intExtra == 109) {
                yy(str);
            } else if (intent != null && intExtra == 1) {
                r2 = getString(R.l.erI);
                com.tencent.mm.plugin.report.service.g.pQN.a(257, 8, 1, true);
                Toast.makeText(this, r2, 0).show();
            } else if (intent == null || intExtra != 113) {
                com.tencent.mm.plugin.report.service.g.pQN.a(257, 7, 1, true);
                if (i4 == 3) {
                    yy(str);
                } else if (intExtra != 100000001 && intExtra != 6) {
                } else {
                    if (i3 == 0) {
                        Toast.makeText(this, getString(R.l.eqL), 0).show();
                        return;
                    }
                    r2 = getString(R.l.eqN);
                    if (!CU(r2)) {
                        Toast.makeText(this, r2, 0).show();
                    }
                }
            } else {
                com.tencent.mm.ui.base.h.a(this, getString(R.l.erB), getString(R.l.erJ), new 10(this));
            }
        } else if (i == 2002) {
            if (this.nIK != null && this.nIK.isShowing()) {
                this.nIK.dismiss();
            }
            String str3 = "";
            int i5 = 0;
            int i6 = 0;
            z = false;
            if (intent != null) {
                i5 = intent.getIntExtra("key_err_code", 0);
                str3 = intent.getStringExtra("key_err_msg");
                i6 = intent.getIntExtra("key_response_position", 0);
                if (i5 == 100000001) {
                    z = true;
                }
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[]{Integer.valueOf(i5), str3, Integer.valueOf(i6), String.valueOf(z)});
            }
            CharSequence charSequence = str3;
            int i7 = i5;
            boolean z2 = z;
            i3 = i6;
            i6 = i7;
            this.nLE.nGv = (long) i6;
            this.nLE.nGt = 0;
            if (i2 != -1) {
                this.nLE.nGu = 2;
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
                Toast.makeText(this, R.l.erW, 0).show();
            } else if (intent == null || i6 != 0) {
                if (z2) {
                    this.nLE.nGu = 1;
                    com.tencent.mm.plugin.report.service.g.pQN.a(257, 17, 1, true);
                    charSequence = getString(R.l.erX);
                } else if (i3 == 3) {
                    this.nLE.nGu = 2;
                    com.tencent.mm.plugin.report.service.g.pQN.a(257, 16, 1, true);
                } else {
                    this.nLE.nGu = 2;
                }
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
                Toast.makeText(this, charSequence, 0).show();
            } else {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    this.nLE.nGu = 3;
                    x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
                    Toast.makeText(this, R.l.erX, 0).show();
                } else {
                    this.nLE.nGu = 0;
                    com.tencent.mm.plugin.report.service.g.pQN.a(257, 15, 1, true);
                    x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.erY), getString(R.l.erZ), new 11(this));
                }
            }
            this.nLE.nFU = System.currentTimeMillis();
            this.nLE.finish();
        }
    }

    private void yy(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.erJ);
        }
        com.tencent.mm.ui.base.h.a(this, str, getString(R.l.erJ), new OnClickListener(this) {
            final /* synthetic */ IPCallRechargeUI nLL;

            {
                this.nLL = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private boolean CU(String str) {
        boolean z;
        if (com.tencent.mm.k.g.zY().getInt("WCOSecondPurchaseSwitch", 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.nLz >= 0) {
            Object item = this.nLI.getItem(this.nLz);
            if ((item instanceof bwl) && !bh.ov(((bwl) item).wXD)) {
                String str2 = ((bwl) item).wXD;
                x.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:" + str2);
                com.tencent.mm.ui.base.h.a(this, str, getString(R.l.erJ), getString(R.l.eru), getString(R.l.dEn), true, new 2(this, str2), null);
                return true;
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        x.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        if (kVar instanceof f) {
            h hVar = this.nLC;
            hVar.nGq = System.currentTimeMillis();
            hVar.nGr = (long) i2;
            if (i == 0 && i2 == 0) {
                aib com_tencent_mm_protocal_c_aib = ((f) kVar).nFz;
                this.nLI.not = com_tencent_mm_protocal_c_aib.wkN;
                this.nLI.nLO = com_tencent_mm_protocal_c_aib;
                this.nLI.notifyDataSetChanged();
                this.lDx = new String[com_tencent_mm_protocal_c_aib.wkN.size()];
                Iterator it = com_tencent_mm_protocal_c_aib.wkN.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    this.lDx[i4] = ((bwl) it.next()).vIR;
                    i4++;
                }
                this.nLA = com_tencent_mm_protocal_c_aib.wpn;
                this.nLB = com_tencent_mm_protocal_c_aib.wpo;
                this.nLv = com_tencent_mm_protocal_c_aib.wpi;
                this.nLw = com_tencent_mm_protocal_c_aib.wpm;
                this.nLy = com_tencent_mm_protocal_c_aib.wpl;
                if (this.nLx) {
                    this.nLu = new String[com_tencent_mm_protocal_c_aib.wkN.size()];
                    for (int i5 = 0; i5 < this.nLu.length; i5++) {
                        this.nLu[i5] = com_tencent_mm_protocal_c_aib.wpm;
                    }
                    this.nLt = new String[com_tencent_mm_protocal_c_aib.wkN.size()];
                    while (i3 < this.nLt.length) {
                        this.nLt[i3] = IPCallDynamicTextView.CS(((bwl) com_tencent_mm_protocal_c_aib.wkN.get(i3)).wEW);
                        i3++;
                    }
                }
                if (((f) kVar).nFA) {
                    x.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
                    if (this.lDx != null && this.lDx.length > 0) {
                        x.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
                        i.a(this, this.lDx, this.lDL);
                        return;
                    }
                    return;
                }
                if (this.nIK != null && this.nIK.isShowing()) {
                    this.nIK.dismiss();
                }
                aUB();
                return;
            }
            if (this.nIK != null && this.nIK.isShowing()) {
                this.nIK.dismiss();
            }
            Toast.makeText(this.mController.xIM, getString(R.l.eqL), 0).show();
            finish();
        }
    }

    public final void aUB() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
    }
}
