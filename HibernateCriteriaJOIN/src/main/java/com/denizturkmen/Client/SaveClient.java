package com.denizturkmen.Client;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.denizturkmen.Entity.Call;
import com.denizturkmen.Entity.Person;
import com.denizturkmen.Entity.Phone;
import com.denizturkmen.Entity.PhoneType;
import com.denizturkmen.Util.HibernateUtil;

public class SaveClient {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		try {
			session = sf.openSession();
			session.beginTransaction();
			
			Person person1 = new Person();
			person1.setName("Deniz TÜRKMEN");
			person1.setNickName("denizm");
			person1.setAddress("Ankara");
			person1.setCreatedOn(new Date());
			person1.setVersion(1);
			
			Phone phone1 = new Phone();
			phone1.setNumber("90532784515");
			phone1.setType(PhoneType.MOBILE);
			phone1.setPerson(person1);
			
			person1.getPhones().add(phone1);
			
			Call call1 = new Call();
			call1.setDuration(30);
			call1.setPhone(phone1);
			call1.setTimestamp(new Date());
			
			Call call2 = new Call();
			call2.setDuration(20);
			call2.setPhone(phone1);
			call2.setTimestamp(new Date());
			
			phone1.getCalls().add(call1);
			phone1.getCalls().add(call2);
			
			Person person2 = new Person();
			person2.setName("Eren Türkmen");
			person2.setNickName("eren");
			person2.setAddress("Çorum");
			person2.setCreatedOn(new Date());
			person2.setVersion(1);
			
			Phone phone2 = new Phone();
			phone2.setNumber("90532654788");
			phone2.setType(PhoneType.MOBILE);
			phone2.setPerson(person2);
			
			Call call3 = new Call();
			call3.setDuration(60);
			call3.setPhone(phone2);
			call3.setTimestamp(new Date());
			
			Call call4 = new Call();
			call4.setDuration(50);
			call4.setPhone(phone2);
			call4.setTimestamp(new Date());
			
			phone2.getCalls().add(call3);
			phone2.getCalls().add(call4);
			
			Phone phone3 = new Phone();
			phone3.setNumber("0312132865");
			phone3.setType(PhoneType.LAND_LINE);
			phone3.setPerson(person2);
			
			person2.getPhones().add(phone2);
			person2.getPhones().add(phone3);
			
			Call call5 = new Call();
			call5.setDuration(120);
			call5.setPhone(phone3);
			call5.setTimestamp(new Date());
			
			phone3.getCalls().add(call5);
			
			session.save(person1);
			session.save(person2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}

	}
}

