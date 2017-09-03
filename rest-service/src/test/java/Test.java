import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(ConfigTools.encrypt("123456"));
        System.out.println(ConfigTools.decrypt("Biyu5YzU+6sxDRbmWEa3B2uUcImzDo0BuXjTlL505+/pTb+/0Oqd3ou1R6J8+9Fy3CYrM18nBDqf6wAaPgUGOg=="));
    }
}
