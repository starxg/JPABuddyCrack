package com.starxg.janetfilter.plugin.jpabuddy;

import com.janetfilter.core.plugin.MyTransformer;
import javassist.ClassPool;
import javassist.CtClass;

import java.io.ByteArrayInputStream;
import java.security.ProtectionDomain;

class CrackTransformer implements MyTransformer {


    @Override
    public String getHookClassName() {
        return "com/haulmont/jpb/ui/toolwindow/structure/node2/JpaSectionMessage$MessageChecker";
    }


    @Override
    public byte[] transform(ClassLoader loader, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, String className, byte[] classBytes, int order) throws Exception {
        final ClassPool pool = ClassPool.getDefault();
        pool.appendSystemPath();
        final CtClass clazz = pool.makeClass(new ByteArrayInputStream(classBytes));
        clazz.getDeclaredMethod("Q").insertBefore("if(true)return true;");
        classBytes = clazz.toBytecode();
        clazz.detach();
        return classBytes;
    }

}
