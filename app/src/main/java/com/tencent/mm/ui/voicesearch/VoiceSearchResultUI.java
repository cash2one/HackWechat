package com.tencent.mm.ui.voicesearch;

import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VoiceSearchResultUI extends MMActivity {
    private int hJq = 2;
    private TextView lgL;
    private int mbO = -1;
    int showType = 1;
    private b zqH;
    private String[] zqI;
    private boolean zqJ = false;
    boolean zqK = false;
    private ListView zqu;
    private String zqw = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.zqJ = false;
    }

    protected final void initView() {
        this.zqu = (ListView) findViewById(R.h.cWX);
        this.lgL = (TextView) findViewById(R.h.cex);
        this.zqI = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
        this.zqw = getIntent().getStringExtra("VoiceSearchResultUI_Error");
        this.mbO = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
        this.showType = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
        this.hJq = this.showType == 1 ? 2 : 1;
        this.zqK = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
        x.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", new Object[]{Integer.valueOf(this.showType), Boolean.valueOf(this.zqK)});
        this.zqH = new b(getApplicationContext(), this.showType);
        this.zqH.nz(false);
        List linkedList = new LinkedList();
        switch (this.showType) {
            case 2:
                linkedList.add("lbsapp");
                linkedList.add("shakeapp");
                linkedList.add("qqfriend");
                linkedList.add("facebookapp");
                linkedList.add("feedsapp");
                linkedList.add("fmessage");
                linkedList.add("voipapp");
                linkedList.add("voicevoipapp");
                linkedList.add("voiceinputapp");
                linkedList.add("linkedinplugin");
                linkedList.add("notifymessage");
                int Gd = q.Gd();
                if ((Gd & 1) != 0) {
                    linkedList.add("qqmail");
                }
                if (!(s.GG() && (Gd & 2) == 0)) {
                    linkedList.add("tmessage");
                }
                if ((Gd & 32) != 0) {
                    linkedList.add("qmessage");
                }
                if ((Gd & FileUtils.S_IWUSR) != 0) {
                    linkedList.add("qqsync");
                }
                if ((Gd & 16) != 0) {
                    linkedList.add("medianote");
                }
                if ((SQLiteGlobal.journalSizeLimit & Gd) != 0) {
                    linkedList.add("newsapp");
                }
                if (!((262144 & Gd) == 0 && s.GF())) {
                    linkedList.add("blogapp");
                }
                if ((65536 & Gd) != 0) {
                    linkedList.add("masssendapp");
                }
                if ((Gd & 33554432) != 0) {
                    linkedList.add("voiceinputapp");
                    break;
                }
                break;
        }
        if (this.zqH != null) {
            this.zqH.dr(linkedList);
        }
        this.zqu.setAdapter(this.zqH);
        this.lgL.setVisibility(8);
        x.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.mbO);
        if (this.showType == 2) {
            setMMTitle("");
            this.zqI = K(this.zqI);
        } else {
            setMMTitle(getString(R.l.dtH));
        }
        setMMTitle(getString(R.l.dtH));
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ VoiceSearchResultUI zqL;

            {
                this.zqL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!this.zqL.zqJ) {
                    g.pQN.k(10452, this.zqL.hJq + "," + this.zqL.mbO + "," + (this.zqL.zqI == null ? 0 : this.zqL.zqI.length) + ",0");
                }
                if (this.zqL.zqK) {
                    this.zqL.moveTaskToBack(true);
                }
                this.zqL.finish();
                return true;
            }
        });
        this.zqu.setOnItemClickListener(new 2(this));
        L(this.zqI);
    }

    private static String[] K(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        x.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + strArr.length);
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (String str : strArr) {
            String gu = r.gu(str);
            x.d("MicroMsg.VoiceSearchResultUI", "displayname " + gu);
            if (!hashMap.containsValue(gu) || !s.eV(str)) {
                x.d("MicroMsg.VoiceSearchResultUI", "username " + str);
                hashMap.put(gu, str);
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void onDestroy() {
        super.onDestroy();
        this.zqH.aUn();
    }

    public void onPause() {
        super.onPause();
        this.zqJ = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (!this.zqJ) {
                g.pQN.k(10452, this.hJq + "," + this.mbO + "," + (this.zqI == null ? 0 : this.zqI.length) + ",0");
            }
            if (this.zqK) {
                moveTaskToBack(true);
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    static boolean aaj(String str) {
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = ar.Hg().hez.a(s.hfk, null, str);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!string.endsWith("@chatroom")) {
                    arrayList2.add(string);
                }
                x.d("MicroMsg.VoiceSearchResultUI", "block user " + string);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceSearchResultUI", e, "", new Object[0]);
            }
        }
        cursorArr[1] = ar.Hg().heA.a(str, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        int count = cursorArr[1].getCount();
        int count2 = cursorArr[0].getCount();
        cursorArr[0].close();
        cursorArr[1].close();
        x.d("MicroMsg.VoiceSearchResultUI", "contactCount " + count + " conversationCount " + count2);
        if (count + count2 <= 1) {
            return true;
        }
        return false;
    }

    private void L(String[] strArr) {
        List arrayList = new ArrayList();
        if (!(strArr == null || this.zqH == null)) {
            for (String str : strArr) {
                if (this.zqH.aai(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.lgL.setVisibility(0);
            if (this.zqw != null) {
                this.lgL.setText(this.zqw);
            } else {
                this.lgL.setText(getString(R.l.dCU));
            }
        } else {
            this.lgL.setVisibility(8);
        }
        if (this.zqH != null) {
            this.zqH.dD(arrayList);
        }
    }

    protected final int getLayoutId() {
        return R.i.dtH;
    }
}
