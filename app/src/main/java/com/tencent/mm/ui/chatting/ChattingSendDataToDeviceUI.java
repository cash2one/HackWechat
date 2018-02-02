package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXLocationObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.Sort3rdAppUI;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.R$styleable;

@com.tencent.mm.ui.base.a(3)
public class ChattingSendDataToDeviceUI extends MMActivity {
    private com.tencent.mm.y.g.a fEt;
    String filePath = null;
    boolean fsG = false;
    private long gAc;
    String iHF = null;
    private String lLW;
    private au rZn;
    private HorizontalListView vrK;
    private boolean ypn;
    boolean yqc = false;
    private HorizontalListView yuA;
    private b yuB;
    private a yuC;
    private int yuD;
    private String yuE = "";
    private RelativeLayout yuF;
    private RelativeLayout yuG;
    private TextView yuH;
    private Boolean yuI = Boolean.valueOf(false);
    private b yuJ;
    private List<c> yuK = new ArrayList();
    private List<f> yuL = new ArrayList();
    private long yuM = 0;
    private boolean yuN = true;
    boolean yuO = false;
    boolean yuP = true;
    int yuQ = 2;
    int yuR = -1;
    private HashMap<String, View> yuS = new HashMap();
    HashMap<String, c> yuT = new HashMap();
    Map<Integer, View> yuU = new HashMap();
    Map<String, Integer> yuV = new HashMap();
    WXMediaMessage yuW = null;
    private com.tencent.mm.sdk.b.c yuX = new 10(this);
    private com.tencent.mm.sdk.b.c yuY = new 2(this);

    private class a extends BaseAdapter {
        private Context context;
        private com.tencent.mm.aq.a.a.c lRR;
        private List<Map<String, c>> yqb = new ArrayList();
        final /* synthetic */ ChattingSendDataToDeviceUI yuZ;
        private Map<String, c> yvh;

        public final /* synthetic */ Object getItem(int i) {
            return Fy(i);
        }

        public a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, Context context) {
            this.yuZ = chattingSendDataToDeviceUI;
            this.context = context;
            com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
            aVar.hDP = R.g.bDU;
            this.lRR = aVar.PK();
        }

