package com.tencent.mm.h;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    public a gAZ;
    public Map<Integer, Long> gBa = new HashMap();
    public Map<Long, a> gBb = new HashMap();
    public c gBc = new 1(this);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean a(ah ahVar) {
        String str = ahVar.foi.fok;
        String str2 = "MicroMsg.BroadcastController";
        String str3 = "summerdiz handleNewDisaster xml len[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(str == null ? -1 : str.length());
        x.i(str2, str3, objArr);
        Map y = bi.y(str, "e");
        if (y == null) {
            x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
            return false;
        }
        x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", new Object[]{y});
        long j = bh.getLong((String) y.get(".e.NoticeId"), 0);
        if (j <= 0) {
            x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
        }
        if (!r.iet) {
            try {
                if (bh.by(bh.getLong((String) y.get(".e.ExpiredTime"), 0)) > 0) {
                    x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", new Object[]{Long.valueOf(bh.getLong((String) y.get(".e.ExpiredTime"), 0))});
                    return false;
                }
            } catch (Exception e) {
                x.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[]{e});
            }
        }
        a aVar = new a();
        aVar.gBg = String.valueOf(j);
        String string = ac.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", "");
        if (r.ieu || !string.contains(aVar.gBg)) {
            a aVar2;
            if (this.gBb.size() > 0) {
                a aVar3 = (a) this.gBb.get(Long.valueOf(j));
                if (aVar3 != null) {
                    x.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", new Object[]{aVar3});
                    aVar2 = aVar3;
                } else {
                    this.gBb.put(Long.valueOf(j), aVar);
                    aVar2 = aVar;
                }
            } else {
                this.gBb.put(Long.valueOf(j), aVar);
                aVar2 = aVar;
            }
            string = (String) y.get(".e.Position");
            if (bh.ov(string)) {
                x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
                return false;
            }
            ArrayList arrayList = new ArrayList();
            String[] split = string.split(",");
            if (split == null || split.length <= 0) {
                x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
                return false;
            }
            Object obj = null;
            int length = split.length;
            int i = 0;
            while (i < length) {
                Object obj2;
                int i2 = bh.getInt(split[i], 0);
                if (i2 > 0) {
                    if (i2 == 1) {
                        obj2 = 1;
                        x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", new Object[]{Integer.valueOf(i2)});
                        i++;
                        obj = obj2;
                    } else {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
            if (obj == null && arrayList.size() == 0) {
                x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
                return false;
            }
            Iterator it;
            Integer num;
            Long valueOf;
            rs rsVar;
            rs rsVar2;
            x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", new Object[]{w.eL(ac.getContext())});
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int i3 = 0;
            while (true) {
                str2 = ".e.Item" + (i3 == 0 ? "" : Integer.valueOf(i3));
                string = (String) y.get(str2 + ".Language");
                if (string == null && i3 > 3) {
                    break;
                } else if (r18.equalsIgnoreCase(string)) {
                    break;
                } else {
                    if ("en".equalsIgnoreCase(string)) {
                        string = (String) y.get(str2 + ".Content");
                        str = (String) y.get(str2 + ".Url");
                        str2 = (String) y.get(str2 + ".Tips");
                    } else {
                        str2 = str6;
                        str = str5;
                        string = str4;
                    }
                    str5 = str;
                    str4 = string;
                    i3++;
                    str6 = str2;
                }
                x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", new Object[]{string, str2});
                if (bh.ov(string)) {
                    str5 = str;
                    str4 = string;
                    str6 = str2;
                } else {
                    x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
                }
                if (bh.ov(str5)) {
                    str5 = ac.getContext().getString(R.l.dYQ);
                }
                if (obj != null) {
                    if (bh.ov(str4)) {
                        str4 = ac.getContext().getString(R.l.dYL);
                    }
                    if (bh.ov(str6)) {
                        str6 = ac.getContext().getString(R.l.dYO);
                    }
                    ahVar.foj.desc = str4;
                    ahVar.foj.fol = 30;
                    ahVar.foj.showType = 0;
                    ahVar.foj.url = str5;
                    ahVar.foj.visible = true;
                    ahVar.foj.foo = 0;
                    ahVar.foj.fom = 6;
                    ahVar.foj.fon = "";
                    ahVar.foj.fop = String.valueOf(j);
                    ahVar.foj.position = 1;
                }
                if (arrayList.size() != 0) {
                    x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
                    return false;
                } else if (aVar2.gBh != 0 || bh.bA(aVar2.gBh) >= 1800000) {
                    aVar2.gBh = bh.Wq();
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        num = (Integer) it.next();
                        valueOf = Long.valueOf(bh.a((Long) this.gBa.get(num), 0));
                        if (valueOf.longValue() > 0 || valueOf.longValue() < j) {
                            rsVar = (rs) aVar2.gBj.get(num);
                            if (rsVar != null) {
                                rsVar = new rs();
                                rsVar.fJx.showType = 0;
                                rsVar.fJx.fol = 30;
                                rsVar.fJx.fon = "";
                                rsVar.fJx.foo = R.i.doj;
                                rsVar.fJx.position = num.intValue();
                                aVar2.gBj.put(num, rsVar);
                                rsVar2 = rsVar;
                            } else {
                                rsVar2 = rsVar;
                            }
                            if (bh.ov(str6)) {
                                str = str6;
                            } else {
                                str = str4;
                            }
                            if (bh.ov(str)) {
                                i = R.l.dYN;
                                switch (num.intValue()) {
                                    case 2:
                                        i = R.l.dYP;
                                        break;
                                    case 3:
                                    case 4:
                                        i = R.l.dYM;
                                        break;
                                }
                                str = ac.getContext().getString(i);
                            }
                            rsVar2.fJx.desc = str;
                            rsVar2.fJx.url = str5;
                            rsVar2.fJx.visible = true;
                            rsVar2.fJx.fom = 2;
                            rsVar2.fJx.fop = aVar2.gBg;
                            this.gBa.put(num, Long.valueOf(j));
                            if (obj == null) {
                                ahVar.foj.desc = str;
                                ahVar.foj.fol = 30;
                                ahVar.foj.showType = 0;
                                ahVar.foj.url = str5;
                                ahVar.foj.visible = true;
                                ahVar.foj.foo = R.i.doj;
                                ahVar.foj.fom = 2;
                                ahVar.foj.fon = "";
                                ahVar.foj.fop = String.valueOf(j);
                                ahVar.foj.position = num.intValue();
                            }
                            ag.y(new Runnable(this) {
                                final /* synthetic */ b gBd;

                                public final void run() {
                                    a.xef.m(rsVar2);
                                }
                            });
                            str6 = str;
                        } else {
                            x.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[]{num, valueOf, Long.valueOf(j)});
                        }
                    }
                    return true;
                } else {
                    x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
                    return false;
                }
            }
            str = null;
            string = null;
            str2 = null;
            x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", new Object[]{string, str2});
            if (bh.ov(string)) {
                str5 = str;
                str4 = string;
                str6 = str2;
            } else {
                x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
            }
            if (bh.ov(str5)) {
                str5 = ac.getContext().getString(R.l.dYQ);
            }
            if (obj != null) {
                if (bh.ov(str4)) {
                    str4 = ac.getContext().getString(R.l.dYL);
                }
                if (bh.ov(str6)) {
                    str6 = ac.getContext().getString(R.l.dYO);
                }
                ahVar.foj.desc = str4;
                ahVar.foj.fol = 30;
                ahVar.foj.showType = 0;
                ahVar.foj.url = str5;
                ahVar.foj.visible = true;
                ahVar.foj.foo = 0;
                ahVar.foj.fom = 6;
                ahVar.foj.fon = "";
                ahVar.foj.fop = String.valueOf(j);
                ahVar.foj.position = 1;
            }
            if (arrayList.size() != 0) {
                if (aVar2.gBh != 0) {
                }
                aVar2.gBh = bh.Wq();
                it = arrayList.iterator();
                while (it.hasNext()) {
                    num = (Integer) it.next();
                    valueOf = Long.valueOf(bh.a((Long) this.gBa.get(num), 0));
                    if (valueOf.longValue() > 0) {
                    }
                    rsVar = (rs) aVar2.gBj.get(num);
                    if (rsVar != null) {
                        rsVar2 = rsVar;
                    } else {
                        rsVar = new rs();
                        rsVar.fJx.showType = 0;
                        rsVar.fJx.fol = 30;
                        rsVar.fJx.fon = "";
                        rsVar.fJx.foo = R.i.doj;
                        rsVar.fJx.position = num.intValue();
                        aVar2.gBj.put(num, rsVar);
                        rsVar2 = rsVar;
                    }
                    if (bh.ov(str6)) {
                        str = str6;
                    } else {
                        str = str4;
                    }
                    if (bh.ov(str)) {
                        i = R.l.dYN;
                        switch (num.intValue()) {
                            case 2:
                                i = R.l.dYP;
                                break;
                            case 3:
                            case 4:
                                i = R.l.dYM;
                                break;
                        }
                        str = ac.getContext().getString(i);
                    }
                    rsVar2.fJx.desc = str;
                    rsVar2.fJx.url = str5;
                    rsVar2.fJx.visible = true;
                    rsVar2.fJx.fom = 2;
                    rsVar2.fJx.fop = aVar2.gBg;
                    this.gBa.put(num, Long.valueOf(j));
                    if (obj == null) {
                        ahVar.foj.desc = str;
                        ahVar.foj.fol = 30;
                        ahVar.foj.showType = 0;
                        ahVar.foj.url = str5;
                        ahVar.foj.visible = true;
                        ahVar.foj.foo = R.i.doj;
                        ahVar.foj.fom = 2;
                        ahVar.foj.fon = "";
                        ahVar.foj.fop = String.valueOf(j);
                        ahVar.foj.position = num.intValue();
                    }
                    ag.y(/* anonymous class already generated */);
                    str6 = str;
                }
                return true;
            }
            x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
            return false;
        }
        x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[]{string, aVar.gBg});
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean eB(String str) {
        String str2 = null;
        x.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[]{this.gAZ, str});
        if (bh.ov(str) || str.indexOf("<") < 0) {
            return false;
        }
        Map y = bi.y(str, "e");
        if (y == null) {
            x.e("MicroMsg.BroadcastController", "this is not errmsg");
            return false;
        }
        if (this.gAZ == null) {
            this.gAZ = new a();
            rs rsVar = new rs();
            this.gAZ.gBj.put(Integer.valueOf(0), rsVar);
            rsVar.fJx.desc = "";
            rsVar.fJx.url = "";
            rsVar.fJx.showType = 0;
            rsVar.fJx.fol = 30;
            rsVar.fJx.visible = false;
            rsVar.fJx.fon = "";
            rsVar.fJx.fom = 0;
            rsVar.fJx.foo = R.i.doj;
            rsVar.fJx.fop = "";
            rsVar.fJx.position = 0;
        }
        if (!r.ies) {
            if (this.gAZ.gBh == 0 || bh.bA(this.gAZ.gBh) >= 1800000) {
                this.gAZ.gBh = bh.Wq();
            } else {
                x.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
                return false;
            }
        }
        if (!r.iet) {
            try {
                if (bh.by(bh.getLong((String) y.get(".e.ExpiredTime"), 0)) > 0) {
                    x.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", new Object[]{Long.valueOf(bh.getLong((String) y.get(".e.ExpiredTime"), 0))});
                    return false;
                }
            } catch (Exception e) {
                x.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[]{e});
            }
        }
        this.gAZ.gBg = (String) y.get(".e.NoticeId");
        String string = ac.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", "");
        if (r.ieu || !string.contains(this.gAZ.gBg)) {
            String str3;
            String eL = w.eL(ac.getContext());
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int i = 0;
            while (true) {
                str3 = ".e.Item" + (i == 0 ? "" : Integer.valueOf(i));
                string = (String) y.get(str3 + ".Language");
                if (string == null && i > 3) {
                    break;
                } else if (eL.equalsIgnoreCase(string)) {
                    break;
                } else {
                    String str7;
                    if ("en".equalsIgnoreCase(string)) {
                        string = (String) y.get(str3 + ".Content");
                        str7 = (String) y.get(str3 + ".Url");
                        str3 = (String) y.get(str3 + ".Tips");
                    } else {
                        str3 = str4;
                        str7 = str5;
                        string = str6;
                    }
                    str5 = str7;
                    str6 = string;
                    i++;
                    str4 = str3;
                }
                if (bh.ov(string)) {
                    str5 = str2;
                    str6 = string;
                    str4 = str3;
                } else {
                    x.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
                }
                if (bh.ov(str5)) {
                    str5 = ac.getContext().getString(R.l.dYQ);
                }
                if (bh.ov(str6)) {
                    x.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
                    str6 = ac.getContext().getString(R.l.dYK);
                }
                if (bh.ov(str4)) {
                    if (bh.ov(str6)) {
                        str4 = str6;
                    } else {
                        str4 = ac.getContext().getString(R.l.dYN);
                    }
                }
                rsVar = (rs) this.gAZ.gBj.get(Integer.valueOf(0));
                rsVar.fJx.desc = str4;
                rsVar.fJx.url = str5;
                rsVar.fJx.visible = true;
                rsVar.fJx.fom = 2;
                rsVar.fJx.fop = this.gAZ.gBg;
                ag.y(new 3(this, rsVar));
                this.gAZ.gBi = str6;
                if (ar.CG().foreground) {
                    xt();
                }
                return true;
            }
            string = null;
            str3 = null;
            if (bh.ov(string)) {
                str5 = str2;
                str6 = string;
                str4 = str3;
            } else {
                x.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
            }
            if (bh.ov(str5)) {
                str5 = ac.getContext().getString(R.l.dYQ);
            }
            if (bh.ov(str6)) {
                x.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
                str6 = ac.getContext().getString(R.l.dYK);
            }
            if (bh.ov(str4)) {
                if (bh.ov(str6)) {
                    str4 = str6;
                } else {
                    str4 = ac.getContext().getString(R.l.dYN);
                }
            }
            rsVar = (rs) this.gAZ.gBj.get(Integer.valueOf(0));
            rsVar.fJx.desc = str4;
            rsVar.fJx.url = str5;
            rsVar.fJx.visible = true;
            rsVar.fJx.fom = 2;
            rsVar.fJx.fop = this.gAZ.gBg;
            ag.y(new 3(this, rsVar));
            this.gAZ.gBi = str6;
            if (ar.CG().foreground) {
                xt();
            }
            return true;
        }
        x.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[]{string, this.gAZ.gBg});
        return false;
    }

    final void xt() {
        if (this.gAZ != null && this.gAZ.gBj.get(Integer.valueOf(0)) != null && !bh.ov(this.gAZ.gBi)) {
            x.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[]{this.gAZ.gBi});
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", this.gAZ.gBi);
            intent.putExtra("key_disaster_url", ((rs) this.gAZ.gBj.get(Integer.valueOf(0))).fJx.url);
            intent.setClass(ac.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ac.getContext().startActivity(intent);
            this.gAZ.gBi = null;
        }
    }
}
