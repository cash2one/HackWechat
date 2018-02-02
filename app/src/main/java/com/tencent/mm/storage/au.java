package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.c.f;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.o;
import java.util.Map;
import junit.framework.Assert;

public final class au extends o {
    public static String xzc = "voip_content_voice";
    public static String xzd = "voip_content_video";
    public boolean xze = false;
    private String xzf;

    public static final class a {
        private String bhd = "";
        public int fWf;
        private String fWp;
        private String fWq;
        public String fWu = "";
        private String fWv = "";
        public String fpL = "";
        public String gfN = "";
        public String hwU = "";
        public String hwV = "";
        public String hwW = "";
        public String hwZ = "";
        public String phJ = "";
        public long pjS = 0;
        public String pjU = "";
        public String rYX = "";
        public int scene = 0;
        public String signature;
        public int tmE = 0;
        public String vtc = "";
        public int xzi = 0;
        public String xzj = "";
        public String xzk = "";
        public String xzl = "";
        public String xzm = "";

        private a() {
        }

        public static a Xr(String str) {
            a aVar = new a();
            String trim = bh.az(str, "").trim();
            if (!trim.startsWith("<")) {
                int indexOf = trim.indexOf(":");
                if (indexOf != -1) {
                    trim = trim.substring(indexOf + 1);
                }
            }
            Map y = bi.y(trim, "msg");
            if (y != null) {
                try {
                    if (y.get(".msg.$fromusername") == null) {
                        aVar.rYX = (String) y.get(".msg.$username");
                    } else {
                        aVar.rYX = (String) y.get(".msg.$fromusername");
                    }
                    if (y.get(".msg.$fromnickname") == null) {
                        aVar.fpL = (String) y.get(".msg.$nickname");
                    } else {
                        aVar.fpL = (String) y.get(".msg.$fromnickname");
                    }
                    aVar.gfN = (String) y.get(".msg.$alias");
                    aVar.hwV = (String) y.get(".msg.$fullpy");
                    aVar.hwU = (String) y.get(".msg.$shortpy");
                    aVar.bhd = (String) y.get(".msg.$source");
                    aVar.xzi = Integer.valueOf((String) y.get(".msg.$imagestatus")).intValue();
                    aVar.scene = Integer.valueOf((String) y.get(".msg.$scene")).intValue();
                    aVar.xzj = (String) y.get(".msg.$mobileidentify");
                    aVar.xzk = (String) y.get(".msg.$mobilelongidentify");
                    if (y.get(".msg.$qqnum") != null && ((String) y.get(".msg.$qqnum")).length() > 0) {
                        aVar.pjS = Long.valueOf((String) y.get(".msg.$qqnum")).longValue();
                    }
                    aVar.signature = (String) y.get(".msg.$sign");
                    if (y.get(".msg.$sex") != null && ((String) y.get(".msg.$sex")).length() > 0) {
                        aVar.fWf = Integer.valueOf((String) y.get(".msg.$sex")).intValue();
                    }
                    aVar.fWq = (String) y.get(".msg.$city");
                    aVar.fWp = (String) y.get(".msg.$province");
                    aVar.hwW = (String) y.get(".msg.$qqnickname");
                    aVar.hwZ = (String) y.get(".msg.$qqremark");
                    aVar.tmE = Integer.valueOf(TextUtils.isEmpty((CharSequence) y.get(".msg.$certflag")) ? "0" : (String) y.get(".msg.$certflag")).intValue();
                    aVar.fWu = bh.ou((String) y.get(".msg.$certinfo"));
                    aVar.phJ = bh.ou((String) y.get(".msg.$brandIconUrl"));
                    aVar.fWv = bh.ou((String) y.get(".msg.$regionCode"));
                    aVar.xzl = bh.ou((String) y.get(".msg.$bigheadimgurl"));
                    aVar.xzm = bh.ou((String) y.get(".msg.$smallheadimgurl"));
                    aVar.pjU = bh.ou((String) y.get(".msg.$googlecontact"));
                    aVar.vtc = bh.ou((String) y.get(".msg.$antispamticket"));
                    x.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", aVar.rYX, aVar.vtc, aVar.xzl, aVar.xzm);
                } catch (Throwable e) {
                    x.e("MicroMsg.MsgInfo", "exception:%s", bh.i(e));
                }
            }
            return aVar;
        }

