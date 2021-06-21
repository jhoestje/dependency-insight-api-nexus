package org.johoco.depinsight.nexus.dto;

import lombok.Data;

@Data
public class AssetDTO {
//	"maven2": {
//        "extension": "jar",
//        "groupId": "asm",
//        "artifactId": "asm",
//        "version": "3.3.1"
//    }
    private String downloadUrl;
    private String path;
    private String id;
    private String repository;
    private String format;
    private ChecksumDTO checksum;
    private String contentType;
    private String lastModified;
}
