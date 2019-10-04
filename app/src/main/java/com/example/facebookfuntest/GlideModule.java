package com.example.facebookfuntest;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;

@com.bumptech.glide.annotation.GlideModule
public class GlideModule extends AppGlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        super.applyOptions(context, builder);

        //내부 또는 외부 디스크 캐시의 디스크 크기를 수정 가능
        int diskCacheSizeBytes = 1024 * 1024 * 200; // 200 MB
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context,diskCacheSizeBytes));

    }
}
