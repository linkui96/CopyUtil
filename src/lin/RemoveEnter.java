package lin;

/**
 * @author 林奎
 * 2019.6.25
 *
 * 获取粘贴板内容，去除所有回车键
 *
 */
public class RemoveEnter {

    public static String removeEnter(String content){
        /**
         * 去除文本内容
         */
        content = content.replace('\n',' ');
        return content;
    }

}
