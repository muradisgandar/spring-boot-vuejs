package com.murad.spvue.filestore.service.s3;

import com.murad.spvue.filestore.config.S3ConfigProperties;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class MinioFileService implements FileService {

    private final MinioClient minioClient;
    private final S3ConfigProperties properties;

    @Override
    public void save(String id, String contentType, InputStream isFile) {
        try {
            var object = PutObjectArgs.builder()
                    .object(id)
                    .contentType(contentType)
                    .stream(isFile,isFile.available(),-1)
                    .bucket(properties.getBucket())
                    .build();
            minioClient.putObject(object);
        } catch (Exception e){
            log.error("File put error: ",e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(id)
                    .build());
        } catch (Exception ex){
            log.error("File delete error: ", ex);
        }
    }

    @Override
    public byte[] get(String id) {
        try {
            return minioClient.getObject(GetObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(id)
                    .build()).readAllBytes();
        } catch (Exception ex){
            log.error("File getting error: " + ex);
        }

        return new byte[0];
    }
}
