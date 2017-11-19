package com.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by zhangyu on 2017/10/30.
 * 单文件上传
 */
public class TestFileAction extends ActionSupport{


    private File upload;

    private String uploadContentType;

    private String uploadFileName;

    private String savePath;


    @Override
    public String execute() throws Exception {
        byte[] buffer = new byte[1024];
        //输入 流
        FileInputStream fis = new FileInputStream(getUpload());
        //输出 流
        FileOutputStream fos = new FileOutputStream(getSavePath()+"\\"+getUploadFileName());

        int length = fis.read(buffer);
        while (length>0){
            fos.write(buffer,0,length);
            length = fis.read(buffer);
        }
        fos.flush();
        fos.close();
        fis.close();
        return SUCCESS;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
