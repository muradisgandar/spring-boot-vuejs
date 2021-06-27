package com.murad.spvue.filestore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Mono;

import java.io.File;
import java.nio.file.Files;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileStoreService {

    public Mono<byte[]> getImage(String id) throws Exception{
        File file = ResourceUtils.getFile("classpath:about-1.jpg");
        return Mono.just(Files.readAllBytes(file.toPath()));
    }
}
