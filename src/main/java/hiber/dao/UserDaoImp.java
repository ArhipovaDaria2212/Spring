package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
//      Car car;
//      if ((car = findCar(user.getCar())) == null) {
//         sessionFactory.getCurrentSession().save(user.getCar());
//      } else {
//         user.setCar(car);
//      }
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   public List<User> findUserByCar(String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where car.model = :model and car.series = :series", User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.getResultList();
   }

   public Car findCar(Car car) {
      TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car where model = :model and series = :series", Car.class);
      query.setParameter("model", car.getModel());
      query.setParameter("series", car.getSeries());
      try {
         return query.getSingleResult();
      } catch (NoResultException e) {
         return null;
      }
   }
}
