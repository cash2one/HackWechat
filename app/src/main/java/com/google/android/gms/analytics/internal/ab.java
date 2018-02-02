package com.google.android.gms.analytics.internal;

import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class ab<T extends aa> extends n {
    a<T> aHe;

    public ab(q qVar, a<T> aVar) {
        super(qVar);
        this.aHe = aVar;
    }

    private T a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    if (toLowerCase.equals("screenname")) {
                        CharSequence attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        CharSequence trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue)) {
                            TextUtils.isEmpty(trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || trim2 == null)) {
                            this.aHe.l(r0, trim2);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        r1 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || TextUtils.isEmpty(r1))) {
                            try {
                                this.aHe.e(r0, Boolean.parseBoolean(r1));
                            } catch (NumberFormatException e) {
                                c("Error parsing bool configuration value", r1, e);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        r1 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || TextUtils.isEmpty(r1))) {
                            try {
                                this.aHe.k(r0, Integer.parseInt(r1));
                            } catch (NumberFormatException e2) {
                                c("Error parsing int configuration value", r1, e2);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            f("Error parsing tracker configuration file", e3);
        } catch (IOException e4) {
            f("Error parsing tracker configuration file", e4);
        }
        return this.aHe.nt();
    }

    public final T db(int i) {
        try {
            return a(this.aFo.aFV.getResources().getXml(i));
        } catch (NotFoundException e) {
            e("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
