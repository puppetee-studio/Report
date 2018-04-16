package org.goskyer.report.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static String save(String filePath, String fileName, MultipartFile file) throws IOException {

        File savedFile = new File(filePath, fileName);

        boolean isCreateSuccess = savedFile.createNewFile();

        if (isCreateSuccess) {
            file.transferTo(savedFile);
            return filePath + File.separator + fileName;
        }

        return null;
    }

}
