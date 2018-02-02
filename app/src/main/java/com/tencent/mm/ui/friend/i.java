package com.tencent.mm.ui.friend;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.h.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.FileUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class i extends ContentObserver implements e {
    private String fAf;
    private boolean hnr = false;
    private Context mContext;
    private int progress = 0;
    private ContentResolver qxW;
    private boolean qxX = false;
    private boolean qxY = false;
    private String[] qyb;
    private String xOX = null;
    private com.tencent.mm.ui.base.i xQA = null;
    private af xQB = new 1(this);
    private ProgressBar xQz;
    private s xRm;
    private String xUZ;
    private final a zdB;
    private t zdC;
    private t zdD;
    private s zdE;
    private String zdF;
    private boolean zdG = false;
    private View zdH;
    public boolean zdI = true;
    private int zdJ;

    public i(int i, Context context, a aVar) {
        super(af.fetchFreeHandler());
        this.zdJ = i;
        this.zdG = false;
        this.mContext = context;
        this.qyb = this.mContext.getResources().getStringArray(R.c.bra);
        this.zdH = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.dpM, null);
        this.xQz = (ProgressBar) this.zdH.findViewById(R.h.cDZ);
        this.zdB = aVar;
    }

    public final void ZQ(String str) {
        if (this.zdJ == b.zdM || this.zdJ == b.zdN) {
            ar.CG().a(132, this);
        } else {
            ar.CG().a(c.CTRL_INDEX, this);
        }
        this.fAf = str;
        this.qxX = false;
        this.qxY = false;
        this.zdF = "";
        this.hnr = false;
        if (this.zdJ == b.zdM || this.zdJ == b.zdN) {
            int i = 1;
            if (this.zdJ == b.zdN) {
                i = 18;
            }
            this.zdD = new t(this.fAf, i, "", 0, "");
            ar.CG().a(this.zdD, 0);
        } else {
            this.xRm = new s(this.fAf, this.zdG ? 8 : 5, "", 0, "");
            ar.CG().a(this.xRm, 0);
        }
        if (this.xQA == null) {
            this.xQA = h.a(this.mContext, false, this.mContext.getString(R.l.dLx), this.zdH, "", "", null, null);
        } else {
            this.xQA.show();
        }
        this.progress = 0;
        this.xQz.setIndeterminate(false);
        this.xQB.sendEmptyMessage(1000);
    }

    public final void recycle() {
        ar.CG().b(132, this);
        ar.CG().b(c.CTRL_INDEX, this);
        this.mContext = null;
        this.hnr = true;
        if (this.xQA != null) {
            this.xQA.dismiss();
        }
    }

    private boolean aW(int i, String str) {
        switch (i) {
            case -214:
                a eA = a.eA(str);
                if (eA == null) {
                    return true;
                }
                eA.a(this.mContext, null, null);
                return true;
            case -74:
                h.a(this.mContext, R.l.dKP, R.l.dGO, null);
                return true;
            case -59:
                h.a(this.mContext, R.l.dKU, R.l.dGO, null);
                return true;
            case -57:
            case -1:
                Toast.makeText(this.mContext, R.l.dEP, 0).show();
                return true;
            case -43:
                x.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
                this.hnr = true;
                if (b.zdM == this.zdJ || this.zdJ == b.zdN) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(4097, "");
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(6, this.fAf);
                    this.mContext.getApplicationContext();
                    com.tencent.mm.modelfriend.a.Nm();
                }
                Eh(1);
                Toast.makeText(this.mContext, R.l.dKQ, 0).show();
                return true;
            case -41:
                Toast.makeText(this.mContext, R.l.dKS, 0).show();
                return true;
            case -36:
                Toast.makeText(this.mContext, R.l.dKV, 0).show();
                return true;
            case -35:
                if (this.zdJ == b.zdL) {
                    Eh(3);
                    return true;
                }
                h.a(this.mContext, R.l.dKR, R.l.bNB, new OnClickListener(this) {
                    final /* synthetic */ i zdK;

                    {
                        this.zdK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            case -34:
                Toast.makeText(this.mContext, R.l.dKT, 0).show();
                return true;
            case -4:
                if (this.zdG) {
                    Eh(6);
                    return true;
                }
                break;
        }
        return false;
    }

    private void Eh(int i) {
        if (this.zdJ == b.zdM || this.zdJ == b.zdN) {
            ar.CG().a(132, this);
        } else {
            ar.CG().a(c.CTRL_INDEX, this);
        }
        if (this.zdB != null) {
            this.zdB.Eh(i);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (!kVar.equals(this.zdC) && !kVar.equals(this.zdD) && !kVar.equals(this.zdE) && !kVar.equals(this.xRm)) {
            x.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
        } else if (!this.hnr) {
            if (i == 1 || i == 2) {
                x.d("MicroMsg.SmsBindMobileObserver", "error net");
                if (this.xQA != null) {
                    this.xQA.dismiss();
                }
                Eh(4);
            } else if (b.zdM == this.zdJ && kVar.getType() == 132) {
                k(i, i2, str, kVar);
            } else if (b.zdN == this.zdJ && kVar.getType() == 132) {
                k(i, i2, str, kVar);
            } else if (b.zdL == this.zdJ && kVar.getType() == c.CTRL_INDEX) {
                switch (((s) kVar).IS()) {
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                        if ((((s) kVar).IS() == 6 || ((s) kVar).IS() == 9) && this.xQA != null) {
                            this.xQA.dismiss();
                        }
                        int i3 = ((b) ((s) kVar).hnp.Hp()).vBv.vMo;
                        if ((i == 0 && i2 == 0) || (i2 == -35 && i3 == 1)) {
                            if (((s) kVar).IS() == 6) {
                                this.xOX = ((s) kVar).NW();
                                x.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.xOX);
                                Eh(1);
                                return;
                            } else if (((s) kVar).IS() == 9) {
                                this.xOX = ((s) kVar).NW();
                                x.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.xOX);
                                ((s) kVar).getUsername();
                                ((s) kVar).NV();
                                return;
                            } else if (((s) kVar).IS() == 5 || ((s) kVar).IS() == 8) {
                                x.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.fAf);
                                if (((s) kVar).IS() == 5 && i2 == -35 && i3 == 1) {
                                    this.zdG = true;
                                    Eh(5);
                                    return;
                                }
                                return;
                            }
                        }
                        if (((s) kVar).IS() == 6 || ((s) kVar).IS() == 9) {
                            if (this.xQA != null) {
                                this.xQA.dismiss();
                            }
                            this.hnr = true;
                            Eh(2);
                            return;
                        } else if (aW(i2, str)) {
                            if (this.xQA != null) {
                                this.xQA.dismiss();
                            }
                            this.hnr = true;
                            return;
                        } else {
                            this.hnr = true;
                            if (this.xQA != null) {
                                this.xQA.dismiss();
                            }
                            Toast.makeText(this.mContext, this.mContext.getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                            return;
                        }
                    default:
                        return;
                }
            } else {
                Assert.assertTrue("code path should not be here!", false);
            }
        }
    }

    private void k(int i, int i2, String str, k kVar) {
        switch (((t) kVar).IS()) {
            case 1:
            case 2:
            case 18:
            case 19:
                if ((((t) kVar).IS() == 2 || ((t) kVar).IS() == 19) && this.xQA != null) {
                    this.xQA.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (((t) kVar).IS() == 2 || ((t) kVar).IS() == 19) {
                        if (this.zdI) {
                            this.mContext.getApplicationContext();
                            com.tencent.mm.modelfriend.a.Nm();
                        }
                        Eh(1);
                        return;
                    } else if (((t) kVar).IS() == 1 || ((t) kVar).IS() == 18) {
                        x.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.fAf);
                        return;
                    }
                }
                if (aW(i2, str)) {
                    if (this.xQA != null) {
                        this.xQA.dismiss();
                    }
                    this.hnr = true;
                    return;
                } else if (((t) kVar).IS() == 2) {
                    if (this.xQA != null) {
                        this.xQA.dismiss();
                    }
                    this.hnr = true;
                    Eh(2);
                    return;
                } else {
                    this.hnr = true;
                    if (this.xQA != null) {
                        this.xQA.dismiss();
                    }
                    a eA = a.eA(str);
                    if (eA != null) {
                        eA.a(this.mContext, null, null);
                        return;
                    }
                    Toast.makeText(this.mContext, this.mContext.getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                }
            default:
                return;
        }
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        if (this.mContext instanceof Activity) {
            x.i("MicroMsg.SmsBindMobileObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "")), bh.cgy(), this.mContext});
            if (!com.tencent.mm.pluginsdk.g.a.a((Activity) this.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "")) {
                return;
            }
        }
        cos();
    }

    public final void cos() {
        x.v("MicroMsg.SmsBindMobileObserver", "sms number:" + this.zdF);
        if (!this.qxX && !this.hnr && !this.qxY) {
            Uri parse = Uri.parse("content://sms/inbox");
            this.qxW = this.mContext.getContentResolver();
            String[] strArr = new String[]{"body", "_id", FFmpegMetadataRetriever.METADATA_KEY_DATE};
            String cwX = cwX();
            if (cwX != null && !cwX.equals("")) {
                Cursor query;
                try {
                    query = this.qxW.query(parse, strArr, cwX, null, null);
                } catch (Throwable e) {
                    x.e("MicroMsg.SmsBindMobileObserver", "get sms failed");
                    x.printErrStackTrace("MicroMsg.SmsBindMobileObserver", e, "", new Object[0]);
                    query = null;
                }
                if (query != null) {
                    int i = -1;
                    long j = 0;
                    while (query.moveToNext()) {
                        long j2 = query.getLong(2);
                        if (j2 > j) {
                            i = query.getPosition();
                            j = j2;
                        }
                    }
                    this.xUZ = null;
                    if (i >= 0) {
                        String group;
                        this.qxY = true;
                        query.moveToPosition(i);
                        Matcher matcher = Pattern.compile("\\d{4,8}").matcher(query.getString(query.getColumnIndex("body")));
                        if (matcher.find()) {
                            group = matcher.group();
                        } else {
                            group = null;
                        }
                        this.xUZ = group;
                        if (this.xQA != null) {
                            this.xQA.setCancelable(true);
                        }
                        if (this.zdJ == b.zdM || this.zdJ == b.zdN) {
                            com.tencent.mm.sdk.b.b hoVar = new ho();
                            hoVar.fxR.context = this.mContext;
                            com.tencent.mm.sdk.b.a.xef.m(hoVar);
                            String str = hoVar.fxS.fxT;
                            hoVar = new hp();
                            com.tencent.mm.sdk.b.a.xef.m(hoVar);
                            this.zdC = new t(this.fAf, this.zdJ == b.zdN ? 19 : 2, this.xUZ, "", str, hoVar.fxU.fxV);
                            ar.CG().a(this.zdC, 0);
                        } else {
                            this.zdE = new s(this.fAf, this.zdG ? 9 : 6, this.xUZ, 0, "");
                            ar.CG().a(this.zdE, 0);
                        }
                    }
                    query.close();
                }
            }
        }
    }

    private String cwX() {
        String str = "( ";
        for (int i = 0; i < this.qyb.length; i++) {
            if (i == this.qyb.length - 1) {
                str = str + " body like \"%" + this.qyb[i] + "%\" ) ";
            } else {
                str = str + "body like \"%" + this.qyb[i] + "%\" or ";
            }
        }
        str = str + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        x.v("MicroMsg.SmsBindMobileObserver", "sql where:" + str);
        return str;
    }
}
