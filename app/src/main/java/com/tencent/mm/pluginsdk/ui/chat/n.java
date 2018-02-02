package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.b.b;
import com.tencent.mm.bg.b.b.1;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.VoiceInputUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class n extends LinearLayout {
    String flw = "";
    private Context mContext;
    private TelephonyManager nCb;
    PhoneStateListener nCc;
    private Button okw;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a vmc = new 7(this);
    private boolean vmh = false;
    private MMEditText vmn;
    private int vpp = com.tencent.mm.bv.a.fromDPToPix(getContext(), com.tencent.mm.plugin.appbrand.game.d.a.CTRL_INDEX);
    private i vqb;
    private VoiceInputLayout vrQ;
    private ImageButton vrR;
    private Button vrS;
    public a vrT;
    private MMEditText vrU = null;
    private VoiceInputScrollView vrV;
    private TextView vrW;
    private long vrX = 0;
    private boolean vrY = false;
    private float vrZ = 0.0f;
    private float vsa = 0.0f;
    private boolean vsb = false;
    private boolean vsc = false;
    private boolean vsd = false;
    private int vse = 300;
    private final String vsf = "voiceinput_downdistance_content";
    private boolean vsg = false;
    private boolean vsh = false;
    private long vsi = 0;
    private long vsj = 0;
    private long vsk = 0;
    private boolean vsl = false;
    private boolean vsm = false;
    private final int vsn = 2;
    private boolean vso = false;
    public String vsp = "";
    private Toast vsq;
    private Set<String> vsr = new HashSet();
    private com.tencent.mm.pluginsdk.ui.n vss;
    private c<sj> vst;
    private b vsu;
    private VoiceInputLayout.b vsv = new 9(this);
    private boolean vsw = true;

    public interface a {
        void Px(String str);

        void bTZ();

        void ky(boolean z);
    }

    static /* synthetic */ void a(n nVar, int i) {
        x.d("MicroMsg.VoiceInputPanel", "sendMsg");
        if (nVar.vmn != null && nVar.vmn.getText() != null) {
            String obj = nVar.vmn.getText().toString();
            if (obj.trim().length() == 0 && obj.length() == 0) {
                if (nVar.vqb == null || !nVar.vqb.isShowing()) {
                    nVar.vqb = h.h(nVar.getContext(), R.l.dQN, R.l.dGO);
                }
            } else if (nVar.vrT != null) {
                if (!nVar.vrY) {
                    VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                    voiceInputBehavior.send = 1;
                    if (nVar.vsm) {
                        voiceInputBehavior.send = 2;
                    }
                    if (i != 1) {
                        if (i == 4) {
                            voiceInputBehavior.send = 4;
                        }
                        a(voiceInputBehavior);
                        x.i("MicroMsg.VoiceInputPanel", "cgiReport size = %s", new Object[]{Integer.valueOf(nVar.vsr.size())});
                        if (nVar.vsu == null) {
                            nVar.vsu = new b();
                        }
                        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100235");
                        x.i("MicroMsg.VoiceInputPanel", "cgiReport: abTestFlag = [%s]", new Object[]{Integer.valueOf(fn.isValid() ? bh.getInt((String) fn.chI().get("MMVoipVadOn"), 0) : 0)});
                        b bVar = nVar.vsu;
                        Collection collection = nVar.vsr;
                        String valueOf = String.valueOf(r0);
                        Set hashSet = new HashSet();
                        hashSet.addAll(collection);
                        g.Dm().F(new 1(bVar, hashSet, obj, valueOf));
                        nVar.vsr.clear();
                    }
                }
                x.i("MicroMsg.VoiceInputPanel", "sendMsg onSendMsg");
                nVar.vrT.Px(obj);
            }
        } else if (nVar.vqb == null || !nVar.vqb.isShowing()) {
            nVar.vqb = h.h(nVar.getContext(), R.l.dQN, R.l.dGO);
        }
    }

    static /* synthetic */ boolean a(n nVar, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (nVar.vrV.getScrollY() <= 0) {
                nVar.vsc = true;
                nVar.vrZ = motionEvent.getRawY();
            }
            nVar.vsd = true;
        } else if (motionEvent.getAction() == 2) {
            nVar.vsb = true;
        } else if (motionEvent.getAction() == 1) {
            float f;
            if (nVar.vsb && nVar.vsc) {
                nVar.vsa = motionEvent.getRawY();
                f = nVar.vsa - nVar.vrZ;
            } else {
                f = 0.0f;
            }
            nVar.vsd = false;
            nVar.vsb = false;
            nVar.vsc = false;
            nVar.vsa = 0.0f;
            nVar.vrZ = 0.0f;
            if (f > ((float) nVar.vse)) {
                if (!(nVar.vmn == null || nVar.vmn.getText() == null || nVar.vmn.getText().length() <= 0)) {
                    SharedPreferences cft = ac.cft();
                    if (cft != null) {
                        cft.edit().putString("voiceinput_downdistance_content", nVar.vmn.getText().toString()).apply();
                        x.d("MicroMsg.VoiceInputPanel", "onDownDistance save memory content");
                    }
                }
                nVar.ccd();
            } else if (nVar.vmh) {
                nVar.vmh = false;
            } else if ((view instanceof MMEditText) && nVar.vmn != null && nVar.vmn.getText() != null && nVar.vmn.getText().length() > 0) {
                Spannable newSpannable = Factory.getInstance().newSpannable(((MMEditText) view).getText());
                MMEditText mMEditText = (MMEditText) view;
                motionEvent.getAction();
                int x = (((int) motionEvent.getX()) - mMEditText.getTotalPaddingLeft()) + mMEditText.getScrollX();
                int y = (((int) motionEvent.getY()) - mMEditText.getTotalPaddingTop()) + mMEditText.getScrollY();
                Layout layout = mMEditText.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    clickableSpanArr[0].onClick(view);
                } else {
                    x.i("MicroMsg.VoiceInputPanel", "startVoiceInputUIActivity offset = %s", new Object[]{Integer.valueOf(((MMEditText) view).getOffsetForPosition(motionEvent.getX(), motionEvent.getY()))});
                    if (nVar.vrQ != null) {
                        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                        voiceInputBehavior.textClick = nVar.vrQ.vlD;
                        a(voiceInputBehavior);
                    }
                    Intent intent = new Intent();
                    intent.setClass(nVar.getContext(), VoiceInputUI.class);
                    intent.putExtra("offset", offsetForHorizontal);
                    intent.putExtra("userCode", nVar.flw);
                    if (!(nVar.vmn == null || nVar.vmn.getText() == null)) {
                        intent.putExtra("text", nVar.vmn.getText().toString());
                        if (nVar.vss != null) {
                            nVar.vss.b(nVar.vmn);
                        }
                    }
                    if (nVar.vsp.equalsIgnoreCase("。") || nVar.vsp.equalsIgnoreCase(".")) {
                        intent.putExtra("punctuation", nVar.vsp);
                    }
                    nVar.getContext().startActivity(intent);
                    if (nVar.vrQ != null) {
                        bh.hideVKB(nVar.vrQ);
                        nVar.vrQ.caz();
                    }
                }
            }
            return view instanceof MMEditText;
        }
        return view instanceof MMEditText;
    }

    static /* synthetic */ void b(n nVar, int i) {
        if (nVar.vsq != null) {
            nVar.vsq.cancel();
        }
        nVar.vsq = Toast.makeText(nVar.mContext, nVar.mContext.getResources().getString(i), 0);
        nVar.vsq.setGravity(17, 0, 0);
        nVar.vsq.show();
    }

    static /* synthetic */ void c(n nVar, int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.fail = i;
        a(voiceInputBehavior);
        Cr(i);
    }

    static /* synthetic */ void ccf() {
        x.i("MicroMsg.VoiceInputPanel", "pauseMusic");
        ar.Hh().xS();
    }

    static /* synthetic */ void s(n nVar) {
        if (nVar.vmn != null && nVar.vmn.getText() != null) {
            String obj = nVar.vmn.getText().toString();
            if (obj.length() <= 0) {
                return;
            }
            if (!nVar.vrY || nVar.vmn.getSelectionStart() >= obj.length()) {
                nVar.vsp = obj.substring(obj.length() - 1, obj.length());
                x.i("MicroMsg.VoiceInputPanel", "delPunctuation msg = %s ,msg.length() = %s, punctuation = %s", new Object[]{bh.VT(obj), Integer.valueOf(obj.length()), nVar.vsp});
                if (nVar.vsp.equalsIgnoreCase("。") || nVar.vsp.equalsIgnoreCase(".")) {
                    nVar.vmn.setText(obj.substring(0, obj.length() - 1));
                }
            }
        }
    }

    static /* synthetic */ void u(n nVar) {
        if (nVar.vmn != null && nVar.vmn.getText() != null && nVar.vmn.getText().length() > 0) {
            if (nVar.vsp.equalsIgnoreCase("。") || nVar.vsp.equalsIgnoreCase(".")) {
                if (!nVar.vrY || nVar.vmn.getSelectionStart() >= nVar.vmn.getText().length()) {
                    nVar.vss.a(nVar.vmn, nVar.vsp, true);
                    nVar.vss.b(nVar.vmn);
                }
                nVar.vsp = "";
            }
            String obj = nVar.vmn.getText().toString();
            x.i("MicroMsg.VoiceInputPanel", "addPunctuation msg = %s,msg.length() = %s", new Object[]{bh.VT(obj), Integer.valueOf(obj.length())});
        }
    }

    public n(Context context, boolean z, MMEditText mMEditText) {
        super(context);
        this.mContext = context;
        this.vrY = z;
        this.vrU = mMEditText;
        init();
        this.vss = new com.tencent.mm.pluginsdk.ui.n(this.mContext);
        this.flw = String.valueOf(System.nanoTime());
        x.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[]{this.flw});
        ccc();
    }

    @TargetApi(16)
    private void init() {
        x.d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), R.i.dtz, this);
        this.vrR = (ImageButton) findViewById(R.h.cWr);
        this.vrS = (Button) findViewById(R.h.cWq);
        this.okw = (Button) findViewById(R.h.cWu);
        this.vrW = (TextView) findViewById(R.h.cPs);
        if (this.vrY) {
            this.vrR.setVisibility(4);
        } else {
            this.vrR.setVisibility(0);
        }
        this.okw.setVisibility(4);
        this.vrS.setVisibility(8);
        if (!this.vrY || this.vrU == null) {
            this.vmn = (MMEditText) findViewById(R.h.cWv);
            this.vmn.setHintTextColor(getResources().getColor(R.e.bts));
            this.vmn.setClickable(true);
            this.vmn.setOnLongClickListener(new 1(this));
            this.vmn.setOnTouchListener(new 2(this));
        } else {
            this.vmn = this.vrU;
        }
        this.vrV = (VoiceInputScrollView) findViewById(R.h.cWt);
        this.vrR.setOnClickListener(new 3(this));
        this.okw.setOnClickListener(new 4(this));
        this.vrS.setOnClickListener(new 5(this));
        this.vrV.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ n vsx;

            {
                this.vsx = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return n.a(this.vsx, view, motionEvent);
            }
        });
    }

    public final void ccc() {
        this.vrX = bh.Wq();
        if (this.vst == null) {
            x.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.vst = new 8(this);
            com.tencent.mm.sdk.b.a.xef.b(this.vst);
        }
        if (this.vrQ == null) {
            this.vrQ = (VoiceInputLayout) findViewById(R.h.cWw);
            this.vrQ.vlX = this.vsv;
            this.vrQ.vmc = this.vmc;
            this.vrQ.kW(this.vrY);
        }
        this.vrW.setVisibility(0);
        if (this.vsu == null) {
            this.vsu = new b();
        }
        SharedPreferences cft = ac.cft();
        if (cft != null) {
            String string = cft.getString("voiceinput_downdistance_content", "");
            if (!string.equalsIgnoreCase("")) {
                x.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[]{Integer.valueOf(string.length())});
                this.vss.b(this.vmn);
                this.vss.a(this.vmn, string, false);
                this.vss.a(this.vmn);
                this.vss.b(this.vmn);
                cce();
                this.vrV.fullScroll(130);
                cft.edit().remove("voiceinput_downdistance_content").apply();
            }
        }
        this.nCb = (TelephonyManager) ac.getContext().getSystemService("phone");
        if (this.nCb != null) {
            if (this.nCc == null) {
                this.nCc = new b(this, (byte) 0);
            }
            this.nCb.listen(this.nCc, 32);
        }
    }

    public final void pause() {
        x.i("MicroMsg.VoiceInputPanel", "pause");
        if (this.vrQ != null) {
            this.vrQ.caz();
        }
        this.vrZ = 0.0f;
        this.vsa = 0.0f;
        this.vsb = false;
        this.vsc = false;
        this.vmh = false;
        this.vsd = false;
        this.vsl = false;
        this.vsw = true;
    }

    public final void reset() {
        x.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
        pause();
        this.vsm = false;
        this.vsr.clear();
        if (this.vmn != null) {
            if (this.vss != null) {
                this.vss.b(this.vmn);
                this.vss.a(this.vmn, "", false);
                this.vss.a(this.vmn);
                this.vss.b(this.vmn);
            }
            cce();
        }
    }

    public final void destroy() {
        x.i("MicroMsg.VoiceInputPanel", "destroy");
        reset();
        if (this.vst != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.vst);
            this.vst = null;
        }
        if (this.vrQ != null) {
            this.vrQ.vlX = null;
            this.vrQ = null;
        }
        if (this.vsu != null) {
            this.vsu = null;
        }
        if (!(this.nCb == null || this.nCc == null)) {
            this.nCb.listen(this.nCc, 0);
            this.nCc = null;
        }
        this.nCb = null;
        this.vrU = null;
    }

    private void ccd() {
        x.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (this.vrT != null) {
            this.vsl = true;
            x.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (this.vmn == null || this.vmn.getText() == null || this.vmn.getText().length() <= 0) {
                if (this.vsl) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (this.vsl) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (this.vrX != 0) {
                voiceInputBehavior.voiceInputTime = bh.bA(this.vrX);
                this.vrX = 0;
            }
            a(voiceInputBehavior);
            this.vrT.bTZ();
        }
    }

    public final void Cq(int i) {
        x.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[]{Integer.valueOf(this.vpp), Integer.valueOf(i)});
        if (this.vpp != i) {
            this.vpp = i;
            this.vsw = true;
        }
    }

    public final void cbi() {
        x.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[]{Integer.valueOf(this.vpp), Boolean.valueOf(this.vsw)});
        if (this.vsw) {
            this.vsw = false;
            View findViewById = findViewById(R.h.cWs);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = this.vpp;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            init();
            cce();
            requestLayout();
        }
    }

    public final void cce() {
        x.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.vmn == null || this.vmn.getText() == null || this.vmn.getText().length() != 0) {
            if (this.vmn != null) {
                this.vmn.setCursorVisible(true);
            }
            this.okw.setVisibility(0);
            if (!this.vrY) {
                this.vrR.setVisibility(8);
                this.vrS.setVisibility(0);
            }
            this.vrW.setVisibility(8);
        } else {
            this.vmn.setSelection(0);
            this.vmn.setCursorVisible(false);
            this.okw.setVisibility(4);
            if (!this.vrY) {
                this.vrR.setVisibility(0);
            }
            this.vrS.setVisibility(8);
            this.vrW.setVisibility(0);
        }
        if (this.vrY) {
            if (this.vrU == null || this.vrU.getText() == null || this.vrU.getText().length() != 0) {
                this.okw.setVisibility(0);
            } else {
                this.okw.setVisibility(4);
            }
        }
        if (this.vmn != null) {
            this.vmn.clearFocus();
        }
        x.i("MicroMsg.VoiceInputPanel", "resumeMusic");
        ar.Hh().xT();
        if (!this.vsh) {
            this.vsh = true;
            this.vsk = System.currentTimeMillis();
            x.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[]{Long.valueOf(this.vsk), Long.valueOf(this.vsk - this.vsj)});
        }
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        x.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[]{Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime)});
        com.tencent.mm.bq.a com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        com.tencent.mm.plugin.report.service.g.pQN.c(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
    }

    private static void Cr(int i) {
        x.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.report.service.g.pQN.a(455, (long) i, 1, false);
    }
}
