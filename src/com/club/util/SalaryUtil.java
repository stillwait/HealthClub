package com.club.util;

import com.club.Po.CoachSalary;
import com.club.Po.UserSalary;

import java.util.*;

/**
 * Created by Administrator on 2019-05-06.
 */
public class SalaryUtil {

    public static Map<String, Map<String, Float>> caculateSalary(List<UserSalary> userSalaryList, List<CoachSalary> coachSalaryList){
        Map<String, Map<String, Float>> result = new HashMap<>();
        String[] allMon = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        Map<String, Float> userSalaryResult = new TreeMap<>(new Comparator<String>(){
            public int compare(String o1,String o2){
                return  Integer.parseInt(o1) > Integer.parseInt(o2) ? 1 : Integer.parseInt(o1) == Integer.parseInt(o2) ? 0:-1; //用正负表示大小值
            }
        });
        Map<String, Float> coachSalaryResult = new TreeMap<>(new Comparator<String>(){
            public int compare(String o1,String o2){
                return Integer.parseInt(o1) > Integer.parseInt(o2) ? 1 : Integer.parseInt(o1) == Integer.parseInt(o2) ? 0:-1; //用正负表示大小值
            }
        });
        for(String mon:allMon) {
            userSalaryResult.put(mon, 0f);
            coachSalaryResult.put(mon, 0f);
        }
        for(UserSalary userSalary: userSalaryList){
            String mon = userSalary.getMonth();
            userSalaryResult.put(mon, userSalaryResult.get(mon) + userSalary.getYfSalary());
        }
        for(CoachSalary coachSalary: coachSalaryList){
            String mon = coachSalary.getMonth();
            coachSalaryResult.put(mon, coachSalaryResult.get(mon) + coachSalary.getYfSalary());
        }
        result.put("user",userSalaryResult);
        result.put("coach",coachSalaryResult);
        return result;
    }

}
