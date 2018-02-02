package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.n;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import junit.framework.Assert;

public class FriendPreference extends Preference implements a {
    private int fCC;
    private MMActivity fmM;
    private TextView ihS;
    private x jLe;
    private boolean lRB;
    private TextView pjN;
    private ImageView pjO;
    private ImageView pjP;
    private b pjQ;
    private String pjR;
    private long pjS;
    private long pjT;
    private String pjU;

    public final /* synthetic */ CharSequence getSummary() {
        return this.pjN.getText().toString();
    }

    static /* synthetic */ void a(FriendPreference friendPreference, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
        friendPreference.fmM.startActivity(intent);
    }

    static /* synthetic */ void a(FriendPreference friendPreference, String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.l.dWk), 0).show();
            return;
        }
        n.Jz();
        Bitmap je = d.je(str);
        if (je == null) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.l.dWl), 0).show();
            e eVar = new e();
            eVar.a(str, new 2(friendPreference, eVar, str, str2));
        } else if (friendPreference.q(str2, je)) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.l.dWm), 0).show();
        } else {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.l.dWk), 0).show();
        }
    }

    public FriendPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
        init();
    }

    public FriendPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
        setWidgetLayoutResource(R.i.dod);
        init();
    }

    private void init() {
        this.lRB = false;
        this.jLe = null;
        this.pjQ = null;
        this.pjR = "";
        this.pjS = 0;
        this.pjT = 0;
        this.fCC = 0;
        this.pjU = "";
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnz, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.ihS = (TextView) view.findViewById(R.h.title);
        this.pjN = (TextView) view.findViewById(R.h.summary);
        this.pjO = (ImageView) view.findViewById(R.h.cpk);
        this.pjP = (ImageView) view.findViewById(R.h.cwM);
        this.lRB = true;
        initView();
        super.onBindView(view);
    }

    private void initView() {
        Bitmap aO;
        InputStream inputStream;
        if (this.jLe == null || !this.lRB) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FriendPreference", "initView : contact = " + this.jLe + " bindView = " + this.lRB);
        } else if (this.pjS != -1 && new o(this.pjS).longValue() > 0) {
            setWidgetLayoutResource(R.i.doe);
            if (this.jLe == null || !this.lRB) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FriendPreference", "initView : contact = " + this.jLe + " bindView = " + this.lRB);
                return;
            }
            this.fCC = 2;
            this.ihS.setText(this.mContext.getString(R.l.dVh));
            this.pjN.setText(bh.ou(this.pjR) + " " + new o(this.pjS).longValue());
            aO = com.tencent.mm.ad.b.aO(this.pjS);
            if (aO == null) {
                inputStream = null;
                try {
                    inputStream = this.mContext.getResources().openRawResource(R.k.dyo);
                    r0 = com.tencent.mm.compatible.f.a.decodeStream(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e, "", new Object[0]);
                        }
                    }
                } catch (Throwable e2) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e2, "", new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            r0 = aO;
                        } catch (Throwable e22) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e22, "", new Object[0]);
                            r0 = aO;
                        }
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e3, "", new Object[0]);
                        }
                    }
                }
                if (r0 != null) {
                    r1 = Bitmap.createScaledBitmap(r0, 48, 48, false);
                    if (r1 != r0) {
                        r0.recycle();
                    }
                    this.pjO.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(r1, true, 0.0f));
                }
                ar.Hg();
                if (!c.isSDCardAvailable()) {
                    this.pjO.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.fmM, R.k.bBB));
                }
            }
            r0 = aO;
            if (r0 != null) {
                r1 = Bitmap.createScaledBitmap(r0, 48, 48, false);
                if (r1 != r0) {
                    r0.recycle();
                }
                this.pjO.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(r1, true, 0.0f));
            }
            ar.Hg();
            if (!c.isSDCardAvailable()) {
                this.pjO.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.fmM, R.k.bBB));
            }
        } else if (this.pjQ != null) {
            setWidgetLayoutResource(R.i.dnX);
            if (this.jLe == null || !this.lRB) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FriendPreference", "initView : contact = " + this.jLe + " bindView = " + this.lRB);
            } else if (this.pjQ != null) {
                this.fCC = 1;
                this.ihS.setText(this.mContext.getString(R.l.dVg));
                Object obj = bh.ou(this.pjQ.Nt()) + " " + bh.ou(this.pjQ.Nz()).replace(" ", "");
                this.pjN.setText(obj);
                r1 = m.a(this.pjQ.Ns(), this.mContext);
                if (r1 == null) {
                    this.pjO.setImageDrawable(com.tencent.mm.bv.a.b(this.fmM, R.k.dyn));
                } else {
                    this.pjO.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(Bitmap.createScaledBitmap(r1, 48, 48, false), true, 0.0f));
                }
                ar.Hg();
                if (c.EY().WK(this.pjQ.getUsername())) {
                    this.pjP.setOnClickListener(new 1(this, obj));
                } else {
                    this.pjP.setVisibility(4);
                }
            }
        } else if (this.pjT > 0) {
            if (this.jLe == null || !this.lRB) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FriendPreference", "initView : contact = " + this.jLe + " bindView = " + this.lRB);
                return;
            }
            this.fCC = 3;
            this.ihS.setText(this.mContext.getString(R.l.enT));
            this.pjN.setText(bh.ou(this.jLe.fWg));
            aO = com.tencent.mm.ad.b.iR(this.pjT);
            if (aO == null) {
                inputStream = null;
                try {
                    inputStream = this.mContext.getResources().openRawResource(R.k.dyo);
                    r0 = com.tencent.mm.compatible.f.a.decodeStream(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e32) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e32, "", new Object[0]);
                        }
                    }
                } catch (Throwable e222) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e222, "", new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            r0 = aO;
                        } catch (Throwable e2222) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e2222, "", new Object[0]);
                            r0 = aO;
                        }
                    }
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e322) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e322, "", new Object[0]);
                        }
                    }
                }
                if (r0 != null) {
                    r1 = Bitmap.createScaledBitmap(r0, 48, 48, false);
                    if (r1 != r0) {
                        r0.recycle();
                    }
                    this.pjO.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(r1, true, 0.0f));
                }
                ar.Hg();
                if (!c.isSDCardAvailable()) {
                    this.pjO.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.fmM, R.k.bBB));
                }
            }
            r0 = aO;
            if (r0 != null) {
                r1 = Bitmap.createScaledBitmap(r0, 48, 48, false);
                if (r1 != r0) {
                    r0.recycle();
                }
                this.pjO.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(r1, true, 0.0f));
            }
            ar.Hg();
            if (!c.isSDCardAvailable()) {
                this.pjO.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.fmM, R.k.bBB));
            }
        } else if (TextUtils.isEmpty(this.pjU)) {
            Assert.assertTrue(false);
        } else if (this.jLe == null || !this.lRB) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FriendPreference", "initView : contact = " + this.jLe + " bindView = " + this.lRB);
        } else {
            this.fCC = 3;
            this.ihS.setText(this.mContext.getString(R.l.eCY));
            this.pjN.setText(bh.ou(this.pjU));
            this.pjO.setVisibility(8);
        }
    }

    private boolean q(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return m.a(str, this.mContext, byteArrayOutputStream.toByteArray());
    }

    public final boolean arS() {
        n.Jz().e(this);
        return true;
    }

    public final void jh(String str) {
        long iT = com.tencent.mm.ad.b.iT(str);
        if (iT > 0 && this.pjS == iT && com.tencent.mm.ad.b.a(str, false, -1) != null) {
            initView();
        }
        if (com.tencent.mm.ad.b.iS(str) == this.pjT && com.tencent.mm.ad.b.a(str, false, -1) != null) {
            initView();
        }
    }
}
