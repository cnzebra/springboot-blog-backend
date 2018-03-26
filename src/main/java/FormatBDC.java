import com.mfx.blog.exception.TipException;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

@SuppressWarnings("ALL")
public class FormatBDC {
    private static final String prefix = "if~(logger.isDebugEnabled())~{";
    private static final String prefix$ = "if~(logger.isDebugEnabled())~{~";
    private static final String prefix_ = "if~(logger.isDebugEnabled())~{`";

    public static void polish(File[] dir) throws IOException {
        for (File file : dir) {
            if (file.isDirectory()) {
                polish(file.listFiles());
            } else {
                if (file.getAbsolutePath().indexOf(".java") != -1) {
                    //在该处处理java文件并存储
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
                    String line;
                    String result = "";
                    while ((line = reader.readLine()) != null) {
                        result += line + "\n";
                    }
//                    System.out.println(content.toString());
                    //到此已读取到文件所有内容
                    result = result.replaceAll(" |\t|\r", "~");
                    result = result.replaceAll("[\n]{1,}", "`");
                    result = result.replaceAll("[~]{1,}", "~");
                    result = result.replaceAll("~`", "`");
                    result = result.replaceAll("`~", "`");
                    //将logger.debug替换成#2018#
                    result = result.replaceAll("logger.debug", "#2018#");

                    System.out.println(result);
                    while (result.indexOf("#2018#") != -1) {
                        int startIndex = result.indexOf("#2018#");
                        //如果日志打印前后空格
                        if ("~".equals(FormatBDC.getBeforeChar(result, startIndex))) {
                            String localPrefix = result.substring(startIndex - prefix$.length(), startIndex);
                            if (localPrefix.equals(prefix$)) {
                                //已经写了if判断  还原原来配置
                                result = result.toString().replaceFirst("#2018#", "logger.debug");
                            } else {
                                String all = prefix$ + "logger.debug";
                                int endIndex = result.indexOf(");`", startIndex);
                                result = result.substring(0, endIndex + 2) + "}" + result.substring(endIndex + 2, result.length());
                                result = result.toString().replaceFirst("#2018#", all);
                            }
                        } else if ("`".equals(FormatBDC.getBeforeChar(result, startIndex))) {
                            String localPrefix = result.substring(startIndex - prefix_.length(), startIndex);
                            if (localPrefix.equals(prefix_)) {
                                //已经写了if判断  还原原来配置
                                result = result.toString().replaceFirst("#2018#", "logger.debug");
                            } else {
                                String all = prefix_ + "logger.debug";
                                int endIndex = result.indexOf(");`", startIndex);
                                result = result.substring(0, endIndex + 2) + "}" + result.substring(endIndex + 2, result.length());
                                result = result.toString().replaceFirst("#2018#", all);
                            }
                        } else {
                            String localPrefix = result.substring(startIndex - prefix.length(), startIndex);
                            if (localPrefix.equals(prefix)) {
                                //已经写了if判断  还原原来配置
                                result = result.toString().replaceFirst("#2018#", "logger.debug");
                            } else {
                                String all = prefix + "logger.debug";
                                int endIndex = result.indexOf(");`", startIndex);
                                result = result.substring(0, endIndex + 2) + "}" + result.substring(endIndex + 2, result.length());
                                result = result.toString().replaceFirst("#2018#", all);
                            }
                        }
                    }
                    result = result.replaceAll("~", " ");
                    System.out.println(result.split("`").length);
                    PrintWriter writer = new PrintWriter(file, "GBK");

                    for (String s : result.split("`")) {
                        writer.println(s.replace("`", ""));
                    }
                    writer.close();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        String projectPath = "D:\\workspace\\BDC_CODE";
        String projectPath = "D:\\test";
        File dir = new File(projectPath);

        FormatBDC.polish(dir.listFiles());


    }


    private static String getBeforeChar(String s, int index) {
        if (StringUtils.isBlank(s)) {
            throw new TipException("异常");
        }

        if (s.length() < index + 1) {
            throw new TipException("字符串长度不够");
        }

        return s.substring(index - 1, index);
    }
}
