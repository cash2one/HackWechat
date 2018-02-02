package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import java.util.ArrayList;

public class IPCallUserProfileUI extends MMActivity {
    private String fIA;
    private String fIy;
    private ImageView ihQ;
    private boolean nIF = false;
    private String nNA;
    private String nNB;
    private Bitmap nNC;
    private boolean nND;
    private Cursor nNE = null;
    private boolean nNF = false;
    private e nNG = new e();
    private TextView nNq;
    private TextView nNr;
    private LinearLayout nNs;
    private LinearLayout nNt;
    private TextView nNu;
    private TextView nNv;
    private TextView nNw;
    private TextView nNx;
    private TextView nNy;
    private Button nNz;

    static /* synthetic */ void a(IPCallUserProfileUI iPCallUserProfileUI, TextView textView) {
        l lVar = new l(iPCallUserProfileUI);
        lVar.rKC = new p$c(iPCallUserProfileUI) {
            final /* synthetic */ IPCallUserProfileUI nNH;

            {
                this.nNH = r1;
            }

            public final void a(n nVar) {
                nVar.add(R.l.dEs);
            }
        };
        lVar.rKD = new 7(iPCallUserProfileUI, textView);
        lVar.bBX();
    }

    static /* synthetic */ void a(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        if (c.cX(iPCallUserProfileUI)) {
            Intent intent = new Intent(iPCallUserProfileUI, IPCallDialUI.class);
            if (iPCallUserProfileUI.nNF) {
                intent.putExtra("IPCallTalkUI_dialScene", 4);
                g.pQN.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
            } else {
                intent.putExtra("IPCallTalkUI_dialScene", 2);
                g.pQN.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
            }
            intent.putExtra("IPCallTalkUI_contactId", iPCallUserProfileUI.fIy);
            intent.putExtra("IPCallTalkUI_nickname", iPCallUserProfileUI.nNA);
            intent.putExtra("IPCallTalkUI_phoneNumber", c.Dm(str));
            intent.putExtra("IPCallTalkUI_toWechatUsername", iPCallUserProfileUI.nNB);
            iPCallUserProfileUI.startActivityForResult(intent, 1001);
            iPCallUserProfileUI.nND = true;
        }
    }

