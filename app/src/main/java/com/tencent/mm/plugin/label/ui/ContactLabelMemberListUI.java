package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public class ContactLabelMemberListUI extends MMActivity {
    private TextView kml;
    private af mHandler = new 1(this);
    private String nPA;
    private b nPi = new 2(this);
    private ListView nPx;
    private a nPy;
    private String nPz;

    static /* synthetic */ void a(ContactLabelMemberListUI contactLabelMemberListUI, int i) {
        if (contactLabelMemberListUI.nPy != null && i <= contactLabelMemberListUI.nPy.getCount()) {
            com.tencent.mm.g.b.af afVar = contactLabelMemberListUI.nPy.rK(i).jLe;
            if (afVar != null && !bh.ov(afVar.field_username) && afVar.field_deleteFlag != 1) {
                if (s.hd(afVar.field_username)) {
                    x.e("MicroMsg.Label.ContactLabelMemberListUI", "error, 4.5 do not contain this contact %s", new Object[]{afVar.field_username});
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", afVar.field_username);
                intent.putExtra("Contact_Alias", afVar.vN());
                intent.putExtra("Contact_Nick", afVar.AP());
                intent.putExtra("Contact_QuanPin", afVar.vR());
                intent.putExtra("Contact_PyInitial", afVar.vQ());
                intent.putExtra("Contact_Sex", afVar.fWf);
                intent.putExtra("Contact_Province", afVar.getProvince());
                intent.putExtra("Contact_City", afVar.getCity());
                intent.putExtra("Contact_Signature", afVar.signature);
                a.ifs.d(intent, contactLabelMemberListUI);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.deS;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nPz = getIntent().getStringExtra("label_id");
        this.nPA = getIntent().getStringExtra("label_name");
        setBackBtn(new 3(this));
        addTextOptionMenu(0, getString(R.l.esz), new 4(this));
        setMMTitle(this.nPA);
        this.nPx = (ListView) findViewById(R.h.bYj);
        this.kml = (TextView) findViewById(R.h.empty);
        if (bh.ov(this.nPz)) {
            x.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
            finish();
        }
        this.nPy = new a(this.mController.xIM);
        this.nPx.setAdapter(this.nPy);
        this.nPx.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ContactLabelMemberListUI nPB;

            {
                this.nPB = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ContactLabelMemberListUI.a(this.nPB, i);
            }
        });
        this.nPx.setEmptyView(this.kml);
    }

    protected void onResume() {
        ar.Hg();
        c.EY().a(this.nPi);
        super.onResume();
        aVf();
    }

    protected void onPause() {
        ar.Hg();
        c.EY().b(this.nPi);
        super.onPause();
    }

    protected void onDestroy() {
        if (this.nPy != null) {
            this.nPy.aUn();
            this.nPy.xIi = null;
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 10001:
                if (i2 == -1) {
                    finish();
                    return;
                } else {
                    aVf();
                    return;
                }
            default:
                x.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    private void aVf() {
        if (this.nPy != null) {
            this.nPy.nPt = com.tencent.mm.plugin.label.a.a.aUX().Dr(this.nPz);
            this.nPy.a(null, null);
        }
        this.nPA = com.tencent.mm.plugin.label.a.a.aUX().Dn(this.nPz);
        if (!bh.ov(this.nPA)) {
            setMMTitle(this.nPA);
        }
    }
}
