package com.example.common.Executor;

import javax.swing.plaf.SpinnerUI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
刘佩佩
2021/8/30
*/
public class MainTest {

   private static ExecutorService  executorService= Executors.newFixedThreadPool(3);


  public  static Student  setStudent(SmallStudent  student){

      Student ss=new Student();
      List<Future<String>> futures=new ArrayList<>();
      for ( int i =0;i<3;i++)
      {
          if (i ==2) {
            //  FutureTask<String> futureFutureTask = new FutureTask<>(new ExeSetStudent(i, ss, student.getName(),0));
              FutureTask<String> futureFutureTask = (FutureTask<String>) executorService.submit(()->{

              });
              futures.add(futureFutureTask);
          }
          if (i ==1) {
              FutureTask<String> futureFutureTask = new FutureTask<>(new ExeSetStudent(i, ss, "", student.getId()));
              executorService.submit(futureFutureTask);
              futures.add(futureFutureTask);
          }

      }
      for (Future future: futures)
      {
          try {
              future.get();
          }catch (Exception e)
          {
              System.out.println(e.getStackTrace());
          }

      }
      executorService.shutdown();
   //   executorService.submit(student);
      System.out.printf("ss+"+ss);
      return ss;
  }

    public static void main(String[] args) {
        SmallStudent student=new SmallStudent();


        student.setId(2000);
        student.setName("111");
        student.setCourseList(null);

        setStudent(student);
    }



}
