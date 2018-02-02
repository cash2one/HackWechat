package com.tencent.mm.plugin.scanner.a;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.plugin.scanner.a.o.a;
import com.tencent.mm.plugin.scanner.a.o.b;
import com.tencent.mm.plugin.scanner.a.o.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class p {
    private o pTF = new o();

    public final void IC(String str) {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = "";
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 1:
                    o.pTF = this.pTF;
                    break;
                case 2:
                    str2 = newPullParser.getName();
                    if (!str2.equals("name")) {
                        if (!str2.equals("address")) {
                            if (!str2.equals("deliveryAddress")) {
                                if (!str2.equals("homeAddress")) {
                                    if (!str2.equals("workAddress")) {
                                        if (!str2.equals(SlookAirButtonFrequentContactAdapter.PHOTO)) {
                                            if (!str2.equals("logo")) {
                                                if (!str2.equals("sound")) {
                                                    break;
                                                }
                                                this.pTF.pTr = c(newPullParser);
                                                break;
                                            }
                                            this.pTF.pTq = c(newPullParser);
                                            break;
                                        }
                                        this.pTF.pTp = c(newPullParser);
                                        break;
                                    }
                                    this.pTF.pTw = b(newPullParser);
                                    break;
                                }
                                this.pTF.pTv = b(newPullParser);
                                break;
                            }
                            this.pTF.pTu = b(newPullParser);
                            break;
                        }
                        this.pTF.pTt = b(newPullParser);
                        break;
                    }
                    this.pTF.pTo = new b(newPullParser.getAttributeValue(null, "firstName"), newPullParser.getAttributeValue(null, "middleName"), newPullParser.getAttributeValue(null, "lastName"));
                    break;
                case 4:
                    String text = newPullParser.getText();
                    if (text != null && text.trim().length() > 0) {
                        text = text.trim();
                        if (!str2.equals("nickName")) {
                            if (!str2.equals("photoUrl")) {
                                if (!str2.equals("birthday")) {
                                    o oVar;
                                    if (!str2.equals("mobilePhoneNumber")) {
                                        if (!str2.equals("homePhoneNumber")) {
                                            if (!str2.equals("workPhoneNumber")) {
                                                if (!str2.equals("telAVPhoneNumber")) {
                                                    if (!str2.equals("phoneNumber")) {
                                                        if (!str2.equals("email")) {
                                                            if (!str2.equals("title")) {
                                                                if (!str2.equals("role")) {
                                                                    if (!str2.equals("agent")) {
                                                                        if (!str2.equals("note")) {
                                                                            if (!str2.equals(SlookSmartClipMetaTag.TAG_TYPE_URL)) {
                                                                                if (!str2.equals("organization")) {
                                                                                    break;
                                                                                }
                                                                                this.pTF.iIk = text;
                                                                                break;
                                                                            }
                                                                            this.pTF.url = text;
                                                                            break;
                                                                        }
                                                                        this.pTF.pTE = text;
                                                                        break;
                                                                    }
                                                                    this.pTF.pTD = text;
                                                                    break;
                                                                }
                                                                this.pTF.pTC = text;
                                                                break;
                                                            }
                                                            this.pTF.title = text;
                                                            break;
                                                        }
                                                        this.pTF.fWi = text;
                                                        break;
                                                    }
                                                    oVar = this.pTF;
                                                    if (oVar.pTB == null) {
                                                        oVar.pTB = new ArrayList();
                                                    }
                                                    if (!(text == null || oVar.pTB.contains(text))) {
                                                        oVar.pTB.add(text);
                                                        break;
                                                    }
                                                }
                                                oVar = this.pTF;
                                                if (oVar.pTA == null) {
                                                    oVar.pTA = new ArrayList();
                                                }
                                                if (!(text == null || oVar.pTA.contains(text))) {
                                                    oVar.pTA.add(text);
                                                    break;
                                                }
                                            }
                                            oVar = this.pTF;
                                            if (oVar.pTz == null) {
                                                oVar.pTz = new ArrayList();
                                            }
                                            if (!(text == null || oVar.pTz.contains(text))) {
                                                oVar.pTz.add(text);
                                                break;
                                            }
                                        }
                                        oVar = this.pTF;
                                        if (oVar.pTy == null) {
                                            oVar.pTy = new ArrayList();
                                        }
                                        if (!(text == null || oVar.pTy.contains(text))) {
                                            oVar.pTy.add(text);
                                            break;
                                        }
                                    }
                                    oVar = this.pTF;
                                    if (oVar.pTx == null) {
                                        oVar.pTx = new ArrayList();
                                    }
                                    if (!(text == null || oVar.pTx.contains(text))) {
                                        oVar.pTx.add(text);
                                        break;
                                    }
                                }
                                this.pTF.pTs = text;
                                break;
                            }
                            this.pTF.iIb = text;
                            break;
                        }
                        this.pTF.bgo = text;
                        break;
                    }
                default:
                    break;
            }
        }
        o.pTF = this.pTF;
    }

    private static a b(XmlPullParser xmlPullParser) {
        return new a(xmlPullParser.getAttributeValue(null, "postOfficeBox"), xmlPullParser.getAttributeValue(null, "extendedAddress"), xmlPullParser.getAttributeValue(null, "street"), xmlPullParser.getAttributeValue(null, TencentExtraKeys.LOCATION_KEY_LOCALITY), xmlPullParser.getAttributeValue(null, "region"), xmlPullParser.getAttributeValue(null, "postalCode"), xmlPullParser.getAttributeValue(null, "country"));
    }

    private static c c(XmlPullParser xmlPullParser) {
        return new c(xmlPullParser.getAttributeValue(null, DownloadSettingTable$Columns.TYPE), xmlPullParser.getAttributeValue(null, "buffer"));
    }
}
