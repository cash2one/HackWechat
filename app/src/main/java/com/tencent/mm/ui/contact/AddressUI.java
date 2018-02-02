package com.tencent.mm.ui.contact;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.m;
import com.tencent.mm.ui.u;

public class AddressUI extends FragmentActivity {
    public u yvF;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.N(16908290) == null) {
            this.yvF = new a();
            this.yvF.setArguments(getIntent().getExtras());
            supportFragmentManager.aS().a(16908290, this.yvF).commit();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }
}
