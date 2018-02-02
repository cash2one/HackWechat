package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.l;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.protocal.c.ayb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class FaceDetectConfirmUI extends MMActivity implements e {
    private String appId;
    private int hKY;
    private String jHS;
    private String joU;
    private String mfk = null;
    private TextView miF;
    private TextView miG;
    private TextView miH;
    private Button miI;
    private List<ant> miJ = new ArrayList();
    private ayb miK = null;
    private r tipDialog;

    protected final int getLayoutId() {
        return g.mdC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appId = getIntent().getStringExtra("k_app_id");
        this.joU = getIntent().getStringExtra("request_verify_pre_info");
        this.jHS = getIntent().getStringExtra("key_function_name");
        this.hKY = getIntent().getIntExtra("key_business_type", -1);
        setMMTitle(getString(h.mdQ));
        setBackBtn(new 1(this));
        this.miF = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.mcU);
        this.miG = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.mde);
        this.miH = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.mdd);
        this.miI = (Button) findViewById(com.tencent.mm.plugin.facedetect.a.e.mdx);
        this.miI.setOnClickListener(new 2(this));
        x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
        Context context = this.mController.xIM;
        getString(h.dGO);
        this.tipDialog = com.tencent.mm.ui.base.h.a(context, getString(h.dHc), false, new OnCancelListener(this) {
            final /* synthetic */ FaceDetectConfirmUI miL;

            {
                this.miL = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        k lVar = new l(this.appId, this.joU);
        com.tencent.mm.kernel.g.CG().a(1147, this);
        com.tencent.mm.kernel.g.CG().a(lVar, 0);
    }

    private void aHg() {
        Intent intent = new Intent();
        intent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.k.pv(90024));
        intent.putExtra("err_msg", "user cancel in confirm ui");
        FaceDetectReporter.aGK().a(this.hKY, false, 3, 1, 90024);
        FaceDetectReporter.aGK().mgU = System.currentTimeMillis();
        FaceDetectReporter.aGK().bi(this.jHS, this.hKY);
        setResult(0, intent);
        finish();
    }

    public void finish() {
        dismissDialog();
        super.finish();
    }

    private void dismissDialog() {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }

    public void onBackPressed() {
        aHg();
        super.onBackPressed();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            this.miJ = ((l) kVar).mfi;
            this.miK = ((l) kVar).mfj;
            this.mfk = ((l) kVar).mfk;
            if (bh.ov(this.mfk)) {
                this.mfk = getString(h.mdP);
            }
            dismissDialog();
            this.miI.setEnabled(true);
            this.miF.setText(this.mfk);
            x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo refreshView");
            if (this.miK != null) {
                if (!bh.ov(this.miK.fyY)) {
                    x.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s", new Object[]{this.miK.fyY});
                    this.miG.setVisibility(0);
                    this.miG.setText(this.miK.fyY);
                }
                if (!bh.ov(this.miK.wFn)) {
                    x.v("MicroMsg.FaceDetectConfirmUI", "alvinluo protocal url wording: %s", new Object[]{this.miK.wFn});
                    this.miH.setVisibility(0);
                    this.miH.setText(this.miK.wFn);
                    if (!bh.ov(this.miK.url)) {
                        x.v("MicroMsg.FaceDetectConfirmUI", "alvinluo protocal url: %s", new Object[]{this.miK.url});
                        final String str2 = this.miK.url;
                        this.miH.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ FaceDetectConfirmUI miL;

                            public final void onClick(View view) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str2);
                                intent.putExtra("showShare", false);
                                intent.putExtra("geta8key_username", q.FS());
                                d.b(this.miL, "webview", ".ui.tools.WebViewUI", intent);
                            }
                        });
                    }
                }
            }
        } else {
            if (bh.ov(str)) {
                str = getString(h.meb);
            }
            dismissDialog();
            com.tencent.mm.ui.base.h.a(this, str, getString(h.dGO), false, new 4(this));
        }
        com.tencent.mm.kernel.g.CG().b(1147, this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        FaceDetectReporter.aGK().mgU = System.currentTimeMillis();
        FaceDetectReporter.aGK().bi(this.jHS, this.hKY);
        setResult(i2, intent);
        finish();
    }
}
