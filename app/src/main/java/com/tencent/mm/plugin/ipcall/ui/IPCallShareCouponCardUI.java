package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.bwt;
import com.tencent.mm.protocal.c.bwu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.u;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponCardUI extends MMActivity implements e, a, b {
    private int Ex = 0;
    private String gAT = null;
    private View iP;
    private ProgressDialog iln = null;
    private String mTitle = null;
    private ProgressDialog nIK = null;
    private TextView nLU;
    private TextView nLV;
    private TextView nLW;
    private TextView nLX;
    private Button nLY;
    private ImageView nLZ;
    private com.tencent.mm.ui.i.a nMa = new com.tencent.mm.ui.i.a();
    private ProgressDialog nMb = null;
    private i nMc = null;
    private ImageView nMd = null;
    private ProgressBar nMe = null;
    private com.tencent.mm.plugin.ipcall.a.e.e nMf = new com.tencent.mm.plugin.ipcall.a.e.e();
    private String nMg = null;
    private String nMh = null;
    private String nMi = null;
    private String nMj = null;
    private String nMk = null;
    private String nMl = null;
    private String nMm = null;
    private String nMn = null;
    private String nMo = null;
    private bwu nMp = null;
    private String nMq = null;
    private View nMr;

    static /* synthetic */ LinkedList a(IPCallShareCouponCardUI iPCallShareCouponCardUI, LinkedList linkedList) {
        x.i("MicroMsg.IPCallShareCouponCardUI", "CheckedShareList svr size =" + linkedList.size());
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(8));
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bwt com_tencent_mm_protocal_c_bwt = (bwt) it.next();
            Context context = iPCallShareCouponCardUI.mController.xIM;
            int i = com_tencent_mm_protocal_c_bwt.fgt;
            boolean aj = (i == 8 || i == 0 || i == 1 || i == 2 || i == 3 || i == 5) ? true : i == 4 ? aj(context, "com.whatsapp") : i == 6 ? q.Gr() : i == 7 ? aj(context, "com.facebook.orca") : false;
            if (aj) {
                linkedList2.add(Integer.valueOf(com_tencent_mm_protocal_c_bwt.fgt));
            }
        }
        x.i("MicroMsg.IPCallShareCouponCardUI", "CheckedShareList final size =" + linkedList2.size());
        return linkedList2;
    }

    static /* synthetic */ void a(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        iPCallShareCouponCardUI.nMf.start();
        iPCallShareCouponCardUI.nMf.nFY = (long) iPCallShareCouponCardUI.Ex;
        g.pQN.a(257, 19, 1, true);
        if (iPCallShareCouponCardUI.nMp != null) {
            com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(iPCallShareCouponCardUI.mController.xIM, com.tencent.mm.ui.widget.g.zto, true);
            gVar.e(iPCallShareCouponCardUI.getString(R.l.esi), 17);
            gVar.rKC = new 12(iPCallShareCouponCardUI);
            gVar.rKD = new d(iPCallShareCouponCardUI) {
                final /* synthetic */ IPCallShareCouponCardUI nMs;

                {
                    this.nMs = r1;
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    IPCallShareCouponCardUI.a(this.nMs, menuItem.getItemId());
                }
            };
            gVar.bUk();
        }
    }

    static /* synthetic */ void a(IPCallShareCouponCardUI iPCallShareCouponCardUI, int i) {
        String str = iPCallShareCouponCardUI.nMn + " " + iPCallShareCouponCardUI.nMq + String.format("&rt=%s", new Object[]{Integer.valueOf(i)});
        String str2;
        Intent intent;
        switch (i) {
            case 0:
                str = iPCallShareCouponCardUI.mTitle;
                str2 = iPCallShareCouponCardUI.nMj + String.format("&rt=%s", new Object[]{Integer.valueOf(i)});
                String str3 = iPCallShareCouponCardUI.gAT;
                String str4 = iPCallShareCouponCardUI.nMh;
                x.i("MicroMsg.IPCallShareCouponCardUI", "onShare2Friends>title:%s,onShare2Friends>url:%s,onShare2Friends>desc:%s,onShare2Friends>imgPath:%s", new Object[]{str, str2, str3, str4});
                iPCallShareCouponCardUI.nMf.nFZ = 0;
                iPCallShareCouponCardUI.nMf.finish();
                g.pQN.a(257, 20, 1, true);
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_Type", 259);
                intent2.putExtra("select_is_ret", true);
                com.tencent.mm.bm.d.a((Context) iPCallShareCouponCardUI, ".ui.transmit.SelectConversationUI", intent2, 1);
                break;
            case 1:
                str = iPCallShareCouponCardUI.mTitle;
                String str5 = iPCallShareCouponCardUI.nMj + String.format("&rt=%s", new Object[]{Integer.valueOf(i)});
                str2 = iPCallShareCouponCardUI.gAT;
                x.i("MicroMsg.IPCallShareCouponCardUI", "onShareSnsEvent>title:%s,onShareSnsEvent>url:%s,onShareSnsEvent>content:%s,onShareSnsEvent>content:%s", new Object[]{str, str5, str2, iPCallShareCouponCardUI.nMh});
                iPCallShareCouponCardUI.nMf.nFZ = 1;
                iPCallShareCouponCardUI.nMf.finish();
                g.pQN.a(257, 21, 1, true);
                intent = new Intent();
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("need_result", false);
                intent.putExtra("Ksnsupload_title", bh.az(str, ""));
                intent.putExtra("Ksnsupload_imgurl", r10);
                intent.putExtra("Ksnsupload_link", str5);
                str = u.hz("wechat_out");
                u.GK().t(str, true).o("prePublishId", "wechat_out");
                intent.putExtra("reportSessionId", str);
                com.tencent.mm.bm.d.b(iPCallShareCouponCardUI, "sns", ".ui.SnsUploadUI", intent, 1);
                break;
            case 2:
                intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("sms_body", str);
                intent.setType("vnd.android-dir/mms-sms");
                if (!bh.k(iPCallShareCouponCardUI, intent)) {
                    Toast.makeText(iPCallShareCouponCardUI, R.l.eJv, 1).show();
                    break;
                } else {
                    iPCallShareCouponCardUI.startActivity(intent);
                    break;
                }
            case 3:
                intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.SUBJECT", String.format(iPCallShareCouponCardUI.getString(R.l.esd), new Object[]{q.FU()}));
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.setType("plain/text");
                iPCallShareCouponCardUI.startActivity(Intent.createChooser(intent, iPCallShareCouponCardUI.getString(R.l.epJ)));
                break;
            case 4:
                try {
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    iPCallShareCouponCardUI.startActivity(intent);
                    break;
                } catch (Exception e) {
                    x.e("MicroMsg.IPCallShareCouponCardUI", "go whatsapp error" + e.getMessage());
                    break;
                }
            case 5:
                if (!iPCallShareCouponCardUI.nMa.cyv()) {
                    h.a(iPCallShareCouponCardUI.mController.xIM, R.l.eNE, R.l.dGO, new 16(iPCallShareCouponCardUI), new OnClickListener(iPCallShareCouponCardUI) {
                        final /* synthetic */ IPCallShareCouponCardUI nMs;

                        {
                            this.nMs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
                } else {
                    iPCallShareCouponCardUI.l(16, str, iPCallShareCouponCardUI.getString(R.l.epK));
                    break;
                }
            case 6:
                if (!q.Gt()) {
                    h.a(iPCallShareCouponCardUI.mController.xIM, R.l.eLp, R.l.dGO, new 3(iPCallShareCouponCardUI), new 4(iPCallShareCouponCardUI));
                    break;
                } else {
                    iPCallShareCouponCardUI.l(8, str, iPCallShareCouponCardUI.getString(R.l.epI));
                    break;
                }
            case 7:
                try {
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.setType("text/plain");
                    intent.setPackage("com.facebook.orca");
                    iPCallShareCouponCardUI.startActivity(intent);
                    break;
                } catch (Exception e2) {
                    x.e("MicroMsg.IPCallShareCouponCardUI", "go facebook msger error" + e2.getMessage());
                    break;
                }
            case 8:
                c.c(iPCallShareCouponCardUI, str);
                Toast.makeText(iPCallShareCouponCardUI, R.l.erf, 0).show();
                break;
        }
        g.pQN.h(13340, new Object[]{Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1)});
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.esf);
        setBackBtn(new 1(this));
        this.iP = findViewById(R.h.layout);
        this.nLU = (TextView) findViewById(R.h.bZi);
        this.nLV = (TextView) findViewById(R.h.cam);
        this.nLW = (TextView) findViewById(R.h.bZh);
        this.nLX = (TextView) findViewById(R.h.bZj);
        this.nLY = (Button) findViewById(R.h.cNG);
        this.nLZ = (ImageView) findViewById(R.h.coq);
        this.iP.setVisibility(8);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.nLZ, q.FS(), 0.5f, false);
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.nIK = h.a(context, getString(R.l.eqO), true, new 9(this));
        com.tencent.mm.plugin.ipcall.a.f.b.aUc().gb(false);
        this.Ex = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
        ar.CG().a(257, this);
        ar.CG().a(1804, this);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(257, this);
        ar.CG().b(1804, this);
    }

    protected final int getLayoutId() {
        return R.i.dlZ;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.ipcall.a.d.g) {
            if (i == 0 && i2 == 0) {
                this.iP.setVisibility(0);
                aid aUQ = c.aUQ();
                if (aUQ != null) {
                    this.nMg = aUQ.wpr;
                    this.gAT = aUQ.nfe;
                    this.nMh = aUQ.wps;
                    this.mTitle = aUQ.fon;
                    this.nMi = aUQ.nGK;
                    this.nMj = aUQ.wpt;
                    this.nMl = aUQ.wpu;
                    this.nMm = aUQ.wpv;
                    this.nMn = aUQ.wpw;
                    this.nMo = aUQ.wpy;
                    this.nMp = aUQ.wpx;
                    this.nMq = aUQ.wpz;
                }
                this.nLU.setText(this.nMo);
                this.nLV.setText(String.format(this.mController.xIM.getString(R.l.esa), new Object[]{this.nMg}));
                this.nLY.setOnClickListener(new 11(this));
                this.nLW.setText(String.format(getString(R.l.esc), new Object[]{this.nMo}));
                TextView textView = this.nLX;
                String format = String.format(getString(R.l.esb), new Object[]{this.nMo});
                String string = getString(R.l.ese);
                if (bh.ov(string)) {
                    textView.setText(format);
                } else {
                    String str2;
                    String string2 = getString(R.l.esg);
                    TextPaint paint = textView.getPaint();
                    float measureText = paint.measureText(format);
                    float measureText2 = paint.measureText(string2);
                    int eA = com.tencent.mm.bv.a.eA(this.mController.xIM) - (((LayoutParams) textView.getLayoutParams()).rightMargin + ((LayoutParams) textView.getLayoutParams()).leftMargin);
                    int ceil = (int) Math.ceil((double) (measureText / ((float) eA)));
                    int ceil2 = (int) Math.ceil((double) ((measureText + measureText2) / ((float) eA)));
                    if (ceil == 0) {
                        ceil = 1;
                    }
                    if (ceil2 > ceil) {
                        str2 = "\n" + string2;
                    } else {
                        str2 = string2;
                    }
                    textView.setGravity(17);
                    CharSequence newSpannable = Factory.getInstance().newSpannable(format + str2);
                    newSpannable.setSpan(new 6(this, string), format.length(), str2.length() + format.length(), 33);
                    textView.setText(newSpannable);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                if (this.nIK != null && this.nIK.isShowing()) {
                    this.nIK.dismiss();
                }
            } else if (this.nIK != null && this.nIK.isShowing()) {
                this.nIK.dismiss();
                h.a(this.mController.xIM, getString(R.l.eqM), getString(R.l.eqI), new 10(this));
            }
        } else if (kVar instanceof i) {
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (!com.tencent.mm.plugin.subapp.b.ift.b(this.mController.xIM, i, i2, str)) {
                if (i == 0 && i2 == 0) {
                    h.bu(this, getResources().getString(R.l.dUd));
                } else {
                    h.h(this.mController.xIM, R.l.eKc, R.l.dGO);
                }
            }
        } else if ((kVar instanceof com.tencent.mm.ba.a) && i == 0 && i2 == 0 && this.nMd != null) {
            if (this.nMe != null) {
                this.nMe.setVisibility(8);
            }
            this.nMd.setImageBitmap(aUC());
        }
    }

    public static void a(Context context, int i, TextView textView, ImageView imageView) {
        CharSequence F = F(context, i);
        if (F != null) {
            textView.setText(F);
        }
        int rE = rE(i);
        if (rE != -1) {
            imageView.setImageResource(rE);
        }
    }

    public static String F(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), context.getString(R.l.erg));
        hashMap.put(Integer.valueOf(0), context.getString(R.l.eXx));
        hashMap.put(Integer.valueOf(1), context.getString(R.l.erl));
        hashMap.put(Integer.valueOf(3), context.getString(R.l.erh));
        hashMap.put(Integer.valueOf(2), context.getString(R.l.erk));
        hashMap.put(Integer.valueOf(5), context.getString(R.l.erm));
        hashMap.put(Integer.valueOf(4), context.getString(R.l.ern));
        hashMap.put(Integer.valueOf(6), context.getString(R.l.erj));
        hashMap.put(Integer.valueOf(7), context.getString(R.l.eri));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return (String) hashMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public static int rE(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), Integer.valueOf(R.k.dwk));
        hashMap.put(Integer.valueOf(0), Integer.valueOf(R.k.dwX));
        hashMap.put(Integer.valueOf(1), Integer.valueOf(R.k.dwW));
        hashMap.put(Integer.valueOf(3), Integer.valueOf(R.k.dwl));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(R.k.dwY));
        hashMap.put(Integer.valueOf(5), Integer.valueOf(R.k.dwZ));
        hashMap.put(Integer.valueOf(4), Integer.valueOf(R.k.dxa));
        hashMap.put(Integer.valueOf(6), Integer.valueOf(R.k.dwm));
        hashMap.put(Integer.valueOf(7), Integer.valueOf(R.k.dwV));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return ((Integer) hashMap.get(Integer.valueOf(i))).intValue();
        }
        return -1;
    }

    private static boolean aj(Context context, String str) {
        if (bh.ov(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public final void a(com.tencent.mm.ui.i.a.c cVar) {
        if (this.nMb != null) {
            this.nMb.cancel();
        }
        switch (8.nMz[cVar.ordinal()]) {
            case 1:
                rF(R.l.eRB);
                return;
            case 3:
                rF(R.l.eRA);
                return;
            default:
                return;
        }
    }

    private void rF(int i) {
        h.a(this.mController.xIM, i, R.l.dGO, new 14(this), new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponCardUI nMs;

            {
                this.nMs = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void b(com.tencent.mm.ui.i.a.c cVar) {
    }

    private static Bitmap aUC() {
        byte[] CV = CV(q.FS());
        if (CV == null) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.d.bl(CV);
    }

    private static byte[] CV(String str) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        Throwable th;
        ar.Hg();
        String Fi = com.tencent.mm.z.c.Fi();
        ar.Hg();
        Fi = com.tencent.mm.sdk.platformtools.i.e(Fi, com.tencent.mm.z.c.Fj(), "qr_", com.tencent.mm.a.g.s(str.getBytes()), ".png");
        if (bh.ov(Fi)) {
            x.e("MicroMsg.IPCallShareCouponCardUI", "filename is null");
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(Fi, "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                }
                return bArr;
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                        return null;
                    }
                    try {
                        randomAccessFile.close();
                        return null;
                    } catch (Exception e4) {
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            x.printErrStackTrace("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                return null;
            }
            randomAccessFile.close();
            return null;
        } catch (Throwable e7) {
            randomAccessFile = null;
            th = e7;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private void l(int i, String str, String str2) {
        this.nMr = View.inflate(this.mController.xIM, R.i.deB, null);
        EditText editText = (EditText) this.nMr.findViewById(R.h.bWU);
        this.nMd = (ImageView) this.nMr.findViewById(R.h.bWS);
        this.nMe = (ProgressBar) this.nMr.findViewById(R.h.ctw);
        editText.setText(str);
        Bitmap aUC = aUC();
        if (aUC == null) {
            String FS = q.FS();
            ar.Hg();
            ar.CG().a(new com.tencent.mm.ba.a(FS, bh.e((Integer) com.tencent.mm.z.c.CU().get(66561, null))), 0);
            this.nMe.setVisibility(0);
        } else if (this.nMd != null) {
            this.nMd.setImageBitmap(aUC);
        }
        com.tencent.mm.pluginsdk.ui.applet.e.a(this.mController, str2, this.nMr, getResources().getString(R.l.dGA), new 5(this, editText, str, i));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bh.ov(stringExtra)) {
                com.tencent.mm.pluginsdk.ui.applet.e.a(this.mController, this.mTitle, this.nMh, this.gAT, null, true, getResources().getString(R.l.dGA), new 7(this, stringExtra));
            }
        }
    }
}
