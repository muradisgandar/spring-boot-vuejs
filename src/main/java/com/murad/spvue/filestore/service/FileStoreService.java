package com.murad.spvue.filestore.service;

import com.murad.spvue.filestore.service.s3.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileStoreService {

    private final FileService fileService;

    public Mono<byte[]> getImage(String id){
//        File file = ResourceUtils.getFile("classpath:about-1.jpg");
//        return Mono.just(Files.readAllBytes(file.toPath()));
        return Mono.just(fileService.get(id));
    }

    public void saveImage(String id, InputStream isFile){
        fileService.save(id, MediaType.IMAGE_JPEG_VALUE, isFile);
    }

    public void deleteImage(String id){
        fileService.delete(id);
    }
}
