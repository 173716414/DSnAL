package json;

import cn.hutool.core.io.resource.ResourceUtil;

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;

/*
 *Author：Victor_htq
 *Package：json
 *Project：DSnAL
 *name：Test
 *Date：2024/7/9  20:00
 *Filename：Test
 */
public class Test {
    public static void main(String[] args) {
        String s = ResourceUtil.readUtf8Str("F:\\Learning\\DSnAL\\src\\main\\java\\json\\test.json");
        System.out.println(s);
        List<String> list = Arrays.asList("seccomp=" + s);
        System.out.println(list.size());

    }

}