        public final String getDisplayName() {
            if (!TextUtils.isEmpty(this.fpL)) {
                return this.fpL;
            }
            if (!TextUtils.isEmpty(this.gfN)) {
                return this.gfN;
            }
            x.f("MicroMsg.MsgInfo", "username is nullOrNil");
            return bh.ou(this.rYX);
        }

        public final String cjG() {
            if (this.hwZ != null && this.hwZ.length() > 0) {
                return this.hwZ;
            }
            if (this.hwW == null || this.hwW.length() <= 0) {
                return Long.toString(this.pjS);
            }
            return this.hwW;
        }

        public final String getCity() {
            if (!bh.ov(this.fWv)) {
                String[] split = this.fWv.split("_");
                if (split.length > 0) {
                    if (split.length > 2) {
                        this.fWq = RegionCodeDecoder.cjP().ai(split[0], split[1], split[2]);
                    } else if (split.length == 2) {
                        this.fWq = RegionCodeDecoder.cjP().fE(split[0], split[1]);
                    } else {
                        this.fWq = "";
                    }
                }
            }
            return this.fWq;
        }

        public final String getProvince() {
            if (!bh.ov(this.fWv)) {
                String[] split = this.fWv.split("_");
                if (split.length > 0) {
                    if (split.length <= 2 || !RegionCodeDecoder.XE(split[0])) {
                        this.fWp = RegionCodeDecoder.cjP().XF(split[0]);
                    } else {
                        this.fWp = RegionCodeDecoder.cjP().fE(split[0], split[1]);
                    }
                }
            }
            return this.fWp;
        }
    }

    public static final class b {
        public int fzv = 0;
        public String label = "";
        public double nQx = 0.0d;
        public double nQy = 0.0d;
        public String nTe = "";
        public String rYX = "";
        public String vcT = "";
        public String xzn = "";
        public String xzo = null;
        public String xzp = null;
        public String xzq = null;

