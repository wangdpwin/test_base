package cn.wangdpwin.test.base.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangdongpeng
 * @Date 2022/4/1 11:00 上午
 * @Version 1.0
 */
public class GroupTest {

    public static void group(){
        //TODO 编写一条sql查询出所有的学生成绩记录
        String selectSql = "";
        //此处省略dao层查询数据库的操作，假设数据结果为 List<StudentScore>
        List<StudentScore> studentScoreList = new ArrayList<>(100);
        //TODO 将 studentScoreList 按学生姓名进行分组，输出每个学生的所有成绩记录


    }

    public static void main(String[] args) {
        GroupTest.group();
        GroupTest.test();
    }

    private static void test() {
        /*
    [
         {"studentName":"甲","studentScoreList": [
                                                  {"subject":"语文"},{"score":"100"},
                                                  {"subject":"数学"},{"score":"100"}
                                                 ]



         },
         {"studentName":"乙","studentScoreList": [
                                                  {"subject":"英语"},{"score":"80"},
                                                  {"subject":"化学"},{"score":"80"}
                                                 ]
         }
    ]
         */
    }
}

class StudentScore {

    /**
     * 学生id，eg: 1、2、3
     */
    private int studentId;

    /**
     * 学生姓名, eg: 张三、李四、王五
     */
    private String studentName;

    /**
     * 科目，eg: 语文、数学、英语等
     */
    private int subject;

    /**
     * 成绩，eg: 0<= value <=100
     */
    private int score;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}


/*
-- 学生表
create table student(
  sno varchar(20) not null,
  sname varchar(20) not null,
  ssex varchar(20) not null default'男',
  sbirthday datetime,
  sclass varchar(20)
);

-- 课程表
create table course(
     cno varchar(20) not null,
     cname varchar(20) not null,
     tno varchar(20) not null
)

-- 成绩表
create table score(
    sno varchar(20) not null,
    cno varchar(20) not null,
    degree decimal(4,1) not null
);

 */