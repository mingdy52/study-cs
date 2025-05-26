package practice.week02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GetAbsentStudent {

    /**
        문제
            Q. 오늘 수업에 많은 학생들이 참여했습니다. 단 한 명의 학생을 제외하고는 모든 학생이 출석했습니다.
            모든 학생의 이름이 담긴 배열과 출석한 학생들의 배열이 주어질 때, 출석하지 않은 학생의 이름을 반환하시오.
     */

    public static void main(String[] args) {
        String[] allStudents1 = new String[]{"나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위"};
        String[] presentStudents1 = new String[]{"정연", "모모", "채영", "쯔위", "사나", "나연", "미나", "다현"};

        String[] allStudents2 = new String[]{"류진","예지","채령","리아","유나"};
        String[] presentStudents2 = new String[]{"리아","류진","채령","유나"};

        String[] allStudents3 = new String[]{"정국","진","뷔","슈가","지민","RM"};
        String[] presentStudents3 = new String[]{"뷔","정국","지민","진","슈가"};

        System.out.println(getAbsentStudent(allStudents1, presentStudents1));
        System.out.println("정답 = 예지 / 현재 풀이 값 = " + getAbsentStudent(allStudents2, presentStudents2));
        System.out.println("정답 = RM / 현재 풀이 값 = " + getAbsentStudent(allStudents3, presentStudents3));

        System.out.println(getAbsentStudentSet(allStudents1, presentStudents1));
        System.out.println("정답 = 예지 / 현재 풀이 값 = " + getAbsentStudentSet(allStudents2, presentStudents2));
        System.out.println("정답 = RM / 현재 풀이 값 = " + getAbsentStudentSet(allStudents3, presentStudents3));
    }

    private static String getAbsentStudent(String[] allStudents, String[] presentStudents) {
        Map<String, Integer> studentMap = new HashMap<>();

        for (String student : allStudents) {
            studentMap.put(student, studentMap.getOrDefault(student, 0) + 1);
        }

        for (String student : presentStudents) {
            studentMap.put(student, studentMap.get(student) - 1);
        }

        for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }

        return null; // 모든 학생이 출석한 경우
    } // O(n)

    private static String getAbsentStudentSet(String[] allStudents, String[] presentStudents) {
        Set<String> studentSet = new HashSet<>();

        for (String student : allStudents) {
            studentSet.add(student);
        }

        for (String student : presentStudents) {
            studentSet .remove(student);
        }

        return studentSet.iterator().next();
    }

}