        public final String toString() {
            return String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.nQx * 1000000.0d)), Integer.valueOf((int) (this.nQy * 1000000.0d)), Integer.valueOf(this.fzv)});
        }

        public static b Xs(String str) {
            b bVar = new b();
            Map y = bi.y(str, "msg");
            if (y != null) {
                bVar.rYX = bh.az((String) y.get(".msg.location.$fromusername"), "");
                bVar.nQx = bh.VK((String) y.get(".msg.location.$x"));
                bVar.nQy = bh.VK((String) y.get(".msg.location.$y"));
                bVar.label = bh.az((String) y.get(".msg.location.$label"), "");
                bVar.xzn = bh.az((String) y.get(".msg.location.$maptype"), "");
                bVar.fzv = bh.VI((String) y.get(".msg.location.$scale"));
                bVar.xzq = bh.az((String) y.get(".msg.location.$localLocationen"), "");
                bVar.xzo = bh.az((String) y.get(".msg.location.$localLocationcn"), "");
                bVar.xzp = bh.az((String) y.get(".msg.location.$localLocationtw"), "");
                bVar.nTe = bh.az((String) y.get(".msg.location.$poiname"), "");
                bVar.vcT = bh.az((String) y.get(".msg.location.$infourl"), "");
            }
            return bVar;
        }

        public final boolean cjH() {
            return (this.nTe == null || this.nTe.equals("")) ? false : true;
        }
    }

    public static final class c {
        public String content = "";
        public String hMK = "";
        public boolean muO = false;
        public String pod;
        public String title = "";
        public String xzr = "";

        private c() {
        }

        public static c Xt(String str) {
            c cVar = new c();
            Map y = bi.y(str, "msg");
            if (y != null) {
                try {
                    cVar.title = (String) y.get(".msg.pushmail.content.subject");
                    cVar.content = (String) y.get(".msg.pushmail.content.digest");
                    cVar.hMK = (String) y.get(".msg.pushmail.content.sender");
                    cVar.xzr = (String) y.get(".msg.pushmail.waplink");
                    cVar.muO = bh.ou((String) y.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
                    cVar.pod = (String) y.get(".msg.pushmail.mailid");
                } catch (Throwable e) {
                    x.e("MicroMsg.MsgInfo", "exception:%s", bh.i(e));
                }
            }
            return cVar;
        }
    }

    public static final class d {
        public String chatroomName = "";
        public String content = "";
        private String countryCode;
        public int fWf;
        public String fpL = "";
        public int fuL;
        public String gfN = "";
        private String hhw;
        private String hhx;
        public String hwU = "";
        public String hwV = "";
        public String hwW = "";
        private String hwZ = "";
        public String mOi;
        public long pjS = 0;
        public String pjU;
        public String rYX = "";
        public int scene = 0;
        public String signature;
        public String vmS;
        public String vmT;
        public int xzi = 0;
        public String xzj = "";
        public String xzk = "";
        public String xzl = "";
        public String xzm = "";
        public int xzs = 0;
        public String xzt;
        public String xzu;
        public int xzv;
        public String xzw;
        public String xzx;

        private d() {
        }

        public static d Xu(String str) {
            d dVar = new d();
            Map y = bi.y(str, "msg");
            if (y != null) {
                try {
                    dVar.rYX = (String) y.get(".msg.$fromusername");
                    dVar.gfN = (String) y.get(".msg.$alias");
                    dVar.fpL = (String) y.get(".msg.$fromnickname");
                    dVar.hwV = (String) y.get(".msg.$fullpy");
                    dVar.hwU = (String) y.get(".msg.$shortpy");
                    dVar.content = (String) y.get(".msg.$content");
                    dVar.xzi = Integer.valueOf((String) y.get(".msg.$imagestatus")).intValue();
                    dVar.scene = Integer.valueOf((String) y.get(".msg.$scene")).intValue();
                    dVar.xzj = (String) y.get(".msg.$mhash");
                    dVar.xzk = (String) y.get(".msg.$mfullhash");
                    if (y.get(y.get(".msg.$qqnum")) != null && ((String) y.get(y.get(".msg.$qqnum"))).length() > 0) {
                        dVar.pjS = Long.valueOf((String) y.get(".msg.$qqnum")).longValue();
                    }
                    dVar.hwW = (String) y.get(".msg.$qqnickname");
                    dVar.hwZ = (String) y.get(".msg.$qqremark");
                    dVar.signature = (String) y.get(".msg.$sign");
                    if (y.get(".msg.$sex") != null && ((String) y.get(".msg.$sex")).length() > 0) {
                        dVar.fWf = Integer.valueOf((String) y.get(".msg.$sex")).intValue();
                    }
                    dVar.hhw = (String) y.get(".msg.$city");
                    dVar.hhx = (String) y.get(".msg.$province");
                    dVar.countryCode = (String) y.get(".msg.$country");
                    if (y.get(".msg.$snsflag") != null) {
                        dVar.xzs = Integer.valueOf((String) y.get(".msg.$snsflag")).intValue();
                        dVar.xzt = (String) y.get(".msg.$snsbgimgid");
                    }
                    dVar.mOi = (String) y.get(".msg.$ticket");
                    x.d("MicroMsg.MsgInfo", "dkverify ticket:%s", dVar.mOi);
                    dVar.xzl = bh.ou((String) y.get(".msg.$bigheadimgurl"));
                    dVar.xzm = bh.ou((String) y.get(".msg.$smallheadimgurl"));
                    dVar.fuL = Integer.valueOf(bh.az((String) y.get(".msg.$opcode"), "0")).intValue();
                    dVar.xzu = bh.ou((String) y.get(".msg.$encryptusername"));
                    dVar.pjU = bh.ou((String) y.get(".msg.$googlecontact"));
                    x.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", dVar.rYX, dVar.xzl, dVar.xzm);
                    dVar.chatroomName = bh.ou((String) y.get(".msg.$chatroomusername"));
                    dVar.vmS = (String) y.get(".msg.$sourceusername");
                    dVar.vmT = (String) y.get(".msg.$sourcenickname");
                    dVar.xzv = bh.getInt((String) y.get(".msg.Antispam.$isSuspiciousUser"), 0);
                    if (dVar.xzv == 1) {
                        dVar.xzw = (String) y.get(".msg.Antispam.safetyWarning");
                        dVar.xzx = (String) y.get(".msg.Antispam.safetyWarningDetail");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MsgInfo", e, "", new Object[0]);
                }
            }
            return dVar;
        }

        public final String cjI() {
            return this.mOi;
        }

        public final String vN() {
            return this.gfN;
        }

        public final String cjJ() {
            return this.rYX;
        }

        public final String vP() {
            return this.fpL;
        }

        public final String getDisplayName() {
            if (this.fpL != null && this.fpL.length() > 0) {
                return this.fpL;
            }
            x.f("MicroMsg.MsgInfo", "username is nullOrNil");
            return this.rYX;
        }

        public final String vR() {
            return this.hwV;
        }

        public final String vQ() {
            return this.hwU;
        }

        public final int cjK() {
            return this.fWf;
        }

        public final String cjL() {
            return this.signature;
        }

        public final String getCity() {
            if (bh.ov(this.countryCode) || bh.ov(this.hhx)) {
                return this.hhw;
            }
            if (bh.ov(this.hhw)) {
                return RegionCodeDecoder.cjP().fE(this.countryCode, this.hhx);
            }
            return RegionCodeDecoder.cjP().ai(this.countryCode, this.hhx, this.hhw);
        }

        public final String getProvince() {
            if (bh.ov(this.countryCode)) {
                return this.hhx;
            }
            if (bh.ov(this.hhx) || bh.ov(this.hhw) || !RegionCodeDecoder.XE(this.countryCode)) {
                return RegionCodeDecoder.cjP().XF(this.countryCode);
            }
            return RegionCodeDecoder.cjP().fE(this.countryCode, this.hhx);
        }

        public final String cjM() {
            return this.xzu;
        }
    }

    public au(String str) {
        super.dS(str);
    }

    public final boolean aNc() {
        return (getType() & 65535) == 49;
    }

    public final boolean ciV() {
        return getType() == 285212721;
    }

    public final boolean ciW() {
        return getType() == 34;
    }

    public final boolean ciX() {
        return getType() == 436207665;
    }

    public final boolean ciY() {
        return getType() == 469762097;
    }

    public final boolean ciZ() {
        return getType() == 301989937;
    }

    public final boolean cja() {
        return getType() == 50 || getType() == 53;
    }

    public final boolean cjb() {
        return getType() == 52;
    }

    public final boolean cjc() {
        return getType() == 318767153;
    }

    public final boolean cjd() {
        return getType() == 10002;
    }

    public final boolean cje() {
        switch (getType()) {
            case 3:
            case 13:
            case 23:
            case 33:
            case 39:
                return true;
            default:
                return false;
        }
    }

    public final boolean cjf() {
        return getType() == 42;
    }

    public final boolean aNe() {
        return getType() == 48;
    }

    public final boolean cjg() {
        switch (getType()) {
            case 1:
            case 11:
            case 21:
            case 31:
            case 36:
                return true;
            default:
                return false;
        }
    }

    public final boolean isSystem() {
        return getType() == 10000;
    }

    public final boolean cjh() {
        return getType() == 43;
    }

    public final boolean cji() {
        return getType() == 62;
    }

    public final boolean cjj() {
        return getType() == 47;
    }

    public final boolean cjk() {
        return getType() == 1048625;
    }

    public final boolean cjl() {
        return getType() == 16777265;
    }

    public final boolean cjm() {
        return getType() == 268435505;
    }

    public final boolean cjn() {
        return getType() == -1879048191;
    }

    public final boolean cjo() {
        return getType() == -1879048190;
    }

    public final boolean cjp() {
        return getType() == -1879048189;
    }

    public final boolean cjq() {
        switch (getType()) {
            case 55:
            case 57:
                return true;
            default:
                return false;
        }
    }

    public final boolean cjr() {
        Object obj;
        String value = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("TranslateMsgOff");
        if (bh.ov(value) || bh.VI(value) == 0) {
            int i = 1;
        } else {
            x.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
            obj = null;
        }
        return (obj == null || bh.ov(this.field_transContent)) ? false : true;
    }

    public static au ae(au auVar) {
        if (auVar == null) {
            x.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
            return null;
        }
        au auVar2 = new au();
        auVar2.ao(auVar.field_msgId);
        auVar2.ap(auVar.field_msgSvrId);
        auVar2.setType(auVar.getType());
        auVar2.eQ(auVar.field_status);
        auVar2.eR(auVar.field_isSend);
        auVar2.field_isShowTimer = auVar.field_isShowTimer;
        auVar2.gjm = true;
        auVar2.aq(auVar.field_createTime);
        auVar2.dS(auVar.field_talker);
        auVar2.setContent(auVar.field_content);
        auVar2.dT(auVar.field_imgPath);
        auVar2.dU(auVar.field_reserved);
        auVar2.A(auVar.field_lvbuffer);
        auVar2.dV(auVar.field_transContent);
        auVar2.dX(auVar.gjD);
        auVar2.fb(auVar.gjE);
        auVar2.dY(auVar.gjF);
        return auVar2;
    }

    public final void eQ(int i) {
        com.tencent.mm.sdk.b.b osVar;
        super.eQ(i);
        if (this.field_isSend == 1) {
            int i2 = (cjg() || aNe() || cjf()) ? 0 : 1;
            if (i2 != 0) {
                if (this.field_status == 5) {
                    x.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", Long.valueOf(this.field_msgId), Integer.valueOf(getType()), this.field_talker, bh.cgy());
                    osVar = new os();
                    osVar.fGK.fnB = this;
                    com.tencent.mm.sdk.b.a.xef.m(osVar);
                    return;
                } else if (this.field_status == 2) {
                    x.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", Long.valueOf(this.field_msgId), Integer.valueOf(getType()));
                    osVar = new ou();
                    osVar.fGM.fnB = this;
                    com.tencent.mm.sdk.b.a.xef.m(osVar);
                    return;
                } else {
                    return;
                }
            }
        }
        if (this.field_isSend == 0) {
            osVar = new ml();
            osVar.fEq.fnB = this;
            com.tencent.mm.sdk.b.a.xef.m(osVar);
        }
    }

    public final boolean cjs() {
        return (this.gjI & 1) > 0;
    }

    public final void cjt() {
        this.gjI |= 1;
        this.gfw = true;
    }

    public final void cju() {
        if (cjv()) {
            fb(this.gjE & -33);
        }
    }

    public final boolean cjv() {
        return (this.gjE & 32) > 0;
    }

    public final boolean cjw() {
        return cjr() && (this.gjE & 16) > 0;
    }

    public final void cjx() {
        if (cjr()) {
            fb(this.gjE | 16);
        }
    }

    public final void cjy() {
        fb(this.gjE | 768);
    }

    public final boolean cjz() {
        return ((this.gjE & 768) == 0 && (this.gjE & 768) == 0) ? false : true;
    }

    public final void Dq(int i) {
        switch (i) {
            case 0:
            case 1:
                fb(this.gjE | i);
                return;
            default:
                x.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
                return;
        }
    }

    public final void cjA() {
        fb(this.gjE & -65);
    }

    public final void cjB() {
        fb(this.gjE | 64);
    }

    public final boolean cjC() {
        return (this.gjE & 64) != 0;
    }

    public final boolean Xq(String str) {
        if (!(bh.ov(this.gjF) || bh.ov(str))) {
            Map y = bi.y(this.gjF, "msgsource");
            if (y == null) {
                return false;
            }
            String str2 = (String) y.get(".msgsource.atuserlist");
            if (!bh.ov(str2)) {
                for (String trim : str2.split(",")) {
                    if (trim.trim().equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean cjD() {
        boolean z;
        if (bh.ov(this.gjF) || !(this.gjF.contains("announcement@all") || this.gjF.contains("notify@all"))) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", Boolean.valueOf(z));
        return z;
    }

    public static boolean au(Map<String, String> map) {
        boolean z;
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", Boolean.valueOf(z));
        return z;
    }

    public static boolean av(Map<String, String> map) {
        boolean z;
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", Boolean.valueOf(z));
        return z;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        String str = this.field_content;
        if (str != null && str.length() > 2097152) {
            final long j = this.field_msgId;
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append("Very big message: \nmsgId = ").append(j).append('\n').append("msgSvrId = ").append(this.field_msgSvrId).append('\n').append("type = ").append(getType()).append('\n').append("createTime = ").append(this.field_createTime).append('\n').append("talker = ").append(this.field_talker).append('\n').append("flag = ").append(this.field_flag).append('\n').append("content.length() = ").append(str.length()).append('\n').append("content = ").append(str.substring(0, 256));
            x.e("MicroMsg.MsgInfo", stringBuilder.toString());
            setType(1);
            setContent("");
            final au ae = ae(this);
            g.Dm().F(new Runnable(this) {
                final /* synthetic */ au xzh;

                public final void run() {
                    ((h) g.h(h.class)).aZi().a(j, ae);
                }
            });
        }
        fQ(this.field_msgId);
    }

    public static void fQ(long j) {
        String str = "msgId not in the reasonable scope";
        boolean z = 100000000 > j && -10 < j;
        Assert.assertTrue(str, z);
    }

    public final ContentValues vI() {
        fQ(this.field_msgId);
        return super.vI();
    }

    public final String cjE() {
        if (!cjd()) {
            return "";
        }
        if (this.xzf == null) {
            cjF();
        }
        return this.xzf;
    }

    public final com.tencent.mm.ax.a cjF() {
        x.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
        com.tencent.mm.ax.a b = com.tencent.mm.ax.a.a.b(f.y(this.field_content, "sysmsg"), this);
        if (b != null) {
            x.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", b);
            if (b.values == null || b.values.size() <= 0) {
                x.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
            } else {
                if (b.values.containsKey(".sysmsg.$type")) {
                    b.TYPE = (String) b.values.get(".sysmsg.$type");
                }
                com.tencent.mm.ax.a.hIr = ".sysmsg." + b.TYPE + ".text";
                if (b.values.containsKey(com.tencent.mm.ax.a.hIr)) {
                    b.TEXT = (String) b.values.get(com.tencent.mm.ax.a.hIr);
                }
                com.tencent.mm.ax.a.hIs = ".sysmsg." + b.TYPE + ".link.scene";
                if (b.values.containsKey(com.tencent.mm.ax.a.hIs)) {
                    b.hIu = (String) b.values.get(com.tencent.mm.ax.a.hIs);
                }
                b.QA();
            }
            this.xzf = b.TEXT;
        } else {
            x.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
        }
        return b;
    }

    public final int getType() {
        int type = super.getType();
        if (type == 486539313) {
            return 285212721;
        }
        return type;
    }
}
