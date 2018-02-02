package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI extends MMPreference {
    private f ilB;
    private String nQt;
    private String name;
    private boolean psS;

    public final int XB() {
        return R.o.fbQ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.name = getIntent().getStringExtra("name");
        this.nQt = getIntent().getStringExtra("addr");
        this.psS = getIntent().getBooleanExtra("can_compose", false);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.epH);
        this.ilB = this.yjd;
        ((KeyValuePreference) this.ilB.YN("mail_receiver_info_name")).setSummary(this.name);
        ((KeyValuePreference) this.ilB.YN("mail_receiver_info_addr")).setSummary(getIntent().getStringExtra("addr"));
        Preference YN = this.ilB.YN("mail_compose_btn");
        if (!this.psS) {
            this.ilB.c(YN);
        }
        setBackBtn(new 1(this));
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.ibD.equals("mail_compose_btn")) {
            Intent intent = new Intent(this, ComposeUI.class);
            intent.putExtra("composeType", 4);
            intent.putExtra("toList", new String[]{this.name + " " + this.nQt});
            startActivity(intent);
            finish();
        }
        return false;
    }
}
