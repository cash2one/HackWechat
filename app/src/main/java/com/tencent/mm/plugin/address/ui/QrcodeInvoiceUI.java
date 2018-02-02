package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.p;

public class QrcodeInvoiceUI extends MMActivity {
    private Dialog ilS = null;
    private b imH = null;
    private int ims = 0;
    private TextView imx;
    private InvoiceQrcodeTextView inB;
    private InvoiceQrcodeTextView inC;
    private InvoiceQrcodeTextView inD;
    private InvoiceQrcodeTextView inE;
    private InvoiceQrcodeTextView inF;
    private InvoiceQrcodeTextView inG;
    private InvoiceQrcodeTextView inH;
    Bitmap inI;
    q inJ = null;
    ImageView inK;
    View inL;
    private float inM = 0.0f;
    OnClickListener inN = new 5(this);
    private OnClickListener inO = new 6(this);

    static /* synthetic */ void c(QrcodeInvoiceUI qrcodeInvoiceUI) {
        LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness > qrcodeInvoiceUI.inM) {
            attributes.screenBrightness = qrcodeInvoiceUI.inM;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
    }

    static /* synthetic */ void d(QrcodeInvoiceUI qrcodeInvoiceUI) {
        LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            qrcodeInvoiceUI.inM = attributes.screenBrightness;
            attributes.screenBrightness = 0.85f;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
        this.ims = getIntent().getIntExtra("invoice_id", 0);
        setMMTitle(R.l.eql);
    }

    public void onResume() {
        getWindow().setSoftInputMode(3);
        super.onResume();
        initView();
    }

    public final void initView() {
        findViewById(R.h.cFh);
        this.inB = (InvoiceQrcodeTextView) findViewById(R.h.cFj);
        if (this.inB != null) {
            this.inB.XR();
        }
        this.inC = (InvoiceQrcodeTextView) findViewById(R.h.cFf);
        if (this.inC != null) {
            this.inC.XR();
        }
        this.inD = (InvoiceQrcodeTextView) findViewById(R.h.cFi);
        if (this.inD != null) {
            this.inD.XR();
        }
        this.inE = (InvoiceQrcodeTextView) findViewById(R.h.cFe);
        if (this.inE != null) {
            this.inE.XR();
        }
        this.inF = (InvoiceQrcodeTextView) findViewById(R.h.cFg);
        if (this.inF != null) {
            this.inF.XR();
        }
        this.inG = (InvoiceQrcodeTextView) findViewById(R.h.cFc);
        if (this.inG != null) {
            this.inG.XR();
        }
        this.inH = (InvoiceQrcodeTextView) findViewById(R.h.cFd);
        if (this.inH != null) {
            this.inH.XR();
        }
        this.inD.inf = true;
        this.inD.imY = true;
        if (this.ims != 0) {
            this.imx = (TextView) findViewById(R.h.cFl);
            this.imH = a.XF().jg(this.ims);
            if (this.imH == null) {
                x.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
                finish();
            }
            if (this.imH != null && this.imH.type != null && this.imH.type.equals("0")) {
                this.imx.setText(getString(R.l.eqh));
                this.inC.setVisibility(8);
                if (this.imH.nBK == null || this.imH.nBK.equals("")) {
                    this.inD.setVisibility(8);
                } else {
                    this.inD.setVisibility(0);
                    this.inD.oO(this.imH.nBK);
                }
                if (this.imH.nBQ == null || this.imH.nBQ.equals("")) {
                    this.inE.setVisibility(8);
                } else {
                    this.inE.setVisibility(0);
                    this.inE.oO(this.imH.nBQ);
                }
                if (this.imH.nBO == null || this.imH.nBO.equals("")) {
                    this.inF.setVisibility(8);
                } else {
                    this.inF.setVisibility(0);
                    this.inF.oO(this.imH.nBO);
                }
                if (this.imH.nBM == null || this.imH.nBM.equals("")) {
                    this.inG.setVisibility(8);
                } else {
                    this.inG.setVisibility(0);
                    this.inG.oO(this.imH.nBM);
                }
                if (this.imH.nBL == null || this.imH.nBL.equals("")) {
                    this.inH.setVisibility(8);
                } else {
                    this.inH.setVisibility(0);
                    this.inH.oO(this.imH.nBL);
                }
            } else if (!(this.imH == null || this.imH.type == null || !this.imH.type.equals("1"))) {
                this.imx.setText(getString(R.l.eqj));
                this.inB.setVisibility(8);
                this.inD.setVisibility(8);
                this.inE.setVisibility(8);
                this.inF.setVisibility(8);
                this.inG.setVisibility(8);
                this.inH.setVisibility(8);
            }
            this.imx.setVisibility(0);
            if (this.imH != null) {
                this.inB.oO(this.imH.title);
                this.inC.oO(this.imH.nBJ);
            }
            if (this.inJ == null) {
                View inflate = View.inflate(this, R.i.dlR, null);
                inflate.setOnClickListener(new 3(this));
                this.inL = inflate.findViewById(R.h.cqC);
                this.inK = (ImageView) inflate.findViewById(R.h.cqB);
                this.inJ = new q(inflate, -1, -1, true);
                this.inJ.setClippingEnabled(false);
                this.inJ.update();
                this.inJ.setBackgroundDrawable(new ColorDrawable(16777215));
                this.inJ.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ QrcodeInvoiceUI inP;

                    {
                        this.inP = r1;
                    }

                    public final void onDismiss() {
                        QrcodeInvoiceUI.c(this.inP);
                    }
                });
            }
        } else {
            x.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
            finish();
        }
        setBackBtn(new 1(this));
        a(0, getString(R.l.dEF), new 2(this), p.b.xJz);
        ImageView imageView;
        View findViewById;
        TextView textView;
        if (this.imH == null || this.imH.nBR == null || this.imH.nBR.equals("")) {
            imageView = (ImageView) findViewById(R.h.cqD);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            findViewById = findViewById(R.h.cqE);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            textView = (TextView) findViewById(R.h.cFa);
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        imageView = (ImageView) findViewById(R.h.cqD);
        if (imageView != null) {
            imageView.setVisibility(0);
            this.inI = com.tencent.mm.bs.a.a.b(this, this.imH.nBR, 0, 3);
            imageView.setImageBitmap(this.inI);
            imageView.setOnClickListener(this.inO);
        }
        findViewById = findViewById(R.h.cqE);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        textView = (TextView) findViewById(R.h.cFa);
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!bh.ov(stringExtra)) {
                        x.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:" + stringExtra);
                        this.inF.oO(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!bh.ov(stringExtra)) {
                        x.d("MicroMsg.QrcodeInvoiceUI", "post:" + stringExtra);
                        this.inF.oO(stringExtra);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (i2 != -1) {
                    x.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dog;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        setResult(0);
        finish();
        return true;
    }
}
