package com.example.colors.dao;
import com.example.colors.entity.Colors;
import com.example.colors.entity.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

//No need to use @Repository because we are using custom queries
public interface TestRepository extends CrudRepository<Orders, Long> {
    @Query(value = "select * from mydb.orders where cast(order_date as date) = ? and color_id = ?",nativeQuery = true)
    List<Orders> SearchOrderByDate(String date, String colorId);
}
