package com.tencent.mm.pluginsdk.ui.websearch;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.wcdb.FileUtils;
import java.util.HashSet;
import java.util.Set;

public final class a extends LinearLayout {
    private String flw = "";
    AudioManager gCe;
    private Context mContext;
    private TelephonyManager nCb;
    PhoneStateListener nCc = new 4(this);
    private Button okw;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a vmc = new com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a(this) {
        final /* synthetic */ a vzt;

        {
            this.vzt = r1;
        }

        public final void caB() {
            a.a(this.vzt, R.l.eTw);
        }
    };
    private boolean vmh = false;
    private MMEditText vmn;
    public int vpp = com.tencent.mm.bv.a.fromDPToPix(getContext(), 280);
    private VoiceInputLayout vrQ;
    private ImageButton vrR;
    private Button vrS;
    private VoiceInputScrollView vrV;
    private TextView vrW;
    private long vrX = 0;
    private float vrZ = 0.0f;
    private float vsa = 0.0f;
    private boolean vsb = false;
    private boolean vsc = false;
    private boolean vsd = false;
    private int vse = 300;
    private boolean vsg = false;
    private boolean vsh = false;
    private long vsi = 0;
    private long vsj = 0;
    private long vsk = 0;
    private boolean vsl = false;
    private boolean vsm = false;
    private final int vsn = 2;
    private boolean vso = false;
    private Toast vsq;
    private Set<String> vsr = new HashSet();
    private c<sj> vst;
    private b vsv = new b(this) {
        final /* synthetic */ a vzt;

        {
            this.vzt = r1;
        }

        public final void caC() {
            this.vzt.vsi = System.currentTimeMillis();
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[]{Long.valueOf(this.vzt.vsi)});
            x.d("VOICEDEBUG", "Start Record Time = %s", new Object[]{Long.valueOf(this.vzt.vsi)});
            this.vzt.vsg = false;
            this.vzt.vsh = true;
            this.vzt.vso = true;
            this.vzt.vsj = 0;
            this.vzt.vsk = 0;
            this.vzt.cce();
            this.vzt.vrW.setVisibility(8);
            this.vzt.vsh = false;
            a aVar = this.vzt;
            if (aVar.gCe != null) {
                aVar.gCe.setStreamMute(3, true);
            }
            if (this.vzt.mContext instanceof Activity) {
                ((Activity) this.vzt.mContext).getWindow().addFlags(FileUtils.S_IWUSR);
            }
            this.vzt.okw.setVisibility(4);
            this.vzt.vrR.setVisibility(4);
            this.vzt.vrS.setVisibility(8);
            this.vzt.vmn.setHint(this.vzt.getResources().getString(R.l.eTu));
            this.vzt.vzs.ky(true);
        }

        public final void caD() {
            this.vzt.vzs.ky(false);
            this.vzt.vmn.setHint(null);
        }

