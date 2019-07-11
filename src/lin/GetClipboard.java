package lin;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class GetClipboard {
    public static String getClipboard(){
        /**
         * 获取粘贴板文本内容
         */
        String content = "";
        Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 获取剪切板中的内容
        Transferable clipTf = sysClip.getContents(null);

        if (clipTf != null) {
            // 检查内容是否是文本类型
            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    content = (String) clipTf.getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                }
            }
        }
        return content;
    }
}
