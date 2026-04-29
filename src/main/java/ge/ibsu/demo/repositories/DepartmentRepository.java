package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.DepartmentDto;
import ge.ibsu.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Обрати внимание на путь к DTO классу в SELECT new ...
    // Замени ge.ibsu.demo.dto.DepartmentDto на свой пакет, если он отличается!
    @Query("""
        SELECT new ge.ibsu.demo.dto.DepartmentDto(
            d.departmentName,
            CONCAT(m.firstName, ' ', m.lastName),
            c.countryName,
            l.city,
            l.streetAddress
        )
        FROM Department d
        LEFT JOIN d.manager m
        LEFT JOIN d.location l
        LEFT JOIN l.country c
        WHERE (:country IS NULL OR c.countryName = :country)
          AND (:city IS NULL OR l.city = :city)
    """)
    List<DepartmentDto> findDepartmentsWithFilters(
            @Param("country") String country,
            @Param("city") String city
    );
}