        public final void caE() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            this.vzt.cce();
            if (this.vzt.mContext instanceof Activity) {
                ((Activity) this.vzt.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            this.vzt.vzs.ky(false);
            this.vzt.vmn.setHint(null);
            a.b(this.vzt, 2);
        }

        public final void caF() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
            this.vzt.cce();
            if (this.vzt.mContext instanceof Activity) {
                ((Activity) this.vzt.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            this.vzt.vzs.ky(false);
            this.vzt.vmn.setHint(null);
        }

        public final void caG() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
            this.vzt.cce();
            if (this.vzt.mContext instanceof Activity) {
                ((Activity) this.vzt.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            this.vzt.vzs.ky(false);
            this.vzt.vmn.setHint(null);
            a.b(this.vzt, 2);
        }

        public final void b(String[] strArr, Set<String> set) {
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (this.vzt.vso) {
                    this.vzt.vso = false;
                }
                x.i("MicroMsg.VoiceInputPanel", "onDetected %s", new Object[]{strArr[0]});
                this.vzt.vmn.setText(strArr[0]);
                if (!(this.vzt.vsg || strArr[0].length() == 0)) {
                    this.vzt.vsg = true;
                    this.vzt.vsj = System.currentTimeMillis();
                    x.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.vzt.vsj - this.vzt.vsi)});
                }
                this.vzt.vsr.addAll(set);
            }
        }

        public final void af(int i, int i2, int i3) {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis())});
            this.vzt.cce();
            if (this.vzt.mContext instanceof Activity) {
                ((Activity) this.vzt.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            if (i == 12) {
                a.a(this.vzt, R.l.eTv);
            } else {
                a.a(this.vzt, R.l.dEP);
            }
            this.vzt.vzs.ky(false);
            this.vzt.vmn.setHint(null);
        }
    };
    public boolean vsw = true;
    public a vzs;

    static /* synthetic */ void a(a aVar) {
        x.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (aVar.vzs != null) {
            aVar.vsl = true;
            x.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (aVar.vmn == null || aVar.vmn.getText() == null || aVar.vmn.getText().length() <= 0) {
                if (aVar.vsl) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (aVar.vsl) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (aVar.vrX != 0) {
                voiceInputBehavior.voiceInputTime = bh.bA(aVar.vrX);
                aVar.vrX = 0;
            }
            aVar.vzs.bTZ();
        }
    }

    static /* synthetic */ void a(a aVar, int i) {
        if (aVar.vsq != null) {
            aVar.vsq.cancel();
        }
        aVar.vsq = Toast.makeText(aVar.mContext, aVar.mContext.getResources().getString(i), 0);
        aVar.vsq.setGravity(17, 0, 0);
        aVar.vsq.show();
    }

    static /* synthetic */ void b(a aVar, int i) {
        x.d("MicroMsg.VoiceInputPanel", "sendMsg");
        if (aVar.vmn != null && aVar.vmn.getText() != null) {
            String obj = aVar.vmn.getText().toString();
            if ((obj.trim().length() != 0 || obj.length() != 0) && aVar.vzs != null) {
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 1;
                if (aVar.vsm) {
                    voiceInputBehavior.send = 2;
                }
                if (i != 1 && i == 4) {
                    voiceInputBehavior.send = 4;
                }
                x.i("MicroMsg.VoiceInputPanel", "sendMsg onSendMsg");
                aVar.vzs.Px(obj);
            }
        }
    }

    public a(Context context) {
        super(context);
        this.mContext = context;
        x.d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), R.i.dtZ, this);
        this.vrR = (ImageButton) findViewById(R.h.cWr);
        this.vrS = (Button) findViewById(R.h.cWq);
        this.okw = (Button) findViewById(R.h.cWu);
        this.vrW = (TextView) findViewById(R.h.cPs);
        this.vrR.setVisibility(0);
        this.okw.setVisibility(4);
        this.vrS.setVisibility(8);
        this.vmn = (MMEditText) findViewById(R.h.cWv);
        this.vmn.setHintTextColor(getResources().getColor(R.e.bts));
        this.vmn.setClickable(false);
        this.vrV = (VoiceInputScrollView) findViewById(R.h.cWt);
        this.vrR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a vzt;

            {
                this.vzt = r1;
            }

            public final void onClick(View view) {
                a.a(this.vzt);
            }
        });
        this.vmn.clearFocus();
        this.vmn.setFocusable(false);
        this.vmn.setClickable(false);
        this.vmn.setLongClickable(false);
        this.gCe = (AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.flw = String.valueOf(System.nanoTime());
        x.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[]{this.flw});
        ccc();
    }

    public final void ccc() {
        this.vrX = bh.Wq();
        if (this.vst == null) {
            x.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.vst = new c<sj>(this) {
                final /* synthetic */ a vzt;

                {
                    this.vzt = r2;
                    this.xen = sj.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    sj sjVar = (sj) bVar;
                    if (!(sjVar instanceof sj)) {
                        x.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                        return false;
                    } else if (sjVar == null || sjVar.fKc == null) {
                        x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                        return false;
                    } else if (sjVar.fKc.fKe.equalsIgnoreCase(this.vzt.flw)) {
                        x.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", new Object[]{Integer.valueOf(sjVar.fKc.action), Integer.valueOf(sjVar.fKc.fKd)});
                        if (sjVar.fKc.action == 2) {
                            if (sjVar.fKc.fKd == 1) {
                                this.vzt.vsm = true;
                            } else {
                                this.vzt.vsm = false;
                            }
                            this.vzt.vmn.setText(sjVar.fKc.result);
                            this.vzt.cce();
                        } else if (sjVar.fKc.action == 3) {
                            if (this.vzt.vzs != null) {
                                this.vzt.vzs.bTZ();
                            }
                        } else if (sjVar.fKc.action == 1 || sjVar.fKc.action == 4) {
                            if (sjVar.fKc.fKd == 1) {
                                this.vzt.vsm = true;
                            } else {
                                this.vzt.vsm = false;
                            }
                            this.vzt.vmn.setText(sjVar.fKc.result);
                            this.vzt.cce();
                            a.b(this.vzt, sjVar.fKc.action);
                        } else {
                            this.vzt.reset();
                        }
                        return true;
                    } else {
                        x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
                        this.vzt.destroy();
                        return false;
                    }
                }
            };
            com.tencent.mm.sdk.b.a.xef.b(this.vst);
        }
        if (this.vrQ == null) {
            this.vrQ = (VoiceInputLayout) findViewById(R.h.cWw);
            this.vrQ.vlX = this.vsv;
            this.vrQ.vmc = this.vmc;
        }
        this.vrW.setVisibility(0);
        this.nCb = (TelephonyManager) ac.getContext().getSystemService("phone");
        this.nCb.listen(this.nCc, 32);
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
            this.vmn.setText("");
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
        if (!(this.nCb == null || this.nCc == null)) {
            this.nCb.listen(this.nCc, 0);
            this.nCc = null;
        }
        this.nCb = null;
    }

    public final void cce() {
        x.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.vmn == null || this.vmn.getText() == null || this.vmn.getText().length() != 0) {
            this.vrR.setVisibility(4);
            this.vrW.setVisibility(8);
        } else {
            this.okw.setVisibility(4);
            this.vrR.setVisibility(0);
            this.vrS.setVisibility(8);
            this.vrW.setVisibility(0);
        }
        if (this.gCe != null) {
            this.gCe.setStreamMute(3, false);
        }
        if (!this.vsh) {
            this.vsh = true;
            this.vsk = System.currentTimeMillis();
            x.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[]{Long.valueOf(this.vsk), Long.valueOf(this.vsk - this.vsj)});
        }
    }
}
