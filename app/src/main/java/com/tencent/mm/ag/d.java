package com.tencent.mm.ag;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.b.y;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends y {
    protected static a gJc;
    public static int hom = 1;
    public static int hon = 0;
    public static int hoo = 1;
    private static int hor = 0;
    private static b hos = null;
    private List<a> hop;
    public b hoq;

    static {
        a aVar = new a();
        aVar.hSY = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xjA.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "username";
        aVar.columns[1] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "brandList";
        aVar.xjA.put("brandList", "TEXT default '' ");
        stringBuilder.append(" brandList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "brandListVersion";
        aVar.xjA.put("brandListVersion", "TEXT");
        stringBuilder.append(" brandListVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "brandListContent";
        aVar.xjA.put("brandListContent", "TEXT");
        stringBuilder.append(" brandListContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "brandFlag";
        aVar.xjA.put("brandFlag", "INTEGER");
        stringBuilder.append(" brandFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "extInfo";
        aVar.xjA.put("extInfo", "TEXT");
        stringBuilder.append(" extInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "brandInfo";
        aVar.xjA.put("brandInfo", "TEXT");
        stringBuilder.append(" brandInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "brandIconURL";
        aVar.xjA.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "updateTime";
        aVar.xjA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "hadAlert";
        aVar.xjA.put("hadAlert", "INTEGER");
        stringBuilder.append(" hadAlert INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "acceptType";
        aVar.xjA.put("acceptType", "INTEGER default '0' ");
        stringBuilder.append(" acceptType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "enterpriseFather";
        aVar.xjA.put("enterpriseFather", "TEXT");
        stringBuilder.append(" enterpriseFather TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "kfWorkerId";
        aVar.xjA.put("kfWorkerId", "TEXT");
        stringBuilder.append(" kfWorkerId TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "specialType";
        aVar.xjA.put("specialType", "INTEGER");
        stringBuilder.append(" specialType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "attrSyncVersion";
        aVar.xjA.put("attrSyncVersion", "TEXT");
        stringBuilder.append(" attrSyncVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "incrementUpdateTime";
        aVar.xjA.put("incrementUpdateTime", "LONG");
        stringBuilder.append(" incrementUpdateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[19] = "bitFlag";
        aVar.xjA.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        aVar.columns[20] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final b bI(boolean z) {
        if (this.hoq == null || z) {
            if (bh.ov(this.field_extInfo) || hor != this.field_extInfo.hashCode()) {
                b jC = b.jC(this.field_extInfo);
                this.hoq = jC;
                hos = jC;
                hor = bh.ou(this.field_extInfo).hashCode();
            } else {
                this.hoq = hos;
            }
        }
        return this.hoq;
    }

    public final boolean KW() {
        return (this.field_brandFlag & 1) == 0;
    }

    public final boolean KX() {
        return (this.field_brandFlag & 4) != 0;
    }

    public final boolean KY() {
        if (System.currentTimeMillis() - this.field_updateTime > 86400000) {
            return true;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        if (this.field_updateTime >= instance.getTimeInMillis()) {
            return false;
        }
        return true;
    }

    public final void KZ() {
        bI(false);
        b bVar = this.hoq;
        if (bVar.hou != null) {
            bVar.hoI = bVar.hou.optInt("ConnectorMsgType");
        }
        this.field_acceptType = bVar.hoI;
        this.field_type = bI(false).LC();
        if (Lg()) {
            hp(1);
        } else {
            this.field_bitFlag &= -2;
        }
    }

    public final boolean La() {
        bI(false);
        x.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[]{this.field_username, Boolean.valueOf(this.hoq.La())});
        return this.hoq.La();
    }

    public final boolean Lb() {
        bI(false);
        if (this.field_type == 1) {
            return true;
        }
        return false;
    }

    public final boolean Lc() {
        bI(false);
        if (this.field_type == 0) {
            return true;
        }
        return false;
    }

    public final boolean Ld() {
        bI(false);
        if (this.field_type == 2 || this.field_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean Le() {
        bI(false);
        if (this.field_type == 2) {
            return true;
        }
        return false;
    }

    public final boolean Lf() {
        bI(false);
        if (this.field_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean Lg() {
        bI(false);
        if (this.hoq == null || this.hoq.LG() == null) {
            return false;
        }
        boolean z = this.hoq.hoF.hph == 1;
        if (z && !ho(1)) {
            hp(1);
            y.Mf().e(this);
        }
        if (!z) {
            return z;
        }
        x.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", new Object[]{this.field_username});
        return z;
    }

    public final boolean Lh() {
        bI(false);
        if (this.hoq == null || this.hoq.LG() == null) {
            return false;
        }
        boolean z = this.hoq.hoF.hph == 2;
        if (z && !ho(2)) {
            hp(2);
            y.Mf().e(this);
        }
        if (!z) {
            return z;
        }
        x.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", new Object[]{this.field_username});
        return z;
    }

    public final String Li() {
        bI(false);
        if (this.hoq != null) {
            a LG = this.hoq.LG();
            if (!(LG == null || LG.hpi == null || LG.hpi.isEmpty())) {
                return LG.hpi;
            }
        }
        return null;
    }

    public final long Lj() {
        bI(false);
        if (this.hoq == null) {
            return 0;
        }
        a LG = this.hoq.LG();
        if (LG == null || LG.appid == 0) {
            return 0;
        }
        return LG.appid;
    }

    public final boolean Lk() {
        bI(false);
        if (this.hoq == null) {
            x.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
            return true;
        } else if (this.hoq.LA() == null) {
            x.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
            return true;
        } else if (this.hoq.LA().hpw) {
            return false;
        } else {
            return true;
        }
    }

    public final String Ll() {
        bI(false);
        if (this.hoq != null) {
            a LG = this.hoq.LG();
            if (LG != null) {
                return LG.hpj;
            }
        }
        return null;
    }

    public final String Lm() {
        String str = bI(false).LG().hpf;
        if (bh.ov(str)) {
            x.e("MicroMsg.BizInfo", "check father: %s, %s", new Object[]{this.field_username, str});
        }
        return str;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }

    public final ContentValues vI() {
        return super.vI();
    }

    public final List<a> Ln() {
        if (this.hop != null) {
            return this.hop;
        }
        this.hop = new LinkedList();
        if (this.field_brandInfo == null || this.field_brandInfo.length() == 0) {
            return this.hop;
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.field_brandInfo).optJSONArray("urls");
            for (int i = 0; i < optJSONArray.length(); i++) {
                a aVar = new a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                aVar.title = optJSONObject.optString("title");
                aVar.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                aVar.hot = optJSONObject.optString("title_key");
                aVar.description = optJSONObject.optString("description");
                this.hop.add(aVar);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bh.i(e)});
        }
        return this.hop;
    }

    private boolean ho(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    private void hp(int i) {
        this.field_bitFlag |= i;
    }
}
