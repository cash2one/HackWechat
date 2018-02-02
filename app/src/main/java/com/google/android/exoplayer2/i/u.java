package com.google.android.exoplayer2.i;

import org.xmlpull.v1.XmlPullParser;

public final class u {
    public static boolean b(XmlPullParser xmlPullParser, String str) {
        return (xmlPullParser.getEventType() == 2) && xmlPullParser.getName().equals(str);
    }

    public static String c(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (str.equals(xmlPullParser.getAttributeName(i))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