    static /* synthetic */ void b(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        if (!bh.ov(iPCallUserProfileUI.fIy) && !bh.ov(str) && !str.endsWith("@stranger")) {
            com.tencent.mm.sdk.e.c CD = i.aTD().CD(iPCallUserProfileUI.fIy);
            if (CD.xjy > 0) {
                CD.field_wechatUsername = str;
                i.aTD().a(CD.xjy, CD);
            }
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        g.pQN.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        setBackBtn(new 1(this));
        setMMTitle(R.l.eqV);
        this.ihQ = (ImageView) findViewById(R.h.bLL);
        this.nNq = (TextView) findViewById(R.h.cQa);
        this.nNr = (TextView) findViewById(R.h.cZq);
        this.nNs = (LinearLayout) findViewById(R.h.cDR);
        this.nNu = (TextView) findViewById(R.h.cDQ);
        this.nNw = (TextView) findViewById(R.h.cDP);
        this.nNv = (TextView) findViewById(R.h.cDO);
        this.nNt = (LinearLayout) findViewById(R.h.cDT);
        this.nNx = (TextView) findViewById(R.h.cHa);
        this.nNy = (TextView) findViewById(R.h.cqf);
        this.nNz = (Button) findViewById(R.h.cDN);
        this.fIy = getIntent().getStringExtra("IPCallProfileUI_contactid");
        this.nNA = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
        this.nNB = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
        this.fIA = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
        this.nNF = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
        if (!bh.ov(this.fIy)) {
            this.nNC = a.an(this, this.fIy);
            if (this.nNC != null) {
                this.ihQ.setImageBitmap(this.nNC);
            }
        }
        if (this.nNC == null && !bh.ov(this.nNB)) {
            this.nNC = b.a(this.nNB, false, -1);
            if (this.nNC != null) {
                this.ihQ.setImageBitmap(this.nNC);
            }
        }
        if (!bh.ov(this.nNA)) {
            this.nNq.setText(this.nNA);
        } else if (!bh.ov(this.fIA)) {
            this.nNq.setText(a.Di(this.fIA));
        }
        if (bh.ov(this.nNB) || this.nNB.endsWith("@stranger")) {
            this.nNr.setVisibility(8);
        } else {
            this.nNr.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, getString(R.l.eqW, new Object[]{r.gu(this.nNB)})));
        }
        if (!bh.ov(this.fIy)) {
            if (com.tencent.mm.pluginsdk.g.a.aZ(this, "android.permission.READ_CONTACTS")) {
                this.nNE = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{this.fIy}, null);
                this.nIF = this.nNE.getCount() <= 1;
            } else {
                x.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
                return;
            }
        }
        aUE();
        this.nNw.setVisibility(8);
        this.nNv.setVisibility(8);
        this.nNu.setVisibility(8);
        this.nNz.setVisibility(8);
        this.nNy.setVisibility(8);
        if (!bh.ov(this.nNB) && !bh.ov(this.nNA)) {
            ar.Hg();
            af WO = com.tencent.mm.z.c.EY().WO(this.nNB);
            if (!(WO == null || com.tencent.mm.l.a.fZ(WO.field_type))) {
                this.nNz.setOnClickListener(new 8(this));
                this.nNz.setText(R.l.eqT);
                this.nNz.setVisibility(0);
            }
        } else if (!bh.ov(this.fIy) && !bh.ov(this.nNA)) {
            aUD();
            this.nNz.setText(R.l.eqU);
        } else if (!bh.ov(this.fIA)) {
            this.nNv.setVisibility(0);
            this.nNw.setVisibility(0);
            this.nNu.setVisibility(0);
            this.nNu.setOnClickListener(new 10(this));
            this.nNv.setOnClickListener(new 11(this));
            this.nNw.setOnClickListener(new 2(this));
            aUD();
            this.nNz.setText(R.l.eqU);
        }
        ArrayList arrayList = new ArrayList();
        if (this.nNE == null || this.nNE.getCount() <= 0) {
            this.nNs.setVisibility(8);
            return;
        }
        try {
            if (this.nNE.moveToFirst()) {
                while (!this.nNE.isAfterLast()) {
                    i++;
                    String string = this.nNE.getString(this.nNE.getColumnIndex("data1"));
                    int i2 = this.nNE.getInt(this.nNE.getColumnIndex("data2"));
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                        if (i == this.nNE.getCount()) {
                            l(string, i2, false);
                        } else {
                            l(string, i2, true);
                        }
                    }
                    this.nNE.moveToNext();
                }
            }
            this.nNE.close();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", new Object[]{e.getMessage()});
        } catch (Throwable th) {
            this.nNE.close();
        }
    }

    protected final int getLayoutId() {
        return R.i.dme;
    }

    private void l(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this).inflate(R.i.dpJ, this.nNs, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.h.cta);
        if (z) {
            linearLayout.setBackgroundDrawable(getResources().getDrawable(R.g.bDp));
        } else {
            linearLayout.setBackgroundDrawable(null);
        }
        TextView textView = (TextView) inflate.findViewById(R.h.cCv);
        TextView textView2 = (TextView) inflate.findViewById(R.h.cCu);
        textView2.setText(a.Di(c.Dm(str)));
        textView.setText(a.rH(i));
        inflate.setClickable(true);
        inflate.setOnClickListener(new 4(this, str));
        inflate.setOnLongClickListener(new 5(this, textView2));
        this.nNs.addView(inflate);
    }

    private static String CW(String str) {
        Exception e;
        String str2 = "";
        Cursor query;
        String str3;
        if (com.tencent.mm.pluginsdk.g.a.aZ(ac.getContext(), "android.permission.READ_CONTACTS")) {
            query = ac.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            try {
                if (query.moveToFirst()) {
                    str3 = str2;
                    while (!query.isAfterLast()) {
                        try {
                            str2 = str3 + query.getString(query.getColumnIndex("data1")) + ",";
                            query.moveToNext();
                            str3 = str2;
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                } else {
                    str3 = str2;
                }
                query.close();
            } catch (Exception e3) {
                e = e3;
                str3 = str2;
            }
            if (str3.lastIndexOf(",") >= 0) {
                str3 = str3.substring(0, str3.lastIndexOf(","));
            }
            return str3;
        }
        x.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
        return null;
        try {
            x.e("MicroMsg.IPCallUserProfileUI", "extractAddressItemFromCursor, error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
            if (str3.lastIndexOf(",") >= 0) {
                str3 = str3.substring(0, str3.lastIndexOf(","));
            }
            return str3;
        } finally {
            query.close();
        }
    }

    private void aUD() {
        this.nNz.setOnClickListener(new 9(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aUE() {
        Cursor query;
        if (!this.nNF) {
            this.nNt.setVisibility(8);
            this.nNx.setVisibility(8);
        }
        if (bh.ov(this.fIy)) {
            com.tencent.mm.plugin.ipcall.a.g.l aTE = i.aTE();
            String str = this.fIA;
            query = aTE.gJP.query("IPCallRecord", com.tencent.mm.plugin.ipcall.a.g.l.nGQ, "phonenumber=?", new String[]{str}, null, null, new StringBuilder("calltime desc limit 4").toString());
        } else {
            Cursor query2;
            String str2 = this.fIy;
            if (!bh.ov(str2)) {
                com.tencent.mm.plugin.ipcall.a.g.c CD = i.aTD().CD(str2);
                if (!(CD == null || CD.xjy == -1)) {
                    long j = CD.xjy;
                    query2 = i.aTE().gJP.query("IPCallRecord", com.tencent.mm.plugin.ipcall.a.g.l.nGQ, "addressId=?", new String[]{String.valueOf(j)}, null, null, new StringBuilder("calltime desc limit 4").toString());
                    query = query2;
                }
            }
            query2 = null;
            query = query2;
        }
        if (query == null || query.getCount() <= 0) {
            this.nNt.setVisibility(8);
            this.nNx.setVisibility(8);
            return;
        }
        try {
            if (query.moveToFirst()) {
                int i = 0;
                while (!query.isAfterLast()) {
                    Object obj;
                    k kVar = new k();
                    kVar.b(query);
                    int i2 = i + 1;
                    if (i2 >= 3) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    int count = query.getCount();
                    View inflate = LayoutInflater.from(this).inflate(R.i.dpK, this.nNt, false);
                    TextView textView = (TextView) inflate.findViewById(R.h.cDS);
                    TextView textView2 = (TextView) inflate.findViewById(R.h.cDV);
                    ((TextView) inflate.findViewById(R.h.cDU)).setText(a.Di(kVar.field_phonenumber));
                    if (kVar.field_duration > 0) {
                        textView2.setText(c.dE(kVar.field_duration));
                    } else {
                        textView2.setText(c.rI(kVar.field_status));
                    }
                    textView.setText(c.dC(kVar.field_calltime));
                    if (obj != null) {
                        inflate.setBackgroundDrawable(getResources().getDrawable(R.g.bEM));
                        i = getResources().getDimensionPixelSize(R.f.bxQ);
                        inflate.setPadding(i, 0, i, 0);
                    }
                    if (1 == count) {
                        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                        layoutParams.height = com.tencent.mm.bv.a.aa(this.mController.xIM, R.f.bxM);
                        inflate.setLayoutParams(layoutParams);
                    }
                    this.nNt.addView(inflate);
                    if (obj != null) {
                        i = i2;
                        break;
                    } else {
                        query.moveToNext();
                        i = i2;
                    }
                }
                if (i <= 0) {
                    this.nNt.setVisibility(8);
                } else if (query.getCount() >= 4) {
                    View inflate2 = LayoutInflater.from(this).inflate(R.i.dpL, this.nNt, false);
                    this.nNt.addView(inflate2);
                    inflate2.setOnClickListener(new 3(this));
                }
            }
            query.close();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", new Object[]{e.getMessage()});
        } catch (Throwable th) {
            query.close();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.nND) {
            this.nND = false;
            this.nNt.removeAllViews();
            aUE();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
