package ge.ibsu.demo.dto;

public record DepartmentDto(
        String departmentName,
        String managerFullName,
        String country,
        String city,
        String streetAddress
) {}