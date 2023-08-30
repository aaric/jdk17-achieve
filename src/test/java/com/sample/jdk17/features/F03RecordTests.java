package com.sample.jdk17.features;

import dev.samstevens.totp.code.*;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.qr.ZxingPngQrGenerator;
import dev.samstevens.totp.recovery.RecoveryCodeGenerator;
import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import dev.samstevens.totp.time.NtpTimeProvider;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import dev.samstevens.totp.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;

/**
 * F03RecordTests
 *
 * @author Aaric, created on 2022-06-14T17:00.
 * @version 0.2.0-SNAPSHOT
 */
@Slf4j
public class F03RecordTests {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OriginPojo {
        private Integer id;
        private String name;
    }

    @Test
    public void testOrigin() {
        OriginPojo pojo = new OriginPojo(1, "aaric");
        log.info("{}", pojo);
    }

    public static record NowPojo(Integer id, String name) {
    }

    @Test
    public void testNow() {
        NowPojo pojo = new NowPojo(1, "aaric");
        log.info("{}", pojo);
    }

    @Test
    public void testFiLeHash() throws Exception {
        try (FileInputStream fis = new FileInputStream("D:\\TDDownload\\ReleaseUploadTest.zip")) {
            log.info(DigestUtils.md5Hex(fis));
            log.info(DigestUtils.sha256Hex(fis));
            log.info(DigestUtils.sha256Hex(new FileInputStream("D:\\TDDownload\\ReleaseUploadTest.zip")));
        } catch (Exception e) {
            log.error("testFiLeHash exception", e);
        }
    }

    @Test
    public void testTotpServer() throws Exception {
        // implementation "dev.samstevens.totp:totp"
        // secret
        SecretGenerator secretGenerator = new DefaultSecretGenerator();
        String secret = secretGenerator.generate();
        log.info("secret: {}", secret);
        secret = "E2TQ4GVKWFGAKQRVDHZSZIUQZ4SMU675";

        // secret recovery
        RecoveryCodeGenerator recoveryCodeGenerator = new RecoveryCodeGenerator();
        String[] codes = recoveryCodeGenerator.generateCodes(16);
        log.info("codes:", secret);
        for (String code : codes) {
            log.info("\t{}", code);
        }

        // qr code
        QrData qrData = new QrData.Builder()
                .label("aaric")
                .secret(secret)
                .issuer("InCar")
                .algorithm(HashingAlgorithm.SHA1)
                .digits(6)
                .period(30)
                .build();

        // qr image
        QrGenerator qrGenerator = new ZxingPngQrGenerator();
        byte[] qrBytes = qrGenerator.generate(qrData);
        String qrMimeType = qrGenerator.getImageMimeType();
        String qrDataUri = Utils.getDataUriForImage(qrBytes, qrMimeType);
        log.info("qr uri: {}", qrDataUri);

        // valid
        TimeProvider timeProvider = new SystemTimeProvider();
        //CodeGenerator codeGenerator = new DefaultCodeGenerator(HashingAlgorithm.SHA1, 4);
        CodeGenerator codeGenerator = new DefaultCodeGenerator();
        CodeVerifier codeVerifier = new DefaultCodeVerifier(codeGenerator, timeProvider);
        //log.info("valid: {}", codeVerifier.isValidCode(secret, "123456"));
        log.info("code valid: {}", codeVerifier.isValidCode(secret, "744669"));
    }

    @Test
    public void testTotpClient() throws Exception {
        // implementation "commons-net:commons-net"
        // implementation "dev.samstevens.totp:totp"
        String secret = "E2TQ4GVKWFGAKQRVDHZSZIUQZ4SMU675";
        int timePeriod = 30;
        TimeProvider timeProvider = new NtpTimeProvider("ntp6.aliyun.com", 5000);
        long counter = Math.floorDiv(timeProvider.getTime(), timePeriod);
        log.info("counter: {}", counter);
        CodeGenerator codeGenerator = new DefaultCodeGenerator();
        log.info("code: {}", codeGenerator.generate(secret, counter));
    }
}
