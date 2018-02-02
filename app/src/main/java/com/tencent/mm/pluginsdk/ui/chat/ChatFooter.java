package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.ag;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel$a;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.b;
import com.tencent.mm.pluginsdk.ui.chat.h.a;
import com.tencent.mm.pluginsdk.ui.chat.i.2;
import com.tencent.mm.pluginsdk.ui.chat.i.3;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChatFooter extends LinearLayout implements OnGlobalLayoutListener, a {
    private static int count = 0;
    private static final int[] kDX = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] kDY = new int[]{R.g.byC, R.g.byD, R.g.byE, R.g.byF, R.g.byG, R.g.byH, R.g.byI};
    private Activity activity;
    private Context context;
    public String fzO;
    private ImageView kEg;
    private boolean kEo;
    private final af kEx;
    public View lWv;
    public final af mHandler;
    public View myF;
    public View myG;
    public View myH;
    public View myI;
    public MMEditText okv;
    public Button okw;
    public ChatFooterPanel okx;
    public q scp;
    private TextView scq;
    private ImageView scr;
    public View scs;
    public String toUser;
    public f vjC;
    private int vjD;
    public n vlG;
    public boolean vlJ;
    private String vpS;
    public AppPanel vpT;
    public TextView vpU;
    private Button vpV;
    public ImageButton vpW;
    public ChatFooterBottom vpX;
    public ImageButton vpY;
    public ImageButton vpZ;
    private int vqA;
    public boolean vqB;
    private int vqC;
    private final int vqD;
    private final int vqE;
    private final int vqF;
    private final int vqG;
    private final int vqH;
    private final int vqI;
    private final int vqJ;
    private final int vqK;
    private int vqL;
    private int vqM;
    private int vqN;
    private int vqO;
    private boolean vqP;
    private final int vqQ;
    private final int vqR;
    private volatile boolean vqS;
    private af vqT;
    private int vqU;
    private int vqV;
    private int vqW;
    private View vqX;
    public boolean vqY;
    private int vqZ;
    public View vqa;
    private i vqb;
    private i vqc;
    public m vqd;
    public b vqe;
    private d vqf;
    public final a vqg;
    public boolean vqh;
    public boolean vqi;
    private TextView vqj;
    private InputMethodManager vqk;
    public int vql;
    private boolean vqm;
    private boolean vqn;
    public boolean vqo;
    public b vqp;
    public c vqq;
    private m$a vqr;
    private boolean vqs;
    public u vqt;
    private boolean vqu;
    private Animation vqv;
    private Animation vqw;
    private ChatFooterPanel$a vqx;
    private b vqy;
    public e vqz;

    static /* synthetic */ void A(ChatFooter chatFooter) {
        if (com.tencent.mm.p.a.aW(chatFooter.context) || com.tencent.mm.p.a.aU(chatFooter.context)) {
            x.d("MicroMsg.ChatFooter", "voip is running, cann't record voice");
            return;
        }
        chatFooter.findViewById(R.h.bTV).setVisibility(8);
        chatFooter.vql = 1;
        chatFooter.okv.setVisibility(8);
        chatFooter.vpV.setVisibility(8);
        chatFooter.Ch(R.g.bBp);
        if (chatFooter.okx != null) {
            chatFooter.okx.setVisibility(8);
        }
        chatFooter.vpT.setVisibility(8);
        chatFooter.vpX.setVisibility(0);
        chatFooter.lh(false);
        if (chatFooter.vlG == null) {
            chatFooter.vlG = new n(chatFooter.getContext(), false, null);
            chatFooter.vpX.addView(chatFooter.vlG, new LayoutParams(-1, -1));
            chatFooter.vlG.vrT = new 13(chatFooter);
            if (chatFooter.vpT.getHeight() > 0) {
                chatFooter.vlG.Cq(chatFooter.vpT.getHeight());
            } else {
                chatFooter.vlG.Cq(j.aQ(chatFooter.context));
            }
        }
        n nVar = chatFooter.vlG;
        String str = chatFooter.toUser;
        if (bh.ov(str)) {
            x.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
        } else {
            nVar.flw = str;
        }
        chatFooter.vlG.ccc();
        chatFooter.vlG.cbi();
        chatFooter.vlG.setVisibility(0);
        chatFooter.vlJ = true;
    }

    static /* synthetic */ void K(ChatFooter chatFooter) {
        chatFooter.vqT.removeMessages(4097);
        chatFooter.vqT.sendEmptyMessageDelayed(4097, 1);
    }

    static /* synthetic */ void a(ChatFooter chatFooter, int i, String str) {
        if (bh.ov(chatFooter.vpS)) {
            x.e("MicroMsg.ChatFooter", "doSendImage : talker is null");
        } else if (str == null || str.equals("") || !e.bO(str)) {
            x.e("MicroMsg.ChatFooter", " doSendImage : filePath is null or empty");
        } else {
            ar.CG().a(new l(4, com.tencent.mm.z.q.FS(), chatFooter.vpS, str, i, null, 0, "", "", true, R.g.bAH), 0);
        }
    }

    static /* synthetic */ int cbY() {
        int i = count;
        count = i + 1;
        return i;
    }

    static /* synthetic */ void q(ChatFooter chatFooter) {
        if (chatFooter.vql == 1) {
            x.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")), bh.cgy(), chatFooter.activity});
            if (com.tencent.mm.pluginsdk.g.a.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")) {
                chatFooter.aa(2, true);
                return;
            }
            return;
        }
        chatFooter.aa(1, true);
    }

    public ChatFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lWv = null;
        this.okv = null;
        this.okw = null;
        this.vpU = null;
        this.vqf = null;
        this.vqg = new a((byte) 0);
        this.vqh = false;
        this.vqi = false;
        this.kEo = false;
        this.vqm = false;
        this.vqn = false;
        this.vqo = false;
        this.vlJ = false;
        this.vqr = new 1(this);
        this.mHandler = new 12(this);
        this.vqs = false;
        this.vqu = false;
        this.vqx = new 10(this);
        this.vqy = new 11(this);
        this.kEx = new af(this) {
            final /* synthetic */ ChatFooter vra;

            {
                this.vra = r1;
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (this.vra.scp != null) {
                    this.vra.scp.dismiss();
                    this.vra.vpV.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.vra.getContext(), R.g.bFg));
                    this.vra.vpV.setEnabled(true);
                }
            }
        };
        this.vqA = 0;
        this.vqB = false;
        this.vqC = 0;
        this.vqD = 0;
        this.vqE = 1;
        this.vqF = 2;
        this.vqG = 3;
        this.vqH = 20;
        this.vqI = 21;
        this.vqJ = 22;
        this.vqK = 23;
        this.vqL = 0;
        this.vqM = 0;
        this.vqN = -1;
        this.vqO = -1;
        this.vqP = false;
        this.vqQ = 4097;
        this.vqR = 4098;
        this.vqT = new 22(this);
        this.vqU = -1;
        this.vqV = -1;
        this.vqW = -1;
        this.vqX = null;
        this.vqY = true;
        this.vqZ = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.vqk = (InputMethodManager) context.getSystemService("input_method");
        this.lWv = inflate(context, R.i.dcY, this);
        this.okv = (MMEditText) this.lWv.findViewById(R.h.bTG);
        c.d(this.okv).GN(com.tencent.mm.k.b.zz()).a(null);
        this.okv.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
        this.okv.setOnFocusChangeListener(new 23(this));
        com.tencent.mm.sdk.b.b mzVar = new mz();
        mzVar.fEV.fEX = this.okv;
        mzVar.fEV.fEW = new 24(this);
        com.tencent.mm.sdk.b.a.xef.m(mzVar);
        this.vqa = this.lWv.findViewById(R.h.cQB);
        this.vpX = (ChatFooterBottom) findViewById(R.h.bTB);
        this.vpY = (ImageButton) this.lWv.findViewById(R.h.bTt);
        this.okw = (Button) this.lWv.findViewById(R.h.bUW);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.okw.setTextSize(0, ((float) com.tencent.mm.bv.a.ab(context, R.f.bvs)) * com.tencent.mm.bv.a.ew(context));
        this.vpV = (Button) this.lWv.findViewById(R.h.cWT);
        this.vpW = (ImageButton) findViewById(R.h.bUE);
        gv(false);
        cbV();
        this.vqc = new i(getContext(), getRootView(), this, new 25(this, context));
        this.vqc.vrw = this;
        Context context2 = getContext();
        getRootView();
        this.vqd = new m(context2);
        this.vqd.vqr = this.vqr;
        x.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[]{Integer.valueOf(this.okv.getImeOptions())});
        this.okv.setOnEditorActionListener(new 26(this));
        this.okv.setOnTouchListener(new 27(this));
        this.okv.setOnLongClickListener(new 2(this));
        this.okw.setOnClickListener(new 3(this));
        this.vpV.setOnTouchListener(new 8(this));
        this.vpV.setOnKeyListener(new 9(this));
        this.vpW.setOnClickListener(new 7(this));
        cbp();
        this.vpY.setVisibility(0);
        this.vpY.setContentDescription(getContext().getString(R.l.dPV));
        this.vpY.setOnClickListener(new 5(this));
        Cn(-1);
        findViewById(R.h.bTV).setOnTouchListener(new 4(this));
        x.d("MicroMsg.ChatFooter", "init time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(Context context, Activity activity) {
        this.activity = activity;
        cbV();
        if (this.okx != null) {
            this.okx.onResume();
        }
        if (!this.vqs && this.vqn) {
            x.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
            this.vqn = false;
            this.okv.setImeOptions(0);
            this.okv.setInputType(this.okv.getInputType() | 64);
        } else if (this.vqs && !this.vqn) {
            cbL();
        }
        if (this.vpT != null) {
            this.vpT.context = context;
        }
        this.context = context;
        this.vqc.vrv = false;
        if (!this.vlJ) {
            this.lWv.findViewById(R.h.bUY).setVisibility(0);
            this.okv.setVisibility(0);
        }
        cbH();
        post(new 21(this));
    }

    public final void onPause() {
        this.vqu = true;
        if (this.okx != null) {
            this.okx.onPause();
        }
        if (this.vlJ && this.vlG != null) {
            this.vlG.pause();
        }
        this.vqe.onPause();
        this.vqY = false;
    }

    public final void destroy() {
        if (this.okx != null) {
            x.i("MicroMsg.ChatFooter", "jacks chat footer desctory smiley panel");
            this.okx.ti();
            this.okx.destroy();
            this.okx = null;
        }
        if (this.vlG != null) {
            this.vlG.destroy();
            this.vlG = null;
            this.vlJ = false;
        }
        if (this.vqe != null) {
            this.vqe.release();
        }
        if (this.vqd != null) {
            this.vqd.vqr = null;
            this.vqd.vrG = null;
            this.vqd.hide();
        }
        x.d("MicroMsg.ChatFooter", "jacks destory");
    }

    public final void cbm() {
        if (this.vpT != null) {
            this.vpT.cbc();
        }
    }

    private void gv(boolean z) {
        if (this.vqv == null) {
            this.vqv = AnimationUtils.loadAnimation(getContext(), R.a.bqk);
            this.vqv.setDuration(150);
        }
        if (this.vqw == null) {
            this.vqw = AnimationUtils.loadAnimation(getContext(), R.a.bql);
            this.vqw.setDuration(150);
        }
        if (this.okw != null && this.vpY != null) {
            if (this.vqs) {
                if (this.vpY.getVisibility() != 0) {
                    this.vpY.setVisibility(0);
                }
            } else if (this.okw.getVisibility() != 0 || !z) {
                if (this.vpY.getVisibility() != 0 || z) {
                    if (z) {
                        this.okw.startAnimation(this.vqv);
                        this.okw.setVisibility(0);
                        this.vpY.startAnimation(this.vqw);
                        this.vpY.setVisibility(8);
                    } else {
                        this.vpY.startAnimation(this.vqv);
                        if (!this.vqi) {
                            this.vpY.setVisibility(0);
                        }
                        this.okw.startAnimation(this.vqw);
                        this.okw.setVisibility(8);
                    }
                    x.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[]{Boolean.valueOf(z)});
                    this.okw.getParent().requestLayout();
                }
            }
        }
    }

    public final void cbn() {
        this.vqe.aYK();
        if (this.vpT.getVisibility() != 0 || this.vpX.fJl) {
            p(2, 22, true);
            if (this.vlG != null && this.vlG.getVisibility() == 0 && this.vlJ) {
                x.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
                this.vlG.setVisibility(8);
                this.vlJ = false;
                this.vlG.reset();
            }
            ao bYV = ao.bYV();
            Context context = ac.getContext();
            if (g.Dh().Cy() && context != null) {
                try {
                    String value = com.tencent.mm.k.g.zY().getValue("ShowAPPSuggestion");
                    if (bh.ov(value) || Integer.valueOf(value).intValue() != 1) {
                        x.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[]{value});
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[]{e.getMessage()});
                }
                if (bYV.vfv) {
                    x.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
                } else {
                    x.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
                    bYV.vfv = true;
                    if (System.currentTimeMillis() - bYV.vfy < 43200000) {
                        x.d("MicroMsg.SuggestionAppListLogic", "not now");
                        bYV.vfv = false;
                    } else {
                        g.Dk();
                        bYV.vfy = g.Dj().CU().Dm(352275);
                        if (System.currentTimeMillis() - bYV.vfy < 43200000) {
                            x.w("MicroMsg.SuggestionAppListLogic", "not now sp");
                            bYV.vfv = false;
                        } else {
                            if (bYV.lang == null) {
                                bYV.lang = w.d(context.getSharedPreferences(ac.cfs(), 0));
                            }
                            com.tencent.mm.pluginsdk.model.app.w agVar = new ag(bYV.lang, new LinkedList());
                            com.tencent.mm.plugin.y.a.aRi();
                            d.a(4, agVar);
                        }
                    }
                }
            }
            ao bYV2 = ao.bYV();
            Context context2 = ac.getContext();
            if (g.Dh().Cy() && context2 != null) {
                if (bYV2.vfw) {
                    x.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
                    return;
                }
                bYV2.vfw = true;
                if (System.currentTimeMillis() - bYV2.vfB < 43200000) {
                    x.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
                    bYV2.vfw = false;
                    return;
                }
                g.Dk();
                bYV2.vfB = g.Dj().CU().Dm(352276);
                if (System.currentTimeMillis() - bYV2.vfB < 43200000) {
                    x.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
                    bYV2.vfw = false;
                    return;
                }
                if (bYV2.lang == null) {
                    bYV2.lang = w.d(context2.getSharedPreferences(ac.cfs(), 0));
                }
                ao.cS(bYV2.lang, bYV2.vfA);
            }
        } else if (this.vql == 1) {
            showVKB();
        } else {
            p(0, -1, false);
        }
    }

    public final void lh(boolean z) {
        if (this.okv != null) {
            if (z) {
                this.okv.requestFocus();
            } else {
                this.okv.clearFocus();
            }
        }
    }

    public final void cbo() {
        boolean z = true;
        if (this.context == null) {
            String str = "MicroMsg.ChatFooter";
            String str2 = "[initSmiley] activity = null? %s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.activity == null);
            x.e(str, str2, objArr);
            if (this.activity != null) {
                this.context = this.activity.getBaseContext();
            } else {
                this.context = getContext();
            }
        }
        if (e.vro != null && this.context != null) {
            if (this.okx != null) {
                this.okx.destroy();
            }
            this.okx = e.vro.cv(this.context);
            if (this.okx != null) {
                this.okx.ej(ChatFooterPanel.vjF);
                if (this.okx != null) {
                    this.okx.setVisibility(8);
                }
                if (this.okx != null) {
                    this.okx.BQ(this.vjD);
                }
                if (this.vpX != null) {
                    this.vpX.addView(this.okx, -1, -2);
                }
                if (this.okx != null) {
                    this.okx.vjB = this.vqx;
                }
                if (this.okx != null) {
                    ChatFooterPanel chatFooterPanel = this.okx;
                    if (this.okv.getText().length() <= 0) {
                        z = false;
                    }
                    chatFooterPanel.aE(z);
                }
                if (this.okx != null) {
                    this.okx.ce(this.vpS);
                    this.okx.ei(cbR());
                    if (!bh.ov(this.okv.getText().toString())) {
                        this.okx.tl();
                    }
                }
                if (this.vqo) {
                    tj();
                }
                b(this.vjC);
            }
        } else if (this.context == null) {
            x.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[]{bh.cgy()});
            this.okx = new d(ac.getContext());
        } else {
            this.okx = new d(this.context);
        }
    }

    public final void tj() {
        this.vqo = true;
        if (this.okx != null) {
            this.okx.tj();
        }
    }

    public final void b(f fVar) {
        this.vjC = fVar;
        if (this.okx != null) {
            this.okx.a(fVar);
        }
    }

    public final void a(j jVar) {
        this.vqd.vrG = jVar;
    }

    private void Ch(int i) {
        if (this.vpW != null) {
            int i2;
            if (i == R.g.bBp) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.vpW != null) {
                if (i2 != 0) {
                    this.vpW.setContentDescription(getContext().getString(R.l.dPX));
                } else {
                    this.vpW.setContentDescription(getContext().getString(R.l.dPW));
                }
            }
            this.vpW.setImageResource(i);
            this.vpW.setPadding(0, 0, 0, 0);
        }
    }

    private void cbp() {
        this.vpT = (AppPanel) findViewById(R.h.bSO);
        this.vpT.voV = this.vqy;
        this.vpT.Cg(cbR());
        if (s.hn(this.vpS) || s.hg(this.vpS)) {
            this.vpT.init(0);
        } else if (s.gF(this.vpS)) {
            this.vpT.init(4);
        } else if (s.eV(this.vpS)) {
            this.vpT.init(2);
        } else {
            this.vpT.init(1);
        }
    }

    public final void cbq() {
        this.vql = 1;
        this.vqa.setVisibility(0);
        this.vpV.setVisibility(8);
        Ch(R.g.bBp);
        if (this.vlG != null) {
            this.vlG.setVisibility(8);
            this.vlJ = false;
            this.vlG.reset();
        }
        p(2, 21, true);
    }

    public final void caw() {
        if (this.vlJ) {
            View findViewById = findViewById(R.h.bTV);
            this.vlJ = false;
            if (this.vlG != null) {
                this.vlG.destroy();
                this.vlG.setVisibility(8);
            }
            findViewById.setVisibility(0);
            this.okv.setVisibility(0);
            this.okv.setText("");
            lh(true);
            cbH();
            p(0, -1, false);
        }
    }

    public final void Sw(String str) {
        this.vqg.vrf = str;
    }

    public final void Sx(String str) {
        this.vqg.vre = str;
    }

    public final void ad(String str, String str2, String str3) {
        LinkedList linkedList;
        if (this.vqg.vrh.containsKey(str)) {
            linkedList = (LinkedList) this.vqg.vrh.get(str);
        } else {
            linkedList = new LinkedList();
            this.vqg.vrh.put(str, linkedList);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(str3, str2);
        linkedList.add(hashMap);
    }

    public final void Ci(int i) {
        this.vqg.vrg = i;
    }

    public final HashMap<String, String> ff(String str, String str2) {
        x.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] :%s :%s", new Object[]{str, str2});
        long currentTimeMillis = System.currentTimeMillis();
        if (bh.ov(str2)) {
            if (this.vqg.vrh.containsKey(str)) {
                this.vqg.vrh.remove(str);
            }
            return null;
        } else if (!this.vqg.vrh.containsKey(str) || ((LinkedList) this.vqg.vrh.get(str)).size() <= 0) {
            return null;
        } else {
            List<String> linkedList = new LinkedList();
            int i = 0;
            while (i < str2.length()) {
                i = str2.indexOf("@", i);
                if (i == -1) {
                    break;
                }
                int indexOf = str2.indexOf(8197, i);
                if (indexOf == -1 || indexOf - i > 40) {
                    break;
                }
                linkedList.add(str2.substring(i + 1, indexOf));
                i = indexOf + 1;
            }
            x.i("MicroMsg.ChatFooter", "after split @ :%s", new Object[]{linkedList});
            if (linkedList.size() <= 0) {
                ((LinkedList) this.vqg.vrh.get(str)).clear();
                return null;
            }
            LinkedList linkedList2 = (LinkedList) this.vqg.vrh.get(str);
            if (linkedList2 == null || linkedList2.size() <= 0) {
                x.w("MicroMsg.ChatFooter", "list is null or size 0");
                return null;
            }
            x.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", new Object[]{Integer.valueOf(linkedList2.size())});
            List linkedList3 = new LinkedList();
            for (String str3 : linkedList) {
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    HashMap hashMap = (HashMap) it.next();
                    if (hashMap.containsKey(str3)) {
                        linkedList3.add(hashMap.get(str3));
                        break;
                    }
                }
            }
            HashMap<String, String> hashMap2 = new HashMap(1);
            x.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", new Object[]{Integer.valueOf(linkedList3.size())});
            hashMap2.put("atuserlist", "<![CDATA[" + bh.d(linkedList3, ",") + "]]>");
            linkedList2.clear();
            x.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return hashMap2;
        }
    }

    public final void Sy(String str) {
        p(str, -1, true);
    }

    public final void p(String str, int i, boolean z) {
        if (z && (str == null || str.length() == 0 || this.okv == null)) {
            this.okv.setText("");
            return;
        }
        this.vqh = true;
        this.okv.setText(com.tencent.mm.pluginsdk.ui.d.i.b(getContext(), str, this.okv.getTextSize()));
        this.vqh = false;
        if (i < 0 || i > this.okv.getText().length()) {
            this.okv.setSelection(this.okv.getText().length());
        } else {
            this.okv.setSelection(i);
        }
    }

    public final void cbr() {
        this.vpV.setEnabled(false);
        this.vpV.setBackgroundDrawable(com.tencent.mm.bv.a.b(getContext(), R.g.bFf));
        if (this.scp != null) {
            this.myG.setVisibility(0);
            this.myF.setVisibility(8);
            this.scs.setVisibility(8);
            this.scp.update();
        }
        this.kEx.sendEmptyMessageDelayed(0, 500);
    }

    public final String cbs() {
        return this.okv == null ? "" : this.okv.getText().toString();
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        this.vqz = new e(this, textWatcher);
        this.okv.addTextChangedListener(this.vqz);
    }

    public final void Cj(int i) {
        this.vqA = 0;
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(getContext(), 180);
        int b = BackwardSupportUtil.b.b(getContext(), 50.0f);
        if (i + b < fromDPToPix) {
            this.vqA = -1;
        } else {
            this.vqA = ((i - fromDPToPix) / 2) + b;
        }
        if (this.scp == null) {
            this.scp = new q(View.inflate(getContext(), R.i.dtG, null), -1, -2);
            this.kEg = (ImageView) this.scp.getContentView().findViewById(R.h.cWI);
            this.myH = this.scp.getContentView().findViewById(R.h.cWJ);
            this.myI = this.scp.getContentView().findViewById(R.h.cWL);
            this.scq = (TextView) this.scp.getContentView().findViewById(R.h.cWN);
            this.scr = (ImageView) this.scp.getContentView().findViewById(R.h.cWM);
            this.scs = this.scp.getContentView().findViewById(R.h.cWO);
            this.myF = this.scp.getContentView().findViewById(R.h.cWP);
            this.myG = this.scp.getContentView().findViewById(R.h.cWQ);
            this.vqj = (TextView) this.scp.getContentView().findViewById(R.h.cWS);
        }
        if (this.vqA != -1) {
            this.myG.setVisibility(8);
            this.myF.setVisibility(8);
            this.scs.setVisibility(0);
            this.scp.showAtLocation(this, 49, 0, this.vqA);
        }
    }

    public final void Sz(String str) {
        if (str != null && this.vqj != null) {
            this.vqj.setText(str);
        }
    }

    public final void cbt() {
        this.scs.setVisibility(8);
        this.myF.setVisibility(0);
    }

    public final void aJO() {
        post(new 15(this));
    }

    public final void Ck(int i) {
        int i2 = 0;
        while (i2 < kDY.length) {
            if (i >= kDX[i2] && i < kDX[i2 + 1]) {
                this.kEg.setBackgroundDrawable(com.tencent.mm.bv.a.b(getContext(), kDY[i2]));
                break;
            }
            i2++;
        }
        if (i == -1 && this.scp != null) {
            this.scp.dismiss();
            this.scs.setVisibility(0);
            this.myF.setVisibility(8);
            this.myG.setVisibility(8);
        }
    }

    private void Cl(int i) {
        this.vql = i;
        switch (i) {
            case 1:
                this.vqa.setVisibility(0);
                this.vpV.setVisibility(8);
                Ch(R.g.bBp);
                return;
            case 2:
                this.vqa.setVisibility(8);
                this.vpV.setVisibility(0);
                Ch(R.g.bBo);
                if (com.tencent.mm.z.q.GA().booleanValue() && this.vqp != null) {
                    this.vqp.b(Boolean.valueOf(true), Boolean.valueOf(true));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void aa(int i, boolean z) {
        boolean z2 = true;
        Cl(i);
        switch (i) {
            case 1:
                lh(true);
                cbS();
                if (z) {
                    showVKB();
                    if (this.okv.length() <= 0) {
                        z2 = false;
                    }
                    gv(z2);
                    return;
                }
                if (this.okv.length() <= 0) {
                    z2 = false;
                }
                gv(z2);
                return;
            case 2:
                p(0, -1, false);
                gv(false);
                return;
            default:
                setVisibility(0);
                return;
        }
    }

    public final void li(boolean z) {
        if (this.okx != null) {
            this.okx.g(z, false);
        }
    }

    public final void cbu() {
        this.vqa.setVisibility(0);
        this.vpW.setVisibility(8);
        this.vpV.setVisibility(8);
    }

    public final void cbv() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vps.value = false;
        appPanel.cbe();
    }

    public final void cbw() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpK.value = false;
        appPanel.cbe();
    }

    public final void cbx() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpt.value = false;
        appPanel.cbe();
    }

    public final void cby() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpv.value = false;
        appPanel.cbe();
    }

    public final void cbz() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpw.value = false;
        appPanel.cbe();
    }

    public final void cbA() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpJ.value = false;
        appPanel.cbe();
    }

    public final void cbB() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpx.value = false;
        appPanel.cbe();
        x.d("MicroMsg.AppPanel", "enable false" + " isVoipPluginEnable " + appPanel.voY.vpy.value);
        this.vpT.lc(true);
    }

    public final void lj(boolean z) {
        AppPanel appPanel = this.vpT;
        boolean z2 = !z;
        appPanel.voY.vpM.value = z2;
        appPanel.cbe();
        x.d("MicroMsg.AppPanel", "enable " + appPanel.voY.vpM.value + " isMultiTalkEnable " + z2);
    }

    public final void lk(boolean z) {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpF.value = !z;
        appPanel.cbe();
    }

    public final void cbC() {
        AppPanel appPanel = this.vpT;
        appPanel.vpg = true;
        appPanel.voY.lf(false);
        appPanel.cbe();
    }

    public final void cbD() {
        AppPanel appPanel = this.vpT;
        appPanel.vph = true;
        appPanel.voY.le(false);
        appPanel.cbe();
    }

    public final void cbE() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpC.value = false;
        appPanel.cbe();
        x.d("MicroMsg.AppPanel", new StringBuilder("disableTalkroom enable false").toString());
    }

    public final void cbF() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpH.value = false;
        appPanel.cbe();
    }

    public final void cbG() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpB.value = false;
        appPanel.cbe();
    }

    public final void cbH() {
        this.vpZ = (ImageButton) this.lWv.findViewById(R.h.bVa);
        this.vpZ.setVisibility(0);
        this.vpZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ChatFooter vra;

            {
                this.vra = r1;
            }

            public final void onClick(View view) {
                this.vra.vqe.aYJ();
                if (this.vra.vpX.fJl || this.vra.okx == null || this.vra.okx.getVisibility() != 0) {
                    if (this.vra.vqi) {
                        this.vra.tj();
                    }
                    this.vra.cbq();
                    return;
                }
                this.vra.showVKB();
            }
        });
        if (this.vqd != null) {
            this.vqd.vrF = this.vpZ;
        }
    }

    public final void cbI() {
        if (this.vpZ != null) {
            this.vpZ.setVisibility(8);
        }
    }

    public final void cbJ() {
        AppPanel appPanel = this.vpT;
        appPanel.vpi = true;
        appPanel.voY.lg(false);
        appPanel.cbe();
    }

    public final void cbK() {
        AppPanel appPanel = this.vpT;
        appPanel.voY.vpP.value = false;
        appPanel.cbe();
    }

    public final void cbL() {
        x.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
        this.vqn = true;
        this.okv.setImeOptions(4);
        this.okv.setInputType(this.okv.getInputType() & -65);
    }

    public final void cbM() {
        if (this.okx != null) {
            this.okx.refresh();
        }
    }

    public final boolean cbN() {
        return this.vpX.getVisibility() == 0;
    }

    @TargetApi(11)
    public final void a(OnDragListener onDragListener) {
        this.okv.setOnDragListener(onDragListener);
    }

    public final void a(AppPanel.a aVar) {
        this.vpT.voU = aVar;
    }

    public static void cbO() {
    }

    public final void a(d dVar) {
        this.vqf = dVar;
        if (dVar != null) {
            View findViewById = findViewById(R.h.bUF);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new 16(this));
        }
    }

    public final void Cm(int i) {
        if (i != this.vqC) {
            this.vqC = i;
            ImageView imageView = (ImageView) findViewById(R.h.cPQ);
            ImageView imageView2 = (ImageView) findViewById(R.h.cBJ);
            if (this.vqC == 1) {
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
                return;
            }
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
        }
    }

    @TargetApi(11)
    public final void ll(boolean z) {
        if (f.fM(11)) {
            com.tencent.mm.compatible.a.a.a(11, new 17(this, z));
        } else if (z) {
            this.okv.setTextColor(getResources().getColor(R.e.btg));
        } else {
            this.okv.setTextColor(getResources().getColor(R.e.bsK));
            lh(false);
        }
    }

    public final void cbP() {
        p(2, 20, false);
    }

    public final void showVKB() {
        post(new 19(this));
    }

    public final void p(int i, int i2, boolean z) {
        boolean z2 = true;
        if (!z) {
            this.vpY.setContentDescription(getContext().getString(R.l.dPV));
            switch (i) {
                case 0:
                    bh.hideVKB(this);
                    lh(false);
                    if (!this.vlJ) {
                        cbS();
                        break;
                    }
                    break;
                case 1:
                    bh.hideVKB(this);
                    break;
                case 2:
                    if (i2 != 20) {
                        if (i2 != 22) {
                            if (i2 != 21) {
                                if (i2 == 23) {
                                    caw();
                                    cbS();
                                    break;
                                }
                            } else if (this.okx != null) {
                                this.okx.setVisibility(8);
                                break;
                            }
                        }
                        this.vpT.setVisibility(8);
                        break;
                    } else if (!this.vlJ) {
                        cbS();
                        break;
                    } else {
                        bh.hideVKB(this);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        if (com.tencent.mm.z.q.GA().booleanValue() && this.vqp != null) {
            this.vqp.a(Boolean.valueOf(true), Boolean.valueOf(false));
            this.vqp.b(Boolean.valueOf(true), Boolean.valueOf(false));
        }
        this.vpY.setContentDescription(getContext().getString(R.l.dPU));
        switch (i) {
            case 1:
                this.vpX.fJl = true;
                lh(true);
                ll(true);
                this.vqk.showSoftInput(this.okv, 0);
                break;
            case 2:
                if (i2 == 22) {
                    if (this.vpT == null) {
                        cbp();
                    }
                    this.vpT.cbi();
                    if (this.okx != null) {
                        this.okx.setVisibility(8);
                    }
                    this.vpT.setVisibility(0);
                    i iVar = this.vqc;
                    ar.Dm().F(new 3(iVar, new 2(iVar, iVar.context.getMainLooper())));
                    lh(false);
                    if (this.vql == 2) {
                        Cl(1);
                    }
                } else if (i2 == 21) {
                    if (this.vpT != null) {
                        this.vpT.setVisibility(8);
                    }
                    if (this.okx == null) {
                        cbo();
                    }
                    if (this.okx != null) {
                        this.okx.setVisibility(0);
                    }
                    lm(true);
                    lh(true);
                }
                this.vpX.setVisibility(0);
                if (!(cbQ() && j.aS(getContext()))) {
                    ViewGroup.LayoutParams layoutParams = this.vpX.getLayoutParams();
                    if (layoutParams != null && layoutParams.height == 0) {
                        layoutParams.height = j.aQ(getContext());
                        this.vpX.setLayoutParams(layoutParams);
                    }
                }
                bh.hideVKB(this);
                break;
            case 3:
                this.vpX.fJl = true;
                lh(true);
                ll(true);
                break;
            default:
                z = false;
                break;
        }
        if (!((!z || i2 == 21 || this.vpZ == null) && (this.vpZ == null || z || (i2 != 21 && i2 != 20)))) {
            lm(false);
        }
        if (i == 0 && !z) {
            lm(false);
        } else if (z && i2 != 22) {
            if (this.okv.length() <= 0) {
                z2 = false;
            }
            gv(z2);
        }
    }

    public final boolean cbQ() {
        return this.vqN > 0 && this.vqN < this.vqO;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        super.onLayout(z, i, i2, i3, i4);
        if (getTop() != 0) {
            if (getTop() > this.vqM) {
                this.vqM = getTop();
            }
            if (this.vqM - getTop() > 50) {
                if (this.vqe != null) {
                    this.vqe.gx(true);
                }
            } else if (this.vqe != null) {
                this.vqe.gx(false);
            }
        }
        if (z && this.vqd != null) {
            m mVar = this.vqd;
            if (mVar.vrE.isShowing()) {
                mVar.vrE.dismiss();
                mVar.ccb();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", new Object[]{Integer.valueOf(MeasureSpec.getSize(i2)), Integer.valueOf(getMeasuredHeight())});
        super.onMeasure(i, i2);
        x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", new Object[]{Integer.valueOf(getMeasuredHeight())});
    }

    public final int cbR() {
        return j.c(getContext(), true);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    private void lm(boolean z) {
        if (this.vpZ != null) {
            if (!this.vqP || !z) {
                if (this.vqP || z) {
                    this.vqP = z;
                    if (z) {
                        this.vpZ.setImageDrawable(getContext().getResources().getDrawable(R.g.bBo));
                    } else {
                        this.vpZ.setImageDrawable(getContext().getResources().getDrawable(R.g.bBn));
                    }
                }
            }
        }
    }

    public final void cbS() {
        this.vpX.setVisibility(8);
        this.vpT.setVisibility(8);
        if (this.okx != null) {
            this.okx.setVisibility(8);
        }
        lm(false);
    }

    public final void Cn(int i) {
        j.zk();
        int q = j.q(this.context, i);
        this.vqL = q;
        if (q > 0 && this.vpX != null) {
            x.d("MicroMsg.ChatFooter", "set bottom panel height: %d", new Object[]{Integer.valueOf(q)});
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 0);
            layoutParams.height = q;
            this.vpX.setLayoutParams(layoutParams);
        }
        if (this.vpT != null) {
            this.vpT.Cg(q);
            AppPanel appPanel = this.vpT;
            appPanel.cbi();
            appPanel.th();
        }
        if (this.vlG != null) {
            this.vlG.Cq(q);
            this.vlG.cbi();
        }
        if (this.okx != null) {
            if (!cbQ()) {
                cbM();
            }
            this.okx.ei(q);
            this.okx.tm();
        }
    }

    public final void cbT() {
        this.kEo = false;
        this.vpV.setBackgroundDrawable(com.tencent.mm.bv.a.b(getContext(), R.g.bFg));
        this.vpV.setText(R.l.dQt);
        if (this.vqe == null) {
            return;
        }
        if (this.myI == null || this.myI.getVisibility() != 0) {
            this.vqe.aYF();
        } else {
            this.vqe.aYH();
        }
    }

    public final boolean cbU() {
        return this.vqM - getTop() > 50;
    }

    public final void SA(String str) {
        this.vpS = str;
        if (this.okx != null) {
            this.okx.ce(this.vpS);
        }
        if (this.vpT == null) {
            return;
        }
        if (s.hn(this.vpS) || s.hg(this.vpS)) {
            this.vpT.vpb = 0;
        } else if (s.gF(this.vpS)) {
            this.vpT.vpb = 4;
        } else if (s.eV(this.vpS)) {
            this.vpT.vpb = 2;
        } else {
            this.vpT.vpb = 1;
        }
    }

    public final void cbV() {
        ar.Hg();
        this.vqs = ((Boolean) com.tencent.mm.z.c.CU().get(66832, Boolean.valueOf(false))).booleanValue();
    }

    public final void Co(int i) {
        this.vqX = null;
        this.vqW = i;
    }

    public void onGlobalLayout() {
        if (this.activity != null && this.activity.getWindow() != null && this.activity.getWindow().getDecorView() != null) {
            if (this.vqW == -1) {
                x.w("MicroMsg.ChatFooter", "chattingui layout id == -1!");
                return;
            }
            if (this.vqX == null) {
                this.vqX = this.activity.getWindow().getDecorView().findViewById(this.vqW);
            }
            if (this.vqX == null) {
                x.e("MicroMsg.ChatFooter", "can't get chattinguilayout by chattinguilayoutid: %d", new Object[]{Integer.valueOf(this.vqW)});
                return;
            }
            int height = this.vqX.getHeight();
            int width = this.vqX.getWidth();
            x.d("MicroMsg.ChatFooter", "ashutest::keybord:ChatFooter measure height: %d, height: %d", new Object[]{Integer.valueOf(this.vqX.getMeasuredHeight()), Integer.valueOf(height)});
            if (this.vqO < height) {
                this.vqO = height;
            }
            this.vqN = height;
            if (this.vqU <= 0) {
                this.vqU = height;
            } else if (this.vqV <= 0) {
                this.vqV = width;
            } else if (this.vqU != height || this.vqV != width) {
                if (cbQ() && this.vqu) {
                    this.vqu = false;
                    x.d("MicroMsg.ChatFooter", "keybord:Chatfooter Show keybord & hide diy panel by onGlobalLayout");
                    postDelayed(new 18(this), 10);
                }
                x.d("MicroMsg.ChatFooter", "keybord:Chatfooter keybord old: %d, new: %d", new Object[]{Integer.valueOf(this.vqU), Integer.valueOf(height)});
                int abs = Math.abs(this.vqU - height);
                this.vqU = height;
                height = Math.abs(this.vqV - width);
                this.vqV = width;
                x.d("MicroMsg.ChatFooter", "alvinluo widthDiff: %d", new Object[]{Integer.valueOf(height)});
                if (this.vqY) {
                    if (abs == 0) {
                        if (this.vpT != null) {
                            this.vpT.vpo = true;
                            this.vpT.th();
                        }
                        if (this.okx != null) {
                            this.okx.ei(j.aQ(this.context));
                            cbM();
                            this.okx.tm();
                        }
                    } else if (j.aS(this.context)) {
                        x.d("MicroMsg.ChatFooter", "alvinluo keyboard current height: %d", new Object[]{Integer.valueOf(this.vqL)});
                        if (this.vqL != abs || abs == -1) {
                            height = j.aQ(this.context);
                            x.d("MicroMsg.ChatFooter", "alvinluo valid panel height: %d", new Object[]{Integer.valueOf(height)});
                            if (abs >= j.aP(this.context) && abs <= j.aO(this.context)) {
                                height = abs;
                            }
                            if (this.vqB) {
                                this.vqB = false;
                                if (height < this.vqL) {
                                    height = this.vqL;
                                }
                                this.vqL = height;
                                Cn(height);
                            } else {
                                this.vqL = height;
                                x.i("MicroMsg.ChatFooter", "jacks calc keyBord dialog height:%d", new Object[]{Integer.valueOf(this.vqL)});
                                j.p(getContext(), height);
                                Cn(height);
                            }
                        }
                    } else {
                        return;
                    }
                }
                x.d("MicroMsg.ChatFooter", "keybord:Chatfooter Keyboard Size: " + abs);
            }
        }
    }

    public final int cbW() {
        int aQ = j.aQ(getContext());
        int height = getHeight();
        return height < aQ ? height + aQ : height;
    }
}
