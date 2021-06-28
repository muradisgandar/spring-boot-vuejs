package com.murad.spvue.filestore.startup;

import com.murad.spvue.filestore.config.S3ConfigProperties;
import com.murad.spvue.filestore.service.FileStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileStoreStartup {

    private final S3ConfigProperties s3ConfigProperties;
    private final FileStoreService fileStoreService;


    @EventListener(ApplicationReadyEvent.class)
    public void init(){

    }
}