        public final void aD(List<c> list) {
            this.yqb.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.yvh = new HashMap();
                this.yvh.put("hard_device_info", list.get(i));
                this.yqb.add(this.yvh);
            }
        }

        public final int getCount() {
            return this.yqb.size();
        }

        public final c Fy(int i) {
            return (c) ((Map) this.yqb.get(i)).get("hard_device_info");
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            al alVar;
            View view2;
            c Fy = Fy(i);
            x.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(getCount())});
            if (this.yuZ.yuU.get(Integer.valueOf(i)) == null) {
                alVar = new al();
                View inflate = View.inflate(viewGroup.getContext(), R.i.drN, null);
                alVar.lUV = inflate.findViewById(R.h.bYF);
                alVar.lgz = (TextView) inflate.findViewById(R.h.cyA);
                alVar.jCP = (ImageView) inflate.findViewById(R.h.coK);
                alVar.yvg = (TextView) inflate.findViewById(R.h.cLr);
                alVar.yxX = (SendDataToDeviceProgressBar) inflate.findViewById(R.h.cLq);
                alVar.yxX.setVisibility(4);
                this.yuZ.yuU.put(Integer.valueOf(i), inflate);
                inflate.setTag(alVar);
                view2 = inflate;
            } else {
                View view3 = (View) this.yuZ.yuU.get(Integer.valueOf(i));
                alVar = (al) view3.getTag();
                view2 = view3;
            }
            this.yuZ.yuV.put(Fy.deviceID, Integer.valueOf(i));
            Object obj = Fy.gBL;
            int i2 = 8;
            int i3 = 0;
            StringBuffer stringBuffer = new StringBuffer();
            CharSequence stringBuffer2 = new StringBuffer();
            float eu = com.tencent.mm.bv.a.eu(this.context);
            if (eu == 1.125f || eu == 1.25f) {
                i2 = 6;
            } else if (eu == 1.375f || eu == 1.625f) {
                i2 = 5;
            }
            for (int i4 = 0; i4 < obj.length(); i4++) {
                int codePointAt = Character.codePointAt(obj, i4);
                String substring = obj.substring(i4, i4 + 1);
                if (codePointAt < 0 || codePointAt > 255) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 <= i2) {
                    stringBuffer = stringBuffer.append(substring);
                } else {
                    stringBuffer2 = stringBuffer2.append(substring);
                }
            }
            alVar.lgz.setText(stringBuffer.toString());
            if (i3 >= i2) {
                alVar.yvg.setText(stringBuffer2);
            }
            c cVar = null;
            if (this.yuZ.yuT.containsKey(Fy(i).deviceID)) {
                cVar = (c) this.yuZ.yuT.get(Fy(i).deviceID);
            }
            if (!(cVar == null || cVar.fsK == null)) {
                x.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[]{Integer.valueOf(i), cVar.fsK});
                if (cVar.fsK.equals("send_data_sending")) {
                    alVar.yvg.setText(this.context.getString(R.l.dSZ));
                    alVar.yvg.setTextColor(this.context.getResources().getColor(R.e.btM));
                    alVar.yxX.setProgress(Fy.progress);
                    alVar.yxX.setVisibility(0);
                    c cVar2 = (c) this.yuZ.yuT.get(Fy.deviceID);
                    int i5 = cVar2.progress;
                    if (i5 >= 100) {
                        i3 = 0;
                    } else {
                        i3 = 500 / (100 - i5);
                    }
                    e.b(new 1(this, i5, cVar2, alVar, i3), "SendDataState_handler").start();
                } else if (cVar.fsK.equals("send_data_sucess")) {
                    alVar.yvg.setText(this.context.getString(R.l.dSX));
                    alVar.yvg.setTextColor(this.context.getResources().getColor(R.e.btM));
                    alVar.yxX.setVisibility(4);
                } else if (cVar.fsK.equals("send_data_cancel")) {
                    alVar.yvg.setText(this.context.getString(R.l.dSR));
                    alVar.yvg.setTextColor(this.context.getResources().getColor(R.e.btL));
                    alVar.yxX.setVisibility(4);
                } else if (cVar.fsK.equals("send_data_failed")) {
                    alVar.yvg.setText(this.context.getString(R.l.dSV));
                    alVar.yvg.setTextColor(this.context.getResources().getColor(R.e.btN));
                    alVar.yxX.setVisibility(4);
                }
            }
            x.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[]{Integer.valueOf(i), Fy.gBL});
            o.PA().a(Fy.iconUrl, alVar.jCP, this.lRR);
            alVar.lUV.setTag(Integer.valueOf(i));
            return view2;
        }
    }

    public class c {
        String deviceID;
        String frg;
        String fsF;
        String fsK;
        String gBL;
        String iconUrl;
        int progress;
        final /* synthetic */ ChattingSendDataToDeviceUI yuZ;
        String yvl;

        public c(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
            this.yuZ = chattingSendDataToDeviceUI;
        }
    }

    static /* synthetic */ void Zb(String str) {
        b ebVar = new eb();
        ebVar.fsI.fsK = str;
        com.tencent.mm.sdk.b.a.xef.m(ebVar);
    }

    static /* synthetic */ void a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, String str, String str2, int i) {
        x.d("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data State:%s progress: %d", new Object[]{str, Integer.valueOf(i)});
        chattingSendDataToDeviceUI.runOnUiThread(new 9(chattingSendDataToDeviceUI, str2, str, i));
    }

    static /* synthetic */ void a(boolean z, int i, View view) {
        try {
            al alVar = (al) view.getTag();
            if (alVar != null) {
                if (z) {
                    alVar.yxX.setVisibility(0);
                    if (i > alVar.yxX.getProgress()) {
                        alVar.yxX.setProgress(i);
                        return;
                    }
                    return;
                }
                alVar.yxX.setVisibility(4);
                alVar.yxX.setProgress(0);
            }
        } catch (Exception e) {
            x.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress exception %s", new Object[]{e});
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        int i = 6;
        super.onCreate(bundle);
        this.fsG = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
        x.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.fsG);
        if (!this.fsG) {
            this.gAc = getIntent().getExtras().getLong("Retr_Msg_Id");
            if (this.gAc != -1) {
                ar.Hg();
                this.rZn = com.tencent.mm.z.c.Fa().dH(this.gAc);
                if (!(this.rZn == null || this.rZn.field_msgId == 0)) {
                    this.yuD = this.rZn.getType();
                    this.ypn = s.eV(this.rZn.field_talker);
                    this.yuE = this.rZn.field_content;
                    if (this.ypn && this.rZn.field_isSend == 0) {
                        str = this.rZn.field_content;
                        int i2 = this.rZn.field_isSend;
                        if (this.ypn && str != null && i2 == 0) {
                            str = ba.hQ(str);
                        }
                        this.yuE = str;
                    }
                    Long Rc;
                    com.tencent.mm.aq.e n;
                    if (this.rZn.getType() == 49) {
                        this.fEt = com.tencent.mm.y.g.a.fT(this.yuE);
                        if (this.fEt == null) {
                            x.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
                        } else if (this.fEt.type == 3) {
                            this.yuM = 16;
                        } else if (this.fEt.type == 4) {
                            this.yuM = 8;
                        } else if (this.fEt.type == 5) {
                            this.yuM = 32;
                        } else if (this.fEt.type == 6) {
                            Rc = com.tencent.mm.pluginsdk.b.a.Rc(this.fEt.hbc);
                            if (Rc == null) {
                                x.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
                            } else {
                                this.yuM = Rc.longValue();
                            }
                        } else if (this.fEt.type == 2) {
                            this.yuM = 2;
                            n = o.Pw().n(this.rZn);
                            if (n != null) {
                                this.yuE = n.hAa;
                            }
                        } else {
                            x.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
                        }
                    } else {
                        if (this.rZn.getType() == 3) {
                            n = o.Pw().n(this.rZn);
                            if (n != null) {
                                this.yuE = n.hAa;
                            }
                        } else if (this.rZn.getType() == 43) {
                            r nr = com.tencent.mm.modelvideo.o.TU().nr(this.rZn.field_imgPath);
                            if (nr != null) {
                                this.yuE = nr.Ug();
                            }
                        }
                        Rc = com.tencent.mm.pluginsdk.b.a.Rc(this.yuD);
                        if (Rc == null) {
                            x.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
                        } else {
                            this.yuM = Rc.longValue();
                        }
                    }
                    x.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[]{Long.valueOf(this.yuM)});
                }
            }
        }
        this.yuQ = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
        this.yuO = false;
        setFinishOnTouchOutside(true);
        this.yuK.clear();
        this.yuT.clear();
        this.yuF = (RelativeLayout) findViewById(R.h.cAe);
        b dhVar = new dh();
        if (this.fsG) {
            this.lLW = getIntent().getExtras().getString("sns_local_id");
            if (this.lLW != null) {
                dhVar.frQ.frH = this.lLW;
                x.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[]{this.lLW});
            }
        } else {
            dhVar.frQ.fqm = this.gAc;
        }
        com.tencent.mm.sdk.b.a.xef.m(dhVar);
        if (dhVar.frR.frp) {
            this.yuI = Boolean.valueOf(true);
            com.tencent.mm.sdk.b.a.xef.b(this.yuX);
            com.tencent.mm.sdk.b.a.xef.b(this.yuY);
            this.yuF.setVisibility(0);
            this.vrK = (HorizontalListView) findViewById(R.h.ctf);
            this.yuH = (TextView) findViewById(R.h.bLB);
            this.yuH.setText(R.l.dSO);
            this.yuC = new a(this, this);
            this.vrK.setAdapter(this.yuC);
            this.vrK.setOnItemClickListener(new 1(this));
            crZ();
            if (this.fsG) {
                int i3;
                str = this.lLW;
                if (str != null) {
                    b htVar = new ht();
                    htVar.fyb.frH = str;
                    com.tencent.mm.sdk.b.a.xef.m(htVar);
                    i3 = htVar.fyc.fyd.wQo.vYc;
                    if (i3 == 1) {
                        i3 = 3;
                    } else if (i3 == 4) {
                        i3 = 1;
                    } else if (i3 == 15) {
                        i3 = 6;
                    } else if (i3 == 3) {
                        i3 = 5;
                    }
                    this.yuR = i3;
                }
                i3 = 0;
                this.yuR = i3;
            } else {
                long j = this.gAc;
                if (j == -1 || j == Long.MIN_VALUE) {
                    i = 0;
                } else {
                    ar.Hg();
                    cf dH = com.tencent.mm.z.c.Fa().dH(j);
                    if (dH.field_msgId != 0) {
                        i2 = dH.getType();
                        String str2 = dH.field_content;
                        if (dH.aNc()) {
                            com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(str2);
                            if (fT == null) {
                                x.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
                            } else if (fT.type == 3) {
                                i = 1;
                            } else if (fT.type != 4) {
                                if (fT.type == 6) {
                                    i = 4;
                                } else if (fT.type == 2) {
                                    i = 3;
                                } else if (fT.type == 5) {
                                    i = 5;
                                }
                            }
                        } else if (i2 == 3) {
                            i = 3;
                        } else if (i2 == 48) {
                            i = 2;
                        } else if (i2 == 62) {
                        }
                    }
                    i = 0;
                }
                this.yuR = i;
            }
            pg(1);
        } else {
            this.yuF.setVisibility(8);
        }
        this.yuG = (RelativeLayout) findViewById(R.h.bKT);
        this.yuA = (HorizontalListView) findViewById(R.h.bKA);
        this.yuB = new b(this);
        this.yuA.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ChattingSendDataToDeviceUI yuZ;

            {
                this.yuZ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                x.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[]{Integer.valueOf(i)});
                if (i == adapterView.getAdapter().getCount() - 1) {
                    Intent intent = new Intent(this.yuZ, Sort3rdAppUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("KFlag", this.yuZ.yuM);
                    this.yuZ.startActivity(intent);
                } else if (this.yuZ.yqc && i == adapterView.getAdapter().getCount() - 2) {
                    if (this.yuZ.filePath == null || this.yuZ.iHF == null) {
                        h.bu(this.yuZ.getBaseContext(), this.yuZ.getString(R.l.dZc));
                    } else {
                        com.tencent.mm.pluginsdk.ui.tools.a.b(this.yuZ, this.yuZ.filePath, this.yuZ.iHF.toLowerCase(), 1);
                    }
                } else if (i >= 0 && i < adapterView.getAdapter().getCount() - 1) {
                    f fVar = (f) this.yuZ.yuL.get(i);
                    if (g.a(this.yuZ.getBaseContext(), fVar)) {
                        com.tencent.mm.bz.a.post(new 1(this, fVar));
                        return;
                    }
                    h.bu(this.yuZ.getBaseContext(), this.yuZ.getString(R.l.dSQ));
                    fVar.field_status = 4;
                    an.bin().a(fVar, new String[0]);
                    this.yuZ.crY();
                }
            }
        });
        this.yuA.setAdapter(this.yuB);
    }

    private void pg(int i) {
        if (this.fsG) {
            com.tencent.mm.plugin.report.service.g.pQN.h(13197, new Object[]{Integer.valueOf(i), Integer.valueOf(this.yuR), "", Integer.valueOf(2), Integer.valueOf(this.yuQ)});
            return;
        }
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.yuR);
        long j = this.gAc;
        String str = "";
        ar.Hg();
        cf dH = com.tencent.mm.z.c.Fa().dH(j);
        if (dH.field_msgId == 0) {
            str = "";
        } else {
            String str2 = dH.field_content;
            if (dH.getType() == 49) {
                com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(str2);
                if (fT != null && fT.type == 6) {
                    str = fT.hbc;
                }
            }
        }
        objArr[2] = str;
        objArr[3] = Integer.valueOf(1);
        objArr[4] = Integer.valueOf(this.yuQ);
        gVar.h(13197, objArr);
    }

    protected final int getLayoutId() {
        return R.i.deq;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b dfVar = new df();
        if (this.fsG) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            dfVar.frF.frH = this.lLW;
            dfVar.frF.frI = string;
            dfVar.frF.frJ = i;
        } else {
            dfVar.frF.fqm = this.gAc;
        }
        com.tencent.mm.sdk.b.a.xef.m(dfVar);
        if (dfVar.frG.frp && this.yuK.size() > 0) {
            x.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[]{Integer.valueOf(this.yuK.size())});
            this.yuC.aD(this.yuK);
            if (this.yuC.getCount() > 0) {
                this.yuH.setText(R.l.dQA);
                this.yuN = false;
            }
            this.yuC.notifyDataSetChanged();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void crY() {
        if (this.yuB == null || this.yuM == 0) {
            String str = "MicroMsg.ChattingSendDataToDeviceUI";
            String str2 = "mAppInfoAdapter is null %s, contentFlag %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.yuB == null);
            objArr[1] = Long.valueOf(this.yuM);
            x.e(str, str2, objArr);
            if (this.yuG != null) {
                this.yuG.setVisibility(8);
                return;
            }
            return;
        }
        this.yuL = g.b((Context) this, this.yuM, false);
        if (!(g.m((Context) this, this.yuM) || this.yuG == null)) {
            this.yuG.setVisibility(8);
        }
        List arrayList = new ArrayList();
        if (this.yuL != null && this.yuL.size() > 0) {
            List fs = an.bYT().fs(this.yuM);
            if (fs != null && fs.size() > 0) {
                Collections.sort(this.yuL, new 4(this, fs));
            }
            for (f fVar : this.yuL) {
                y yVar = new y();
                yVar.appId = fVar.field_appId;
                yVar.gBL = fVar.field_appName;
                yVar.iconUrl = fVar.field_appIconUrl;
                arrayList.add(yVar);
            }
        }
        if (this.yuW == null) {
            IMediaObject iMediaObject = null;
            com.tencent.mm.aq.e n;
            int lastIndexOf;
            switch (this.rZn.getType()) {
                case 1:
                    iMediaObject = new WXTextObject(this.rZn.field_content);
                case 3:
                    iMediaObject = new WXImageObject();
                    n = o.Pw().n(this.rZn);
                    if (n != null) {
                        iMediaObject.imagePath = o.Pw().lm(n.hzQ);
                        if (bh.ov(iMediaObject.imagePath)) {
                            iMediaObject.imagePath = o.Pw().lm(n.hzS);
                        }
                        if (!bh.ov(iMediaObject.imagePath)) {
                            this.filePath = iMediaObject.imagePath;
                            lastIndexOf = iMediaObject.imagePath.lastIndexOf(".");
                            if (lastIndexOf >= 0 && lastIndexOf < iMediaObject.imagePath.length() - 1) {
                                this.iHF = iMediaObject.imagePath.substring(lastIndexOf + 1);
                            }
                        }
                    }
                    x.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[]{iMediaObject.imagePath});
                case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    iMediaObject = new WXVideoObject();
                    com.tencent.mm.modelvideo.o.TU();
                    String nt = com.tencent.mm.modelvideo.s.nt(this.rZn.field_imgPath);
                    if (nt != null) {
                        iMediaObject.videoUrl = nt;
                        this.filePath = nt;
                        lastIndexOf = nt.lastIndexOf(".");
                        if (lastIndexOf >= 0 && lastIndexOf < nt.length() - 1) {
                            this.iHF = nt.substring(lastIndexOf + 1);
                        }
                    }
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    ar.Hg();
                    au.b EL = com.tencent.mm.z.c.Fa().EL(this.rZn.field_content);
                    iMediaObject = new WXLocationObject(EL.nQx, EL.nQy);
                case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                    if (this.fEt != null) {
                        if (this.fEt.type == 3) {
                            iMediaObject = new WXMusicObject();
                            iMediaObject.musicUrl = this.fEt.url;
                            iMediaObject.musicDataUrl = this.fEt.hbs;
                            iMediaObject.musicLowBandUrl = this.fEt.hba;
                            iMediaObject.musicLowBandDataUrl = this.fEt.hbt;
                        } else if (this.fEt.type == 4) {
                            iMediaObject = new WXVideoObject();
                            iMediaObject.videoUrl = this.fEt.url;
                            iMediaObject.videoLowBandUrl = this.fEt.hbt;
                        } else if (this.fEt.type == 5) {
                            iMediaObject = new WXWebpageObject(this.fEt.url);
                        } else if (this.fEt.type == 6) {
                            com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(this.fEt.fny);
                            if (Rz != null) {
                                x.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[]{Rz.field_fileFullPath});
                                iMediaObject = new WXFileObject(Rz.field_fileFullPath);
                                this.filePath = Rz.field_fileFullPath;
                                this.iHF = this.fEt.hbc;
                            } else {
                                x.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
                            }
                            if (q.RM(this.filePath) != null) {
                                h.bu(this, getString(R.l.dSP));
                                finish();
                                break;
                            }
                        } else if (this.fEt.type == 2) {
                            iMediaObject = new WXImageObject();
                            n = o.Pw().n(this.rZn);
                            if (n != null) {
                                iMediaObject.imagePath = o.Pw().lm(n.hzQ);
                                if (bh.ov(iMediaObject.imagePath)) {
                                    iMediaObject.imagePath = o.Pw().lm(n.hzS);
                                }
                            }
                            this.filePath = iMediaObject.imagePath;
                            this.iHF = this.fEt.hbc;
                            x.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[]{iMediaObject.imagePath});
                        }
                    }
            }
            this.yuW = new WXMediaMessage(iMediaObject);
            this.yuW.sdkVer = 620823552;
            if (!(this.iHF == null || this.filePath == null || iMediaObject == null || !(iMediaObject instanceof WXFileObject))) {
                this.yqc = true;
            }
        }
        this.yuB.yqc = this.yqc;
        this.yuB.aD(arrayList);
        this.yuB.notifyDataSetChanged();
    }

    private void crZ() {
        b dfVar = new df();
        if (this.fsG) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            dfVar.frF.frH = this.lLW;
            dfVar.frF.frI = string;
            dfVar.frF.frJ = i;
        } else {
            dfVar.frF.fqm = this.gAc;
        }
        com.tencent.mm.sdk.b.a.xef.m(dfVar);
        if (dfVar.frG.frp) {
            List list = dfVar.frG.frK;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = new c(this);
                cVar.frg = (String) ((Map) list.get(i2)).get("deviceType");
                cVar.deviceID = (String) ((Map) list.get(i2)).get("deviceID");
                cVar.gBL = (String) ((Map) list.get(i2)).get("displayName");
                cVar.iconUrl = (String) ((Map) list.get(i2)).get("iconUrl");
                cVar.fsF = (String) ((Map) list.get(i2)).get("ability");
                cVar.yvl = (String) ((Map) list.get(i2)).get("abilityInf");
                if (this.fsG && a(cVar, this.lLW)) {
                    this.yuK.add(cVar);
                } else if (!this.fsG && a(cVar, this.gAc)) {
                    this.yuK.add(cVar);
                }
            }
            if (this.yuK.size() > 0) {
                x.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
                this.yuC.aD(this.yuK);
                if (this.yuC.getCount() > 0) {
                    this.yuH.setText(R.l.dQA);
                    this.yuN = false;
                }
                this.yuC.notifyDataSetChanged();
            }
        }
    }

    private static boolean a(String str, c cVar) {
        String str2 = cVar.fsF;
        String str3 = cVar.yvl;
        String host = Uri.parse(str).getHost();
        if (str3 == null || str3.length() <= 0 || str2 == null || !str2.contains("wxmsg_url")) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONObject(str3).getJSONArray("wxmsg_url");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (jSONArray.getString(i).equals(host)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", e, str3, new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(c cVar, String str) {
        boolean z = true;
        if (str == null) {
            return false;
        }
        b htVar = new ht();
        htVar.fyb.frH = str;
        com.tencent.mm.sdk.b.a.xef.m(htVar);
        bnp com_tencent_mm_protocal_c_bnp = htVar.fyc.fyd;
        int i = com_tencent_mm_protocal_c_bnp.wQo.vYc;
        x.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[]{Integer.valueOf(i)});
        String str2 = cVar.fsF;
        if (str2 == null) {
            x.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
            return false;
        }
        if (i != 1) {
            if (i != 4) {
                if (i == 15) {
                    if (str2.contains("wxmsg_video")) {
                    }
                    z = false;
                } else {
                    if (i == 3) {
                        z = a(com_tencent_mm_protocal_c_bnp.wQo.nfX, cVar);
                    }
                    z = false;
                }
            }
        }
        return z;
    }

    public void onBackPressed() {
        if (this.yuS.size() > 0) {
            i$a com_tencent_mm_ui_base_i_a = new i$a(this);
            com_tencent_mm_ui_base_i_a.EA(R.l.dSS);
            com_tencent_mm_ui_base_i_a.EC(R.l.dSU).a(new 5(this));
            com_tencent_mm_ui_base_i_a.ED(R.l.dST).b(new 6(this));
            com_tencent_mm_ui_base_i_a.akx().show();
            return;
        }
        super.onBackPressed();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(c cVar, long j) {
        boolean z = true;
        if (j == -1) {
            return false;
        }
        String str = cVar.fsF;
        ar.Hg();
        cf dH = com.tencent.mm.z.c.Fa().dH(j);
        if (dH.field_msgId == 0 || str == null) {
            return false;
        }
        int type = dH.getType();
        String str2 = dH.field_content;
        if (dH.aNc()) {
            com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(str2);
            if (fT == null) {
                x.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
                return false;
            } else if (fT.type != 3) {
                if (fT.type == 4) {
                    z = false;
                } else if (fT.type != 6) {
                    if (fT.type == 5) {
                        z = a(fT.url, cVar);
                    } else {
                        if (fT.type == 2 && str.contains("wxmsg_image")) {
                        }
                        z = false;
                    }
                }
            }
        } else if (type == 3) {
            if (str.contains("wxmsg_image")) {
            }
            z = false;
        } else if (type == 48) {
            if (str.contains("wxmsg_poi")) {
            }
            z = false;
        } else {
            if (type == 62 && str.contains("wxmsg_video")) {
            }
            z = false;
        }
        return z;
    }

    protected void onResume() {
        super.onResume();
        crY();
        if (this.yuI.booleanValue()) {
            LayoutParams layoutParams = (LayoutParams) this.vrK.getLayoutParams();
            int i = layoutParams.height;
            float eu = com.tencent.mm.bv.a.eu(this);
            if (eu == 1.125f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(R.f.bvz);
            } else if (eu == 1.375f || eu == 1.25f || eu == 1.625f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(R.f.bvJ);
            }
            this.vrK.setLayoutParams(layoutParams);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.l.dZc, R.l.dZd, 1);
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
        this.yuP = false;
        if (this.yuI.booleanValue()) {
            if (!this.yuO) {
                pg(2);
            }
            com.tencent.mm.sdk.b.a.xef.c(this.yuX);
            com.tencent.mm.sdk.b.a.xef.c(this.yuY);
            b enVar = new en();
            com.tencent.mm.sdk.b.a.xef.m(enVar);
            if (enVar.fte.fsH) {
                x.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
            }
        }
        com.tencent.mm.sdk.platformtools.a.dd(getWindow().getDecorView());
        com.tencent.mm.sdk.platformtools.a.eF(this);
    }

    public final b csa() {
        if (this.yuJ == null) {
            this.yuJ = new b(this);
        }
        return this.yuJ;
    }
}
