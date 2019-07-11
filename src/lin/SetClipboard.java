package lin;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class SetClipboard {
    public static boolean setClipboard(String content){
        /**
         * 输出粘贴板文本内容
         */
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(content);
        clip.setContents(tText, null);
        return true;
    }
}
