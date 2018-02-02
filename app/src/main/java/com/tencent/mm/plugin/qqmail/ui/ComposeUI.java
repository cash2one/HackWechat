package com.tencent.mm.plugin.qqmail.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.qqmail.b.c;
import com.tencent.mm.plugin.qqmail.b.d;
import com.tencent.mm.plugin.qqmail.b.e;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.j$a;
import com.tencent.mm.plugin.qqmail.b.p$a;
import com.tencent.mm.plugin.qqmail.b.p$c;
import com.tencent.mm.plugin.qqmail.b.t;
import com.tencent.mm.plugin.qqmail.b.u;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI extends MMActivity {
    private static List<i> pqv;
    private int mode = 5;
    private int poc = 1;
    private Map<String, String> ppA = new HashMap();
    private long ppZ;
    private v ppt = w.bkt();
    private LinearLayout pqA;
    private MailAddrsViewControl pqB;
    private ImageView pqC;
    private LinearLayout pqD;
    private MailAddrsViewControl pqE;
    private ImageView pqF;
    private EditText pqG;
    private LinearLayout pqH;
    private TextView pqI;
    private ImageView pqJ;
    private LinearLayout pqK;
    private TextView pqL;
    private EditText pqM;
    private WebView pqN;
    private j pqO;
    private b pqP;
    public c pqQ = new c(this);
    private r pqR;
    private String pqS;
    private q pqT;
    public boolean pqU = true;
    public boolean pqV = true;
    public boolean pqW = false;
    private String pqX = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    private String pqY = "document.getElementById('history').innerHTML";
    private String pqZ = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    private ScrollView pqw;
    protected MailAddrsViewControl pqx;
    private ImageView pqy;
    private LinearLayout pqz;
    private String pra = "</div>";
    private String prb = null;
    private String prc = null;
    private String prd = "weixin://get_img_info/";
    private String pre = "weixin://get_mail_content/";
    private String prf = "weixin://img_onclick/";
    private boolean prg = false;
    private boolean prh = false;
    private ak pri = new ak(new 1(this), true);
    private ak prj = new ak(new 12(this), true);
    j$a prk = new 17(this);
    private OnClickListener prl = new 7(this);
    private OnClickListener prm = new 8(this);
    private OnMenuItemClickListener prn = new 10(this);
    private OnClickListener pro = new 11(this);
    private OnClickListener prp = new 13(this);
    private p$a prq = new 15(this);

    static /* synthetic */ long H(ComposeUI composeUI) {
        Map hashMap = new HashMap();
        hashMap.put("from", "");
        hashMap.put("to", composeUI.pqx.bkY());
        hashMap.put("cc", composeUI.pqB.bkY());
        hashMap.put("bcc", composeUI.pqE.bkY());
        hashMap.put("subject", composeUI.getSubject());
        hashMap.put("content", composeUI.bkG());
        hashMap.put("attachlist", composeUI.pqP.bkN());
        hashMap.put("sendtype", (composeUI.poc == 4 ? 1 : composeUI.poc));
        hashMap.put("oldmailid", composeUI.pqS);
        p$c com_tencent_mm_plugin_qqmail_b_p_c = new p$c();
        com_tencent_mm_plugin_qqmail_b_p_c.ppk = false;
        com_tencent_mm_plugin_qqmail_b_p_c.ppj = true;
        return w.bks().a("/cgi-bin/composesendwithattach", hashMap, com_tencent_mm_plugin_qqmail_b_p_c, composeUI.prq);
    }

    static /* synthetic */ boolean a(ComposeUI composeUI, boolean z) {
        if (z && composeUI.pqx.psU.size() == 0 && composeUI.pqB.psU.size() == 0 && composeUI.pqE.psU.size() == 0 && !composeUI.pqx.bkX() && !composeUI.pqB.bkX() && !composeUI.pqE.bkX()) {
            return false;
        }
        if (composeUI.mode == 5) {
            if (composeUI.pqG.getText().toString().trim().length() == 0 && composeUI.pqP.bkO().size() == 0 && composeUI.pqM.getText().length() == 0) {
                return false;
            }
        } else if (composeUI.mode == 6 && composeUI.pqG.getText().toString().trim().length() == 0 && composeUI.pqP.bkO().size() == 0) {
            return false;
        }
        return true;
    }

    static /* synthetic */ void b(ComposeUI composeUI) {
        d dVar = new d();
        dVar.poc = composeUI.poc;
        dVar.pod = composeUI.pqS;
        dVar.poe = composeUI.pqx.psU;
        dVar.pof = composeUI.pqB.psU;
        dVar.pog = composeUI.pqE.psU;
        dVar.poi = composeUI.pqG.getText().toString();
        dVar.poh = composeUI.pqP.bkO();
        if (composeUI.mode != 6 && composeUI.mode == 5) {
            dVar.content = composeUI.bkG();
            dVar.poj = composeUI.mode;
            x.i("MicroMsg.ComposeUI", "save draft mail as normal mode");
        }
        c cVar = w.bks().poZ;
        try {
            cVar.pob.bkg();
            e.q(cVar.pob.pol + c.bT(dVar.pod, dVar.poc), dVar.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
        }
    }

    static /* synthetic */ void r(ComposeUI composeUI) {
        String str = null;
        ar.Hg();
        String oVar = new o(((Integer) com.tencent.mm.z.c.CU().get(9, null)).intValue()).toString();
        oVar = !bh.ov(oVar) ? oVar + "@qq.com" : null;
        u uVar = new u();
        uVar.fzO = oVar;
        uVar.poi = composeUI.getSubject();
        if (!bh.ov(composeUI.pqx.bkY())) {
            uVar.poM = composeUI.pqx.bkY().split(",");
        }
        if (!bh.ov(composeUI.pqB.bkY())) {
            uVar.poN = composeUI.pqB.bkY().split(",");
        }
        if (!bh.ov(composeUI.pqE.bkY())) {
            uVar.poO = composeUI.pqE.bkY().split(",");
        }
        oVar = composeUI.bkG();
        if (!bh.ov(oVar)) {
            str = oVar.replaceAll("src=\"file://", "src=\"cid:").replaceAll("height=\"100\"", "style=\"max-width: 200px; max-width:300px;\"");
        }
        uVar.ppz = str;
        if (composeUI.ppA.size() > 0) {
            Map map = composeUI.ppA;
            uVar.ppA = new HashMap();
            uVar.ppA.putAll(map);
        }
        x.d("MicroMsg.ComposeUI", "send mail content: \n%s", new Object[]{str});
        x.d("MicroMsg.ComposeUI", "msgImgInfoMap.size: %d", new Object[]{Integer.valueOf(composeUI.ppA.size())});
        x.d("MicroMsg.ComposeUI", "uploadedAttachidMap.size: %d", new Object[]{Integer.valueOf(composeUI.pqP.pso.size())});
        if (composeUI.pqP.pso.size() > 0 && composeUI.pqP.psp.size() > 0) {
            map = composeUI.pqP.pso;
            uVar.ppB = new LinkedHashMap();
            uVar.ppB.putAll(map);
            map = composeUI.pqP.psp;
            uVar.ppC = new LinkedHashMap();
            uVar.ppC.putAll(map);
        }
        v vVar = composeUI.ppt;
        if (vVar.ppE == null) {
            vVar.ppE = new t();
        }
        vVar.ppE.a(uVar);
        composeUI.prh = false;
        h.bu(composeUI.mController.xIM, composeUI.getString(R.l.eic));
        ag.h(new 14(composeUI), 800);
    }

    static /* synthetic */ void y(ComposeUI composeUI) {
        composeUI.pqy.setVisibility(4);
        composeUI.pqC.setVisibility(4);
        composeUI.pqF.setVisibility(4);
    }

    protected final int getLayoutId() {
        return R.i.dpT;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.prb = this.pqZ + "%s" + this.pra;
        this.prg = false;
        this.prh = false;
        this.poc = getIntent().getIntExtra("composeType", 1);
        this.pqS = getIntent().getStringExtra("mailid");
        if (this.pqS == null) {
            this.pqS = "";
        }
        this.mode = getIntent().getIntExtra("mail_mode", 5);
        x.d("MicroMsg.ComposeUI", "onCreate, mode = %d", new Object[]{Integer.valueOf(this.mode)});
        initView();
        this.pqO = w.bks().poY;
        this.pqO.a(this.prk);
        this.pqO.bki();
        this.prj.J(180000, 180000);
    }

    protected void onResume() {
        super.onResume();
        this.pri.J(1500, 1500);
    }

    protected void onPause() {
        super.onPause();
        aWs();
        this.pri.TG();
        if (this.pqT != null) {
            this.pqT.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (pqv != null) {
            pqv = null;
        }
        this.pqP.bkP();
        ar.CG().b(484, this.pqP);
        this.pqO.b(this.prk);
        this.pqQ.release();
        this.prj.TG();
    }

    private void bkE() {
        this.pqx.clearFocus();
        this.pqB.clearFocus();
        this.pqE.clearFocus();
    }

    protected final void initView() {
        String str;
        CharSequence charSequence;
        this.pqw = (ScrollView) findViewById(R.h.cEQ);
        this.pqx = (MailAddrsViewControl) findViewById(R.h.cEM);
        this.pqy = (ImageView) findViewById(R.h.cEH);
        this.pqz = (LinearLayout) findViewById(R.h.cEP);
        this.pqA = (LinearLayout) findViewById(R.h.cEL);
        this.pqB = (MailAddrsViewControl) findViewById(R.h.cEK);
        this.pqC = (ImageView) findViewById(R.h.cEG);
        this.pqD = (LinearLayout) findViewById(R.h.cEJ);
        this.pqE = (MailAddrsViewControl) findViewById(R.h.cEI);
        this.pqF = (ImageView) findViewById(R.h.cEF);
        this.pqG = (EditText) findViewById(R.h.cEU);
        this.pqH = (LinearLayout) findViewById(R.h.cEE);
        this.pqL = (TextView) findViewById(R.h.cCZ);
        this.pqM = (EditText) findViewById(R.h.cER);
        this.pqN = a.l(this, R.h.cES);
        this.pqI = (TextView) findViewById(R.h.cEO);
        this.pqJ = (ImageView) findViewById(R.h.cEN);
        this.pqK = (LinearLayout) findViewById(R.h.cCY);
        this.pqx.bkW();
        this.pqB.bkW();
        this.pqE.bkW();
        CharSequence stringExtra = getIntent().getStringExtra("mail_content");
        List<String> stringArrayListExtra = getIntent().getStringArrayListExtra("mail_attach");
        List stringArrayListExtra2 = getIntent().getStringArrayListExtra("mail_attach_title");
        d bS = w.bks().poZ.bS(this.pqS, this.poc);
        this.pqP = new b(this, this.pqI, this.pqJ, this.pqK, (byte) 0);
        if (!bh.ov(stringExtra)) {
            x.i("MicroMsg.ComposeUI", "read mail from extra");
            if (this.mode == 6) {
                bkF();
                this.pqx.requestFocus();
                this.prc = String.format(this.prb, new Object[]{stringExtra});
                this.pqN.loadDataWithBaseURL("", this.prc, "text/html", ProtocolPackage.ServerEncoding, "");
                this.pqM.setVisibility(8);
                this.pqN.setVisibility(0);
            } else if (this.mode == 5) {
                this.pqM.setVisibility(0);
                this.pqN.setVisibility(8);
                if (stringExtra.indexOf("<div>") != -1) {
                    x.i("MicroMsg.ComposeUI", "set content in html format");
                    this.pqM.setText(Html.fromHtml(stringExtra));
                } else {
                    this.pqM.setText(stringExtra);
                }
            }
            this.pqP.mode = this.mode;
            if (this.mode == 6) {
                int i = 0;
                for (String str2 : stringArrayListExtra) {
                    File file = new File(str2);
                    if (file.exists()) {
                        if (((int) file.length()) + this.pqP.bkS() > 52428800) {
                            h.a((Context) this, R.l.eAP, R.l.dGO, null);
                            break;
                        }
                        x.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[]{Integer.valueOf(this.mode)});
                        int i2 = i + 1;
                        this.pqP.dI(str2, (String) stringArrayListExtra2.get(i));
                        i = i2;
                    }
                }
            }
        } else if (bS == null || this.mode != 6) {
            x.i("MicroMsg.ComposeUI", "no extra or draf mail content");
            if (this.mode == 6) {
                bkF();
                this.pqx.requestFocus();
                this.prc = String.format(this.prb, new Object[]{""});
                this.pqN.loadDataWithBaseURL("", this.prc, "text/html", ProtocolPackage.ServerEncoding, "");
                this.pqM.setVisibility(8);
                this.pqN.setVisibility(0);
            } else if (this.mode == 5) {
                this.pqN.setVisibility(8);
                this.pqM.setVisibility(0);
            }
            this.pqP.mode = this.mode;
        } else {
            x.i("MicroMsg.ComposeUI", "read mail from draftMail");
            this.pqx.bs(bS.poe);
            this.pqB.bs(bS.pof);
            this.pqE.bs(bS.pog);
            this.pqG.setText(bS.poi);
            charSequence = bS.content;
            this.mode = 5;
            if (charSequence.indexOf("<div>") != -1) {
                x.i("MicroMsg.ComposeUI", "set content in html format");
                this.pqM.setText(Html.fromHtml(charSequence));
            } else {
                this.pqM.setText(charSequence);
            }
            this.pqP.mode = this.mode;
            this.pqP.br(bS.poh);
            this.pqP.bkR();
            this.pqN.setVisibility(8);
            this.pqM.setVisibility(0);
        }
        String[] stringArrayExtra;
        if (this.poc != 1) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            String[] stringArrayExtra2 = getIntent().getStringArrayExtra("ccList");
            String[] stringArrayExtra3 = getIntent().getStringArrayExtra("bccList");
            String stringExtra2 = getIntent().getStringExtra("subject");
            this.pqx.a(stringArrayExtra, false);
            this.pqB.a(stringArrayExtra2, false);
            this.pqE.a(stringArrayExtra3, false);
            if (!bh.ov(stringExtra2)) {
                EditText editText = this.pqG;
                StringBuilder stringBuilder = new StringBuilder();
                if (this.poc == 2) {
                    str2 = "Re:";
                } else {
                    str2 = "Fwd:";
                }
                editText.setText(stringBuilder.append(str2).append(stringExtra2).toString());
            }
        } else if (this.poc == 2 || this.poc == 3) {
            this.pqL.setVisibility(0);
        } else if (this.poc == 4) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                this.pqx.a(stringArrayExtra, false);
            }
        } else if (this.poc == 1) {
            charSequence = getIntent().getStringExtra("subject");
            if (!bh.ov(charSequence)) {
                this.pqG.setText(charSequence);
            }
        }
        if (this.pqB.psU.size() > 0 || this.pqE.psU.size() > 0) {
            this.pqz.setVisibility(8);
            this.pqA.setVisibility(0);
            this.pqD.setVisibility(0);
        }
        if (this.poc == 2 && this.mode != 6 && this.mode == 5) {
            this.pqM.requestFocus();
            this.pqM.setSelection(0);
            this.pqw.postDelayed(new 18(this), 1000);
        }
        this.pqx.psX = new c(this, this.pqy, 0);
        this.pqB.psX = new c(this, this.pqC, 1);
        this.pqE.psX = new c(this, this.pqF, 2);
        MailAddrsViewControl.a 19 = new 19(this);
        this.pqx.psZ = 19;
        this.pqB.psZ = 19;
        this.pqE.psZ = 19;
        this.pqy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposeUI prr;

            {
                this.prr = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.prr, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", this.prr.pqx.a(false, null));
                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
                this.prr.startActivityForResult(intent, 0);
                this.prr.overridePendingTransition(R.a.bqo, R.a.bqa);
            }
        });
        this.pqC.setOnClickListener(new 21(this));
        this.pqF.setOnClickListener(new 22(this));
        this.pqz.setOnClickListener(this.prl);
        ImageView imageView = (ImageView) findViewById(R.h.cET);
        if (this.pqV && this.pqG.getText().length() > 0) {
            imageView.setVisibility(0);
        }
        this.pqG.setOnFocusChangeListener(new 23(this));
        this.pqG.addTextChangedListener(new 2(this, imageView));
        imageView.setOnClickListener(new 3(this));
        this.pqH.setOnClickListener(this.prm);
        setMMTitle(R.l.eAz);
        if (getIntent().getBooleanExtra("show_qqmail", false)) {
            ar.Hg();
            int intValue = ((Integer) com.tencent.mm.z.c.CU().get(9, Integer.valueOf(0))).intValue();
            if (intValue == 0) {
                x.w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
            } else {
                setMMSubTitle(new o(intValue) + "@qq.com");
            }
        }
        setBackBtn(this.prn);
        if (this.mode == 5) {
            addTextOptionMenu(0, getString(R.l.dGA), new 4(this));
        } else if (this.mode == 6) {
            x.i("MicroMsg.ComposeUI", "set onShareModeSendListener");
            addTextOptionMenu(0, getString(R.l.dGA), new 5(this));
        }
        enableOptionMenu(false);
        bkE();
    }

    private void bkF() {
        if (this.pqN != null) {
            this.pqN.clearFocus();
            this.pqN.getSettings().setJavaScriptEnabled(true);
            this.pqN.setWebViewClient(new b(this, (byte) 0));
            this.pqN.setWebChromeClient(new a(this, (byte) 0));
            this.pqN.setOnTouchListener(new 6(this));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.prn.onMenuItemClick(null);
        return true;
    }

    private void arQ() {
        if (!k.c(this, com.tencent.mm.compatible.util.e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(R.l.eJu), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.ComposeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    arQ();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezM), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 9(this), null);
                    return;
                }
            default:
                return;
        }
    }

    private String bkG() {
        if (this.mode == 6) {
            s.a(this.pqN, this.pre, this.pqY);
            if (this.prc != null) {
                int indexOf = this.prc.indexOf(this.pqZ);
                int lastIndexOf = this.prc.lastIndexOf(this.pra);
                if (indexOf == -1 || lastIndexOf == -1) {
                    return this.prc;
                }
                return this.prc.substring(indexOf + this.pqZ.length(), lastIndexOf + this.pra.length());
            }
        } else if (this.mode == 5) {
            return this.pqM.getText().toString();
        }
        return null;
    }

    private String getSubject() {
        int i = 40;
        String obj = this.pqG.getText().toString();
        if (obj.trim().length() > 0) {
            return obj;
        }
        obj = bkG();
        if (this.mode == 5) {
            if (obj.length() > 0) {
                if (obj.length() <= 40) {
                    i = obj.length();
                }
                return obj.substring(0, i);
            }
        } else if (this.mode == 6 && !bh.ov(obj)) {
            if (obj.length() <= 40) {
                i = obj.length();
            }
            return obj.substring(0, i);
        }
        return getString(R.l.eAx);
    }

    protected final boolean bkH() {
        if (!this.pqx.bkZ()) {
            Toast.makeText(this, R.l.eAA, 1).show();
            return false;
        } else if (!this.pqB.bkZ()) {
            Toast.makeText(this, R.l.eAv, 1).show();
            return false;
        } else if (!this.pqE.bkZ()) {
            Toast.makeText(this, R.l.eAu, 1).show();
            return false;
        } else if ((this.pqx.psU.size() + this.pqB.psU.size()) + this.pqE.psU.size() <= 20) {
            return true;
        } else {
            Toast.makeText(this, R.l.eAG, 1).show();
            return false;
        }
    }

    static void bq(List<i> list) {
        pqv = list;
    }

    private static void a(MailAddrsViewControl mailAddrsViewControl) {
        if (pqv != null) {
            List list = pqv;
            if (list != null) {
                int i;
                i iVar;
                int i2;
                for (i = 0; i < mailAddrsViewControl.psU.size(); i++) {
                    iVar = (i) mailAddrsViewControl.psU.get(i);
                    i2 = 0;
                    while (i2 < list.size()) {
                        if (iVar.nQt.equalsIgnoreCase(((i) list.get(i2)).nQt)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == list.size()) {
                        mailAddrsViewControl.f(iVar);
                    }
                }
                for (i = 0; i < list.size(); i++) {
                    iVar = (i) list.get(i);
                    i2 = 0;
                    while (i2 < mailAddrsViewControl.psU.size()) {
                        if (iVar.nQt.equalsIgnoreCase(((i) mailAddrsViewControl.psU.get(i2)).nQt)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == mailAddrsViewControl.psU.size()) {
                        mailAddrsViewControl.e(iVar);
                    }
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            String b;
            switch (i) {
                case 0:
                    a(this.pqx);
                    showVKB();
                    return;
                case 1:
                    a(this.pqB);
                    showVKB();
                    return;
                case 2:
                    a(this.pqE);
                    showVKB();
                    return;
                case 3:
                    ar.Hg();
                    b = k.b(this, intent, com.tencent.mm.z.c.Fi());
                    if (b != null) {
                        HP(b);
                        bkE();
                        return;
                    }
                    return;
                case 4:
                    if (intent != null) {
                        ar.Hg();
                        b = com.tencent.mm.ui.tools.a.c(this, intent, com.tencent.mm.z.c.Fi());
                        if (b != null && b.length() > 0) {
                            HP(b);
                            bkE();
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (intent != null) {
                        HP(intent.getStringExtra("choosed_file_path"));
                        bkE();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void HP(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (this.pqP.psm.containsKey(str)) {
            h.h(this.mController.xIM, R.l.eAN, R.l.dGO);
            return;
        }
        int length = (int) file.length();
        if (length > 20971520) {
            h.a((Context) this, R.l.eAO, R.l.dGO, null);
            return;
        }
        h.a((Context) this, getString(R.l.eAQ, new Object[]{bh.bx((long) length)}), getString(R.l.dGO), new 16(this, length, file, str), null);
    }

    public void setRequestedOrientation(int i) {
    }
}
