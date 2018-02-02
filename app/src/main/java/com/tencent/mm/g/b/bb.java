package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class bb extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fOb = "sourceType".hashCode();
    private static final int fPr = "updateTime".hashCode();
    private static final int fRe = "xml".hashCode();
    private static final int fRk = "flag".hashCode();
    private static final int fXI = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int gbA = "updateSeq".hashCode();
    private static final int gbB = "sourceId".hashCode();
    private static final int gbC = "itemStatus".hashCode();
    private static final int gbD = "sourceCreateTime".hashCode();
    private static final int gbE = "fromUser".hashCode();
    private static final int gbF = "toUser".hashCode();
    private static final int gbG = "realChatName".hashCode();
    private static final int gbH = "favProto".hashCode();
    private static final int gbI = "ext".hashCode();
    private static final int gbJ = "edittime".hashCode();
    private static final int gbK = "tagProto".hashCode();
    private static final int gbL = "sessionId".hashCode();
    private static final int gbM = "datatotalsize".hashCode();
    private static final int gbj = "localId".hashCode();
    private static final int gbz = "localSeq".hashCode();
    private boolean fNE = true;
    private boolean fNF = true;
    private boolean fPn = true;
    private boolean fRa = true;
    private boolean fRi = true;
    private boolean fXF = true;
    public long field_datatotalsize;
    public long field_edittime;
    public String field_ext;
    public ve field_favProto;
    public int field_flag;
    public String field_fromUser;
    public int field_id;
    public int field_itemStatus;
    public long field_localId;
    public int field_localSeq;
    public String field_realChatName;
    public String field_sessionId;
    public long field_sourceCreateTime;
    public String field_sourceId;
    public int field_sourceType;
    public vr field_tagProto;
    public String field_toUser;
    public int field_type;
    public int field_updateSeq;
    public long field_updateTime;
    public String field_xml;
    private boolean gbh = true;
    private boolean gbl = true;
    private boolean gbm = true;
    private boolean gbn = true;
    private boolean gbo = true;
    private boolean gbp = true;
    private boolean gbq = true;
    private boolean gbr = true;
    private boolean gbs = true;
    private boolean gbt = true;
    private boolean gbu = true;
    private boolean gbv = true;
    private boolean gbw = true;
    private boolean gbx = true;
    private boolean gby = true;

    public static a vJ() {
        a aVar = new a();
        aVar.hSY = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xjA.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "localId";
        aVar.columns[1] = SlookAirButtonFrequentContactAdapter.ID;
        aVar.xjA.put(SlookAirButtonFrequentContactAdapter.ID, "INTEGER");
        stringBuilder.append(" id INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "localSeq";
        aVar.xjA.put("localSeq", "INTEGER");
        stringBuilder.append(" localSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "updateSeq";
        aVar.xjA.put("updateSeq", "INTEGER");
        stringBuilder.append(" updateSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "flag";
        aVar.xjA.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "sourceId";
        aVar.xjA.put("sourceId", "TEXT");
        stringBuilder.append(" sourceId TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "itemStatus";
        aVar.xjA.put("itemStatus", "INTEGER");
        stringBuilder.append(" itemStatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "sourceType";
        aVar.xjA.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "sourceCreateTime";
        aVar.xjA.put("sourceCreateTime", "LONG");
        stringBuilder.append(" sourceCreateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "updateTime";
        aVar.xjA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "fromUser";
        aVar.xjA.put("fromUser", "TEXT");
        stringBuilder.append(" fromUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "toUser";
        aVar.xjA.put("toUser", "TEXT");
        stringBuilder.append(" toUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "realChatName";
        aVar.xjA.put("realChatName", "TEXT");
        stringBuilder.append(" realChatName TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "favProto";
        aVar.xjA.put("favProto", "BLOB");
        stringBuilder.append(" favProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = "xml";
        aVar.xjA.put("xml", "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "ext";
        aVar.xjA.put("ext", "TEXT");
        stringBuilder.append(" ext TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "edittime";
        aVar.xjA.put("edittime", "LONG");
        stringBuilder.append(" edittime LONG");
        stringBuilder.append(", ");
        aVar.columns[18] = "tagProto";
        aVar.xjA.put("tagProto", "BLOB");
        stringBuilder.append(" tagProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[19] = "sessionId";
        aVar.xjA.put("sessionId", "TEXT");
        stringBuilder.append(" sessionId TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "datatotalsize";
        aVar.xjA.put("datatotalsize", "LONG");
        stringBuilder.append(" datatotalsize LONG");
        aVar.columns[21] = "rowid";
        aVar.xjB = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbj == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.gbh = true;
                } else if (fXI == hashCode) {
                    this.field_id = cursor.getInt(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gbz == hashCode) {
                    this.field_localSeq = cursor.getInt(i);
                } else if (gbA == hashCode) {
                    this.field_updateSeq = cursor.getInt(i);
                } else if (fRk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (gbB == hashCode) {
                    this.field_sourceId = cursor.getString(i);
                } else if (gbC == hashCode) {
                    this.field_itemStatus = cursor.getInt(i);
                } else if (fOb == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (gbD == hashCode) {
                    this.field_sourceCreateTime = cursor.getLong(i);
                } else if (fPr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gbE == hashCode) {
                    this.field_fromUser = cursor.getString(i);
                } else if (gbF == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (gbG == hashCode) {
                    this.field_realChatName = cursor.getString(i);
                } else if (gbH == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_favProto = (ve) new ve().aF(r0);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
                    }
                } else if (fRe == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (gbI == hashCode) {
                    this.field_ext = cursor.getString(i);
                } else if (gbJ == hashCode) {
                    this.field_edittime = cursor.getLong(i);
                } else if (gbK == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_tagProto = (vr) new vr().aF(r0);
                        }
                    } catch (IOException e2) {
                        x.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
                    }
                } else if (gbL == hashCode) {
                    this.field_sessionId = cursor.getString(i);
                } else if (gbM == hashCode) {
                    this.field_datatotalsize = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gbh) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.fXF) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.field_id));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gbl) {
            contentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
        }
        if (this.gbm) {
            contentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
        }
        if (this.fRi) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.gbn) {
            contentValues.put("sourceId", this.field_sourceId);
        }
        if (this.gbo) {
            contentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
        }
        if (this.fNF) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.gbp) {
            contentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
        }
        if (this.fPn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gbq) {
            contentValues.put("fromUser", this.field_fromUser);
        }
        if (this.gbr) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.gbs) {
            contentValues.put("realChatName", this.field_realChatName);
        }
        if (this.gbt && this.field_favProto != null) {
            try {
                contentValues.put("favProto", this.field_favProto.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
            }
        }
        if (this.fRa) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.gbu) {
            contentValues.put("ext", this.field_ext);
        }
        if (this.gbv) {
            contentValues.put("edittime", Long.valueOf(this.field_edittime));
        }
        if (this.gbw && this.field_tagProto != null) {
            try {
                contentValues.put("tagProto", this.field_tagProto.toByteArray());
            } catch (IOException e2) {
                x.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
            }
        }
        if (this.gbx) {
            contentValues.put("sessionId", this.field_sessionId);
        }
        if (this.gby) {
            contentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
