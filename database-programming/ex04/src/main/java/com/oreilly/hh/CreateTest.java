package com.oreilly.hh;

import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;

import com.oreilly.hh.data.*;

import java.sql.Time;
import java.util.Date;

public class CreateTest {

    public static void main(String args[]) throws Exception {
        
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            // 1. Hibernate 설정 파일(hibernate.cfg.xml)을 로드하여 SessionFactory를 생성합니다.
            //    데이터베이스 연결 풀 등을 관리하는 무거운 객체이므로 애플리케이션에서 한 번만 생성합니다.
            sessionFactory = new Configuration().configure().buildSessionFactory();
            
            // 2. SessionFactory로부터 Session을 엽니다.
            //    Session은 데이터베이스와의 실제 작업을 수행하는 가벼운 작업 단위입니다.
            session = sessionFactory.openSession();
            
            // 3. 트랜잭션을 시작합니다.
            //    데이터베이스의 상태를 변경하는 모든 작업(INSERT, UPDATE, DELETE)은 트랜잭션 안에서 수행되어야 합니다.
            tx = session.beginTransaction();
            
            // 4. 과제 내용에 맞게 두 개의 Employee 객체를 생성합니다.
            System.out.println("Creating Employee objects...");
            Employee emp1 = new Employee("Lim Si Wan");
            Employee emp2 = new Employee("Lee Sung Min");
            
            // 5. 생성된 객체를 데이터베이스에 저장(영속화)하도록 Session에 전달합니다.
            //    이 시점에는 DB에 바로 INSERT 되지 않고, 트랜잭션이 커밋될 때 함께 처리됩니다.
            session.persist(emp1);
            session.persist(emp2);
            
            System.out.println("Employee objects created and persisted.");
            
            // 6. 트랜잭션을 커밋합니다.
            //    지금까지의 모든 변경사항을 데이터베이스에 최종적으로 적용합니다.
            tx.commit();
            System.out.println("Transaction committed.");

        } catch (Exception e) {
            // 7. 작업 중 예외가 발생하면 트랜잭션을 롤백하여 변경사항을 모두 취소합니다.
            if (tx != null) {
                System.err.println("Transaction is being rolled back.");
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // 8. 작업이 성공하든 실패하든, 사용이 끝난 Session을 항상 닫아줍니다.
            if (session != null) {
                session.close();
            }
            // 9. 애플리케이션이 종료될 때 SessionFactory를 닫아 리소스를 해제합니다.
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}