package com.techacademy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{ymd}")
    public String dispDayOfWeek(@PathVariable String ymd) {
        // 曜日
        String[] weekDays = {"","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // 年月日を取得する
        int y = Integer.parseInt(ymd.substring(0,4));
        int m = Integer.parseInt(ymd.substring(4,6)) - 1;
        int d = Integer.parseInt(ymd.substring(6,8));

        // 取得した日付をCalendarにセット
        Calendar cal = Calendar.getInstance();
        cal.set(y, m, d);

        // 曜日取得
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        // 曜日を英語で出力
        return weekDays[dayOfWeek];
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果：" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果：" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果：" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果：" + res;
    }

}
