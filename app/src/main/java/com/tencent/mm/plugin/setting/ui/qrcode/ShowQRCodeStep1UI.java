package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class ShowQRCodeStep1UI extends MMActivity implements e {
    private ProgressDialog iln = null;
    private int qgG = 1;
    private ImageView qgL = null;
    byte[] qgM = null;

    protected final int getLayoutId() {
        return R.i.dsG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        ar.CG().a(JsApiSetClipboardData.CTRL_INDEX, this);
    }

    public void onDestroy() {
        ar.CG().b(JsApiSetClipboardData.CTRL_INDEX, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eJX);
        this.qgL = (ImageView) findViewById(R.h.cLm);
        this.qgG = getIntent().getIntExtra("show_to", 1);
        TextView textView = (TextView) findViewById(R.h.cOl);
        if (this.qgG == 3) {
            textView.setText(getString(R.l.eJB, new Object[]{getString(R.l.eJF)}));
        } else if (this.qgG == 4) {
            textView.setText(getString(R.l.eJB, new Object[]{getString(R.l.eJC)}));
        } else if (this.qgG == 2) {
            textView.setText(getString(R.l.eJB, new Object[]{getString(R.l.eJE)}));
        } else {
            textView.setText(getString(R.l.eJB, new Object[]{getString(R.l.eJD)}));
        }
        bqs();
        setBackBtn(new 1(this));
        addIconOptionMenu(0, R.g.bDI, new 2(this));
        ((Button) findViewById(R.h.cLn)).setOnClickListener(new 3(this));
    }

    final void bqs() {
        k aVar = new a();
        ar.CG().a(aVar, 0);
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.iln = h.a(context, getString(R.l.eJz), true, new 5(this, aVar));
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (!com.tencent.mm.plugin.setting.a.ift.b(this.mController.xIM, i, i2, str)) {
            if (i == 0 && i2 == 0) {
                this.qgM = ((a) kVar).hJW;
                this.qgL.setImageBitmap(d.bl(this.qgM));
                return;
            }
            Toast.makeText(this, getString(R.l.ejg, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
