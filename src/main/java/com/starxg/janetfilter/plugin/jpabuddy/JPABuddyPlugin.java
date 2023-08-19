package com.starxg.janetfilter.plugin.jpabuddy;

import com.janetfilter.core.Environment;
import com.janetfilter.core.plugin.MyTransformer;
import com.janetfilter.core.plugin.PluginConfig;
import com.janetfilter.core.plugin.PluginEntry;

import java.util.ArrayList;
import java.util.List;

public class JPABuddyPlugin implements PluginEntry {

    private final List<MyTransformer> transformers = new ArrayList<>();

    @Override
    public void init(Environment environment, PluginConfig config) {
        transformers.add(new CrackTransformer());
    }

    @Override
    public String getName() {
        return "JPABuddyPlugin";
    }

    @Override
    public String getAuthor() {
        return "https://github.com/starxg";
    }

    @Override
    public String getVersion() {
        return "v1.0.0";
    }

    @Override
    public List<MyTransformer> getTransformers() {
        return transformers;
    }
}
