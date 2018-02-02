package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dr extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fZO = "desc".hashCode();
    private static final int gji = "tips".hashCode();
    private static final int gsA = "bankPhone".hashCode();
    private static final int gsB = "bizUsername".hashCode();
    private static final int gsC = "onceQuotaKind".hashCode();
    private static final int gsD = "onceQuotaVirtual".hashCode();
    private static final int gsE = "dayQuotaKind".hashCode();
    private static final int gsF = "dayQuotaVirtual".hashCode();
    private static final int gsG = "fetchArriveTime".hashCode();
    private static final int gsH = "fetchArriveTimeWording".hashCode();
    private static final int gsI = "repay_url".hashCode();
    private static final int gsJ = "wxcreditState".hashCode();
    private static final int gsK = "bankcardClientType".hashCode();
    private static final int gsL = "ext_msg".hashCode();
    private static final int gsM = "support_micropay".hashCode();
    private static final int gsN = "arrive_type".hashCode();
    private static final int gsO = "avail_save_wording".hashCode();
    private static final int gsP = "fetch_charge_rate".hashCode();
    private static final int gsQ = "full_fetch_charge_fee".hashCode();
    private static final int gsR = "fetch_charge_info".hashCode();
    private static final int gsS = "forbid_title".hashCode();
    private static final int gsT = "forbid_url".hashCode();
    private static final int gsU = "no_micro_word".hashCode();
    private static final int gsV = "card_bottom_wording".hashCode();
    private static final int gsW = "support_lqt_turn_in".hashCode();
    private static final int gsX = "support_lqt_turn_out".hashCode();
    private static final int gsY = "is_hightlight_pre_arrive_time_wording".hashCode();
    private static final int gso = "bindSerial".hashCode();
    private static final int gsp = "cardType".hashCode();
    private static final int gsq = "bankcardState".hashCode();
    private static final int gsr = "forbidWord".hashCode();
    private static final int gss = "bankName".hashCode();
    private static final int gst = "bankcardType".hashCode();
    private static final int gsu = "bankcardTypeName".hashCode();
    private static final int gsv = "bankcardTag".hashCode();
    private static final int gsw = "bankcardTail".hashCode();
    private static final int gsx = "supportTag".hashCode();
    private static final int gsy = "mobile".hashCode();
    private static final int gsz = "trueName".hashCode();
    private boolean fZK = true;
    public String field_arrive_type;
    public String field_avail_save_wording;
    public String field_bankName;
    public String field_bankPhone;
    public int field_bankcardClientType;
    public int field_bankcardState;
    public int field_bankcardTag;
    public String field_bankcardTail;
    public String field_bankcardType;
    public String field_bankcardTypeName;
    public String field_bindSerial;
    public String field_bizUsername;
    public int field_cardType;
    public String field_card_bottom_wording;
    public double field_dayQuotaKind;
    public double field_dayQuotaVirtual;
    public String field_desc;
    public String field_ext_msg;
    public long field_fetchArriveTime;
    public String field_fetchArriveTimeWording;
    public String field_fetch_charge_info;
    public double field_fetch_charge_rate;
    public String field_forbidWord;
    public String field_forbid_title;
    public String field_forbid_url;
    public double field_full_fetch_charge_fee;
    public int field_is_hightlight_pre_arrive_time_wording;
    public String field_mobile;
    public String field_no_micro_word;
    public double field_onceQuotaKind;
    public double field_onceQuotaVirtual;
    public String field_repay_url;
    public int field_supportTag;
    public int field_support_lqt_turn_in;
    public int field_support_lqt_turn_out;
    public boolean field_support_micropay;
    public String field_tips;
    public String field_trueName;
    public int field_wxcreditState;
    private boolean gjc = true;
    private boolean grD = true;
    private boolean grE = true;
    private boolean grF = true;
    private boolean grG = true;
    private boolean grH = true;
    private boolean grI = true;
    private boolean grJ = true;
    private boolean grK = true;
    private boolean grL = true;
    private boolean grM = true;
    private boolean grN = true;
    private boolean grO = true;
    private boolean grP = true;
    private boolean grQ = true;
    private boolean grR = true;
    private boolean grS = true;
    private boolean grT = true;
    private boolean grU = true;
    private boolean grV = true;
    private boolean grW = true;
    private boolean grX = true;
    private boolean grY = true;
    private boolean grZ = true;
    private boolean gsa = true;
    private boolean gsb = true;
    private boolean gsc = true;
    private boolean gsd = true;
    private boolean gse = true;
    private boolean gsf = true;
    private boolean gsg = true;
    private boolean gsh = true;
    private boolean gsi = true;
    private boolean gsj = true;
    private boolean gsk = true;
    private boolean gsl = true;
    private boolean gsm = true;
    private boolean gsn = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gso == hashCode) {
                    this.field_bindSerial = cursor.getString(i);
                    this.grD = true;
                } else if (gsp == hashCode) {
                    this.field_cardType = cursor.getInt(i);
                } else if (gsq == hashCode) {
                    this.field_bankcardState = cursor.getInt(i);
                } else if (gsr == hashCode) {
                    this.field_forbidWord = cursor.getString(i);
                } else if (gss == hashCode) {
                    this.field_bankName = cursor.getString(i);
                } else if (gst == hashCode) {
                    this.field_bankcardType = cursor.getString(i);
                } else if (gsu == hashCode) {
                    this.field_bankcardTypeName = cursor.getString(i);
                } else if (gsv == hashCode) {
                    this.field_bankcardTag = cursor.getInt(i);
                } else if (gsw == hashCode) {
                    this.field_bankcardTail = cursor.getString(i);
                } else if (gsx == hashCode) {
                    this.field_supportTag = cursor.getInt(i);
                } else if (gsy == hashCode) {
                    this.field_mobile = cursor.getString(i);
                } else if (gsz == hashCode) {
                    this.field_trueName = cursor.getString(i);
                } else if (fZO == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (gsA == hashCode) {
                    this.field_bankPhone = cursor.getString(i);
                } else if (gsB == hashCode) {
                    this.field_bizUsername = cursor.getString(i);
                } else if (gsC == hashCode) {
                    this.field_onceQuotaKind = cursor.getDouble(i);
                } else if (gsD == hashCode) {
                    this.field_onceQuotaVirtual = cursor.getDouble(i);
                } else if (gsE == hashCode) {
                    this.field_dayQuotaKind = cursor.getDouble(i);
                } else if (gsF == hashCode) {
                    this.field_dayQuotaVirtual = cursor.getDouble(i);
                } else if (gsG == hashCode) {
                    this.field_fetchArriveTime = cursor.getLong(i);
                } else if (gsH == hashCode) {
                    this.field_fetchArriveTimeWording = cursor.getString(i);
                } else if (gsI == hashCode) {
                    this.field_repay_url = cursor.getString(i);
                } else if (gsJ == hashCode) {
                    this.field_wxcreditState = cursor.getInt(i);
                } else if (gsK == hashCode) {
                    this.field_bankcardClientType = cursor.getInt(i);
                } else if (gsL == hashCode) {
                    this.field_ext_msg = cursor.getString(i);
                } else if (gsM == hashCode) {
                    this.field_support_micropay = cursor.getInt(i) != 0;
                } else if (gsN == hashCode) {
                    this.field_arrive_type = cursor.getString(i);
                } else if (gsO == hashCode) {
                    this.field_avail_save_wording = cursor.getString(i);
                } else if (gsP == hashCode) {
                    this.field_fetch_charge_rate = cursor.getDouble(i);
                } else if (gsQ == hashCode) {
                    this.field_full_fetch_charge_fee = cursor.getDouble(i);
                } else if (gsR == hashCode) {
                    this.field_fetch_charge_info = cursor.getString(i);
                } else if (gji == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (gsS == hashCode) {
                    this.field_forbid_title = cursor.getString(i);
                } else if (gsT == hashCode) {
                    this.field_forbid_url = cursor.getString(i);
                } else if (gsU == hashCode) {
                    this.field_no_micro_word = cursor.getString(i);
                } else if (gsV == hashCode) {
                    this.field_card_bottom_wording = cursor.getString(i);
                } else if (gsW == hashCode) {
                    this.field_support_lqt_turn_in = cursor.getInt(i);
                } else if (gsX == hashCode) {
                    this.field_support_lqt_turn_out = cursor.getInt(i);
                } else if (gsY == hashCode) {
                    this.field_is_hightlight_pre_arrive_time_wording = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.grD) {
            contentValues.put("bindSerial", this.field_bindSerial);
        }
        if (this.grE) {
            contentValues.put("cardType", Integer.valueOf(this.field_cardType));
        }
        if (this.grF) {
            contentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
        }
        if (this.grG) {
            contentValues.put("forbidWord", this.field_forbidWord);
        }
        if (this.grH) {
            contentValues.put("bankName", this.field_bankName);
        }
        if (this.grI) {
            contentValues.put("bankcardType", this.field_bankcardType);
        }
        if (this.grJ) {
            contentValues.put("bankcardTypeName", this.field_bankcardTypeName);
        }
        if (this.grK) {
            contentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
        }
        if (this.grL) {
            contentValues.put("bankcardTail", this.field_bankcardTail);
        }
        if (this.grM) {
            contentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
        }
        if (this.grN) {
            contentValues.put("mobile", this.field_mobile);
        }
        if (this.grO) {
            contentValues.put("trueName", this.field_trueName);
        }
        if (this.fZK) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.grP) {
            contentValues.put("bankPhone", this.field_bankPhone);
        }
        if (this.grQ) {
            contentValues.put("bizUsername", this.field_bizUsername);
        }
        if (this.grR) {
            contentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
        }
        if (this.grS) {
            contentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
        }
        if (this.grT) {
            contentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
        }
        if (this.grU) {
            contentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
        }
        if (this.grV) {
            contentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
        }
        if (this.grW) {
            contentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
        }
        if (this.grX) {
            contentValues.put("repay_url", this.field_repay_url);
        }
        if (this.grY) {
            contentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
        }
        if (this.grZ) {
            contentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
        }
        if (this.gsa) {
            contentValues.put("ext_msg", this.field_ext_msg);
        }
        if (this.gsb) {
            contentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
        }
        if (this.gsc) {
            contentValues.put("arrive_type", this.field_arrive_type);
        }
        if (this.gsd) {
            contentValues.put("avail_save_wording", this.field_avail_save_wording);
        }
        if (this.gse) {
            contentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
        }
        if (this.gsf) {
            contentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
        }
        if (this.gsg) {
            contentValues.put("fetch_charge_info", this.field_fetch_charge_info);
        }
        if (this.gjc) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.gsh) {
            contentValues.put("forbid_title", this.field_forbid_title);
        }
        if (this.gsi) {
            contentValues.put("forbid_url", this.field_forbid_url);
        }
        if (this.gsj) {
            contentValues.put("no_micro_word", this.field_no_micro_word);
        }
        if (this.gsk) {
            contentValues.put("card_bottom_wording", this.field_card_bottom_wording);
        }
        if (this.gsl) {
            contentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
        }
        if (this.gsm) {
            contentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
        }
        if (this.gsn) {
            contentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
