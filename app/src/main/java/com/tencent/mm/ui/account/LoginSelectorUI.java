package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bh;

@Deprecated
public class LoginSelectorUI extends MMActivity implements OnClickListener {
    private View oaU;
    private TextView xPv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        a.ift.up();
        ar.CC();
        initView();
    }

    protected final int getLayoutId() {
        return R.i.drE;
    }

    public void onResume() {
        super.onResume();
        ar.CC();
    }

    protected final void initView() {
        Button button = (Button) findViewById(R.h.cKT);
        Button button2 = (Button) findViewById(R.h.cLc);
        this.xPv = (TextView) findViewById(R.h.cKP);
        this.oaU = findViewById(R.h.cKQ);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.xPv.setText(w.g(this.mController.xIM, R.c.bqS, R.l.dFv));
        this.oaU.setOnClickListener(new 1(this));
        if (f.xeC) {
            a.ift.e(this);
        } else {
            a.ift.aq(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent at = a.ifs.at(this);
            at.addFlags(67108864);
            at.putExtra("can_finish", true);
            startActivity(at);
            finish();
            b.fG(this);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onClick(View view) {
        boolean z = true;
        if (R.h.cKT == view.getId()) {
            Intent intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            startActivity(intent);
        } else if (R.h.cLc != view.getId()) {
        } else {
            if (d.vAC) {
                String string = getString(R.l.dXK, new Object[]{"0x" + Integer.toHexString(d.vAz), w.cfi()});
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", string);
                intent2.putExtra("showShare", false);
                intent2.putExtra("show_bottom", false);
                intent2.putExtra("needRedirect", false);
                intent2.putExtra("neverGetA8Key", true);
                intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                a.ifs.j(intent2, this);
                return;
            }
            if (bh.HO().HP() <= 0) {
                z = false;
            }
            Intent intent3;
            if (z) {
                intent3 = new Intent(this, RegByMobileRegAIOUI.class);
                intent3.putExtra("login_type", 0);
                startActivity(intent3);
                return;
            }
            intent3 = new Intent(this, MobileInputUI.class);
            intent3.putExtra("mobile_input_purpose", 2);
            startActivity(intent3);
        }
    }
}
