package com.sample.jaudiotagger;

import lombok.extern.slf4j.Slf4j;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * JAudioTaggerTests
 *
 * @author Aaric
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
public class JAudioTaggerTests {

    @Disabled
    @Test
    public void testRr() throws Exception {
        // 输出指定目录文件列表
        String path = "F:\\如何阅读一本书\\";
        File[] files = new File(path).listFiles();
        if (null != files && 0 < files.length) {
            Arrays.stream(files).forEach(file -> {
                // 输出到控制台
                String newFileName = file.getName().replace("《如何阅读一本书》", "");
                System.err.println(newFileName.replace(" ", ""));
                file.renameTo(new File(path + newFileName));
            });
        }
    }

    @Disabled
    @Test
    public void testRt() throws Exception {
        setAudioTaggerLogLevel(Level.OFF);

        // 输出指定目录文件列表
        String path = "F:\\如何阅读一本书\\";
        File[] files = new File(path).listFiles();
        if (null != files && 0 < files.length) {
            Arrays.stream(files).forEach(file -> {
                // 如果不是mp3就跳过
                if (!file.getName().toLowerCase().endsWith(".mp3")) {
                    return;
                }

                // 修改文件属性
                System.err.println("##" + file.getName());
                try {
                    updateAudioTagInfo(path + file.getName(),
                            file.getName(),
                            "",
                            "如何阅读一本书");
                } catch (Exception e) {
                    log.error("testRtGroup exception", e);
                }
            });
        }
    }

    private static void setAudioTaggerLogLevel(Level level) {
        AudioFileIO.logger.setLevel(level);
        org.jaudiotagger.tag.id3.ID3v23Tag.logger.setLevel(level);
        org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody.logger.setLevel(level);
        org.jaudiotagger.tag.id3.AbstractID3v2Tag.logger.setLevel(level);
        org.jaudiotagger.tag.datatype.TextEncodedStringSizeTerminated.logger.setLevel(level);
        org.jaudiotagger.tag.datatype.NumberFixedLength.logger.setLevel(level);
        org.jaudiotagger.audio.mp3.MP3File.logger.setLevel(level);
        org.jaudiotagger.audio.AudioFile.logger.setLevel(level);
        org.jaudiotagger.tag.vorbiscomment.VorbisCommentReader.logger.setLevel(level);
    }

    private static void showAudioTagInfo(Tag audioTag) {
        System.err.println("Title:   " + audioTag.getFirst(FieldKey.TITLE));
        System.err.println("Artist:  " + audioTag.getFirst(FieldKey.ARTIST));
        System.err.println("Album:   " + audioTag.getFirst(FieldKey.ALBUM));
        System.err.println("Year:    " + audioTag.getFirst(FieldKey.YEAR));
        System.err.println("COMMENT: " + audioTag.getFirst(FieldKey.YEAR));
    }

    private static void updateAudioTagInfo(String filePath, String title, String artist, String album) throws Exception {
        AudioFile audioFile = AudioFileIO.read(new File(filePath));
        Tag audioTag = audioFile.getTagOrCreateAndSetDefault();

        showAudioTagInfo(audioTag);

        audioTag.setField(FieldKey.TITLE, title);
        audioTag.setField(FieldKey.ARTIST, artist);
        audioTag.setField(FieldKey.ALBUM, album);
        audioFile.commit();
    }

    @Disabled
    @Test
    public void testUpdateAudioTagInfo() throws Exception {
        setAudioTaggerLogLevel(Level.OFF);

        String filePath = "F:\\001【战国】立*木*取信：商*鞅*变*法.mp3";
        updateAudioTagInfo(filePath,
                "001【战国】立*木*取信：商*鞅*变*法",
                "凯*叔*讲*故*事",
                "每*日*历*史*典*故");
    }
}
