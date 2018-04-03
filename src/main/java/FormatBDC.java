import com.mfx.blog.exception.TipException;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("ALL")
public class FormatBDC {
//    private static final String prefix = "if~(logger.isDebugEnabled())~{";
//    private static final String prefix$ = "if~(logger.isDebugEnabled())~{~";
//    private static final String prefix_ = "if~(logger.isDebugEnabled())~{`";
    private static final String prefix = "if~(logger.isInfoEnabled())~{";
    private static final String prefix$ = "if~(logger.isInfoEnabled())~{~";
    private static final String prefix_ = "if~(logger.isInfoEnabled())~{`";

//    private static final String logger_debug="logger.debug";
    private static final String logger_debug="logger.info";

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
                        result += line + "`";
                    }
                    reader.close();

//                    System.out.println(content.toString());
                    //到此已读取到文件所有内容
                    result = result.replaceAll(" |\t|\r", "~");
                    result = result.replaceAll("[`]{1,}", "`");
                    result = result.replaceAll("[~]{1,}", "~");
                    result = result.replaceAll("~`", "`");
                    result = result.replaceAll("`~", "`");
                    //将logger.debug替换成#2018#
                    result = result.replaceAll(logger_debug, "#2018#");

                    while (result.indexOf("#2018#") != -1) {
                        int startIndex = result.indexOf("#2018#");
                        //如果日志打印前后空格
                        if ("~".equals(FormatBDC.getBeforeChar(result, startIndex))) {
                            String localPrefix = result.substring(startIndex - prefix$.length(), startIndex);
                            if (localPrefix.equals(prefix$)) {
                                //已经写了if判断  还原原来配置
                                result = result.toString().replaceFirst("#2018#", logger_debug);
                            } else {
                                String all = prefix$ + logger_debug;// 需要替换的全部
                                result = result.toString().replaceFirst("#2018#", all);

                                startIndex = result.lastIndexOf(all);

                                int endIndex = result.indexOf(");`", startIndex);// 需要加反大括号的地方
                                int endIndex2 = result.indexOf(");~", startIndex);// 需要加反大括号的地方
                                if (endIndex2 > 0) {
                                    endIndex = endIndex < endIndex2 ? endIndex : endIndex2;
                                }
                                result = result.substring(0, endIndex + 2) + "}" + result.substring(endIndex + 2, result.length());

                            }
                        } else if ("`".equals(FormatBDC.getBeforeChar(result, startIndex))) {
                            String localPrefix = result.substring(startIndex - prefix_.length(), startIndex);
                            if (localPrefix.equals(prefix_)) {
                                //已经写了if判断  还原原来配置
                                result = result.toString().replaceFirst("#2018#", logger_debug);
                            } else {
                                String all = prefix_ + logger_debug;
                                result = result.toString().replaceFirst("#2018#", all);

                                startIndex = result.lastIndexOf(all);
                                int endIndex = result.indexOf(");`", startIndex);// 需要加反大括号的地方
                                int endIndex2 = result.indexOf(");~", startIndex);// 需要加反大括号的地方
                                if (endIndex2 > 0) {
                                    endIndex = endIndex < endIndex2 ? endIndex : endIndex2;
                                }
                                System.out.println(result.substring(startIndex, endIndex + 2));
                                result = result.substring(0, endIndex + 2) + "}" + result.substring(endIndex + 2, result.length());
                            }
                        } else {
                            String localPrefix = result.substring(startIndex - prefix.length(), startIndex);
                            if (localPrefix.equals(prefix)) {
                                //已经写了if判断  还原原来配置
                                result = result.toString().replaceFirst("#2018#", logger_debug);
                            } else {
                                String all = prefix + logger_debug;
                                result = result.toString().replaceFirst("#2018#", all);

                                startIndex = result.lastIndexOf(all);


                                int endIndex = result.indexOf(");`", startIndex);// 需要加反大括号的地方
                                int endIndex2 = result.indexOf(");~", startIndex);// 需要加反大括号的地方
                                if (endIndex2 > 0) {
                                    endIndex = endIndex < endIndex2 ? endIndex : endIndex2;
                                }
                                result = result.substring(0, endIndex + 2) + "}" + result.substring(endIndex + 2, result.length());
                            }
                        }
                    }
                    result = result.replaceAll("~", " ");
//                    System.out.println(result);

                    //去掉最后一个大括号后面的内容
                    result = result.substring(0, result.lastIndexOf("}") + 1);
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
        /*String projectPath = "D:\\workspace\\BDC\\BDC_CODE_NEW";
//        String projectPath = "D:\\workspace\\test";
        File dir = new File(projectPath);

        long start = System.currentTimeMillis();
        FormatBDC.polish(dir.listFiles());
        long end = System.currentTimeMillis();

        System.out.println("鑰楁椂:" + (end - start) + "(ms)");*/


        String regex = "^[1-9]|1[0-2]$";
        String amount = "10";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(amount);
        System.out.println(matcher.matches());


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
