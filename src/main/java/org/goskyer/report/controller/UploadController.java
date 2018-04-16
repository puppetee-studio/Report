package org.goskyer.report.controller;

import org.goskyer.report.base.ResultBean;
import org.goskyer.report.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping(value = "upload")
public class UploadController {

    @RequestMapping(value = "file")
    @ResponseBody
    public ResultBean uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {

        if (file.isEmpty())
            return new ResultBean(-1, "空文件");

        String savePath = request.getSession().getServletContext().getRealPath("static/upload");
        String realName = file.getOriginalFilename();

        String filePath = FileUtils.save(savePath, realName, file);

        if (filePath == null)
            return new ResultBean(-1, "有相同文件名存在");
        else
            return new ResultBean(filePath);
    }

}
