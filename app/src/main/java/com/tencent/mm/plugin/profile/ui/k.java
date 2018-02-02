package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.e;
import com.tencent.mm.bf.l;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.plugin.sns.b.h$a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.m;
import com.tencent.mm.z.r;
import junit.framework.Assert;
import org.json.JSONObject;
import org.xwalk.core.R$styleable;

@g(ceR = {ContactInfoUI.class})
public final class k implements e, h$a, a {
    Activity fAF;
    String foI = null;
    private int fug = 0;
    private f ilB;
    x jLe;
    q kZS;
    String lbf;
    private String mOi;
    private String nzw;
    private boolean phD;
    private boolean phE;
    int phF;
    String pjA;
    c<ap> pjB = new 5(this);
    private int pji;
    private bla pjo = new bla();
    private boolean pjp;
    private String pjq = "";
    private int pjr = -1;
    private boolean pjs = false;
    private boolean pjt = false;
    private String pju;
    private boolean pjv = false;
    private boolean pjw = false;
    private String pjx = null;
    private String pjy = null;
    private int pjz;

    public k(Activity activity) {
        this.fAF = activity;
    }

    public final boolean vQ(String str) {
        Intent intent;
        if (str.equals("contact_info_sns")) {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                intent = this.fAF.getIntent();
                intent.putExtra("sns_source", this.fug);
                intent.putExtra("sns_signature", this.jLe.signature);
                intent.putExtra("sns_nickName", this.jLe.AP());
                intent.putExtra("sns_title", this.jLe.AQ());
                if (n.qQD != null) {
                    intent = n.qQD.e(intent, this.jLe.field_username);
                }
                if (intent == null) {
                    ((MMActivity) this.fAF).finish();
                } else {
                    d.b(this.fAF, "sns", ".ui.SnsUserUI", intent);
                    if ((intent.getFlags() & 67108864) != 0) {
                        ((MMActivity) this.fAF).finish();
                    }
                }
            } else {
                u.fI(this.fAF);
                return true;
            }
        }
        String stringExtra;
        long longExtra;
        if (str.equals("contact_info_more")) {
            Intent intent2 = new Intent();
            intent2.setClass(this.fAF, ContactMoreInfoUI.class);
            intent2.putExtra("Is_RoomOwner", this.fAF.getIntent().getBooleanExtra("Is_RoomOwner", false));
            intent2.putExtra("Contact_User", this.jLe.field_username);
            intent2.putExtra("KLinkedInAddFriendNickName", this.pjx);
            intent2.putExtra("KLinkedInAddFriendPubUrl", this.pjy);
            stringExtra = this.fAF.getIntent().getStringExtra("room_name");
            if (stringExtra == null) {
                stringExtra = this.fAF.getIntent().getStringExtra("Contact_ChatRoomId");
            }
            intent2.putExtra("Contact_ChatRoomId", stringExtra);
            intent2.putExtra("verify_gmail", this.nzw);
            intent2.putExtra("profileName", this.pju);
            longExtra = this.fAF.getIntent().getLongExtra("Contact_Uin", 0);
            stringExtra = this.fAF.getIntent().getStringExtra("Contact_QQNick");
            intent2.putExtra("Contact_Uin", longExtra);
            intent2.putExtra("Contact_QQNick", stringExtra);
            this.fAF.startActivity(intent2);
        } else if (str.equals("contact_info_social")) {
            intent = new Intent();
            intent.setClass(this.fAF, ContactSocialInfoUI.class);
            intent.putExtra("Contact_User", this.jLe.field_username);
            longExtra = this.fAF.getIntent().getLongExtra("Contact_Uin", 0);
            r1 = this.fAF.getIntent().getStringExtra("Contact_QQNick");
            intent.putExtra("Contact_Uin", longExtra);
            intent.putExtra("Contact_QQNick", r1);
            intent.putExtra("profileName", this.pju);
            intent.putExtra("verify_gmail", this.nzw);
            r1 = this.fAF.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = this.fAF.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            intent.putExtra("Contact_Mobile_MD5", r1);
            intent.putExtra("Contact_full_Mobile_MD5", stringExtra2);
            this.fAF.startActivity(intent);
        } else if (str.equals("contact_info_invite_source")) {
            stringExtra = ((KeyValuePreference) this.ilB.YN("contact_info_invite_source")).getExtras().getString("inviteer");
            if (!bh.ov(stringExtra)) {
                r1 = gu(stringExtra);
                Intent intent3 = new Intent();
                intent3.putExtra("Contact_User", stringExtra);
                intent3.putExtra("Contact_RemarkName", r1);
                intent3.putExtra("Contact_RoomNickname", r1);
                intent3.putExtra("Contact_RoomMember", true);
                intent3.putExtra("room_name", this.lbf);
                ar.Hg();
                intent3.putExtra("Contact_Nick", com.tencent.mm.z.c.EY().WO(stringExtra).field_nickname);
                intent3.putExtra("Contact_Scene", 14);
                intent3.putExtra("Is_RoomOwner", true);
                intent3.putExtra("Contact_ChatRoomId", this.lbf);
                com.tencent.mm.plugin.profile.a.ifs.d(intent3, this.fAF);
            }
        }
        return true;
    }

    final void HA(String str) {
        if (bh.ov(str)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.phF);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", this.jLe.field_username);
        intent.putExtra("Contact_Nick", this.jLe.field_nickname);
        intent.putExtra("Contact_RemarkName", this.jLe.field_conRemark);
        com.tencent.mm.plugin.profile.a.ifs.q(intent, this.fAF);
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        String stringExtra;
        String str;
        int i2;
        KeyValuePreference keyValuePreference;
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(bh.ou(xVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        this.ilB = fVar;
        this.jLe = xVar;
        this.phD = z;
        this.phF = i;
        this.phE = this.fAF.getIntent().getBooleanExtra("User_Verify", false);
        this.mOi = bh.ou(this.fAF.getIntent().getStringExtra("Verify_ticket"));
        this.pjp = this.fAF.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.pji = this.fAF.getIntent().getIntExtra("Kdel_from", -1);
        this.pjq = this.fAF.getIntent().getStringExtra("Contact_RemarkName");
        this.fug = this.fAF.getIntent().getIntExtra("Sns_from_Scene", 0);
        this.pjs = this.fAF.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.pjt = this.fAF.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.pjr = this.fAF.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
        long longExtra = this.fAF.getIntent().getLongExtra("Contact_KSnsBgId", -1);
        String az = bh.az(this.fAF.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
        this.nzw = bh.az(this.fAF.getIntent().getStringExtra("verify_gmail"), "");
        this.pju = bh.az(this.fAF.getIntent().getStringExtra("profileName"), bh.VS(this.nzw));
        this.pjo.hvE = this.pjr;
        this.pjo.hvG = longExtra;
        this.pjo.hvF = az;
        this.pjx = this.fAF.getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.pjy = this.fAF.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        if (n.qQz != null) {
            this.pjo = n.qQz.b(xVar.field_username, this.pjo);
        }
        this.lbf = this.fAF.getIntent().getStringExtra("room_name");
        ar.Hg();
        this.kZS = com.tencent.mm.z.c.Fh().hD(this.lbf);
        this.pjw = xVar.field_deleteFlag == 1;
        arS();
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fbw);
        if (n.qQD != null) {
            n.qQD.a(3, this.jLe.field_username, this);
        }
        ar.CG().a(30, this);
        this.pjA = "";
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[]{this.jLe.AM()});
        if (!this.jLe.AM()) {
            b bVar = null;
            stringExtra = this.fAF.getIntent().getStringExtra("Contact_Mobile_MD5");
            az = this.fAF.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            Object[] objArr;
            if (bh.ov(stringExtra) && bh.ov(az)) {
                if (!bh.ov(this.jLe.field_username)) {
                    b kR = af.OD().kR(this.jLe.field_username);
                    az = "MicroMsg.ContactWidgetNormal";
                    str = "Contact name: %s AddrUpload IS NULL? %s";
                    objArr = new Object[2];
                    objArr[0] = this.jLe.field_username;
                    objArr[1] = kR == null ? "true" : "false";
                    com.tencent.mm.sdk.platformtools.x.i(az, str, objArr);
                    bVar = kR;
                }
            } else if (!(bh.ov(stringExtra) && bh.ov(az))) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[]{this.jLe.field_username, stringExtra, az});
                bVar = af.OD().kS(stringExtra);
                if (bVar == null || bh.ov(bVar.Nr())) {
                    bVar = af.OD().kS(az);
                }
                az = "MicroMsg.ContactWidgetNormal";
                str = "Contact name: %s AddrUpload IS NULL? %s";
                objArr = new Object[2];
                objArr[0] = this.jLe.field_username;
                objArr[1] = bVar == null ? "true" : "false";
                com.tencent.mm.sdk.platformtools.x.i(az, str, objArr);
            }
            if (!(bVar == null || bh.ov(bVar.Nr()))) {
                this.pjA = bh.ou(bVar.Nz()).replace(" ", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[]{this.jLe.field_username, this.pjA});
            }
        }
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ilB.YN("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            x xVar2 = this.jLe;
            i2 = this.phF;
            az = this.mOi;
            str = this.pjA;
            String str2 = this.jLe.fWE;
            normalUserHeaderPreference.vkI = str;
            normalUserHeaderPreference.vkJ = str2;
            normalUserHeaderPreference.a(xVar2, i2, az);
            normalUserHeaderPreference.bc(this.jLe.field_username, this.pjs);
            normalUserHeaderPreference.vtW = new 1(this);
            if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                this.pjt = false;
            }
            normalUserHeaderPreference.bd(this.jLe.field_username, this.pjt);
        } else {
            this.ilB.c(normalUserHeaderPreference);
        }
        if (bh.ov(this.jLe.getProvince())) {
            this.ilB.YO("contact_info_district");
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_district");
            if (keyValuePreference != null) {
                keyValuePreference.setTitle(this.fAF.getString(R.l.dUP));
                keyValuePreference.setSummary(r.gw(this.jLe.getProvince()) + (bh.ov(this.jLe.getCity()) ? "" : "  " + this.jLe.getCity()));
                keyValuePreference.mx(false);
                keyValuePreference.setEnabled(false);
            }
        }
        if (this.jLe.signature == null || this.jLe.signature.trim().equals("") || com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
            this.ilB.YO("contact_info_signature");
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_signature");
            if (keyValuePreference != null) {
                keyValuePreference.yiT = false;
                keyValuePreference.setTitle(this.fAF.getString(R.l.dWw));
                keyValuePreference.setSummary(i.a(this.fAF, this.jLe.signature));
                keyValuePreference.mx(false);
            }
        }
        this.ilB.YN("contact_info_facebook");
        this.ilB.YO("contact_info_facebook");
        if ((((this.pjo.hvE & 1) > 0 ? 1 : 0) & d.OQ("sns")) == 0 || x.Wy(this.jLe.field_username) || this.jLe.AF()) {
            this.ilB.YO("contact_info_sns");
        } else {
            com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.ilB.YN("contact_info_sns");
            if (!(gVar == null || n.qQz == null)) {
                gVar.SG(this.jLe.field_username);
            }
        }
        this.ilB.YO("contact_info_verifyuser");
        if (this.phF == 96) {
            this.ilB.YO("contact_info_footer_normal");
        }
        Object obj;
        if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
            int[] iArr = new int[7];
            ContactMoreInfoPreference contactMoreInfoPreference = (ContactMoreInfoPreference) this.ilB.YN("contact_info_more");
            if (contactMoreInfoPreference != null) {
                long longExtra2 = this.fAF.getIntent().getLongExtra("Contact_Uin", 0);
                if (longExtra2 == -1 || new o(longExtra2).longValue() <= 0) {
                    contactMoreInfoPreference.uL(8);
                    iArr[0] = 8;
                } else {
                    contactMoreInfoPreference.uL(0);
                    iArr[0] = 0;
                }
                if (bh.ov(this.nzw) || bh.ov(this.pju)) {
                    contactMoreInfoPreference.uN(8);
                    iArr[1] = 8;
                } else {
                    contactMoreInfoPreference.uN(0);
                    iArr[1] = 0;
                }
                stringExtra = com.tencent.mm.k.g.zY().getValue("LinkedinPluginClose");
                obj = (bh.ov(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0) ? 1 : null;
                if (obj == null || bh.ov(this.jLe.fWA)) {
                    contactMoreInfoPreference.uM(8);
                    iArr[2] = 8;
                } else {
                    contactMoreInfoPreference.uM(0);
                    iArr[2] = 0;
                }
                if (com.tencent.mm.z.q.FS().equals(this.jLe.field_username)) {
                    ar.Hg();
                    stringExtra = (String) com.tencent.mm.z.c.CU().get(w.a.xpK, null);
                } else {
                    stringExtra = this.jLe.fWD;
                }
                if (!bh.ov(stringExtra)) {
                    try {
                        stringExtra = new JSONObject(stringExtra).optString("ShopUrl");
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "", new Object[0]);
                    }
                    if (bh.ov(stringExtra)) {
                        contactMoreInfoPreference.uO(0);
                        iArr[3] = 0;
                    } else {
                        contactMoreInfoPreference.uO(8);
                        iArr[3] = 8;
                    }
                    if (bh.ov(this.jLe.signature)) {
                        iArr[4] = 0;
                    } else {
                        iArr[4] = 8;
                    }
                    if (this.jLe.getSource() > 0) {
                        iArr[5] = 8;
                    } else {
                        iArr[5] = 0;
                    }
                    iArr[6] = 8;
                    this.ilB.bk("contact_info_more", false);
                }
                stringExtra = null;
                if (bh.ov(stringExtra)) {
                    contactMoreInfoPreference.uO(8);
                    iArr[3] = 8;
                } else {
                    contactMoreInfoPreference.uO(0);
                    iArr[3] = 0;
                }
                if (bh.ov(this.jLe.signature)) {
                    iArr[4] = 0;
                } else {
                    iArr[4] = 8;
                }
                if (this.jLe.getSource() > 0) {
                    iArr[5] = 0;
                } else {
                    iArr[5] = 8;
                }
                iArr[6] = 8;
                this.ilB.bk("contact_info_more", false);
            }
            this.ilB.YO("contact_info_social");
        } else {
            ContactSocialInfoPreference contactSocialInfoPreference = (ContactSocialInfoPreference) this.ilB.YN("contact_info_social");
            if (contactSocialInfoPreference != null) {
                if (bh.ov(this.pjA)) {
                    contactSocialInfoPreference.uP(8);
                } else {
                    contactSocialInfoPreference.uP(0);
                    this.pjz = 1;
                }
                ar.Hg();
                i2 = bh.e((Integer) com.tencent.mm.z.c.CU().get(9, null));
                long longExtra3 = this.fAF.getIntent().getLongExtra("Contact_Uin", 0);
                str2 = this.fAF.getIntent().getStringExtra("Contact_QQNick");
                if (!(longExtra3 == 0 || i2 == 0)) {
                    if (str2 == null || str2.length() == 0) {
                        ad be = af.OI().be(longExtra3);
                        if (be == null) {
                            be = null;
                        }
                        if (be != null) {
                            be.getDisplayName();
                        }
                    }
                    if (longExtra3 == -1 || new o(longExtra3).longValue() <= 0) {
                        contactSocialInfoPreference.uL(8);
                    } else {
                        contactSocialInfoPreference.uL(0);
                        this.pjz = 1;
                    }
                }
                if (bh.ov(this.nzw) || bh.ov(this.pju)) {
                    contactSocialInfoPreference.uN(8);
                } else {
                    contactSocialInfoPreference.uN(0);
                    this.pjz = 1;
                }
                stringExtra = com.tencent.mm.k.g.zY().getValue("LinkedinPluginClose");
                obj = (bh.ov(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0) ? 1 : null;
                if (obj == null || bh.ov(this.jLe.fWA)) {
                    contactSocialInfoPreference.uM(8);
                } else {
                    contactSocialInfoPreference.uM(0);
                    this.pjz = 1;
                }
                if (com.tencent.mm.z.q.FS().equals(this.jLe.field_username)) {
                    ar.Hg();
                    stringExtra = (String) com.tencent.mm.z.c.CU().get(w.a.xpK, null);
                } else {
                    stringExtra = this.jLe.fWD;
                }
                az = null;
                if (!bh.ov(stringExtra)) {
                    try {
                        az = new JSONObject(stringExtra).optString("ShopUrl");
                    } catch (Throwable e2) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ContactWidgetNormal", e2, "", new Object[0]);
                    }
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[]{stringExtra, az});
                if (bh.ov(az)) {
                    contactSocialInfoPreference.uO(8);
                } else {
                    contactSocialInfoPreference.uO(0);
                    this.pjz = 1;
                }
                if (this.pjz == 0) {
                    this.ilB.YO("contact_info_social");
                }
            }
            this.ilB.YO("contact_info_more");
        }
        if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
            this.ilB.YO("contact_info_source");
        } else {
            i2 = this.fAF.getIntent().getIntExtra("Contact_Source_FMessage", 0);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.jLe.getSource() + ", sourceFMessage = " + i2);
            if (i2 != 0) {
                keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_source");
                if (this.phE) {
                    switch (i2) {
                        case 1:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(R.l.dWS);
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 3:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(R.l.dWU);
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 4:
                        case 12:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(this.fAF.getString(R.l.eie));
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 8:
                        case 14:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                com.tencent.mm.bf.f mW = l.Tw().mW(this.jLe.field_username);
                                ar.Hg();
                                com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(mW == null ? "" : mW.field_chatroomName);
                                if (bh.ov(WO != null ? WO.field_nickname : null)) {
                                    keyValuePreference.setSummary(R.l.dWH);
                                } else {
                                    keyValuePreference.setSummary(this.fAF.getString(R.l.dWI, new Object[]{WO != null ? WO.field_nickname : null}));
                                }
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 10:
                        case 13:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(R.l.dWY);
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 15:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(R.l.dWQ);
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 17:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                stringExtra = r.gu(this.fAF.getIntent().getStringExtra("source_from_user_name"));
                                if (bh.ov(stringExtra)) {
                                    stringExtra = this.fAF.getIntent().getStringExtra("source_from_nick_name");
                                }
                                if (bh.ov(stringExtra)) {
                                    keyValuePreference.setSummary(R.l.dWF);
                                } else {
                                    keyValuePreference.setSummary(i.a(this.fAF, this.fAF.getString(R.l.dWE, new Object[]{stringExtra})));
                                }
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 18:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(R.l.dWK);
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 25:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(R.l.dWC);
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 30:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(R.l.dWN);
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(this.fAF.getString(R.l.dWO));
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 58:
                        case 59:
                        case 60:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(this.fAF.getString(R.l.enp));
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        default:
                            this.ilB.c(keyValuePreference);
                            break;
                    }
                } else if (keyValuePreference != null) {
                    if (i2 == 10) {
                        keyValuePreference.yiT = false;
                        keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                        keyValuePreference.setSummary(this.fAF.getString(R.l.eid));
                        keyValuePreference.mx(false);
                    } else {
                        this.ilB.c(keyValuePreference);
                    }
                }
            } else {
                keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_source");
                if (this.phE) {
                    switch (this.jLe.getSource()) {
                        case 18:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(R.l.dWK);
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 22:
                        case 23:
                        case 24:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(R.l.dWW);
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 30:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(R.l.dWN);
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 34:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(this.fAF.getString(R.l.dWA));
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(this.fAF.getString(R.l.dWO));
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case 58:
                        case 59:
                        case 60:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(this.fAF.getString(R.l.enp));
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        case R$styleable.AppCompatTheme_textAppearanceListItem /*76*/:
                            if (keyValuePreference != null) {
                                keyValuePreference.yiT = false;
                                keyValuePreference.setTitle(this.fAF.getString(R.l.dWZ));
                                keyValuePreference.setSummary(this.fAF.getString(R.l.dWL));
                                keyValuePreference.mx(false);
                                break;
                            }
                            break;
                        default:
                            this.ilB.c(keyValuePreference);
                            break;
                    }
                }
                this.ilB.c(keyValuePreference);
            }
        }
        this.ilB.bk("contact_info_invite_source", true);
        boolean booleanExtra = this.fAF.getIntent().getBooleanExtra("Is_RoomOwner", false);
        if (this.phF != 14 || !booleanExtra || this.kZS == null || this.jLe.field_username.equals(this.kZS.field_roomowner)) {
            stringExtra = "MicroMsg.ContactWidgetNormal";
            az = "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(this.phF);
            objArr2[1] = Boolean.valueOf(booleanExtra);
            objArr2[2] = Boolean.valueOf(this.kZS == null);
            com.tencent.mm.sdk.platformtools.x.i(stringExtra, az, objArr2);
            this.ilB.bk("contact_info_invite_source", true);
        } else {
            this.foI = this.fAF.getIntent().getStringExtra("inviteer");
            if (bh.ov(this.foI)) {
                com.tencent.mm.i.a.a.b Wu = this.kZS.Wu(this.jLe.field_username);
                this.foI = Wu == null ? "" : bh.az(Wu.gBN, "");
            }
            if (bh.ov(this.foI)) {
                this.foI = m.J(this.jLe.field_username, this.lbf);
            }
            if (bh.ov(this.foI)) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", new Object[]{this.lbf, this.jLe.field_username});
                this.pjB.ceO();
                ak.a.hfL.a(this.jLe.field_username, this.lbf, new 3(this));
            } else {
                this.fAF.getIntent().putExtra("inviteer", this.foI);
                String gu = gu(this.foI);
                if (bh.ov(gu)) {
                    ak.a.hfL.a(this.jLe.field_username, "", new 4(this));
                } else {
                    dH(this.foI, gu);
                }
            }
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ilB.YN("contact_info_footer_normal");
        boolean booleanExtra2 = this.fAF.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean booleanExtra3 = this.fAF.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.fAF.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long longExtra4 = this.fAF.getIntent().getLongExtra("Contact_Uin", -1);
        if (this.phF == 30 || this.phF == 45) {
            this.pjp = false;
        }
        if (normalUserFooterPreference == null || !normalUserFooterPreference.a(this.jLe, this.mOi, this.phD, this.phE, this.pjp, this.phF, this.pji, booleanExtra3, booleanExtra2, longExtra4, this.pjq)) {
            this.ilB.YO("contact_info_footer_normal");
        } else {
            normalUserFooterPreference.hkZ.removeAll();
            normalUserFooterPreference.hkZ.a(new 2(this, normalUserHeaderPreference), Looper.getMainLooper());
        }
        i2 = this.jLe.fWs;
        this.ilB.YO("clear_lbs_info");
        if (this.pjw) {
            this.ilB.removeAll();
            if (normalUserHeaderPreference != null) {
                this.ilB.a(normalUserHeaderPreference);
            }
            if (normalUserFooterPreference != null) {
                this.ilB.a(normalUserFooterPreference);
            }
        }
        ar.Hg();
        com.tencent.mm.z.c.EY().WK(xVar.field_username);
        boolean equals = com.tencent.mm.z.q.FS().equals(xVar.field_username);
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[]{Integer.valueOf(this.pjo.hvE)});
        Object obj2 = (this.pjo.hvE & 1) > 0 ? 1 : null;
        if (!(xVar.AF() || x.Wy(xVar.field_username) || obj2 == null || n.qQD == null)) {
            n.qQD.a(2, xVar.field_username, equals, this.fug);
        }
        return true;
    }

    final void dH(String str, String str2) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", new Object[]{str, str2});
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_invite_source");
        TextPreference textPreference = (TextPreference) this.ilB.YN("contact_info_hint");
        this.ilB.bk("contact_info_invite_source", false);
        CharSequence spannableString = new SpannableString(i.a(this.fAF, this.fAF.getResources().getString(R.l.dVi, new Object[]{str2})));
        spannableString.setSpan(new ForegroundColorSpan(this.fAF.getResources().getColor(R.e.bsE)), 0, str2.length(), 33);
        keyValuePreference.setSummary(spannableString);
        keyValuePreference.getExtras().putString("inviteer", str);
        this.fAF.getIntent().putExtra("inviteer", str);
        if (this.kZS == null || this.kZS.Ms().contains(this.jLe.field_username)) {
            this.ilB.bk("contact_info_footer_normal", false);
            return;
        }
        this.ilB.bk("contact_info_footer_normal", true);
        textPreference.S(i.a(this.fAF, this.fAF.getResources().getString(R.l.dVN, new Object[]{gu(this.jLe.field_username)})));
    }

    final String gu(String str) {
        String str2 = null;
        if (this.kZS == null) {
            return null;
        }
        ar.Hg();
        com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(str);
        if (WO != null && ((int) WO.gJd) > 0) {
            str2 = WO.field_conRemark;
        }
        if (bh.ov(str2)) {
            str2 = this.kZS.gu(str);
        }
        if (!bh.ov(str2) || WO == null) {
            return str2;
        }
        return WO.AP();
    }

    public final boolean arS() {
        if (n.qQD != null) {
            n.qQD.a(this, 3);
        }
        ar.CG().b(30, this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ilB.YN("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ilB.YN("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.arS();
        }
        FriendPreference friendPreference = (FriendPreference) this.ilB.YN("contact_info_friend_qq");
        if (friendPreference != null) {
            friendPreference.arS();
        }
        friendPreference = (FriendPreference) this.ilB.YN("contact_info_friend_mobile");
        if (friendPreference != null) {
            friendPreference.arS();
        }
        friendPreference = (FriendPreference) this.ilB.YN("contact_info_facebook");
        if (friendPreference != null) {
            friendPreference.arS();
        }
        this.ilB.YN("contact_info_sns");
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.f.aZh().k(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.f.aZh().dj(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.h(this.fAF, this.fAF.getString(R.l.eic));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (kVar.getType() != 30 && kVar.getType() != 458) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + kVar.getType());
        } else if (i == 0 && i2 == 0) {
            if (kVar.getType() == 30) {
                com.tencent.mm.pluginsdk.model.o oVar = (com.tencent.mm.pluginsdk.model.o) kVar;
                if (oVar.fuL != 1 && oVar.fuL != 3) {
                    return;
                }
                if (oVar.vdy == null || oVar.vdy.contains(this.jLe.field_username)) {
                    NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ilB.YN("contact_info_header_normal");
                    NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ilB.YN("contact_info_footer_normal");
                    if (normalUserHeaderPreference != null && normalUserFooterPreference != null && normalUserFooterPreference.pkz) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
                        this.pjs = false;
                        this.pjt = false;
                        normalUserHeaderPreference.bc(this.jLe.field_username, false);
                        normalUserHeaderPreference.bd(this.jLe.field_username, false);
                        normalUserHeaderPreference.jh(this.jLe.field_username);
                        this.fAF.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.pjs);
                        this.fAF.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.pjt);
                    }
                }
            }
        } else if (i == 4 && i2 == -24 && !bh.ov(str)) {
            Toast.makeText(this.fAF, str, 1).show();
        }
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
        com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.ilB.YN("contact_info_sns");
        if (!(gVar == null || n.qQz == null)) {
            gVar.SG(this.jLe.field_username);
        }
        this.pjo = n.qQz.b(this.jLe.field_username, this.pjo);
        this.ilB.notifyDataSetChanged();
        if (z3) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetNormal", "bg Change!");
            if (n.qQD != null) {
                n.qQD.JC(this.jLe.field_username);
            }
        }
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
    }
}
