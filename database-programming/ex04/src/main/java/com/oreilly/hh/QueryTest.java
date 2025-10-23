package com.oreilly.hh;

import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;

import com.oreilly.hh.data.*;

import java.sql.Time;
import java.util.*;

/**
 * Retrieve data as objects
 */
public class QueryTest {

    /**
public class QueryTest {

    /**
     * Look up and print some tracks when invoked from the command line.
     */
    public static void main(String args[]) throws Exception {

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            // 1. SessionFactory 생성
            sessionFactory = new Configuration().configure().buildSessionFactory();

            // 2. Session 열기
            session = sessionFactory.openSession();

            // 3. 트랜잭션 시작 (읽기 작업에도 권장됨)
            tx = session.beginTransaction();

            System.out.println("Querying Employee data...");

            // 4-A. [방법 1] ID(PK)로 1건 조회하기 (get)
            //    ctest에서 ID '1L' (Long 타입)로 데이터가 생성되었을 것이라 가정
            System.out.println("--- [방법 1] session.get() ---");
            Employee emp1 = session.get(Employee.class, 1L);
            if (emp1 != null) {
                System.out.println("ID 1L: " + emp1.getName());
            } else {
                System.out.println("ID 1L: Data not found.");
            }


            // 4-B. [방법 2] HQL로 여러 건 조회하기 (createQuery)
            //    "FROM Employee"는 SQL의 "SELECT * FROM EMPLOYEE"와 유사합니다.
            System.out.println("\n--- [방법 2] session.createQuery() ---");
            String hql = "FROM Employee"; // HQL: 테이블명이 아닌 '엔티티 클래스명'을 사용
            Query<Employee> query = session.createQuery(hql, Employee.class);
            List<Employee> allEmployees = query.getResultList();

            for (Employee emp : allEmployees) {
                System.out.println("ID " + emp.getId() + ": " + emp.getName());
            }

            // 5. 트랜잭션 커밋
            tx.commit();

        } catch (Exception e) {
            // 6. 오류 발생 시 롤백
            if (tx != null) {
                System.err.println("Transaction is being rolled back.");
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // 7. Session 닫기
            if (session != null) {
                session.close();
            }
            // 8. SessionFactory 닫기
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}