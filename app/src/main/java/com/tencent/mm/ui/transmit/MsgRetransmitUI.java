package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.aq.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.transmit.c.1;
import com.tencent.mm.ui.transmit.c.2;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.bx;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MsgRetransmitUI extends MMBaseActivity implements e {
    public String fDP;
    public String fileName;
    public long fqm;
    private String fvC;
    private float fzt;
    private float hBL;
    private String hBM;
    private f hBj = null;
    private int hzT = 0;
    private String iKB;
    private ProgressDialog iln = null;
    long kGB;
    private int length;
    private af mHandler = new af();
    public int msgType;
    private long startTime = 0;
    boolean vnK;
    private int yLf = -1;
    private boolean yoF = false;
    private String zoA;
    private String zoB;
    private int zoC;
    private int zoD;
    private boolean zoE = true;
    boolean zoF = false;
    public List<String> zog;
    private String zoh = null;
    private boolean zoi = true;
    private boolean zoj = false;
    private i zok;
    private int zol = 0;
    private int zom = 0;
    private l zon = null;
    private boolean zoo = false;
    private List<String> zop = null;
    private int zoq = 0;
    private int zor = 0;
    private boolean zos = false;
    private boolean zot = false;
    private int zou;
    private boolean zov;
    private boolean zow = true;
    private boolean zox = true;
    private int zoy = 0;
    private int zoz;

    public static final class a extends AsyncTask<Object, Object, String> {
        public Context context;
        public String fGG;
        public String fileName;
        public String gjF;
        public int hTT;
        public int hVH;
        public Dialog ilS;
        private af mHandler = new af();
        public String userName;
        public boolean zoO;
        public String zoP;
        public boolean zoQ = true;
        public boolean zoR = false;
        public boolean zoS = true;
        public bmf zoT = null;
        public b zoU = null;
        public boolean zoj = false;
        public int zol;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            String ns = s.ns(q.FS());
            o.TU();
            String nu = s.nu(ns);
            if (this.zoS) {
                FileOp.x(s.nt(this.fileName), s.nt(ns));
                FileOp.x(s.nu(this.fileName), nu);
            } else {
                FileOp.x(this.fileName, s.nt(ns));
                FileOp.x(this.zoP, nu);
            }
            r nF = t.nF(this.fileName);
            int i = nF != null ? nF.status : 0;
            x.i("MicroMsg.MsgRetransmitUI", "CopyVideoTask ori[%s] status[%d] new[%s]", new Object[]{this.fileName, Integer.valueOf(i), ns});
            return ns;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (this.ilS != null) {
                this.ilS.dismiss();
                this.ilS = null;
            }
            o.TU();
            boolean bO = FileOp.bO(s.nt(str));
            o.TU();
            String nu = s.nu(str);
            boolean bO2 = FileOp.bO(nu);
            if (this.zoO) {
                if (bO) {
                    FileOp.deleteFile(str);
                }
                if (bO2) {
                    FileOp.deleteFile(nu);
                    return;
                }
                return;
            }
            x.d("MicroMsg.MsgRetransmitUI", "dkvideo videoIsExport :" + this.zol + ", videoMsgType :43 videoType : " + this.hTT);
            t.a(str, this.hVH, this.userName, null, this.zol, "", 43, this.zoT, this.fGG);
            Object obj2 = t.nA(str) != 0 ? 1 : null;
            o.TU();
            nu = s.nt(str);
            int i = 3;
            if (!bh.ov(this.fileName) && this.fileName.contains("favorite")) {
                i = 7;
            }
            int i2 = (bh.ov(this.fileName) || !this.fileName.contains("sns")) ? i : 6;
            n.TS().a("", nu, this.userName, this.gjF, "", i2, 2);
            g.pQN.h(10424, new Object[]{Integer.valueOf(43), Integer.valueOf(8), this.userName});
            if (this.zoU != null) {
                b bVar = this.zoU;
                nu = this.userName;
                Object obj3 = obj2 == null ? 1 : null;
                if (bVar.zoW != null && bVar.zoW.contains(nu)) {
                    bVar.zoW.remove(nu);
                    if (obj3 == null) {
                        bVar.fpW = false;
                    }
                    if (bVar.zoW.size() == 0) {
                        obj3 = 1;
                        if (obj3 != null) {
                            obj2 = this.zoU.fpW ? 1 : null;
                        } else {
                            return;
                        }
                    }
                }
                obj3 = null;
                if (obj3 != null) {
                    if (this.zoU.fpW) {
                    }
                    obj2 = this.zoU.fpW ? 1 : null;
                } else {
                    return;
                }
            }
            if (this.zoQ) {
                Intent intent = new Intent(this.context, ChattingUI.class);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", this.userName);
                this.context.startActivity(intent);
            }
            if (this.zoj && (this.context instanceof Activity)) {
                com.tencent.mm.ui.snackbar.a.h((Activity) this.context, this.context.getString(obj2 == null ? R.l.epb : R.l.eKc));
            }
            this.mHandler.postDelayed(new 1(this), 1800);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        ae.a(getWindow());
        x.i("MicroMsg.MsgRetransmitUI", "on activity create");
        this.startTime = bh.Wo();
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.fDP = getIntent().getStringExtra("Retr_Msg_content");
        this.fqm = getIntent().getLongExtra("Retr_Msg_Id", -1);
        this.fileName = getIntent().getStringExtra("Retr_File_Name");
        this.zop = getIntent().getStringArrayListExtra("Retr_File_Path_List");
        boolean z = this.zop != null && this.zop.size() > 0;
        this.zos = z;
        this.hzT = getIntent().getIntExtra("Retr_Compress_Type", 0);
        this.zom = getIntent().getIntExtra("Retr_Scene", 0);
        this.length = getIntent().getIntExtra("Retr_length", 0);
        this.zol = getIntent().getIntExtra("Retr_video_isexport", 0);
        this.zoh = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.zoi = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
        this.zow = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
        Intent intent = getIntent();
        String str = "Multi_Retr";
        if (this.zom == 0) {
            z = true;
        } else {
            z = false;
        }
        this.zox = intent.getBooleanExtra(str, z);
        if (this.zox) {
            this.zow = true;
        }
        this.zoj = getIntent().getBooleanExtra("Retr_show_success_tips", this.zow);
        this.zot = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
        this.yoF = getIntent().getBooleanExtra("is_group_chat", false);
        this.yLf = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.fvC = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
        this.zou = getIntent().getIntExtra("Retr_MsgImgScene", 0);
        this.hBL = getIntent().getFloatExtra("Retr_Longtitude", -1000.0f);
        this.fzt = getIntent().getFloatExtra("Retr_Latitude", -1000.0f);
        this.hBM = getIntent().getStringExtra("Retr_AttachedContent");
        this.zov = "gallery".equals(getIntent().getStringExtra("Retr_From"));
        this.iKB = getIntent().getStringExtra("reportSessionId");
        this.zoz = getIntent().getIntExtra("Retr_MsgFromScene", 0);
        this.zoA = getIntent().getStringExtra("Retr_MsgFromUserName");
        this.zoB = getIntent().getStringExtra("Retr_MsgTalker");
        this.zoC = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
        this.zoD = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
        ar.CG().a(110, this);
        if (!d.fM(19)) {
            setContentView(R.i.dbs);
        }
        Intent intent2 = new Intent(this, SelectConversationUI.class);
        intent2.putExtra("scene", 8);
        intent2.putExtra("select_is_ret", true);
        if (this.zox) {
            intent2.putExtra("mutil_select_is_ret", true);
        }
        switch (this.msgType) {
            case 2:
            case 6:
            case 7:
            case 14:
            case 15:
            case 16:
                intent2.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
                if (this.zoz == 3) {
                    intent2.putExtra("scene_from", 3);
                }
                intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.yLf);
                intent2.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
                intent2.putExtra("Select_Conv_Type", 3);
                break;
            case 13:
                intent2.putExtra("Select_Conv_Type", 11);
                break;
            default:
                intent2.putExtra("Select_Conv_Type", 3);
                break;
        }
        intent2.putExtra("Retr_Msg_Type", this.msgType);
        intent2.putExtra("Retr_Msg_Id", this.fqm);
        intent2.putExtra("Retr_Msg_content", this.fDP);
        intent2.putExtra("image_path", this.fileName);
        startActivityForResult(intent2, 0);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    protected void onDestroy() {
        if (!this.zoo) {
            ar.CG().b(110, this);
        }
        super.onDestroy();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cyi() {
        String str;
        switch (this.zom) {
            case 0:
                boolean z;
                switch (this.msgType) {
                    case 0:
                    case 1:
                    case 5:
                    case 8:
                    case 11:
                        if (!cyj()) {
                            finish();
                            z = false;
                            break;
                        }
                    case 4:
                        if (this.fDP == null || this.fDP.equals("")) {
                            x.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
                            finish();
                            z = false;
                            break;
                        }
                    case 7:
                        if (cyj()) {
                            if (this.fileName == null) {
                                x.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
                                finish();
                                z = false;
                                break;
                            }
                        }
                        finish();
                        z = false;
                        break;
                    case 9:
                        if (this.fDP == null || this.fDP.equals("")) {
                            x.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
                            finish();
                            z = false;
                            break;
                        }
                    case 2:
                    case 6:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 16:
                        z = true;
                        break;
                    case 15:
                        finish();
                        z = false;
                        break;
                    default:
                        x.e("MicroMsg.MsgRetransmitUI", "unknown type %s", new Object[]{Integer.valueOf(this.msgType)});
                }
                z = true;
                if (!z) {
                    return;
                }
                if (this.msgType == 11 || this.msgType == 1) {
                    Object<String> obj = this.zog;
                    x.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
                    if (11 == this.msgType && t.nH(this.fileName)) {
                        com.tencent.mm.ui.snackbar.a.c(this, getResources().getString(R.l.eKc), "");
                        this.mHandler.postDelayed(new 13(this), 1800);
                        return;
                    }
                    b bVar = new b((byte) 0);
                    bVar.zoW = new LinkedList();
                    bVar.zoW.addAll(obj);
                    for (String str2 : obj) {
                        final a aVar = new a();
                        getString(R.l.dGO);
                        this.iln = h.a(this, getString(R.l.dGB), true, new OnCancelListener(this) {
                            final /* synthetic */ MsgRetransmitUI zoG;

                            public final void onCancel(DialogInterface dialogInterface) {
                                aVar.zoO = true;
                            }
                        });
                        aVar.context = this;
                        aVar.fileName = this.fileName;
                        aVar.ilS = this.iln;
                        aVar.zol = this.zol;
                        aVar.hVH = this.length;
                        aVar.hTT = this.msgType;
                        aVar.zoQ = false;
                        aVar.userName = str2;
                        aVar.zoR = true;
                        aVar.zoj = this.zoj;
                        aVar.zoU = bVar;
                        r nF = t.nF(this.fileName);
                        if (!(nF == null || nF.hVQ == null)) {
                            x.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
                            aVar.zoT = nF.hVQ;
                            aVar.gjF = nF.Ud();
                        }
                        aVar.execute(new Object[0]);
                        bo.HS().c(bo.hhF, null);
                        if (this.fqm != -1) {
                            ar.Hg();
                            au dH = c.Fa().dH(this.fqm);
                            boolean eV = com.tencent.mm.z.s.eV(str2);
                            com.tencent.mm.ui.chatting.a.a(eV ? com.tencent.mm.ui.chatting.a.c.ypd : com.tencent.mm.ui.chatting.a.c.ypc, this.zov ? com.tencent.mm.ui.chatting.a.d.yph : com.tencent.mm.ui.chatting.a.d.ypg, dH, eV ? m.gl(str2) : 0);
                        } else {
                            return;
                        }
                    }
                    return;
                }
                if (this.msgType == 0) {
                    this.zoy = this.zog.size();
                }
                int size = this.zog.size();
                int i = size;
                boolean z2 = true;
                for (final String str22 : this.zog) {
                    i--;
                    boolean z3 = i == 0;
                    b mtVar;
                    switch (this.msgType) {
                        case 0:
                            ar.Dm().tS();
                            ar.Dm().F(new Runnable(this) {
                                final /* synthetic */ MsgRetransmitUI zoG;

                                public final void run() {
                                    x.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                                    this.zoG.a(str22, 4, null);
                                }
                            });
                            z = z2;
                            break;
                        case 2:
                        case 16:
                            z = aad(str22);
                            break;
                        case 4:
                            q.FS();
                            ar.CG().a(new j(str22, this.fDP, com.tencent.mm.z.s.hp(str22)), 0);
                            z = true;
                            break;
                        case 5:
                            z = bq(str22, false);
                            break;
                        case 6:
                            com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(bh.VH(this.fDP));
                            if (fT != null) {
                                a(str22, fT, null);
                                z = true;
                                break;
                            }
                            x.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
                            z = false;
                            break;
                        case 7:
                            ar.CG().a(new com.tencent.mm.modelvoice.f(com.tencent.mm.modelvoice.q.e(str22, this.fileName, this.length), 1), 0);
                            z = true;
                            break;
                        case 8:
                            ar.CG().a(new j(str22, this.fDP, 42), 0);
                            z = z2;
                            break;
                        case 9:
                            ar.CG().a(new j(str22, this.fDP, 48), 0);
                            z = true;
                            break;
                        case 10:
                            mtVar = new mt();
                            mtVar.fEE.type = 4;
                            com.tencent.mm.g.a.mt.a aVar2 = mtVar.fEE;
                            ar.Hg();
                            aVar2.fEJ = c.Fa().dH(this.fqm);
                            mtVar.fEE.toUser = str22;
                            com.tencent.mm.sdk.b.a.xef.m(mtVar);
                            z = z2;
                            break;
                        case 12:
                            com.tencent.mm.ui.chatting.j.k(this, str22, z3);
                            z = z2;
                            break;
                        case 13:
                            com.tencent.mm.ui.chatting.j.j(this, str22, z3);
                            z = z2;
                            break;
                        case 14:
                            mtVar = new pd();
                            mtVar.fGY.fpG = this.fqm;
                            mtVar.fGY.fys = this.fDP;
                            mtVar.fGY.fyt = str22;
                            com.tencent.mm.sdk.b.a.xef.m(mtVar);
                            break;
                    }
                    z = z2;
                    if (this.zot) {
                        com.tencent.mm.ui.chatting.j.mD(z3);
                    }
                    z2 = z;
                }
                str22 = (String) this.zog.get(0);
                switch (this.msgType) {
                    case 0:
                    case 2:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 16:
                        if (this.msgType == 2 || this.msgType == 16) {
                            com.tencent.mm.y.g.a fT2 = com.tencent.mm.y.g.a.fT(bh.VH(this.fDP));
                            if (fT2 != null && fT2.type == 5 && !bh.ov(fT2.url)) {
                                String str3 = "";
                                try {
                                    str3 = URLEncoder.encode(fT2.url, "UTF-8");
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                                }
                                int i2 = z2 ? 1 : 2;
                                x.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), fT2.url, Long.valueOf(this.startTime), Integer.valueOf(this.zoz), Integer.valueOf(1), Integer.valueOf(i2)});
                                g.pQN.h(13378, new Object[]{str3, Long.valueOf(this.startTime), Integer.valueOf(this.zoz), Integer.valueOf(1), Integer.valueOf(i2)});
                            } else if (!(z2 || fT2 == null || fT2.type != 33)) {
                                b nVar = new com.tencent.mm.g.a.n();
                                nVar.fnn.scene = this.zoC;
                                nVar.fnn.fnv = this.zoD;
                                if (2 == this.zoC) {
                                    nVar.fnn.fnp = this.zoB + ":" + this.zoA;
                                } else {
                                    nVar.fnn.fnp = this.zoB;
                                }
                                if (str22.endsWith("@chatroom")) {
                                    nVar.fnn.action = 2;
                                } else {
                                    nVar.fnn.action = 1;
                                }
                                nVar.fnn.fno = fT2.hdE + 1;
                                nVar.fnn.fnq = fT2.hdw;
                                nVar.fnn.fnl = fT2.hdx;
                                nVar.fnn.appId = fT2.hdy;
                                nVar.fnn.fnr = "";
                                nVar.fnn.fns = bh.Wo();
                                nVar.fnn.fnt = 2;
                                com.tencent.mm.sdk.b.a.xef.m(nVar);
                            }
                        }
                        if (z2) {
                            if (this.zoj) {
                                com.tencent.mm.ui.snackbar.a.h(this, getString(R.l.epb));
                            }
                            Intent intent = new Intent();
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(this.zog);
                            intent.putStringArrayListExtra("SendMsgUsernames", arrayList);
                            setResult(-1, intent);
                            if (this.zoE) {
                                this.mHandler.postDelayed(new 4(this), 1800);
                            }
                            if (this.zoi && !this.zow) {
                                intent = new Intent(this, ChattingUI.class);
                                intent.addFlags(67108864);
                                intent.putExtra("Chat_User", str22);
                                startActivity(intent);
                                return;
                            }
                            return;
                        }
                        finish();
                        return;
                    case 1:
                    case 11:
                        return;
                    default:
                        finish();
                        return;
                }
            case 1:
                str22 = (String) this.zog.get(0);
                if (cyj()) {
                    switch (this.msgType) {
                        case 0:
                            if (this.zop != null && this.zop.size() > 0) {
                                this.zor = this.zop.size();
                            }
                            this.hBj = new 16(this);
                            this.zok = h.a(this, getString(R.l.evO, new Object[]{Integer.valueOf(1), Integer.valueOf(this.zor), Integer.valueOf(0)}), getString(R.l.dGO), new 2(this));
                            this.zok.setOnCancelListener(new 3(this));
                            this.zok.setCanceledOnTouchOutside(false);
                            this.zok.getButton(-1).setText(R.l.dEn);
                            a(str22, 6, this.hBj);
                            return;
                        case 1:
                        case 11:
                            if (ab.bC(this)) {
                                m(getIntent(), str22);
                                return;
                            } else {
                                h.a(this, R.l.eSZ, R.l.dGO, R.l.dFU, R.l.dEn, new 11(this, str22), new OnClickListener(this) {
                                    final /* synthetic */ MsgRetransmitUI zoG;

                                    {
                                        this.zoG = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.zoG.finish();
                                    }
                                });
                                return;
                            }
                        case 5:
                            bq(str22, true);
                            return;
                        default:
                            x.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", new Object[]{Integer.valueOf(this.msgType)});
                            return;
                    }
                }
                finish();
                return;
            case 2:
                switch (this.msgType) {
                    case 2:
                    case 16:
                        View inflate;
                        this.zog.get(0);
                        str22 = getIntent().getExtras().getString(ConstantsAPI.APP_PACKAGE);
                        com.tencent.mm.pluginsdk.model.app.f fVar = new com.tencent.mm.pluginsdk.model.app.f();
                        fVar.field_packageName = str22;
                        an.bin().b(fVar, new String[]{DownloadInfoColumns.PACKAGENAME});
                        WXMediaMessage wXMediaMessage = new Req(getIntent().getExtras()).message;
                        c cVar = new c(new 9(this));
                        Bitmap bl = wXMediaMessage.thumbData == null ? null : com.tencent.mm.sdk.platformtools.d.bl(wXMediaMessage.thumbData);
                        View inflate2;
                        TextView textView;
                        switch (wXMediaMessage.mediaObject.type()) {
                            case 1:
                                inflate = View.inflate(this, R.i.daA, null);
                                ((TextView) inflate.findViewById(R.h.cSu)).setText(wXMediaMessage.title);
                                break;
                            case 2:
                                inflate2 = View.inflate(this, R.i.daz, null);
                                ((ImageView) inflate2.findViewById(R.h.cRi)).setImageBitmap(bl);
                                ((TextView) inflate2.findViewById(R.h.cSu)).setText(wXMediaMessage.title);
                                inflate = inflate2;
                                break;
                            case 3:
                                inflate2 = View.inflate(this, R.i.day, null);
                                ((ImageView) inflate2.findViewById(R.h.cRi)).setImageBitmap(bl);
                                textView = (TextView) inflate2.findViewById(R.h.caS);
                                ((TextView) inflate2.findViewById(R.h.cSu)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                inflate = inflate2;
                                break;
                            case 4:
                                inflate2 = View.inflate(this, R.i.day, null);
                                ((ImageView) inflate2.findViewById(R.h.cRi)).setImageBitmap(bl);
                                textView = (TextView) inflate2.findViewById(R.h.caS);
                                ((TextView) inflate2.findViewById(R.h.cSu)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                inflate = inflate2;
                                break;
                            case 5:
                                inflate2 = View.inflate(this, R.i.day, null);
                                ((ImageView) inflate2.findViewById(R.h.cRi)).setImageBitmap(bl);
                                textView = (TextView) inflate2.findViewById(R.h.caS);
                                ((TextView) inflate2.findViewById(R.h.cSu)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                inflate = inflate2;
                                break;
                            case 6:
                                inflate2 = View.inflate(this, R.i.day, null);
                                ((ImageView) inflate2.findViewById(R.h.cRi)).setImageBitmap(bl);
                                textView = (TextView) inflate2.findViewById(R.h.caS);
                                ((TextView) inflate2.findViewById(R.h.cSu)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                inflate = inflate2;
                                break;
                            case 7:
                                inflate2 = View.inflate(this, R.i.day, null);
                                ((ImageView) inflate2.findViewById(R.h.cRi)).setImageBitmap(bl);
                                textView = (TextView) inflate2.findViewById(R.h.caS);
                                ((TextView) inflate2.findViewById(R.h.cSu)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                inflate = inflate2;
                                break;
                            default:
                                x.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + wXMediaMessage.mediaObject.type());
                                return;
                        }
                        ((TextView) inflate.findViewById(R.h.cPc)).setText(com.tencent.mm.pluginsdk.model.app.g.a((Context) this, fVar, null));
                        cVar.pyk = h.a(this, null, inflate, getString(R.l.dGA), getString(R.l.dEn), new 1(cVar), new 2(cVar));
                        return;
                    default:
                        return;
                }
            default:
                x.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", new Object[]{Integer.valueOf(this.zom)});
                finish();
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str;
        if (i2 != -1) {
            com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(bh.VH(this.fDP));
            if (fT != null && fT.type == 5 && fT.url != null) {
                x.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), fT.url, Long.valueOf(this.startTime), Integer.valueOf(this.zoz), Integer.valueOf(1), Integer.valueOf(3)});
                str = "";
                try {
                    str = URLEncoder.encode(fT.url, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                }
                g.pQN.h(13378, new Object[]{str, Long.valueOf(this.startTime), Integer.valueOf(this.zoz), Integer.valueOf(1), Integer.valueOf(3)});
            } else if (fT != null && fT.type == 33) {
                b nVar = new com.tencent.mm.g.a.n();
                nVar.fnn.fnv = this.zoD;
                nVar.fnn.scene = this.zoC;
                if (2 == this.zoC) {
                    nVar.fnn.fnp = this.zoB + ":" + this.zoA;
                } else {
                    nVar.fnn.fnp = this.zoB;
                }
                nVar.fnn.fno = fT.hdE + 1;
                nVar.fnn.fnq = fT.hdw;
                nVar.fnn.fnl = fT.hdx;
                nVar.fnn.appId = fT.hdy;
                nVar.fnn.action = 1;
                nVar.fnn.fnr = "";
                nVar.fnn.fns = bh.Wo();
                nVar.fnn.fnt = 3;
                com.tencent.mm.sdk.b.a.xef.m(nVar);
            }
            finish();
        } else if (i != 0) {
            x.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = " + i);
        } else {
            this.zog = bh.F(intent.getStringExtra("Select_Conv_User").split(","));
            Object stringExtra = intent.getStringExtra("custom_send_text");
            this.vnK = intent.getBooleanExtra("key_is_biz_chat", false);
            if (this.vnK) {
                this.kGB = intent.getLongExtra("key_biz_chat_id", -1);
            }
            int intExtra = intent.getIntExtra("Retr_Msg_Type", -1);
            if (intExtra != -1) {
                x.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[]{Integer.valueOf(this.msgType), Integer.valueOf(intExtra)});
                this.msgType = intExtra;
            }
            x.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[]{Integer.valueOf(this.msgType), Integer.valueOf(this.zom), Integer.valueOf(this.zog.size())});
            cyi();
            if (!TextUtils.isEmpty(stringExtra)) {
                for (String str2 : this.zog) {
                    b orVar = new or();
                    orVar.fGI.fGJ = str2;
                    orVar.fGI.content = stringExtra;
                    orVar.fGI.type = com.tencent.mm.z.s.hp(str2);
                    orVar.fGI.flags = 0;
                    com.tencent.mm.sdk.b.a.xef.m(orVar);
                }
            }
        }
    }

    private boolean aad(String str) {
        byte[] d;
        Throwable e;
        Exception e2;
        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(bh.VH(this.fDP));
        x.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[]{this.fDP, fT});
        if (fT == null) {
            x.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
            return false;
        }
        ar.Hg();
        cf dH = c.Fa().dH(this.fqm);
        if (!dH.ciV()) {
            if (this.zoh != null) {
                try {
                    d = FileOp.d(this.zoh, 0, -1);
                    try {
                        if (!bA(d)) {
                            return false;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        x.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                        x.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[]{str, e.getLocalizedMessage()});
                        ar.Dm().F(new 10(this, str, fT, d));
                        return true;
                    }
                } catch (Throwable e4) {
                    Throwable th = e4;
                    d = null;
                    e = th;
                    x.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                    x.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[]{str, e.getLocalizedMessage()});
                    ar.Dm().F(new 10(this, str, fT, d));
                    return true;
                }
            } else if (this.yLf >= 0 || dH.field_imgPath == null || dH.field_imgPath.equals("")) {
                d = null;
            } else {
                try {
                    d = FileOp.d(com.tencent.mm.aq.o.Pw().B(dH.field_imgPath, true), 0, -1);
                    try {
                        if (!bA(d)) {
                            return false;
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        x.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[]{str, e2.getLocalizedMessage()});
                        ar.Dm().F(new 10(this, str, fT, d));
                        return true;
                    }
                } catch (Exception e6) {
                    Exception exception = e6;
                    d = null;
                    e2 = exception;
                    x.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[]{str, e2.getLocalizedMessage()});
                    ar.Dm().F(new 10(this, str, fT, d));
                    return true;
                }
            }
            ar.Dm().F(new 10(this, str, fT, d));
        } else if (fT.type == 33) {
            k.b(str, fT, bx.d(((HashMap) getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
        } else {
            com.tencent.mm.ui.chatting.i.a(this, str, this.fDP, dH.field_isSend, this.yoF);
        }
        return true;
    }

    private void a(String str, com.tencent.mm.y.g.a aVar, byte[] bArr) {
        x.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[]{str, aVar.fny});
        com.tencent.mm.pluginsdk.model.app.b RI = com.tencent.mm.pluginsdk.model.app.l.RI(aVar.fny);
        String str2 = "";
        if (!(RI == null || RI.field_fileFullPath == null || RI.field_fileFullPath.equals(""))) {
            ar.Hg();
            str2 = com.tencent.mm.pluginsdk.model.app.l.ac(c.Fu(), aVar.title, aVar.hbc);
            FileOp.x(RI.field_fileFullPath, str2);
            x.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[]{RI.field_fileFullPath, aVar.title, str2, Boolean.valueOf(RI.aOC())});
        }
        final com.tencent.mm.y.g.a a = com.tencent.mm.y.g.a.a(aVar);
        a.hbe = 3;
        if (!bh.ov(str2) || (aVar.hbf == 0 && aVar.hbb <= 26214400)) {
            com.tencent.mm.pluginsdk.model.app.l.a(a, aVar.appId, aVar.appName, str, str2, bArr, this.iKB);
            if (a.type == 36) {
                int i = str.endsWith("chatroom") ? 1 : 0;
                String encode = URLEncoder.encode(bh.ou(a.url));
                String encode2 = URLEncoder.encode(bh.ou(a.title));
                String encode3 = URLEncoder.encode(bh.ou(a.description));
                String encode4 = URLEncoder.encode(bh.ou(a.hdw));
                g.pQN.h(14127, new Object[]{a.appId, a.hdx, encode4, encode2, encode3, "", encode, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), str});
                return;
            }
            return;
        }
        x.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[]{Integer.valueOf(aVar.hbf), Integer.valueOf(aVar.hbb)});
        final com.tencent.mm.y.g.a aVar2 = aVar;
        encode3 = str;
        final byte[] bArr2 = bArr;
        ar.CG().a(new z(aVar, null, str, new com.tencent.mm.pluginsdk.model.app.z.a(this) {
            final /* synthetic */ MsgRetransmitUI zoG;

            public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                x.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[]{str, bh.VT(str2), bh.VT(str3), bh.VT(aVar2.hbp), bh.VT(str4), bh.VT(str5)});
                if (bh.ov(str3)) {
                    h.b(this.zoG, this.zoG.getString(R.l.dXA), "", true);
                    this.zoG.finish();
                    return;
                }
                com.tencent.mm.pluginsdk.model.app.l.a(a, aVar2.appId, aVar2.appName, encode3, "", bArr2, this.zoG.iKB, str3);
            }
        }), 0);
    }

    private boolean bq(String str, boolean z) {
        if (this.fileName == null) {
            return false;
        }
        EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(this.fileName);
        int bN = yc == null ? com.tencent.mm.a.e.bN(this.fileName) : com.tencent.mm.a.e.bN(yc.ckB());
        String ckB = yc == null ? this.fileName : yc.ckB();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        boolean z2;
        if ((com.tencent.mm.sdk.platformtools.d.decodeFile(ckB, options) == null || options.outHeight <= com.tencent.mm.k.b.zE()) && options.outWidth <= com.tencent.mm.k.b.zE()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (bN > com.tencent.mm.k.b.zF() || r0) {
            String str2 = "MicroMsg.MsgRetransmitUI";
            String str3 = "emoji is over size. md5:%s size:%d";
            Object[] objArr = new Object[2];
            objArr[0] = yc == null ? DownloadInfo.FILENAME : yc.Nr();
            objArr[1] = Integer.valueOf(this.length);
            x.i(str2, str3, objArr);
            this.zoE = false;
            this.zoj = false;
            h.a(this, getString(R.l.dZJ), "", getString(R.l.epk), new 15(this));
            if (this.zou != 1) {
                return true;
            }
            g.pQN.h(13459, new Object[]{Integer.valueOf(bN), Integer.valueOf(1), yc.Nr(), Integer.valueOf(1)});
            return true;
        }
        if (this.zou == 1) {
            g gVar = g.pQN;
            objArr = new Object[4];
            objArr[0] = Integer.valueOf(bN);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = yc == null ? "" : yc.Nr();
            objArr[3] = Integer.valueOf(1);
            gVar.h(13459, objArr);
        }
        if (z) {
            EmojiInfo yc2;
            if (yc == null) {
                yc2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(getApplicationContext(), new WXMediaMessage(new WXEmojiObject(this.fileName)), ""));
            } else {
                yc2 = yc;
            }
            g.pQN.h(13459, new Object[]{Integer.valueOf(bN), Integer.valueOf(0), yc2.Nr(), Integer.valueOf(2)});
            com.tencent.mm.ui.chatting.i.b(yc2, str);
            finish();
            return true;
        } else if (yc != null && bN > com.tencent.mm.k.b.zD()) {
            com.tencent.mm.ui.chatting.i.b(yc, str);
            return true;
        } else if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().m(this, str, this.fileName)) {
            return true;
        } else {
            x.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
            return false;
        }
    }

    private boolean cyj() {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            return true;
        }
        x.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
        u.fI(this);
        return false;
    }

    private void m(Intent intent, String str) {
        if (this.zos) {
            this.zor = this.zop.size();
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
            if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                finish();
                return;
            }
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                it.next();
                if (!this.zoF) {
                    aae(str);
                } else {
                    return;
                }
            }
            return;
        }
        this.zor = 1;
        aae(str);
    }

    private void aae(String str) {
        x.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
        Object kVar = new com.tencent.mm.pluginsdk.model.k(this, null, getIntent(), str, 1, new 5(this));
        com.tencent.mm.sdk.f.e.post(kVar, "ChattingUI_importMultiVideo");
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.dHc), true, new 6(this, kVar));
    }

    private void a(String str, int i, f fVar) {
        String str2;
        String FS = q.FS();
        String str3 = "";
        ar.Hg();
        cf dH = c.Fa().dH(this.fqm);
        if (dH.field_msgId == this.fqm) {
            str3 = dH.field_content;
        }
        com.tencent.mm.aq.e eVar = null;
        if (dH.field_msgId > 0) {
            eVar = com.tencent.mm.aq.o.Pw().bi(dH.field_msgId);
        }
        if ((eVar == null || eVar.hzP <= 0) && dH.field_msgSvrId > 0) {
            eVar = com.tencent.mm.aq.o.Pw().bh(dH.field_msgSvrId);
        }
        if (str3 != null || dH.field_msgSvrId <= 0) {
            str2 = str3;
        } else {
            str2 = eVar.hAa;
        }
        if (eVar == null || ((eVar.offset >= eVar.hlp && eVar.hlp != 0) || this.zos)) {
            a(str, i, FS, str2, fVar);
            return;
        }
        int i2;
        com.tencent.mm.aq.e bh = com.tencent.mm.aq.o.Pw().bh(dH.field_msgSvrId);
        if (dH.field_isSend == 1) {
            int i3;
            if (bh.Pe()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            i2 = i3;
        } else if (bh.Pe()) {
            if (com.tencent.mm.a.e.bO(com.tencent.mm.aq.o.Pw().m(com.tencent.mm.aq.f.a(bh).hzQ, "", ""))) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = this.fileName;
        long a = com.tencent.mm.aq.o.Pw().a(this.fileName, i2, i, 0, pString, pInt, pInt2);
        eVar = com.tencent.mm.aq.o.Pw().b(Long.valueOf(a));
        eVar.hO(1);
        cf auVar = new au();
        auVar.setType(com.tencent.mm.z.s.hq(str));
        auVar.dS(str);
        auVar.eR(1);
        auVar.eQ(1);
        auVar.dT(pString.value);
        auVar.fc(pInt.value);
        auVar.fd(pInt2.value);
        auVar.aq(ba.hR(auVar.field_talker));
        if (com.tencent.mm.ag.f.eE(auVar.field_talker)) {
            dH.dY(com.tencent.mm.ag.a.e.HD());
        }
        ar.Hg();
        long Q = c.Fa().Q(auVar);
        Assert.assertTrue(Q >= 0);
        x.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = " + Q);
        eVar.bf((long) ((int) Q));
        com.tencent.mm.aq.o.Pw().a(Long.valueOf(a), eVar);
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(Q), bh);
        com.tencent.mm.aq.o.Px().a(bh.hzP, dH.field_msgId, i2, hashMap, R.g.bAH, new 7(this, str, i, FS, str2, fVar));
    }

    private void a(String str, int i, String str2, String str3, f fVar) {
        if (!bh.ov(this.fileName)) {
            this.zoq = 1;
            this.zor = 1;
            if (aaf(this.fileName)) {
                if (q.a(this.fileName, str, this.hzT == 0)) {
                    this.hzT = 1;
                } else {
                    this.hzT = 0;
                }
                long currentTimeMillis = System.currentTimeMillis();
                g.pQN.a(106, 96, 1, false);
                this.zon = new l(i, str2, str, this.fileName, this.hzT, fVar, 0, str3, "", true, R.g.bAH, this.zou, this.hBL, this.fzt);
                if (this.zom == 1) {
                    this.zon.Pm();
                }
                ar.CG().a(this.zon, 0);
                this.zoo = true;
                x.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.hzT)});
                bo.HS().c(bo.hhE, null);
            }
        } else if (this.zos) {
            this.zoq++;
            if (aaf((String) this.zop.get(0))) {
                if (q.a((String) this.zop.get(0), str, this.hzT == 0)) {
                    this.hzT = 1;
                } else {
                    this.hzT = 0;
                }
                x.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[]{Integer.valueOf(this.hzT)});
                this.zon = new l(i, str2, str, (String) this.zop.get(0), this.hzT, fVar, 0, str3, "", true, R.g.bAH);
                if (this.zom == 1) {
                    this.zon.Pm();
                }
                this.zoo = true;
                ar.CG().a(this.zon, 0);
                bo.HS().c(bo.hhE, null);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean aaf(String str) {
        Throwable th;
        x.i("MicroMsg.MsgRetransmitUI", "isImage called, fn:%s, scene:%d", new Object[]{str, Integer.valueOf(7)});
        InputStream inputStream = null;
        try {
            inputStream = FileOp.openRead(str);
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            if (MMBitmapFactory.checkIsImageLegal(inputStream, decodeResultLogger) || decodeResultLogger.getDecodeResult() < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                    }
                }
                return true;
            }
            x.w("MicroMsg.MsgRetransmitUI", "try to send illegal image.");
            g.pQN.k(12712, KVStatHelper.getKVStatString(str, 7, decodeResultLogger));
            if (inputStream == null) {
                return false;
            }
            try {
                inputStream.close();
                return false;
            } catch (Exception e2) {
                return false;
            }
        } catch (FileNotFoundException e3) {
            InputStream inputStream2 = inputStream;
            try {
                x.w("MicroMsg.MsgRetransmitUI", "fn:%s not found.", new Object[]{str});
                if (inputStream2 == null) {
                    return false;
                }
                try {
                    inputStream2.close();
                    return false;
                } catch (Exception e4) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    private static boolean bA(byte[] bArr) {
        x.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d], scene:%d", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Integer.valueOf(6)});
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        if (MMBitmapFactory.checkIsImageLegal(bArr, decodeResultLogger) || decodeResultLogger.getDecodeResult() < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            return true;
        }
        x.w("MicroMsg.MsgRetransmitUI", "try to send illegal image.");
        g.pQN.k(12712, KVStatHelper.getKVStatString(bArr, 6, decodeResultLogger));
        return false;
    }

    @com.tencent.mm.sdk.platformtools.g
    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (kVar.getType() == 110 && (kVar instanceof l)) {
            l lVar = (l) kVar;
            if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false)) {
                String stringExtra = getIntent().getStringExtra("Retr_KSnsId");
                b psVar;
                if (com.tencent.mm.z.s.eV(lVar.fGJ)) {
                    psVar = new ps();
                    psVar.fHv.fzW = stringExtra;
                    com.tencent.mm.sdk.b.a.xef.m(psVar);
                } else {
                    psVar = new pt();
                    psVar.fHw.fzW = stringExtra;
                    com.tencent.mm.sdk.b.a.xef.m(psVar);
                }
            }
            if (this.zop == null || this.zop.size() <= 1) {
                if (this.zok != null) {
                    this.zok.dismiss();
                    this.zok = null;
                }
                this.zoy--;
                if (this.zoy <= 0 || !this.zox) {
                    this.zoo = false;
                    ar.CG().b(110, this);
                    if (this.zom != 0) {
                        if (this.zoi && !this.zow) {
                            Intent intent = new Intent(this, ChattingUI.class);
                            intent.addFlags(67108864);
                            intent.putExtra("Chat_User", lVar.fGJ);
                            startActivity(intent);
                        }
                        finish();
                        return;
                    }
                    return;
                }
                return;
            }
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, getString(R.l.evM, new Object[]{this.zop.get(0)}), 1).show();
            }
            this.zop.remove(0);
            a(lVar.fGJ, 3, this.hBj);
        }
    }
}
