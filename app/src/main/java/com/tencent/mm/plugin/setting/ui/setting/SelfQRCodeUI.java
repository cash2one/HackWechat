package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ag.f;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class SelfQRCodeUI extends MMActivity implements e {
    private static final String qhC = (h.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/");
    private Bitmap hkT = null;
    private ProgressDialog iln = null;
    private ImageView jCP = null;
    private long llS;
    private ImageView qgL = null;
    private byte[] qgM = null;
    private boolean qhA = false;
    private a qhB;
    private TextView qhy = null;
    private TextView qhz = null;
    private String userName = "";

    static /* synthetic */ void b(SelfQRCodeUI selfQRCodeUI) {
        g gVar = new g(selfQRCodeUI, g.ztp, false);
        gVar.rKC = new 6(selfQRCodeUI);
        gVar.rKD = new 7(selfQRCodeUI);
        gVar.bUk();
    }

    static /* synthetic */ void e(SelfQRCodeUI selfQRCodeUI) {
        byte[] toByteArray;
        FileOutputStream fileOutputStream;
        Throwable e;
        if (s.eV(selfQRCodeUI.userName) || f.jX(selfQRCodeUI.userName)) {
            com.tencent.mm.plugin.report.service.g.pQN.a(219, 10, 1, true);
            Bitmap de = d.de(selfQRCodeUI.findViewById(R.h.cFb));
            if (de != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                de.compress(CompressFormat.PNG, 90, byteArrayOutputStream);
                toByteArray = byteArrayOutputStream.toByteArray();
            } else {
                toByteArray = null;
            }
            if (toByteArray == null) {
                toByteArray = selfQRCodeUI.qgM;
            }
        } else {
            toByteArray = selfQRCodeUI.qgM;
        }
        if (toByteArray != null && toByteArray.length > 0) {
            String str = k.ccF() + "mmqrcode" + System.currentTimeMillis() + ".png";
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    fileOutputStream.write(toByteArray);
                    Toast.makeText(selfQRCodeUI, selfQRCodeUI.getString(R.l.dXO, new Object[]{k.ccF()}), 1).show();
                    k.b(str, selfQRCodeUI);
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                x.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.drM;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qhB = new a(this, this);
        this.qhB.start();
        ar.CG().a(JsApiSetClipboardData.CTRL_INDEX, this);
        initView();
        this.qgL.post(new 1(this));
    }

    public void onDestroy() {
        ar.CG().b(JsApiSetClipboardData.CTRL_INDEX, this);
        if (this.qhB != null) {
            this.qhB.stop();
        }
        if (!(this.hkT == null || this.hkT.isRecycled())) {
            this.hkT.recycle();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (!s.eV(this.userName) && !f.jX(this.userName)) {
            View findViewById = findViewById(R.h.cLp);
            this.llS = q.FX();
            x.d("MicroMsg.SelfQRCodeNewUI", (this.llS & 2) + ",extstatus:" + this.llS);
            if ((this.llS & 2) != 0) {
                findViewById.setVisibility(0);
                this.qgL.setAlpha(0.1f);
                findViewById(R.h.cLo).setOnClickListener(new 4(this));
                return;
            }
            findViewById.setVisibility(8);
            this.qgL.setAlpha(1.0f);
        }
    }

    protected final void initView() {
        this.userName = getIntent().getStringExtra("from_userName");
        if (bh.ov(this.userName)) {
            this.userName = q.FS();
        }
        if (q.FS().equals(this.userName)) {
            this.qhA = true;
        }
        if (s.eV(this.userName)) {
            setMMTitle(R.l.eMQ);
            ((TextView) findViewById(R.h.cFk)).setText("");
            enableOptionMenu(false);
        } else if (f.jX(this.userName)) {
            setMMTitle(R.l.ebX);
            ((TextView) findViewById(R.h.cFk)).setText(R.l.ebY);
            enableOptionMenu(false);
        } else {
            setMMTitle(R.l.eMJ);
        }
        this.qgL = (ImageView) findViewById(R.h.cLm);
        this.jCP = (ImageView) findViewById(R.h.coq);
        this.qhy = (TextView) findViewById(R.h.cAj);
        this.qhz = (TextView) findViewById(R.h.cch);
        if (!s.eV(this.userName) && !f.jX(this.userName)) {
            CharSequence charSequence;
            ar.Hg();
            String str = (String) c.CU().get(42, null);
            String string = getString(R.l.dFe);
            if (bh.ov(str)) {
                ar.Hg();
                str = (String) c.CU().get(2, null);
                string = string + str;
                com.tencent.mm.storage.x.WB(str);
                str = string;
            } else {
                str = string + str;
            }
            x.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[]{str});
            if (this.hkT == null) {
                x.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[]{"bitmap == null"});
                vR(1);
            } else {
                this.qgL.setImageBitmap(this.hkT);
            }
            b.a(this.jCP, q.FS());
            ar.Hg();
            x.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[]{(String) c.CU().get(4, null)});
            this.qhy.setText(i.c(this, str, a.aa(this.mController.xIM, R.f.bvs)));
            bi HQ = bi.HQ();
            string = bh.ou(HQ.getProvince());
            x.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[]{r.gw(string) + " " + bh.ou(HQ.getCity())});
            this.qhz.setText(charSequence);
            ar.Hg();
            switch (bh.a((Integer) c.CU().get(12290, null), 0)) {
                case 1:
                    this.qhy.setCompoundDrawablesWithIntrinsicBounds(null, null, a.b(this, R.k.dyN), null);
                    break;
                case 2:
                    this.qhy.setCompoundDrawablesWithIntrinsicBounds(null, null, a.b(this, R.k.dyM), null);
                    break;
                default:
                    break;
            }
        }
        vR(1);
        b.a(this.jCP, this.userName);
        ar.Hg();
        af WO = c.EY().WO(this.userName);
        this.qhy.setSingleLine(false);
        this.qhy.setMaxLines(3);
        this.qhy.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (WO != null) {
            charSequence = WO.field_nickname;
            if (bh.ov(charSequence)) {
                ar.Hg();
                charSequence = c.Fh().hE(this.userName).field_displayname;
            }
            this.qhy.setText(i.b(this, charSequence, this.qhy.getTextSize()));
        } else {
            this.qhy.setVisibility(8);
        }
        this.qhz.setVisibility(8);
        addIconOptionMenu(0, R.g.bDI, new 2(this));
        setBackBtn(new 3(this));
    }

    private void vR(int i) {
        int e;
        if (this.qhA) {
            ar.Hg();
            e = bh.e((Integer) c.CU().get(66561, null));
        } else {
            e = 0;
        }
        com.tencent.mm.ae.k aVar = new com.tencent.mm.ba.a(this.userName, e, i);
        ar.CG().a(aVar, 0);
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.iln = com.tencent.mm.ui.base.h.a(context, getString(R.l.eJz), true, new 5(this, aVar));
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        com.tencent.mm.ba.a aVar = (com.tencent.mm.ba.a) kVar;
        if (kVar.getType() == JsApiSetClipboardData.CTRL_INDEX && !com.tencent.mm.plugin.setting.a.ift.b(this.mController.xIM, i, i2, str)) {
            if (i == 0 && i2 == 0) {
                this.qgM = aVar.hJW;
                this.hkT = d.bl(this.qgM);
                if (s.eV(this.userName) || f.jX(this.userName)) {
                    enableOptionMenu(true);
                    CharSequence charSequence = aVar.hJU;
                    if (!bh.ov(charSequence)) {
                        ((TextView) findViewById(R.h.cFk)).setText(charSequence);
                    }
                } else if (this.qhA) {
                    CharSequence charSequence2 = aVar.hJV;
                    TextView textView = (TextView) findViewById(R.h.cSb);
                    View view = (View) textView.getParent();
                    if (bh.ov(charSequence2)) {
                        view.setVisibility(8);
                    } else {
                        textView.setText(charSequence2);
                        view.setOnClickListener(new 9(this));
                        view.setVisibility(0);
                    }
                }
                this.qgL.setImageBitmap(this.hkT);
                return;
            }
            Toast.makeText(this, getString(R.l.ejg, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }

    public static void bqv() {
        com.tencent.mm.plugin.report.service.g.pQN.a(219, 14, 1, true);
    }
}
