package lab4;

import lab4.entity.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
public class BicycleDao {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Создание новой записи
     * @param bicycle экземпляр Bicycle
     */
    public int create(Bicycle bicycle){
        var values = new Object[]{
                bicycle.getManufacturer(), bicycle.getModel(),
                bicycle.getType(), bicycle.getWheelSize(), bicycle.getPrice()
        };
        var query = "insert into bicycle " + "(manufacturer, model, type, wheel_size, price, id) "
                + "values (?,?,?,?,?,default)";
        try{
            return jdbcTemplate.update(query, values);
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }
    /**
     * Чтение всех записей из БД
     * @return List<Bicycle> список записей
     */
    public List<Bicycle> read(){
        var mapper = new BeanPropertyRowMapper<>(Bicycle.class);
        var query = "select * from bicycle" + " order by id";
        return jdbcTemplate.query(query, mapper);
    }

    /**
     *  Обновление записи в базе
     * @param bicycle экземпляр класса Bicycle
     */
    public int update(Bicycle bicycle){
        var values = new Object[]{
                bicycle.getManufacturer(), bicycle.getModel(), bicycle.getType(),
                bicycle.getWheelSize(), bicycle.getPrice(), bicycle.getId()
        };
        var query = "update bicycle " + "set (manufacturer, model, type, wheel_size, price) ="
                + "(?, ?, ?, ?, ?) where id = ?";
        try{
            return jdbcTemplate.update(query, values);
        }
        catch (Exception e){
            System.out.println(e);
            return -1;
        }
    }
    /**
     * Удаление записи с базы
     *  @param id id записи
     */
    public int delete(long id){
        var query = "delete from bicycle where id = ?";
        try{
            return jdbcTemplate.update(query, id);
        }
        catch (Exception e){
            System.out.println(e);
            return -1;
        }
    }

    public List<Bicycle> findByWheelSize(Integer maxWheelSize){
        var mapper = new BeanPropertyRowMapper<>(Bicycle.class);
        var query = "select * from bicycle where wheel_size < " + maxWheelSize;
        return jdbcTemplate.query(query, mapper);
    }
}
