package com.mashibing.algorithmbasic2020;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

/**
 * @author linshijin
 * @date 2022/4/19 14:50
 */
public class DoubleColorBall {

    public static void main(String[] args) throws Exception {
        File file = new File("E:\\linshijin\\DoubleColorBall\\" + "DoubleColorBall-" + LocalDate.now()
                + "-" + System.currentTimeMillis() + ".txt");
        try (OutputStream outputStream = new FileOutputStream(file)) {
            for (int i = 0; i < 5; i++) {
                Set<Integer> set = new HashSet<>();
                while (set.size() < 6) {
                    set.add((int) (Math.random() * 33) + 1);
                }
                int blueBall = (int) (Math.random() * 16) + 1;
                StringBuilder stringBuilder = new StringBuilder();
                List<Integer> redBalls = new ArrayList<>(set);
                redBalls.sort(Comparator.comparingInt(o -> o));
                for (int redBall : redBalls) {
                    if (redBall < 10) {
                        stringBuilder.append(0);
                    }
                    stringBuilder.append(redBall).append("  ");
                }
                if (blueBall < 10) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(blueBall);
                System.out.println(stringBuilder);
                outputStream.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
                outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
            }
            outputStream.flush();
        }
    }
}
