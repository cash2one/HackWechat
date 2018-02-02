package org.xwalk.core.extension;

import org.xwalk.core.extension.ReflectionHelper.MemberType;

public class MessageHandler$Handler {
    String javaName;
    ReflectionHelper reflection;
    Object targetObject;
    final /* synthetic */ MessageHandler this$0;
    MemberType type;

    public MessageHandler$Handler(MessageHandler messageHandler, String str, MemberType memberType, Object obj, ReflectionHelper reflectionHelper) {
        this.this$0 = messageHandler;
        this.type = memberType;
        this.javaName = str;
        this.targetObject = obj;
        this.reflection = reflectionHelper;
    }

    public MessageHandler$Handler(MessageHandler messageHandler, String str, MemberType memberType, Object obj) {
        this(messageHandler, str, memberType, obj, null);
    }
}
