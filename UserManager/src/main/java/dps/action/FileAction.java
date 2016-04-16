package dps.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

public class FileAction extends ActionSupport {

    private String username;
    private File myUpload;
    private String myUploadFileName;
    private String myUploadContentType;
    private String savePath;

    //返回上传文件的保存位置
    public String getSavePath() throws Exception {
        final String str = ServletActionContext.getServletContext()
                .getRealPath(this.savePath);
        return str;
    }

    //接受struts.xml文件配置值的方法
    public void setSavePath(final String value) {
        this.savePath = value;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public File getMyUpload() {
        return this.myUpload;
    }

    public void setMyUpload(final File myUpload) {
        this.myUpload = myUpload;
    }

    public String getMyUploadFileName() {
        return this.myUploadFileName;
    }

    public void setMyUploadFileName(final String myUploadFileName) {
        this.myUploadFileName = myUploadFileName;
    }

    public String getMyUploadContentType() {
        return this.myUploadContentType;
    }

    public void setMyUploadContentType(final String myUploadContentType) {
        this.myUploadContentType = myUploadContentType;
    }

    // 文件上传的action方法
    public String upload() throws Exception {
        String strNewFileName = UUID.randomUUID().toString();
        final String suffix = this.myUploadFileName.substring(
                this.myUploadFileName.lastIndexOf("."));
        strNewFileName += suffix;
        //以服务器的文件保存地址和原文件名建立上传文件输出流
        final FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + strNewFileName);
        this.myUploadFileName = strNewFileName;
        final FileInputStream fis = new FileInputStream(getMyUpload());
        final byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        return SUCCESS;
    }
}
