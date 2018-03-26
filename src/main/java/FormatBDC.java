import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FormatBDC {
    public static List<File> getCurDirFiles(File[] dir) {
        List<File> ret = new ArrayList();
        for (File file : dir) {
            if (file.isDirectory()) {
                ret.addAll(getCurDirFiles(file.listFiles()));
            } else {
                if (file.getAbsolutePath().indexOf(".java") != -1) {
                    System.out.println(file.getAbsolutePath());
                    //在该处处理java文件并存储
                    ret.add(file);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String projectPath = "D:\\workspace\\BDC\\BDC_CODE_NEW";
        File dir = new File(projectPath);
        List<File> javaFiles = new ArrayList();

        if (dir.isDirectory()) {
            javaFiles.addAll(FormatBDC.getCurDirFiles(dir.listFiles()));
        } else {
            javaFiles.add(dir);
        }

        System.out.println(javaFiles.size());
    }
}
